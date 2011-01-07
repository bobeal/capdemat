zenexity.capdemat.tools.namespace("zenexity.capdemat.bong.users");
(function(){
  var zct = zenexity.capdemat.tools;
  var zcbu = zenexity.capdemat.bong.users;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var ylj = YAHOO.lang.JSON;
  zcbu.MeansOfContact = function() {
    var splitEvent = function(e) {
      return (yue.getTarget(e).id||'_').split('_')[1];
    };
    return {
      clickEv : undefined,
      init : function() {
        zcbu.MeansOfContact.clickEv = new zct.Event(zcbu.MeansOfContact,zcbu.MeansOfContact.processClick);
        yue.on(yud.get("meansOfContactBox"),"click",zcbu.MeansOfContact.clickEv.dispatch,zcbu.MeansOfContact.clickEv,true);
        zcbu.MeansOfContact.loadMoCs();
      },
      processClick : function(e) {
        var target  = yue.getTarget(e);
        return (target.id||'_').split('_')[0];
      },
      loadMoCs : function() {
        var cont = yud.get("listContainer");
        zct.doAjaxCall("/moCs", null, function(o) {
          cont.innerHTML = o.responseText;
        });
      },
      saveMoC : function(e) {
        var target  = yue.getTarget(e);
        zct.doAjaxFormSubmitCall(splitEvent(e) + "Form",[], function(o){
          zct.Notifier.processMessage("success", ylj.parse(o.responseText).success_msg, null, target);
          zcbu.MeansOfContact.loadMoCs();
        });
      },
    }
  }();
  yue.onDOMReady(zcbu.MeansOfContact.init);
}());
