/**
 * categrory request types management
 * sort display , add, del
 */

zenexity.capdemat.bong.categoryRequestType = function() {
  
  var zcb = zenexity.capdemat.bong;
  var zcc = zenexity.capdemat.common;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  /* display , sort */
  var handleViewRequestTypesSuccess = function(o) {
    if (o.argument[0] === "All") {
      yud.addClass("viewAllRequestTypesLink", "current");
      yud.removeClass("viewCategoryRequestTypesLink", "current");
    } else {
      yud.removeClass("viewAllRequestTypesLink", "current");
      yud.addClass("viewCategoryRequestTypesLink", "current");
    }
    yud.get("categoryRequestTypes").innerHTML = o.responseText;
  }
  
  function viewRequestTypes(scope) {
    // set the scope manually in the form in order to get it from the POSTed parameters
    yud.get("scope").value = scope;
    zcc.doAjaxFormSubmitCall ("sortRequestTypeForm", [scope], handleViewRequestTypesSuccess);
  }
  
  function sortRequestTypes() {
    if (yus.query("select[name=orderRequestTypeBy]", "sortRequestTypeForm", true).value != "")
      zcc.doAjaxFormSubmitCall ("sortRequestTypeForm", [yud.get("scope").value], handleViewRequestTypesSuccess);
  }
  
  /* association */	
  function associateRequestTypeToCategory(requestTypeId, action) {
    var url = "";
    
    url += action === "associate" ? "/associateRequestType/" : "/unassociateRequestType/";
    url += "?categoryId=" + zcb.categoryId +  "&requestTypeId=" + requestTypeId;
    
    zcc.doAjaxCall(
      url,null,
      function(o) {
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
          zcc.Notifier.processMessage('modelError',response.success_msg);
        }  
      });
  }
  
  yue.addListener(
      "categoryRequestTypes",
      "click",
      function(e) {
        var targetEl = yue.getTarget(e);
        if (targetEl.className === "associate" || targetEl.className === "unassociate" ) {
          associateRequestTypeToCategory(
            targetEl.parentNode.id.replace("requestType_", ""),
            targetEl.className);
        }
      });
  
  return {
    viewRequestTypes : function(scope) { viewRequestTypes(scope); },
    sortRequestTypes : function() { sortRequestTypes(); }
  };

}();
