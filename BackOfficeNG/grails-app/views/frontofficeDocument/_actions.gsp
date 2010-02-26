<g:if test="${!actions?.isEmpty()}">
  <div class="yui-g">
    <h3><g:message code="document.header.actionHistory"/></h3>
    <div class="list-box">
      <ul>
        <g:each var="action" in="${actions}">
          <li>
            ${action.label}
            <g:if test="${action.resultingState}">
              (<g:message code="property.newState" /> : <g:message code="${action.resultingState}"/>)
            </g:if>
            - <g:message code="searchResult.actionDate" /> <g:formatDate formatName="format.fullDate" date="${action.date}"/>
            <g:message code="layout.by" /> ${action.agentName}
          </li>
        </g:each>
      </ul>
    </div>
  </div>
</g:if> 