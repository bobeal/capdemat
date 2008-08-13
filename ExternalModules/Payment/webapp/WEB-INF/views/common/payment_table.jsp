<script type="text/javascript">
    <c:if test="${payments != null}" >
	YAHOO.namespace("payments");
	YAHOO.payments.Data = {
    	payments: [
    		  	<c:forEach items="${payments}" var="payment" varStatus="status">
  					{paymentAck:"<c:out value="${payment.paymentAck}" />",
  					 cvqAck:"<c:out value="${payment.cvqAck}" />", 
  					 paymentAmount:"<fmt:formatNumber value="${payment.paymentAmount / 100}" type="currency" currencySymbol="&euro;" />",
  					 paymentDate:"<fmt:formatDate value="${payment.paymentDate}" type="both" timeStyle="short" dateStyle="short" />",
  					 cfaId:"<c:out value="${payment.cfaId}" />",
  					 broker:"<c:out value="${payment.broker}" />"}
  					 // IE6 will see a extra null element if there is a trailing comma after the last element
        			 <c:if test="${status.count < paymentsSize}">,</c:if>
  				</c:forEach>
    	]
    };
    		
	YAHOO.util.Event.addListener(window, "load", function() {
    YAHOO.payments.Basic = new function() {
        var myColumnDefs = [
            {key:"paymentAck", sortable:true, label:"<fmt:message key='table.header.payment_ack'/>"},
            {key:"cvqAck", sortable:true, label:"<fmt:message key='table.header.cvq_ack'/>"},
            {key:"paymentAmount", label:"<fmt:message key='table.header.payment_amount'/>"},
            {key:"paymentDate", sortable:true, label:"<fmt:message key='table.header.payment_date'/>"},
            {key:"cfaId", sortable:true, label:"<fmt:message key='table.header.capwebct_id'/>"},
            {key:"broker", sortable:true, label:"<fmt:message key='table.header.broker'/>"}
        ];

		var myConfigs = {
			<c:if test="${paginate}">
			paginator : new YAHOO.widget.Paginator({
				containers: ['search-results-paginator-top', 'search-results-paginator-bottom'],
	        	rowsPerPage : 25,
	        	rowsPerPageOptions : [25,50,100],
	        	template: "{FirstPageLink} {PreviousPageLink} {CurrentPageReport} {NextPageLink} {LastPageLink} <span class='results-rows-dropdown'>{RowsPerPageDropdown} résultats par page</span>",
				pageReportTemplate: "<b>{totalRecords} résultats, page {currentPage} sur {totalPages}</b>",
				firstPageLinkLabel: "&lt;&lt;",
				previousPageLinkLabel: "&lt;",
				lastPageLinkLabel: "&gt;&gt;",
				nextPageLinkLabel: "&gt;"
			}),
        	</c:if>
        	sortedBy:{
        		key:"paymentDate", 
        		dir:"desc"
        	}
		};

        this.myDataSource = new YAHOO.util.DataSource(YAHOO.payments.Data.payments);
        this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        this.myDataSource.responseSchema = {
            fields: ["paymentAck","cvqAck","paymentAmount","paymentDate", "cfaId", "broker"]
        };

        this.myDataTable = new YAHOO.widget.DataTable("paymentsData",
                myColumnDefs, this.myDataSource, myConfigs);
    };
	});
	</c:if>
</script>
