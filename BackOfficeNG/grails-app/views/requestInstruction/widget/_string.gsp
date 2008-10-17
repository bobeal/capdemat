<form method="POST" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span> 
  
  <input id="${propertyName}_Field" name="${propertyNameTp}" type="text" value="${propertyValue}" 
      class="${propertyType != "" ? 'validate-' + propertyType : ''} ${required}" 
      title=" <g:if test="${propertyType == 'email'}">
                <g:message code="request.error.emailRequired" />
              </g:if>
              <g:elseif test="${propertyType == 'number'}">
                <g:message code="request.error.numberRequired" />
              </g:elseif>
              <g:elseif test="${required == 'required'}">
               <g:message code="request.error.required" />
              </g:elseif>" 
  />
  
  <input name="requestId" type="hidden" value="${requestId}" />
  <input name="individualId" type="hidden" value="${individualId}" />

  <input type="button" value="modify" class="submit" />
  <input type="button" value="discard" class="discard" />
</form>
