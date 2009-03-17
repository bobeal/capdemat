
/**
 * @description This file contains PUT YOUR DESCRIPTION
 * 
 * @author rdj@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbrp = zenexity.capdemat.bong.requesttype;
  var zca = zenexity.capdemat.aspect; 
    
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  zcbrp.accessRule = {
    notCurrent: function(e) {
      return !yud.hasClass(yud.get(yue.getTarget(e)), 'current');
    }
  };
  
  zcbrp.LocalReferential = function() {
    
    var toggleEntries = function(dataName, displayPolicy) {
      zct.each(yus.query('ul', yud.get('lrtEntries_' + dataName)), function(){
        zct.style(this, {display:displayPolicy});
      });
      zct.toggleClass(yud.get('expandEntries_' + dataName), 'current');
      zct.toggleClass(yud.get('collapseEntries_' + dataName), 'current');
    }
      
    return {
      event: undefined,
      
      init: function() {
        zcbrp.LocalReferential.event = new zct.Event(zcbrp.LocalReferential, zcbrp.LocalReferential.prepareEvent);
        yue.on(yud.get('requestTypeLocalReferential'),'click',zcbrp.LocalReferential.event.dispatch,zcbrp.LocalReferential.event,true);
        zct.doAjaxCall(['/localReferential/',(zcbrp.currentId||0)].join(''),[],function(o){
          zct.html(yud.get('requestTypeLocalReferential'),o.responseText);
        });
        
        zcbrp.LocalReferential.collapseEntries = zca.condition(zcbrp.LocalReferential.collapseEntries, zcbrp.accessRule.notCurrent);
        zcbrp.LocalReferential.expandEntries = zca.condition(zcbrp.LocalReferential.expandEntries, zcbrp.accessRule.notCurrent);
      },
      
      prepareEvent : function(e) {
        var target = yue.getTarget(e);
        return target.id.split('_')[0];
      },
      
      editEntry : function(e) {
        var target = (yue.getTarget(e)||e);
        var entryKey = target.id.split('_')[1];
        var parentEntryKey = yud.getAncestorByTagName(target, 'ul').id.split('_')[1];
        var dataName = yud.getAncestorByClassName(target, 'editableTree').id.split('_')[1];
        zct.doAjaxCall(['/localReferentialEntry/','?dataName=',dataName,'&entryKey=',entryKey,
                        '&parentEntryKey=',parentEntryKey].join(''),[],function(o){
          var entryFormContainerEl = yud.get('formContainer_' + entryKey);
          zct.style(entryFormContainerEl, {display:'block'});
          zct.html(entryFormContainerEl,o.responseText);
        });
      },
      
      saveEntry : function(e) {
        var target = (yue.getTarget(e)||e);
        var entryFormEl = yud.getAncestorByTagName(target, 'form');
        zct.doAjaxFormSubmitCall(entryFormEl.id, null, function(o) {
          var response = ylj.parse(o.responseText);
          if (!response.isNew) {
            zct.html(yud.getFirstChild(yud.getAncestorByTagName(target, 'li')), response.entryLabel);
            zct.style(yud.getAncestorByTagName(entryFormEl, 'div'), {display:'none'});
          } else {
            zcbrp.LocalReferential.refreshEntries(e);
            zct.style(yud.getAncestorByTagName(entryFormEl, 'div'), {display:'none'});
          }
        });
      },
      
      addEntry : function(e) {
        var target = (yue.getTarget(e)||e);
        var dataName = target.id.split('_')[1];
        zct.doAjaxCall(['/localReferentialEntry/','?dataName=',dataName,
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
        zct.doAjaxCall(['/localReferentialEntry/','?dataName=',dataName,
                        '&parentEntryKey=',parentEntryKey, '&isNew'].join(''),[],function(o){
          var entryFormContainerEl = yud.get('formContainer_' + parentEntryKey);
          zct.style(entryFormContainerEl, {display:'block'});
          zct.html(entryFormContainerEl,o.responseText);
        });
      },
      
      removeEntry : function(e) {
        var target = (yue.getTarget(e)||e);
        var entryKey = target.id.split('_')[1];
        var parentEntryKey = yud.getAncestorByTagName(target, 'ul').id.split('_')[1];
        var dataName = yud.getAncestorByClassName(target, 'editableTree').id.split('_')[1];
        zct.doAjaxCall(['/removeLocalReferentialEntry/','?dataName=',dataName,'&entryKey=',entryKey,
                        '&parentEntryKey=',parentEntryKey].join(''),[],function(o){
          var response = ylj.parse(o.responseText);
          if (response.status === 'ok')
            zcbrp.LocalReferential.refreshEntries(e);
        });
      },
      
      refreshEntries : function(e) {
        var target = (yue.getTarget(e)||e);
        var dataName = yud.getAncestorByClassName(target, 'mainbox').id.split('_')[1];
        zct.doAjaxCall(['/localReferentialData/','?dataName=',dataName].join(''),[],function(o){
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
  
}());

