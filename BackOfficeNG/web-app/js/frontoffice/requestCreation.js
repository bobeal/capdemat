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
    
    // hack to append submit input as hidden
    var addSubmitAsHidden = function (submitEl) {
      var submitAsHiddenEl = document.createElement("input");
      submitAsHiddenEl.type = 'hidden';
      submitAsHiddenEl.name = submitEl.name;
      submitAsHiddenEl.value = submitEl.value;
      var fromYuiEl = new yu.Element(submitEl.form);
      fromYuiEl.appendChild(submitAsHiddenEl);
    };

    var validateAndSubmit = function (e) {
      yue.preventDefault(e);
      var targetEl = yue.getTarget(e);
      if (!zcv.check(e, yud.get(targetEl.form.getAttribute('id') + '-error'))) {
        if (!zcf.RequestCreation.requestTypeModule
            || !zcf.RequestCreation.requestTypeModule.displayErrorMsg)
          zct.html(yud.get(targetEl.form.getAttribute('id') + '-error'), 'Des champs obligatoires ne sont pas correctement remplis, merci de v&eacute;rifier les champs en rouge');
        yud.addClass(yus.query("#request form")[0], 'invalid');
        yud.addClass(yus.query("#request div.steps li.current")[0], 'invalid');
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
      requestTypeModule: undefined,
      clickEvent : undefined,
      requestFormTabView : undefined,
      
      init : function() {
        var subjectSelect = yud.get("subjectId");
        if (subjectSelect) {
          zct.each([["Adult", "Nouvel adulte"], ["Child", "Nouvel enfant"], ["Subject", "Nouveau sujet"]], function() {
            if (yud.get("add" + this[0] + "Link")) {
              var option = document.createElement("option");
              option.text = this[1];
              option.value = "";
              option.id = "addSubject";
              option.name = this[0];
              subjectSelect.add(option, null);
            }
          });
        }
        zcf.RequestCreation.clickEvent = new zct.Event(zcf.RequestCreation, zcf.RequestCreation.getHandler);
        yue.on('request','click', zcf.RequestCreation.clickEvent.dispatch, zcf.RequestCreation.clickEvent, true);
        
        yue.on('request','keyup',zcf.RequestCreation.formatField);
        yue.on(yus.query("#request .validate-phone"), "keyup", zcf.RequestCreation.formatPhone);
        yue.on(yus.query("#request .date .month, #request .date .year"), "change", zcf.RequestCreation.dateChange);
        yue.on(yus.query("#request .validate-mobilePhone"), "keyup", zcf.RequestCreation.formatPhone);
        
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
        
        initCustomJS();
        zcf.Condition.init();
        zcf.RequestCreation.resizeDatasBloc();
      },
      
      getHandler : function(e) {
          var targetEl = yue.getTarget(e);
          tokens = targetEl.id.split('-');
          if (tokens.length > 1)
            return [tokens[0], zct.capitalize(tokens[1])].join('');
          else
            return tokens[0];
      },

      // FIXME: deprecated
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

      nextStep : function(e) { validateAndSubmit(e); },
      previousStep : function(e) { validateAndSubmit(e); },
      collectionSave : function(e) { validateAndSubmit(e); },

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
      dateChange : function(e) {
        adaptDateDays(yud.getAncestorByTagName(yue.getTarget(e), "div"));
      },
      resizeDatasBloc : function () {
        var steps = yus.query("#request div.steps")[0];
        var datasForm = yus.query("#request form")[0];
        if (datasForm.offsetHeight < steps.offsetHeight + 20)
          yud.setStyle(datasForm, 'min-height', steps.offsetHeight + 20 + 'px');
      },
      addSubject : function(e) {
        window.location.href = yud.get("add" + yue.getTarget(e).name + "Link").href;
      }
    };
    
  }();
  
  yue.onDOMReady(zcf.RequestCreation.init);
  
}());

