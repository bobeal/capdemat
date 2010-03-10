<g:if test="${history.isEmpty()}">
  ${message(code : "requestArchive.message.noHistory")}
</g:if>
<g:else>
  <ul>
    <g:each var="action" in="${history}">
      <li>
        <dl>
          <dt class="title">
            <span class="tag ${action.type.cssClass}">
              <g:message code="${action.type.i18nKey}" />
            </span>
          </dt>
          <dd class="title">
            <g:message code="searchResult.actionDate" />
            <strong><g:formatDate formatName="format.fullDate" date="${action.date}"/></strong>
            <g:message code="layout.by" />
            <strong>${action.admin}</strong>
          </dd>
          <g:each var="data" in="${action.complementaryData}">
            <dt><g:message code="requestAdminAction.complementaryData.${data.key}" /></dt>
            <dd><g:render template="${data.key.toString().toLowerCase()}" model="['data' : data.value]" /></dd>
          </g:each>
        </dl>
      </li>
    </g:each>
  </ul>
</g:else>
