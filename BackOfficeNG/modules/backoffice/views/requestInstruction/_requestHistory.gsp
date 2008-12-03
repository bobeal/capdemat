<ul>
  <g:each var="requestAction" in="${requestActionList}">
    <li>
      <span class="first-line">
        <strong>${requestAction.label}</strong>
        <g:if test="${requestAction.resulting_state}">
          (<g:message code="property.newState" /> : <strong><g:message code="${requestAction.resulting_state}"/></strong>)
        </g:if>        
        - <g:message code="request.property.actionDate" /> <strong>${requestAction.date}</strong>
        <g:message code="layout.by" /> <strong>${requestAction.agent_name}</strong>
      </span>
    </li>
  </g:each>
</ul>

