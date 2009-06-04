<div id="externalService" class="nobox taskstate">
  <h3>${externalProviderServiceLabel}</h3>
  <div class="body">
    <p>
      <h4><g:message code="externalService.header.referentialChecks" /> :</h4>
      <div id="externalReferentialChecksPendingMessage" class="invisible">
        <span id="externalReferentialCheck_pending_${request.id}_${externalProviderServiceLabel}" class="tag-pending externalLink">
          <g:message code="externalService.message.referentialChecksPending" />
        </span>
      </div>
      <div id="externalReferentialChecksContainer">
        <span id="externalReferentialCheck_notsent_${request.id}_${externalProviderServiceLabel}"class="tag-notsent externalLink">
          <g:message code="externalService.message.referentialChecksNotDone" />
        </span>
      </div>
    </p>
    <p class="block">
      <h4><g:message code="externalService.header.status" /> :</h4>
      <div id="externalStatusContainer">
        <g:render template="/backofficeRequestInstruction/external/${externalProviderServiceLabel}/externalStatus"
          model="['externalProviderServiceLabel' : externalProviderServiceLabel, 'lastTraceStatus' : lastTraceStatus]" />
      </div>
      <form id="sendRequestForm" action="${createLink(action:'external')}" method="post">
        <input type="hidden" name="id" value="${request.id}" />
        <input type="hidden" name="label" value="${externalProviderServiceLabel}" />
      </form>
    </p>
  </div>
</div>