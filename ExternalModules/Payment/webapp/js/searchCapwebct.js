var searchCapwebctDatatable;
function searchCapwebct() {

	var cfaId = document.getElementById('cfaId').value;
	var cfaResponsible = document.getElementById('cfaResponsible').value;

	// A custom function to translates sorting and pagination values
	// into a query string the server will accept
	var buildQueryString = function (state,dt) {
		var cfaId = document.getElementById('cfaId').value;
		var cfaResponsible = document.getElementById('cfaResponsible').value;

    	return "startIndex=" + state.pagination.recordOffset +
           "&results=" + state.pagination.rowsPerPage +
           "&sort=" + state.sorting.key +
           "&dir=" + ((state.sorting.dir === YAHOO.widget.DataTable.CLASS_DESC) ? "desc" : "asc") +
           "&action=searchCapwebct" + 
           "&cfaId=" + cfaId + 
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
       	{key:"cfaId", sortable:true, formatter:formatCfaIdLink, label:document.getElementById('faTableId').innerHTML},
       	{key:"cfaResponsible", sortable:true, 
       		label:document.getElementById('faTableResponsible').innerHTML},
       	{key:"cfaAddress", label:document.getElementById('faTableAddress').innerHTML}
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
			initialRequest:"action=searchCapwebct" + "&cfaId=" + cfaId
				+ "&cfaResponsible=" + cfaResponsible + '&startIndex=0&results=25',
			
			generateRequest : buildQueryString,
			paginationEventHandler : handlePagination,
    		sortedBy : {key:"cfaId",dir:YAHOO.widget.DataTable.CLASS_ASC}
	};

	var callUrl = YAHOO.payment_module.baseUrl + "familyaccount/search_capwebct.jsp?";
	this.myDatasource = new YAHOO.util.DataSource(callUrl);
    this.myDatasource.responseType = YAHOO.util.DataSource.TYPE_JSON;
    this.myDatasource.responseSchema = {
    	resultsList: "cfaList",
        fields: ["cfaId","cfaResponsible", "cfaAddress"],
		metaFields : {
			totalRecords: "totalRecords"
		}
	};
	
    searchCapwebctDatatable = new YAHOO.widget.DataTable("capwebctAccountsDatatable",
    	myColumnDefs, this.myDatasource, myConfigs);
    	
    // Override function for custom server-side sorting
	searchCapwebctDatatable.sortColumn = function(oColumn) {
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

function initSearchCapwebct() {
	
	var oSubmitButton1 = new YAHOO.widget.Button('wrappedSubmit', {type:'button'});
	oSubmitButton1.on("click", searchCapwebct);
}

YAHOO.util.Event.onDOMReady(initSearchCapwebct);
