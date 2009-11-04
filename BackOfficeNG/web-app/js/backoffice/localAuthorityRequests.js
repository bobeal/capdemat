/**
 * @description This file contains the Javascript module for the configuration management page
 * for requests configuration
 *
 * @author jsb@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.localauthority');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcv = zenexity.capdemat.Validation;
  var zcbl = zenexity.capdemat.bong.localauthority;

  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var ylj = YAHOO.lang.JSON;

  zcbl.Requests = function() {
    var splitEvent = function(e) {
      return (yue.getTarget(e).id||'_').split('_')[1];
    };
    return {
      clickEv : undefined,
      init : function() {
        zcbl.Requests.clickEv = new zct.Event(zcbl.Requests,zcbl.Requests.processClick);
        yue.on(yud.get('draftsBox'),'click',zcbl.Requests.clickEv.dispatch,zcbl.Requests.clickEv,true);
        yue.on(yud.get('meansOfContactBox'),'click',zcbl.Requests.clickEv.dispatch,zcbl.Requests.clickEv,true);
        yue.on(yud.get('platformConfigurationBox'),'click',zcbl.Requests.clickEv.dispatch,zcbl.Requests.clickEv,true);
        zcbl.Requests.loadMoCs();
      },
      /**
      * @description The name of the method to call is the first part of the clicked item's ID, except for new season creation
      */
      processClick : function(e) {
        var target  = yue.getTarget(e);
        return (target.id||'_').split('_')[0];
      },
      loadMoCs : function() {
        var cont = yud.get('meansOfContactContainer');
        zct.doAjaxCall("/moCs", null, function(o) {
          cont.innerHTML = o.responseText;
        });
      },
      save : function(e) {
        var id = splitEvent(e);
        var cont = yud.get(id + "FormErrors");
        cont.innerHTML = "";
        if (zcv.check(yud.get(id + "Form"), cont)) {
          zct.doAjaxFormSubmitCall(id + "Form", [], function(o){
            zct.Notifier.processMessage('success', ylj.parse(o.responseText).success_msg, null, e);
          });
        }
      },
      saveMoC : function(e) {
        zct.doAjaxFormSubmitCall(splitEvent(e) + "Form", [], function(o){
          zct.Notifier.processMessage('success', ylj.parse(o.responseText).success_msg, null, e);
          zcbl.Requests.loadMoCs();
        });
      }
    }
  }();
  yue.onDOMReady(zcbl.Requests.init);
}());
