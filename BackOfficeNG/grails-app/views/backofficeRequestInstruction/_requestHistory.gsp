<form method="post" id="requestNoteForm" action="${createLink(action : 'requestNote')}">
  <label for="note">
    <g:message code="request.note.addLabel" /><span id="noteLimit"></span>
  </label>
  <input type="text" id="note" name="note" size="60" maxlength="1024" />
  <div id="noteMsg" class="invisible"></div>
  <input type="hidden" name="requestNoteType" value="Internal" />
  <input type="button" id="submitNote" value="${message(code : 'action.save')}" />
  <input type="hidden" name="requestId" value="${requestId}" />
</form>
<ul>
  <g:each var="action" in="${actions}">
    <li>
      <g:render template="${action.template}" model="['action' : action]" />
    </li>
  </g:each>
</ul>
