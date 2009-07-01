/**
 * @description Client side form autofill implementation
 *
 * @author (Jean-Sébastien Bour) jsb@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.fong');

(function() {
  var zcf = zenexity.capdemat.fong;
  var zct = zenexity.capdemat.tools;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
  var yl = YAHOO.lang;
  var ylj = yl.JSON;
  
  zcf.Autofill = function() {
	  
    var reset = function() {
      zcf.Autofill.listeners = {};
      zcf.Autofill.fields = {};
    };
    
    return {
      listeners : undefined,
      fields : undefined,
      init : function() {
        reset();
        yue.on('requestTabView', 'change', zcf.Autofill.fill, zcf.Autofill, true);
        yue.on('requestTabView', 'click', zcf.Autofill.fill, zcf.Autofill, true);
      },
      fill : function(e) {
        if(e) {
          var target = yue.getTarget(e);
          if( !zct.isIn(target.nodeName,['select','input','textarea'])) return yue.stopEvent(e);
          if(/radio|checkbox/i.test(target.type) && e.type == 'change') return yue.stopEvent(e);
          if(!/radio|checkbox|select/i.test(target.type) && e.type == 'click') return yue.stopEvent(e);
        }
        reset();
        var target = yue.getTarget(e);
        var trigger = /autofill-(\w+)-trigger/i.exec(target.className);
        if (trigger && target.value !== "") {
          zct.val(yud.get("triggerName"), target.name);
          zct.val(yud.get("triggerValue"), zct.val(target));
          var regexp = new RegExp("autofill-" + trigger[1] + "-listener-(\\w+)", "i");
          zct.each(yus.query('#requestTabView [name], #requestTabView div [class]'), function() {
            var listener = regexp.exec(this.className);
            if (listener) {
              if (zct.inArray(this.tagName, ["INPUT", "SELECT", "TEXTAREA"]) == -1) {
                var complexElementChildren = yud.getChildrenBy(this, function(element) { return zct.inArray(element.tagName, ["INPUT", "SELECT", "TEXTAREA"]) >= 0; });
                zct.each(
                  complexElementChildren,
                  function(child) {
                    if (zcf.Autofill.listeners[this.name] === undefined) {
                      zcf.Autofill.listeners[this.name] = [];
                    }
                    zcf.Autofill.listeners[this.name].push(complexElementChildren[child]);
                    zcf.Autofill.fields[this.name] = listener[1] + "." + this.name.split('.')[1];
                });
              } else {
                if (zcf.Autofill.listeners[this.name] === undefined) {
                  zcf.Autofill.listeners[this.name] = [];
                }
                zcf.Autofill.listeners[this.name].push(this);
                zcf.Autofill.fields[this.name] = listener[1];
              }
            }
          });
          zct.val(yud.get('autofillContainer'), ylj.stringify(zcf.Autofill.fields)||[]);
          zct.doAjaxFormSubmitCall('autofillForm', [], function(o){
            zct.each(ylj.parse(o.responseText), function(i, el) {
              zct.each(zcf.Autofill.listeners[i], function(j) {
                zct.val(zcf.Autofill.listeners[i][j], el);
              });
            });
          });
        }
      }
    };
  }();
  yue.onDOMReady(zcf.Autofill.init);
}());
