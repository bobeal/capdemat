<g:if test="${!ticketingContracts.isEmpty()}">
  <ul>
    <g:each var="record" in="${ticketingContracts}">
      <li>
        <p>
          Compte ${record.label} de ${record.subjectName} (réf ${record.reference})
        </p>
        <p>
          Statut au <g:formatDate date="${record.creationDate}" formatName="format.date"/> :
          <g:if test="${record.oldQuantity < 0}">
            <span style="color:red;">
              ${record.oldQuantity} ticket(s)
            </span>
          </g:if>
          <g:else>${record.oldQuantity} ticket(s)</g:else>
        </p>
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
                <!--
                <img src="${createLinkTo(dir:'images/icons',file:'cart.png')}"
                  alt="${message(code:'action.addToCart')}" />
                -->
                Ajouter au panier
              </button>
              <input type="hidden" name="externalItemId" value="${record.reference}"/>
              <input type="hidden" name="type" value="ticketingContracts"/>
            </form>
          </span>
          Prix unitaire du ticket : ${record.unitPrice / 100} € (achat min. ${record.minBuy} - achat max. ${record.maxBuy})
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
