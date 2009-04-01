/**
 * @description This file contains the Javascript module for the seasons management page
 * for request type of registration kind
 *
 * @author jsb@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.localauthority');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcb = zenexity.capdemat.bong;
  var zcbl = zenexity.capdemat.bong.localauthority;

  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcbl.Aspect = function() {
    var content = {head : "Attention !", body : "Confirmez-vous le retour à l'ancienne version ?"};
    return {
      clickEv : undefined,
      init : function() {
        zcbl.Aspect.clickEv = new zct.Event(zcbl.Aspect,zcbl.Aspect.processClick);
        yue.on(yud.get('cssFOBox'),'click',zcbl.Aspect.clickEv.dispatch,zcbl.Aspect.clickEv,true);
        yue.on(yud.get('bannerBox'),'click',zcbl.Aspect.clickEv.dispatch,zcbl.Aspect.clickEv,true);
        yue.on(yud.get('logoFOBox'),'click',zcbl.Aspect.clickEv.dispatch,zcbl.Aspect.clickEv,true);
        yue.on(yud.get('logoBOBox'),'click',zcbl.Aspect.clickEv.dispatch,zcbl.Aspect.clickEv,true);
        yue.on(yud.get('logoPDFBox'),'click',zcbl.Aspect.clickEv.dispatch,zcbl.Aspect.clickEv,true);
        zcbl.Aspect.loadBox("cssFO");
        zcbl.Aspect.loadBox("banner");
        zcbl.Aspect.loadBox("logoFO");
        zcbl.Aspect.loadBox("logoBO");
        zcbl.Aspect.loadBox("logoPDF");
      },
      /**
      * @description The name of the method to call is the first part of the clicked item's ID, except for new season creation
      */
      processClick : function(e) {
        var target  = yue.getTarget(e);
        return (target.id||'_').split('_')[0];
      },
      loadBox : function(fileID) {
        zct.doAjaxCall("/aspect/" + fileID, null, function(o){
          yud.get(fileID + "Box").innerHTML = o.responseText;
        });
      },
      /**
      * @description Upload a new file
      */
      save : function(e) {
        var fileID = (yue.getTarget(e).id||'_').split('_')[1];
        var cont = yud.get('setupFormErrors_' + fileID);
        cont.innerHTML = "";
        var validform = FIC_checkForm(yud.get('setupForm_' + fileID), cont);
        if (validform) {
          zct.doAjaxFormSubmitCall('setupForm_' + fileID,[],function(o){
            zct.Notifier.processMessage('success',ylj.parse(o.responseText).success_msg);
            zcbl.Aspect.loadBox(fileID);
          }, true);
        }
      },
      /**
      * @description Revenir à l'ancienne version
      */
      rollback : function(e) {
        new zct.ConfirmationDialog(content, function(){
          var fileID = (yue.getTarget(e).id||'_').split('_')[1];
          zct.doAjaxCall("/rollback/" + fileID, null, function(o){
            zct.Notifier.processMessage('success',ylj.parse(o.responseText).success_msg);
            zcbl.Aspect.loadBox(fileID);
          });
        }).show(e);
      }
    }
  }();
  yue.onDOMReady(zcbl.Aspect.init);
}());
