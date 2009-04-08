<div class="list-box">
  <h2><g:message code="payment.header.lastPayments" /></h2>
  <g:if test="${dashBoard.payments?.all.size() > 0}">
    <ul>
      <g:each var="record" in="${dashBoard.payments.all}">
        <li>
            <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="payment.state" />
            <p>
              <g:message code="payment.property.payment" /> 
              <g:if test="${record.bankReference}">
                ${record.bankReference}
              </g:if>
              <g:message code="payment.searchResult.amount" /> 
              <span><g:formatNumber number="${record.amount / 100}" formatName="format.currency"/></span>
              - <g:message code="payment.searchResult.paidBy" />
              <span>${record.paymentMode}</span>
              - <g:message code="payment.searchResult.initializationDate" /> 
              <g:formatDate date="${record.initializationDate}" formatName="format.fullDate"/>
            </p>
        </li>
      </g:each>
    </ul>
    <p class="see-all">
      <a href="${createLink(controller:'frontofficePayment',action:'history')}" id="showAllPayments">
        <g:message code="action.seeAll" />
      </a>
    </p>
  </g:if>
  <g:else>
    <strong><g:message code="message.noPayments" /></strong>
  </g:else>
</div>
