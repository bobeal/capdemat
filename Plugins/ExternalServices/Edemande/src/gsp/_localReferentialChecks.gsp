<g:if test="${localReferentialCheckErrors.isEmpty()}">
  <span id="externalReferentialCheck_valid_${id}_${label}" class="tag-valid externalLink">
    <g:message code="external.referential.checks.ok" />
  </span>
</g:if>
<g:else>
  <ul id="localReferentialChecks">
    <g:each var="localReferentialCheckError" in="${localReferentialCheckErrors}">
      <li>${localReferentialCheckError}</li>
    </g:each>
  </ul>
  <span id="externalReferentialCheck_invalid_${id}_${label}" class="tag-invalid externalLink">
    <g:message code="external.referential.checks.invalid" />
  </span>
</g:else>
