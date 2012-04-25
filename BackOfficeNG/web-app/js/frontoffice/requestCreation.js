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
      var formErrorId = targetEl.form.getAttributeNode("id").value + "-error";
      if (!zcv.check(e, yud.get(formErrorId))) {
        if (!zcf.RequestCreation.requestTypeModule
            || !zcf.RequestCreation.requestTypeModule.displayErrorMsg)
          zct.html(yud.get(formErrorId), 'Des champs obligatoires ne sont pas correctement remplis, merci de v&eacute;rifier les champs en rouge');
        yud.addClass(yus.query("#request div.form")[0], 'invalid');
        yud.addClass(yus.query("#request div.steps li.current")[0], 'invalid');
        return;
      }
      else {
        // -- hack to know current step
        addSubmitAsHidden(targetEl);
        
        targetEl.form.submit();
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
        var subjectSeparatorAdded = false;
        zcf.RequestCreation.clickEvent = new zct.Event(zcf.RequestCreation, zcf.RequestCreation.getHandler);
        yue.on('request','click', zcf.RequestCreation.clickEvent.dispatch, zcf.RequestCreation.clickEvent, true);
        
        var requestNote = yud.get("requestNote");
        if (requestNote != null) {
          yue.on(yud.get("requestNote"), 'keyup', function(e) {
            zct.limitArea("requestNote", 1024, "requestNoteLimit");
          });
          zct.limitArea("requestNote", 1024, "requestNoteLimit");
        }
        zct.each(yus.query("#request div.date"), function() {
          zcv.complexRules["dateWidget"].pushFields(
            yus.query(".day", this, true).name,
            yus.query(".month", this, true).name,
            yus.query(".year", this, true).name
          );
        });
        
        initCustomJS();
        zcf.Condition.init();
        zcf.RequestCreation.resizeDatasBloc();
      },
      
      getHandler : function(e) {
          var targetEl = yue.getTarget(e);
          var tokens = targetEl.id.split('-');
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
      resizeDatasBloc : function () {
        var steps = yus.query("#request div.steps")[0];
        var datas = yus.query("#request div.form")[0];
        if (datas.offsetHeight < steps.offsetHeight + 20)
          yud.setStyle(datas, 'min-height', steps.offsetHeight + 20 + 'px');
      },
      addSubject : function(e) {
        window.location.href = yud.get("add" + yue.getTarget(e).name + "Link").href;
      }
    };
    
  }();
  
  yue.onDOMReady(zcf.RequestCreation.init);
  
}());

