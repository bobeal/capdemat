<form id="draftForm" method="post" action="${createLink(action:'draft')}" class="exitActionForm">
  <g:if test="${draftedMessage}">
    <span class="drafted-message">${draftedMessage}</span>
  </g:if>
  <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
  <input type="hidden" name="uuidString" value="${uuidString}" />
  <input type="hidden" name="currentTabIndex" value="${currentTabIndex}" />
  <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
  <input type="submit" value="${message(code:'action.saveDraft')}"
         id="submit-draft" name="submit-draft" ${session.currentEcitizen && draftVisible ? '' : 'disabled=\"disabled\"'}/>
</form>
