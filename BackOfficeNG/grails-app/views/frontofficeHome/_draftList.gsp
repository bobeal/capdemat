<g:if test="${dashBoard.drafts?.count > 0}">
  <div class="list-box">
    <h2><g:message code="request.header.drafts" /></h2>
    <ul>
      <g:each var="record" in="${dashBoard.drafts.records}">
        <li>
          <span class="date">${formatDate(date:record.creationDate,formatName:'format.date')}</span>

          <div class="content">
            <span class="action_and_tag-state">
              <a href="${createLink(action:'deleteDraft',controller:'frontofficeRequest',id:record.id)}">
                  <g:message code="action.remove"/>
              </a>
              <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" />
            </span>
            <a href="${createLink(action:'edit',controller:'frontofficeRequest',id:record.id)}">
              ${record.label}
              <g:message code="request.searchResult.requestId" />
              ${record.id}
            </a>
            <g:if test="${record.subjectName && record.subjectName != ''}">
              <p>> <g:message code="layout.for" /> ${record.subjectName}</p>
            </g:if>
            <p>
              <span ${record.warn ? 'class="warn"' : ''}>
                > <g:message code="request.message.expireOn"
                    args="${[formatDate(date:record.expirationDate,formatName:'format.date')]}"/><g:if test="${record.warn}"> !</g:if>
              </span>
            </p>
          </div>

        </li>
      </g:each>
    </ul>
  </div>
</g:if>
