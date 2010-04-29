<form method="post" id="${propertyName}_Form" action="${createLink(action:'modify')} />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span>

  <fieldset>
    <label>${message(code:'frenchRIB.property.bankCode')}</label>
    <input name="${propertyName}.bankCode" type="text" maxlength="5" value="${propertyValue.bankCode}" />

    <label>${message(code:'frenchRIB.property.counterCode')}</label>
    <input name="${propertyName}.counterCode" type="text" maxlength="5" value="${propertyValue.counterCode}" />

    <label>${message(code:'frenchRIB.property.accountNumber')}</label>
    <input name="${propertyName}.accountNumber" type="text" maxlength="11" value="${propertyValue.accountNumber}" />

    <label>${message(code:'frenchRIB.property.accountKey')}</label>
    <input name="${propertyName}.accountKey" type="text" maxlength="2" value="${propertyValue.accountKey}" />
  </fieldset>

  <input name="requestId" type="hidden" value="${requestId}" />
  <input type="button" class="submitField" value="${message(code:'action.save')}" />
  <input type="button" class="revertField" value="${message(code:'action.cancel')}" />
</form>
