<!-- Threads -->
<div id="infoThreads">
  <h2><g:message code="monitoring.header.threads" /></h2>
  <g:each var="thread" in="${systemInfo.threads}">
    <p>
      <span><g:message code="monitoring.header.name" /> :</span>
      <span>${thread.name}</span>
    </p>
  </g:each>
</div>