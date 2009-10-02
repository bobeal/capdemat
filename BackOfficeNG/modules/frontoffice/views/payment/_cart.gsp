<div class="yui-b">
  <div class="narrow-box action-list">
    <h3>
      <g:message code="payment.header.cart" />
    </h3>
    <div class="body">
      <g:if test="${session.payment}">
        
          <g:if test="${cart.invoices}">
            <div class="cart-list-header"><g:message code="payment.header.invoices"/></div>
            <ul class="cart-list">
              <g:each in="${cart.invoices}" var="${record}">
                <li>${record.label} - ${record.amount / 100} € </li>
              </g:each>
            </ul>
          </g:if>
          <g:if test="${cart.depositAccounts}">
            <div class="cart-list-header"><g:message code="payment.header.depositAccounts"/></div>
            <ul class="cart-list">
              <g:each in="${cart.depositAccounts}" var="${record}">
                <li>${record.label} - ${record.amount / 100} € </li>
              </g:each>
            </ul>
          </g:if>
          <g:if test="${cart.ticketingContracts}">
            <div class="cart-list-header"><g:message code="payment.header.ticketingContracts"/></div>
            <ul class="cart-list">
              <g:each in="${cart.ticketingContracts}" var="${record}">
                <li>${record.label} - ${record.amount / 100} € </li>
              </g:each>
            </ul>
          </g:if>
        <p class="total-block">
          <span><g:message code="message.total" /> : ${session.payment.amount / 100} €</span>
          <g:if test="${session.payment && actionName != 'cartDetails'}">
            <a href="${createLink(action:'cartDetails')}" target="_self">
              <g:message code="payment.header.cartDetails"/>
            </a>
          </g:if>
        </p>
        <div class="button-panel">
          <form action="${createLink(action:'pay')}" method="post">
            <input type="submit" value="${message(code:'action.pay')}" />
            <input type="hidden" name="callbackUrl" value="${paymentUrl}" />
          </form>
        </div>
      </g:if>
      <g:else>
        <g:message code="message.cartIsEmpty" />
      </g:else>
    </div>
  </div>
</div>