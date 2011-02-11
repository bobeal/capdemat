<form id="adultContact_${adult.id}" method="post" action="${g.createLink(action:'adult')}">

  <label for="email" class="required">
    ${message(code:'homeFolder.adult.property.email')} *
    <span>
      ${message(code:'homeFolder.adult.property.email.help')}
    </span>
  </label>
  <input type="text" id="email" name="email" value="${adult?.email}"
      class="required validate-email ${invalidFields?.contains('email') ? 'validation-failed' : ''}"
      title="${message(code:'homeFolder.adult.property.email.validationError')}" />

  <label class="required">
    ${message(code:'homeFolder.adult.label.phones')} *
    <span>
      (${message(code:'homeFolder.adult.label.phones.help')})
    </span>
  </label>
  <div id="adultPhones" class="address ${invalidFields?.contains('adultPhones') ? 'validation-failed' : ''}">

    <label for="homePhone">
      ${message(code:'homeFolder.adult.property.homePhone')}
      <span>
        ${message(code:'homeFolder.adult.property.homePhone.help')}
      </span>
    </label>
    <input type="text" id="homePhone" name="homePhone" value="${adult?.homePhone}"
        class="validate-phone ${invalidFields?.contains('homePhone') ? 'validation-failed' : ''}"
        title="${message(code:'homeFolder.adult.property.homePhone.validationError')}" />

    <label for="mobilePhone">
      ${message(code:'homeFolder.adult.property.mobilePhone')}
      <span>
        ${message(code:'homeFolder.adult.property.mobilePhone.help')}
      </span>
    </label>
    <input type="text" id="mobilePhone" name="mobilePhone" value="${adult?.mobilePhone}"
        class="validate-mobilePhone ${invalidFields?.contains('mobilePhone') ? 'validation-failed' : ''}"
        title="${message(code:'homeFolder.adult.property.mobilePhone.validationError')}" />

    <label for="officePhone">
      ${message(code:'homeFolder.adult.property.officePhone')}
      <span>
        ${message(code:'homeFolder.adult.property.officePhone.help')}
      </span>
    </label>
    <input type="text" id="officePhone" name="officePhone" value="${adult?.officePhone}"
        class="validate-phone ${invalidFields?.contains('officePhone') ? 'validation-failed' : ''}"
        title="${message(code:'homeFolder.adult.property.officePhone.validationError')}" />
  </div>
  <g:render template="edit/submit" model="['individual':adult, 'fragment':'contact']" />
</form>
