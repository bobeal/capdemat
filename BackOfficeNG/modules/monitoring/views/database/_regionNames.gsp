<g:if test="${stats && stats?.secondLevelCacheRegionNames}" >
  <h2><g:message code="monitoring.header.secondLevelCacheRegionNames" /> :</h2>
  <g:each in="${stats.secondLevelCacheRegionNames}" var="name">
    <p>${name}</p>
  </g:each>
</g:if>