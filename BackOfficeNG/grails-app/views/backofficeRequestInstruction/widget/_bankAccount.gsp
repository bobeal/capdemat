<form method="post" id="${propertyName.replace('[','').replace(']','').replace('.', '')}_Form" action="${createLink(action:'modify')} />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span>
  <fieldset>
    <label>${message(code:'bankAccount.property.BIC')}</label>
    <input name="${propertyName}.BIC" type="text" value="${propertyValue.BIC}"
      class="required validate-regex" regex="[a-zA-Z]{6}[a-zA-Z0-9]{2,5}" maxlength="11" />
    <label>${message(code:'bankAccount.property.IBAN')}</label>
    <input name="${propertyName}.IBAN" type="text" value="${propertyValue.IBAN}"
      class="required validate-IBAN" maxlength="34" />
  </fieldset>
  <input name="requestId" type="hidden" value="${requestId}" />
  <input type="button" class="submitField" value="${message(code:'action.save')}" />
  <input type="button" class="revertField" value="${message(code:'action.cancel')}" />
</form>
