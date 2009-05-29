<div id="externalService" class="nobox taskstate">
  <h3>${externalProviderService.label}</h3>
  <div class="body">
    <p>
      <h4><g:message code="external.referential.checks" /> :</h4>
      <div id="externalChecksPendingMessage" class="invisible">
        <span id="externalReferentialCheck_pending_${request.id}_${externalProviderService.label}" class="tag-pending externalLink">
          <g:message code="external.referential.checks.pending" />
        </span>
      </div>
      <div id="localReferentialChecksContainer">
        <span id="externalReferentialCheck_notsent_${request.id}_${externalProviderService.label}"class="tag-notsent externalLink">
          <g:message code="external.referential.checks.not.done" />
        </span>
      </div>
    </p>
    <p class="block">
      <h4><g:message code="external.status" /> :</h4>
      <div id="externalStatusContainer">
        <g:render template="/backofficeRequestInstruction/external/${externalProviderService.label}/externalStatus"
          model="['externalProviderService' : externalProviderService, 'lastTraceStatus' : lastTraceStatus]" />
      </div>
      <form id="sendRequestForm" action="${createLink(action:'external')}" method="post">
        <input type="hidden" name="id" value="${request.id}" />
        <input type="hidden" name="label" value="${externalProviderService.label}" />
      </form>
    </p>
  </div>
</div>