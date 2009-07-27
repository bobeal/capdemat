<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="admin.audit.title"/></title>
    <script type="text/javascript">	
    <c:if test="${externalImportAudits != null}" >
	YAHOO.namespace("audit");
	YAHOO.audit.Data = {
    	audit: [
    		  	<c:forEach items="${externalImportAudits}" var="audit" varStatus="status">
  					{importType:"<c:out value="${audit.importType}" />",
  					 externalApplicationLabel:"<c:out value="${audit.externalApplicationLabel}" />", 
  					 broker:"<c:out value="${audit.broker}" />",
  					 externalDataType:"<fmt:message key="${audit.externalDataType.i18nKey}" />",
  					 date:"<fmt:formatDate value="${audit.date}" type="both" dateStyle="short" timeStyle="short" />", 
        			 agent:"<c:out value="${audit.agent.login}" />"}
        			 // IE6 will see a extra null element if there is a trailing comma after the last element
        			 <c:if test="${status.count < externalImportAuditsSize}">,</c:if>
  				</c:forEach>
    	]
    };
    		
	YAHOO.util.Event.addListener(window, "load", function() {
    YAHOO.audit.Basic = new function() {
        var myColumnDefs = [
            {key:"importType", sortable:true, label:"<fmt:message key='table.header.import_type'/>"},
            {key:"externalApplicationLabel", sortable:true, label:"<fmt:message key='table.header.external_application_label'/>"},
            {key:"broker", sortable:true, label:"<fmt:message key='table.header.broker'/>"},
            {key:"externalDataType", sortable:true, label:"<fmt:message key='table.header.external_data_type'/>"},
            {key:"date", sortable:true, label:"<fmt:message key='table.header.date'/>"},
            {key:"agent", sortable:true, label:"<fmt:message key='table.header.agent'/>"}
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
        		key:"date", 
        		dir:YAHOO.widget.DataTable.CLASS_DESC
        	}
		};

        this.myDataSource = new YAHOO.util.DataSource(YAHOO.audit.Data.audit);
        this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        this.myDataSource.responseSchema = {
            fields: ["importType","externalApplicationLabel","broker","externalDataType","date",
            	"agent"]
        };

        this.myDataTable = new YAHOO.widget.DataTable("auditData",
                myColumnDefs, this.myDataSource, myConfigs);
    };
	});
	</c:if>
    </script>
    
  </head>
  
  <body>
  
    <!--  where audit data will appear in a table -->
    <c:if test="${externalImportAudits != null}">
    	<div id="search-results-paginator-top" class="search-results-paginator"></div>
    	<div  class="search-results yui-skin-sam">
    		<div id="auditData"></div>
    	</div>
    	<div id="search-results-paginator-bottom" class="search-results-paginator"></div>
    </c:if>
    
  </body>  
</html>
