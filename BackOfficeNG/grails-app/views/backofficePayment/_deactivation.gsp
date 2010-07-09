<h2><g:message code="payment.header.deactivation" /></h2>
<form method="post" id="activationForm" action="${createLink(action : 'deactivation')}">
  <p class="field">
    <label>
      <g:message code="payment.property.inactive" /> :
    </label>
    <input type="checkbox" name="inactive" rel="toggleDeactivationDatesPanel" <g:if test="${inactive}">checked="checked" </g:if>/>
  </p>
  <div id="deactivationDatesPanel"<g:if test="${!inactive}"> class="invisible"</g:if>>
    <p class="field">
      <label for="paymentDeactivationStartDate">
        <g:message code="payment.property.paymentDeactivationStartDate" /> :
      </label>
      <input type="text" id="paymentDeactivationStartDate" name="paymentDeactivationStartDate" class="validate-date"
        value="<g:formatDate formatName="format.date" date="${paymentDeactivationStartDate}" />" />
      <a class="calendarLink">
        <img id="paymentDeactivationStartDateShow" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
      </a>
      <div id="paymentDeactivationStartDateCalContainer" class="yui-cal yui-calcontainer"></div>
    </p>
    <p class="field">
      <label for="paymentDeactivationEndDate">
        <g:message code="payment.property.paymentDeactivationEndDate" /> :
      </label>
      <input type="text" id="paymentDeactivationEndDate" name="paymentDeactivationEndDate" class="validate-date"
        value="<g:formatDate formatName="format.date" date="${paymentDeactivationEndDate}" />" />
      <a class="calendarLink">
        <img id="paymentDeactivationEndDateShow" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
      </a>
      <div id="paymentDeactivationEndDateCalContainer" class="yui-cal yui-calcontainer"></div>
    </p>
  </div>
  <div class="form-button">
    <input type="button" value="${message(code:'action.save')}" rel="saveActivation" />
  </div>
</form>