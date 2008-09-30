/**
 * categrory"s agent management
 * display , add, del
 */

/* display */
function viewAgents(scope) {
    doAjaxCall(
        "/load"+ scope +"AgentsTemplate/" + YAHOO.capdematBo.categoryId,
        function(o) {
            if (scope === "All") {
                YAHOO.util.Dom.addClass("viewAllAgentsLink", "current");
                YAHOO.util.Dom.removeClass("viewCategoryAgentsLink", "current");
            } else {
                YAHOO.util.Dom.removeClass("viewAllAgentsLink", "current");
                YAHOO.util.Dom.addClass("viewCategoryAgentsLink", "current");
            }
            YAHOO.util.Dom.get("categoryAgents").innerHTML = o.responseText;
        }, 
        null);
}

/* update current editing agent profile */
function updateAgentProfile(agentId, action) {
    var currentLiEl = new YAHOO.util.Element("agent_" + agentId);
    
    var profileSpanEls = YAHOO.util.Selector.query(
        "li[id|=agent] > span[class|=tag]", "agent_" + agentId);
    if  (profileSpanEls.length > 0) {
        currentLiEl.removeChild(profileSpanEls[0]);
    }
    
    if (action != "unassociate") {
        var cloneNewProfileSpanEl = YAHOO.util.Dom.getPreviousSibling(
            YAHOO.util.Selector.query("input:checked", "agentEditForm_" + agentId, true)
        ).cloneNode(true);
        
        currentLiEl.appendChild(cloneNewProfileSpanEl);
    }
}

/* cancel editable list item form */
function cancelAgentEditForm(agentId) {
    new YAHOO.util.Element("agent_" + agentId)
        .removeChild(YAHOO.util.Dom.get("agentEditForm_" + agentId));
        
    // re-active add/edit item link button
    YAHOO.util.Dom.removeClass(
        YAHOO.util.Selector.query("a.currentEditItem", "agent_" + agentId, true),
        "currentEditItem");
}

/* submit editable list item form */
function submitAgentEditForm(agentId) {
    doAjaxFormSubmitCall ( 
        function(o) {
            var response = YAHOO.lang.JSON.parse(o.responseText);
            if (response.status === "ok") {
                updateAgentProfile(agentId, "editItem");
                // remove item edit form
                cancelAgentEditForm(agentId);
                // remove cssClass 'notbelong' if necessary
                YAHOO.util.Dom.removeClass("agent_" + agentId, "notBelong");
                // add unassociate button (TODO: it may be dangeourous if anchor element order is changed)
                var firstAnchorEl = YAHOO.util.Selector.query("a", "agent_" + agentId, true);
                if (firstAnchorEl.className === "associate") {
                    cloneAnchorEl =  firstAnchorEl.cloneNode(false);
                    YAHOO.util.Dom.replaceClass(cloneAnchorEl, cloneAnchorEl.className, "unassociate");
                    new YAHOO.util.Element(cloneAnchorEl)
                        .appendTo(YAHOO.util.Dom.get("agent_" + agentId), firstAnchorEl);
                    
                    // transform "asociate button" in "editItem button"
                    YAHOO.util.Dom.replaceClass(firstAnchorEl, firstAnchorEl.className, "editItem");
                }
                
            } else {
                displayResponseResult("modelError", response.error_msg);
            }
        },
        null, 
        "agentEditForm_" + agentId);
}


/* view editable list item form */
function viewAgentEditForm(agentId, targetElClassName) {
    doAjaxCall(
        "/loadAgentEditTemplate/"
                + "?id=" + YAHOO.capdematBo.categoryId 
                + "&agentId=" + agentId,
        function(o) {
            var currentLiEl = YAHOO.util.Dom.get("agent_" + agentId);
            currentLiEl.innerHTML += o.responseText;
            // unactive edit item link button  
            YAHOO.util.Dom.addClass(
                YAHOO.util.Selector.query("a." + targetElClassName, "agent_" + agentId, true),
                "currentEditItem");                    
        }, 
        null);
}


/* association */	
function unassociateAgentToCategory(agentId) {
    var url = "/unassociateAgent/?categoryId=" + YAHOO.capdematBo.categoryId 
            + "&agentId=" + agentId;
    
    doAjaxCall(
        url, 
        function(o) {
            var response = YAHOO.lang.JSON.parse(o.responseText);
            if (response.status === "ok") {
                var currentLiEl = YAHOO.util.Dom.get("agent_" + agentId);

                YAHOO.util.Dom.addClass(currentLiEl, "notBelong");
                
                currentLiEl.removeChild(
                    YAHOO.util.Selector.query("a.unassociate", "agent_" + agentId, true));
                
                YAHOO.util.Dom.replaceClass(
                    YAHOO.util.Selector.query("a.editItem", "agent_" + agentId, true),
                    "editItem",
                    "associate");
                
                updateAgentProfile(agentId, "unassociate");
            } else {
                displayResponseResult("modelError", response.error_msg);
            }
        },
        null);
}


function agentListEventdispatcher(e) {
    var targetEl = YAHOO.util.Event.getTarget(e);
    var parentTargetEl = YAHOO.util.Event.getTarget(e).parentNode;
    
    var agentId;
    // TODO - implement an ignore case policy to test tagname
    agentId = parentTargetEl.tagName === "LI" ?
        agentId = parentTargetEl.id.replace("agent_", "")
        : agentId = parentTargetEl.parentNode.id.replace("agent_", "");
    
    switch (targetEl.className) {
        case "associate" :
            viewAgentEditForm(agentId, targetEl.className); break;
        case "unassociate" :
            unassociateAgentToCategory(agentId); break;
        case "editItem" :
            viewAgentEditForm(agentId, targetEl.className); break;
        case "submitEditItem" :
            if (FIC_checkForm(e, YAHOO.util.Dom.get("agentEditForm_" + agentId + "Errors")))
                submitAgentEditForm(agentId);
            break;
        case "cancelEditItem" :
            cancelAgentEditForm(agentId); break;
        default: break;
    }
}

YAHOO.util.Event.addListener("categoryAgents", "click", agentListEventdispatcher); 
