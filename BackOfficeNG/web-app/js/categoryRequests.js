/**
 * categrory request types management
 * sort display , add, del
 */

/* display , sort */
var handleViewRequestTypesSuccess = function(o) {
    if (o.argument[0] === "All") {
        YAHOO.util.Dom.addClass("viewAllRequestTypesLink", "current");
        YAHOO.util.Dom.removeClass("viewCategoryRequestTypesLink", "current");
    } else {
        YAHOO.util.Dom.removeClass("viewAllRequestTypesLink", "current");
        YAHOO.util.Dom.addClass("viewCategoryRequestTypesLink", "current");
    }
    YAHOO.util.Dom.get("categoryRequestTypes").innerHTML = o.responseText;
}

function viewRequestTypes(scope) {
    doAjaxCall(
        "/load"+ scope +"RequestTypesTemplate/" + YAHOO.capdematBo.categoryId,
        handleViewRequestTypesSuccess, 
        [scope]);
}

function sortRequestTypes() {
    doAjaxFormSubmitCall ( handleViewRequestTypesSuccess, ["All"], "sortRequestTypeForm");
}

/* association */	
function associateRequestTypeToCategory(requestTypeId, action) {
    var url = "";

    url += action === "associate" ? "/associateRequestType/" : "/unassociateRequestType/";
    url += "?categoryId=" + YAHOO.capdematBo.categoryId +  "&requestTypeId=" + requestTypeId;
    
    doAjaxCall(
        url,
        function(o) {
            var response = YAHOO.lang.JSON.parse(o.responseText);
            if (response.status === "ok") {
                var currentLiEl = YAHOO.util.Dom.get("requestType_" + requestTypeId);
                
                var targetAnchorEl = YAHOO.util.Selector.query(
                    "a." + action, "requestType_" + requestTypeId, true);
                                
                var categorySpanEl = YAHOO.util.Selector.query(
                    "span.categoryName", "requestType_" + requestTypeId, true);
                
                if (action === "associate") {
                    YAHOO.util.Dom.removeClass(currentLiEl, "notBelong");
                    YAHOO.util.Dom.replaceClass(targetAnchorEl, action, "unassociate");
                    if (categorySpanEl != null) {
                        // TODO : it may be better to remove node
                        YAHOO.util.Dom.replaceClass(categorySpanEl, "categoryName", "invisible");
                    }
                } else {
                    YAHOO.util.Dom.addClass(currentLiEl, "notBelong");
                    YAHOO.util.Dom.replaceClass(targetAnchorEl, action, "associate");
                } 
            } else {
                displayResponseResult("modelError", response.error_msg);
            }    
        },
        null);
}

function editableListEventdispatcher(e) {
    var targetEl = YAHOO.util.Event.getTarget(e);
    if (targetEl.className === "associate" || targetEl.className === "unassociate" ) {
        associateRequestTypeToCategory(
            targetEl.parentNode.id.replace("requestType_", ""),
            targetEl.className);
    }
}

YAHOO.util.Event.addListener("categoryRequestTypes", "click", editableListEventdispatcher); 

