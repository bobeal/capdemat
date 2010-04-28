/**
 * @author rdj@zenexity.fr
 */
zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcv = zenexity.capdemat.Validation;
  var zcbrp = zenexity.capdemat.bong.requesttype;
    
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
 
  zcbrp.Rules = function() {
    
    return {
      clickEvent: undefined,

      init: function() {
        zcbrp.Rules.initRules();
        
        // click event
        zcbrp.Rules.clickEvent = new zct.Event(zcbrp.Rules, zcbrp.Rules.prepareEvent);
        yue.on(yud.get('requestTypeRules'),'click',zcbrp.Rules.clickEvent.dispatch,zcbrp.Rules.clickEvent,true);
      },
      
      prepareEvent : function(e) {
        var target = yue.getTarget(e);
        return target.id.split('_')[0];
      },
      
      initRules : function() {
        zct.doAjaxCall(['/loadRules/',(zcbrp.currentId||0)].join(''),[],function(o){
          zct.html(yud.get('requestTypeRules'),o.responseText);
        });
      },
      
      saveRule : function(e) {
        yue.preventDefault(e);
        var target = yue.getTarget(e);
        var formEl = yud.getAncestorByTagName(target, 'form');
        zct.doAjaxFormSubmitCall(formEl.id,[],function(o){
          var json = ylj.parse(o.responseText);
          zcbrp.Rules.initRules();
          zct.Notifier.processMessage(json.status, json.message, null, target);
        }, true);
      }
      
    }
  }();
  
}());

