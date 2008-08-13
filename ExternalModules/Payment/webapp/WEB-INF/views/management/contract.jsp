<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="contract.search.title"/></title>
	<%@ include file="/WEB-INF/views/common/contract_table.jsp" %>
    <script type="text/javascript">
		YAHOO.util.Event.onContentReady('contractSearchFieldset', onDefaultSubmitButtonsMarkupReady);
    </script>
  </head>
  
  <body>
  	
    <form method="post" action="#">
      <fieldset id="contractSearchFieldset">
        <legend><fmt:message key="contract.search.search_legend"/></legend>
        <c:if test="${error_message != null}">
        	<div class="errors">
        		<fmt:message key="${error_message}">
        			<fmt:param value="${error_message_param}"></fmt:param>
        		</fmt:message>
        	</div>
        </c:if>
		<label for="id"><fmt:message key="contract.contract_id"/> : </label>
		<input type="text" id="id" name="id" value="<c:out value="${contract.id}"/>"/>
		<br/>
		<label for="label"><fmt:message key="contract.label"/> : </label>
		<input type="text" id="label" name="label" value="<c:out value="${contract.label}"/>" />
		<br/>
		<label for="externalIndividualId"><fmt:message key="familyaccount.external_individual_id"/> : </label>
		<input type="text" id="externalIndividualId" name="externalIndividualId" 
			value="<c:out value="${contract.externalIndividualId}"/>" />
		<br/>
		<label for="efaId">
			<fmt:message key="familyaccount.external_account_id"/> : 
		</label>
		<input type="text" id="efaId" name="efaId" 
			value="<c:out value="${contract.efaId}"/>" />
		<br/>
		<label for="externalApplicationId">
			<fmt:message key="external_application.label"/> : 
		</label>
		<select id="externalApplicationId" name="externalApplicationId">
			<option value=""><fmt:message key="common.no_choice"/></option>
			<c:forEach items="${externalApplications}" var="externalApplication">
				<c:if test="${contract.externalApplicationId == externalApplication.id}">
					<option value="<c:out value="${externalApplication.id}"/>" selected="selected">
						<c:out value="${externalApplication.label}" />
					</option>
				</c:if>
				<c:if test="${contract.externalApplicationId != externalApplication.id}">
					<option value="<c:out value="${externalApplication.id}" />">
						<c:out value="${externalApplication.label}" />
					</option>
				</c:if>
			</c:forEach>
		</select>
		<br/>
        <label for="wrappedSubmit">&nbsp;</label>
        <input type="submit" id="wrappedSubmit" name="swrappedSubmit" 
        	value="<fmt:message key="action.search"/>"/>
      </fieldset>
    </form>
    
    <!--  where contracts data will appear in a table -->
    <c:if test="${contracts != null}">
    	<div id="search-results-paginator-top" class="search-results-paginator"></div>
    	<div  class="search-results yui-skin-sam">
    		<div id="contractsData"></div>
    	</div>
    	<div id="search-results-paginator-bottom" class="search-results-paginator"></div>
    </c:if>
    
  </body>  
</html>
