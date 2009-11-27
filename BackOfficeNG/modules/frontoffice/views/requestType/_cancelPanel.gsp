<g:if test="${askConfirmCancel}">
  <div class="confirmation-box">
    <form id="confirmCancelRequestForm" method="post" action="${createLink(action:'step')}">
      <p>${message(code:'requestType.message.AskConfirmationCancelRequest')}</p>
      <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
      <input type="hidden" name="uuidString" value="${uuidString}" />
      <input type="submit" name="submit-confirmCancelRequest-${currentStep}"
             value="${message(code:'action.confirm')}" />
      <input type="submit" name="submit-discardCancelRequest-${currentStep}"
             value="${message(code:'action.cancel')}" />
    </form>   
  </div>
</g:if>
<g:else>
  <form id="cancelRequestForm" method="post" action="${createLink(action:'step')}" class="exitActionForm">
    <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
    <input type="hidden" name="uuidString" value="${uuidString}" />
    <input type="submit" name="submit-cancelRequest-${currentStep}" 
           value="${rqt.state.toString().equals("Draft") ? message(code:'action.quit') : message(code:'action.cancel')}" />
  </form>
</g:else>
