<dl class="action">
  <dt class="title">
    <span class="tag ${action.type.cssClass}">
      <g:message code="${action.type.i18nKey}" />
    </span>
  </dt>
  <g:if test="${action.resulting_state}">
    <dd class="title">
      <span class="tag ${action.resulting_state.cssClass}">
        <g:message code="${action.resulting_state.i18nKey}" /></span>
    </dd>
  </g:if>
  <dd class="title">
    <g:message code="searchResult.actionDate" /> :
    <strong><g:formatDate formatName="format.fullDate" date="${action.date}"/></strong>
    <g:if test="${action.user.name}">
      <g:message code="layout.by" />
      <strong>${action.user.name}</strong>
    </g:if>
  </dd>
  <g:if test="${action.hasFile}">
    <dt><g:message code="${action.fileType}" /></dt>
    <dd>
      <a title="<g:message code='${"requestAction.action.download." + action.type.enumString}' />"
        href="${createLink(controller : 'backofficeContact', action : 'view',
          params : ['requestId' : action.requestId, 'requestActionId' : action.id])}">
        <img
          alt="<g:message code='${"requestAction.action.download." + action.type.enumString}' />"
          src="${resource(dir:'images/icons',file:'pdficon_small.gif')}" />
      </a>
    </dd>
  </g:if>
  <g:if test="${action.filename}">
    <dt><g:message code="requestAction.property.filename" /> :</dt>
    <dd>${action.filename}</dd>
  </g:if>
  <g:if test="${!action.hasFile}">
    <g:if test="${action.message}">
      <dt><g:message code="requestAction.property.message" /> :</dt>
      <dd>${action.message}</dd>
    </g:if>
  </g:if>
  <g:if test="${action.note}">
    <g:if test="${action.user.nature == 'agent'}">
      <dt class="action-note"><g:message code="requestAction.property.note" /> :</dt>
    </g:if>
    <g:else>
      <dt class="action-note"><g:message code="requestAction.property.eCitizenNote" /> :</dt>
    </g:else>
      <dd class="action-note">${action.note}</dd>
  </g:if>
</dl>
