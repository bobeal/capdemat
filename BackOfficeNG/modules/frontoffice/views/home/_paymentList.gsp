<h2>
  <g:message code="payment.header.lastPayments" /> :
</h2>
<g:if test="${dashBoard.payments?.all.size() > 0}">
  <ul>
    <g:each var="record" in="${dashBoard.payments.all}">
      <li>
        <p class="first-line"> 
          <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="payment.state" />
          <g:message code="payment.header.profilePayment"
            args="[record.bankReference, 
                  format('value':record.amount/100,'formatName':'format.currency'),
                  format('value':record.initializationDate,'formatName':'format.date')]"
          />
        </p>
        
      </li>
    </g:each>
  </ul>
  <a href="${createLink(controller:'frontofficePayment')}" id="showAllPayments">
    <g:message code="action.seeAll" />
  </a>
</g:if>
<g:else>
  <strong><g:message code="message.noPayments" /></strong>
</g:else>