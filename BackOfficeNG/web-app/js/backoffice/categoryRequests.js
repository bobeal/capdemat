(function(){
  var zcb = zenexity.capdemat.bong;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcb.categoryRequestType = function() {
  
    var displayRequestTypes = function(o) {
      if (o.argument[0] === "All") {
        yud.addClass("viewAllRequestTypesLink", "current");
        yud.removeClass("viewCategoryRequestTypesLink", "current");
      } else {
        yud.removeClass("viewAllRequestTypesLink", "current");
        yud.addClass("viewCategoryRequestTypesLink", "current");
      }
      yud.get("categoryRequestTypes").innerHTML = o.responseText;
    }
    
    function manageRequestType(targetEl) {
      var requestTypeId = targetEl.parentNode.id.replace("requestType_", "");
      var action = targetEl.className;
      var url = "";
      
      url += action === "associate" ? "/associateRequestType/" : "/unassociateRequestType/";
      url += "?categoryId=" + zcb.categoryId +  "&requestTypeId=" + requestTypeId;
      
      zct.doAjaxCall(url, null, function(o) {
          var response = ylj.parse(o.responseText);
          if (response.status === "ok") {
            var currentLiEl = yud.get("requestType_" + requestTypeId);
            var targetAnchorEl = yus.query("a." + action, "requestType_" + requestTypeId, true);    
            var categorySpanEl = yus.query("span.categoryName", "requestType_" + requestTypeId, true);
                
            if (action === "associate") {
              yud.removeClass(currentLiEl, "notBelong");
              yud.replaceClass(targetAnchorEl, action, "unassociate");
              if (categorySpanEl != null) {
                // TODO : it may be better to remove node
                yud.replaceClass(categorySpanEl, "categoryName", "invisible");
              }
            } else {
              yud.addClass(currentLiEl, "notBelong");
              yud.replaceClass(targetAnchorEl, action, "associate");
            } 
          } else {
            zct.Notifier.processMessage('modelError',response.success_msg);
          }  
        });
    }

    return {
      clickEvent : undefined,
      
      init: function() {
          zcb.categoryRequestType.clickEvent = new zct.Event(zcb.categoryRequestType, zcb.categoryRequestType.getHandler);
          yue.on('categoryRequestTypes','click', zcb.categoryRequestType.clickEvent.dispatch,
              zcb.categoryRequestType.clickEvent, true);
      },
      
      getHandler : function(e) {
          return yue.getTarget(e).className.split(' ')[0];
      },
      
      associate : function(e) {
          manageRequestType(yue.getTarget(e));
      },
      
      unassociate : function(e) {
          manageRequestType(yue.getTarget(e));
      },
      
      viewRequestTypes : function(scope) {
          yud.get("scope").value = scope;
          zct.doAjaxFormSubmitCall ("sortRequestTypeForm", [scope], displayRequestTypes);
      },
      
      sortRequestTypes : function() {
          if (yus.query("select[name=orderRequestTypeBy]", "sortRequestTypeForm", true).value != "")
            zct.doAjaxFormSubmitCall ("sortRequestTypeForm", [yud.get("scope").value], displayRequestTypes);
      }
    };

  }();
  
  YAHOO.util.Event.onDOMReady(zcb.categoryRequestType.init);
  
}());
