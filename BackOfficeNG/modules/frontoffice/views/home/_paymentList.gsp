<h2>
  <g:message code="payment.header.lastPayments" /> :
</h2>
<g:if test="${dashBoard.payments?.all.size() > 0}">
  <ul>
    <g:each var="record" in="${dashBoard.payments.all}">
      <li>
        <p class="first-line"> 
          <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="payment.state" />
          <g:message code="payment.property.paymentMode" /> : 
          <span>${record.paymentMode},</span>
          <g:message code="payment.property.amount" /> : 
          <span>${record.amount},</span>
          <g:message code="payment.property.initializationDate" /> : 
          <span>${record.initializationDate},</span>
          <g:message code="payment.property.commitDate" /> : 
          <span>${record.commitDate}</span>
        </p>
        
      </li>
    </g:each>
  </ul>
  <a href="${createLink(controller:'frontofficePayment')}" id="showAllPayments">
    <g:message code="action.seeAll" />
  </a>
</g:if>
<g:else>
  <strong><g:message code="message.noDocuments" /></strong>
</g:else>