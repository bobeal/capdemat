<div id="requestTypeDelaysConfiguration" class="mainbox mainbox-yellow">
  <h2><g:message code="requestType.configuration.delays" /></h2>
  <div id="requestTypeDelaysMessages"></div>
  <form class="edit" method="post" id="requestTypeDelaysForm" action="${createLink(action:'delays')}">
    <div class="error" id="dialogRequestTypeDelaysFormError"></div>
    <p class="field">
      <label for="instructionMaxDelay">
        <g:message code="requestType.property.instructionMaxDelay" /> :
        <span>
          (<g:message code="message.defaultValue" /> :
            ${defaultConfig.instructionMaxDelay} <g:message code="property.days" />)
        </span>
      </label>
      <input type="text" name="instructionMaxDelay" value="${requestType?.instructionMaxDelay}"
        class="validate-number" size="3"
        title="${message(code:'requestType.message.instructionMaxDelayIsNumber')}"/>
      <g:message code="property.days" />
    </p>
    <p class="field">
      <label for="instructionAlertDelay">
        <g:message code="requestType.property.instructionAlertDelay" /> :
        <span>
          (<g:message code="message.defaultValue" /> :
            ${defaultConfig.instructionAlertDelay} <g:message code="property.days" />)
        </span>
      </label>
      <input type="text" name="instructionAlertDelay" value="${requestType?.instructionAlertDelay}"
        class="validate-number" size="3"
        title="${message(code:'requestType.message.instructionAlertDelayIsNumber')}"/>
      <g:message code="property.days" />
    </p>
    <div class="form-button">
      <input type="button" id="saveRequestTypeDelays"
        name="saveRequestTypeDelays" value="${message(code:'action.save')}" />
      <input type="hidden" name="id" value="${requestType?.id}" />
    </div>
  </form>
</div>
