<g:if test="${externalReferentialCheckErrors.isEmpty()}">
  <span id="externalReferentialCheck_valid_${id}_${label}" class="tag-valid externalLink">
    <g:message code="externalService.message.referentialChecksOk" />
  </span>
</g:if>
<g:else>
  <ul id="externalReferentialChecks">
    <g:each var="externalReferentialCheckError" in="${externalReferentialCheckErrors}">
      <li>${externalReferentialCheckError}</li>
    </g:each>
  </ul>
  <span id="externalReferentialCheck_invalid_${id}_${label}" class="tag-invalid externalLink">
    <g:message code="externalService.message.referentialChecksInvalid" />
  </span>
</g:else>
