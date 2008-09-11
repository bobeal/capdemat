/**
 * categrory request types management
 * sort display , add, del
 */

/* display , sort */
var handleViewRequestTypesSuccess = function(o) {
    if (o.argument[0] === "All") {
        YAHOO.util.Dom.addClass('viewAllRequestTypesLink', 'current');
        YAHOO.util.Dom.removeClass('viewCategoryRequestTypesLink', 'current');
    } else {
        YAHOO.util.Dom.removeClass('viewAllRequestTypesLink', 'current');
        YAHOO.util.Dom.addClass('viewCategoryRequestTypesLink', 'current');
    }
    var element = document.getElementById('categoryRequestTypes');
    element.innerHTML = o.responseText;
}

function viewRequestTypes(scope) {
    doAjaxCall(
            '/load'+ scope +'RequestTypesTemplate/' + YAHOO.capdematBo.categoryId,
            handleViewRequestTypesSuccess, 
            [scope]);
}

function sortRequestTypes() {
    doAjaxFormSubmitCall ( handleViewRequestTypesSuccess,
                           ["All"], 
                           "sortRequestTypeForm");
}

/* association */	
function handleAssociateRequestToCategorySuccess(o) {
    var response = YAHOO.lang.JSON.parse(o.responseText);
    if (response.status === "ok") {
        var currentLiEl = new YAHOO.util.Element('requestType_' + o.argument[0]);
        
        var targetAnchorEl = new YAHOO.util.Element(
                YAHOO.util.Dom.getElementsByClassName(
                        o.argument[1], 'a', 'requestType_' + o.argument[0])[0]);
                        
        var categorySpanElArray = YAHOO.util.Dom.getElementsByClassName(
                        'category', 'span', 'requestType_' + o.argument[0]);
        
        if (o.argument[1] === 'associate') {
            currentLiEl.removeClass('notBelong');
            targetAnchorEl.replaceClass(o.argument[1], 'unassociate');
            if (categorySpanElArray != null && categorySpanElArray.length > 0) {
                var categorySpanEl = new YAHOO.util.Element(categorySpanElArray[0]);
                categorySpanEl.replaceClass('category', 'invisible');
            }
        } else {
            currentLiEl.addClass("notBelong");
            targetAnchorEl.replaceClass(o.argument[1], 'associate');
        } 
//        displayResponseResult('success', response.success_msg);
    } else {
        displayResponseResult('modelError', response.error_msg);
    }
    
}

function associateRequestTypeToCategory(associatedTo, requestTypeId) {
    var url = '';
    if (associatedTo === 'associate') {
        url += '/associateRequestType/';
    } else {
    	  url += '/unassociateRequestType/';
    }
    url += 
        '?categoryId=' + YAHOO.capdematBo.categoryId + 
        '&requestTypeId=' + requestTypeId;
    
    doAjaxCall(url, handleAssociateRequestToCategorySuccess, [requestTypeId, associatedTo]);
}

function editableListEventdispatcher(e) {
    var targetEl = YAHOO.util.Event.getTarget(e);
    if (targetEl.className === 'associate' || targetEl.className === 'unassociate' ) {
        var requestTypeId = YAHOO.util.Event.getTarget(e).parentNode.id.replace('requestType_', '');
        associateRequestTypeToCategory(targetEl.className, requestTypeId);
    }
}

YAHOO.util.Event.addListener('categoryRequestTypes', 'click', editableListEventdispatcher); 

