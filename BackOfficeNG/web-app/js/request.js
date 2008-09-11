function initRequest() {
    var submitSearchRequestButton = new YAHOO.widget.Button("submitSearchRequest", {type:"submit"});
    displayPaginator();
}

YAHOO.util.Event.onDOMReady(initRequest);

function displayPaginator() {
	var myPaginator = new YAHOO.widget.Paginator({
		containers: ['pagination-top','pagination-bottom'],
		rowsPerPage : 15,
		totalRecords: parseInt(document.getElementById('totalRecords').value),
		recordOffset: parseInt(document.getElementById('recordOffset').value),
		template : "{FirstPageLink} {PreviousPageLink} <span>{CurrentPageReport}</span> {NextPageLink} {LastPageLink}",
		previousPageLinkLabel : '&lt;',
		firstPageLinkLabel : '&lt;&lt;',
		nextPageLinkLabel : '&gt;',
		lastPageLinkLabel : '&gt;&gt;',
		pageReportTemplate : 'R&eacute;sultats {startRecord} &agrave; {endRecord} sur {totalRecords}'
	});

    function handlePaginatorChange(state) {
        document.getElementById('recordOffset').value = state.recordOffset;
        document.getElementById('requestForm').submit();
    }
    myPaginator.subscribe('changeRequest', handlePaginatorChange);
    
    myPaginator.render();
}

function filterSearchRequest(filterType) {
    document.getElementById('filterBy').value = 
        document.getElementById('filterBy').value + 
        '@' + filterType + '=' + document.getElementById(filterType).value;                
    document.getElementById('requestForm').submit();
}

function sortSearchRequest(sortType) {
    document.getElementById('sortBy').value = sortType;
    document.getElementById('requestForm').submit();
}
