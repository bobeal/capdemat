zenexity.capdemat.tools.namespace('zenexity.capdemat.bong');
(function() {
  var zcb = zenexity.capdemat.bong;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var options = {
    close : true
  };
  zcb.Calendar = function(label) {
    var field = yud.get(label);
    var container = yud.get(label + "CalContainer");
    var trigger = yud.get(label + "Show");
    var show = function() {
      update();
      yud.setStyle(container, 'display','block');
      yud.setStyle(container, 'z-index','10');
      var pos = yud.getXY(trigger);
      pos[1] += trigger.offsetHeight + 1;
      yud.setXY(container, pos);
    };
    var fill = function(type, args, obj) {
      var year = args[0][0][0];
      var month = args[0][0][1];
      if (month < 10) month = '0' + month;
      var day = args[0][0][2];
      if (day < 10) day = '0' + day;
      var textValue = [day, month, year].join('/');
      if (Date != null && zct.isFunction(Date.parseExact)) {
        textValue = Date.parseExact(textValue, "dd/MM/yyyy")
          .toString(Date.CultureInfo.formatPatterns.shortDate);
      }
      zct.val(field, textValue);
      cal.hide();
    };
    var update = function() {
      var textValue = zct.val(field);
      if (Date != null && zct.isFunction(Date.parse)) {
        var date = Date.parse(textValue);
        if (date) {
          textValue = date.toString("MM/dd/yyyy");
          cal.setMonth(parseInt(date.toString("MM"), 10) - 1);
          cal.setYear(parseInt(date.toString("yyyy"), 10));
        }
      }
      if (textValue && textValue != "") {
        cal.select(textValue);
        cal.render();
      }
    };
    var cal = new YAHOO.widget.Calendar(label + "Cal", container, options);
    cal.selectEvent.subscribe(fill, cal, true);
    update();
    cal.render();
    yue.on(trigger, "click", show);
  }
}());
