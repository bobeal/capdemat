<h2><g:message code="payment.header.displayedMessage" /></h2>
<form method="post" id="displayedMessageForm" action="${createLink(action : 'displayedMessage')}" class="editor-form">
  <p class="field">
    <textarea id="displayedMessageEditor" name="editor">${editorContent}</textarea>
  </p>
  <div class="form-button">
    <input type="button" id="displayedMessageButton" value="${message(code:'action.save')}" />
  </div>
</form>