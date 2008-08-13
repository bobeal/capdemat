var accountDetailPanel;

function displayAccountDetailPanel(o) {
	var resultData = eval('('+o.responseText+')');
	if (accountDetailPanel != null) {
		accountDetailPanel.hide();
		accountDetailPanel.destroy();
		document.body.removeChild(document.getElementById('_yuiResizeMonitor'));
	}
	accountDetailPanel = 
		new YAHOO.widget.Panel(o.argument[0] + "Panel", 
			{ close:true, visible:false, draggable:true, constraintoviewport:true, monitorresize:true,
				context:[o.argument[1],"tl","bl"] } ); 
	accountDetailPanel.setHeader(document.getElementById('accountPanelBodyHeader').innerHTML 
		+ " " + o.argument[0]);
	var panelBody = '<table><tr>' 
		+ '<th>' + document.getElementById('accountPanelBodyTableHeaderSubject').innerHTML + '</th>'
		+ '<th>' + document.getElementById('accountPanelBodyTableHeaderDate').innerHTML + '</th>'
		+ '<th>' + document.getElementById('accountPanelBodyTableHeaderValue').innerHTML + '</th>'
		+ '<th>' + document.getElementById('accountPanelBodyTableHeaderPaymentType').innerHTML + '</th>'
		+ '<th>' + document.getElementById('accountPanelBodyTableHeaderPaymentAck').innerHTML + '</th>'
		+ '<th>' + document.getElementById('accountPanelBodyTableHeaderCvqAck').innerHTML + '</th></tr>';
	for (var i = 0; i < resultData.length; i++) {
		var accountDetail = resultData[i];
		var rowClass;
		if (i % 2 == 0)
			rowClass = 'even';
		else
			rowClass = 'odd';
		var accountRow = '<tr class="' + rowClass + '">'
			+ '<td>' + accountDetail.subject + '</td>'
			+ '<td>' + accountDetail.date.day + '/' + (accountDetail.date.month + 1) + '/' + (accountDetail.date.year) + '</td>'
			+ '<td>' + accountDetail.value + '</td>'
			+ '<td>' + accountDetail.paymentType + '</td>'
			+ '<td>' + accountDetail.paymentAck + '</td>'
			+ '<td>' + accountDetail.cvqAck + '</td>'
			+ '</tr>';
		panelBody += accountRow;
	}
	accountDetailPanel.setBody(panelBody);
	accountDetailPanel.setFooter('');
	accountDetailPanel.render(document.body);
	accountDetailPanel.show();
}
		
function loadAccountDetails(baseUrl, accountId, extFamilyAccountId, extAppId, elementDestId) {
	var url = baseUrl
		+ '?action=loadAccountDetails'
		+ '&accountId=' + accountId
		+ '&externalFamilyAccountId=' + extFamilyAccountId
		+ '&externalApplicationId=' + extAppId;
	var callback = {
		success: displayAccountDetailPanel,
		argument: [accountId, elementDestId]
	};
	var transaction = YAHOO.util.Connect.asyncRequest('GET', url, callback, null);
}

