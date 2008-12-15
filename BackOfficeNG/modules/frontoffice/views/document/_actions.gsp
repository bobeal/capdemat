<g:if test="${!actions?.isEmpty()}">
  <h3><g:message code="document.header.actionHistory"/></h3>
  <div class="list-box">
    <ul>
      <g:each var="action" in="${actions}">
        <li>
          <g:capdematEnumToFlag var="${action.resultingState}" i18nKeyPrefix="document.state" />
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