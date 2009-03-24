<div id="narrow" class="yui-b">
  <div class="requestBox">
    <h3>
      <g:message code="payment.header.cart" />
    </h3>
    <div class="body">
      <g:if test="${session.payment}">
        <ul class="cart-list">
          <g:if test="${cart.ticketingContracts}">
            <div class="header"><g:message code="payment.header.ticketingContracts"/>:</div>
            <g:each in="${cart.ticketingContracts}" var="${record}">
              <li>${record.label} - ${record.amount / 100} € </li>
            </g:each>
          </g:if>
          <g:if test="${cart.depositAccounts}">
            <div class="header"><g:message code="payment.header.depositAccounts"/>:</div>
            <g:each in="${cart.depositAccounts}" var="${record}">
              <li>${record.label} - ${record.amount / 100} € </li>
            </g:each>
          </g:if>
          <g:if test="${cart.invoices}">
            <div class="header"><g:message code="payment.header.invoices"/>:</div>
            <g:each in="${cart.invoices}" var="${record}">
              <li>${record.label} - ${record.amount / 100} € </li>
            </g:each>
          </g:if>
        </ul>
        <p style="text-align:right;font-weight:bold;margin-top:0.5em;">Total : ${session.payment.amount / 100} €</p>
        <p>
        <a href="${createLink(action:'cartDetails')}" target="_self">
          <g:message code="action.finishShopping"/>
        </a>
        </p>
      </g:if>
      <g:else>
        <g:message code="message.cartIsEmpty" />
      </g:else>
    </div>
  </div>
</div>