<g:if test="${requests?.count > 0}">
  <ul>
    <g:each var="record" in="${requests?.records}">
      <li>
        <p>
          <g:if test="${record?.draft}">
            <span class="tag-draft tag-state">
              <g:message code="request.property.draft"/>
            </span>
          </g:if>
          <g:else>
            <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" />
          </g:else>
          <a href="${createLink(controller:'backofficeRequestInstruction', action:'edit',id:record.id)}">
            ${record.label}
            <g:message code="request.searchResult.requestId" />
            <span>${record.id}</span>
            - <g:message code="layout.from" /> 
            <span>${record.requesterLastName} ${record.requesterFirstName}</span>
            <g:if test="${record.subjectLastName && record.subjectLastName != ''}">
             <g:message code="layout.for" />
             ${record.subjectLastName} ${record.subjectFirstName}
            </g:if>
          </a>
        </p>
        <p>
          <g:message code="request.searchResult.creationDate" 
            args="${[formatDate(date:record.creationDate,formatName:'format.date')]}"/> 
          <g:if test="${record.lastModificationDate}">
            - <g:message code="request.property.lastModificationDate" />
            <g:formatDate date="${record.lastModificationDate}" formatName="format.date" />
            <g:if test="${record.lastInterveningAgentId}">
              <g:message code="layout.by" />
              ${record.lastInterveningAgentId}
            </g:if>
          </g:if> 
        </p>
      </li>
    </g:each>
  </ul>
</g:if>
<g:else>
  <strong><g:message code="message.noRequests" /></strong>
</g:else>
