/**
 *  Client-side configuration module
 *  Creates richtext editor & button and interacts with the server
 * 
 *
 *  @author vba@zenexity.fr
 *
 **/

zenexity.capdemat.tools.namespace("zenexity.capdemat.bong.payment");

(function(){

  var zct = zenexity.capdemat.tools;
  var zcb = zenexity.capdemat.bong;
  var zcbet = zenexity.capdemat.bong.editor.toolbars;
  var zcbp = zenexity.capdemat.bong.payment;

  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var ylj = YAHOO.lang.JSON;

  zcbp.Config = function() {
    return {
      clickEv : undefined,
      editor : undefined,
      init : function() {
        zcbp.Config.loadBox("displayConfiguration");
        zcbp.Config.loadBox("deactivation");
        zcbp.Config.loadBox("displayedMessage");
        zcbp.Config.clickEv = new zct.Event(zcbp.Config,zcbp.Config.processClick);
        yue.on(yud.get("displayConfigurationBox"),'click',zcbp.Config.clickEv.dispatch,zcbp.Config.clickEv,true);
        yue.on(yud.get("deactivationBox"),'click',zcbp.Config.clickEv.dispatch,zcbp.Config.clickEv,true);
        yue.on(yud.get("displayedMessageBox"),'click',zcbp.Config.clickEv.dispatch,zcbp.Config.clickEv,true);
      },
      processClick : function(e) {
        return yue.getTarget(e).getAttribute("rel");
      },
      loadBox : function(boxName) {
        zct.doAjaxCall('/' + boxName, null, function(o){
          yud.get(boxName + "Box").innerHTML = o.responseText;
          if (boxName === "displayedMessage") {
            var ta = yud.get('editor');
            zcbp.Config.editor = new YAHOO.widget.SimpleEditor('editor', {
              focusAtStart: false,
              toolbar : zcbet.def,
              width: (zct.width(ta.parentNode)-5)+'px',
              height : '400px'
            });
            zcbp.Config.editor.render();
          } else if (boxName === "deactivation") {
            zcb.Calendar("paymentDeactivationStartDate");
            zcb.Calendar("paymentDeactivationEndDate");
          }
        });
      },
      toggleDeactivationDatesPanel : function(e) {
        var el = yue.getTarget(e);
        if (el.checked) {
          yud.removeClass("deactivationDatesPanel", "invisible");
        }
        else {
          yud.addClass("deactivationDatesPanel", "invisible");
        }
      },
      saveDisplayConfiguration : function(e) {
        zct.doAjaxFormSubmitCall(yue.getTarget(e).form.id, [], function(o){
          zct.Notifier.processMessage('success',ylj.parse(o.responseText).success_msg);
        });
      },
      saveActivation : function(e) {
        zct.doAjaxFormSubmitCall(yue.getTarget(e).form.id, [], function(o){
          zct.Notifier.processMessage('success',ylj.parse(o.responseText).success_msg);
        });
      },
      saveDisplayedMessage : function(e) {
        zcbp.Config.editor.saveHTML();
        zct.doAjaxFormSubmitCall('form1',[],function(r){
          zct.Notifier.processMessage('success',ylj.parse(r.responseText).success_msg);
        });
      }
    }
  }();

  yue.onDOMReady(zcbp.Config.init);

}());
