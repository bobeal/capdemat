<g:if test="${actions?.size() > 0}">
  <h2>
    <g:message code="document.header.actionHistory"/>
  </h2>
  <div class="individual-detail">
    <ul>
      <g:each var="action" in="${actions}">
        <li>
          <span class="${action.resultingState.cssClass}">
            <g:message code="${action.resultingState.i18nKey}" />
          </span>
          <strong>${action.label}</strong>
          <g:if test="${action.date}">
            - <strong><g:formatDate date="${action.date}" formatName="format.date" /></strong>
          </g:if>
          <g:if test="${action.agentName}">
            - <strong>${action.agentName}</strong>
          </g:if>
        </li>
      </g:each>
    </ul> 
  </div>
</g:if> 