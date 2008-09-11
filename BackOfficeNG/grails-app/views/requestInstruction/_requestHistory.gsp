<ul>
  <g:each var="requestAction" in="${requestActionList}">
    <li>
      <span class="first-line">
        <strong>${requestAction.label}</strong>
        - <g:message code="request.property.actionId" /> <strong>${requestAction.id}</strong>
        - <g:message code="layout.from" /> <strong>${requestAction.agent_name}</strong>
        - <g:message code="request.property.actionDate" /> <strong>${requestAction.date}</strong>
      </span>
      <br/>
      <span class="second-line">
        <g:message code="property.state" /> : <strong>${requestAction.resulting_state}</strong>
      </span>
    </li>
  </g:each>
</ul>

