
<h2><g:message code="monitoring.header.mostWastefulQuery" /> :</h2>
<pre name="code" class="sql">
  ${stats.queryExecutionMaxTimeQueryString}
</pre>

<h2><g:message code="monitoring.header.queries" /> (TOP 30):</h2>
<pre name="code" class="sql">
  <g:each in="${stats.queries}" var="sql">
    ${sql}
  </g:each>
</pre>