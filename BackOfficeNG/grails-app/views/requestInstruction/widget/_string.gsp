<form method="POST" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="form-list-edition" >
  <span id="${propertyName}_FormErrors" class="error"></span> 
  
  <input id="${propertyName}_tp" name="${propertyNameTp}" type="text" value="${propertyValue}" 
      class="required" title="<g:message code="request.error.propertyValueRequired" />" />
  
  <input name="oldPropertyValue" type="hidden" value="${propertyValue}" />sdsd
  <input name="requestId" type="hidden" value="${requestId}" />
  <input name="individualId" type="hidden" value="${individualId}" />

  <input type="button" value="modify" class="submit" />
  <input type="button" value="discard" class="discard" />
</form>
