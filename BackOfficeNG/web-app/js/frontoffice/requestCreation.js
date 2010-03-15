(function() {
  var zcf = zenexity.capdemat.fong;
  var zct = zenexity.capdemat.tools;
  var zcv = zenexity.capdemat.Validation;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
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

    var validateAndSubmit = function (e, scope) {
      yue.preventDefault(e);
      var targetEl = yue.getTarget(e);
      if (!zcv.check(e, yud.get(targetEl.form.id + '-error'), scope)) {
        zct.html(yud.get(targetEl.form.id + '-error'), 'Des champs obligatoires ne sont pas correctement remplis, merci de v&eacute;rifier les champs en rouge');
        return;
      }
      else {
        // -- hack to know current step
        addSubmitAsHidden(targetEl);
        
        targetEl.form.submit();
      }
    };

    var adaptDateDays = function(cont) {
      var yearInput = yus.query(".year", cont, true);
      var year = yearInput.value === "" ? Date.today().getFullYear() : yearInput.value;
      var monthInput = yus.query(".month", cont, true);
      var month = monthInput.value === "" ? 0 : monthInput.value - 1;
      var dayInput = yus.query(".day", cont, true);
      var days = Date.getDaysInMonth(year, month);
      if (dayInput.length > days + 1) {
        while (dayInput.length > days + 1) {
          dayInput.remove(dayInput.length - 1);
        }
      } else if (days + 1 > dayInput.length) {
        for (i = dayInput.length; i <= days; i++) {
          var option = document.createElement("option");
          option.text = i;
          option.value = i;
          dayInput.add(option, null);
        }
      }
    };
    
    var initCustomJS = function() {
      var label = yud.get("conditionsForm").requestTypeLabel.value.split(' ').join('');
      if (!!zcf.requesttype && !!zcf.requesttype[label + 'Request'])
        zcf.requesttype[label + 'Request'].init();
    };

    return {
      clickEvent : undefined,
      requestFormTabView : undefined,
      
      init : function() {
        zcf.RequestCreation.requestFormTabView = new yw.TabView('requestTabView');
        
        zcf.RequestCreation.clickEvent = new zct.Event(zcf.RequestCreation, zcf.RequestCreation.getHandler);
        yue.on('requestTabView','click', zcf.RequestCreation.clickEvent.dispatch, zcf.RequestCreation.clickEvent, true);
        
        yue.on('requestTabView','keyup',zcf.RequestCreation.formatField);
        yue.on(yus.query("#requestTabView .validate-phone"), "keyup", zcf.RequestCreation.formatPhone);
        yue.on(yus.query("#requestTabView .date .month, #requestTabView .date .year"), "change", zcf.RequestCreation.dateChange);
        yue.on(yus.query("#requestTabView .validate-mobilePhone"), "keyup", zcf.RequestCreation.formatPhone);
        
        var requestNote = yud.get("requestNote");
        if (requestNote != null) {
          yue.on(yud.get("requestNote"), 'keyup', function(e) {
            zct.limitArea("requestNote", 1024, "requestNoteLimit");
          });
          zct.limitArea("requestNote", 1024, "requestNoteLimit");
        }
        zct.each(yus.query("#request div.date"), function() {
          adaptDateDays(this);
          zcv.complexRules["dateWidget"].pushFields(
            yus.query(".year", this, true).name,
            yus.query(".month", this, true).name,
            yus.query(".day", this, true).name
          );
        });
      },
      
      getHandler : function(e) {
          var targetEl = yue.getTarget(e);
          tokens = targetEl.id.split('-');
          if (tokens.length > 1)
            return [tokens[0], zct.capitalize(tokens[1])].join('');
          else
            return tokens[0];
      },

      computeScope : function(form) {
        if (form.id.split('-')[1] === "account") return zcv.scope.OUTSIDE;
        var allEmpty = true;
        var subScopes = yud.getElementsByClassName("validation-scope", null, form);
        zct.each(subScopes, function() {
          var inputs = yud.getElementsBy(function(el) {
            if (zct.inArray(el.nodeName, ["INPUT", "SELECT", "TEXTAREA"]) > -1 && zct.inArray(el.type, ["submit", "hidden"]) == -1)
              return true;
            else
              return false;
          }, null, this);
          zct.each(inputs, function() {
            if (zct.inArray(this.type, ["checkbox", "radio"]) != -1) {
              allEmpty = allEmpty && !this.checked;
            } else {
              allEmpty = allEmpty && (zct.val(this) === "");
            }
          });
        });
        if (!allEmpty) return zcv.scope.IGNORE;
        return zcv.scope.OUTSIDE;
      },

      submitStep : function(e) { validateAndSubmit(e, zcf.RequestCreation.computeScope(yue.getTarget(e).form)); },

      submitCollectionAdd : function(e) { validateAndSubmit(e, zcv.scope.INSIDE); },

      submitCollectionModify : function(e) { validateAndSubmit(e, zcv.scope.INSIDE); },

      formatField : function(e) {
        var targetEl = yue.getTarget(e);
        if (!zct.nodeName(targetEl,'input') || targetEl.type != 'text')
          return;
        
        var fieldType = /validate-(\w+)/i.exec(targetEl.className);
        if (fieldType) {
          if (fieldType[1] === 'lastName') targetEl.value = targetEl.value.toUpperCase();
          else if (fieldType[1] === 'city') targetEl.value = targetEl.value.toUpperCase();
          else if (fieldType[1] === 'firstName') targetEl.value = zct.capitalize(targetEl.value);
          else if (fieldType[1] === 'phone') zcf.RequestCreation.formatPhone(e);
          else if (fieldType[1] === 'mobilePhone') zcf.RequestCreation.formatPhone(e);
        }
      },
      formatPhone : function(e) {
        var targetEl = yue.getTarget(e);
        targetEl.value = targetEl.value.replace(/[^\d]/g, "");
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
      },

      dateChange : function(e) {
        adaptDateDays(yud.getAncestorByTagName(yue.getTarget(e), "div"));
      }
    };
    
  }();
  
  yue.onDOMReady(zcf.RequestCreation.init);
  
}());

