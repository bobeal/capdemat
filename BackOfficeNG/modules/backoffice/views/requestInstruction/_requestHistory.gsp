<ul>
  <g:each var="requestAction" in="${requestActionList}">
    <li>
      <ul>
        <li>
          <strong>${requestAction.label}</strong>
          <g:if test="${requestAction.resulting_state}">
            (<g:message code="property.newState" /> : <strong><g:message code="${requestAction.resulting_state}"/></strong>)
          </g:if>
          - <g:message code="searchResult.actionDate" /> <strong><g:formatDate formatName="format.fullDate" date="${requestAction.date}"/></strong>
          <g:message code="layout.by" /> <strong>${requestAction.agent_name}</strong>
        </li>
        <g:if test="${requestAction.hasFile || requestAction.message}">
          <li>
            <g:if test="${requestAction.hasFile}">
              <a href="${createLink(controller : 'backofficeContact', action : 'view', params : ['requestActionId' : requestAction.id])}">
                <img src="${createLinkTo(dir:'images/icons',file:'pdficon_small.gif')}" />
              </a>
            </g:if>
            <g:if test="${requestAction.message}">
              <g:message code="requestAction.property.message" /> : ${requestAction.message}
            </g:if>
          </li>
        </g:if>
        <g:if test="${requestAction.note}">
          <li>
            <g:message code="requestAction.property.note" /> : ${requestAction.note}
          </li>
        </g:if>
      </ul>
    </li>
  </g:each>
</ul>
