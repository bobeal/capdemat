<g:if test="${searchType == 'invoice'}">
    <li class="invoice">
      <p class="first-line">
        <g:capdematEnumToFlag var="${record.isPaid ? 'valid' : 'pending'}" i18nKeyPrefix="invoice.state" />
        <span class="reference">
          <g:message code="external.searchResult.property.invoice" /> ${record.externalItemId}
          <g:message code="external.searchResult.property.invoice.issueAt" /> <g:formatDate formatName="format.date" date="${record.issueDate}" />
        </span>
      </p>
      <p class="second-line">
        ${record.label}, 
        <g:message code="external.searchResult.property.expirationDate" /> <g:formatDate formatName="format.date" date="${record.expirationDate}" />
      </p>
    </li>
</g:if>

<g:if test="${searchType == 'depositAccount'}">
    <li class="deposit-account">
      <p class="first-line">
        <span class="reference">
          <g:message code="external.searchResult.property.depositAccount" /> ${record.externalItemId}
        </span>
      </p>
      <p class="second-line">
        ${record.label}, 
        <g:message code="external.searchResult.property.amount" /> : ${record.euroAmount + ' €'}
      </p>
    </li>
</g:if>

<g:if test="${searchType == 'ticketingContract'}">
    <li class="ticketing-contract">
      <p class="first-line">
        <span class="reference">
          <g:message code="external.searchResult.property.ticketingContract" /> ${record.externalItemId}
          <g:message code="external.searchResult.property.ticketingContract.createdAt" /> <g:formatDate formatName="format.date" date="${record.creationDate}" />
          </span>
      </p>
      <p class="second-line">
        ${record.label}, 
        <g:message code="external.searchResult.property.amount" /> : ${record.amount}
      </p>
    </li>
</g:if>