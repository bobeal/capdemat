
/**
 * @description This file contains PUT YOUR DESCRIPTION
 * 
 * @author rdj@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcv = zenexity.capdemat.Validation;
  var zcbrt = zenexity.capdemat.bong.requesttype;
  var zca = zenexity.capdemat.aspect; 
    
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  zcbrt.accessRule = {
    notCurrent: function(e) {
      return !yud.hasClass(yud.get(yue.getTarget(e)), 'current');
    }
  };
  
  zcbrt.LocalReferential = function() {
    
    var toggleEntries = function(dataName, displayPolicy) {
      zct.each(yus.query('ul', yud.get('lrtEntries_' + dataName)), function(){
        zct.style(this, {display:displayPolicy});
      });
      zct.toggleClass(yud.get('expandEntries_' + dataName), 'current');
      zct.toggleClass(yud.get('collapseEntries_' + dataName), 'current');
    }
    
    return {
      clickEvent: undefined,
      changeEvent: undefined,
      
      init: function() {
        zcbrt.LocalReferential.initLocalreferential();
        if (zcbrt.LocalReferential.clickEvent != undefined) return;
        
        zcbrt.LocalReferential.confirmRemoveEntryDialog = new zct.ConfirmationDialog(
          { head : 'Attention',
            body : 'Voulez-vous supprimer cette entrée et tous ces descendants ?' },
          zcbrt.LocalReferential.removeEntry);
        
        // click event
        zcbrt.LocalReferential.clickEvent = new zct.Event(zcbrt.LocalReferential, zcbrt.LocalReferential.prepareEvent);
        yue.on(yud.get('requestTypeLocalReferential'),'click',zcbrt.LocalReferential.clickEvent.dispatch,zcbrt.LocalReferential.clickEvent,true);
        // change event
        zcbrt.LocalReferential.changeEvent = new zct.Event(zcbrt.LocalReferential, zcbrt.LocalReferential.prepareEvent);
        yue.on(yud.get('requestTypeLocalReferential'),'change',zcbrt.LocalReferential.changeEvent.dispatch,zcbrt.LocalReferential.changeEvent,true);
        
        zcbrt.LocalReferential.collapseEntries = zca.condition(zcbrt.LocalReferential.collapseEntries, zcbrt.accessRule.notCurrent);
        zcbrt.LocalReferential.expandEntries = zca.condition(zcbrt.LocalReferential.expandEntries, zcbrt.accessRule.notCurrent);
      },
      
      prepareEvent : function(e) {
        var target = yue.getTarget(e);
        return target.id.split('_')[0];
      },
      
      initLocalreferential : function() {
        zct.doAjaxCall("/localReferentialList/" + (zcbrt.currentId||0), [], function(o){
          zct.html(yud.get('requestTypeLocalReferential'),o.responseText);
        });
      },
      
      editEntry : function(e) {
        var target = (yue.getTarget(e)||e);
        var entryKey = target.id.split('_')[1];
        var parentEntryKey = yud.getAncestorByTagName(target, 'ul').id.split('_')[1];
        var dataName = yud.getAncestorByClassName(target, 'editableTree').id.split('_')[1];
        zct.doAjaxCall(['/localReferentialEntry/' + (zcbrt.currentId || 0),'?dataName=',dataName,'&entryKey=',entryKey,
                        '&parentEntryKey=',parentEntryKey].join(''),[],function(o){
          var entryFormContainerEl = yud.get('formContainer_' + entryKey);
          zct.style(entryFormContainerEl, {display:'block'});
          zct.html(entryFormContainerEl,o.responseText);
        });
      },
      
      saveWidget : function(se) {
        if (se.type === 'click') return;
        var target = (yue.getTarget(se)||se);
        zct.doAjaxFormSubmitCall(target.form.id, null, function(o) {
          var response = ylj.parse(o.responseText);
          if (response.status === 'success') {
            zcbrt.LocalReferential.initLocalreferential();
          }
        });
      },
      
      saveEntry : function(e) {
        var target = (yue.getTarget(e)||e);
        var entryFormEl = yud.getAncestorByTagName(target, 'form');
        if (!zcv.check(e, yud.get(entryFormEl.id + "_Errors")))
          return;
        zct.doAjaxFormSubmitCall(entryFormEl.id, null, function(o) {
          var response = ylj.parse(o.responseText);
          if (!response.isNew) {
            zct.html(yud.getFirstChild(yud.getAncestorByTagName(target, 'li')), response.entryLabel);
            zct.style(yud.getAncestorByTagName(entryFormEl, 'div'), {display:'none'});
          } else {
            zcbrt.LocalReferential.refreshEntries(entryFormEl.dataName.value);
            zct.style(yud.getAncestorByTagName(entryFormEl, 'div'), {display:'none'});
          }
        });
      },
      
      addEntry : function(e) {
        var target = (yue.getTarget(e)||e);
        var dataName = target.id.split('_')[1];
        zct.doAjaxCall(['/localReferentialEntry/' + (zcbrt.currentId || 0),'?dataName=',dataName,
                        '&parentEntryKey=',dataName,'&isNew'].join(''),[],function(o){
          var entryFormContainerEl = yud.get('formContainer_' + dataName);
          zct.style(entryFormContainerEl, {display:'block'});
          zct.html(entryFormContainerEl,o.responseText);
        });
      },
      
      addSubEntry : function(e) {
        var target = (yue.getTarget(e)||e);
        var parentEntryKey = target.id.split('_')[1];
        var dataName = yud.getAncestorByClassName(target, 'editableTree').id.split('_')[1];
        zct.doAjaxCall(['/localReferentialEntry/' + (zcbrt.currentId || 0),'?dataName=',dataName,
                        '&parentEntryKey=',parentEntryKey, '&isNew'].join(''),[],function(o){
          var entryFormContainerEl = yud.get('formContainer_' + parentEntryKey);
          zct.style(entryFormContainerEl, {display:'block'});
          zct.html(entryFormContainerEl,o.responseText);
        });
      },
      
      confirmRemoveEntry : function(e) { zcbrt.LocalReferential.confirmRemoveEntryDialog.show(e); },
      removeEntry : function(e, se) {
        var target = (yue.getTarget(se)||se);
        var entryKey = target.id.split('_')[1];
        var parentEntryKey = yud.getAncestorByTagName(target, 'ul').id.split('_')[1];
        var dataName = yud.getAncestorByClassName(target, 'editableTree').id.split('_')[1];
        zct.doAjaxCall(['/removeLocalReferentialEntry/' + (zcbrt.currentId || 0),'?dataName=',dataName,'&entryKey=',entryKey,
                        '&parentEntryKey=',parentEntryKey].join(''),[],function(o){
          var response = ylj.parse(o.responseText);
          if (response.status === 'success')
            zcbrt.LocalReferential.refreshEntries(dataName);
        });
      },
      
      refreshEntries : function(dataName) {
        zct.doAjaxCall(['/localReferentialType/' + (zcbrt.currentId || 0),'?dataName=',dataName].join(''),[],function(o){
          zct.html(yud.get('lrtEntriesContainer_' + dataName),o.responseText);
        });
        if (yud.hasClass(yud.get('collapseEntries_' + dataName), 'current'))
            toggleEntries(dataName,'none');
      },
      
      discardEntry : function(e) {
        var target = (yue.getTarget(e)||e);
        var entryId = target.id.split('_')[1];
        var entryFormContainerEl = yud.get('formContainer_' + entryId);
        zct.style(entryFormContainerEl, {display:'none'});
      },
      
      collapseEntries : function(e) {
        var target = (yue.getTarget(e)||e); 
        toggleEntries(target.id.split('_')[1],'none'); 
      },
      
      expandEntries : function(e) { 
        var target = (yue.getTarget(e)||e); 
        toggleEntries(target.id.split('_')[1], 'block'); 
      }
    }
  }();
  YAHOO.util.Event.onDOMReady(zcbrt.LocalReferential.init);
}());

