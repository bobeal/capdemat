(function(){
  var zcb = zenexity.capdemat.bong;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  
  zcb.agentEdit = function() {
	  
    var agentId;
	  
	// Create our custom event and listeners to handle category selection
	zcb.agentSelectedEvent = new YAHOO.util.CustomEvent('agentSelectedEvent');
	zcb.agentSelectedEvent.subscribe(loadAgentCategories);
	  
	function loadAgentCategories() {
	  zct.doAjaxCall(
	      "/categories/?id=" + agentId + "&scope=Agent",
	      [agentId],
	      function(o) {
	        yud.get('agentCategories').innerHTML = o.responseText;
	      });
	}
	  
	return { 
	  init : function() {
	    agentId = zcb.agentId;
	    zcb.agentSelectedEvent.fire();
	  } 
	};
	
  }();
	  
  YAHOO.util.Event.onDOMReady(zcb.agentEdit.init);
  
}());