<form method="POST" id="requestNoteForm" action="<g:createLink action="addRequestNote" />">
  <label for="newRequestNote"><g:message code="action.add" /></label>
  <input type="text" id="newRequestNote" name="newRequestNote" size="60" />
  <input type="button" id="submitNewRequestNote" name="submitNewRequestNote" value="Valider"  />
  <input type="hidden" id="requestId" name="requestId" value="${requestId}">
</form>

<ul>
  <g:if test="${requestNoteList.size() == 0}">
  <g:message code="request.message.noComment" /> <g:message code="request.property.comment" /> !
  </g:if>
  <g:else>
    <g:each var="requestNote" in="${requestNoteList}">
      <li>
        <span class="first-line">
            <img src="${createLinkTo(dir:'images',file:'16-circle-green.png')}"/>
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
  </g:else>
</ul>

