zenexity.capdemat.tools.namespace('zenexity.capdemat.fong.internal');

(function() {
  
  var zcfi = zenexity.capdemat.fong.internal;
  var zcf = zenexity.capdemat.fong;
  var zct = zenexity.capdemat.tools;
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
  var ylj = yl.JSON;
  
  /**
   * @description Gets "internal" type for passed element
   * 
   * @param el {HTMLElement} element to check
   */  
  zcfi.getType = function(el) {
    if(el.constructor == 'String') {
    	el = yus.query('#request [name=' + el + ']')[0];
    }
    if(/radio|checkbox/i.test(el.type)) { return el.type; }
    else if(zct.nodeName(el,'select')) { return 'select'; }
    else if(/text/i.test(el.type) || zct.nodeName(el,'textarea')) { return 'text'; }
    else { return undefined; }
  };
  zcfi.getByName = function(nm,tag,root) {
    var _r = root || yud.get('#request');
    return yud.getElementsBy(function(n){return n.name == nm;},tag,_r);
  };
  
  zcfi.radio = {
    getValue : function(nm) {
      var r = zct.grep(zcfi.getByName(nm,'input'), function(n) {return !!n.checked;});
      if (r.length > 0) { return zct.val(r[0]); }
    },
    setValue : function(nm, val) {
      zct.each(zcfi.getByName(nm,'input'), function() {
        this.checked = undefined;
        if (this.value === val) { this.checked = 'checked'; }
      });
    },
    empty : function(nm) {
      zct.each(zcfi.getByName(nm,'input'), function(){this.checked = undefined;});
    },
    isModified : function() {
      //Not implemented yet
      return false;
    }
  }; 
  
  zct.each(['select','text'],function(){
    zcfi[this+''] = {};
    zcfi[this+''].getValue = function(nm) {
      var el = zcfi.getByName(nm)[0];
      return zct.val(el);
    };
    zcfi[this+''].setValue = function(nm,val) {
      var el = zcfi.getByName(nm)[0];
      return zct.val(el,val);
    };
    zcfi[this+''].empty = function(nm) {
      var el = zcfi.getByName(nm)[0];
      if(el.selectedIndex) el.selectedIndex = 0; 
      else zct.val(el,'');
    };
  });
  
  zcfi.select.isModified = function(nm) {
    var el = zcfi.getByName(nm,'select')[0];
    return el.selectedIndex != 0;
  };
  
  zcfi.text.isModified = function(nm) {
    var el = zcfi.getByName(nm)[0];
    return yl.trim(zct.val(el)||'').length > 0;
  };
  
  zcf.Condition = function() {
    
    var reset = function() {
       zcf.Condition.triggers = [];
       zcf.Condition.filleds = [];
       zcf.Condition.unfilleds = [];
       zcf.Condition.filledDescendants = [];
       zcf.Condition.unfilledDescendants = [];
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
    
    var isMultipleTrigger = function (triggerEl) {
      var triggerArray = triggerEl.className.match(/condition-(\w+)-trigger/ig);
      if (triggerArray.length > 1) return true;
      else return false;
    };
    
    var getTriggerValue = function (triggerEl) {
      if (zct.nodeName(triggerEl,'select') && yud.hasClass(triggerEl, 'data-localReferentialData'))
        return triggerEl.value || "";
      if (zct.nodeName(triggerEl,'select')
        || (!yud.hasClass(triggerEl, 'boolean') && yud.hasClass(triggerEl, 'validate-one-required')))
        return triggerEl.value.split('_')[1] || "";
      else
        return triggerEl.value || "";
    };
    
    var setDisabled = function (controlEl, active) {
      if (zct.nodeName(controlEl, 'div'))
        zct.each(yud.getChildren(controlEl), function() { setDisabled(this, active); });
        
      if (!(zct.nodeName(controlEl, 'input') || zct.nodeName(controlEl, 'textarea') || zct.nodeName(controlEl, 'select')))
        return;
      controlEl.disabled = active;
    };
    
    var listenerSwitch = function (listenerEl, active) {
      
      if(active) yud.removeClass(listenerEl, 'unactive');
      else yud.addClass(listenerEl, 'unactive');
      
      //setDisabled(listenerEl, !active);
      zcf.Condition.restate(listenerEl,!active);
    };
    
    var getDescendants = function(listenerEls) {
      var descendants = [];
      var addChildren = function(listenerEls) {
        var children = [];
        zct.each(listenerEls, function() {
          var trigger = /condition-(\w+)-trigger/i.exec(this.className);
          if (!yl.isNull(trigger)) {
            // FIXME - stange idea. maybe want to reset all children values
            // this.value = "";
            children = children.concat(yud.getElementsByClassName(
                trigger[0].replace('-trigger', '-filled'), null, 'request'));
            children = children.concat(yud.getElementsByClassName(
                trigger[0].replace('-trigger', '-unfilled'), null, 'request'));
          }
        });
        descendants = descendants.concat(children);
        if (children.length > 0)
          addChildren(children);
      };
      addChildren(listenerEls);
      return descendants;
    };
    var initWidgets = function() {
      var content = {
        head : 'Attention',
        body : 'Vous risquez de perdre les données entrées'
      };
      zcf.Condition.confirmDialog = new zct.ConfirmationDialog(content,zcf.Condition.confirmRetain);
      zcf.Condition.confirmDialog.cfg.setProperty("draggable",true); 
    };
    var initElements = function() {
      zcf.Condition.triggered = {};
      var l = zct.grep(yus.query('#request [name]'),function(n){return n.className.indexOf('trigger') > -1;});
      zct.each(l,function(){
        var type = zcfi.getType(this);
        if(type && zcfi[type]) zcf.Condition.triggered[this.name] = zcfi[type].getValue(this.name);
      });
      
      //zcf.Condition.timerId = setInterval(zcf.Condition.watchTriggers,1000);
    };
        
    return {
      /* type triggers = [json{requestField : value}, json{requestField : value}, json{requestField : value} ... ] 
       * triggers[n] affects filled[n], unfilled[n], and idescendants[n]
       */
      initStates : undefined,
      triggers : undefined,
      triggered : undefined,
      confirmDialog : undefined,
      
      /* type = [<htlmEl>[], <htlmEl>[], <htlmEl>[] ... ] */
      filleds : undefined,
      unfilleds : undefined,
      
      /* type idescendants = type filled
       * allow to manage indirect decendant chaining
       */
      filledDescendants : undefined,
      unfilledDescendants : undefined,
      triggerValues: undefined,
      
      /* hack to save selectedIndexes of select elements
       * to avoid condition submission when their value doesn't change
       */
      selectValues : undefined,

      init : function() {
        initWidgets();
        initElements();
        zcf.Condition.retainStates();
        zcf.Condition.selectValues = {};

        reset();
        zcf.Condition.setAll();
        zcf.Condition.test(undefined,undefined,true);
        yue.on('request', 'change', zcf.Condition.run,zcf.Condition,true);
        yue.on('request', 'click', zcf.Condition.run,zcf.Condition,true);
      },
      run : function(e) {
        if(e) {
          var target = yue.getTarget(e);
          if(/submit|file/i.test(target.type)||!zct.isIn(target.nodeName,['select','input'])) return true;
          if( !zct.isIn(target.nodeName,['select','input','textarea'])) return yue.stopEvent(e);
          if(/radio|checkbox/i.test(target.type) && e.type == 'change') return yue.stopEvent(e);
          if(!/radio|checkbox/i.test(target.type) && e.type == 'click') {
            if (!/select/i.test(target.nodeName)) {
              return yue.stopEvent(e);
            }
            else {
              if (zcf.Condition.selectValues[target.name] == null) {
                zcf.Condition.selectValues[target.name] = target.selectedIndex;
                return yue.stopEvent(e);
              } else if (zcf.Condition.selectValues[target.name] != target.selectedIndex) {
                zcf.Condition.selectValues[target.name] = target.selectedIndex;
              } else {
                return yue.stopEvent(e);
              }
            }
          }
        }
        reset();
        if(zcf.Condition.set(e)) zcf.Condition.test(e,true);
      },
      test : function(e,confirm,init) {
        zct.val(yud.get('conditionsContainer'),ylj.stringify(zcf.Condition.triggers)||[]);
        var t = yue.getTarget(e||{target:undefined});
        zct.doAjaxFormSubmitCall('conditionsForm',[],function(o){
          var json = ylj.parse(o.responseText);
          zct.each(json,function(i,el){
            if(!el.test && !!confirm && zcf.Condition.checkChanges(i) && !yud.hasClass(zcf.Condition.filleds[i][0],'unactive')) {
              zcf.Condition.confirmDialog.triggerIndex = i;
              zcf.Condition.confirmDialog.triggerTarget = yue.getTarget(e);
              zcf.Condition.confirmDialog.triggerTargetValue = yue.getTarget(e).value; // hack RDJ
              zcf.Condition.confirmDialog.show(e);
              
              var v = zcf.Condition.triggered[t.name];
              zcfi[zcfi.getType(t)].setValue(t.name,v);
            }
            else {
              if(!!t) zcf.Condition.triggered[t.name] = zcfi[zcfi.getType(t)].getValue(t.name);
              zcf.Condition.fill(i,el.test,init);
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
        var hasTrigger = false;
        zct.each (targetEl.className.split(' '), function() {
          var trigger = /condition-(\w+)-trigger/i.exec(this);
          if (trigger) {
            zcf.Condition.addTriggers(trigger[1], getTriggerEls(trigger[0]));
            hasTrigger = true;
          }
        });
        return hasTrigger;
      },
      
      /*
       * Specific current trigger element isn't usefull in FrontOffice request creation from
       * TODO - Modify zcf.condition.js API or call addTriggers() with the two fisrt params only
       */
      addTriggers : function (conditionName, triggerEls) {
          if (!yl.isUndefined(triggerEls) && triggerEls.length > 0) {
            var jsonTrigger = {};
            zct.each (triggerEls, function() {
              if (yud.hasClass(this, 'data-localReferentialData')) {
                jsonTrigger[this.name.split('[')[0]] = (isMultipleTrigger(this) ? conditionName + '=' : '') + getTriggerValue(this);;
              } else {
                jsonTrigger[this.name] = (isMultipleTrigger(this) ? conditionName + '=' : '') + getTriggerValue(this);;
              }
            });
            zcf.Condition.triggers.push(jsonTrigger);
            zcf.Condition.addFilleds(['condition', conditionName, 'filled'].join('-'));
            zcf.Condition.addUnfilleds(['condition', conditionName, 'unfilled'].join('-'));
          }
      },
      
      addFilleds : function(condition) {
          zcf.Condition.filleds.push(yud.getElementsByClassName(condition, null, 'request'));
          zcf.Condition.filledDescendants.push(getDescendants(
                  yud.getElementsByClassName(condition, null, 'request')));
      },
      
      addUnfilleds : function(condition) {
          zcf.Condition.unfilleds.push(yud.getElementsByClassName(condition, null, 'request'));
          zcf.Condition.unfilledDescendants.push(getDescendants(
                  yud.getElementsByClassName(condition, null, 'request')));
      },
      /**
       * @description Checks if filled elements were modified
       * 
       * @param i {Number} Current trigger index
       */
      checkChanges : function(i) {
        var result = false, _t = zcfi.getType, _l = {};
        var list = zct.merge(zcf.Condition.filleds[i],zcf.Condition.filledDescendants[i]);
        
        zct.each(list, function() {
          var that = this, type = _t(this);
          if(type) {
            result = result || zcfi[type].isModified(this.name);
          } else if(zct.isIn(this.nodeName,['div','fieldset']) && (this.childNodes||[]).length > 0) {
            zct.each(yus.query('[name]',that),function(){
              if(_t(this) && this.name) result = result || zcfi[_t(this)].isModified(this.name);
            });
          }
        });
        return result;
      },
      /**
       * @description Confirmation handler, called if user confirm current operation
       * 
       */
      confirmRetain : function() {
        var i = zcf.Condition.confirmDialog.triggerIndex;
        if(typeof i != 'undefined') {
          zcf.Condition.fill(i,false);
          var t = zcf.Condition.confirmDialog.triggerTarget;
          var v = zcf.Condition.confirmDialog.triggerTargetValue; // hack RDJ
          zcfi[zcfi.getType(t)].setValue(t.name,v);
        }
      },
      /**
       * @description Fills? form fields
       * 
       * @param i trigger index
       * @param flag active/unactive flag
       * @param init intit contex indicator
       */
      fill : function(i,flag,init){
        zcf.Condition.process(zcf.Condition.filleds[i],!flag,init);
        zcf.Condition.process(zcf.Condition.unfilleds[i],flag,init);
        if(flag) zcf.Condition.process(zcf.Condition.unfilledDescendants[i],flag,init);
        else zcf.Condition.process(zcf.Condition.filledDescendants[i],!flag,init);
      },
      /**
       * @description Process event triggers and related html elements
       * 
       * @param list {Array} Related elements list
       * @param state {Boolean} Current state
       * @param init {Boolean} Initialization indicator
       */
      process : function(list,state,init) {
        var key1 = (state+'').toUpperCase();
        var map1 = {'TRUE': 'add','FALSE': 'remove'};
        
        zct.each(list,function(){
          yud[map1[key1]+'Class'](this, 'unactive');
          if(!init) zcf.Condition.restate(this,!state);
        });
      },
      /**
       * @description Restates(assigns default values or states) passed element/container
       * 
       * @param el {HTMLElement} DOM Element
       */
      restate: function(el) {
        var factor = zct.isIn(el.nodeName,['select','input','textarea']);
        if (!factor && (el.childNodes||[]).length == 0)  return false;
        if (!yud.hasClass(el, 'unactive')) return false; // hack RDJ

        if(zct.isIn(el.nodeName,['select','input','textarea'])) {
          zct.tryToCall(zcf.Condition['reset'+zct.capitalize(el.nodeName.toLowerCase())],zcf.Condition,el,'');
        } else {
          yud.getElementsBy(function(_el){
            return zct.isIn(_el.nodeName,['select','input','textarea']);
          },'',el,function(_el) {
            zct.tryToCall(zcf.Condition['reset'+zct.capitalize(_el.nodeName.toLowerCase())],zcf.Condition,_el,'');
          });
        }
      },
      /**
       * @description Retains initial values of forms elements
       */
      retainStates : function() {
        var states = zcf.Condition.initStates;
        if(!states) states = {};
        
        zct.each(yus.query('#request input[checked]'),function(){
          if(/radio|checkbox/i.test(this.type)) states[this.name] = this.checked;
        });
        zct.each(yus.query('#request select'),function(){states[this.name] = this.selectedIndex;});
        
        zcf.Condition.initStates = states;
      },
      /**
       * @description Resets default value to select elements
       * 
       * @param el {HTMLSelectElement} select to set default value
       */
      resetSelect : function(el) {
        var states = zcf.Condition.initStates;
        if(typeof states[el.name] != 'undefined') el.selectedIndex = 0; //states[el.name];
      },
      /**
       * @description Resets input elements value
       * 
       * @param el {HTMLInputElement} input to be set
       * @param val {Object} value
       */
      resetInput : function(el,val) {
        var states = zcf.Condition.initStates;
        if(/radio|checkbox/i.test(el.type)) {if(states[el.name]) el.checked = states[el.name];}
        else if(el.type != 'hidden')  zct.val(el,val);
      },
      /**
       * @description Resets textarea elements value
       * 
       * @param el {HTMLTextAreaElement} textarea to be set
       * @param val {Object} value
       */
      resetTextarea : function(el,val) {zct.val(el,val);}
    };
  }();
  
}());
