zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.request.External');
(function() {
  var zcb = zenexity.capdemat.bong;
  var zcbre = zcb.request.External;
  var zcbri = zcb.request.Information;
  zcbre.Edemande = function() {
    return {
      init : function() {
        zcbri.addTab('Edemande', '/externalHistory?label=Edemande&id=' + zcb.requestId, false, false);
      }
    };
  }();
  YAHOO.util.Event.onDOMReady(zcbre.Edemande.init);
}());