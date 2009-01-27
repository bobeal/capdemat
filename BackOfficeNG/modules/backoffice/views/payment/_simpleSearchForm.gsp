<div class="txt-right" id="paymentSearchSwitcher">
  <g:message code="action.goToSimpleSearch" /> |
  <a href="javascript:void(0);" class="advanced"><g:message code="action.goToAdvancedSearch" /></a>
</div>

<div id="search-form">
  <h1><g:message code="payment.header.simpleSearch" /></h1>
  <form method="POST" id="paymentForm" class="simple-search" action="<g:createLink action="search" />">
    <input type="text" id="searchQuery" name="searchQuery" size="80" value="${searchQuery}" />
	 <span class="form-button">
	   <input type="button" id="submitSearchPayment" name="submitSearchPayment" value="<g:message code="action.search" />" />
      <input type="hidden" id="totalRecords" name="totalRecords" value="${totalRecords}" />
      <input type="hidden" id="recordsReturned" name="recordsReturned" value="${recordsReturned}" />
      <input type="hidden" id="recordOffset" name="recordOffset" value="${recordOffset}" />
      <input type="hidden" id="paginatorChange" name="paginatorChange" />
      <input type="hidden" id="sortBy" name="sortBy" value="${sortBy}" />
      <input type="hidden" id="filterBy" name="filterBy" value="${filterBy}" />
	   <input type="hidden" id="mode" name="mode" value="simple" />
	 </span>
  </form>
</div>
