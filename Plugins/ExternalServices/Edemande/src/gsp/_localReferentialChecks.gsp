<g:if test="${localReferentialCheckErrors.isEmpty()}">
  <span id="externalReferentialCheck_valid_${id}_${label}" class="tag-valid externalLink">
    <g:message code="externalService.message.referentialChecksOk" />
  </span>
</g:if>
<g:else>
  <ul id="localReferentialChecks">
    <g:each var="localReferentialCheckError" in="${localReferentialCheckErrors}">
      <li>${localReferentialCheckError}</li>
    </g:each>
  </ul>
  <span id="externalReferentialCheck_invalid_${id}_${label}" class="tag-invalid externalLink">
    <g:message code="externalService.message.referentialChecksInvalid" />
  </span>
</g:else>
