  <ul>
    <g:each var="record" in="${requests.records}">
      <li>
        <p>
          <g:if test="${record.draft}">
            <span class="tag-draft tag-state">
              <g:message code="request.property.draft"/>
            </span>
          </g:if>
          <g:else>
            <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="request.state" />
          </g:else>
          <g:if test="${record.isEditable}">
            <span class="tag-state">
              <a href="${module.createLink(module:'frontoffice',action:'draft',controller:'RequestCreation',id:record.id)}">
                <g:message code="action.modify"/>
              </a>
            </span>
          </g:if>
          <a href="${createLink(controller:'frontofficeRequest',action:'summary',id:record.id)}">
            ${record.label}
            <g:message code="request.searchResult.requestId" />
            <span>${record.id}</span>
            - <g:message code="layout.from" /> 
            <span>${record.requesterLastName} ${record.requesterFirstName}</span>
            <g:if test="${record.subjectLastName && record.subjectLastName != ''}">
             <g:message code="layout.for" />
             ${record.subjectLastName} ${record.subjectFirstName}
            </g:if>
          </a>
        </p>
        <p>
          <g:message code="request.searchResult.creationDate" 
            args="${[formatDate(date:record.creationDate,formatName:'format.date')]}"/> 
          <g:if test="${record.lastModificationDate}">
            - <g:message code="request.property.lastModificationDate" />
            <g:formatDate date="${record.lastModificationDate}" formatName="format.date" />
            <g:if test="${record.lastInterveningUserId}">
              <g:message code="layout.by" />
              ${record.lastInterveningUserId}
            </g:if>
          </g:if> 
        </p>
        <g:if test="${record.externalInformations}">
          <p>
            <g:each status="i" var="externalInformation" in="${record.externalInformations}">
              <g:message code="${externalInformation.key}" /> : ${externalInformation.value + (i == record.externalInformations.size() - 1 ? "" : " - ")}
            </g:each>
          </p>
        </g:if>
        <g:if test="${record.lastAgentNote}">
          <p>
            <g:message code="request.property.lastAgentNote" />
            <g:if test="${record.lastAgentNote.date}">
                <g:message code="layout.on.date" /> <g:formatDate date="${record.lastAgentNote.date}" formatName="format.date" />
              </g:if>
            <g:message code="layout.by" />&nbsp;${record.lastAgentNote.user_name} :
            ${record.lastAgentNote.note}
          </p>
        </g:if>
      </li>
    </g:each>
  </ul>
