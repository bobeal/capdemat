(function(){

  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var zcb = zenexity.capdemat.bong;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var ylj = YAHOO.lang.JSON;

  zcb.externalApplications = function() {

    return {
      clickEvent : undefined,

      init: function() {
        zcb.externalApplications.clickEvent = new zct.Event(zcb.externalApplications, zcb.externalApplications.getHandler);
        yue.on('applications','click', zcb.externalApplications.clickEvent.dispatch, zcb.externalApplications.clickEvent, true);

        zcb.externalApplications.confirmDeleteDialog = new zct.ConfirmationDialog(
         { head : 'Attention',
           body : 'Confirmez vous la suppression ?' },
         zcb.externalApplications.deleteApp);
      },

      getHandler : function(e) {
        return yue.getTarget(e).id.split('_')[0];
      },

      confirmDelete : function(e) {
        var target = (yue.getTarget(e)||e);
        zcb.externalApplications.confirmDeleteDialog.setBody(target.alt);
        zcb.externalApplications.confirmDeleteDialog.show(e);
      },

      deleteApp : function(e, se) {
        var target = (yue.getTarget(se)||se);
        var id = target.id.split('_')[1];
        zct.doAjaxCall('/deleteApplication/' + id, null, function(o) {
          var json = ylj.parse(o.responseText);
          if (json.status === 'success')
            (new yu.Element('applications')).removeChild(yud.getAncestorByTagName(target,'li'));
          zct.Notifier.processMessage(json.status,json.message,'applicationMsg');
        });
      }
    };

  }();

yu.Event.onDOMReady(zcb.externalApplications.init);

}());