(function() {
  var zcf = zenexity.capdemat.fong;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  
  zcf.Condition = function() {
  
    var reset = function() {
       zcf.Condition.triggers = [];
       zcf.Condition.filleds = [];
       zcf.Condition.unfilleds = [];
       zcf.Condition.filledDescendants = [];
       zcf.Condition.unfilledDescendants = [];
    }
  
    var getTriggerEls = function (triggerClassName) {
      var triggerEls = []
      zct.each (yud.getElementsByClassName(triggerClassName, null, 'requestTabView'), function() {
        if (zct.nodeName(this, 'input') && this.type === 'radio') {
          if (this.checked)
            triggerEls.push(this);
        } else
            triggerEls.push(this);       
      });
      return triggerEls;
    }
    
    var getTriggerValue = function (triggerEl) {
      if (zct.nodeName(triggerEl,'select') || yud.hasClass(triggerEl, 'validate-one-required'))
        return triggerEl.value.split('_')[1] || "";
      else
        return triggerEl.value || "";
    }
    
    var getRequestTypeLabel = function () {
      var inputEl = yud.get('requestTypeInfo');
      return ylj.parse(yl.trim(inputEl.value.replace(/\n/g,''))).label;
    }
    
    var setDisabled = function (controlEl, active) {
      if (zct.nodeName(controlEl, 'div'))
        zct.each(yud.getChildren(controlEl), function() { setDisabled(this, active) });
        
      if (!(zct.nodeName(controlEl, 'input') || zct.nodeName(controlEl, 'textarea') || zct.nodeName(controlEl, 'select')))
        return;
      controlEl.disabled = active;
    }
    
    var listenerSwitch = function (listenerEl, active) {
      active ? yud.removeClass(listenerEl, 'unactive') : yud.addClass(listenerEl, 'unactive');
      setDisabled(listenerEl, !active);
    }
    
    var getDescendants = function(listenerEls) {
      var descendants = [];
      var addChildren = function(listenerEls) {
        var children = [];
        zct.each(listenerEls, function() {
          var trigger = /condition-(\w+)-trigger/i.exec(this.className);
          if (!yl.isNull(trigger)) {
            this.value = "";
            children = children.concat(yud.getElementsByClassName(
                trigger[0].replace('-trigger', '-filled'), null, 'requestTabView'));
            children = children.concat(yud.getElementsByClassName(
                trigger[0].replace('-trigger', '-unfilled'), null, 'requestTabView'));
          }
        });
        descendants = descendants.concat(children);
        if (children.length > 0)
          addChildren(children);
      }
      addChildren(listenerEls);
      return descendants;
    }
    
        
    return {
      /* type triggers = [json{requestField : value}, json{requestField : value}, json{requestField : value} ... ] 
       * triggers[n] affects filled[n], unfilled[n], and idescendants[n]
       */
      triggers : undefined,
      
      /* type = [<htlmEl>[], <htlmEl>[], <htlmEl>[] ... ] */
      filleds : undefined,
      unfilleds : undefined,
      
      /* type idescendants = type filled
       * allow to manage indirect decendant chaining
       */
      filledDescendants : undefined,
      unfilledDescendants : undefined,
      
      init : function() {
          reset();
          zcf.Condition.setAll();
          zcf.Condition.test();
      },
      
      run : function(e) {
          reset();
          zcf.Condition.set(e);
          zcf.Condition.test();
      },
      
      test : function() {
          zct.each(zcf.Condition.triggers, function(i) {
            zct.doAjaxCall(
                '/condition/?requestTypeLabel=' + getRequestTypeLabel() + '&triggers='+ ylj.stringify(this),
                null,
                function(o) {
                  var json = ylj.parse(o.responseText);
                  if (json.test) {
                    zcf.Condition.active(zcf.Condition.filleds[i]);
                    zcf.Condition.unactive(zcf.Condition.unfilleds[i]);
                    zcf.Condition.unactive(zcf.Condition.unfilledDescendants[i]);
                  } else {
                    zcf.Condition.unactive(zcf.Condition.filleds[i]);
                    zcf.Condition.unactive(zcf.Condition.filledDescendants[i]);
                    zcf.Condition.active(zcf.Condition.unfilleds[i]);
                  }
                });
           });
      },
      
      setAll : function() {
          var conditionTriggers = {};
          var controlEls = [];
          controlEls = controlEls.concat(yus.query('input', 'requestTabView'));
          controlEls = controlEls.concat(yus.query('select', 'requestTabView'));
          controlEls = controlEls.concat(yus.query('textarea', 'requestTabView'));
          zct.each (controlEls, function() {
            var trigger = /condition-(\w+)-trigger/i.exec(this.className);
            if (!yl.isNull(trigger))
              conditionTriggers[trigger[0]] = trigger[0]; 
          });
          zct.each (conditionTriggers, function() {
            zcf.Condition.addTriggers(this.split('-')[1], getTriggerEls(this), null);
          });
      },
      
      set : function(e) {
          var targetEl = yue.getTarget(e);
          var trigger = /condition-(\w+)-trigger/i.exec(targetEl.className);
          if (!yl.isNull(trigger))
            zcf.Condition.addTriggers(trigger[1], getTriggerEls(trigger[0]), null);
      },
      
      /*
       * Specific current trigger element isn't usefull in FrontOffice request creation from
       * TODO - Modify zcf.condition.js API or call addTriggers() with the two fisrt params only
       */
      addTriggers : function (conditionName, triggerEls, currentTriggerEl) {
          if (!yl.isUndefined(triggerEls) && triggerEls.length > 0) {
            var jsonTrigger = {};
            zct.each (triggerEls, function() {
              jsonTrigger[this.name] = getTriggerValue(this);
            });
            zcf.Condition.triggers.push(jsonTrigger);
            zcf.Condition.addFilleds(['condition', conditionName, 'filled'].join('-'));
            zcf.Condition.addUnfilleds(['condition', conditionName, 'unfilled'].join('-'));
          }
      },
      
      addFilleds : function(condition) {
          zcf.Condition.filleds.push(yud.getElementsByClassName(condition, null, 'requestTabView'));
          zcf.Condition.filledDescendants.push(getDescendants(
                  yud.getElementsByClassName(condition, null, 'requestTabView')));
      },
      
      addUnfilleds : function(condition) {
          zcf.Condition.unfilleds.push(yud.getElementsByClassName(condition, null, 'requestTabView'));
          zcf.Condition.unfilledDescendants.push(getDescendants(
                  yud.getElementsByClassName(condition, null, 'requestTabView')));
      },
      
      active : function(elArray) {
          zct.each(elArray, function() { listenerSwitch(this, true); });
      },
      
      unactive : function (elArray) {
          zct.each(elArray, function() { listenerSwitch(this, false); });
      }
      
    };
    
  }();
  
  yue.addListener('requestTabView', 'change', zcf.Condition.run);
  yue.onDOMReady(zcf.Condition.init);
  
}());
