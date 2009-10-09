(function(){
  var zcb = zenexity.capdemat.bong;
  var zct = zenexity.capdemat.tools;
  var zcv = zenexity.capdemat.Validation;
  var yud = YAHOO.util.Dom;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcb.agentCategory = function() {
	  
	var displayCategories =  function(o) {
	  if (o.argument[0] === "All") {
	    yud.addClass("viewCategories_All", "current");
	    yud.removeClass("viewCategories_Agent", "current");
	  } else {
	    yud.removeClass("viewCategories_All", "current");
	    yud.addClass("viewCategories_Agent", "current");
	  }
	  yud.get("agentCategories").innerHTML = o.responseText;
	}

	function getCategoryId(e) {
	  return yud.getAncestorByTagName(yue.getTarget(e), 'li').id.replace("category_", "");
	}
	  
	function updateCategoryAgentProfile(categoryId, action) {
	  var currentLiEl = new yu.Element("category_" + categoryId);
	  
	  var profileSpanEls = yus.query("li[id|=category] > span[class|=tag]", "category_" + categoryId);
	  if  (profileSpanEls.length > 0) {
	    currentLiEl.removeChild(profileSpanEls[0]);
	  }
	   
	  if (action != "unassociate") {
	    var cloneNewProfileSpanEl = yud.getPreviousSibling(
	      yus.query("input:checked", "categoryEditForm_" + categoryId, true)
	    ).cloneNode(true);	      
	    currentLiEl.appendChild(cloneNewProfileSpanEl);
	  }
	}
	  
	function cancelCategoryEditForm(categoryId) {
	  new yu.Element("category_" + categoryId).removeChild(yud.get("categoryEditForm_" + categoryId));  
	  // re-active add/edit item link button
	  yud.removeClass(
	    yus.query("a.currentEditItem", "category_" + categoryId, true), "currentEditItem");
	}

	function displayCategoryEditForm(e) {
		var categoryId = getCategoryId(e);
	    zct.doAjaxCall("/editCategory/" + "?id=" + zcb.agentId + "&categoryId=" + categoryId, null, function(o) {
	    	var currentLiEl = yud.get("category_" + categoryId);
	        currentLiEl.innerHTML += o.responseText;
	        // unactive edit item link button
	        yud.addClass(yus.query("a." + yue.getTarget(e).className, "category_" + categoryId, true), "currentEditItem");
	    });
	}	  
	  
	return {
	  clickEvent : undefined,
	      
	  init: function() {
	    zcb.agentCategory.clickEvent = new zct.Event(zcb.agentCategory, zcb.agentCategory.getHandler);
	    yue.on(['sortCategoryForm', 'agentCategories'],'click', zcb.agentCategory.clickEvent.dispatch,
	        zcb.agentCategory.clickEvent, true);
	  },
	      
	  getHandler : function(e) {
	    var targetClassName = yue.getTarget(e).className
	    if (targetClassName.indexOf('currentEditItem') > 0 )
	      return 'currentEditItem';
	    else
	      return targetClassName.split(' ')[0];
	  },
	      
	  associate : function(e) {
	    displayCategoryEditForm(e);
	  },
	      
	  unassociate : function(e) {
	    var categoryId = getCategoryId(e);
	    var url = "/unassociateCategory/?agentId=" + zcb.agentId + "&categoryId=" + categoryId;
	    zct.doAjaxCall(url, null, function(o) {
	        var response = ylj.parse(o.responseText);
	        if (response.status === "ok") {
	          var currentLiEl = yud.get("category_" + categoryId);
	          yud.addClass(currentLiEl, "notBelong");
	          currentLiEl.removeChild(yus.query("a.unassociate", "category_" + categoryId, true));
	          yud.replaceClass(yus.query("a.editItem", "category_" + categoryId, true), "editItem", "associate");
	          updateCategoryAgentProfile(categoryId, "unassociate");
	        } else
	          zct.Notifier.processMessage('modelError',response.success_msg);
	    });
	  },
	      
	  editItem : function(e) {
	    displayCategoryEditForm(e);
	  },
	      
	  submitEditItem : function(e) {
	    var categoryId = getCategoryId(e);
	    if (!zcv.check(e, yud.get("categoryEditForm_" + categoryId + "Errors")))
	      return;
	    zct.doAjaxFormSubmitCall("categoryEditForm_" + categoryId, null, function(o) {
	        var response = ylj.parse(o.responseText);
	        if (response.status === "ok") {
	          updateCategoryAgentProfile(categoryId, "editItem");
	          // remove item edit form
	          cancelCategoryEditForm(categoryId);
	          // remove cssClass 'notbelong' if necessary
	          yud.removeClass("category_" + categoryId, "notBelong");
	          // add unassociate button
	          var firstAnchorEl = yus.query("a", "category_" + categoryId, true);
	          if (firstAnchorEl.className === "associate") {
	            cloneAnchorEl =  firstAnchorEl.cloneNode(false);
	            yud.replaceClass(cloneAnchorEl, cloneAnchorEl.className, "unassociate");
	            new yu.Element(cloneAnchorEl).appendTo(yud.get("category_" + categoryId), firstAnchorEl);
	            // transform "asociate button" in "editItem button"
	            yud.replaceClass(firstAnchorEl, firstAnchorEl.className, "editItem");
	          }
	        } else
	           zct.Notifier.processMessage('modelError',response.success_msg);
	    });
	  },
	      
	  cancelEditItem : function(e) {
	    cancelCategoryEditForm(getCategoryId(e));
	  },
	      
	  viewCategories : function(e) {
	    var scope = (yue.getTarget(e).id||'_').split('_')[1];
	    zct.doAjaxCall(
	        "/categories/?id=" + zcb.agentId + "&scope=" + scope,
	        [scope], displayCategories);
      }
	};

  }();
	  
  YAHOO.util.Event.onDOMReady(zcb.agentCategory.init);
	  
}());
