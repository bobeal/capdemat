<g:if test="${ticketingContracts.size() > 0}">
  <ul>
    <g:each var="record" in="${ticketingContracts}">
      <li>
        <p>
          <span id="${record.type}_${record.reference}" class="payment-form" style="float:right">
            <form id="invoceForm_${record.reference}" method="post" 
              action="${createLink(action:'addToCart')}" class="list-form">
              <div class="error" 
                style="display:${unvalid?.id == record.reference && unvalid.type == record.type ? 'block' : 'none'}">
                ${errorMessage}
              </div>
              <input type="text" name="quantity" size="4" 
                value="${unvalid?.id == record.reference && unvalid.type == record.type ? unvalid.value : record.minBuy}"
                class="payment-textbox validate-mandatory validate-number 
                ${unvalid?.id == record.reference && unvalid.type == record.type ? 'validation-failed' : ''}" />
              ticket(s) 
              <button type="submit" title="${message(code:'action.addToCart')}">
                <img src="${createLinkTo(dir:'images/icons',file:'cart.png')}" 
                  alt="${message(code:'action.addToCart')}" />
              </button>
              <input type="hidden" name="externalItemId" value="${record.reference}"/>
              <input type="hidden" name="type" value="ticketingContracts"/>
            </form>
          </span>
          ${record.label} pour ${record.subjectName} - réf ${record.reference}
        </p>
        <p>
          ${record.oldQuantity} ticket(s) (${record.unitPrice / 100} € / piece)
        </p>
        <p>
          crée le <g:formatDate date="${record.creationDate}" formatName="format.date"/>
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
