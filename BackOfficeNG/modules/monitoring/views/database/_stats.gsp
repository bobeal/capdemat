
<g:if test="${stats}" >
  <!-- Hibernate stats -->
  <div id="hibernateStats">
    <h2><g:message code="monitoring.header.databaseStatistics" /></h2>
    <p>
      <span><g:message code="monitoring.header.closeStatementCount" /> :</span>
      <span>${stats.closeStatementCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.collectionFetchCount" /> :</span>
      <span>${stats.collectionFetchCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.collectionLoadCount" /> :</span>
      <span>${stats.collectionLoadCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.collectionRecreateCount" /> :</span>
      <span>${stats.collectionRecreateCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.collectionRemoveCount" /> :</span>
      <span>${stats.collectionRemoveCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.collectionUpdateCount" /> :</span>
      <span>${stats.collectionUpdateCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.connectCount" /> :</span>
      <span>${stats.connectCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.entityDeleteCount" /> :</span>
      <span>${stats.entityDeleteCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.entityFetchCount" /> :</span>
      <span>${stats.entityFetchCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.entityInsertCount" /> :</span>
      <span>${stats.entityInsertCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.entityLoadCount" /> :</span>
      <span>${stats.entityLoadCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.entityUpdateCount" /> :</span>
      <span>${stats.entityUpdateCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.flushCount" /> :</span>
      <span>${stats.flushCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.optimisticFailureCount" /> :</span>
      <span>${stats.optimisticFailureCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.prepareStatementCount" /> :</span>
      <span>${stats.prepareStatementCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.queryCacheHitCount" /> :</span>
      <span>${stats.queryCacheHitCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.queryCacheMissCount" /> :</span>
      <span>${stats.queryCacheMissCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.queryCachePutCount" /> :</span>
      <span>${stats.queryCachePutCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.queryExecutionCount" /> :</span>
      <span>${stats.queryExecutionCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.queryExecutionMaxTime" /> :</span>
      <span>${stats.queryExecutionMaxTime}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.queryExecutionMaxTimeQueryString" /> :</span>
      <span>${stats.queryExecutionMaxTimeQueryString}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.secondLevelCacheHitCount" /> :</span>
      <span>${stats.secondLevelCacheHitCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.secondLevelCacheMissCount" /> :</span>
      <span>${stats.secondLevelCacheMissCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.secondLevelCachePutCount" /> :</span>
      <span>${stats.secondLevelCachePutCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.sessionCloseCount" /> :</span>
      <span>${stats.sessionCloseCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.sessionOpenCount" /> :</span>
      <span>${stats.sessionOpenCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.startTime" /> :</span>
      <span>${stats.startTime}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.successfulTransactionCount" /> :</span>
      <span>${stats.successfulTransactionCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.transactionCount" /> :</span>
      <span>${stats.transactionCount}</span>
    </p>
    <p>
      <span><g:message code="SUMMARY" /> :</span>
      <span>${stats.logSummary}</span>
    </p>

  </div>
</g:if>