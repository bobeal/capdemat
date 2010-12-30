zenexity.capdemat.tools.namespace("zenexity.capdemat.bong.homeFolder");
(function(){
  var ylj = YAHOO.lang.JSON;
  var yu = YAHOO.util;
  var yue = yu.Event;
  var yud = yu.Dom;
  var yus = yu.Selector;
  var yw = YAHOO.widget;
  var zcb = zenexity.capdemat.bong;
  var zcbh = zcb.homeFolder;
  var zct = zenexity.capdemat.tools;
  zcbh.Import = function() {
    return {
      init: function() {
        yue.on(yud.get("uploadDocument"), "click",  zcbh.Import.upload);
      },
      upload : function(e) {
        yue.stopEvent(e);
        yue.removeListener(yud.get("uploadDocument"), "click",  zcbh.Import.upload);
        var target = yue.getTarget(e);
        zct.doAjaxFormSubmitCall("fileForm", null, function(o) {
          var response = ylj.parse(o.responseText);
          if (response.status === "ok") {
            zct.Notifier.processMessage("success", ylj.parse(o.responseText).success_msg, null, target);
          } else {
            zct.Notifier.processMessage("modelError", ylj.parse(o.responseText).error_msg);
          }
          yue.on(yud.get("uploadDocument"), "click",  zcbh.Import.upload);
        }, true);
      }
    };
  }();
  yue.onDOMReady(zcbh.Import.init);
}());
