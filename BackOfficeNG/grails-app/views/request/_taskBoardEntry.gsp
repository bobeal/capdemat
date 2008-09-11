<li>
  <a href="${createLink(controller:'requestInstruction', action:'edit',id: record.id)}">
    <strong>
      <g:translateRequestTypeLabel label="${record.requestType.label}"/>
    </strong>
  </a>
  - <g:message code="request.searchResult.requestId" /> <strong>${record.id}</strong>
  - <g:message code="layout.from" /> <strong>${record.requester.lastName}</strong>

   <g:message code="request.searchResult.creationDate" />
  <strong>
    <g:formatDate format="dd-MM-yyyy hh:mm" date="${record.creationDate}"/>
  </strong>
  <span class="state">${record.state}</span>
</li>

