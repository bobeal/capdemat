function getXmlHttp() {
    var xmlhttp=false;
    /*@cc_on @*/
    /*@if (@_jscript_version >= 5)
    // JScript gives us Conditional compilation, we can cope with old IE versions.
    // and security blocked creation of the objects.
     try {
      xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
     } catch (e) {
      try {
       xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
      } catch (E) {
       xmlhttp = false;
      }
     }
    @end @*/
    if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
        try {
            xmlhttp = new XMLHttpRequest();
        } catch (e) {
            xmlhttp=false;
        }
    }
    if (!xmlhttp && window.createRequest) {
        try {
            xmlhttp = window.createRequest();
        } catch (e) {
            xmlhttp=false;
        }
    }
    return xmlhttp;
}

function sendRequest(action, parameters, data, async, fieResult, extraData) {
    xhr_object = getXmlHttp();
    if (!xhr_object) { // XMLHttpRequest non supporté par le navigateur
        alert("Votre navigateur ne supporte pas les objets XMLHTTPRequest...");
        return;
    }

	var url = action;
	if (url.indexOf("?") != -1) {
		url += "&" + parameters;
	} else {
		url += "?" + parameters;
	}
    xhr_object.open("POST", url, async);
	if (async)
	    xhr_object.onreadystatechange = function() {
	        if(xhr_object.readyState == 4) {
	        	if (xhr_object.status==200)
		            window.status = "Ok";

		        else if (xhr_object.status==404) 
		        	window.status = "URL: " + url + " doesn't exist!";
				else 
					window.status = "Status is " + xhr_object.status;

				if (fieResult != null)
		       		fieResult(xhr_object.status, xhr_object.responseText, extraData);
		    }
		}

    xhr_object.setRequestHeader("Content-type", "text/xml; charset=UTF-8");
    xhr_object.send(data);
	if (!async) {
        if(xhr_object.readyState == 4) {
        	if (xhr_object.status==200)
	            window.status = "Ok";

	        else if (xhr_object.status==404) 
	        	window.status = "URL: " + url + " doesn't exist!";
			else 
				window.status = "Status is " + xhr_object.status;

			if (fieResult != null) {
	       		fieResult(xhr_object.status, xhr_object.responseText, extraData);
			}
	    }
	}
}

if (typeof DOMParser == "undefined") { 
	DOMParser = function (){}
	
	DOMParser.prototype.parseFromString = function (str, contentType) {
		if (typeof ActiveXObject != "undefined") { 
			var d = new ActiveXObject("MSXML.DomDocument"); 
			d.loadXML(str); 
			return d; 
		} 
		else if (typeof XMLHttpRequest != "undefined") {
			var req = new XMLHttpRequest; 
			req.open("GET", "data:" + (contentType || "application/xml") +  
                                 ";charset=utf-8," + encodeURIComponent(str), false); 
			if (req.overrideMimeType) { 
				req.overrideMimeType(contentType); 
			} 
			req.send(null); 
			return req.responseXML; 
		} 
	} 
}

