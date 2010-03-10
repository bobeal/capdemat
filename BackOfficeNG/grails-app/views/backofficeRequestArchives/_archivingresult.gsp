<g:if test="${data.numberOfSuccesses > 0}">
  <p>
    <g:message code="requestArchive.notification.body" args="${[data.numberOfSuccesses]}" />
  </p>
</g:if>
<g:if test="${!(data.failures.isEmpty())}">
  <g:message code="requestArchive.notification.body.failures" />
  <ul>
    <g:each var="failure" in="${data.failures}">
      <li>${failure.key.id} : ${failure.value.localizedMessage}</li>
    </g:each>
  </ul>
</g:if>
