<g:if test="${traces.isEmpty()}">
  <g:message code="externalservice.no.trace" />
</g:if>
<g:else>
  <ul>
    <g:each var="trace" in="${traces}">
      <li>
        <span class="first-line">
          <strong><g:message code="${trace.status}" /></strong>
          - <strong><g:formatDate formatName="format.fullDate" date="${trace.date}"/></strong>
          <g:if test="${trace.message != null}">
            : ${trace.message}
          </g:if>
        </span>
      </li>
    </g:each>
  </ul>
</g:else>