<div class="list-box">
  <h2><g:message code="payment.header.lastPayments" /></h2>
  <g:if test="${dashBoard.payments?.all.size() > 0}">
    <ul>
      <g:each var="record" in="${dashBoard.payments.all}">
        <li>
            <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="payment.state" />
            <p>
              <g:message code="payment.property.paymentMode" /> : 
              <span>${record.paymentMode},</span>
              <g:message code="payment.property.amount" /> : 
              <span>${record.amount},</span>
            </p>
            <p>
              <g:message code="payment.property.initializationDate" /> : 
              <span>${record.initializationDate},</span>
              <g:message code="payment.property.commitDate" /> : 
              <span>${record.commitDate}</span>
            </p>
        </li>
      </g:each>
    </ul>
    <p class="see-all">
      <a href="${createLink(controller:'frontofficePayment')}" id="showAllPayments">
        <g:message code="action.seeAll" />
      </a>
    </p>
  </g:if>
  <g:else>
    <strong><g:message code="message.noDocuments" /></strong>
  </g:else>
</div>
