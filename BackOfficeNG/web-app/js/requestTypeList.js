(function(){

  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var zct = zenexity.capdemat.tools;
  zct.namespace("zenexity.capdemat.bong.requestType");
  var zcbrt = zenexity.capdemat.bong.requestType;

  zcbrt.list = function() {

    var filterListRequestType = function(filterType) {
      yud.get('filterBy').value = yud.get('filterBy').value + 
        '@' + filterType + '=' + yud.get(filterType).value;                
      yud.get('requestTypeListFilters').submit();
    };
      
    return {
      init: function() {
        yue.addListener("requestTypeListFilters", "change", 
          function(e) {
            filterListRequestType(yue.getTarget(e).id);
          }
        );
      }
    }; 
  }();

  yue.onDOMReady(zcbrt.list.init);
}());
