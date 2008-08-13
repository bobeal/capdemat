<script type="text/javascript">
    <c:if test="${accounts != null}" >
	YAHOO.namespace("accounts");
	YAHOO.accounts.Data = {
    	accounts: [
    		  	<c:forEach items="${accounts}" var="account" varStatus="status">
  					{accountId:"<c:out value="${account.accountId}" />+<c:out value="${account.externalFamilyAccount.externalFamilyAccountId}" />+<c:out value="${account.externalFamilyAccount.externalApplication.id}" />",
  					 accountLabel:"<c:out value="${account.accountLabel}" />", 
  					 accountValue:"<fmt:formatNumber value="${account.accountValue / 100}" type="currency" currencySymbol="&euro;" />",
  					 accountDate:"<fmt:formatDate value="${account.accountDate}" type="both" timeStyle="short" dateStyle="short" />", 
        			 externalFamilyAccountId:"<c:out value="${account.externalFamilyAccount.externalFamilyAccountId}" />+<c:out value="${account.externalFamilyAccount.externalApplication.id}" />", 
        			 externalApplicationLabel:"<c:out value="${account.externalFamilyAccount.externalApplication.label}" />"}
        			 // IE6 will see a extra null element if there is a trailing comma after the last element
        			 <c:if test="${status.count < accountsSize}">,</c:if>
  				</c:forEach>
    	]
    };
    		
	function formatAccountPanelLink(elCell, oRecord, oColumn, oData) {
		var idTab = oData.split('+');
		elCell.innerHTML = "<a href='javascript:void(0);' onclick=\"loadAccountDetails('<c:url value='/management/detailLoader.jsp'/>','" + idTab[0] + "','" + idTab[1] + "','" + idTab[2] + "','" + idTab[0] + "');return false;\">" + idTab[0] + "</a>"
			+ "<div class='panelContainer' id='" + idTab[0] + "'></div>";
	}
	
	function formatEfaIdLink(elCell, oRecord, oColumn, oData) {
		var idTab = oData.split('+');
		elCell.innerHTML = "<a href='<c:url value='/familyaccount/search.jsp?efaId=" + idTab[0] 
			+ "&externalApplicationId=" + idTab[1] + "'/>' >" + idTab[0] + "</a>";
	}
	
	YAHOO.util.Event.addListener(window, "load", function() {
    YAHOO.accounts.Basic = new function() {
        var myColumnDefs = [
            {key:"accountId", sortable:true, formatter:formatAccountPanelLink, label:"<fmt:message key='table.header.id'/>"},
            {key:"accountLabel", sortable:true, label:"<fmt:message key='table.header.label'/>"},
            {key:"accountValue", label:"<fmt:message key='table.header.value'/>"},
            {key:"accountDate", sortable:true,
            	label:"<fmt:message key='table.header.date'/>"},
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
        		key:"accountId", 
        		dir:"asc"
        	}
		};

        this.myDataSource = new YAHOO.util.DataSource(YAHOO.accounts.Data.accounts);
        this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        this.myDataSource.responseSchema = {
            fields: ["accountId","accountLabel","accountValue","accountDate",
            	"externalFamilyAccountId", "externalApplicationLabel"]
        };

        this.myDataTable = new YAHOO.widget.DataTable("accountsData",
                myColumnDefs, this.myDataSource, myConfigs);
    };
	});
	</c:if>
</script>
