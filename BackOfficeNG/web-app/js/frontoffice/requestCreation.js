(function() {
  var zcf = zenexity.capdemat.fong;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yu = YAHOO.util;
  var yw = YAHOO.widget;
  
  zcf.RequestCreation = function() {
    
    var selectTab = function(href) {
      var tabs = zcf.RequestCreation.requestFormTabView.get('tabs');
      for (var i = 0, len = tabs.length; i < len; ++i) {
        if (tabs[i].get('href') === href) {
          zcf.RequestCreation.requestFormTabView.set('activeIndex', i);
          break;
        }
      }
    };
    
    var viewTab = function(offset) {
      zcf.RequestCreation.requestFormTabView.set(
          'activeIndex',
          zcf.RequestCreation.requestFormTabView.get('activeIndex') + offset
      );
    };
    
    // hack to append submit input as hidden
    var addSubmitAsHidden = function (submitEl) {
      var submitAsHiddenEl = document.createElement("input");
      submitAsHiddenEl.type = 'hidden';
      submitAsHiddenEl.name = submitEl.name;

      var fromYuiEl = new yu.Element(submitEl.form);
      fromYuiEl.appendChild(submitAsHiddenEl);
    };

    var validateAndSubmit = function (e, includeScope) {
      yue.preventDefault(e);
      var targetEl = yue.getTarget(e);
      if (!FIC_checkForm(e, yud.get(targetEl.form.id + '-error'), includeScope))
        return;
      else {
        // -- hack to know current step
        addSubmitAsHidden(targetEl);
        
        targetEl.form.submit();
      }
    };

    var computeIncludeScope = function(form) {
      if (form.id.split('-')[1] === "account") return false;
      var allEmpty = true;
      var subScopes = yud.getElementsByClassName("validation-scope", null, form);
      zct.each(subScopes, function() {
        var inputs = yud.getElementsBy(function(el) {
          return (zct.inArray(el.nodeName, ["INPUT", "SELECT", "TEXTAREA"]) > -1 && zct.inArray(el.type, ["submit", "hidden"]) == -1);
        }, null, this);
        zct.each(inputs, function() {
          if (zct.inArray(this.type, ["checkbox", "radio"]) != -1) {
            allEmpty = allEmpty && !this.checked;
          } else {
            allEmpty = allEmpty && (zct.val(this) === "");
          }
        });
      });
      if (!allEmpty) return undefined;
      return false;
    };

    return {
      clickEvent : undefined,
      requestFormTabView : undefined,
      
      init : function() {
        zcf.RequestCreation.requestFormTabView = new yw.TabView('requestTabView');
        
        zcf.RequestCreation.clickEvent = new zct.Event(zcf.RequestCreation, zcf.RequestCreation.getHandler);
        yue.on('requestTabView','click', zcf.RequestCreation.clickEvent.dispatch, zcf.RequestCreation.clickEvent, true);
        
        yue.on('requestTabView','change',zcf.RequestCreation.formatField);
        
        yue.on('draftForm','submit',zcf.RequestCreation.submitDraft);
        
        yue.on(yud.get("requestNote"), 'keyup', function(e) {
          zct.limitArea("requestNote",
            yud.get("requestNote").getAttribute('maxlength'),
            "requestNoteLimit");
        });
        zct.limitArea("requestNote",
          yud.get("requestNote").getAttribute('maxlength'), "requestNoteLimit");

        var index = zct.getElementsByName('currentTabIndex','input',yud.get('draftForm'))[0].value;
        if (!!index) zcf.RequestCreation.requestFormTabView.set('activeIndex',index);
      },
      
      getHandler : function(e) {
          var targetEl = yue.getTarget(e);
          tokens = targetEl.id.split('-');
          if (tokens.length > 1)
            return [tokens[0], zct.capitalize(tokens[1])].join('');
          else
            return tokens[0];
      },
      
      submitStep : function(e) { validateAndSubmit(e, computeIncludeScope(yue.getTarget(e).form)); },
      
      submitCollectionAdd : function(e) { validateAndSubmit(e, true); },
      
      submitCollectionModify : function(e) { validateAndSubmit(e, true); },
      
      submitDraft : function(e) {
        yue.stopEvent(e);
        var hd = zct.getElementsByName('currentTabIndex','input',yud.get('draftForm'))[0];
        hd.value = zcf.RequestCreation.requestFormTabView.get('activeIndex');
        yud.get('draftForm').submit();
      },
      
      formatField : function(e) {
        var targetEl = yue.getTarget(e);
        if (!zct.nodeName(targetEl,'input') || targetEl.type != 'text')
          return false;
        
        var fieldType = /validate-(\w+)/i.exec(targetEl.className);
        if (fieldType) {
          if (fieldType[1] === 'lastName') targetEl.value = targetEl.value.toUpperCase();
          else if (fieldType[1] === 'city') targetEl.value = targetEl.value.toUpperCase();
          else if (fieldType[1] === 'firstName') targetEl.value = zct.capitalize(targetEl.value);
          else if (fieldType[1] === 'date') targetEl.value = Date.parse(targetEl.value).toString(Date.CultureInfo.formatPatterns.shortDate);
        }
      },
      
      prevTab : function(e) {
          yue.preventDefault(e);
          viewTab(-1);
      },
      
      nextTab : function(e) {
          yue.preventDefault(e);
          viewTab(1);
      },
      
      activeTab : function(e) {
          yue.preventDefault(e);
          var targetEl = yue.getTarget(e);
          selectTab(targetEl.hash);
      }
    };
    
  }();
  
  yue.onDOMReady(zcf.RequestCreation.init);
  
}());

