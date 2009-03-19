<g:if test="${invoices.size() > 0}">
  <ul>
    <g:each var="record" in="${invoices}">
      <li>
        <p>
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
          ${record?.amount ? 'de '+record.amount / 100+' €':''}
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