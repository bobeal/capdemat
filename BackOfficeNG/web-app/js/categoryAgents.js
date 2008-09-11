/**
 * categrory's agent management
 * display , add, del
 */

/* display */
var handleViewAgentsSuccess = function(o) {
    if (o.argument[0] === "All") {
        YAHOO.util.Dom.addClass('viewAllAgentsLink', 'current');
        YAHOO.util.Dom.removeClass('viewCategoryAgentsLink', 'current');
    } else {
        YAHOO.util.Dom.removeClass('viewAllAgentsLink', 'current');
        YAHOO.util.Dom.addClass('viewCategoryAgentsLink', 'current');
    }
    var element = document.getElementById('categoryAgents');
    element.innerHTML = o.responseText;
}

function viewAgents(scope) {
    doAjaxCall(
            '/load'+ scope +'AgentsTemplate/' + YAHOO.capdematBo.categoryId,
            handleViewAgentsSuccess, 
            [scope]);
}


/* submit editable list item form */
var handleSubmitAgentEditFormSuccess = function(o) {
    var response = YAHOO.lang.JSON.parse(o.responseText);
    if (response.status === "ok") {
        // remove item edit form
        cancelAgentEditForm(o.argument[0]);
        // remove cssClass 'notbelong' if necessary
        YAHOO.util.Dom.removeClass('agent_' + o.argument[0], 'notBelong');
        //
    } else {
        displayResponseResult('modelError', response.error_msg);
    }
}

function submitAgentEditForm(agentId) {
    doAjaxFormSubmitCall ( handleSubmitAgentEditFormSuccess,
                           [agentId], 
                           "agentEditForm_" + agentId);
}


/* cancel editable list item form */
function cancelAgentEditForm(agentId) {
    var currentLiEl = new YAHOO.util.Element('agent_' + agentId);
    var editFormEl = YAHOO.util.Dom.get('agentEditForm_' + agentId);
    
    currentLiEl.removeChild(editFormEl);
    
    // re-active edit item link button
    var anchorEl = new YAHOO.util.Element(
                YAHOO.util.Dom.getElementsByClassName(
                        'currentEditItem', 'a', 'agent_' + agentId)[0]);    
    anchorEl.replaceClass('currentEditItem', 'editItem'); 
}


/* view editable list item form */
var handleviewAgentEditFormSuccess = function(o) {
    var currentLi = document.getElementById("agent_" + o.argument[0]);
    currentLi.innerHTML += o.responseText;
    
    // unactive edit item link button
    var targetAnchorEl = new YAHOO.util.Element(
                YAHOO.util.Dom.getElementsByClassName(
                        o.argument[1], 'a', 'agent_' + o.argument[0])[0]);      
    targetAnchorEl.replaceClass(o.argument[1], 'currentEditItem');                    
}

function viewAgentEditForm(agentId, targetElClassName) {
    doAjaxCall(
            '/loadAgentEditTemplate/'
                    + '?id=' + YAHOO.capdematBo.categoryId 
                    + '&agentId=' + agentId,
            handleviewAgentEditFormSuccess, 
            [agentId, targetElClassName]);
}


/* association */	
function handleAssociateAgentToCategorySuccess(o) {
    var response = YAHOO.lang.JSON.parse(o.responseText);
    if (response.status === "ok") {
        var currentLiEl = new YAHOO.util.Element('agent_' + o.argument[0]);
        
        var targetAnchorEl = new YAHOO.util.Element(
                YAHOO.util.Dom.getElementsByClassName(
                        o.argument[1], 'a', 'agent_' + o.argument[0])[0]);

         if (o.argument[1] === 'unassociate') {
            currentLiEl.addClass("notBelong");
            currentLiEl.removeChild(targetAnchorEl);
            
            var currentLiLastChildEl = YAHOO.util.Dom.getLastChild('agent_' + o.argument[0]);
            if  (currentLiLastChildEl != null) {
                var currentLiLastChildYUIEl = new YAHOO.util.Element(currentLiLastChildEl);
                currentLiEl.removeChild(currentLiLastChildYUIEl);
            }
        }
    } else {
        displayResponseResult('modelError', response.error_msg);
    }
}

function associateAgentToCategory(agentId, associatedTo) {
    var url = '';
    if (associatedTo === 'associate') {
        url += '/associateAgent/';
    } else {
    	  url += '/unassociateAgent/';
    }
    url += 
        '?categoryId=' + YAHOO.capdematBo.categoryId + 
        '&agentId=' + agentId;
    
    doAjaxCall(url, handleAssociateAgentToCategorySuccess, [agentId, associatedTo]);
}

function agentListEventdispatcher(e) {
    var targetEl = YAHOO.util.Event.getTarget(e);
    var parentTargetEl = YAHOO.util.Event.getTarget(e).parentNode;
    
    var agentId;
    // TODO - implement an ignore case policy to test tagname
    if (parentTargetEl.tagName === "LI")
        agentId = parentTargetEl.id.replace("agent_", "");
    else
        agentId = parentTargetEl.parentNode.id.replace("agent_", "");
    
    switch (targetEl.className) {
        case "associate" :
            viewAgentEditForm(agentId, targetEl.className);
            break;
        case "unassociate" :
            associateAgentToCategory(agentId, targetEl.className);
            break;
        case "editItem" :
            viewAgentEditForm(agentId, targetEl.className);
            break;
        case "submitEditItem" :
            submitAgentEditForm(agentId);
            break;
        case "cancelEditItem" :
            cancelAgentEditForm(agentId);
            break;
        default:
            break;
    }
}

YAHOO.util.Event.addListener('categoryAgents', 'click', agentListEventdispatcher); 
