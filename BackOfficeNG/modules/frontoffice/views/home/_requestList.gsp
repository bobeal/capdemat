<div class="list-box">
  <h2><g:message code="request.header.${requestListName}" /></h2>
  <g:if test="${requests?.count > 0}">
    <ul>
      <g:each var="record" in="${requests.records}">
        <li>
          <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" />
          <g:if test="${record.isEditable}">
            <span class="tag-state">
              <a href="${module.createLink(module:'frontoffice',action:'draft',controller:'RequestCreation',id:record.id)}">
                <g:message code="action.modify"/>
              </a>
            </span>
          </g:if>
          <a href="${createLink(controller:'frontofficeRequest',action:'summary',id:record.id)}">
            ${record.label}
            <g:message code="searchResult.id" />
            <span>${record.id}</span>
            - <g:message code="layout.from" />
            <span>${record.requesterLastName} ${record.requesterFirstName}</span>
            <g:if test="${record.subjectLastName && record.subjectLastName != ''}">
              <g:message code="layout.for" /> ${record.subjectLastName} ${record.subjectFirstName}
            </g:if>
            - <g:message code="request.searchResult.creationDate"
                         args="${[formatDate(date:record.creationDate,formatName:'format.date')]}" />
          </a>
          <g:if test="${record.lastAgentNote}">
            <p>
              <g:message code="request.property.lastAgentNote" />
              <g:if test="${record.lastAgentNote.date != null}">
                <g:message code="layout.on.date" /> <g:formatDate date="${record.lastAgentNote.date}" formatName="format.date" />
              </g:if>
              <g:message code="layout.by" />&nbsp;${record.lastAgentNote.user_name} :
              ${record.lastAgentNote.note}
            </p>
          </g:if>
        </li>
      </g:each>
    </ul>
    <g:if test="${requests.count != requests.records.size}">
      <p class="see-all">
        <a href="${createLink(controller:'frontofficeRequest')}" id="showAllRequests">
          <g:message code="action.seeAll" />
        </a>
      </p>
    </g:if>
  </g:if>
  <g:else>
    <p class="empty"><g:message code="message.noRequests" /></p>
  </g:else>
</div>
