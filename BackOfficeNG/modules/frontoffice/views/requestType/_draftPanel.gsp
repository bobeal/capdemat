<g:if test="${session.currentUser}">
  <form id="draftForm" method="post" action="${createLink(action:'draft')}">
    <div id="draftPanel">
      <g:if test="${draftedMessage}">
        <span class="drafted-message">${draftedMessage}</span>
      </g:if>
      <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
      <input type="hidden" name="uuidString" value="${uuidString}" />
      <input type="submit" value="${message(code:'action.saveDraft')}"
        id="submitDraft" name="submitDraft" />
    </div>
  </form>
</g:if>
