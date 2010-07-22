<form id="seasonForm_${season?.id}" class="listItem" action="${createLink(action:'editSeason')}" method="post">
  <input type="hidden" name="requestTypeId" value="${requestTypeId}" />
  <input type="hidden" name="id" value="${season?.id}" />
  <p>
    <label class="required" for="label"><g:message code="requestSeason.property.label"/> * :</label>
    <input type="text" name="label" class="required" value="${season?.label}" />
  </p>
  <p>
    <label class="required" for="registrationStart"><g:message code="requestSeason.property.registrationStart"/> * :</label>
    <input type="text" id="registrationStart_${season?.id}" name="registrationStart" class="required validate-date"
      <g:if test="${season}">value="<g:formatDate formatName='format.date' date='${season.registrationStart.toDate()}'/>"</g:if> />
    <img id="registrationStart_${season?.id}Show" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}" class="calendar"/>
    <span id="registrationStart_${season?.id}CalContainer" class="yui-cal yui-calcontainer"></span>
  </p>
  <p>
    <label class="required" for="registrationEnd"><g:message code="requestSeason.property.registrationEnd"/> * :</label>
    <input type="text" id="registrationEnd_${season?.id}" name="registrationEnd" class="required validate-date"
      <g:if test="${season}">value="<g:formatDate formatName='format.date' date='${season?.registrationEnd.toDate()}'/>"</g:if> />
    <img id="registrationEnd_${season?.id}Show" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}" class="calendar"/>
    <span id="registrationEnd_${season?.id}CalContainer" class="yui-cal yui-calcontainer"></span>
  </p>
  <p>
    <label for="validationAuthorizationStart"><g:message code="requestSeason.property.validationAuthorizationStart"/> :</label>
    <input type="text" id="validationAuthorizationStart_${season?.id}" name="validationAuthorizationStart" class="validate-date"
      <g:if test="${season}">value="<g:formatDate formatName='format.date' date='${season?.validationAuthorizationStart?.toDate()}'/>"</g:if> />
    <img id="validationAuthorizationStart_${season?.id}Show" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}" class="calendar"/>
    <span id="validationAuthorizationStart_${season?.id}CalContainer" class="yui-cal yui-calcontainer"></span>
  </p>
  <p>
    <label class="required" for="effectStart"><g:message code="requestSeason.property.effectStart"/> * :</label>
    <input type="text" id="effectStart_${season?.id}" name="effectStart" class="required validate-date"
      <g:if test="${season}">value="<g:formatDate formatName='format.date' date='${season?.effectStart.toDate()}'/>"</g:if> />
    <img id="effectStart_${season?.id}Show" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}" class="calendar" />
    <span id="effectStart_${season?.id}CalContainer" class="yui-cal yui-calcontainer"></span>
  </p>
  <p>
    <label class="required" for="effectEnd"><g:message code="requestSeason.property.effectEnd"/> * :</label>
    <input type="text" id="effectEnd_${season?.id}" name="effectEnd" class="required validate-date"
      <g:if test="${season}">value="<g:formatDate formatName='format.date' date='${season?.effectEnd.toDate()}'/>"</g:if> />
    <img id="effectEnd_${season?.id}Show" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}" class="calendar"/>
    <span id="effectEnd_${season?.id}CalContainer" class="yui-cal yui-calcontainer"></span>
  </p>
  <p id="error-container_${season?.id}" class="error"></p>q
  <p class="button">
    <input id="saveSeason_${season?.id}" name="save" type="button"" value="${message(code:'action.save')}" />
    <input id="cancelEditSeason_${season?.id}" name="cancel" type="button" value="${message(code:'action.close')}" />
  </p>
</form>
