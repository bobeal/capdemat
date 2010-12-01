/**
 * @author rdj@zenexity.fr
 */
zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcv = zenexity.capdemat.Validation;
  var zcbrt = zenexity.capdemat.bong.requesttype;

  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcbrt.Rules = function() {

    return {

      init: function() {
        zcbrt.Rules.initRules();
        zcbrt.Conf.saveRule = zcbrt.Rules.save;
      },

      initRules : function() {
        zct.doAjaxCall(['/loadRules/',(zcbrt.currentId||0)].join(''),[],function(o){
          zct.html(yud.get('requestTypeRules'),o.responseText);
        });
      },

      save : function(e) {
        yue.preventDefault(e);
        var target = yue.getTarget(e);
        var formEl = yud.getAncestorByTagName(target, 'form');
        zct.doAjaxFormSubmitCall(formEl.id,[],function(o){
          var json = ylj.parse(o.responseText);
          zcbrt.Rules.initRules();
          zct.Notifier.processMessage(json.status, json.message, null, target);
        }, true);
      }
    }
  }();
  YAHOO.util.Event.onDOMReady(zcbrt.Rules.init);
}());

