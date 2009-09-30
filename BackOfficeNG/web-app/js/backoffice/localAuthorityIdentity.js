/**
 * @description This file contains the Javascript module for the identity management page
 * for local authority customization
 *
 * @author jsb@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.localauthority');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcv = zenexity.capdemat.Validation;
  var zcbl = zenexity.capdemat.bong.localauthority;

  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var ylj = YAHOO.lang.JSON;

  zcbl.Identity = function() {
    //var content = {head : "Attention !", body : "Confirmez-vous le retour à l'ancienne version ?"};
    return {
      clickEv : undefined,
      init : function() {
        zcbl.Identity.clickEv = new zct.Event(zcbl.Identity,zcbl.Identity.processClick);
        yue.on(yud.get('identityBox'),'click',zcbl.Identity.clickEv.dispatch,zcbl.Identity.clickEv,true);
      },
      /**
      * @description The name of the method to call is the first part of the clicked item's ID, except for new season creation
      */
      processClick : function(e) {
        var target  = yue.getTarget(e);
        return (target.id||'_').split('_')[0];
      },
      /**
      * @description Save identity modifications
      */
      save : function(e) {
        var cont = yud.get("identityFormErrors");
        cont.innerHTML = "";
        if (zcv.check(yud.get("identityForm"), cont)) {
          zct.doAjaxFormSubmitCall("identityForm", [], function(o){
            zct.Notifier.processMessage('success',ylj.parse(o.responseText).success_msg);
          });
        }
      }
    }
  }();
  yue.onDOMReady(zcbl.Identity.init);
}());
