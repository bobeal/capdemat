<form method="POST" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span> 
  
  <textarea id="${propertyName}_Field" name="${propertyNameTp}" rows="${rows}" class="${required}" 
      title="<g:message code="${i18nKeyPrefix}.validationError" />"
  >${propertyValue}</textarea>
  
  <input name="requestId" type="hidden" value="${requestId}" />
  <input name="individualId" type="hidden" value="${individualId}" />

  <input type="button" class="submitField" value="<g:message code="action.save" />" />
  <input type="button" class="revertField" value="<g:message code="action.cancel" />" />
</form>
