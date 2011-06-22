<dl class="action">
  <dt class="title">
    <span class="tag tag-external">
      <g:message code="requestExternalAction.property.name" />
    </span>
  </dt>
  <dd class="title">
    <span class="tag ${action.status.cssClass}">
      <g:message code="${action.status.i18nKey}" />
    </span>
  </dd>
  <dd class="title">
    <g:message code="searchResult.actionDate" /> :
    <strong><g:formatDate formatName="format.fullDate" date="${action.date}"/></strong>
    <g:message code="layout.by" />
    <strong>${action.label}</strong>
  </dd>
  <g:if test="${action.message}">
    <dt><g:message code="requestExternalAction.property.message" /> :</dt>
    <dd>${action.message}</dd>
  </g:if>
  <g:if test="${action.customTemplate}">
    <g:render template="${action.customTemplate}" model="${action.complementaryData}" />
  </g:if>
</dl>
