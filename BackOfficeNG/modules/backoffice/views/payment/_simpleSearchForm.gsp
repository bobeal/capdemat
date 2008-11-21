<h1><g:message code="payment.header.simpleSearch" /></h1>
<form method="POST" id="paymentForm" class="simple-search" action="<g:createLink action="loadPayments" />">
  <input type="text" id="searchQuery" name="searchQuery" size="80" value="${searchQuery}" />
  <span class="form-button">
	  <input  type="button" id="submitSearchPayment" name="submitSearchPayment" value="<g:message code="action.search" />" />
  </span>
</form>

