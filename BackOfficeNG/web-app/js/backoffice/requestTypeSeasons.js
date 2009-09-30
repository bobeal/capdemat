/**
 * @description This file contains the Javascript module for the seasons management page
 * for request type of registration kind
 *
 * @author jsb@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcv = zenexity.capdemat.Validation;
  var zcb = zenexity.capdemat.bong;
  var zcbrt = zenexity.capdemat.bong.requesttype;

  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcbrt.Seasons = function() {
    var content = {head : 'Attention !', body : 'Confirmez-vous la suppression ?'};
    var createCalendars = function(uuid) {
      zcb.Calendar("registrationStart_" + uuid);
      zcb.Calendar("registrationEnd_" + uuid);
      zcb.Calendar("validationAuthorizationStart_" + uuid);
      zcb.Calendar("effectStart_" + uuid);
      zcb.Calendar("effectEnd_" + uuid);
    };
    return {
      clickEv : undefined,
      init : function() {
        zcbrt.Seasons.clickEv = new zct.Event(zcbrt.Seasons,zcbrt.Seasons.processClick);
        yue.on(yud.get('requestTypeSeasons'),'click',zcbrt.Seasons.clickEv.dispatch,zcbrt.Seasons.clickEv,true);
      },
      /**
      * @description The name of the method to call is the first part of the clicked item's ID, except for new season creation
      */
      processClick : function(e) {
        var target  = yue.getTarget(e);
        if (target.id == "linkShowDatasheet") {
          return "loadNewSeasonForm";
        }
        return (target.id||'_').split('_')[0];
      },
      loadSeasons : function() {
        zct.doAjaxCall('/loadSeasonsArea/' + zcbrt.currentId,'',function(o){
          yud.get('requestTypeSeasons').innerHTML = o.responseText;
        });
      },
      /**
      * @description Get a blank edit season form to create a new season
      */
      loadNewSeasonForm : function() {
        zct.doAjaxCall('/editSeason?requestTypeId=' + zcbrt.currentId,[],function(o){
          yud.get('newSeasonFormContainer').innerHTML = o.responseText;
          createCalendars("");
        });
      },
      /**
      * @description Get the edit season form
      */
      editSeason: function(e) {
        var uuid = (yue.getTarget(e).id||'_').split('_')[1];
        zct.doAjaxCall('/editSeason?requestTypeId=' + zcbrt.currentId + '&uuid=' + uuid,[],function(o){
          yud.get('seasonEditionContainer_' + uuid).innerHTML = o.responseText;
          createCalendars(uuid);
        });
      },
      /**
      * @description Upload the edit season form
      */
      saveSeason: function(e) {
        var uuid = (yue.getTarget(e).id||'_').split('_')[1];
        var form = yud.get('seasonForm_' + uuid);
        var cont = yud.get('error-container_' + uuid);
        cont.innerHTML = "";
        var validform = zcv.check(e, cont);
        if (validform) {
          zct.doAjaxFormSubmitCall('seasonForm_' + uuid,[],function(o){
            zcbrt.Seasons.loadSeasons();
            zct.Notifier.processMessage('success',ylj.parse(o.responseText).success_msg);
          });
        }
      },
      /**
      * @description Hide the edit season form
      */
      cancelEditSeason : function(e) {
        var uuid = (yue.getTarget(e).id||'_').split('_')[1];
        zct.style(yud.get('seasonForm_' + uuid),{'display':'none'});
      },
      /**
      * @description Request season deletion
      */
      deleteSeason : function(e) {
        var uuid = (yue.getTarget(e).id||'_').split('_')[1];
        new zct.ConfirmationDialog(content, function(){
          zct.doAjaxDeleteCall('/editSeason', 'requestTypeId=' + zcbrt.currentId + '&uuid=' + uuid, function(o){
            zct.Notifier.processMessage('success', ylj.parse(o.responseText).success_msg);
            zcbrt.Seasons.loadSeasons();
          })
        }).show(e);
      }
    }
  }();
  YAHOO.util.Event.onDOMReady(zcbrt.Seasons.init);
}());
