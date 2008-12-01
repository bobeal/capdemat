<g:if test="${requests?.count > 0}">
  <div class="pagination" id="pagination-top"></div>

  <ul>
    <g:each var="record" in="${requests?.records}">
      <li>
        <p class="first-line">
          <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" /> 
          <a href="${createLink(controller:'backofficeRequestInstruction', action:'edit',id:record.id)}">
          ${record.label}
          <g:message code="request.searchResult.requestId" /> 
          <span>${record.id}</span>
          - <g:message code="layout.from" /> 
          <span>${record.requesterLastName} ${record.requesterFirstName}</span>
          <g:if test="${record.subjectLastName && record.subjectLastName != ''}">
           <g:message code="layout.for" /> ${record.subjectLastName} ${record.subjectFirstName}
          </g:if>
          </a>
        </p>
        <p class="second-line">
          <g:message code="request.searchResult.creationDate" /> 
          <span>${record.creationDate}</span> - 
          <g:if test="${record.lastModificationDate}">
            <g:message code="request.property.lastModificationDate" /> ${record.lastModificationDate}
            <g:if test="${record.lastInterveningAgentId}">
              <g:message code="layout.by" /> ${record.lastInterveningAgentId}
            </g:if>
          </g:if> 
        </p>
      </li>
    </g:each>
  </ul>
  <div class="pagination" id="pagination-bottom"></div>
</g:if>
<g:else>
  <strong><g:message code="message.noRequests" /></strong>
</g:else>