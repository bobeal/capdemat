<div class="txt-right" id="requestSearchSwitcher">
  <a href="${createLink(controller:'backofficePayment', action:'search')}"
     class="simple">
    <g:message code="action.goToPaymentSearch" /></a> |
  <a href="${createLink(controller:'backofficeExternalApplication', action:'searchInvoice')}"
     class="simple">
    <g:message code="action.goToInvoiceSearch" /></a> | 
  <a href="${createLink(controller:'backofficeExternalApplication', action:'searchDepositAccount')}"
     class="simple">
    <g:message code="action.goToDepositAccountSearch" /></a> |
  <a href="${createLink(controller:'backofficeExternalApplication', action:'searchTicketingContract')}"
     class="simple">
    <g:message code="action.goToTicketingContractSearch" /></a>
</div>

<div id="search-form">
<g:if test="${searchType == 'invoice'}">
  <h1><g:message code="external.header.searchInvoice" /></h1>
  <form method="post" id="searchForm" class="advanced-search" action="${createLink(action:"searchInvoice")}">
    <input type="hidden" id="pageState" name="pageState" value="${pageState}" />
    <input type="hidden" name="totalRecords" id="totalRecords" value="${totalRecords}" />
    <input type="hidden" name="recordOffset" id="recordOffset" value="${recordOffset}" />
    <input type="hidden" name="recordsReturned" id="recordsReturned" value="${recordsReturned}" />
    <input type="hidden" id="sortBy" name="sortBy" value="${sortBy}" />
    <input type="hidden" id="filterBy" name="filterBy" value="${filterBy}" />
    <div id="errorContainer" class="error"><!-- error container --></div>
    <div class="yui-g">
      <div class="yui-u first">
        <label for="homeFolderId"><g:message code="property.homeFolderId" /> :</label>
        <input type="text" name="homeFolderId" class="persistent" size="40" value="${state?.homeFolderId}" />
        <label for="externalInvoiceId"><g:message code="external.search.invoice.id" /> :</label>
        <input type="text" name="externalInvoiceId" class="persistent" size="40" value="${state?.externalInvoiceId}" />
      </div>

      <div class="yui-u">
        <label for="expirationDateBefore"><g:message code="external.search.invoice.expirationDateBefore" /> :</label>
        <input type="text" id="expirationDateBefore" name="expirationDateBefore" size="10" value="${params?.expirationDateBefore}" />
        <a>
          <img id="expirationDateBeforeShow" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
        </a>
        <div id="expirationDateBeforeCalContainer" class="yui-cal"></div>
        <label for="isPaid"><g:message code="external.search.invoice.state" /> :</label>
        <input type="checkbox" name="isPaid" value="true" class="persistent" ${state?.isPaid ? ' checked="checked"': ''} />
      </div>
    </div>
    <div class="form-button">
      <input type="submit" value="${message(code:"action.search")}" />
    </div>
  </form>
</g:if>

<g:if test="${searchType == 'depositAccount'}">
  <h1><g:message code="external.header.searchDepositAccount" /></h1>
  <form method="post" id="searchForm" class="advanced-search" action="${createLink(action:"searchDepositAccount")}">
    <input type="hidden" id="pageState" name="pageState" value="${pageState}" />
    <input type="hidden" name="totalRecords" id="totalRecords" value="${totalRecords}" />
    <input type="hidden" name="recordOffset" id="recordOffset" value="${recordOffset}" />
    <input type="hidden" name="recordsReturned" id="recordsReturned" value="${recordsReturned}" />
    <input type="hidden" id="sortBy" name="sortBy" value="${sortBy}" />
    <input type="hidden" id="filterBy" name="filterBy" value="${filterBy}" />
    <div id="errorContainer" class="error"><!-- error container --></div>
    <div class="yui-g">
      <div class="yui-u first">
        <label for="homeFolderId"><g:message code="property.homeFolderId" /> :</label>
        <input type="text" name="homeFolderId" class="persistent" size="40" value="${state?.homeFolderId}" />
        <label for="externalDepositAccountId"><g:message code="external.search.depositAccount.id" /> :</label>
        <input type="text" name="externalDepositAccountId" class="persistent" size="40" value="${state?.externalDepositAccountId}" />
      </div>
    </div>
    <div class="form-button">
      <input type="submit" value="${message(code:"action.search")}" />
    </div>
  </form>
</g:if>

<g:if test="${searchType == 'ticketingContract'}">
  <h1><g:message code="external.header.searchTicketingContract" /></h1>
  <form method="post" id="searchForm" class="advanced-search" action="${createLink(action:"searchTicketingContract")}">
    <input type="hidden" id="pageState" name="pageState" value="${pageState}" />
    <input type="hidden" name="totalRecords" id="totalRecords" value="${totalRecords}" />
    <input type="hidden" name="recordOffset" id="recordOffset" value="${recordOffset}" />
    <input type="hidden" name="recordsReturned" id="recordsReturned" value="${recordsReturned}" />
    <input type="hidden" id="sortBy" name="sortBy" value="${sortBy}" />
    <input type="hidden" id="filterBy" name="filterBy" value="${filterBy}" />
    <div id="errorContainer" class="error"><!-- error container --></div>
    <div class="yui-g">
      <div class="yui-u first">
        <label for="homeFolderId"><g:message code="property.homeFolderId" /> :</label>
        <input type="text" name="homeFolderId" class="persistent" size="40" value="${state?.homeFolderId}" />
        <label for="externalTicketingContractId"><g:message code="external.search.ticketingContract.id" /> :</label>
        <input type="text" name="externalTicketingContractId" class="persistent" size="40" value="${state?.externalTicketingContractId}" />
      </div>
    </div>
    <div class="form-button">
      <input type="submit" value="${message(code:"action.search")}" />
    </div>
  </form>
</g:if>
</div>
