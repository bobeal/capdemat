<form method="post" id="school_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="school_FormErrors" class="error"></span> 
  <select id="school_Field" name="schoolId">
    <g:each var="school" in="${schools}">
      <option value="${school.id}" ${(propertyValue != null && school.id == propertyValue) ? 'selected="selected"' : ''}>
        ${school.name}
      </option>
    </g:each>
  </select>

  <input name="requestId" type="hidden" value="${requestId}" />
  <input type="button" class="submitField" value="<g:message code="action.save" />" />
  <input type="button" class="revertField" value="<g:message code="action.cancel" />" />
</form>
