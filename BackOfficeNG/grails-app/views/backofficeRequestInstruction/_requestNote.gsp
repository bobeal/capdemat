<dl class="action">
  <dt class="title">
    <g:if test="${action.user.nature == 'eCitizen'}">
      <span class="tag tag-comment">
        <g:message code="request.property.comment" />
      </span>
    </g:if>
    <g:else>
      <span class="tag tag-note">
        <g:message code="request.property.note" />
      </span>
    </g:else>
  </dt>
  <dd class="title">
    <g:message code="request.note.date" /> <g:message code="layout.on.date" /> :
    <strong><g:formatDate formatName="format.fullDate" date="${action.date}"/></strong>
    <g:if test="${action.user.name}">
      <g:message code="layout.by" />
      <strong>${action.user.name}</strong>
    </g:if>
  </dd>
  <dd class="title">${action.note}</dd>
</dl>
