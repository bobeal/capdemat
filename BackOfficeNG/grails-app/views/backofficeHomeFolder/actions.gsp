<ul id="userActions">
  <g:each var="action" in="${actions}">
    <li>
      <dl class="action">
        <dt class="title">
          <span class="tag ${action.type.cssClass}">
            <g:message code="${action.type.i18nKey}" />
          </span>
        </dt>
        <dd class="title">
          <g:if test="${action.state}">
            <span class="tag ${action.state.cssClass}"><g:message code="${action.state.i18nKey}" /></span>
          </g:if>
          ${action.target}
        </dd>
        <dd class="title">
          <g:message code="searchResult.actionDate" /> :
          <strong><g:formatDate formatName="format.fullDate" date="${action.date}"/></strong>
          <g:if test="${action.username}">
            <g:message code="layout.by" />
            <strong>${action.username}</strong>
          </g:if>
        </dd>
        <g:if test="${action.role}">
          <dt <g:if test="${action.role.deleted}">style="text-decoration : line-through;"</g:if>>
            <g:capdematEnumToFlag var="${action.role.type}" i18nKeyPrefix="homeFolder.role" />
          </dt>
          <dd <g:if test="${action.role.deleted}">style="text-decoration : line-through;"</g:if>>
            ${action.role.owner}
          </dd>
        </g:if>
        <g:each var="data" in="${action.data}">
          <dt>${data.key}</dt>
          <dd>${data.value}</dd>
        </g:each>
      </dl>
    </li>
  </g:each>
</ul>
