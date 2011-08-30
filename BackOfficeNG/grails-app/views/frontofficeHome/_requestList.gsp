<div class="list-box">
  <h2><g:message code="request.header.lastRequests" /></h2>
    <g:if test="${dashBoard.drafts?.count == 0 && dashBoard.lastRequests?.count == 0}">
      <p class="empty"><g:message code="message.noRequests" /></p>
    </g:if>
    <g:else>
    <ul>
      <g:if test="${dashBoard.drafts?.count > 0}">
      <g:each var="record" in="${dashBoard.drafts.records}">
        <li>
            <span class="tag-state">
              <a href="${createLink(action:'deleteDraft',controller:'frontofficeRequest',id:record.id)}">
                <g:message code="action.remove"/>
              </a>
              <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" />
              <br/> ${formatDate(date:record.creationDate,formatName:'format.date')}
             </span>
            <a href="${createLink(action:'edit',controller:'frontofficeRequest',id:record.id)}">
              ${record.label}
              <g:message code="request.searchResult.requestId" />
              <span>${record.id}</span>
%{--              - <g:message code="layout.from" />--}%
%{--              <span>${record.requesterLastName} ${record.requesterFirstName}</span>--}%
              <g:if test="${record.subjectLastName && record.subjectLastName != ''}">
                <g:message code="layout.for" /> ${record.subjectLastName} ${record.subjectFirstName}
              </g:if>
%{--              - <g:message code="request.searchResult.creationDate"--}%
%{--                           args="${[formatDate(date:record.creationDate,formatName:'format.date')]}" />--}%
            </a>
            <g:if test="${record.displayDraftWarning}">
              <p class="draft-warning">
                <img src="${resource(dir:'images/icons',file:'24-warning.png')}" />
                <span>
                  <g:message code="request.message.draftExpirationWarning"
                             args="${[formatDate(date:record.draftExpirationDate,
                                      formatName:'format.date')]}"/>
                </span>
              </p>
            </g:if>
        </li>
      </g:each>
      </g:if>
      <g:if test="${dashBoard.lastRequests?.count > 0}">
      <g:each var="record" in="${dashBoard.lastRequests.records}">
        <li>
          <span class="tag-state">
            <g:if test="${record.isEditable}">
              <a href="${createLink(action:'edit',controller:'frontofficeRequest',id:record.id)}">
                <g:message code="action.modify"/>
              </a>
            </g:if>
            <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" /> 
            <br />${formatDate(date:record.creationDate,formatName:'format.date')}
          </span>
          <g:if test="${record.state != 'Archived'}">
            <a href="${createLink(controller:'frontofficeRequest',action:'summary',id:record.id)}">
          </g:if>
            ${record.label}
            <g:message code="searchResult.id" />
            <span>${record.id}</span>
%{--            - <g:message code="layout.from" />--}%
%{--            <span>${record.requesterLastName} ${record.requesterFirstName}</span>--}%
            <g:if test="${record.subjectLastName && record.subjectLastName != ''}">
              <g:message code="layout.for" /> ${record.subjectLastName} ${record.subjectFirstName}
            </g:if>
%{--            - <g:message code="request.searchResult.creationDate"--}%
%{--                         args="${[formatDate(date:record.creationDate,formatName:'format.date')]}" />--}%
          <g:if test="${record.state != 'Archived'}">
            </a>
          </g:if>
          <g:if test="${record.lastAgentNote}">
            <p class="agent-note">
              <g:message code="request.property.lastAgentNote" />
              <g:if test="${record.lastAgentNote.date != null}">
                <g:message code="layout.on.date" /> <g:formatDate date="${record.lastAgentNote.date}" formatName="format.date" />
              </g:if>
              <g:message code="layout.by" />&nbsp;${record.lastAgentNote.user_name} :
              <strong>${record.lastAgentNote.note}</strong>
            </p>
          </g:if>
        </li>
      </g:each>
      </g:if>
    </ul>
    <p class="see-all">
      <a href="${createLink(controller:'frontofficeRequest')}">
        <g:message code="action.seeAll" />
      </a>
    </p>
  </g:else>
</div>
