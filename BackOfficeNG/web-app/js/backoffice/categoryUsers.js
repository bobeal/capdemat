(function(){
  var zcb = zenexity.capdemat.bong;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcb.categoryUser = function() {
  
    var displayUsers =  function(o) {
      if (o.argument[0] === "All") {
        yud.addClass("viewAllUsersLink", "current");
        yud.removeClass("viewCategoryUsersLink", "current");
      } else {
        yud.removeClass("viewAllUsersLink", "current");
        yud.addClass("viewCategoryUsersLink", "current");
      }
      yud.get("categoryUsers").innerHTML = o.responseText;
    }
    
    function getUserId(e) {
      return yud.getAncestorByTagName(yue.getTarget(e), 'li').id.replace("user_", "");
    }
    
    function cancelUserEditForm(userId) {
      new yu.Element("user_" + userId).removeChild(yud.get("userEditForm_" + userId));
      // re-active add/edit item link button
      yud.removeClass(yus.query("a.currentEditItem", "user_" + userId, true), "currentEditItem");
    }
    
    //FIXME - simplify user display update policy by ajax refresh for example
    function updateUserProfile(userId, action) {
      var currentLiEl = new yu.Element("user_" + userId);
       
      var profileSpanEls = yus.query("li[id|=user] > span[class|=tag]", "user_" + userId);
      if  (profileSpanEls.length > 0)
        currentLiEl.removeChild(profileSpanEls[0]);
      
      if (action != "unassociate") {
        var cloneNewProfileSpanEl = 
          yud.getPreviousSibling(yus.query("input:checked", "userEditForm_" + userId, true)).cloneNode(true);
        currentLiEl.appendChild(cloneNewProfileSpanEl);
      }
    }
    
    function displayUserEditForm(e) {
      var userId = getUserId(e);
      zct.doAjaxCall("/editUser/" + "?id=" + zcb.categoryId + "&userId=" + userId, null, function(o) {
          var currentLiEl = yud.get("user_" + userId);
          currentLiEl.innerHTML += o.responseText;
          // unactive edit item link button
          yud.addClass(yus.query("a." + yue.getTarget(e).className, "user_" + userId, true), "currentEditItem");
      });
    }

    return {
      clickEvent : undefined,
      
      init: function() {
          zcb.categoryUser.clickEvent = new zct.Event(zcb.categoryUser, zcb.categoryUser.getHandler);
          yue.on('categoryUsers','click', zcb.categoryUser.clickEvent.dispatch,
              zcb.categoryUser.clickEvent, true);
      },
      
      getHandler : function(e) {
          var targetClassName = yue.getTarget(e).className
          if (targetClassName.indexOf('currentEditItem') > 0 )
            return 'currentEditItem';
          else
            return targetClassName.split(' ')[0];
      },
      
      associate : function(e) {
          displayUserEditForm(e);
      },
      
      unassociate : function(e) {
          var userId = getUserId(e);
          var url = "/unassociateUser/?categoryId=" + zcb.categoryId + "&userId=" + userId;
          zct.doAjaxCall(url, null, function(o) {
              var response = ylj.parse(o.responseText);
              if (response.status === "ok") {
                var currentLiEl = yud.get("user_" + userId);
                yud.addClass(currentLiEl, "notBelong");
                currentLiEl.removeChild(yus.query("a.unassociate", "user_" + userId, true));
                yud.replaceClass(yus.query("a.editItem", "user_" + userId, true), "editItem", "associate");
                updateUserProfile(userId, "unassociate");
              } else
                zct.Notifier.processMessage('modelError',response.success_msg);
          });
      },
      
      editItem : function(e) {
          displayUserEditForm(e);
      },
      
      submitEditItem : function(e) {
          var userId = getUserId(e);
          if (!FIC_checkForm(e, yud.get("userEditForm_" + userId + "Errors")))
            return;
          zct.doAjaxFormSubmitCall("userEditForm_" + userId, null, function(o) {
              var response = ylj.parse(o.responseText);
              if (response.status === "ok") {
                updateUserProfile(userId, "editItem");
                // remove item edit form
                cancelUserEditForm(userId);
                // remove cssClass 'notbelong' if necessary
                yud.removeClass("user_" + userId, "notBelong");
                // add unassociate button (TODO: it may be dangeourous if anchor element order is changed)
                var firstAnchorEl = yus.query("a", "user_" + userId, true);
                if (firstAnchorEl.className === "associate") {
                  cloneAnchorEl =  firstAnchorEl.cloneNode(false);
                  yud.replaceClass(cloneAnchorEl, cloneAnchorEl.className, "unassociate");
                  new yu.Element(cloneAnchorEl).appendTo(yud.get("user_" + userId), firstAnchorEl);
                  // transform "asociate button" in "editItem button"
                  yud.replaceClass(firstAnchorEl, firstAnchorEl.className, "editItem");
                }
              } else
                zct.Notifier.processMessage('modelError',response.success_msg);
        });
      },
      
      cancelEditItem : function(e) {
          cancelUserEditForm(getUserId(e));
      },
      
      viewUsers : function(scope) {
          zct.doAjaxCall("/users/?id=" + zcb.categoryId + "&scope=" + scope, [scope], displayUsers);
      },
      // TODO - no more used - remove from code
      sortUsers : function() {
          if (yus.query("select[name=orderUserBy]", "sortUserForm", true).value != "")
            zct.doAjaxFormSubmitCall ("sortUserForm", ["All"], displayUsers);
      }
    };

  }();
  
  YAHOO.util.Event.onDOMReady(zcb.categoryUser.init);
  
}());
