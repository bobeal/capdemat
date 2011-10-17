(function() {
  var zcb = zenexity.capdemat.bong;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yud = YAHOO.util.Dom;
  var ylj = YAHOO.lang.JSON;
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  
  zcb.Condition = function() {
    
    var reset = function() {
       zcb.Condition.triggers = [];
       zcb.Condition.filleds = [];
       zcb.Condition.unfilleds = [];
       zcb.Condition.filledDescendants = [];
       zcb.Condition.unfilledDescendants = [];
    }
    
    var getTriggerEls = function (triggerClassName) {
      return yud.getElementsByClassName(triggerClassName, null, 'requestData');
    }
    
    var currentTriggerValue = function (ddEl) {
      var formEl = yud.getLastChild(ddEl);
      if (yud.hasClass(ddEl,'data-localReferentialData'))
        return formEl[ddEl.id + "[0].name"].value || '';
      if (yud.hasClass(ddEl,'validate-capdematEnum'))
        return formEl[ddEl.id].value || '';
      else if (yud.hasClass(ddEl,'validate-boolean')) {
        var value;
        zct.each(formEl[ddEl.id], function(){
          if (this.checked) value = this.value; 
        });
        return value || '';
      }
      return formEl[ddEl.id].value || '';
    }
    
    var isMultipleTrigger = function (triggerEl) {
      var triggerArray = triggerEl.className.match(/condition-(\w+)-trigger/ig);
      if (triggerArray.length > 1) return true;
      else return false;
    }
    
    var triggerValue = function (ddEl) {
      if (yud.hasClass(ddEl,'data-localReferentialData'))
        return yud.getFirstChild(ddEl).className.split(':')[1];
      if (yud.hasClass(ddEl,'validate-capdematEnum'))
        return yud.getFirstChild(ddEl).className.split(' ')[0];
      else if (yud.hasClass(ddEl,'validate-boolean'))
        return yud.getFirstChild(ddEl).className.split('-')[1];
      else
        return yl.trim(yud.getFirstChild(ddEl).innerHTML);
    }
    
    var getRequestTypeLabel = function () {
      return zct.html(yud.get('requestTypeLabel'));
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
      else if (action === yud.hasClass(listenerEl, 'not-action-editField')) {
          var listenerDdEl = yud.getNextSibling(listenerEl);
          zct.toggleClass(listenerEl,'not-action-editField');
          if (yud.hasClass(listenerDdEl, notActionClass))
            yud.replaceClass(listenerDdEl, notActionClass, actionClass);
      }
    }
    
    var getDescendants = function(listenerEls) {
      var descendants = [];
      var addChildren = function(listenerEls) {
        var children = [];
        zct.each(listenerEls, function() {
          var trigger = /condition-(\w+)-trigger/i.exec(this.className);
          if (!yl.isNull(trigger)) {
            children = children.concat(yud.getElementsByClassName(
                trigger[0].replace('-trigger', '-filled'), null, 'requestData'));
            children = children.concat(yud.getElementsByClassName(
                trigger[0].replace('-trigger', '-unfilled'), null, 'requestData'));
          }
        });
        descendants = descendants.concat(children);
        if (children.length > 0)
          addChildren(children);
      }
      addChildren(listenerEls);
      return descendants;
    }
    
    // Move to zct, or write a more generic version
    var isArrayEmpty = function (array) {
      if (array.join().replace(/,/g,'').length > 0)
        return false;
      else
        return true;
    }
    
    return {
      /* type triggers = [json{requestField : value}, json{requestField : value}, json{requestField : value} ... ] 
       * triggers[n] affects filled[n] and unfilled[n] 
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
          zcb.Condition.setAll();
          zcb.Condition.test();
      },
      
      // FIXME - poor solution that force a lot of http request to the server
      reInit : function() {
          if (!isArrayEmpty(zcb.Condition.filledDescendants.concat(zcb.Condition.unfilledDescendants))) {
            reset();
            zcb.Condition.setAll();
            zcb.Condition.test();
          }
      },
      
      run : function(e) {
          reset();
          if (zcb.Condition.set(e)) zcb.Condition.test();
      },
      
      test : function() {
        zct.val(yud.get('conditionsContainer'),ylj.stringify(zcb.Condition.triggers)||[]);
        zct.doAjaxFormSubmitCall('conditionsForm',[],function(o){
          var json = ylj.parse(o.responseText);
          zct.each(json,function(i){
            if (this.test) {
              zcb.Condition.active(zcb.Condition.filleds[i]);
              zcb.Condition.unactive(zcb.Condition.unfilleds[i]);
              zcb.Condition.unactive(zcb.Condition.unfilledDescendants[i]);
            } else {
              zcb.Condition.unactive(zcb.Condition.filleds[i]);
              zcb.Condition.unactive(zcb.Condition.filledDescendants[i]);
              zcb.Condition.active(zcb.Condition.unfilleds[i]);
            }
          });
        });
      },
      
      setAll : function() {
        zct.each (yus.query('dt', 'requestData'), function() {
          zct.each (this.className.split(' '), function() {
            var trigger = /condition-(\w+)-trigger/i.exec(this);
            if (trigger) zcb.Condition.addTriggers(trigger[1], getTriggerEls(trigger[0]));
          });
        });
      },
      
      set : function(e) {
        var targetEl = yue.getTarget(e);  
        var currentDdEl = yud.getAncestorByTagName(targetEl, 'dd');
        var hasTrigger = false
        zct.each (yud.getPreviousSibling(currentDdEl).className.split(' '), function() {
          var trigger = /condition-(\w+)-trigger/i.exec(this);
          if (trigger) {
            zcb.Condition.addTriggers(trigger[1], getTriggerEls(trigger[0]), currentDdEl);
            hasTrigger = true;
          }
        });
        return hasTrigger;
      },
      
      addTriggers : function (conditionName, triggerDtEls, currentDdEl) {
          if (!yl.isUndefined(triggerDtEls) && triggerDtEls.length > 0) {
            var jsonTrigger = {};
            zct.each (triggerDtEls, function() {
              var ddEl = yud.getNextSibling(this);
              var value;
              if (currentDdEl != null && ddEl.id === currentDdEl.id)
                value = currentTriggerValue(ddEl);
              else 
                value = triggerValue(ddEl);
              
              jsonTrigger[ddEl.id] = (isMultipleTrigger(this) ? conditionName + '=' : '') + value;
            });
            zcb.Condition.triggers.push(jsonTrigger);
            zcb.Condition.addFilleds(['condition', conditionName, 'filled'].join('-'));
            zcb.Condition.addUnfilleds(['condition', conditionName, 'unfilled'].join('-'));
          }
      },
      
      addFilleds : function(condition) {
          zcb.Condition.filleds.push(yud.getElementsByClassName(condition, null, 'requestData'));
          zcb.Condition.filledDescendants.push(getDescendants(
                  yud.getElementsByClassName(condition, null, 'requestData')));
      },
      
      addUnfilleds : function(condition) {
          zcb.Condition.unfilleds.push(yud.getElementsByClassName(condition, null, 'requestData'));
          zcb.Condition.unfilledDescendants.push(getDescendants(
                  yud.getElementsByClassName(condition, null, 'requestData')));
      },
      
      active : function(elArray) {
          zct.each(elArray, function() { listenerSwitch(this, true); });
      },
      
      unactive : function (elArray) {
          zct.each(elArray, function() { listenerSwitch(this, false); });
      }
      
    };
    
  }();
  
  yue.onDOMReady(zcb.Condition.init);
  
}());
