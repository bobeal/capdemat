zenexity.capdemat.tools.namespace('zenexity.capdemat.fong');
(function() {
  var zcf = zenexity.capdemat.fong;
  var zct = zenexity.capdemat.tools;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
  var ylj = YAHOO.lang.JSON;
  zcf.Autofill = function() {
    var reset = function() {
      zcf.Autofill.listeners = [];
      zcf.Autofill.fields = [];
    };
    return {
      listeners : undefined,
      fields : undefined,
      init : function() {
        reset();
        yue.on('requestTabView', 'change', zcf.Autofill.fill, zcf.Autofill, true);
      },
      fill : function(e) {
        reset();
        var target = yue.getTarget(e);
        var trigger = /autofill-(\w+)-trigger/i.exec(target.className);
        if (trigger && target.value != "") {
          zct.val(yud.get("triggerName"), target.name);
          zct.val(yud.get("triggerValue"), zct.val(target));
          var regexp = new RegExp("autofill-" + trigger[1] + "-listener-(\\w+)", "i");
          zct.each(yus.query('#requestTabView [name]'), function() {
            var listener = regexp.exec(this.className);
            if (listener) {
              zcf.Autofill.listeners.push(this);
              zcf.Autofill.fields.push(listener[1]);
            }
          });
          zct.val(yud.get('autofillContainer'), ylj.stringify(zcf.Autofill.fields)||[]);
          zct.doAjaxFormSubmitCall('autofillForm', [], function(o){
            zct.each(ylj.parse(o.responseText), function(i, el) {
              zct.val(zcf.Autofill.listeners[i], el);
            });
          });
        }
      }
    };
  }();
  yue.onDOMReady(zcf.Autofill.init);
}());