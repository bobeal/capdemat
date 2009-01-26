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
    
    var triggerValue = function (triggerEl) {
      if (zct.nodeName(triggerEl,'select') || yud.hasClass(triggerEl, 'validate-one-required'))
        return triggerEl.value.split('_')[1] || "";
      else
        return triggerEl.value || "";
    }
    
    var listenerSwitch = function (listenerEl, action) {
      var actionClass = action ? 'action-editField' : 'not-action-editField';
      var notActionClass = action ? 'not-action-editField' : 'action-editField';
      
      if (listenerEl.tagName === 'dl'.toUpperCase() && action === yud.hasClass(listenerEl, 'not-action-editField')) {
        zct.toggleClass(listenerEl,'not-action-editField');
        zct.each(yus.query('dt', listenerEl), function(){
          zct.toggleClass(this,'not-action-editField');
        });
        zct.each(yus.query('dd', listenerEl), function(){
          if (yud.hasClass(this, notActionClass))
            yud.replaceClass(this, notActionClass, actionClass);
        });
      }
      else if (listenerEl.tagName === 'dt'.toUpperCase() && action === yud.hasClass(listenerEl, 'not-action-editField')) {
          var listenerDdEl = yud.getNextSibling(listenerEl);
          zct.toggleClass(listenerEl,'not-action-editField');
          if (yud.hasClass(listenerDdEl, notActionClass))
            yud.replaceClass(listenerDdEl, notActionClass, actionClass);
      }
    }
    
    return {
      /* type triggers = [json{requestField : value}, json{requestField : value}, json{requestField : value} ... ] 
       * triggers[n] affects filled[n] and unfilled[n] 
       */
      triggers : undefined,
      
      /* type filled = [<htlmEl>[], <htlmEl>[], <htlmEl>[] ... ] */
      filleds : undefined,
      
      /* type unfilleds = type filled */
      unfilleds : undefined,
      
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
                '/condition/?triggers='+ ylj.stringify(this),
                null,
                function(o) {
                  var json = ylj.parse(o.responseText);
                  if (json.test) {
                    zcf.Condition.active(zcf.Condition.filleds[i]);
                    zcf.Condition.unactive(zcf.Condition.unfilleds[i]);
                  } else {
                    zcf.Condition.unactive(zcf.Condition.filleds[i]);
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
              jsonTrigger[this.name] = triggerValue(this);
            });
            zcf.Condition.triggers.push(jsonTrigger);
            zcf.Condition.addFilleds(['condition', conditionName, 'filled'].join('-'));
            zcf.Condition.addUnfilleds(['condition', conditionName, 'unfilled'].join('-'));
          }
      },
      
      addFilleds : function(condition) {
          zcf.Condition.filleds.push(yud.getElementsByClassName(condition, null, 'requestTabView'));
      },
      
      addUnfilleds : function(condition) {
          zcf.Condition.unfilleds.push(yud.getElementsByClassName(condition, null, 'requestTabView'));
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
