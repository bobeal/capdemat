<g:if test="${stats && stats?.entityNames}" >
  <h2><g:message code="monitoring.header.entityNames" /> :</h2>
  <g:each in="${stats.entityNames}" var="name">
    <p>${name}</p>
  </g:each>
</g:if>