(function(){
  var zcb = zenexity.capdemat.bong;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcb.DisplayGroupEdit = function() {

    function manageRequestType(targetEl) {
      var requestTypeId = targetEl.id.split('_')[1];
      var action = targetEl.id.split('_')[0];
      var url = '';

      url += ['/',action,'RequestType/',
              '?displayGroupId=',zcb.DisplayGroupEdit.displayGroupId,
              '&requestTypeId=',requestTypeId].join('');
              
      zct.doAjaxCall(url, null, function(o) {
        var json = ylj.parse(o.responseText);
        if (json.status !== 'success') return false;
        
        var liYuiEl = new yu.Element('requestType_' + requestTypeId);
        if (action === "associate") {
          liYuiEl.removeClass('notBelong');
          yud.replaceClass(targetEl, action, "unassociate");
          targetEl.id = targetEl.id.replace('associate','unassociate');
        } else {
          liYuiEl.addClass('notBelong');
          yud.replaceClass(targetEl, action, "associate");
          targetEl.id = targetEl.id.replace('unassociate','associate');
        }
        
        var spanEl = yus.query("span.displayGroupName", "requestType_" + requestTypeId, true);
        if (!!spanEl && !YAHOO.lang.isArray(spanEl)) liYuiEl.removeChild(spanEl);
      });
    }

    return {
      clickEvent : undefined,
      
      init: function() {
        zcb.DisplayGroupEdit.clickEvent = new zct.Event(zcb.DisplayGroupEdit, zcb.DisplayGroupEdit.getHandler);
        yue.on('displayGroupRequestTypesBox','click', zcb.DisplayGroupEdit.clickEvent.dispatch, zcb.DisplayGroupEdit.clickEvent, true);
        yue.on('displayGroupForm','submit', zcb.DisplayGroupEdit.saveDisplayGroup);
        yue.on('orderRequestTypeBy','change', zcb.DisplayGroupEdit.sortRequestTypes);
      },

      getHandler: function(e) { 
        return yue.getTarget(e).id.split('_')[0]; 
      },

      associate: function(e) { manageRequestType(yue.getTarget(e)); },

      unassociate: function(e) { manageRequestType(yue.getTarget(e)); },
      
      displayRequestTypes: function(o) {
        yud.removeClass(yus.query('a.current', "sortRequestTypeForm", true), 'current');
        yud.addClass('viewRequestTypes_' + o.argument[0], "current");
        yud.get("displayGroupRequestTypesWrapper").innerHTML = o.responseText;
      },  

      viewRequestTypes: function(e) {
        var scopeEl = yud.get("scope");
        scopeEl.value = yue.getTarget(e).id.split('_')[1]
        zct.doAjaxFormSubmitCall ("sortRequestTypeForm",[scopeEl.value] , zcb.DisplayGroupEdit.displayRequestTypes);
      },

      sortRequestTypes: function(e) {
        if (yue.getTarget(e).value != "")
          zct.doAjaxFormSubmitCall("sortRequestTypeForm", [yud.get("scope").value],zcb.DisplayGroupEdit.displayRequestTypes);
      },
      
      saveDisplayGroup: function(e) {
        yue.preventDefault(e);
        if (!FIC_checkForm(e, yud.get('displayGroupFormErrors')))
          return false;
        zct.doAjaxFormSubmitCall('displayGroupForm',[],function(o){
          var json = ylj.parse(o.responseText);
          if (json.status === 'success' && zcb.DisplayGroupEdit.editMode === 'create')
            window.location = zenexity.capdemat.baseUrl + '/edit/' + json.id;
          else
            zct.Notifier.processMessage(json.status,json.message,'displayGroupMsg');
        });
      }
      
    };

  }();
  
  YAHOO.util.Event.onDOMReady(zcb.DisplayGroupEdit.init);
  
}());
