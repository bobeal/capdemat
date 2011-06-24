<h1>
  <g:message code="request.note.addLabel" />
</h1>
<div class="mainbox mainbox-yellow">
  <form method="post" id="noteForm" action="${createLink(action : 'requestNote')}">
    <input type="hidden" name="requestId" value="${rqt.id}" />
    <input type="hidden" name="requestNoteType" value="Internal" />
    <div class="error" id="noteFormErrors"></div>
    <p>
      <textarea id="note" name="note" rows="5" cols="75" maxlength="1024"></textarea>
      <span id="noteLimit"></span>
    </p>
    <p>
      <input type="button" id="submitNote" class="form-button" value="${message(code : 'request.note.action.add')}" />
      <input type="button" id="hideNote" value="${message(code : 'action.close')}" />
    </p>
  </form>
</div>
