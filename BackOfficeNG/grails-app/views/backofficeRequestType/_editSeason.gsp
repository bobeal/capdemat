<form id="seasonForm_${season?.id}" class="editable-list-form"
  action="${createLink(action:'editSeason')}" method="post">
  <div id="error-container_${season?.id}" class="error"></div>

  <label class="required" for="label"><g:message code="requestSeason.property.label"/> * :</label>
  <input type="text" name="label" class="required" value="${season?.label}" />

  <label class="required" for="registrationStart"><g:message code="requestSeason.property.registrationStart"/> * :</label>
  <input type="text" id="registrationStart_${season?.id}" name="registrationStart" class="required validate-date"
    <g:if test="${season}">value="<g:formatDate formatName='format.date' date='${season.registrationStart.toDate()}'/>"</g:if> />
  <a class="calendarLink">
    <img id="registrationStart_${season?.id}Show" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="registrationStart_${season?.id}CalContainer" class="yui-cal yui-calcontainer"></div>

  <label class="required" for="registrationEnd"><g:message code="requestSeason.property.registrationEnd"/> * :</label>
  <input type="text" id="registrationEnd_${season?.id}" name="registrationEnd" class="required validate-date"
    <g:if test="${season}">value="<g:formatDate formatName='format.date' date='${season?.registrationEnd.toDate()}'/>"</g:if> />
  <a class="calendarLink">
    <img id="registrationEnd_${season?.id}Show" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="registrationEnd_${season?.id}CalContainer" class="yui-cal yui-calcontainer"></div>

  <label for="validationAuthorizationStart"><g:message code="requestSeason.property.validationAuthorizationStart"/> :</label>
  <input type="text" id="validationAuthorizationStart_${season?.id}" name="validationAuthorizationStart" class="validate-date"
    <g:if test="${season}">value="<g:formatDate formatName='format.date' date='${season?.validationAuthorizationStart?.toDate()}'/>"</g:if> />
  <a class="calendarLink">
    <img id="validationAuthorizationStart_${season?.id}Show" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="validationAuthorizationStart_${season?.id}CalContainer" class="yui-cal yui-calcontainer"></div>

  <label class="required" for="effectStart"><g:message code="requestSeason.property.effectStart"/> * :</label>
  <input type="text" id="effectStart_${season?.id}" name="effectStart" class="required validate-date"
    <g:if test="${season}">value="<g:formatDate formatName='format.date' date='${season?.effectStart.toDate()}'/>"</g:if> />
  <a class="calendarLink">
    <img id="effectStart_${season?.id}Show" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="effectStart_${season?.id}CalContainer" class="yui-cal yui-calcontainer"></div>

  <label class="required" for="effectEnd"><g:message code="requestSeason.property.effectEnd"/> * :</label>
  <input type="text" id="effectEnd_${season?.id}" name="effectEnd" class="required validate-date"
    <g:if test="${season}">value="<g:formatDate formatName='format.date' date='${season?.effectEnd.toDate()}'/>"</g:if> />
  <a class="calendarLink">
    <img id="effectEnd_${season?.id}Show" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="effectEnd_${season?.id}CalContainer" class="yui-cal yui-calcontainer"></div>

  <input type="hidden" name="requestTypeId" class="required" value="${requestTypeId}" />
  <input type="hidden" name="id" class="required" value="${season?.id}" />
  <p class="same-line">
    <input id="saveSeason_${season?.id}" name="save" type="button"
      class="submitEditItem form-button first-button" value="${message(code:'action.save')}" />
    <input id="cancelEditSeason_${season?.id}" name="cancel" type="button"
      class="cancelEditItem form-button" value="${message(code:'action.close')}" />
  </p>
</form>
