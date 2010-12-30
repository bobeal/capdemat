<li>
  <p class="first-line">
    <g:capdematEnumToFlag var="${trace.status}" i18nKeyPrefix="externalservice.trace.status" />
    <g:message code="requestExternalAction.property.date" />
    <span class="${sortBy == 'date' ? 'current-sort' : ''}">
      <g:formatDate formatName="format.date" date="${trace.date}" /></span> - 
    <g:message code="requestExternalAction.property.key" />
    <span class="${sortBy == 'key' ? 'current-sort' : ''}">${trace.key}</span> - 
    <g:message code="requestExternalAction.property.name" />
    <span class="${sortBy == 'name' ? 'current-sort' : ''}">${trace.externalServiceLabel}</span>
  </p>

  <p class="second-line">
    <g:capdematEnumToFlag var="${trace.request.state}" i18nKeyPrefix="request.state" />
    <g:if test="${trace.request.isViewable}">
      <a href="${createLink(controller:'backofficeRequestInstruction', action:'edit',id:trace.request.id)}">
    </g:if>
    ${trace.request.label}&nbsp;
    <g:message code="request.searchResult.requestId" />
    <span class="${sortBy == 'requestId' ? 'current-sort' : ''}">${trace.request.id}</span>
    - <g:message code="layout.from" />
    <span class="${sortBy == 'requesterLastName' ? 'current-sort' : ''}">
      ${trace.request.requesterLastName} ${trace.request.requesterFirstName}
    </span>
    <g:if test="${trace.request.subjectLastName}">
      <g:message code="layout.for" />
      <span class="${sortBy == 'subjectLastName' ? 'current-sort' : ''}">${trace.request.subjectLastName} ${trace.request.subjectFirstName}</span>
    </g:if>
    <span class="${sortBy == 'homeFolderId' ? 'current-sort' : ''}">(${trace.request.homeFolderId})</span>
    <g:if test="${trace.request.isViewable}">
      </a>
    </g:if>
  </p>

  <p class="third-line">
    ${trace.message}
  </p>
</li>
