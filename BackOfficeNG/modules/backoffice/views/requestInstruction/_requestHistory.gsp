<ul>
  <g:each var="requestAction" in="${requestActionList}">
    <li>
      <ul>
        <li>
          <strong>${requestAction.i18nLabel}</strong>
          <g:if test="${requestAction.resulting_state}">
            (<g:message code="property.newState" /> : <strong><g:message code="${requestAction.resulting_state}"/></strong>)
          </g:if>
          - <g:message code="searchResult.actionDate" /> <strong><g:formatDate formatName="format.fullDate" date="${requestAction.date}"/></strong>
          <g:message code="layout.by" /> <strong>${requestAction.agent_name}</strong>
          <g:if test="${requestAction.hasFile}">
            <a class="documentLink" title="<g:message code='${"requestAction.action.download." + requestAction.label}' />"
              href="${createLink(controller : 'backofficeContact', action : 'view', params : ['requestActionId' : requestAction.id])}">
              <img src="${createLinkTo(dir:'images/icons',file:'pdficon_small.gif')}" />
            </a>
          </g:if>
        </li>
        <g:if test="${requestAction.message}">
          <li>
            <g:message code="requestAction.property.message" /> : ${requestAction.message}
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
