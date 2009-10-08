<div class="narrow-box">
  <h3>
    <g:message code="payment.header.cart" />
  </h3>
  <div class="body">
    <g:if test="${session.payment}">
      
        <g:if test="${cart.invoices}">
          <h4><g:message code="payment.header.invoices"/></h4>
          <ul>
            <g:each in="${cart.invoices}" var="${record}">
              <li>${record.label} - ${record.amount / 100} € </li>
            </g:each>
          </ul>
        </g:if>
        <g:if test="${cart.depositAccounts}">
          <h4><g:message code="payment.header.depositAccounts"/></h4>
          <ul>
            <g:each in="${cart.depositAccounts}" var="${record}">
              <li>${record.label} - ${record.amount / 100} € </li>
            </g:each>
          </ul>
        </g:if>
        <g:if test="${cart.ticketingContracts}">
          <h4><g:message code="payment.header.ticketingContracts"/></h4>
          <ul>
            <g:each in="${cart.ticketingContracts}" var="${record}">
              <li>${record.label} - ${record.amount / 100} € </li>
            </g:each>
          </ul>
        </g:if>
      <h4 class="total">
        <g:message code="message.total" /> : ${session.payment.amount / 100} €
      </h4>
      <form action="${createLink(action:'pay')}" method="post">
        <g:if test="${session.payment && actionName != 'cartDetails'}">
          <a href="${createLink(action:'cartDetails')}"><g:message code="payment.header.cartDetails"/></a>
        </g:if>
        <input type="submit" value="${message(code:'action.pay')}" title="${message(code:'action.pay')}" />
        <input type="hidden" name="callbackUrl" value="${paymentUrl}" />
      </form>
    </g:if>
    <g:else>
      <g:message code="message.cartIsEmpty" />
    </g:else>
  </div>
</div>
