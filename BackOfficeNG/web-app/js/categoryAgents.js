/**
 * categrory"s agent management
 * display , add, del
 */

zenexity.capdemat.bong.categoryAgent = function() {
  
  var zcb = zenexity.capdemat.bong;
  var zcc = zenexity.capdemat.common;
  var yud = YAHOO.util.Dom;
  var yuel = YAHOO.util.Element;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  /* display */
  var handleViewAgentsSuccess =  function(o) {
    if (o.argument[0] === "All") {
      yud.addClass("viewAllAgentsLink", "current");
      yud.removeClass("viewCategoryAgentsLink", "current");
    } else {
      yud.removeClass("viewAllAgentsLink", "current");
      yud.addClass("viewCategoryAgentsLink", "current");
    }
    yud.get("categoryAgents").innerHTML = o.responseText;
  }
      
  function viewAgents(scope) {
    zcc.doAjaxCall(
        "/agents/?id=" + zcb.categoryId + "&scope=" + scope,
        [scope],
        handleViewAgentsSuccess);
  }
  
  function sortAgents() {
    if (yus.query("select[name=orderAgentBy]", "sortAgentForm", true).value != "")
      zcc.doAjaxFormSubmitCall ("sortAgentForm", ["All"], handleViewAgentsSuccess);
  }
  
  /* update current editing agent profile */
  function updateAgentProfile(agentId, action) {
    var currentLiEl = new yuel("agent_" + agentId);
    
    var profileSpanEls = yus.query("li[id|=agent] > span[class|=tag]", "agent_" + agentId);
    if  (profileSpanEls.length > 0) {
      currentLiEl.removeChild(profileSpanEls[0]);
    }
    
    if (action != "unassociate") {
      var cloneNewProfileSpanEl = yud.getPreviousSibling(
        yus.query("input:checked", "agentEditForm_" + agentId, true)
      ).cloneNode(true);
      
      currentLiEl.appendChild(cloneNewProfileSpanEl);
    }
  }
  
  /* cancel editable list item form */
  function cancelAgentEditForm(agentId) {
    new yuel("agent_" + agentId).removeChild(yud.get("agentEditForm_" + agentId));
      
    // re-active add/edit item link button
    yud.removeClass(
      yus.query("a.currentEditItem", "agent_" + agentId, true),
      "currentEditItem");
  }
  
  /* submit editable list item form */
  function submitAgentEditForm(agentId) {
    zcc.doAjaxFormSubmitCall(
        "agentEditForm_" + agentId,
        null, 
        function(o) {
          var response = ylj.parse(o.responseText);
          if (response.status === "ok") {
            updateAgentProfile(agentId, "editItem");
            // remove item edit form
            cancelAgentEditForm(agentId);
            // remove cssClass 'notbelong' if necessary
            yud.removeClass("agent_" + agentId, "notBelong");
            // add unassociate button (TODO: it may be dangeourous if anchor element order is changed)
            var firstAnchorEl = yus.query("a", "agent_" + agentId, true);
            if (firstAnchorEl.className === "associate") {
              cloneAnchorEl =  firstAnchorEl.cloneNode(false);
              yud.replaceClass(cloneAnchorEl, cloneAnchorEl.className, "unassociate");
              new yuel(cloneAnchorEl)
                .appendTo(yud.get("agent_" + agentId), firstAnchorEl);
              
              // transform "asociate button" in "editItem button"
              yud.replaceClass(firstAnchorEl, firstAnchorEl.className, "editItem");
            }
            
          } else {
            zcc.displayResponseResult("modelError", response.error_msg);
          }
        });
  }
  
  /* view editable list item form */
  function viewAgentEditForm(agentId, targetElClassName) {
    zcc.doAjaxCall(
        "/editAgent/" + "?id=" + zcb.categoryId + "&agentId=" + agentId,
        null,
        function(o) {
          var currentLiEl = yud.get("agent_" + agentId);
          currentLiEl.innerHTML += o.responseText;
          // unactive edit item link button
          yud.addClass(
            yus.query("a." + targetElClassName, "agent_" + agentId, true),
            "currentEditItem");          
        });
  }
  
  /* association */	
  function unassociateAgentToCategory(agentId) {
    var url = "/unassociateAgent/?categoryId=" + zcb.categoryId + "&agentId=" + agentId;
    
    zcc.doAjaxCall(
        url,
        null,
        function(o) {
          var response = ylj.parse(o.responseText);
          if (response.status === "ok") {
            var currentLiEl = yud.get("agent_" + agentId);
            yud.addClass(currentLiEl, "notBelong");
            currentLiEl.removeChild(yus.query("a.unassociate", "agent_" + agentId, true));
            yud.replaceClass(
                yus.query("a.editItem", "agent_" + agentId, true),
                "editItem",
                "associate");
            
            updateAgentProfile(agentId, "unassociate");
          } else {
            zcc.displayResponseResult("modelError", response.error_msg);
          }
        });
  }
  
  yue.addListener(
      "categoryAgents",
      "click",
      function (e) {
        var targetEl = yue.getTarget(e);
        var parentTargetEl = yue.getTarget(e).parentNode;
        // TODO - implement an ignore case policy to test tagname
        var agentId = parentTargetEl.tagName === "LI" ?
          agentId = parentTargetEl.id.replace("agent_", "")
          : agentId = parentTargetEl.parentNode.id.replace("agent_", "");
        
        if (yud.hasClass(targetEl, "associate"))
          viewAgentEditForm(agentId, "associate");
        
        else if (yud.hasClass(targetEl, "unassociate"))
          unassociateAgentToCategory(agentId);
        
        else if (yud.hasClass(targetEl, "editItem") && !yud.hasClass(targetEl, "currentEditItem"))
          viewAgentEditForm(agentId, "editItem");
        
        else if (yud.hasClass(targetEl, "submitEditItem")) {
          if (FIC_checkForm(e, yud.get("agentEditForm_" + agentId + "Errors")))
            submitAgentEditForm(agentId);
        }
        
        else if (yud.hasClass(targetEl, "cancelEditItem"))
          cancelAgentEditForm(agentId);
      });
     
  return {
    viewAgents : function(scope) { viewAgents(scope); },
    sortAgents : function() { sortAgents(); }
  };

}();
