<ul>
  <g:each var="requestAction" in="${requestActionList}">
    <li>
      <span class="first-line">
        <strong>${requestAction.label}</strong> (${requestAction.id})
        - <g:message code="layout.from" /> <strong>${requestAction.agent_name}</strong>
        - <g:message code="request.property.actionDate" /> <strong>${requestAction.date}</strong>
      </span>
      <span class="second-line">
        <g:if test="${requestAction.resulting_state}">
          <g:message code="property.state" /> : <strong>${requestAction.resulting_state}</strong>
        </g:if>
      </span>
    </li>
  </g:each>
</ul>

