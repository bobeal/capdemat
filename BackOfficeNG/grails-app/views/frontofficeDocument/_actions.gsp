<g:if test="${!actions?.isEmpty()}">
  <div class="yui-g">
    <h3><g:message code="document.header.actionHistory"/></h3>
    <div class="list-box">
      <ul>
        <g:each var="action" in="${actions}">
          <li>
            <g:message code="${action.type.i18nKey}" />
            <g:if test="${action.resultingState}">
              (<g:message code="property.newState" /> : <g:message code="${action.resultingState.i18nKey}"/>)
            </g:if>
            - <g:message code="searchResult.actionDate" /> <g:formatDate formatName="format.fullDate" date="${action.date}"/>
            <g:message code="layout.by" /> ${action.username}
          </li>
        </g:each>
      </ul>
    </div>
  </div>
</g:if> 