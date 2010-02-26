<div id="requestTypeAlertsConfiguration">
  <h2><g:message code="requestType.configuration.alerts" /></h2>
  <div id="requestTypeAlertsMessages"></div>
  <form class="edit" method="post" id="requestTypeAlertsForm" action="${createLink(action:'saveAlerts')}">
    <div class="error" id="dialogRequestTypeAlertsFormError"></div>
    <label for="instructionMaxDelay">
      <g:message code="requestType.property.instructionMaxDelay" /> :
      <span>
        (<g:message code="message.defaultValue" /> :
          ${instructionDefaultMaxDelay} <g:message code="property.days" />)
      </span>
    </label>
    <input type="text" name="instructionMaxDelay" value="${requestType?.instructionMaxDelay}"
        class="validate-number required" size="3"
        title="${message(code:'requestType.message.instructionMaxDelayIsNumber')}"/>
    <br/>
    <label for="instructionAlertDelay">
      <g:message code="requestType.property.instructionAlertDelay" /> :
      <span>
        (<g:message code="message.defaultValue" /> : 
          ${instructionDefaultAlertDelay} <g:message code="property.days" />)
      </span>
    </label>
    <input type="text" name="instructionAlertDelay" value="${requestType?.instructionAlertDelay}"
        class="validate-number required" size="3"
        title="${message(code:'requestType.message.instructionAlertDelayIsNumber')}"/>
    <div class="form-button">
      <input type="button" id="saveRequestTypeAlerts" 
        name="saveRequestTypeAlerts" value="${message(code:'action.save')}" />
      <input type="hidden" name="requestTypeId" value="${requestType?.id}" />
    </div>
  </form>
</div>

