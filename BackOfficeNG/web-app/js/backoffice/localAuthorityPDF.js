/**
 * @description This file contains the Javascript module for the pdf files management page
 * for local authority resources customization
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

  zcbl.PDF = function() {
    var content = {head : "Attention !", body : "Confirmez-vous le retour à l'ancienne version ?"};
    return {
      clickEv : undefined,
      init : function() {
        zcbl.PDF.clickEv = new zct.Event(zcbl.PDF,zcbl.PDF.processClick);
        yue.on(yud.get('faqFoBox'),'click',zcbl.PDF.clickEv.dispatch,zcbl.PDF.clickEv,true);
        yue.on(yud.get('helpBoBox'),'click',zcbl.PDF.clickEv.dispatch,zcbl.PDF.clickEv,true);
        yue.on(yud.get('helpFoBox'),'click',zcbl.PDF.clickEv.dispatch,zcbl.PDF.clickEv,true);
        yue.on(yud.get('legalBox'),'click',zcbl.PDF.clickEv.dispatch,zcbl.PDF.clickEv,true);
        yue.on(yud.get('useBox'),'click',zcbl.PDF.clickEv.dispatch,zcbl.PDF.clickEv,true);
        zcbl.PDF.loadBox("faqFo");
        zcbl.PDF.loadBox("helpBo");
        zcbl.PDF.loadBox("helpFo");
        zcbl.PDF.loadBox("legal");
        zcbl.PDF.loadBox("use");
      },
      /**
      * @description The name of the method to call is the first part of the clicked item's ID, except for new season creation
      */
      processClick : function(e) {
        var target  = yue.getTarget(e);
        return (target.id||'_').split('_')[0];
      },
      loadBox : function(fileID) {
        zct.doAjaxCall("/pdf/" + fileID, null, function(o){
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
            zcbl.PDF.loadBox(fileID);
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
            zcbl.PDF.loadBox(fileID);
          });
        }).show(e);
      }
    }
  }();
  yue.onDOMReady(zcbl.PDF.init);
}());
