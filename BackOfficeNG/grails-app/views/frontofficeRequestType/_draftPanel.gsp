<form id="draftForm" method="post" action="${createLink(action:'step')}" class="exitActionForm">
  <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
  <input type="hidden" name="uuidString" value="${uuidString}" />
  <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
  <input type="submit" value="${message(code:'action.saveDraft')}"
         id="submit-draft" name="submit-draft-${currentStep}" ${session.currentEcitizen && draftVisible ? '' : 'disabled=\"disabled\"'}/>
</form>
