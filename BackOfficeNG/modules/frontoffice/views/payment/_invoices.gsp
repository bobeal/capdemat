<g:if test="${!invoices.isEmpty()}">
  <ul>
    <g:each var="record" in="${invoices}">
      <li>
        <h3>
          <g:message code="payment.header.invoice"/> 
          "${record.label}" <g:message code="message.of"/> ${record.amount ? record.amount / 100 + ' €':''}
          (<g:message code="message.ref"/> ${record.externalItemId})
        </h3>
        <g:if test="${record.totalValue && record.totalValue != record.amount}">
          <p>
            <g:message code="payment.header.totalValue" /> : ${record.totalValue / 100} €
          </p>
        </g:if>
        <p>
          <g:message code="payment.header.issueAt"/>
          <g:formatDate date="${record.issueDate}" formatName="format.date"/> - 
          <g:message code="payment.header.expireAt"/>
          <g:formatDate date="${record.expirationDate}" formatName="format.date"/>
        </p>
        <g:if test="${record.hasDetails}">
          <p>
            <a href="${createLink(controller:'frontofficePayment')}/details/invoice/${record.externalItemId}">
              <g:message code="payment.action.seeInvoiceDetails"/>
            </a>
          </p>
        </g:if>
        <form  method="post" action="${createLink(action:'addToCart')}">
          <input type="submit" title="${message(code:'payment.action.addToCart')}"
            ${record.isInCart ?'disabled="disabled"':''}
            value="${message(code:'payment.action.addToCart')}" />
          <input type="hidden" name="externalItemId" value="${record.externalItemId}"/>
          <input type="hidden" name="type" value="${record.type}"/>
        </form>
      </li>
    </g:each>
  </ul>
</g:if>
<g:else>
  <p class="empty"><g:message code="message.noInvoices" /></p>
</g:else>
