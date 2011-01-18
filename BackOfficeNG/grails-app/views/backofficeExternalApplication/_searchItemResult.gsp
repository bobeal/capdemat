<g:if test="${searchType == 'invoice'}">
    <li class="invoice">
      <p class="first-line">
        <g:capdematEnumToFlag var="${record.item.isPaid ? 'valid' : 'pending'}" i18nKeyPrefix="invoice.state" />
        <span class="reference">
          <g:message code="external.searchResult.property.invoice" /> ${record.item.externalItemId}
          <g:message code="external.searchResult.property.invoice.issueAt" /> <g:formatDate formatName="format.date" date="${record.item.issueDate}" />
          <g:if test="${record.homeFolderId != null}">
            <g:message code="external.searchResult.property.toHomeFolder" /> ${record.homeFolderId}
          </g:if>
        </span>
      </p>
      <p class="second-line">
        <g:message code="external.searchResult.property.externalLabel" /> : ${record.externalLabel} - 
        <g:message code="external.searchResult.property.broker" /> : ${record.item.supportedBroker}
      </p>
      <p class="second-line">
        ${record.item.label}, 
        <g:message code="external.searchResult.property.expirationDate" /> <g:formatDate formatName="format.date" date="${record.item.expirationDate}" />
      </p>
    </li>
</g:if>

<g:if test="${searchType == 'depositAccount'}">
    <li class="deposit-account">
      <p class="first-line">
        <span class="reference">
          <g:message code="external.searchResult.property.depositAccount" /> ${record.item.externalItemId}
          <g:if test="${record.homeFolderId != null}">
            <g:message code="external.searchResult.property.toHomeFolder" /> ${record.homeFolderId}
          </g:if>
        </span>
      </p>
      <p class="second-line">
        <g:message code="external.searchResult.property.externalLabel" /> : ${record.externalLabel} - 
        <g:message code="external.searchResult.property.broker" /> : ${record.item.supportedBroker}
      </p>
      <p class="second-line">
        ${record.item.label}, 
        <g:message code="external.searchResult.property.amount" /> : ${record.item.euroAmount + ' €'}
      </p>
    </li>
</g:if>

<g:if test="${searchType == 'ticketingContract'}">
    <li class="ticketing-contract">
      <p class="first-line">
        <span class="reference">
          <g:message code="external.searchResult.property.ticketingContract" /> ${record.item.externalItemId}
          <g:message code="external.searchResult.property.ticketingContract.createdAt" /> <g:formatDate formatName="format.date" date="${record.item.creationDate}" />
          <g:if test="${record.homeFolderId != null}">
            <g:message code="external.searchResult.property.toHomeFolder" /> ${record.homeFolderId}
          </g:if>
        </span>
      </p>
      <p class="second-line">
        <g:message code="external.searchResult.property.externalLabel" /> : ${record.externalLabel} - 
        <g:message code="external.searchResult.property.broker" /> : ${record.item.supportedBroker}
      </p>
      <p class="second-line">
        ${record.item.label}, 
        <g:message code="external.searchResult.property.amount" /> : ${record.item.amount}
      </p>
    </li>
</g:if>