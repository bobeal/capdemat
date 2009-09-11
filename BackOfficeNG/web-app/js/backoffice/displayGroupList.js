(function(){

  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var zcb = zenexity.capdemat.bong;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var ylj = YAHOO.lang.JSON;
  
  zcb.DisplayGroupList = function() {
    
    return {
      clickEvent : undefined,
      
      init: function() {
        zcb.DisplayGroupList.clickEvent = new zct.Event(zcb.DisplayGroupList, zcb.DisplayGroupList.getHandler);
        yue.on('displayGroups','click', zcb.DisplayGroupList.clickEvent.dispatch, zcb.DisplayGroupList.clickEvent, true);
        
        zcb.DisplayGroupList.confirmDeleteDialog = new zct.ConfirmationDialog(
         { head : 'Attention',
           body : 'Confirmez vous la suppression ?' },
         zcb.DisplayGroupList.deleteDg);
      },

      getHandler : function(e) {
        return yue.getTarget(e).id.split('_')[0];
      },

      confirmDelete : function(e) {
        var target = (yue.getTarget(e)||e);
        zcb.DisplayGroupList.confirmDeleteDialog.setBody(target.alt);
        zcb.DisplayGroupList.confirmDeleteDialog.show(e);
      },

      deleteDg : function(e, se) {
        var target = (yue.getTarget(se)||se);
        var id = target.id.split('_')[1];
        zct.doAjaxCall('/delete/' + id, null, function(o) {
          var json = ylj.parse(o.responseText);
          if (json.status === 'success')
            (new yu.Element('displayGroups')).removeChild(yud.getAncestorByTagName(target,'li'));
          zct.Notifier.processMessage(json.status,json.message,'displayGroupMsg');
        });
      }
    };

  }();

yu.Event.onDOMReady(zcb.DisplayGroupList.init);

}());

