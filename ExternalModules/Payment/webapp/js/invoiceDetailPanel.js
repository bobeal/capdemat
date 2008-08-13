var invoiceDetailPanel;

function displayInvoiceDetailPanel(o) {
	var resultData = eval('('+o.responseText+')');
	if (invoiceDetailPanel != null) {
		invoiceDetailPanel.hide();
		invoiceDetailPanel.destroy();
		document.body.removeChild(document.getElementById('_yuiResizeMonitor'));
	}
	invoiceDetailPanel = 
		new YAHOO.widget.Panel(o.argument[0] + "Panel", 
			{ close:true, visible:false, draggable:true, constraintoviewport:true, monitorresize:true,
				context:[o.argument[1],"tl","bl"] } ); 
	invoiceDetailPanel.setHeader(document.getElementById('invoicePanelBodyHeader').innerHTML 
		+ " " + o.argument[0]);
	var panelBody = '<table><tr>' 
		+ '<th>' + document.getElementById('invoicePanelBodyTableHeaderLabel').innerHTML + '</th>'
		+ '<th>' + document.getElementById('invoicePanelBodyTableHeaderSubject').innerHTML + '</th>'
		+ '<th>' + document.getElementById('invoicePanelBodyTableHeaderUnitPrice').innerHTML + '</th>'
		+ '<th>' + document.getElementById('invoicePanelBodyTableHeaderQuantity').innerHTML + '</th>'
		+ '<th>' + document.getElementById('invoicePanelBodyTableHeaderValue').innerHTML + '</th></tr>';
	for (var i = 0; i < resultData.length; i++) {
		var invoiceDetail = resultData[i];
		var rowClass;
		if (i % 2 == 0)
			rowClass = 'even';
		else
			rowClass = 'odd';
		var invoiceRow = '<tr class="' + rowClass + '">'
			+ '<td>' + invoiceDetail.label + '</td>'
			+ '<td>' + invoiceDetail.subject + '</td>'
			+ '<td>' + invoiceDetail.unitPrice + '</td>'
			+ '<td>' + invoiceDetail.quantity + '</td>'
			+ '<td>' + invoiceDetail.value + '</td>'
			+ '</tr>';
		panelBody += invoiceRow;
	}
	invoiceDetailPanel.setBody(panelBody);
	invoiceDetailPanel.setFooter('');
	invoiceDetailPanel.render(document.body);
	invoiceDetailPanel.show();
}

function loadInvoiceDetails(baseUrl, invoiceId, extFamilyAccountId, extAppId, elementDestId) {
	var url = baseUrl
		+ '?action=loadInvoiceDetails'
		+ '&invoiceId=' + invoiceId
		+ '&externalFamilyAccountId=' + extFamilyAccountId
		+ '&externalApplicationId=' + extAppId;
	var callback = {
		success: displayInvoiceDetailPanel,
		argument: [invoiceId, elementDestId]
	};
	var transaction = YAHOO.util.Connect.asyncRequest('GET', url, callback, null);
}
