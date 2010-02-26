<form method="post" id="recreationCenter_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="recreationCenter_FormErrors" class="error"></span> 
  <select id="recreationCenter_Field" name="recreationCenterId">
    <g:each var="recreationCenter" in="${recreationCenters}">
      <option value="${recreationCenter.id}" ${(propertyValue != null && recreationCenter.id == propertyValue) ? 'selected="selected"' : ''}>
        ${recreationCenter.name}
      </option>
    </g:each>
  </select>

  <input name="requestId" type="hidden" value="${requestId}" />
  <input type="button" class="submitField" value="<g:message code="action.save" />" />
  <input type="button" class="revertField" value="<g:message code="action.cancel" />" />
</form>
