<form method="POST" id="requestNoteForm" action="${createLink(action:'addRequestNote')}">
  <label for="newRequestNote"><g:message code="request.note.addLabel" /></label>
  <input type="text" id="newRequestNote" name="newRequestNote" size="60" />
  <input type="button" id="submitNewRequestNote" name="submitNewRequestNote" 
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
        <span class="first-line">
            <b>${requestNote.type}</b>
            - <g:message code="request.property.comment" /> n° <b>${requestNote.id}</b>
            - <g:message code="layout.from" /> <b>${requestNote.agent_name}</b>
        </span>
        <br/>
        <span class="second-line">
            <u><g:message code="request.property.comment" /></u> : ${requestNote.note}
        </span>
      </li>
    </g:each>
  </ul>
</g:else>

