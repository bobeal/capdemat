<ul>
  <g:each var="requestAction" in="${requestActionList}">
    <li>
      <dl class="action">
        <dt class="title">
          <span class="tag ${requestAction.type.cssClass}">
            <g:message code="${requestAction.type.i18nKey}" />
          </span>
        </dt>
        <g:if test="${requestAction.resulting_state}">
          <dd class="title">
            <span class="tag ${requestAction.resulting_state.cssClass}">
              <g:message code="${requestAction.resulting_state.i18nKey}" /></span>
          </dd>
        </g:if>
        <dd class="title">
          <g:message code="searchResult.actionDate" /> :
          <strong><g:formatDate formatName="format.fullDate" date="${requestAction.date}"/></strong>
          <g:if test="${requestAction.agent_name}">
            <g:message code="layout.by" />
            <strong>${requestAction.agent_name}</strong>
          </g:if>
        </dd>
        <g:if test="${requestAction.hasFile}">
          <dt><g:message code="${requestAction.fileType}" /></dt>
          <dd>
            <a title="<g:message code='${"requestAction.action.download." + requestAction.type.enumString}' />"
              href="${createLink(controller : 'backofficeContact', action : 'view',
                params : ['requestId' : requestId, 'requestActionId' : requestAction.id])}">
              <img
                alt="<g:message code='${"requestAction.action.download." + requestAction.type.enumString}' />"
                src="${resource(dir:'images/icons',file:'pdficon_small.gif')}" />
            </a>
          </dd>
        </g:if>        
        <g:if test="${requestAction.filename}">
          <dt><g:message code="requestAction.property.filename" /> :</dt>
          <dd>${requestAction.filename}</dd>
        </g:if>
        <g:if test="${!requestAction.hasFile}">
            <g:if test="${requestAction.message}">
                <dt><g:message code="requestAction.property.message" /> :</dt>
                <dd>${requestAction.message}</dd>
            </g:if>
        </g:if>
        <g:if test="${requestAction.note}">
          <dt><g:message code="requestAction.property.note" /> :</dt>
          <dd>${requestAction.note}</dd>
        </g:if>
      </dl>
    </li>
  </g:each>
</ul>
