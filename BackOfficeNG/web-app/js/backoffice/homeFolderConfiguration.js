zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.homeFolder');
(function() {
  var zcbhf = zenexity.capdemat.bong.homeFolder;
  var yw = YAHOO.widget;
  var zct = zenexity.capdemat.tools;
  var zcv = zenexity.capdemat.Validation;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var ylj = YAHOO.lang.JSON;

  zcbhf.Configuration = function() {

    return {
      clickEv: undefined,

      init: function() {
        zcbhf.Configuration.tabView = new yw.TabView('configuration');
        zcbhf.Configuration.clickEv = new zct.Event(zcbhf.Configuration, zcbhf.Configuration.processClick);
        yue.on(yud.get('configuration'), 'click', zcbhf.Configuration.clickEv.dispatch, zcbhf.Configuration.clickEv, true);
      },

      processClick: function(e) {
        return yue.getTarget(e).id;
      },

      independentCreationInput: function(e) {
        var cont = yud.get("independentCreationErrors");
        cont.innerHTML = "";
        if (zcv.check(yud.get("independentCreationForm"), cont)) {
          var target = yue.getTarget(e);
          zct.doAjaxFormSubmitCall("independentCreationForm", [], function(o) {
            zct.Notifier.processMessage('success', ylj.parse(o.responseText).success_msg, yud.get('notification'), target);
          });
        }
      }
    }
  }();
  YAHOO.util.Event.onDOMReady(zcbhf.Configuration.init);
}()
);