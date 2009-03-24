<g:if test="${!depositAccounts.isEmpty()}">
  <ul>
    <g:each var="record" in="${depositAccounts}">
      <li>
        <p>
          <g:if test="${record.hasDetails}">
            <a href="${createLink(controller:'frontofficePayment')}/details/deposit/${record.reference}">
              Compte ${record.label} (réf ${record.reference})
            </a>
          </g:if>
          <g:else>Compte ${record.label} (réf ${record.reference})</g:else>
        </p>
        <p>
          <span id="${record.type}_${record.reference}" class="payment-form" style="float:right">
            <form id="invoceForm_${record.reference}" method="post"
              action="${createLink(action:'addToCart')}" class="list-form">
              <div class="error"
                style="display:${unvalid?.id == record.reference && unvalid.type == record.type ? 'block' : 'none'}">
                ${errorMessage}
              </div>
              <input type="text" name="amount" size="4"
                value="${unvalid?.id == record.reference && unvalid.type == record.type ? unvalid.value : 1}"
                class="payment-textbox validate-mandatory validate-money
                ${unvalid?.id == record.reference && unvalid.type == record.type ? 'validation-failed' : ''}" />
              €
              <button type="submit" title="${message(code:'action.addToCart')}">
                <!--
                <img src="${createLinkTo(dir:'images/icons',file:'cart.png')}"
                  alt="${message(code:'action.addToCart')}" />
                -->
                Ajouter au panier
              </button>
              <input type="hidden" name="externalItemId" value="${record.reference}"/>
              <input type="hidden" name="type" value="depositAccounts"/>
            </form>
          </span>
          Statut au <g:formatDate date="${record.oldValueDate}" formatName="format.date"/> :
          <g:if test="${record.amount < 0}">
            <span style="color:red;">${record.amount / 100 + ' €'}</span>
          </g:if>
          <g:else>${record.amount ? record.amount / 100 + ' €':''}</g:else>
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
