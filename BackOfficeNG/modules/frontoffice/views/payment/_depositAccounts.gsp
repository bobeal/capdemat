<g:if test="${depositAccounts.size() > 0}">
  <ul>
    <g:each var="record" in="${depositAccounts}">
      <li>
        <p>
          ${record.label} 
          ${record?.amount ? 'de '+record.amount / 100+' €':''}
          ${record?.holderName ? 'pour '+record.holderName:''} 
          - réf ${record.reference}
        </p>
        <p>
          fait le ${formatDate(date:record.oldValueDate,formatName:'format.date')}
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
