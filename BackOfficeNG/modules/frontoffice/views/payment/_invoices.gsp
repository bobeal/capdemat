<g:if test="${invoices.size() > 0}">
  <ul>
    <g:each var="record" in="${invoices}">
      <li>
        <p>
          <g:if test="${record.hasDetails}">
            <a href="${createLink(controller:'frontofficePayment')}/details/invoice/${record.externalItemId}">
              <g:message code="payment.header.invoice"/> 
              ${record.label} <g:message code="message.of"/> ${record.amount ? record.amount / 100 + ' €':''}
              (<g:message code="message.ref"/> ${record.externalItemId})
            </a>
          </g:if>
          <g:else>
            <g:message code="payment.header.invoice"/>
            ${record.label} <g:message code="message.of"/> ${record.amount ? record.amount / 100 + ' €':''}
            (<g:message code="message.ref"/> ${record.externalItemId})
          </g:else>
        </p>
        <p>
          <span style="float:right">
            <form id="invoceForm_${record.externalItemId}" method="post" action="${createLink(action:'addToCart')}">
              <input type="submit" title="${message(code:'action.addToCart')}" 
                ${record.isInCart ?'disabled="disabled"':''}
                value="${message(code:'action.addToCart')}" />
              <input type="hidden" name="externalItemId" value="${record.externalItemId}"/>
              <input type="hidden" name="type" value="${record.type}"/>
            </form>
          </span>
          <g:message code="payment.header.issueAt"/>
          <g:formatDate date="${record.issueDate}" formatName="format.date"/> - 
          <g:message code="payment.header.expireAt"/>
          <g:formatDate date="${record.expirationDate}" formatName="format.date"/>
        </p>
      </li>
    </g:each>
  </ul>
</g:if>
<g:else>
  <strong>
    <g:message code="message.noRecords" />
  </strong>
</g:else>