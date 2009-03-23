<div id="narrow" class="yui-b">
  <div id="requestSubject" class="requestBox">
    <h3>
      <g:message code="payment.header.cart" />
    </h3>
    <div class="body">
      <g:if test="${session.payment}">
        <ul class="cart-list">
          <g:each in="${session.payment.purchaseItems}" var="${record}">
            <li>
              ${record.label} de ${record.amount / 100} €
            </li>
          </g:each>
        </ul>
        <a href="${createLink(action:'cartDetails')}" target="_self">
          <g:message code="action.accessToPayment"/>
        </a>
      </g:if>
      <g:else>
        <g:message code="message.cartIsEmpty" />
      </g:else>
    </div>
  </div>
</div>