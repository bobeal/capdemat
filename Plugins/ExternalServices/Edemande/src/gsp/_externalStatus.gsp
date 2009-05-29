<g:if test="${lastTraceStatus != null}">
  <span id="sendRequest_${externalProviderService.label}" class="${lastTraceStatus.cssClass} externalLink">
    <g:message code="${lastTraceStatus.i18nKey}" />
  </span>
</g:if>
<g:else>
  <span id="sendRequest_${externalProviderService.label}" class="tag-notsent externalLink">
    <g:message code="externalservice.trace.status.notSent" />
  </span>
</g:else>