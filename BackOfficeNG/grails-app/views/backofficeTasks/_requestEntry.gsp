<li>
  <a href="${createLink(controller:'backofficeRequestInstruction', action:'edit', id:record.id)}">
    <strong>
      <g:translateRequestTypeLabel label="${record.requestType.label}"/>
    </strong>
  </a>
  - <g:message code="request.searchResult.requestId" /> <strong>${record.id}</strong>
  - <g:message code="layout.from" /> <strong>${record.requesterLastName} ${record.requesterFirstName}</strong>
  <g:if test="${record.subjectLastName}">
    <g:message code="layout.for" /> ${record.subjectLastName} ${record.subjectFirstName}
  </g:if>
  - <g:message code="request.searchResult.creationDateLabel" />
  <strong>
    <g:formatDate formatName="format.fullDate" date="${record.creationDate}"/>
  </strong>
</li>