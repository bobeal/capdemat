<!-- Garbage collectors -->
<div id="infoGarbageCollectors">
  <h2><g:message code="monitoring.header.garbageCollectors" /></h2>
  <g:each var="collector" in="${systemInfo.garbageCollectors}">
    <p>
      <span><g:message code="monitoring.header.name" /> :</span>
      <span>${collector.name}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.collectionCount" /> :</span>
      <span>${collector.collectionCount}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.collectionTime" /> :</span>
      <span>${collector.collectionTime}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.memoryPools" /> :</span>
      <span>
        <g:each var="pool" in="${collector.pools}">
          ${pool.name}
        </g:each>
      </span>
    </p>
  </g:each>
</div>