<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="familyaccount.search.title"/></title>
    <script type="text/javascript" src="<c:url value="/js/searchExternal.js"/>"></script>
  </head>
  
  <body>
  	
    <form id="efaSearchForm" method="post" action="#">
      <fieldset id="familyaccountSearchFieldset">
        <legend><fmt:message key="familyaccount.search.search_legend"/></legend>
        <c:if test="${error_message != null}">
        	<div class="errors">
        		<fmt:message key="${error_message}">
        			<fmt:param value="${error_message_param}"></fmt:param>
        		</fmt:message>
        	</div>
        </c:if>
		<label for="efaId">
			<fmt:message key="familyaccount.external_account_id"/> : 
		</label>
		<input type="text" id="efaId" name="efaId" />
		<br/>
		<label for="efaResponsible">
			<fmt:message key="familyaccount.capwebct_responsible_lastname"/> : 
		</label>
		<input type="text" id="efaResponsible" name="efaResponsible" />
		<br/>
		<label for="externalApplicationId">
			<fmt:message key="external_application.label"/> :
		</label>
		<select id="externalApplicationId" name="externalApplicationId">
			<option value=""><fmt:message key="common.no_choice"/></option>
			<c:forEach items="${externalApplications}" var="externalApplication">
				<option value="<c:out value="${externalApplication.id}" />">
					<c:out value="${externalApplication.label}" />
				</option>
			</c:forEach>
		</select>
		<br/>
        <label for="wrappedSubmit">&nbsp;</label>
        <input type="button" id="wrappedSubmit" name="wrappedSubmit" 
        	value="<fmt:message key="action.search"/>"/>
      </fieldset>
    </form>
    
    <!--  where family accounts data data will appear in a table -->
   	<div id="search-results-paginator-top" class="search-results-paginator"></div>
   	<div  class="search-results yui-skin-sam">
   		<div id="externalAccountsDatatable"></div>
   	</div>
   	<div id="search-results-paginator-bottom" class="search-results-paginator"></div>
    
    <!-- family accounts labels used by JS code, put here for i18n purposes -->
    <div id="familyAccountsLabels" style="display:none;">
    	<span id="faTableId"><fmt:message key='table.header.id'/></span>
    	<span id="faTableResponsible"><fmt:message key='table.header.responsible'/></span>
    	<span id="faTableAddress"><fmt:message key='table.header.address'/></span>
    	<span id="faTableExtApp"><fmt:message key='table.header.external_application_label'/></span>
    	<span id="faTableCfaId"><fmt:message key='table.header.capwebct_id'/></span>
    </div>
    
  </body>  
</html>

