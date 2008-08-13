function updateExtAppBrokersList(extAppBrokersList) {
	var extAppBrokerIdElement = document.getElementById('externalApplicationBroker');
	extAppBrokerIdElement.parentNode.removeChild(extAppBrokerIdElement);
	if (extAppBrokersList == null || extAppBrokersList.length == 0) {
		var extAppBrokerInput = document.createElement("input");
		extAppBrokerInput.setAttribute("id", "externalApplicationBroker");
		extAppBrokerInput.setAttribute("name", "externalApplicationBroker");
		extAppBrokerInput.setAttribute("type", "text");
		YAHOO.util.Dom.insertAfter(extAppBrokerInput, 
			document.getElementById('externalApplicationBrokerLabel'));
	} else {
		var extAppBrokerSelect = document.createElement('select');
		extAppBrokerSelect.setAttribute("id", "externalApplicationBroker");
		extAppBrokerSelect.setAttribute("name", "externalApplicationBroker");
		for (var i = 0; i < extAppBrokersList.length; i++) {
			var extAppBroker = extAppBrokersList[i];
			var optionExtAppBroker = document.createElement("option");
			optionExtAppBroker.setAttribute("value", extAppBroker.broker);
			optionExtAppBroker.innerHTML = extAppBroker.broker;
			extAppBrokerSelect.appendChild(optionExtAppBroker);
		}
		YAHOO.util.Dom.insertAfter(extAppBrokerSelect, 
			document.getElementById('externalApplicationBrokerLabel'));
	}
}

function updateExtAppBrokersCallback(o) {
	var resultData = YAHOO.lang.JSON.parse(o.responseText);
	updateExtAppBrokersList(resultData.brokers);
	updateBrokersState();
}

function loadExternalApplicationBrokers(callUrl) {

	var extAppId = document.getElementById('externalApplicationId');
	var url = callUrl 
		+ '?action=loadExternalApplicationBrokers'
		+ '&externalApplicationId=' + extAppId.value;
	var callback = {
		success: updateExtAppBrokersCallback
	}
	var transaction = YAHOO.util.Connect.asyncRequest('GET', url, callback, null);
} 
    
function updateBrokersState() {
	if (document.getElementById('dataType').value == 'external-family-account') {
		document.getElementById('externalApplicationBroker').disabled = true;	
	} else {
		document.getElementById('externalApplicationBroker').disabled = false;			
	}
}

function submitSaveExternalImportForm(ev) {
	document.getElementById('externalImportForm').submit()
}
      
function initButton() {
  	var submitSaveExternalImportButton = new YAHOO.widget.Button("submitSaveExternalImport");
   	submitSaveExternalImportButton.on("click", FIC_checkForm, 
       	document.getElementById('externalImportFormError'));
   	submitSaveExternalImportButton.on("click", submitSaveExternalImportForm);
}

YAHOO.util.Event.onDOMReady(initButton);
