/**
 * @description This file contains the Javascript module for the configuration management page
 * for platform configuration
 *
 * @author jsb@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.localauthority');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcbl = zenexity.capdemat.bong.localauthority;

  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var ylj = YAHOO.lang.JSON;

  zcbl.PlatformConfiguration = function() {
    return {
      clickEv : undefined,
      init : function() {
        zcbl.PlatformConfiguration.clickEv = new zct.Event(zcbl.PlatformConfiguration,zcbl.PlatformConfiguration.processClick);
        yue.on(yud.get('platformConfigurationBox'),'click',zcbl.PlatformConfiguration.clickEv.dispatch,zcbl.PlatformConfiguration.clickEv,true);
      },
      /**
      * @description The name of the method to call is the first part of the clicked item's ID, except for new season creation
      */
      processClick : function(e) {
        var target  = yue.getTarget(e);
        return (target.id||'_').split('_')[0];
      },
      /**
      * @description Save platformConfiguration modifications
      */
      save : function(e) {
        var cont = yud.get("platformConfigurationFormErrors");
        cont.innerHTML = "";
        if (FIC_checkForm(yud.get("platformConfigurationForm"), cont)) {
          zct.doAjaxFormSubmitCall("platformConfigurationForm", [], function(o){
            zct.Notifier.processMessage('success',ylj.parse(o.responseText).success_msg);
          });
        }
      }
    }
  }();
  yue.onDOMReady(zcbl.PlatformConfiguration.init);
}());
