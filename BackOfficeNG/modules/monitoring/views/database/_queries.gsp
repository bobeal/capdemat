<g:if test="${stats && stats?.queries}" >
  <h2><g:message code="monitoring.header.queries" /> :</h2>
  <g:each in="${stats.queries}" var="name">
    <p>${name}</p>
  </g:each>
</g:if>