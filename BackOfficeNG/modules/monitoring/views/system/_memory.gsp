<!-- Heap storage -->
<div id="infoHeapStorage">
  <h2><g:message code="monitoring.header.heapStorage" /></h2>
  <p>
    <span><g:message code="monitoring.header.committed" /> :</span>
    <span>${systemInfo.heapStorage.committed}</span>
  </p>
  <p>
    <span><g:message code="monitoring.header.init" /> :</span>
    <span>${systemInfo.heapStorage.init}</span>
  </p>
  <p>
    <span><g:message code="monitoring.header.max" /> :</span>
    <span>${systemInfo.heapStorage.max}</span>
  </p>
  <p>
    <span><g:message code="monitoring.header.used" /> :</span>
    <span>${systemInfo.heapStorage.used}</span>
  </p>
</div>
<!-- Non-Heap storage -->
<div id="infoNonHeapStorage">
  <h2><g:message code="monitoring.header.nonHeapStorage" /></h2>
  <p>
    <span><g:message code="monitoring.header.committed" /> :</span>
    <span>${systemInfo.nonHeapStorage.committed}</span>
  </p>
  <p>
    <span><g:message code="monitoring.header.init" /> :</span>
    <span>${systemInfo.nonHeapStorage.init}</span>
  </p>
  <p>
    <span><g:message code="monitoring.header.max" /> :</span>
    <span>${systemInfo.nonHeapStorage.max}</span>
  </p>
  <p>
    <span><g:message code="monitoring.header.used" /> :</span>
    <span>${systemInfo.nonHeapStorage.used}</span>
  </p>
</div>
<!-- Memory pools -->
<div id="infoMemoryPool">
  <h2><g:message code="monitoring.header.memoryPools" /></h2>
  <g:each var="pool" in="${systemInfo.memoryPools}">
    <p>
      <span><g:message code="monitoring.header.name" /> :</span>
      <span>${pool.name}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.type" /> :</span>
      <span>${pool.type}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.isUsageThresholdSupported" /> :</span>
      <span>${pool.isUsageThresholdSupported}</span>
    </p>
    <p>
      <span><g:message code="monitoring.header.managerNames" /> :</span>
      <span>
        <g:each var="manager" in="${pool.managers}">
          ${manager.name}
        </g:each>
      </span>
    </p>
  </g:each>
</div>