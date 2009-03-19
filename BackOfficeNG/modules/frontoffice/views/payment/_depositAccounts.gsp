<g:if test="${depositAccounts.size() > 0}">
  <ul>
    <g:each var="record" in="${depositAccounts}">
      <li>
        <p>
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
