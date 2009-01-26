<g:if test="${dashBoard.drafts?.count > 0}">
  <div class="list-box">
    <h2><g:message code="request.header.lastDrafts" /></h2>
      <ul>
        <g:each var="record" in="${dashBoard.drafts.records}">
          <li>
              <span class="tag-state">
                <a href="${module.createLink(module:'frontoffice',action:'draft',controller:'DomesticHelpRequest')}/${record.id}">
                  <g:message code="action.modify"/>
                </a>
              </span>
              ${record.label}
              <g:message code="request.searchResult.requestId" /> 
              <span>${record.id}</span>
              - <g:message code="layout.from" /> 
              <span>${record.requesterLastName} ${record.requesterFirstName}</span>
              <g:if test="${record.subjectLastName && record.subjectLastName != ''}">
               <g:message code="layout.for" /> ${record.subjectLastName} ${record.subjectFirstName}
              </g:if>
              - <g:message code="request.searchResult.creationDate"
                args="${[formatDate(date:record.creationDate,formatName:'format.date')]}" />
          </li>
        </g:each>
      </ul>
      <p class="see-all">
        <a href="${createLink(controller:'frontofficeRequest')}" id="showAllDrafts">
          <g:message code="action.seeAll" />
        </a>
      </p>
  </div>
</g:if>