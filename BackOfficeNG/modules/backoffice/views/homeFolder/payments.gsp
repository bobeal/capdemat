<g:if test="${payments.size()}">
  <ul>
    <g:each var="record" in="${payments}">
      <li>
        <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="payment.state"/>
        <p>
          <g:message code="payment.property.payment"/>
          <g:if test="${record.bankReference}">
            ${record.bankReference}
          </g:if>
          <g:message code="payment.searchResult.amount"/>
          <span><g:formatNumber number="${record.amount / 100}" formatName="format.currency"/></span>
          - <g:message code="payment.searchResult.paidBy"/>
          <span>${record.paymentMode}</span>
          <g:message code="payment.searchResult.initializationDate"/>
          <g:formatDate date="${record.initializationDate}" formatName="format.fullDate"/>
        </p>
      </li>
    </g:each>
  </ul>
</g:if>
<g:else>
  <strong><g:message code="message.noResultFound"/></strong>
</g:else>