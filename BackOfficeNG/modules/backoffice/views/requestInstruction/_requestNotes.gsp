<form method="POST" id="requestNoteForm" action="${createLink(action:'requestNote')}">
  <div id="noteMsg" style="display:none"></div>
  <label for="note"><g:message code="request.note.addLabel" /></label>
  <input type="text" id="note" name="note" size="60" />
  <input type="button" id="submitNote" name="submitNote" 
    value="${message(code:'action.save')}"  />
  <input type="hidden" id="requestId" name="requestId" value="${requestId}">
</form>

<g:if test="${requestNoteList.isEmpty()}">
 <g:message code="request.message.noComment" /> <g:message code="request.property.comment" /> !
</g:if>
<g:else>
  <ul>
    <g:each var="requestNote" in="${requestNoteList}">
      <li>
        <span class="tag-state">${requestNote.type}</span>
        <p class="comment">
          ${requestNote.note}
        </p>
        <p>
          <g:message code="request.property.comment" /> n° <strong>${requestNote.id}</strong>
          <g:message code="layout.from" /> <strong>${requestNote.agent_name}</strong>
        </p>
      </li>
    </g:each>
  </ul>
</g:else>

