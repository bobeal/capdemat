<script type="text/javascript"><!--
    <c:if test="${invoices != null}" >
	YAHOO.namespace("invoices");
	YAHOO.invoices.Data = {
    	invoices: [
    		  	<c:forEach items="${invoices}" var="invoice" varStatus="status">
  					{invoiceId:"<c:out value="${invoice.invoiceId}" />+<c:out value="${invoice.externalFamilyAccount.externalFamilyAccountId}" />+<c:out value="${invoice.externalFamilyAccount.externalApplication.id}" />",
  					 invoiceLabel:"<c:out value="${invoice.invoiceLabel}" />", 
  					 invoiceValue:"<fmt:formatNumber value="${invoice.invoiceValue / 100}" type="currency" currencySymbol="&euro;" />",
  					 invoiceDate:"<fmt:formatDate value="${invoice.invoiceDate}" type="both" timeStyle="short" dateStyle="short" />", 
        			 invoiceExpirationDate:"<fmt:formatDate value="${invoice.invoiceExpirationDate}" type="both" timeStyle="short" dateStyle="short" />", 
        			 invoicePaymentDate:"<fmt:formatDate value="${invoice.invoicePaymentDate}" type="both" timeStyle="short" dateStyle="short" />",
        			 invoicePaid:<c:out value="${invoice.invoicePayed}" />,
        			 externalFamilyAccountId:"<c:out value="${invoice.externalFamilyAccount.externalFamilyAccountId}" />+<c:out value="${invoice.externalFamilyAccount.externalApplication.id}" />", 
        			 externalApplicationLabel:"<c:out value="${invoice.externalFamilyAccount.externalApplication.label}" />"}
        			 // IE6 will see a extra null element if there is a trailing comma after the last element
        			 <c:if test="${status.count < invoicesSize}">,</c:if>
  				</c:forEach>
    	]
    };

	function formatInvoicePanelLink(elCell, oRecord, oColumn, oData) {
		var idTab = oData.split('+');
		elCell.innerHTML = "<a href='javascript:void(0);' onclick=\"loadInvoiceDetails('<c:url value='/management/detailLoader.jsp'/>','" + idTab[0] + "','" + idTab[1] + "','" + idTab[2] + "','" + idTab[0] + "');return false;\">" + idTab[0] + "</a>"
			+ "<div class='panelContainer' id='" + idTab[0] + "'></div>";
	}
	
	// TODO : reactivate
	function formatEfaIdLink(elCell, oRecord, oColumn, oData) {
		var idTab = oData.split('+');
		//elCell.innerHTML = "<a href='<c:url value='/familyaccount/search.jsp?efaId=" + idTab[0] 
		//	+ "&externalApplicationId=" + idTab[1] + "'/>' >" + idTab[0] + "</a>";
		elCell.innerHTML = idTab[0];
	}
	
	YAHOO.util.Event.addListener(window, "load", function() {
    YAHOO.invoices.Basic = new function() {
        var myColumnDefs = [
            {key:"invoiceId", sortable:true, formatter:formatInvoicePanelLink, label:"<fmt:message key='table.header.id'/>"},
            {key:"invoiceLabel", sortable:true, label:"<fmt:message key='table.header.label'/>"},
            {key:"invoiceValue", label:"<fmt:message key='table.header.value'/>"},
            {key:"invoiceDate", sortable:true, 
            	label:"<fmt:message key='table.header.date'/>"},
            {key:"invoiceExpirationDate", sortable:true,
            	label:"<fmt:message key='table.header.expiration_date'/>"},
            {key:"invoicePaymentDate", sortable:true,
            	label:"<fmt:message key='table.header.payment_date'/>"},
            {key:"invoicePaid", sortable:true,
            	label:"<fmt:message key='table.header.paid'/>"},
            {key:"externalFamilyAccountId", sortable:true, formatter:formatEfaIdLink,
            	label:"<fmt:message key='table.header.external_family_account_id'/>"},
            {key:"externalApplicationLabel", sortable:true,
            	label:"<fmt:message key='table.header.external_application_label'/>"}
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
        		key:"invoiceId",
        		dir:"asc"
        	}
		};

        this.myDataSource = new YAHOO.util.DataSource(YAHOO.invoices.Data.invoices);
        this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        this.myDataSource.responseSchema = {
            fields: ["invoiceId","invoiceLabel","invoiceValue","invoiceDate","invoiceExpirationDate",
            	"invoicePaymentDate", "invoicePaid", "externalFamilyAccountId", "externalApplicationLabel"]
        };

        this.myDataTable = new YAHOO.widget.DataTable("invoicesData",
                myColumnDefs, this.myDataSource, myConfigs);
    };
	});
	</c:if>
--></script>
