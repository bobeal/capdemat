<g:if test="${!depositAccounts.isEmpty()}">
  <ul>
    <g:each var="record" in="${depositAccounts}">
      <li>
        <h3>
          <g:message code="payment.header.account"/> "${record.label}" 
          (<g:message code="message.ref"/> ${record.externalItemId})
        </h3>
        <p>
          <g:message code="payment.header.statusAt"/> 
          <g:formatDate date="${record.oldValueDate}" formatName="format.date"/> :
          <g:if test="${record.amount < 0}">
            <span style="color:red;">${record.amount / 100 + ' €'}</span>
          </g:if>
          <g:else>${record.oldValue / 100 + ' €'}</g:else>
        </p>
        <g:if test="${record.hasDetails}">
          <p>
            <a href="<g:baseUrl controller='frontofficePayment' />/details/deposit/${record.externalItemId}">
              <g:message code="payment.action.seeDepositAccountHistory"/>
            </a>
          </p>
        </g:if>
        <form  method="post" action="${createLink(action:'addToCart')}">
          <p class="error">
            ${invalid?.id == record.externalItemId && invalid.type == record.type ? message(code:'message.invalidFormat') : ''}
          </p>
          <label for="${record.type}_${record.externalItemId}"><g:message code="payment.property.amount"/>:</label>
          <input type="text" name="amount" size="4"
            id="${record.type}_${record.externalItemId}"
            value="${invalid?.id == record.externalItemId && invalid.type == record.type ? invalid.value : ''}"
            class="required validate-money
            ${invalid?.id == record.externalItemId && invalid.type == record.type ? 'validation-failed' : ''}" 
            title="${message(code:'message.invalidFormat')} " />
          €
          <input type="submit" title="${message(code:'payment.action.addToCart')}"
            value="${message(code:'payment.action.addToCart')}" />
          <input type="hidden" name="externalItemId" value="${record.externalItemId}"/>
          <input type="hidden" name="type" value="${record.type}"/>
        </form>
      </li>
    </g:each>
  </ul>
</g:if>
<g:else>
  <p class="empty"><g:message code="message.noDepositAccounts" /></p>
</g:else>
