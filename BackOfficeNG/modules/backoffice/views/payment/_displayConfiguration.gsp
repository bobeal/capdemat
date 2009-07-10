<h2><g:message code="payment.header.displayConfiguration" /></h2>
<form method="post" id="displayConfigurationForm" action="${createLink(action : 'displayConfiguration')}">
  <p class="field">
    <label>
      <g:message code="payment.property.displayInProgressPayments" /> :
    </label>
    <input type="checkbox" name="displayInProgressPayments" <g:if test="${displayInProgressPayments}">checked="checked" </g:if>/>
    <input type="hidden" name="_displayInProgressPayments" />
  </p>
  <div class="form-button">
    <input type="button" value="${message(code:'action.save')}" rel="saveDisplayConfiguration" />
  </div>
</form>