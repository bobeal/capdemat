<div class="list-box">
  <h2><g:message code="request.header.lastRequests" /></h2>
  <g:if test="${dashBoard.requests?.count > 0}">
    <ul>
      <g:each var="record" in="${dashBoard.requests.records}">
        <li>
            <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" />
            ${record.label}
            <g:message code="request.searchResult.requestId" /> 
            <span>${record.id}</span>
            - <g:message code="layout.from" /> 
            <span>${record.requesterLastName} ${record.requesterFirstName}</span>
            <g:if test="${record.subjectLastName && record.subjectLastName != ''}">
             <g:message code="layout.for" /> ${record.subjectLastName} ${record.subjectFirstName}
            </g:if>
        </li>
      </g:each>
    </ul>
    <p class="see-all">
      <a href="${createLink(controller:'frontofficeRequest')}" id="showAllRequests">
        <g:message code="action.seeAll" />
      </a>
    </p>
  </g:if>
  <g:else>
    <strong><g:message code="message.noRequests" /></strong>
  </g:else>
</div>
