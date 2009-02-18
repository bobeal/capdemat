<g:if test="${dashBoard.drafts?.count > 0}">
  <div class="list-box">
    <h2><g:message code="request.header.drafts" /></h2>
      <ul>
        <g:each var="record" in="${dashBoard.drafts.records}">
          <li>
              <span class="tag-state">
                <g:message code="action.remove"/>
              </span>
              <a href="${module.createLink(module:'frontoffice',action:'draft',controller:'RequestCreation')}/?id=${record.id}&requestTypeLabel=${record.requestTypeLabel}">
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
              </a>
              <g:if test="${record.displayDraftWarning}">
                  <span class="draft-warning">
                      <img src="${createLinkTo(dir:'images',file:'24-message-warn.png')}" />
                      <g:message code="request.message.draftExpirationWarning"
                                 args="${[formatDate(date:record.draftExpirationDate,
                                          formatName:'format.date')]}"/>
                  </span>
              </g:if>
          </li>
        </g:each>
      </ul>
  </div>
</g:if>
