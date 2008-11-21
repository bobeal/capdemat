<form method="POST" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span> 
  
  <input id="${propertyName}_Field" name="${propertyNameTp}" type="text" maxlength="10" 
      value="${propertyValue}" 
      class="validate-date-au ${required}" 
      title="<g:message code="request.error.dateRequired" />" 
  />
  
  <a onclick="showCalendar('${propertyName}_FieldShow', 0);">
    <img id="${propertyName}_FieldShow" src="${createLinkTo(dir:'css/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="${propertyName}_FieldCalContainer" class="yui-cal"></div>
  
  <input name="requestId" type="hidden" value="${requestId}" />
  <input name="individualId" type="hidden" value="${individualId}" />

  <input type="button" class="submit" value="<g:message code="action.save" />" />
  <input type="button" class="discard" value="<g:message code="action.cancel" />" />
</form>
