<g:if test="${dashBoard.payments?.all.size() > 0}">
  <div class="list-box">
    <h2><g:message code="payment.header.lastPayments" /></h2>
    <ul>
      <g:each var="record" in="${dashBoard.payments.all}">
        <li>
          <span class="date">${formatDate(date:record.initializationDate,formatName:'format.date')}</span>

          <div class="content">
            <span class="action_and_tag-state">
              <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="payment.state" />
            </span>
            <a href="${createLink(controller:'frontofficePayment',action:'paymentDetails',id:record.id)}">
              ${formatNumber(number:record.amount / 100,formatName:'format.currency')}
              <g:if test="${record.bankReference}">
                - ${record.bankReference}
              </g:if>
            </a>
            <p>> <g:message code="payment.searchResult.paidBy" /> ${record.paymentMode}</p>
          </div>

        </li>
      </g:each>
    </ul>
    <p class="see-all">
      <a href="${createLink(controller:'frontofficePayment',action:'history')}" id="showAllPayments">
        <g:message code="action.seeAll" />
      </a>
    </p>
  </div>
</g:if>
