<g:if test="${!actions?.isEmpty()}">
  <div class="yui-g">
    <h3><g:message code="document.header.actionHistory"/></h3>
    <div class="list-box">
      <ul>
        <g:each var="action" in="${actions}">
          <li>
            <g:capdematEnumToFlag var="${action.resultingState}" i18nKeyPrefix="document.state" />
            ${action.label}
            <g:if test="${action.date}">
              - <g:formatDate date="${action.date}" formatName="format.date" />
            </g:if>
            <g:if test="${action.agentName}">
              - ${action.agentName}
            </g:if>
          </li>
        </g:each>
      </ul>
    </div>
  </div>
</g:if> 