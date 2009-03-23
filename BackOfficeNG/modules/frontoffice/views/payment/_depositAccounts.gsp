<g:if test="${depositAccounts.size() > 0}">
  <ul>
    <g:each var="record" in="${depositAccounts}">
      <li>
        <p>
          <span class="payment-form" style="float:right">
            <form id="invoceForm_${record.reference}" method="post" action="${createLink(action:'addToCart')}">
              <input type="text" name="amount" size="4" value="1" class="payment-textbox" /> € 
              <button type="submit" title="${message(code:'action.addToCart')}">
                <img src="${createLinkTo(dir:'images/icons',file:'cart.png')}" 
                  alt="${message(code:'action.addToCart')}" />
              </button>
              <input type="hidden" name="externalItemId" value="${record.reference}"/>
              <input type="hidden" name="type" value="depositAccounts"/>
            </form>
          </span>
          <g:if test="${record.hasDetails}">
            <a href="${createLink(controller:'frontofficePayment')}/details/deposit/${record.reference}">
              ${record.label} - réf ${record.reference}
            </a>
          </g:if>
          <g:else>
            ${record.label} - réf ${record.reference}
          </g:else>
        </p>
        <p>
          ${record?.amount ? 'de '+record.amount / 100+' €':''}
        </p>
        <p>
          fait le <g:formatDate date="${record.oldValueDate}" formatName="format.date"/>
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
