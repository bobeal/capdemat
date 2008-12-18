<g:if test="${stats && stats?.collectionRoleNames}" >
  <h2><g:message code="monitoring.header.collectionRoleNames" /> :</h2>
  <g:each in="${stats.collectionRoleNames}" var="name">
    <p>${name}</p>
  </g:each>
</g:if>