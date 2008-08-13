var searchExternalDatatable;
function searchExternal() {

	var efaId = document.getElementById('efaId').value;
	var efaResponsible = document.getElementById('efaResponsible').value;
	var externalApplicationId = document.getElementById('externalApplicationId').value;
	
	// A custom function to translates sorting and pagination values
	// into a query string the server will accept
	var buildQueryString = function (state,dt) {
		var efaId = document.getElementById('efaId').value;
		var efaResponsible = document.getElementById('efaResponsible').value;
		var externalApplicationId = document.getElementById('externalApplicationId').value;

    	return "startIndex=" + state.pagination.recordOffset +
           "&results=" + state.pagination.rowsPerPage +
           "&sort=" + state.sorting.key +
           "&dir=" + ((state.sorting.dir === YAHOO.widget.DataTable.CLASS_DESC) ? "desc" : "asc") +
           "&action=searchExternal" + 
           "&efaId=" + efaId + 
           "&efaResponsible=" + efaResponsible +
           "&externalApplicationId=" + externalApplicationId;
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
		{key:"efaId", sortable:true, label:document.getElementById('faTableId').innerHTML},
       	{key:"efaResponsible", sortable:true, 
       		label:document.getElementById('faTableResponsible').innerHTML},
       	{key:"efaAddress", label:document.getElementById('faTableAddress').innerHTML},
       	{key:"externalApplication", label:document.getElementById('faTableExtApp').innerHTML},
       	{key:"cfaId", formatter:formatCfaIdLink, label:document.getElementById('faTableCfaId').innerHTML},
       	{key:"cfaResponsible", label:document.getElementById('faTableResponsible').innerHTML}
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
			initialRequest:"action=searchExternal" + "&efaId=" + efaId
				+ "&efaResponsible=" + efaResponsible 
				+ "&externalApplicationId=" + externalApplicationId
				+ "&startIndex=0&results=25",
			generateRequest : buildQueryString,
			paginationEventHandler : handlePagination,
    		sortedBy : {key:"efaId",dir:YAHOO.widget.DataTable.CLASS_ASC}
	};

	var callUrl = YAHOO.payment_module.baseUrl + "familyaccount/search_external.jsp?";
	this.myDatasource = new YAHOO.util.DataSource(callUrl);
    this.myDatasource.responseType = YAHOO.util.DataSource.TYPE_JSON;
    this.myDatasource.responseSchema = {
    	resultsList: "efaList",
        fields: ["efaId","efaResponsible", "efaAddress", "externalApplication", "cfaId", "cfaResponsible"],
		metaFields : {
			totalRecords: "totalRecords"
		}
	};
	
    searchExternalDatatable = new YAHOO.widget.DataTable("externalAccountsDatatable",
    	myColumnDefs, this.myDatasource, myConfigs);
    	
    // Override function for custom server-side sorting
	searchExternalDatatable.sortColumn = function(oColumn) {
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

function initSearchExternal() {
	
	var oSubmitButton1 = new YAHOO.widget.Button('wrappedSubmit', {type:'button'});
	oSubmitButton1.on("click", searchExternal);
}

YAHOO.util.Event.onDOMReady(initSearchExternal);
