<form method="post" id="${propertyName}_Form" action="${createLink(action:'modify')}" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span>
  
  <input id="${propertyName}_Field" name="${propertyName}" type="text" maxlength="10" 
      value="${propertyValue}" 
      class="validate-date-au ${required}" 
      title="${message(code:'request.error.dateRequired')}"/>
  
  <a>
    <img id="${propertyName}_FieldShow" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="${propertyName}_FieldCalContainer" class="yui-cal"></div>

  <input name="requestId" type="hidden" value="${requestId}" />
  <input type="button" class="submitField" value="${message(code:'action.save')}" />
  <input type="button" class="revertField" value="${message(code:'action.cancel')}" />
</form>
