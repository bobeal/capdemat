<g:if test="${traces.isEmpty()}">
  <g:message code="externalservice.no.trace" />
</g:if>
<g:else>
  <ul>
    <g:each var="trace" in="${traces}">
      <li>
        <dl class="action">
          <dt class="title">
            <span class="tag ${trace.status.cssClass}">
              <g:message code="${trace.status.i18nKey}" />
            </span>
          </dt>
          <dd class="title">
            <g:message code="searchResult.actionDate" /> :
            <strong><g:formatDate formatName="format.fullDate" date="${trace.date}"/></strong>
          </dd>
          <g:if test="${trace.message}">
            <dt><g:message code="requestExternalAction.property.message" /> :</dt>
            <dd>${trace.message}</dd>
          </g:if>
          <g:if test="${customTemplate}">
            <g:render template="${customTemplate}" model="${trace.complementaryData}" />
          </g:if>
        </dl>
      </li>
    </g:each>
  </ul>
</g:else>