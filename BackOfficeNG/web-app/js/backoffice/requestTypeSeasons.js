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
    var loadSeasons = function() {
      zct.doAjaxCall('/loadSeasonsArea/' + zcbrt.currentId,'',function(o){
        yud.get('requestTypeSeasons').innerHTML = o.responseText;
      });
    };
    var createCalendars = function(uuid) {
      YAHOO.capdematBo.calendar.init(null, null, {id : 'registrationStart_' + uuid, label : 'registrationStart_' + uuid});
      YAHOO.capdematBo.calendar.init(null, null, {id : 'registrationEnd_' + uuid, label : 'registrationEnd_' + uuid});
      YAHOO.capdematBo.calendar.init(null, null, {id : 'validationAuthorizationStart_' + uuid, label : 'validationAuthorizationStart_' + uuid});
      YAHOO.capdematBo.calendar.init(null, null, {id : 'effectStart_' + uuid, label : 'effectStart_' + uuid});
      YAHOO.capdematBo.calendar.init(null, null, {id : 'effectEnd_' + uuid, label : 'effectEnd_' + uuid});
    };
    return {
      clickEv : undefined,
      init : function() {
        YAHOO.capdematBo.calendar.cal = {};
        zcbrt.Seasons.clickEv = new zct.Event(zcbrt.Seasons,zcbrt.Seasons.processClick);
        yue.on(yud.get('requestTypeSeasons'),'click',zcbrt.Seasons.clickEv.dispatch,zcbrt.Seasons.clickEv,true);
        loadSeasons();
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
      /**
      * @description Get a blank edit season form to create a new season
      */
      loadNewSeasonForm : function() {
        zct.doAjaxCall('/editSeason?requestTypeId=' + zcbrt.currentId,[],function(o){
          var cont = yud.get('newSeasonFormContainer');
          cont.innerHTML = o.responseText;
          createCalendars("");
        });
      },
      /**
      * @description Get the edit season form
      */
      editSeason: function(e) {
        var uuid = (yue.getTarget(e).id||'_').split('_')[1];
        zct.doAjaxCall('/editSeason?requestTypeId=' + zcbrt.currentId + '&uuid=' + uuid,[],function(o){
          var cont = yud.get('seasonEditionContainer_' + uuid);
          cont.innerHTML = o.responseText;
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
        var validform = FIC_checkForm(form, cont);
        if (validform) {
          zct.doAjaxFormSubmitCall('seasonForm_' + uuid,[],function(o){
            loadSeasons();
            var json = YAHOO.lang.JSON.parse(o.responseText);
            zct.Notifier.processMessage('success',json.success_msg);
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
            var li = new yu.Element(yue.getTarget(e).parentNode);
            var ul = new yu.Element(yue.getTarget(e).parentNode.parentNode);
            var json = YAHOO.lang.JSON.parse(o.responseText);
            zct.Notifier.processMessage('success',json.success_msg);
            loadSeasons();
          })
        }).show(e);
      }
    }
  }();
}());
