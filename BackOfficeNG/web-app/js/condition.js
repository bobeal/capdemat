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
    
    var listenerDisplay = function (listenerEl, displayStyle) {
      if (listenerEl.tagName === 'dl'.toUpperCase()) {
        yud.setStyle(listenerEl, 'display', displayStyle);
        yud.setStyle(yud.getPreviousSibling(listenerEl), 'display', displayStyle);
      }
      else if (listenerEl.tagName === 'dt'.toUpperCase())
        yud.setStyle(yud.getAncestorByTagName(listenerEl, 'dl'), 'display', displayStyle);
    }
    
    return {
      triggers : undefined,
      filleds : undefined,
      unfilleds : undefined,
      
      init : function() { 
      },
      
      run : function(e) {
          console.log('zcb.Condition.run');
          
          zcb.Condition.getTriggers(e);
          
          var j = 0; zct.each(zcb.Condition.triggers, function(){return j++});
          if (j > 0) {
            zcc.doAjaxCall(
              '/condition/'
               + '?triggers='+ ylj.stringify(zcb.Condition.triggers),
              null,
              function(o) {
                var json = ylj.parse(o.responseText);
                if (json.test) {
                  zcb.Condition.display(zcb.Condition.filleds);
                  zcb.Condition.hide(zcb.Condition.unfilleds);
                } else {
                  zcb.Condition.hide(zcb.Condition.filleds);
                  zcb.Condition.display(zcb.Condition.unfilleds);
                }
              });
          }
      },
      
      getTriggers : function(e) {
          zcb.Condition.triggers = {};
          var targetEl = yue.getTarget(e);
          var currentDdEl = yud.getAncestorByTagName(targetEl, 'dd');
          
          var dtTriggers;
          zct.each (yud.getPreviousSibling(currentDdEl).className.split(' '), function() {
            if (this.indexOf('-trigger') != -1) {
              dtTriggers = yud.getElementsByClassName(this, null, 'requestData');
              zcb.Condition.getFilleds(this.replace('-trigger', '-filled'));
              zcb.Condition.getUnfilleds(this.replace('-trigger', '-unsfilled'));
            }
          });
          
          if (yl.isUndefined(dtTriggers))
            return;
          
          zct.each (dtTriggers, function() {
            var ddEl = yud.getNextSibling(this);
            var value;
            if (ddEl.id === currentDdEl.id)
              value = currentTriggerValue(ddEl);
            else 
              value = triggerValue(ddEl);
            
            zcb.Condition.triggers[ddEl.id] = value;
          });
      },
      
      getFilleds : function(condition) {
          zcb.Condition.filleds = yud.getElementsByClassName(condition, null, 'requestData');
      },
      
      getUnfilleds : function(condition) {
          zcb.Condition.unfilleds = yud.getElementsByClassName(condition, null, 'requestData');
      },
      
      display : function(elArray) {
          zct.each(elArray, function() {
            listenerDisplay(this, 'block');
          });
      },
      
      hide : function (elArray) {
          zct.each(elArray, function() {
            listenerDisplay(this,  'none');
          });
      }
      
    };
    
  }();
  
}());
