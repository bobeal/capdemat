(function(){
  var zcb = zenexity.capdemat.bong;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  zcb.agentEdit = function() {
    return {
      init : function() {
        zct.doAjaxCall(
          "/categories/?id=" + zcb.agentId + "&scope=Agent",
          [zcb.agentId],
          function(o) {
            yud.get('agentCategories').innerHTML = o.responseText;
          });
        yue.on("agentId", "change", zcb.agentEdit.changeAgent);
      },
      changeAgent : function() {
        yud.get("agentId").form.submit();
      }
    };
  }();
  YAHOO.util.Event.onDOMReady(zcb.agentEdit.init);
}());
