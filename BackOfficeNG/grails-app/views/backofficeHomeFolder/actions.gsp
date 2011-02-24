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
          ${action.target.name}
        </dd>
        <dd class="title">
          <g:message code="searchResult.actionDate" /> :
          <strong><g:formatDate formatName="format.fullDate" date="${action.date}"/></strong>
          <g:if test="${action.user.name}">
            <g:message code="layout.by" />
            <strong>${action.user.name}</strong>
          </g:if>
        </dd>
        <g:if test="${action.responsible}">
          <g:if test="${action.responsible.deleted}">
            <dt style="text-decoration : line-through">
              <g:each var="type" in="${action.responsible.deleted}">
                <g:capdematEnumToFlag var="${type}" i18nKeyPrefix="homeFolder.role" />
              </g:each>
            </dt>
            <dd style="text-decoration : line-through">
              ${action.responsible.name}
            </dd>
          </g:if>
          <g:else>
            <dt>
              <g:each var="type" in="${action.responsible.types}">
                <g:capdematEnumToFlag var="${type}" i18nKeyPrefix="homeFolder.role" />
              </g:each>
            </dt>
            <dd>
              ${action.responsible.name}
            </dd>
          </g:else>
        </g:if>
        <g:if test="${action.atom}">
          <dt>${action.atom.name}</dt>
          <dd>
            <dl>
            <g:each var="field" in="${action.atom.fields}">
              <dt>${field.key}</dt>
              <dd>
                ${field.value.from} ↪ ${field.value.to}
              </dd>
            </g:each>
            </dl>
          </dd>
        </g:if>
      </dl>
    </li>
  </g:each>
</ul>
