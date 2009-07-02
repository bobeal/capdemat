<ul>
  <g:each var="requestAction" in="${requestActionList}">
    <li>
      <strong>${requestAction.label}</strong>
      <g:if test="${requestAction.resulting_state}">
        (<g:message code="property.newState" /> : <strong><g:message code="${requestAction.resulting_state}"/></strong>)
      </g:if>        
      - <g:message code="searchResult.actionDate" /> <strong><g:formatDate formatName="format.fullDate" date="${requestAction.date}"/></strong>
      <g:message code="layout.by" /> <strong>${requestAction.agent_name}</strong>
      <br/>
      <g:if test="${requestAction.note}">
		<g:message code="requestAction.property.note" /> : ${requestAction.note}      	
      </g:if>
    </li>
  </g:each>
</ul>

