<g:if test="${invoices.size() > 0}">
  <ul>
    <g:each var="record" in="${invoices}">
      <li>
        <p>
          ${record.label} 
          ${record?.amount ? 'de '+record.amount / 100+' €':''}
          ${record?.subjectName ? 'pour '+record.subjectName:''}
          - réf ${record.reference} 
        </p>
        <g:if test="${!record.noDetails}">
          <p>
            Quantité : ${record.quantity} (${record.unitPrice / 100} € / piece)
            crée le ${formatDate(date:record.issueDate,formatName:'format.date')}
            expire le ${formatDate(date:record.expirationDate,formatName:'format.date')}
          </p>
        </g:if>
      </li>
    </g:each>
  </ul>
</g:if>
<g:else>
  <strong>
    <g:message code="message.noRecords" />
  </strong>
</g:else>