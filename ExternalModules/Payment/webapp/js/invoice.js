function buildComplementaryQueryString() {
	var id = document.getElementById('id').value;
	var label = document.getElementById('label').value;
	var paymentDateStart = document.getElementById('paymentDateStart').value;
	var paymentDateEnd = document.getElementById('paymentDateEnd').value;
	var efaId = document.getElementById('efaId').value;
	var externalApplicationId = document.getElementById('externalApplicationId').value;
	var broker = document.getElementById('broker').value;

	return "&action=loadInvoices" + 
		"&id=" + id +	"&label=" + label +
		"&paymentDateStart=" + paymentDateStart +
		"&paymentDateEnd=" + paymentDateEnd +
		"&efaId=" + efaId + "&externalApplicationId=" + externalApplicationId +
		"&broker=" + broker;
}

function reloadInvoices() {
	reloadServerSideJsonTable(buildComplementaryQueryString, "invoiceId");
}

function loadInvoices() {

	var formatInvoicePanelLink = function(elCell, oRecord, oColumn, oData) {
		var invoiceId = oRecord.getData("invoiceId");
		var detailLoaderUrl = YAHOO.payment_module.baseUrl + "management/detailLoader.jsp";
		elCell.innerHTML = "<a href='javascript:void(0);' onclick=\"loadInvoiceDetails('" 
				+ detailLoaderUrl + "','" + invoiceId + "','" + oRecord.getData("externalFamilyAccountId") + "','" 
				+ oRecord.getData("externalApplicationId") + "','" + invoiceId + "');return false;\">" + invoiceId 
			+ "</a>"
			+ "<div class='panelContainer' id='" + invoiceId + "'></div>";
	};
	
	// TODO : reactivate
	var formatEfaIdLink = function(elCell, oRecord, oColumn, oData) {
		var idTab = oData.split('+');
		//elCell.innerHTML = "<a href='<c:url value='/familyaccount/search.jsp?efaId=" + idTab[0] 
		//	+ "&externalApplicationId=" + idTab[1] + "'/>' >" + idTab[0] + "</a>";
		elCell.innerHTML = idTab[0];
	};
	
	var formatDate = function(elCell, oRecord, oColumn, oData) {
		if (oData != null && oData != '')
			elCell.innerHTML = oData.day + '/' + (oData.month + 1) + '/' + (oData.year);
		else
			elCell.innerHTML = '';
	};
	
	var formatInvoicePaid = function(elCell, oRecord, oColumn, oData) {
		if (oData == true)
			elCell.innerHTML = 	document.getElementById('faCommonYes').innerHTML;
		else
			elCell.innerHTML = 	document.getElementById('faCommonNo').innerHTML;
	};
	
    var myColumnDefs = [
		{key:"invoiceId", sortable:true, formatter:formatInvoicePanelLink, 
			label:document.getElementById('invTableId').innerHTML},
        {key:"invoiceLabel", label:document.getElementById('invTableLabel').innerHTML},
        {key:"invoiceValue", label:document.getElementById('invTableValue').innerHTML},
        {key:"invoicePaymentDate", sortable:true, formatter:formatDate,
           	label:document.getElementById('invTablePaymentDate').innerHTML},
        {key:"invoicePaid", formatter:formatInvoicePaid,
           	label:document.getElementById('invTablePaid').innerHTML},
        {key:"paymentAck", label:document.getElementById('invTablePaymentAck').innerHTML},
        {key:"broker", label:document.getElementById('invTableBroker').innerHTML},
        {key:"externalFamilyAccountId", sortable:true, formatter:formatEfaIdLink,
           	label:document.getElementById('invTableEfaId').innerHTML},
        {key:"externalApplicationLabel", 
           	label:document.getElementById('invTableExternalApplicationLabel').innerHTML}
    ];
	
	var initialRequest = "action=loadInvoices"; 
	var initialSortKey = "invoiceId";
	var controllerUrl = "management/invoice.jsp?";
	var resultsList = "invoiceList";
	var fields = ["invoiceId","invoiceLabel","invoiceValue", "invoicePaymentDate", "invoicePaid", 
	              "paymentAck", "broker", "externalFamilyAccountId", "externalApplicationLabel", 
	              "externalApplicationId"];

	loadServerSideJsonTable(buildComplementaryQueryString, myColumnDefs, initialRequest, initialSortKey,
		controllerUrl, resultsList, fields);
}

function initInvoice() {
	YAHOO.payment_module.calendar.cal = new Array(2);
	YAHOO.util.Event.onDOMReady(YAHOO.payment_module.calendar.init, 
														{id : 0, label : "paymentDateStart"});
	YAHOO.util.Event.onDOMReady(YAHOO.payment_module.calendar.init, 
														{id : 1, label : "paymentDateEnd"});
	
	var oSubmitButton1 = new YAHOO.widget.Button('wrappedSubmit', {type:'button'});
	oSubmitButton1.on("click", reloadInvoices);
	
	loadInvoices();
}

YAHOO.util.Event.onDOMReady(initInvoice);
