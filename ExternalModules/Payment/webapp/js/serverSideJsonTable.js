var resultsDatatable;

function loadServerSideJsonTable(buildComplementaryQueryString, columnDefs, initialRequest,
	initialSortKey, controllerUrl, resultsList, fields) {
	
	// A custom function to translates sorting and pagination values
	// into a query string the server will accept
	var buildQueryString = function (state,dt) {
    	return "startIndex=" + state.pagination.recordOffset +
           "&results=" + state.pagination.rowsPerPage +
           "&sort=" + state.sorting.key +
           "&dir=" + ((state.sorting.dir === YAHOO.widget.DataTable.CLASS_DESC) ? "desc" : "asc") +
           buildComplementaryQueryString();
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
			initialRequest:initialRequest + '&startIndex=0&results=25',
			generateRequest : buildQueryString,
			paginationEventHandler : handlePagination,
    		sortedBy : {key:initialSortKey, dir:YAHOO.widget.DataTable.CLASS_ASC}
	};

	var callUrl = YAHOO.payment_module.baseUrl + controllerUrl;
	this.myDatasource = new YAHOO.util.DataSource(callUrl);
    this.myDatasource.responseType = YAHOO.util.DataSource.TYPE_JSON;
    this.myDatasource.responseSchema = {
    	resultsList: resultsList,
        fields: fields,
		metaFields : {
			totalRecords: "totalRecords"
		}
	};
	
    resultsDatatable = new YAHOO.widget.DataTable("resultsDatatable",
    	columnDefs, this.myDatasource, myConfigs);
    	
    // Override function for custom server-side sorting
	resultsDatatable.sortColumn = function(oColumn) {
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

function reloadServerSideJsonTable(buildComplementaryQueryString, initialSortKey) {
	
	// Re-initialize state
    var newState = {
    	startIndex: 0, 
        sorting: {
        	key: initialSortKey,
            dir: 'asc'
        },
        pagination : { // Pagination values
        	recordOffset: 0, // Default to first page when sorting
            rowsPerPage: 25 // Keep current setting
        }
    };

	var oCallback = {
    	success : resultsDatatable.onDataReturnInitializeTable,
    	failure : resultsDatatable.onDataReturnInitializeTable,
    	scope : resultsDatatable,
    	argument: newState
	};

	var queryString = 'startIndex=0&results=25' + buildComplementaryQueryString();
	
	resultsDatatable.getDataSource().sendRequest(queryString, oCallback);
}
