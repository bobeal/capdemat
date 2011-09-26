<g:if test="${dashBoard.lastRequests?.count > 0}">
  <div class="list-box">
    <h2><g:message code="request.header.lastRequests" /></h2>
    <ul>
      <g:each var="record" in="${dashBoard.lastRequests.records}">
        <li>
          <span class="date">${formatDate(date:record.creationDate,formatName:'format.date')}</span>

          <div class="content">
            <g:if test="record.state != 'Archived'">
              <a href="${createLink(controller:'frontofficeRequest',action:'summary',id:record.id)}">
            </g:if>
              ${record.label}
              <g:message code="request.searchResult.requestId" />
              ${record.id}
            <g:if test="record.state != 'Archived'">
              </a>
            </g:if>
            <span class="tag-state">
              <g:if test="${record.isEditable}">
                <a href="${createLink(action:'edit',controller:'frontofficeRequest',id:record.id)}">
                  <g:message code="action.modify"/>
                </a>
              </g:if>
              <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" />
            </span>
            <g:if test="${record.subjectName && record.subjectName != ''}">
              <p>> <g:message code="layout.for" /> ${record.subjectName}</p>
            </g:if>
            <!-- Not working atm. If we re-enable request notes, .agent-note class should be styled, won't work as-it.
            <g:if test="${record.lastAgentNote}">
              <p class="agent-note">
                > <g:message code="request.property.lastAgentNote" />
                <g:if test="${record.lastAgentNote.date != null}">
                  <g:message code="layout.on.date" />${formatDate(date:record.lastAgentNote.date,formatName:'format.date')}
                </g:if>
                <g:message code="layout.by" />${record.lastAgentNote.user_name} :
                <strong>${record.lastAgentNote.note}</strong>
              </p>
            </g:if>-->
          </div>

        </li>
      </g:each>
    </ul>
    <p class="see-all">
      <a href="${createLink(controller:'frontofficeRequest')}">
        <g:message code="action.seeAll" />
      </a>
    </p>
  </div>
</g:if>
