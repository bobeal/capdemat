<g:if test="${!ticketingContracts.isEmpty()}">
  <ul>
    <g:each var="record" in="${ticketingContracts}">
      <li>
        <h3>
          <g:message code="payment.header.account"/> 
          "${record.label}" <g:message code="message.of"/> ${record.subjectName} 
          (<g:message code="message.ref"/> ${record.externalItemId})
        </h3>
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
        <form  method="post" action="${createLink(action:'addToCart')}" >
          <p class="error">
            ${invalid?.id == record.externalItemId && invalid.type == record.type ? message(code:'message.invalidFormat') : ''}
          </p>
          <label for="${record.type}_${record.externalItemId}"><g:message code="payment.property.quantity"/>:</label>
          <input type="text" name="quantity" size="4"
            id="${record.type}_${record.externalItemId}"
            value="${invalid?.id == record.externalItemId && invalid.type == record.type ? invalid.value : ''}"
            class="required validate-number ${invalid?.id == record.externalItemId && invalid.type == record.type ? 'validation-failed' : ''}" 
            title="${message(code:'message.invalidFormat')} " />
          <g:message code="payment.header.tickets"/>
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
  <p class="empty"><g:message code="message.noTicketingContracts" /></p>
</g:else>
