
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
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  
  zcbrp.LocalReferential = function() {
    return {
      event: undefined,
      
      init: function() {
        zcbrp.LocalReferential.event = new zct.Event(zcbrp.LocalReferential, zcbrp.LocalReferential.prepareEvent);
        yue.on(yud.get('requestTypeLocalReferential'),'click',zcbrp.LocalReferential.event.dispatch,zcbrp.LocalReferential.event,true);
        zct.doAjaxCall(['/localReferential/',(zcbrp.currentId||0)].join(''),[],function(o){
          zct.html(yud.get('requestTypeLocalReferential'),o.responseText);
        });
      },
      
      prepareEvent : function(e) {
        var target = yue.getTarget(e);
        return target.id.split('_')[0];
      },
      
      editEntry : function(e) {
        var target = (yue.getTarget(e)||e);
        var entryId = target.id.split('_')[1];
        zct.doAjaxCall(['/localReferentialEntry/','?entryId=',entryId].join(''),[],function(o){
          var entryFormContainerEl = yud.get('formContainer_' + entryId);
          zct.style(entryFormContainerEl, {display:'block'});
          zct.html(entryFormContainerEl,o.responseText);
        });
      },
      
      deleteEntry : function(e) {
        var target = (yue.getTarget(e)||e);
        var entryId = target.id.split('_')[1];
        var entryFormContainerEl = yud.get('formContainer_' + entryId);
        zct.style(entryFormContainerEl, {display:'none'});
      }
    }
  }();
  
  yue.onDOMReady(zcbrp.LocalReferential.init);
  
}());

