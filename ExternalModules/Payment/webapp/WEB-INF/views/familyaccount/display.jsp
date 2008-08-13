<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="familyaccount.accounts.title"/></title>
	<script type="text/javascript" src="<c:url value="/js/invoiceDetailPanel.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/accountDetailPanel.js"/>"></script>
	<%@ include file="/WEB-INF/views/common/invoice_table.jsp" %>
	<%@ include file="/WEB-INF/views/common/account_table.jsp" %>
	<%@ include file="/WEB-INF/views/common/contract_table.jsp" %>
  </head>
  
  <body>
  
      <c:if test="${error_message != null}">
       	<div class="errors">
       		<fmt:message key="${error_message}">
       			<c:if test="${error_message_param}">
       				<fmt:param value="${error_message_param}"></fmt:param>
       			</c:if>
       		</fmt:message>
       	</div>
     </c:if>
 
     <c:if test="${error_message == null}">
    	<div id="body-header">
		<!-- 
  		<div style="float:left;display:block;clear:both;margin-left:10px;">
			<a href="<c:url value="/familyaccount/${searchOrigin}.jsp${familyAccountSearchQuery}"/>">
				<fmt:message key="familyaccount.link.back_to_search"/>
			</a>
  		</div>
		<br/>
		-->
		
  		<h1>
  			<fmt:message key="familyaccount.accounts.header">
  				<fmt:param value="${familyaccount.capwebctFamilyAccountId}"></fmt:param>
  				<fmt:param value="${familyaccount.responsibleFullName}"></fmt:param>
  			</fmt:message>
  		</h1>
  		
		</div>  	
  	</c:if>
  	
    <!--  where invoices data will appear in a table -->
    <c:if test="${invoices != null}" >
    
    <h2><fmt:message key="familyaccount.accounts.invoices_title"/></h2>
    <div class="accounts-results yui-skin-sam">
    	<div id="invoicesData"></div>
    </div>
    
    <!-- invoice detail panel messages, put here for i18n purposes -->
    <div id="invoicePanelBodyTableHeaders" style="display:none;">
    	<span id="invoicePanelBodyHeader"><fmt:message key="invoice.detail_panel.header" /></span>
    	<span id="invoicePanelBodyTableHeaderLabel"><fmt:message key="invoice.detail_panel.label" /></span>
		<span id="invoicePanelBodyTableHeaderSubject"><fmt:message key="invoice.detail_panel.subject" /></span>
		<span id="invoicePanelBodyTableHeaderUnitPrice"><fmt:message key="invoice.detail_panel.unit_price" /></span>
		<span id="invoicePanelBodyTableHeaderQuantity"><fmt:message key="invoice.detail_panel.quantity" /></span>
		<span id="invoicePanelBodyTableHeaderValue"><fmt:message key="invoice.detail_panel.value" /></span>
    </div>
    
    </c:if>
    
    <!--  where accounts data will appear in a table -->
    <c:if test="${accounts != null}" >
    
    <h2><fmt:message key="familyaccount.accounts.accounts_title"/></h2>
    <div class="accounts-results yui-skin-sam">
    	<div id="accountsData"></div>
    </div>
    
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
    
    </c:if>
    
    <!--  where contracts data will appear in a table -->
    <c:if test="${contracts != null}" >
    
    <h2><fmt:message key="familyaccount.accounts.contracts_title"/></h2>
    <div class="accounts-results yui-skin-sam">
    	<div id="contractsData"></div>
    </div>
    
    </c:if>
    
  </body>  
</html>
 	
    