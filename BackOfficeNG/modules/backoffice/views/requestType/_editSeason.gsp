<form id="seasonForm_${season?.uuid}" class="editable-list-form"
  action="${createLink(action:'editSeason')}" method="post">
  <div id="error-container_${season?.uuid}" class="error"></div>

  <label class="required" for="label"><g:message code="requestSeason.property.label"/> * :</label>
  <input type="text" name="label" class="required" value="${season?.label}" />

  <label class="required" for="registrationStart"><g:message code="requestSeason.property.registrationStart"/> * :</label>
  <input type="text" id="registrationStart_${season?.uuid}" name="registrationStart" class="required validate-date-au" value="<g:formatDate formatName='format.date' date='${season?.registrationStart}'/>" />
  <a class="calendarLink" onclick="showCalendar('registrationStart_${season?.uuid}Show', 'registrationStart_${season?.uuid}');">
    <img id="registrationStart_${season?.uuid}Show" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="registrationStart_${season?.uuid}CalContainer" class="yui-cal yui-calcontainer"></div>

  <label class="required" for="registrationEnd"><g:message code="requestSeason.property.registrationEnd"/> * :</label>
  <input type="text" id="registrationEnd_${season?.uuid}" name="registrationEnd" class="required validate-date-au" value="<g:formatDate formatName='format.date' date='${season?.registrationEnd}'/>" />
  <a class="calendarLink" onclick="showCalendar('registrationEnd_${season?.uuid}Show', 'registrationEnd_${season?.uuid}');">
    <img id="registrationEnd_${season?.uuid}Show" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="registrationEnd_${season?.uuid}CalContainer" class="yui-cal yui-calcontainer"></div>

  <label class="required" for="validationAuthorizationStart"><g:message code="requestSeason.property.validationAuthorizationStart"/> * :</label>
  <input type="text" id="validationAuthorizationStart_${season?.uuid}" name="validationAuthorizationStart" class="required validate-date-au" value="<g:formatDate formatName='format.date' date='${season?.validationAuthorizationStart}'/>" />
  <a class="calendarLink" onclick="showCalendar('validationAuthorizationStart_${season?.uuid}Show', 'validationAuthorizationStart_${season?.uuid}');">
    <img id="validationAuthorizationStart_${season?.uuid}Show" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="validationAuthorizationStart_${season?.uuid}CalContainer" class="yui-cal yui-calcontainer"></div>

  <label class="required" for="effectStart"><g:message code="requestSeason.property.effectStart"/> * :</label>
  <input type="text" id="effectStart_${season?.uuid}" name="effectStart" class="required validate-date-au" value="<g:formatDate formatName='format.date' date='${season?.effectStart}'/>" />
  <a class="calendarLink" onclick="showCalendar('effectStart_${season?.uuid}Show', 'effectStart_${season?.uuid}');">
    <img id="effectStart_${season?.uuid}Show" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="effectStart_${season?.uuid}CalContainer" class="yui-cal yui-calcontainer"></div>

  <label class="required" for="effectEnd"><g:message code="requestSeason.property.effectEnd"/> * :</label>
  <input type="text" id="effectEnd_${season?.uuid}" name="effectEnd" class="required validate-date-au" value="<g:formatDate formatName='format.date' date='${season?.effectEnd}'/>" />
  <a class="calendarLink" onclick="showCalendar('effectEnd_${season?.uuid}Show', 'effectEnd_${season?.uuid}');">
    <img id="effectEnd_${season?.uuid}Show" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="effectEnd_${season?.uuid}CalContainer" class="yui-cal yui-calcontainer"></div>

  <input type="hidden" name="requestTypeId" class="required" value="${requestTypeId}" />
  <input type="hidden" name="uuid" class="required" value="${season?.uuid}" />
  <p class="same-line">
    <input id="saveSeason_${season?.uuid}" name="save" type="button"
      class="submitEditItem form-button" value="${message(code:'action.save')}" /> 
    <input id="cancelEditSeason_${season?.uuid}" name="cancel" type="button"
      class="cancelEditItem form-button" value="${message(code:'action.close')}" />
  </p>
</form>
