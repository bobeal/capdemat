<g:if test="${session.currentUser}">
  <form id="draftForm" method="post" action="${createLink(action:'draft')}">
    <div id="draftPanel">
      <g:if test="${draftedMessage}">
        <span class="drafted-message">${draftedMessage}</span>
      </g:if>
<!--      <span id="submitDraft" class="yui-button yui-push-button">
        <span class="first-child">
          <button type="submit" tabindex="0">${message(code:'action.draft')}</button>
        </span>
      </span>-->
      <input type="hidden" name="requestTypelabel" value="${requestTypeLabel}" />
      <input type="hidden" name="uuidString" value="${uuidString}" />
      <input type="submit" 
        value="${message(code:'action.draft')}"
        id="submitDraft"
        name="submitDraft" />
    </div>
  </form>
</g:if>
