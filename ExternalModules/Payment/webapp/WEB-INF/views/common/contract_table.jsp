<script type="text/javascript">
    <c:if test="${contracts != null}" >
	YAHOO.namespace("contracts");
	YAHOO.contracts.Data = {
    	contracts: [
    		  	<c:forEach items="${contracts}" var="contract" varStatus="status">
  						{contractId:"<c:out value="${contract.contractId}" />",
  					 	 contractLabel:"<c:out value="${contract.contractLabel}" />", 
  					 	 contractValue:"<fmt:formatNumber value="${contract.contractValue / 100}" type="currency" currencySymbol="&euro;" />",
  					 	 contractDate:"<fmt:formatDate value="${contract.contractDate}" type="both" timeStyle="short" dateStyle="short" />", 
  					 	 contractBuyPrice:"<fmt:formatNumber value="${contract.buyPrice / 100}" type="currency" currencySymbol="&euro;" />", 
  					 	 contractMinBuy:<c:out value="${contract.buyMin}" />, 
  					 	 contractMaxBuy:<c:out value="${contract.buyMax}" />, 
  					 	 <c:if test="${contract.externalIndividual.capwebctIndividual != null}">
  					 	 capwebctIndividualId:"<c:out value="${contract.externalIndividual.capwebctIndividual.capwebctIndividualId}" />",
  					 	 </c:if>
  					 	 <c:if test="${contract.externalIndividual.capwebctIndividual == null}">
  					 	 capwebctIndividualId:"",
  					 	 </c:if>
        			 	 externalFamilyAccountId:"<c:out value="${contract.externalFamilyAccount.externalFamilyAccountId}" />+<c:out value="${contract.externalFamilyAccount.externalApplication.id}" />", 
        			 	 externalIndividualId:"<c:out value="${contract.externalIndividual.externalIndividualId}" />", 
        			 	 externalApplicationLabel:"<c:out value="${contract.externalFamilyAccount.externalApplication.label}" />"}
        			 	 // IE6 will see a extra null element if there is a trailing comma after the last element
        			 	<c:if test="${status.count < contractsSize}">,</c:if> 
  				</c:forEach>
    	]
    };
    		
	function formatEfaIdLink(elCell, oRecord, oColumn, oData) {
		var idTab = oData.split('+');
		elCell.innerHTML = "<a href='<c:url value='/familyaccount/search.jsp?efaId=" + idTab[0] 
			+ "&externalApplicationId=" + idTab[1] + "'/>' >" + idTab[0] + "</a>";
	}
	
	YAHOO.util.Event.addListener(window, "load", function() {
    YAHOO.contracts.Basic = new function() {
        var myColumnDefs = [
            {key:"contractId", sortable:true, label:"<fmt:message key='table.header.id'/>"},
            {key:"contractLabel", sortable:true, label:"<fmt:message key='table.header.label'/>"},
            {key:"contractValue", label:"<fmt:message key='table.header.value'/>"},
            {key:"contractDate", sortable:true, label:"<fmt:message key='table.header.date'/>"},
            {key:"contractBuyPrice", formatter:YAHOO.widget.DataTable.formatNumber,  
            	width:"5%", label:"<fmt:message key='table.header.buy_price'/>"},
            {key:"contractMinBuy", formatter:YAHOO.widget.DataTable.formatNumber, 
            	width:"5%", label:"<fmt:message key='table.header.min_buy'/>"},
            {key:"contractMaxBuy", formatter:YAHOO.widget.DataTable.formatNumber, 
            	width:"5%", label:"<fmt:message key='table.header.max_buy'/>"},
            {key:"capwebctIndividualId", formatter:YAHOO.widget.DataTable.formatNumber, 
            	width:"5%", label:"<fmt:message key='table.header.capwebct_individual_id'/>"},
            {key:"externalFamilyAccountId", sortable:true, formatter:formatEfaIdLink,
            	label:"<fmt:message key='table.header.external_family_account_id'/>"},
            {key:"externalIndividualId", sortable:true,
            	label:"<fmt:message key='table.header.external_individual_id'/>"},
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
        		key:"contractId", 
        		dir:"asc"
        	}
		};

        this.myDataSource = new YAHOO.util.DataSource(YAHOO.contracts.Data.contracts);
        this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        this.myDataSource.responseSchema = {
            fields: ["contractId","contractLabel","contractValue","contractDate",
					"contractBuyPrice","contractMinBuy","contractMaxBuy",
					"capwebctIndividualId", "externalFamilyAccountId", "externalIndividualId",
					"externalApplicationLabel"]
        };

        this.myDataTable = new YAHOO.widget.DataTable("contractsData",
                myColumnDefs, this.myDataSource, myConfigs);
    };
	});
	</c:if>
</script>
