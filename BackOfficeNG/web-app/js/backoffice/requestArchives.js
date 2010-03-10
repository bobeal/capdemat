zenexity.capdemat.tools.namespace("zenexity.capdemat.bong.request");

(function(){

  var zct = zenexity.capdemat.tools;
  var zcb = zenexity.capdemat.bong;
  var zcbr = zenexity.capdemat.bong.request;
  var zcv = zenexity.capdemat.Validation;

  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var ylj = YAHOO.lang.JSON;
  var yw = YAHOO.widget;

  zcbr.Archives = function() {
    var form = undefined;
    var errorsContainer = undefined;
    var tabView = undefined;
    return {
      clickEv : undefined,
      content : undefined,
      deleteErrorMessage  :undefined,
      init : function() {
        form = yud.get("form");
        errorsContainer = yud.get("errorsContainer");
        tabView = new yw.TabView();
        tabView.addTab(new yw.Tab({
          label : "Historique",
          dataSrc : zenexity.capdemat.baseUrl + "/history",
          cacheData: true, active: true
        }));
        tabView.appendTo("archivesHistory");
        zcbr.Archives.clickEv = new zct.Event(zcbr.Archives, zcbr.Archives.processClick);
        yue.on(yud.get("archivesList"), "click", zcbr.Archives.clickEv.dispatch, zcbr.Archives.clickEv, true);
      },
      processClick : function(e) {
        var target  = yue.getTarget(e);
        return (target.id||'_').split('_')[0];
      },
      switchSelection : function(e) {
        zct.each(
          YAHOO.util.Selector.query("input[type=checkbox]"),
          function(i, el) {
            el.checked = !el.checked;
          }
        );
      },
      download : function(e) {
        if (zcv.check(e, errorsContainer)) {
          form.submit();
          zcbr.Archives.refreshTab("Historique");
        }
      },
      remove : function(e) {
        if (zcv.check(e, errorsContainer)) {
          new zct.ConfirmationDialog(zcbr.Archives.content, function() {
            var target = yue.getTarget(e);
            var action = form.action;
            form.action = zenexity.capdemat.baseUrl + "/deleteArchives";
            zct.doAjaxFormSubmitCall(form.getAttribute("id"), null, function(o) {
              var response = ylj.parse(o.responseText);
              zct.each(YAHOO.util.Selector.query("input[type=checkbox]:checked"), function(i, el) {
                if (!response.failures || !zct.isIn(el.value, response.failures))
                  form.removeChild(yud.get(el.value));
              });
              if (response.status === "success") {
                zct.Notifier.processMessage('success', response.success_msg, null, target);
              } else {
                zct.Notifier.processMessage('unexpectedError',
                  zcbr.Archives.deleteErrorMessage + '\n' + response.failures.join('\n'));
              }
              zcbr.Archives.refreshTab("Historique");
              form.action = action;
            });
          }).show(e);
        }
      },
      refreshTab : function(label) {
        zct.each(tabView.get("tabs"), function() {
          if (this.get("label") == label) {
            var cacheData = this.get("cacheData");
            var contentVisible = this.get("contentVisible");
            this.set("cacheData", false);
            this.set("contentVisible", false);
            this.set("contentVisible", true);
            this.set("contentVisible", contentVisible);
            this.set("cacheData", cacheData);
          }
        }, null);
      }
    };
  }();

  yue.onDOMReady(zcbr.Archives.init);

}());
