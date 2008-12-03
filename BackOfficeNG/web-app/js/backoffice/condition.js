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
    }
  
    var currentTriggerValue = function (ddEl) {
      var formEl = yud.getLastChild(ddEl);
      if (yud.hasClass(ddEl,'validate-capdematEnum'))
        return formEl[ddEl.id].value.split('_')[1];
      else
        return formEl[ddEl.id].value;
    }
    
    var triggerValue = function (ddEl) {
      if (yud.hasClass(ddEl,'validate-capdematEnum'))
        return yud.getFirstChild(ddEl).className.split(' ')[0];
      else
        return yl.trim(yud.getFirstChild(ddEl).innerHTML);
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
      
      /* type unfilles = type filled */
      unfilleds : undefined,
      
      init : function() {
          reset();
          zcb.Condition.setAll();
          zcb.Condition.test();
      },
      
      run : function(e) {
          reset();
          zcb.Condition.set(e);
          zcb.Condition.test();
      },
      
      test : function() {
          zct.each(zcb.Condition.triggers, function(i) {
            zcc.doAjaxCall(
                '/condition/?triggers='+ ylj.stringify(this),
                null,
                function(o) {
                  var json = ylj.parse(o.responseText);
                  if (json.test) {
                    zcb.Condition.active(zcb.Condition.filleds[i]);
                    zcb.Condition.unactive(zcb.Condition.unfilleds[i]);
                  } else {
                    // Not tested
                    // zcb.Condition.addFilledsDescendants();
                    zcb.Condition.unactive(zcb.Condition.filleds[i]);
                    zcb.Condition.active(zcb.Condition.unfilleds[i]);
                  }
                });
           });
      },
      
      setAll : function() {
          var conditionTriggers = {};
          zct.each (yus.query('dt', 'requestData'), function() {
            var trigger = /condition-(\w+)-trigger/i.exec(this.className);
            if (!yl.isNull(trigger))
              conditionTriggers[trigger[0]] = trigger[0]; 
          });
          
          zct.each (conditionTriggers, function() {
            zcb.Condition.addTriggers(
                this.split('-')[1],
                yud.getElementsByClassName([this], null, 'requestData'), 
                null);
          });
      },
      
      set : function(e) {
          var targetEl = yue.getTarget(e);
          var currentDdEl = yud.getAncestorByTagName(targetEl, 'dd');
          var dtTriggers;
          var trigger = /condition-(\w+)-trigger/i
              .exec(yud.getPreviousSibling(currentDdEl).className);
          if (!yl.isNull(trigger)) {
            dtTriggers = yud.getElementsByClassName(trigger[0], null, 'requestData');
            zcb.Condition.addTriggers(trigger[1], dtTriggers, currentDdEl);
          }
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
              
              jsonTrigger[ddEl.id] = value;
            });
            zcb.Condition.triggers.push(jsonTrigger);
            zcb.Condition.addFilleds(['condition', conditionName, 'filled'].join('-'));
            zcb.Condition.addUnfilleds(['condition', conditionName, 'unfilled'].join('-'));
          }
      },
      
      addFilleds : function(condition) {
          zcb.Condition.filleds.push(yud.getElementsByClassName(condition, null, 'requestData'));
      },
      
      addUnfilleds : function(condition) {
          zcb.Condition.unfilleds.push(yud.getElementsByClassName(condition, null, 'requestData'));
      },
      
//      addFilledsDescendants : function() {
//          var descendants = [];
//          
//          var recursion = function(listenerEls) {
//            var childs = [];
//            zct.each(listenerEls, function() {
//              var trigger = /condition-(\w+)-trigger/i.exec(this.className);
//              if (!yl.isNull(trigger)) {
//                childs = childs.concat(yud.getElementsByClassName(
//                    tirgger[0].replace('-trigger', '-filled'), null, 'requestData'));
//                childs = childs.concat(yud.getElementsByClassName(
//                    tirgger[0].replace('-trigger', '-unfilled'), null, 'requestData'));
//              }
//            });
//            descendants = descendants.concat(childs);
//            if (childs.length > 0)
//              recursion(childs);
//          }
//          
//          recursion(zcb.Condition.filleds);
//          filleds = filleds.concat(descendants);
//      },
//      
//      addUnfilledsDescendants : function() {
//          zcb.Condition.unfilleds;
//      },
      
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
