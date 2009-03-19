<g:if test="${ticketingContracts.size() > 0}">
  <ul>
    <g:each var="record" in="${ticketingContracts}">
      <li>
        <p>
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
