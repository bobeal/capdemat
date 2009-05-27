<g:if test="${!depositAccounts.isEmpty()}">
  <ul>
    <g:each var="record" in="${depositAccounts}">
      <li>
        <p>
          <g:message code="payment.header.account"/> ${record.label} 
          (<g:message code="message.ref"/> ${record.externalItemId})
        </p>
        <p>
          <g:message code="payment.header.statusAt"/> 
          <g:formatDate date="${record.oldValueDate}" formatName="format.date"/> :
          <g:if test="${record.amount < 0}">
            <span style="color:red;">${record.amount / 100 + ' €'}</span>
          </g:if>
          <g:else>${record.amount ? record.amount / 100 + ' €':''}</g:else>
        </p>
        <g:if test="${record.hasDetails}">
          <p>
            <a href="${createLink(controller:'frontofficePayment')}/details/deposit/${record.externalItemId}">
              <g:message code="payment.action.seeDepositAccountHistory"/>
            </a>
          </p>
        </g:if>
        <p>
          <span id="${record.type}_${record.externalItemId}" class="payment-form" style="float:right">
            <form id="invoceForm_${record.externalItemId}" method="post"
              action="${createLink(action:'addToCart')}" class="list-form">
              <div class="error"
                style="display:${invalid?.id == record.externalItemId && invalid.type == record.type ? 'block' : 'none'}">
                ${errorMessage}
              </div>
              <g:message code="payment.property.amount"/> :
              <input type="text" name="amount" size="4"
                value="${invalid?.id == record.externalItemId && invalid.type == record.type ? invalid.value : ''}"
                class="payment-textbox validate-mandatory validate-money
                ${invalid?.id == record.externalItemId && invalid.type == record.type ? 'validation-failed' : ''}" />
              €
              <input type="submit" title="${message(code:'payment.action.addToCart')}"
                value="${message(code:'payment.action.addToCart')}" />
              <input type="hidden" name="externalItemId" value="${record.externalItemId}"/>
              <input type="hidden" name="type" value="${record.type}"/>
            </form>
          </span>
        </p>
      </li>
    </g:each>
  </ul>
</g:if>
<g:else>
  <p class="empty"><g:message code="message.noDepositAccounts" /></p>
</g:else>
