(function(){
  var zcb = zenexity.capdemat.bong;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  
  zcb.userEdit = function() {
	  
    var userId;
	  
	// Create our custom event and listeners to handle category selection
	zcb.userSelectedEvent = new YAHOO.util.CustomEvent('userSelectedEvent');
	zcb.userSelectedEvent.subscribe(loadUserCategories);
	  
	function loadUserCategories() {
	  zct.doAjaxCall(
	      "/categories/?id=" + userId + "&scope=User",
	      [userId],
	      function(o) {
	        yud.get('userCategories').innerHTML = o.responseText;
	      });
	}
	  
	return { 
	  init : function() {
	    userId = zcb.userId;
	    zcb.userSelectedEvent.fire();
	  } 
	};
	
  }();
	  
  YAHOO.util.Event.onDOMReady(zcb.userEdit.init);
  
}());