<li class="request">
  <p class="first-line">
    <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" />
    <g:if test="${record.isViewable}">
      <a href="${createLink(controller:'backofficeRequestInstruction', action:'edit',id:record.id)}">
    </g:if>
    ${record.label}&nbsp;
    <g:message code="request.searchResult.requestId" /> 
    <span class="${sortBy == 'requestId' ? 'current-sort' : ''}">${record.id}</span>
    - <g:message code="layout.from" /> 
    <span class="${sortBy == 'requesterLastName' ? 'current-sort' : ''}">
      ${record.requesterLastName} ${record.requesterFirstName}
    </span>
    <g:if test="${record.subjectLastName}">
      <g:message code="layout.for" /> 
      <span class="${sortBy == 'subjectLastName' ? 'current-sort' : ''}">${record.subjectLastName} ${record.subjectFirstName}</span>
    </g:if>
    <span class="${sortBy == 'homeFolderId' ? 'current-sort' : ''}">(${record.homeFolderId})</span>
    <g:if test="${record.isViewable}">
      </a>
    </g:if>
  </p>

  <p class="second-line">
    <g:message code="request.searchResult.creationDateLabel" />
    <span class="${sortBy == 'creationDate' ? 'current-sort' : ''}">
      <g:formatDate formatName="format.date" date="${record.creationDate}" /></span> - 
    <g:if test="${record.lastModificationDate}">
      <g:message code="request.property.lastModificationDate" /> 
      <g:formatDate formatName="format.date" date="${record.lastModificationDate}" />
      <g:if test="${record.lastInterveningUserId}">
        <g:message code="layout.by" /> ${record.lastInterveningUserId}
      </g:if>
    </g:if> 
  </p>

  <p class="third-line">
    <g:message code="request.property.withAccount"/> : 
    <g:if test="${record.permanent}">
      <img src="${resource(dir:'images/icons',file:'12-check-green.png')}"/>
    </g:if>
    <g:else>
      <img src="${resource(dir:'images/icons',file:'HorsFoyerListe.gif')}"/>
    </g:else>
    - <g:message code="request.property.qualityOfService"/> :
    <g:if test="${record.quality == 'red'}">
      <img src="${resource(dir:'images/icons',file:'10-circle-red.png')}"/>
    </g:if>
    <g:elseif test="${record.quality == 'orange'}">
      <img src="${resource(dir:'images/icons',file:'10-circle-orange.png')}"/>
    </g:elseif>
    <g:else>
      <img src="${resource(dir:'images/icons',file:'10-circle-green.png')}"/>
    </g:else>
  </p>
  
</li>

