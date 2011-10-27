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
    };

    var getTriggerEls = function (triggerClassName) {
      var triggerEls = [];
      zct.each (yud.getElementsByClassName(triggerClassName, null, 'request'), function() {
        if (zct.nodeName(this, 'input') && this.type === 'radio') {
          if (this.checked)
            triggerEls.push(this);
        } else
            triggerEls.push(this);       
      });
      return triggerEls;
    };

    var getTriggerValue = function (triggerEl) {
        return triggerEl.value || "";
    };

    var isMultipleTrigger = function (triggerEl) {
      var triggerArray = triggerEl.className.match(/condition-(\w+)-trigger/ig);
      if (triggerArray.length > 1) return true;
      else return false;
    };

    var setDisabled = function (controlEl, active) {
      if((controlEl.nodeName == "INPUT" || controlEl.nodeName == "SELECT" || controlEl.nodeName == "TEXTAREA")) {
          controlEl.disabled = active;
      }
      else {
      yud.getElementsBy(
                function(el){
                    return (el.nodeName == "INPUT" || el.nodeName == "SELECT" || el.nodeName == "TEXTAREA");
                },
                null,
                controlEl,
                function(el){
                    el.disabled = active;
                }
                );
      }
    };

    var listenerSwitch = function (listenerEl, active) {
      active ? yud.removeClass(listenerEl, 'unactive') : yud.addClass(listenerEl, 'unactive');
      setDisabled(listenerEl, !active);
    };

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
          if (!zcf.Condition.triggers.length) return;
          zcf.Condition.test();
          yue.on(yus.query('select', 'request'), 'change', zcf.Condition.run, zcf.Condition, true);
          //IE5-8 change event is buggy on checkboxes and radios, we have to use the click event.
          yue.on(yus.query('input[type="checkbox"]', 'request'), 'click', zcf.Condition.run, zcf.Condition, true);
          yue.on(yus.query('input[type="radio"]', 'request'), 'click', zcf.Condition.run, zcf.Condition, true);
      },
      
      run : function(e) {
          reset();
          zcf.Condition.set(e);
          if (!zcf.Condition.triggers.length) return;
          zcf.Condition.test();
      },
      
      test : function() {
          zct.val(yud.get('conditionsContainer'),ylj.stringify(zcf.Condition.triggers)||[]);
          zct.doAjaxFormSubmitCall('conditionsForm',[],function(o) {
              var json = ylj.parse(o.responseText);
              zct.each(json,function(i,el){
                  if (el.test) {
                    zcf.Condition.active(zcf.Condition.filleds[i]);
                    zcf.Condition.unactive(zcf.Condition.unfilleds[i]);
                  } else {
                    zcf.Condition.unactive(zcf.Condition.filleds[i]);
                    zcf.Condition.active(zcf.Condition.unfilleds[i]);
                  }
              });
              zcf.RequestCreation.resizeDatasBloc(); // hack RDJ
          });
      },
      
      setAll : function() {
          var named = yus.query('#request [name]');
          zct.each (named, function() {
              zct.each (this.className.split(' '), function() {
                var trigger = /condition-(\w+)-trigger/i.exec(this);
                if (trigger) zcf.Condition.addTriggers(trigger[1], getTriggerEls(trigger[0]));
              });
          });
      },

      set : function(e) {
        var targetEl = yue.getTarget(e);
        zct.each (targetEl.className.split(' '), function() {
          var trigger = /condition-(\w+)-trigger/i.exec(this);
          if (trigger) {
            zcf.Condition.addTriggers(trigger[1], getTriggerEls(trigger[0]));
          }
        });
      },

      /*
       * Specific current trigger element isn't useful in FrontOffice request creation from
       * TODO - Modify zcf.condition.js API or call addTriggers() with the two fisrt params only
       */
      addTriggers : function (conditionName, triggerEls, currentTriggerEl) {
          if (!yl.isUndefined(triggerEls) && triggerEls.length > 0) {
            var jsonTrigger = {};
            zct.each (triggerEls, function() {
              if (yud.hasClass(this, 'data-localReferentialData')) {
                jsonTrigger[this.name.split('[')[0]] = (isMultipleTrigger(this) ? conditionName + '=' : '') + getTriggerValue(this);
              } else {
                //.replace(/\[\d*\]/, '') is for conditions in collection items.
                jsonTrigger[this.name.replace(/\[\d*\]/, '')] = (isMultipleTrigger(this) ? conditionName + '=' : '') + getTriggerValue(this);
              }
            });
            zcf.Condition.triggers.push(jsonTrigger);
            zcf.Condition.addFilleds(['condition', conditionName, 'filled'].join('-'));
            zcf.Condition.addUnfilleds(['condition', conditionName, 'unfilled'].join('-'));
          }
      },
      
      addFilleds : function(condition) {
          zcf.Condition.filleds.push(yud.getElementsByClassName(condition, null, 'request'));
      },
      
      addUnfilleds : function(condition) {
          zcf.Condition.unfilleds.push(yud.getElementsByClassName(condition, null, 'request'));
      },
      
      active : function(elArray) {
          zct.each(elArray, function() { listenerSwitch(this, true); });
      },
      
      unactive : function (elArray) {
          zct.each(elArray, function() { listenerSwitch(this, false); });
      }
      
    };
    
  }();

}());
