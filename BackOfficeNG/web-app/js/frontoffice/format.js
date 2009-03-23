(function() {
  var zcf = zenexity.capdemat.fong;
  var yue = YAHOO.util.Event;
  var yl = YAHOO.lang;
  
  zcf.Format = function() {
    
    var doFormat = function(type, o) {   
      if (type == "lastName")
        uppercase(o)    	
      else if (type == "firstName")
        firstupper(o)
      else if (type == "city")
    	uppercase(o) 
    }
    
    var uppercase = function(o) {
  	  o.value = o.value.toUpperCase();
    }
    
    var firstupper = function(o) {
      o.value = o.value.slice(0,1).toUpperCase() + o.value.slice(1)
    }
    
    return {  
      
      format : function(e) {
        var targetEl = yue.getTarget(e);
    	var trigger = /validate-(\w+)/i.exec(targetEl.className);
    	if (!yl.isNull(trigger))
    	  doFormat(trigger[1], targetEl) 
      }
    };
    
  }();
  
  yue.addListener('requestTabView', 'change', zcf.Format.format);
  
}());
