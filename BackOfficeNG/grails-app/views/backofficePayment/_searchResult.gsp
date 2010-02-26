<li class="payment">
  <p class="first-line">
    <g:capdematEnumToFlag var="${record.paymentState}" i18nKeyPrefix="payment.state" />
    <span class="reference">
      <g:message code="payment.property.payment" /> ${record.cvqReference}
      - <g:message code="layout.from" />
      <span class="${sortBy == 'requesterLastName' ? 'current-sort' : ''}">
          ${record.requesterLastName}</span>
      <span class="${sortBy == 'homeFolderId' ? 'current-sort' : ''}">
          (${record.homeFolderId})</span>
      <g:message code="payment.searchResult.amount" /> <g:formatNumber number="${record.amount / 100}" formatName="format.currency"/>
	  </span>
  </p>
  <p class="second-line">
    <g:message code="payment.searchResult.initializationDate" />
    <span class="${sortBy == 'initializationDate' ? 'current-sort' : ''}">
      <g:formatDate formatName="format.date" date="${record.initializationDate}" /></span>
    <g:if test="${record.commitDate}">
      <g:message code="payment.searchResult.commitDate" /> <g:formatDate formatName="format.date" date="${record.commitDate}" />
    </g:if>
    <g:if test="${record.bankReference}">
      <g:message code="payment.searchResult.bankReference" /> ${record.bankReference}
    </g:if>
  </p>
  <p class="third-line">
    <g:message code="payment.searchResult.paidBy" /> <g:message code="payment.mode.${record.paymentMode.toString().toLowerCase()}" />
    - <g:message code="payment.searchResult.broker" /> : ${record.broker}
  </p>
</li>
