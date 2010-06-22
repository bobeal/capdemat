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
        yue.on('stepForm', 'change', zcf.Autofill.fill, zcf.Autofill, true);
        yue.on('stepForm', 'click', zcf.Autofill.fill, zcf.Autofill, true);
      },
      fill : function(e) {
        if(e) {
          var target = yue.getTarget(e);
          if(/submit|file/i.test(target.type)||!zct.isIn(target.nodeName,['select','input'])) return true;
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
          zct.each(yus.query('#stepForm [name], #stepForm div [class]'), function() {
            var listener = regexp.exec(this.className);
            if (listener) {
              if (zct.inArray(this.tagName, ["INPUT", "SELECT", "TEXTAREA"]) == -1) {
                if (/date/.test(this.className)) {
                  zct.each(yud.getChildrenBy(this, function(element) { return true; }),
                    function(i, child) {
                      var fieldName = this.name.split('_')[0];
                      /*
                       * bootstrap generic autocomplete information on the first widget input
                       * (we needed an input to know the whole date name)
                       */
                      if (i === 0) {
                        /*
                         * only add the whole date field name, to only ask once for the date
                         * the server-side autocomplete service knows that it has to answer
                         * the three fields separately
                         */
                        zcf.Autofill.fields[fieldName] = listener[1];
                        /*
                         * register an empty listener array for the whole date name :
                         * if the date doesn't exist, the server can't know it is a date, and it
                         * will answer null for the whole date name, like a generic text field
                         */
                        zcf.Autofill.listeners[fieldName] = [];
                      }
                      /*
                       * now, register the listeners for each part of the date the server will answer
                       */
                      var fieldPart = this.className.split(/\s+/)[0];
                      if (zcf.Autofill.listeners[fieldName + "." + fieldPart] === undefined) {
                        zcf.Autofill.listeners[fieldName + "." + fieldPart] = [];
                      }
                      zcf.Autofill.listeners[fieldName + "." + fieldPart].push(child);
                    }
                  );
                } else {
                  var complexElementChildren = yud.getChildrenBy(this, function(element) { return zct.inArray(element.tagName, ["INPUT", "SELECT", "TEXTAREA"]) >= 0; });
                  zct.each(
                    complexElementChildren,
                    function(child) {
                      if (zcf.Autofill.listeners[this.name] === undefined) {
                        zcf.Autofill.listeners[this.name] = [];
                      }
                      zcf.Autofill.listeners[this.name].push(complexElementChildren[child]);
                      zcf.Autofill.fields[this.name] = listener[1] + "." + this.name.split(/[\._]/)[1];
                  });
                }
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
