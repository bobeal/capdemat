<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="account.search.title"/></title>
	<script type="text/javascript" src="<c:url value="/js/accountDetailPanel.js"/>"></script> 
	<%@ include file="/WEB-INF/views/common/account_table.jsp" %>
    <script type="text/javascript">
		YAHOO.util.Event.onContentReady('accountSearchFieldset', onDefaultSubmitButtonsMarkupReady);		
    </script>
  </head>
  
  <body>
  	
    <form method="post" action="#">
      <fieldset id="accountSearchFieldset">
        <legend><fmt:message key="account.search.search_legend"/></legend>
        <c:if test="${error_message != null}">
        	<div class="errors">
        		<fmt:message key="${error_message}">
        			<fmt:param value="${error_message_param}"></fmt:param>
        		</fmt:message>
        	</div>
        </c:if>
		<label for="id"><fmt:message key="account.account_id"/> : </label>
		<input type="text" id="id" name="id" value="<c:out value="${account.id}"/>"/>
		<br/>
		<label for="label"><fmt:message key="account.label"/> : </label>
		<input type="text" id="label" name="label" value="<c:out value="${account.label}"/>" />
		<br/>
		<label for="efaId">
			<fmt:message key="familyaccount.external_account_id"/> : 
		</label>
		<input type="text" id="efaId" name="efaId" 
			value="<c:out value="${account.efaId}"/>" />
		<br/>
		<label for="externalApplicationId">
			<fmt:message key="external_application.label"/> : 
		</label>
		<select id="externalApplicationId" name="externalApplicationId">
			<option value=""><fmt:message key="common.no_choice"/></option>
			<c:forEach items="${externalApplications}" var="externalApplication">
				<c:if test="${account.externalApplicationId == externalApplication.id}">
					<option value="<c:out value="${externalApplication.id}"/>" selected="selected">
						<c:out value="${externalApplication.label}" />
					</option>
				</c:if>
				<c:if test="${account.externalApplicationId != externalApplication.id}">
					<option value="<c:out value="${externalApplication.id}" />">
						<c:out value="${externalApplication.label}" />
					</option>
				</c:if>
			</c:forEach>
		</select>
		<br/>
        <label for="wrappedSubmit">&nbsp;</label>
		<input type="submit" id="wrappedSubmit" name="wrappedSubmit" 
			value="<fmt:message key="action.search"/>" />
      </fieldset>
    </form>
    
    <!--  where accounts data will appear in a table -->
    <c:if test="${accounts != null}">
    	<div id="search-results-paginator-top" class="search-results-paginator"></div>
    	<div  class="search-results yui-skin-sam">
    		<div id="accountsData"></div>
    	</div>
    	<div id="search-results-paginator-bottom" class="search-results-paginator"></div>
    </c:if>
    
    <!-- account detail panel messages, put here for i18n purposes -->
    <div id="accountPanelBodyTableHeaders" style="display:none;">
    	<span id="accountPanelBodyHeader"><fmt:message key="account.detail_panel.header" /></span>
    	<span id="accountPanelBodyTableHeaderSubject"><fmt:message key="account.detail_panel.subject" /></span>
		<span id="accountPanelBodyTableHeaderDate"><fmt:message key="account.detail_panel.date" /></span>
		<span id="accountPanelBodyTableHeaderValue"><fmt:message key="account.detail_panel.value" /></span>
		<span id="accountPanelBodyTableHeaderPaymentType"><fmt:message key="account.detail_panel.payment_type" /></span>
		<span id="accountPanelBodyTableHeaderPaymentAck"><fmt:message key="account.detail_panel.payment_ack" /></span>
		<span id="accountPanelBodyTableHeaderCvqAck"><fmt:message key="account.detail_panel.cvq_ack" /></span>
    </div>
    
  </body>  
</html>
