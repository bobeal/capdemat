<form method="POST" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="form-list-edition" >
  <span id="${propertyName}_FormErrors" class="error"></span> 
  
  <input id="${propertyName}_Input" name="${propertyNameTp}" type="text" maxlength="10" 
      value="${propertyValue}" 
      class="validate-date-au ${required}" 
      title="<g:message code="request.error.dateRequired" />" 
  />
  
  <a onclick="showCalendar('${propertyName}_InputShow', 0);">
    <img id="${propertyName}_InputShow" src="${createLinkTo(dir:'css/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="${propertyName}_InputCalContainer" class="yui-cal"></div>
  
  <input name="requestId" type="hidden" value="${requestId}" />
  <input name="individualId" type="hidden" value="${individualId}" />

  <input type="button" value="modify" class="submit" />
  <input type="button" value="discard" class="discard" />
</form>
