<h2><g:message code="payment.header.displayedMessage" /></h2>
<form method="post" id="form1" action="${createLink(action : 'displayedMessage')}" class="editor-form">
  <p class="field">
    <textarea id="editor" name="editor">${editorContent}</textarea>
  </p>
  <div class="form-button">
    <input type="button" value="${message(code:'action.save')}" rel="saveDisplayedMessage" />
  </div>
</form>