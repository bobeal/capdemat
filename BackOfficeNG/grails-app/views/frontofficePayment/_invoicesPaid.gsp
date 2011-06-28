<g:if test="${!invoicesPaid.isEmpty()}">
  <ul>
    <g:each var="record" in="${invoicesPaid}">
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
            <a href="<g:baseUrl controller='frontofficePayment' />/details/invoicePaid/${record.externalItemId}">
              <g:message code="payment.action.seeInvoiceDetails"/>
            </a>
          </p>
        </g:if>
        
      </li>
    </g:each>
  </ul>
</g:if>
<g:else>
  <p class="empty"><g:message code="message.noInvoices" /></p>
</g:else>
