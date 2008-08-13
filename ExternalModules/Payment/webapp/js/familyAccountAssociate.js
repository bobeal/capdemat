var familyAccountAssociationDatatable;

function removeDatatableRow(recordId) {
	var recordSet = familyAccountAssociationDatatable.getRecordSet();
	var record = recordSet.getRecord(recordId);
		
	familyAccountAssociationDatatable.deleteRow(recordSet.getRecordIndex(record));
}

var familyAccountAssociationDialog;
function instantiateFamilyAccountAssociationDialog() {
	familyAccountAssociationDialog = new YAHOO.widget.Dialog("familyAccountAssociationDialog",
    	{width:"40em", visible:false, fixedcenter:true, constraintoviewport:true, 
    		height:"30em", draggable:false, modal:true, postmethod:"async"});

	// build the AC control
	var itemSelectHandler = function(sType, aArgs) { 
		var aData = aArgs[2]; //array of the data for the item as returned by the DataSource 
		document.getElementById('efaIdToAssociate').value = aData[1];
		document.getElementById('familyAccountInput').value = aData[0] + " (" + aData[1] + ") - " + aData[2];
	};

	var mySchema = ["efaList", "efaResponsibleLastName", "efaId", "efaAddress", "isAssociated"]; 
	var myDataSource = 
		new YAHOO.widget.DS_XHR('associate.jsp', mySchema);
	myDataSource.scriptQueryAppend = "action=searchEfa&externalApplicationId=" 
		+ document.getElementById('externalApplicationId').value;
	myDataSource.queryMatchSubset = false;
	myDataSource.maxCacheEntries = 0;
	var familyAccountAutoComp = 
		new YAHOO.widget.AutoComplete("familyAccountInput", "familyAccountAutoCompleteContainer", 
			myDataSource);
	familyAccountAutoComp.minQueryLength = 3;
	familyAccountAutoComp.maxResultsDisplayed = 8;
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
		if (isAssociated == true) {
			divClass = 'associated';
			extraMessage = ' - ' + document.getElementById('faAssociationAssociatedMessage').innerHTML;
		} else {
			divClass = 'not_associated';
		}
		var aMarkup = ["<div id='ysearchresult' class='", divClass, "'>",
   			"<span style='font-weight:bold;'>", sKeyQuery, "</span>", sKeyRemainder,
   			" (", efaId, 	") - ", efaAddress, extraMessage, "</div>"];
		return (aMarkup.join(""));
	};		
	
	familyAccountAssociationDialog.render();    	
}

function loadFamilyAccountAssociationPanel(cfaId,recordId) {
	// initialize left-side association fields
	document.getElementById('cfaIdToAssociate').value = cfaId;
	document.getElementById('externalApplicationIdToAssociate').value = 
		document.getElementById('externalApplicationId').value;
		
	// reset previous values
	document.getElementById('familyAccountInput').value = '';
	document.getElementById('efaIdToAssociate').value = '';
	document.getElementById('familyAccountInput').value = '';
	
	var handleCancel = function() {
		this.hide();
	}
	var handleSubmit = function() {
		doAjaxFormSubmitCall(handleAssociationSuccess, recordId, 'familyAccountAssociationForm', false);
		this.hide();
	}
	var handleAssociationSuccess = function(o) {
		removeDatatableRow(o.argument);
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
    }
    	
	var handleDeleteAssociationConfirm = function() {
		var callUrl = YAHOO.payment_module.baseUrl + "familyaccount/associate.jsp?"
			+ "action=deleteFamilyAccountBinding"
			+ '&efaId=' + efaId
			+ '&externalApplicationId=' + externalApplicationId;
   		doAjaxCall(callUrl,handleDeleteAssociationSuccess,recordId);
   		this.hide();
   	}
   		
   	loadConfirmationDialog(handleDeleteAssociationConfirm, 
   		document.getElementById('faCommonWarning').innerHTML,
		document.getElementById('faDeassociationConfirmMessage').innerHTML + " " + efaId + " ?", 
		document.getElementById('faCommonYes').innerHTML, 
		document.getElementById('faCommonNo').innerHTML);
}

function loadFamilyAccountHideDialog(cfaId, externalApplicationId, recordId) {
	var handleHideFamilyAccountSuccess = function(o) {
		removeDatatableRow(o.argument);
    }

	var handleHideFamilyAccountConfirm = function() {
		var callUrl = YAHOO.payment_module.baseUrl + "familyaccount/associate.jsp?"
			+ "action=hideFamilyAccount"
			+ '&cfaId=' + cfaId
			+ '&externalApplicationId=' + externalApplicationId;
   		doAjaxCall(callUrl,handleHideFamilyAccountSuccess,recordId);
   		this.hide();
   	}

   	loadConfirmationDialog(handleHideFamilyAccountConfirm, 
   		document.getElementById('faCommonWarning').innerHTML,
		document.getElementById('faHideConfirmMessage').innerHTML + " " + cfaId + " ?",
		document.getElementById('faCommonYes').innerHTML, 
		document.getElementById('faCommonNo').innerHTML);
}

function formatActionLink (elCell, oRecord, oColumn, oData) {
	var familyAccountType = oData;
	if (familyAccountType == "not_associated") {
		elCell.innerHTML = "<a href='javascript:void(0);'" 
			+ " onclick=\"loadFamilyAccountAssociationPanel('" 
				+ oRecord.getData("cfaId") + "','" 
				+ oRecord.getId() + "');return false;\">" 
			+ "<img src='../img/connect.gif'/>" + "</a>"
			+ "<div style='display:inline;' class='panelContainer' id='" + oRecord.getData("cfaId") + "'></div>";
		elCell.innerHTML +=  "<a href='javascript:void(0);'" 
			+ " onclick=\"loadFamilyAccountHideDialog('" 
				+ oRecord.getData("cfaId") + "','" 
				+ document.getElementById('externalApplicationId').value + "','"
				+ oRecord.getId() + "');return false;\">"
			+ "<img src='../img/folder-minus.gif'/>" + "</a>";
	} else if (familyAccountType == "no_meaning") {
		elCell.innerHTML = "<a href='javascript:void(0);'" 
			+ " onclick=\"loadFamilyAccountAssociationPanel('" 
				+ oRecord.getData("cfaId") + "','" 
				+ oRecord.getId() + "');return false;\">" 
			+ "<img src='../img/connect.gif'/>" + "</a>"
			+ "<div class='panelContainer' id='" + oRecord.getData("cfaId") + "'></div>";
	} else if (familyAccountType == "associated") {
		elCell.innerHTML = "<a href='javascript:void(0);'" 
			+ " onclick=\"loadFamilyAccountDeassociationDialog('" 
				+ oRecord.getData("efaId") + "','" 
				+ document.getElementById('externalApplicationId').value + "','" 
				+ oRecord.getId() + "');return false;\">" 
			+ "<img src='../img/disconnect.gif'/>" + "</a>";
		elCell.innerHTML += "<a href='javascript:void(0);'" 
			+ " onclick=\"loadFamilyAccountAssociationPanel('" 
				+ oRecord.getData("cfaId") + "','" 
				+ oRecord.getId() + "');return false;\">" 
			+ "<img src='../img/connect.gif'/>" + "</a>"
			+ "<div style='display:inline;' class='panelContainer' id='" + oRecord.getData("cfaId") + "'></div>";
		elCell.innerHTML +=  "<a href='javascript:void(0);'" 
			+ " onclick=\"loadFamilyAccountHideDialog('" 
				+ oRecord.getData("cfaId") + "','" 
				+ document.getElementById('externalApplicationId').value + "','"
				+ oRecord.getId() + "');return false;\">"
			+ "<img src='../img/folder-minus.gif'/>" + "</a>";
	}
};

function reloadFamilyAccounts() {
	var familyAccountType = getFamilyAccountType();
	var externalApplicationId = document.getElementById('externalApplicationId').value;
	var cfaResponsible = document.getElementById('cfaResponsible').value;

	// Re-initialize state
    var newState = {
    	startIndex: 0, 
        sorting: {
        	key: 'cfaId',
            dir: 'asc'
        },
        pagination : { // Pagination values
        	recordOffset: 0, // Default to first page when sorting
            rowsPerPage: 25 // Keep current setting
        }
    };

	var oCallback = {
    	success : familyAccountAssociationDatatable.onDataReturnInitializeTable,
    	failure : familyAccountAssociationDatatable.onDataReturnInitializeTable,
    	scope : familyAccountAssociationDatatable,
    	argument: newState
	};

	familyAccountAssociationDatatable.getDataSource().sendRequest("action=loadFamilyAccounts" 
		+ "&externalApplicationId=" 	+ externalApplicationId 
		+ "&familyAccountType=" + familyAccountType 
		+ "&cfaResponsible=" + cfaResponsible
		+ '&startIndex=0&results=25', oCallback);
}

function getFamilyAccountType() {
	var familyAccountType = "not_associated";
	var faTypeInput = document.getElementById('familyAccountAssociateForm').familyAccountType;
	for (var i=0; i < faTypeInput.length; i++) {
		if (faTypeInput[i].checked == true) {
			return faTypeInput[i].value;
		}
	}
	return familyAccountType;	
}

function loadFamilyAccounts() {
	var familyAccountType = getFamilyAccountType();
	var externalApplicationId = document.getElementById('externalApplicationId').value;

	// A custom function to translates sorting and pagination values
	// into a query string the server will accept
	var buildQueryString = function (state,dt) {
		var familyAccountType = getFamilyAccountType();
		var externalApplicationId = document.getElementById('externalApplicationId').value;
		var cfaResponsible = document.getElementById('cfaResponsible').value;
		
    	return "startIndex=" + state.pagination.recordOffset +
           "&results=" + state.pagination.rowsPerPage +
           "&sort=" + state.sorting.key +
           "&dir=" + ((state.sorting.dir === YAHOO.widget.DataTable.CLASS_DESC) ? "desc" : "asc") +
           "&action=loadFamilyAccounts" + 
           "&externalApplicationId=" + externalApplicationId + 
           "&familyAccountType=" + familyAccountType +
           "&cfaResponsible=" + cfaResponsible;
	};
	
	// Custom function to handle pagination requests
	var handlePagination = function (state,dt) {
    	var sortedBy  = dt.get('sortedBy');

    	// Define the new state
    	var newState = {
        	startIndex: state.recordOffset, 
        	sorting: {
            	key: sortedBy.key,
            	dir: ((sortedBy.dir === YAHOO.widget.DataTable.CLASS_DESC) ? "desc" : "asc")
        	},
        	pagination : { // Pagination values
            	recordOffset: state.recordOffset, // Default to first page when sorting
            	rowsPerPage: state.rowsPerPage // Keep current setting
        	}
    	};

    	// Create callback object for the request
    	var oCallback = {
        	success: dt.onDataReturnSetRows,
        	failure: dt.onDataReturnSetRows,
        	scope: dt,
        	argument: newState // Pass in new state as data payload for callback function to use
    	};
    
    	// Send the request
    	dt.getDataSource().sendRequest(buildQueryString(newState), oCallback);
	};

	var formatCfaIdLink = function(elCell, oRecord, oColumn, oData) {
		var url = YAHOO.payment_module.baseUrl + "familyaccount/display.jsp";		
		elCell.innerHTML = "<a href='" + url + "?cfaId=" + oData + "'>" + oData + "</a>";
	}
	
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

	var myConfigs = {
			paginator : new YAHOO.widget.Paginator({
				containers: ['search-results-paginator-top', 'search-results-paginator-bottom'],
	        	rowsPerPage : 25,
	        	rowsPerPageOptions : [10,25,50],
	        	template: "{FirstPageLink} {PreviousPageLink} {CurrentPageReport} {NextPageLink} {LastPageLink} <span class='results-rows-dropdown'>{RowsPerPageDropdown} résultats par page</span>",
				pageReportTemplate: "<b>{totalRecords} résultat(s), page {currentPage} sur {totalPages}</b>",
				firstPageLinkLabel: "&lt;&lt;",
				previousPageLinkLabel: "&lt;",
				lastPageLinkLabel: "&gt;&gt;",
				nextPageLinkLabel: "&gt;"
			}),
			initialRequest:"action=loadFamilyAccounts" + "&externalApplicationId=" + externalApplicationId
				+ "&familyAccountType=" + familyAccountType + '&startIndex=0&results=25',
			generateRequest : buildQueryString,
			paginationEventHandler : handlePagination,
    		sortedBy : {key:"cfaId",dir:YAHOO.widget.DataTable.CLASS_ASC}
	};

	var callUrl = YAHOO.payment_module.baseUrl + "familyaccount/associate.jsp?";
	this.myDatasource = new YAHOO.util.DataSource(callUrl);
    this.myDatasource.responseType = YAHOO.util.DataSource.TYPE_JSON;
    this.myDatasource.responseSchema = {
    	resultsList: "cfaList",
        fields: ["cfaId","cfaResponsible", "cfaAddress", "efaId", "efaResponsible", 
            			"efaAddress", "action"],
		metaFields : {
			totalRecords: "totalRecords"
		}
	};
	
    familyAccountAssociationDatatable = new YAHOO.widget.DataTable("familyAccountsAssociationTable",
    	myColumnDefs, this.myDatasource, myConfigs);
    	
    // Override function for custom server-side sorting
	familyAccountAssociationDatatable.sortColumn = function(oColumn) {
    	// Default ascending
    	var sDir = "asc";
    
    	// If already sorted, sort in opposite direction
    	if(oColumn.key === this.get("sortedBy").key) {
        	sDir = (this.get("sortedBy").dir === YAHOO.widget.DataTable.CLASS_ASC) ?
                "desc" : "asc";
    	}

    	// Define the new state
    	var newState = {
        	startIndex: 0,
        	sorting: { // Sort values
            	key: oColumn.key,
            	dir: (sDir === "desc") ? YAHOO.widget.DataTable.CLASS_DESC : YAHOO.widget.DataTable.CLASS_ASC
        	},
        	pagination : { // Pagination values
            	recordOffset: 0, // Default to first page when sorting
            	rowsPerPage: this.get("paginator").getRowsPerPage() // Keep current setting
        	}
    	};

    	// Create callback object for the request
    	var oCallback = {
        	success: this.onDataReturnSetRows,
        	failure: this.onDataReturnSetRows,
        	scope: this,
        	argument: newState // Pass in new state as data payload for callback function to use
    	};
    
    	// Send the request
    	this.getDataSource().sendRequest(buildQueryString(newState), oCallback);
	};
}

function initAccountAssociate() {
	
	var oSubmitButton1 = new YAHOO.widget.Button('wrappedSubmit', {type:'button'});
	oSubmitButton1.on("click", reloadFamilyAccounts);

	loadFamilyAccounts();
	
	instantiateFamilyAccountAssociationDialog();
}

YAHOO.util.Event.onDOMReady(initAccountAssociate);
