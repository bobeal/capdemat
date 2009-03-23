<g:if test="${invoices.size() > 0}">
  <ul>
    <g:each var="record" in="${invoices}">
      <li>
        <p>
          <span style="float:right">
            <form id="invoceForm_${record.reference}" method="post" action="${createLink(action:'addToCart')}">
              <button type="submit" title="${message(code:'action.addToCart')}" ${record.isInCart ?'disabled="disabled"':''} >
                <img src="${createLinkTo(dir:'images/icons',file:'cart.png')}" 
                  alt="${message(code:'action.addToCart')}" />
              </button
              <input type="hidden" name="externalItemId" value="${record.reference}"/>
              <input type="hidden" name="type" value="invoices"/>
            </form>
          </span>
          <g:if test="${record.hasDetails}">
            <a href="${createLink(controller:'frontofficePayment')}/details/invoice/${record.reference}">
              ${record.label} - réf ${record.reference}
            </a>
          </g:if>
          <g:else>
            ${record.label} - réf ${record.reference}
          </g:else>
        </p>
        <p>
          ${record?.amount ? 'de '+record.amount / 100 + ' €':''}
        </p>
        <p>
          crée le <g:formatDate date="${record.issueDate}" formatName="format.date"/>
          expire le <g:formatDate date="${record.expirationDate}" formatName="format.date"/>
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