<g:each in="${identifierMappings}" var="identifierMapping">
  <h3>
    ${identifierMapping.externalServiceLabel}
  </h3>
  <div class="yui-g">
    <div class="yui-u first">
      <dl>
        <dt><g:message code="homeFolder.header" /></dt>
        <dd class="action-editField">
          <form method="get" action="<g:createLink action="mapping" />"
            id="identifierMapping_${identifierMapping.externalServiceLabel}_${identifierMapping.homeFolderId}">
            <span>${identifierMapping.externalId}</span>
            <input type="hidden" name="externalServiceLabel"
              value="${identifierMapping.externalServiceLabel}" />
            <input type="hidden" name="homeFolderId"
              value="${identifierMapping.homeFolderId}" />
          </form>
        </dd>
        <g:each in="${identifierMapping.individualMappings}" var="individualMapping">
          <dt>${individualMapping.individual.firstName} ${individualMapping.individual.lastName}</dt>
          <dd class="action-editField">
            <form method="get" action="<g:createLink action="mapping" />"
              id="individualMapping_${identifierMapping.externalServiceLabel}_${individualMapping.individual.id}">
              <span>${individualMapping.externalId}</span>
              <input type="hidden" name="externalServiceLabel"
                value="${identifierMapping.externalServiceLabel}" />
              <input type="hidden" name="homeFolderId"
                value="${identifierMapping.homeFolderId}" />
              <input type="hidden" name="individualId"
                value="${individualMapping.individual.id}" />
            </form>
          </dd>
        </g:each>
      </dl>
    </div>
  </div>
</g:each>
