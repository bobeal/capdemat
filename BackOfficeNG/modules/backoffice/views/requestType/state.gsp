<form action="${createLink(action:"state")}" id="requestStateForm" method="post">
  <ul>
    <g:if test="${!active}">
      <li>
        <input type="radio"  class="validate-one-required" value="active" name="requestState"/>
        <span class="tag-validated">${message(code:'property.active')}</span>
      </li>
    </g:if>
    <g:if test="${active}">
      <li>
        <input type="radio" value="inactive" name="requestState"/>
        <span class="tag-rejected">${message(code:'property.inactive')}</span>
      </li>
    </g:if>
  </ul>
  <input type="hidden" value="${active ? 'active':'inactive'}" id="initRequestState" name="initState" />
  <input type="hidden" value="${requestTypeId}" name="id" />
  <input id="saveButton" class="submitStateChange bt" type="button" value="${message(code:'action.confirm')}" />
  <input id="cancelButton" class="cancelStateChange bt" type="button" value="${message(code:'action.cancel')}" />
</form>
