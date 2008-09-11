<li>
  <span class="first-line">
    <a href="${createLink(controller:'requestInstruction', action:'edit',id:record.id)}"><strong>${record.label}</strong></a>
    - <g:message code="request.searchResult.requestId" /> <strong>${record.id}</strong>
    - <g:message code="layout.from" /> <strong>${record.requesterLastName}</strong>
    <g:if test="${record.subjectLastName && record.subjectLastName != ''}">
     <g:message code="layout.for" /> <strong>${record.subjectLastName}</strong> -
    </g:if>
    <g:else> - </g:else>
    <g:message code="request.searchResult.creationDate" /> <strong>${record.creationDate}</strong>
  </span>
  <br/>

  <span class="second-line">
    <g:message code="request.property.lastModificationDate" /> ${record.lastModificationDate} 
    <g:message code="layout.by" /> ${record.lastInterveningAgentId}
  </span>
  <br/>

  <span class="third-line">
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
    - <span class="state">${record.state}</span>
  </span>
</li>

