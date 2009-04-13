<g:if test="${!ticketingContracts.isEmpty()}">
  <ul>
    <g:each var="record" in="${ticketingContracts}">
      <li>
        <p>
          <g:message code="payment.header.account"/> 
          ${record.label} <g:message code="message.of"/> ${record.subjectName} 
          (<g:message code="message.ref"/> ${record.externalItemId})
        </p>
        <p>
          <g:message code="payment.header.statusAt"/>
          <g:formatDate date="${record.creationDate}" formatName="format.date"/> :
          <g:if test="${record.oldQuantity < 0}">
            <span style="color:red;">
              ${record.oldQuantity} <g:message code="payment.header.tickets"/>
            </span>
          </g:if>
          <g:else>
            ${record.oldQuantity} <g:message code="payment.header.tickets"/>
          </g:else>
        </p>
        <p>
          <g:message code="payment.header.ticketUnitPrice"/> : ${record.unitPrice / 100} € 
          (<g:message code="payment.header.buyMin"/> ${record.minBuy} - 
          <g:message code="payment.header.buyMax"/> ${record.maxBuy})
        </p>
        <p>
          <span id="${record.type}_${record.externalItemId}" class="payment-form" style="float:right">
            <form id="invoceForm_${record.externalItemId}" method="post"
              action="${createLink(action:'addToCart')}" class="list-form">
              <div class="error"
                style="display:${invalid?.id == record.externalItemId && invalid.type == record.type ? 'block' : 'none'}">
                ${errorMessage}
              </div>
              <g:message code="payment.property.quantity"/> :
              <input type="text" name="quantity" size="4"
                value="${invalid?.id == record.externalItemId && invalid.type == record.type ? invalid.value : ''}"
                class="payment-textbox validate-mandatory validate-number
                ${invalid?.id == record.externalItemId && invalid.type == record.type ? 'validation-failed' : ''}" />
              <g:message code="payment.header.tickets"/>
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
  <strong>
    <g:message code="message.noRecords" />
  </strong>
</g:else>
