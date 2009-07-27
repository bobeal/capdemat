function removeDatatableRow(recordId) {
	var recordSet = resultsDatatable.getRecordSet();
	var record = recordSet.getRecord(recordId);
		
	resultsDatatable.deleteRow(recordSet.getRecordIndex(record));
}

var familyAccountAssociationDialog;
function instantiateFamilyAccountAssociationDialog() {
	familyAccountAssociationDialog = new YAHOO.widget.Dialog("familyAccountAssociationDialog",
    	{width:"40em", visible:false, fixedcenter:true, constraintoviewport:true, 
    		height:"30em", draggable:true, modal:true, postmethod:"async"});

	// build the AC control
	var itemSelectHandler = function(sType, aArgs) { 
		var aData = aArgs[2]; //array of the data for the item as returned by the DataSource 
		document.getElementById('efaIdToAssociate').value = aData[1];
		document.getElementById('familyAccountInput').value = aData[0] + " (" + aData[1] + ") - " + aData[2];
	};

	var mySchema = ["efaList", "efaResponsibleLastName", "efaId", "efaAddress", "isAssociated"]; 
	var myDataSource = 
		new YAHOO.widget.DS_XHR('associate.jsp', mySchema);
	myDataSource.scriptQueryAppend = "action=searchEfa&externalApplicationId=" + document.getElementById('externalApplicationId').value;
	myDataSource.queryMatchSubset = false;
	myDataSource.maxCacheEntries = 0;
	var familyAccountAutoComp = 
		new YAHOO.widget.AutoComplete("familyAccountInput", "familyAccountAutoCompleteContainer", 
			myDataSource);
	familyAccountAutoComp.minQueryLength = 3;
	familyAccountAutoComp.maxResultsDisplayed = 20;
	familyAccountAutoComp.itemSelectEvent.subscribe(itemSelectHandler); 

	// This function returns markup that bolds the original query,
	// and also displays to additional pieces of supplemental data.
	familyAccountAutoComp.formatResult = function(aResultItem, sQuery) {
		var sKey = aResultItem[0]; // the entire result key
		var sKeyQuery = sKey.substr(0, sQuery.length); // the query itself
		var sKeyRemainder = sKey.substr(sQuery.length); // the rest of the result

		var efaId = aResultItem[1]; 
		var efaAddress = aResultItem[2];
		var isAssociated = aResultItem[3];

		var divClass = '';
		var extraMessage = '';
		if (isAssociated === true) {
			divClass = 'associated';
			extraMessage = ' - ' + document.getElementById('faAssociationAssociatedMessage').innerHTML;
		} else {
			divClass = 'not_associated';
		}
		var aMarkup = ["<div id='ysearchresult' class='", divClass, "'>",
   			"<span style='font-weight:bold;'>", sKeyQuery, "</span>", sKeyRemainder,
   			" (", efaId, 	") - ", efaAddress, extraMessage, "</div>"];
		return aMarkup.join("");
	};		
	
	familyAccountAssociationDialog.render();    	
}

function getFamilyAccountType() {
	var familyAccountType = "not_associated";
	var faTypeInput = document.getElementById('familyAccountAssociateForm').familyAccountType;
	for (var i=0; i < faTypeInput.length; i++) {
		if (faTypeInput[i].checked === true) {
			return faTypeInput[i].value;
		}
	}
	return familyAccountType;	
}

function loadFamilyAccountAssociationPanel(cfaId, currentEfaId, recordId) {
	// initialize left-side association fields
	document.getElementById('cfaIdToAssociate').value = cfaId;
	document.getElementById('externalApplicationIdToAssociate').value = 
		document.getElementById('externalApplicationId').value;
	if (currentEfaId !== '') {
		document.getElementById('currentEfaId').value = currentEfaId;
	}
		
	// reset previous values
	document.getElementById('familyAccountInput').value = '';
	document.getElementById('efaIdToAssociate').value = '';
	document.getElementById('familyAccountInput').value = '';
	document.getElementById('familyAccountAssociationError').innerHTML = '';
	YAHOO.util.Dom.addClass(document.getElementById('familyAccountAssociationError'),'invisible');
	
	var handleCancel = function() {
		this.hide();
	};
	var handleSubmit = function() {
		doAjaxFormSubmitCall(handleAssociationSuccess, recordId, 'familyAccountAssociationForm', false);
	};
	var handleAssociationSuccess = function(o) {
		var resultData = YAHOO.lang.JSON.parse(o.responseText);
		if (resultData.result == "OK") {
			if (resultData.previousEfaId !== '') {
				// it was already associated, do not remove the row, instead update it
				var record = resultsDatatable.getRecord(o.argument);
				record.setData("efaId", resultData.efaId);
				record.setData("efaResponsible", resultData.efaResponsible);
				record.setData("efaAddress", resultData.efaAddress);
				var recordData = {
					"cfaId" : record.getData("cfaId"),
					"cfaResponsible" : record.getData("cfaResponsible"),
					"cfaAddress" : record.getData("cfaAddress"),
					"efaId" : resultData.efaId,
					"efaResponsible" : resultData.efaResponsible,
					"efaAddress" : resultData.efaAddress
				};
				resultsDatatable.updateRow(record, recordData);
				// TODO : we may have to remove a row that is no longer associated
			} else {
				removeDatatableRow(o.argument);				
			}		
			familyAccountAssociationDialog.hide();
		} else {
			document.getElementById('familyAccountAssociationError').innerHTML 
				= "Echec du traitement ou données non valides, merci de ré-essayer";
			YAHOO.util.Dom.removeClass(document.getElementById('familyAccountAssociationError'),'invisible');
		}
	};

	var handleFailure = function(o) {
		alert("Submission failed: " + o.status);
	};

	var myButtons = [ 
		{ text:document.getElementById('faAssociationOk').innerHTML, handler:handleSubmit, isDefault:true },
		{ text:document.getElementById('faAssociationCancel').innerHTML, handler:handleCancel } 
	];
	familyAccountAssociationDialog.cfg.queueProperty("buttons", myButtons);
	familyAccountAssociationDialog.render();    	
	familyAccountAssociationDialog.show();
}

function loadFamilyAccountDeassociationDialog(efaId, externalApplicationId, recordId) {
	var handleDeleteAssociationSuccess = function(o) {
		removeDatatableRow(o.argument);
    };
    	
	var handleDeleteAssociationConfirm = function() {
		var callUrl = YAHOO.payment_module.baseUrl + "familyaccount/associate.jsp?"
			+ "action=deleteFamilyAccountBinding"
			+ '&efaId=' + efaId
			+ '&externalApplicationId=' + externalApplicationId;
   		doAjaxCall(callUrl,handleDeleteAssociationSuccess,recordId);
   		this.hide();
   	};
   		
   	loadConfirmationDialog(handleDeleteAssociationConfirm, 
   		document.getElementById('faCommonWarning').innerHTML,
		document.getElementById('faDeassociationConfirmMessage').innerHTML + " " + efaId + " ?", 
		document.getElementById('faCommonYes').innerHTML, 
		document.getElementById('faCommonNo').innerHTML);
}

function loadFamilyAccountHideDialog(cfaId, externalApplicationId, recordId) {
	var handleHideFamilyAccountSuccess = function(o) {
		removeDatatableRow(o.argument);
    };

	var handleHideFamilyAccountConfirm = function() {
		var callUrl = YAHOO.payment_module.baseUrl + "familyaccount/associate.jsp?"
			+ "action=hideFamilyAccount"
			+ '&cfaId=' + cfaId
			+ '&externalApplicationId=' + externalApplicationId;
   		doAjaxCall(callUrl,handleHideFamilyAccountSuccess,recordId);
   		this.hide();
   	};

   	loadConfirmationDialog(handleHideFamilyAccountConfirm, 
   		document.getElementById('faCommonWarning').innerHTML,
		document.getElementById('faHideConfirmMessage').innerHTML + " " + cfaId + " ?",
		document.getElementById('faCommonYes').innerHTML, 
		document.getElementById('faCommonNo').innerHTML);
}

function formatActionLink (elCell, oRecord, oColumn, oData) {
	
	var buildAssociationLink = function(cfaId, currentEfaId, recordId) {
		var htmlLink = ["<a href='javascript:void(0);' onclick=\"loadFamilyAccountAssociationPanel('",
			cfaId, "','", currentEfaId, "','", recordId, "');return false;\">",
			document.getElementById('connectImg').innerHTML, "</a>",
			"<div style='display:inline;' class='panelContainer' id='", oRecord.getData("cfaId"), "'></div>"];
		return htmlLink.join("");
	};
	
	var buildHideLink = function(cfaId, externalApplicationId, recordId) {
		var htmlLink = ["<a href='javascript:void(0);' onclick=\"loadFamilyAccountHideDialog('",
			cfaId, "','", externalApplicationId, "','" , recordId, "');return false;\">",
			document.getElementById('hideImg').innerHTML, "</a>"];
		return htmlLink.join("");			
	};
	
	var familyAccountType = oData;
	if (familyAccountType == "not_associated") {
		elCell.innerHTML = 
			buildAssociationLink(oRecord.getData("cfaId"), oRecord.getData("efaId"), oRecord.getId());
		elCell.innerHTML += 
			buildHideLink(oRecord.getData("cfaId"), document.getElementById('externalApplicationId').value, 
				oRecord.getId());
	} else if (familyAccountType == "no_meaning") {
		elCell.innerHTML = 
			buildAssociationLink(oRecord.getData("cfaId"), oRecord.getData("efaId"), oRecord.getId());
	} else if (familyAccountType == "associated") {
		elCell.innerHTML = "<a href='javascript:void(0);'" 
			+ " onclick=\"loadFamilyAccountDeassociationDialog('" 
				+ oRecord.getData("efaId") + "','" 
				+ document.getElementById('externalApplicationId').value + "','" 
				+ oRecord.getId() + "');return false;\">" 
			+ document.getElementById('disconnectImg').innerHTML + "</a>";
		elCell.innerHTML += 
			buildAssociationLink(oRecord.getData("cfaId"), oRecord.getData("efaId"), oRecord.getId());
		elCell.innerHTML +=  
			buildHideLink(oRecord.getData("cfaId"), document.getElementById('externalApplicationId').value, 
				oRecord.getId());
	}
};

function buildComplementaryQueryString() {
	var familyAccountType = getFamilyAccountType();
	var externalApplicationId = document.getElementById('externalApplicationId').value;
	var cfaResponsible = document.getElementById('cfaResponsible').value;

	return "&action=loadFamilyAccounts" + 
    	"&externalApplicationId=" + externalApplicationId + 
        "&familyAccountType=" + familyAccountType +
        "&cfaResponsible=" + cfaResponsible;
}

function reloadFamilyAccounts() {
	reloadServerSideJsonTable(buildComplementaryQueryString, "cfaId");
}

function loadFamilyAccounts() {

	var formatCfaIdLink = function(elCell, oRecord, oColumn, oData) {
		var url = YAHOO.payment_module.baseUrl + "familyaccount/display.jsp";		
		elCell.innerHTML = "<a href='" + url + "?cfaId=" + oData + "'>" + oData + "</a>";
	};
	
	var myColumnDefs = [
        	{label:"<b>" + document.getElementById('faTableCfaHeader').innerHTML + "</b>", 
        		className:"table-header", children:[
            	{key:"cfaId", sortable:true, formatter:formatCfaIdLink, 
            		label:document.getElementById('faTableId').innerHTML},
            	{key:"cfaResponsible", sortable:true, 
            		label:document.getElementById('faTableResponsible').innerHTML},
            	{key:"cfaAddress", label:document.getElementById('faTableAddress').innerHTML}]
            },
            {label:"<b>" + document.getElementById('faTableEfaHeader').innerHTML + "</b>", 
            	className:"table-header", children:[
            	{key:"efaId", sortable:true, 
            		label:document.getElementById('faTableId').innerHTML},
            	{key:"efaResponsible", sortable:true, 
            		label:document.getElementById('faTableResponsible').innerHTML},
            	{key:"efaAddress", label:document.getElementById('faTableAddress').innerHTML}
            	]
            },
            {key:"action", className:"table-header", formatter:formatActionLink, 
            	label:document.getElementById('faTableAction').innerHTML}
    ];

	var initialRequest = "action=loadFamilyAccounts" 
		+ "&externalApplicationId=" + document.getElementById('externalApplicationId').value
		+ "&familyAccountType=" + getFamilyAccountType();
	var initialSortKey = "cfaId";
	var controllerUrl = "familyaccount/associate.jsp?";
	var resultsList = "cfaList";
	var fields = ["cfaId","cfaResponsible", "cfaAddress", "efaId", "efaResponsible", 
            			"efaAddress", "action"];
            			
	loadServerSideJsonTable(buildComplementaryQueryString, myColumnDefs, initialRequest, initialSortKey,
		controllerUrl, resultsList, fields);
}

function initAccountAssociate() {
	
	var oSubmitButton1 = new YAHOO.widget.Button('wrappedSubmit', {type:'button'});
	oSubmitButton1.on("click", reloadFamilyAccounts);

	// only try to load family accounts if an external application is defined
	if (document.getElementById('externalApplicationId').value != '')
		loadFamilyAccounts();
	
	instantiateFamilyAccountAssociationDialog();
}

YAHOO.util.Event.onDOMReady(initAccountAssociate);
