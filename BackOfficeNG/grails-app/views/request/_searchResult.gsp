<li>
  <p class="first-line">
    <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" /> 
    <a href="${createLink(controller:'requestInstruction', action:'edit',id:record.id)}">${record.label}
    - <g:message code="request.searchResult.requestId" /> <strong>${record.id}</strong>
    - <g:message code="layout.from" /> ${record.requesterLastName}
    <g:if test="${record.subjectLastName && record.subjectLastName != ''}">
     <g:message code="layout.for" /> ${record.subjectLastName}
    </g:if>
    </a>
  </p>

  <p class="second-line">
    <g:message code="request.searchResult.creationDate" /> ${record.creationDate} - 
    <g:message code="request.property.lastModificationDate" /> ${record.lastModificationDate} 
    <g:message code="layout.by" /> ${record.lastInterveningAgentId}
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

