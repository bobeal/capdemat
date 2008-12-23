<li>
  <p class="first-line">
    <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" /> 
    <a href="${createLink(controller:'backofficeRequestInstruction', action:'edit',id:record.id)}">${record.label}
    <g:message code="request.searchResult.requestId" /> 
    <span class="${sortBy == 'requestId' ? 'current-sort' : ''}">${record.id}</span>
    - <g:message code="layout.from" /> 
    <span class="${sortBy == 'requesterLastName' ? 'current-sort' : ''}">
      ${record.requesterLastName} ${record.requesterFirstName}
    </span>
    <g:if test="${record.subjectLastName}">
      <g:message code="layout.for" /> ${record.subjectLastName} ${record.subjectFirstName}
    </g:if>
    <span class="${sortBy == 'homeFolderId' ? 'current-sort' : ''}">(${record.homeFolderId})</span>
    </a>
  </p>

  <p class="second-line">
    <g:message code="request.searchResult.oldCreationDate" /> 
    <span class="${sortBy == 'creationDate' ? 'current-sort' : ''}">
      <g:formatDate formatName="format.date" date="${record.creationDate}" /></span> - 
    <g:if test="${record.lastModificationDate}">
      <g:message code="request.property.lastModificationDate" /> 
      <g:formatDate formatName="format.date" date="${record.lastModificationDate}" />
      <g:if test="${record.lastInterveningAgentId}">
        <g:message code="layout.by" /> ${record.lastInterveningAgentId}
      </g:if>
    </g:if> 
  </p>

  <p class="third-line">
    CP : 
    <g:if test="${record.permanent}">
      <img src="${createLinkTo(dir:'images',file:'12-em-check.png')}"/>
    </g:if>
    <g:else>
      <img src="${createLinkTo(dir:'images',file:'12-em-cross.png')}"/>
    </g:else>
    - QS :
    <g:if test="${record.quality == 'red'}">
      <img src="${createLinkTo(dir:'images',file:'circle-red-10.png')}"/>
    </g:if>
    <g:elseif test="${record.quality == 'orange'}">
      <img src="${createLinkTo(dir:'images',file:'circle-orange-10.png')}"/>
    </g:elseif>
    <g:else>
      <img src="${createLinkTo(dir:'images',file:'circle-green-10.png')}"/>
    </g:else>
  </p>
  
</li>

