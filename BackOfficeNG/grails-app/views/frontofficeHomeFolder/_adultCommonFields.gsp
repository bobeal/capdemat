<input type="hidden" name="id" value="${adult?.id}" />
<input type="hidden" name="mode" value="edit" />
<div class="yui-gb">
  <h3><g:message code="homeFolder.individual.header.civilInformations" /></h3>
  <div class="yui-u first">
    <label for="title" class="required">
      <g:message code="homeFolder.adult.property.title" />
    </label>
    <select id="title" name="title"
      class="required validate-not-first ${invalidFields?.contains('title') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.adult.property.title.validationError" />">
      <option value="">
        <g:message code="message.select.defaultOption" />
      </option>
      <g:each in="${fr.cg95.cvq.business.users.TitleType.allTitleTypes}">
        <option value="fr.cg95.cvq.business.users.TitleType_${it}"
          ${it == adult?.title ? 'selected="selected"': ''}>
          <g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.title" />
        </option>
      </g:each>
    </select>
  </div>
  <div class="yui-u">
    <label for="lastName" class="required">
      <g:message code="homeFolder.individual.property.lastName" />
    </label>
    <input type="text" id="lastName" name="lastName" value="${adult?.lastName}"
      class="required validate-lastName ${invalidFields?.contains('lastName') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />
  </div>
  <div class="yui-u">
    <label for="firstName" class="required">
      <g:message code="homeFolder.individual.property.firstName" />
    </label>
    <input type="text" id="firstName" name="firstName" value="${adult?.firstName}"
      class="required validate-firstName ${invalidFields?.contains('firstName') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />
  </div>
</div>
<div class="yui-g">
  <h3><g:message code="homeFolder.individual.header.contactInformations" /></h3>
  <div class="yui-u first">
    <label class="required"><g:message code="homeFolder.individual.property.address" /></label>
    <div class="address-fieldset required ${invalidFields?.contains('adress') ? 'validation-failed' : ''}">
      <label for="adress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
      <input type="text" class="validate-addressLine38 ${invalidFields?.contains('adress.additionalDeliveryInformation') ? 'validation-failed' : ''}" maxlength="38" id="adress.additionalDeliveryInformation" name="adress.additionalDeliveryInformation"
        value="${adult?.adress?.additionalDeliveryInformation}" />
      <label for="adress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
      <input type="text" class="validate-addressLine38 ${invalidFields?.contains('adress.additionalGeographicalInformation') ? 'validation-failed' : ''}" maxlength="38" id="adress.additionalGeographicalInformation" name="adress.additionalGeographicalInformation"
        value="${adult?.adress?.additionalGeographicalInformation}" />
      <label for="adress.streetNumber"><g:message code="address.property.streetNumber" /></label> -
      <label for="adress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
      <input type="text" class="line1 validate-streetNumber ${invalidFields?.contains('adress.streetNumber') ? 'validation-failed' : ''}" size="5" maxlength="5" id="adress.streetNumber" name="adress.streetNumber"
        value="${adult?.adress?.streetNumber}" />
      <input type="text" class="line2 required validate-streetName ${invalidFields?.contains('adress.streetName') ? 'validation-failed' : ''}" maxlength="32" id="adress.streetName" name="adress.streetName" title="<g:message code="address.property.streetName.validationError" />"
        value="${adult?.adress?.streetName}" />
      <label for="adress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
      <input type="text" class="validate-addressLine38 ${invalidFields?.contains('adress.placeNameOrService') ? 'validation-failed' : ''}" maxlength="38" id="adress.placeNameOrService" name="adress.placeNameOrService"
        value="${adult?.adress?.placeNameOrService}" />
      <label for="adress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> -
      <label for="adress.city" class="required"><g:message code="address.property.city" /> *</label><br />
      <input type="text" class="line1 required validate-postalCode ${invalidFields?.contains('adress.postalCode') ? 'validation-failed' : ''}" size="5" maxlength="5" id="adress.postalCode" name="adress.postalCode" title="<g:message code="address.property.postalCode.validationError" />"
        value="${adult?.adress?.postalCode}" />
      <input type="text" class="line2 required validate-city ${invalidFields?.contains('adress.city') ? 'validation-failed' : ''}" maxlength="32" id="adress.city" name="adress.city" title="<g:message code="address.property.city.validationError" />"
        value="${adult?.adress?.city}" />
      <label for="adress.countryName"><g:message code="address.property.countryName" /></label>
      <input type="text" class="validate-addressLine38 ${invalidFields?.contains('adress.countryName') ? 'validation-failed' : ''}" maxlength="38" id="adress.countryName" name="adress.countryName"
        value="${adult?.adress?.countryName}" />
    </div>
  </div>
  <div class="yui-u">
    <label for="email" class="required">
      <g:message code="homeFolder.adult.property.email" /> <span><g:message code="homeFolder.adult.property.email.help" /></span>
    </label>
    <input type="text" id="email" name="email" value="${adult?.email}"
      class="required validate-email ${invalidFields?.contains('email') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.adult.property.email.validationError" />" />
    <label class="required">
      <g:message code="homeFolder.adult.label.phones" />
      <span>(<g:message code="homeFolder.adult.label.phones.help" />)</span>
    </label>
    <div id="adultPhones"
      class="address-fieldset ${invalidFields?.contains('adultPhones') ? 'validation-failed' : ''}">
      <label for="homePhone">
        <g:message code="homeFolder.adult.property.homePhone" />
        <span><g:message code="homeFolder.adult.property.homePhone.help" /></span>
      </label>
      <input type="text" id="homePhone" name="homePhone" value="${adult?.homePhone}"
        class="validate-phone ${invalidFields?.contains('homePhone') ? 'validation-failed' : ''}"
        title="<g:message code="homeFolder.adult.property.homePhone.validationError" />" />
      <label for="mobilePhone">
        <g:message code="homeFolder.adult.property.mobilePhone" />
        <span><g:message code="homeFolder.adult.property.mobilePhone.help" /></span>
      </label>
      <input type="text" id="mobilePhone" name="mobilePhone" value="${adult?.mobilePhone}"
        class="validate-mobilePhone ${invalidFields?.contains('mobilePhone') ? 'validation-failed' : ''}"
        title="<g:message code="homeFolder.adult.property.mobilePhone.validationError" />" />
      <label for="officePhone">
        <g:message code="homeFolder.adult.property.officePhone" />
        <span><g:message code="homeFolder.adult.property.officePhone.help" /></span>
      </label>
      <input type="text" id="officePhone" name="officePhone" value="${adult?.officePhone}"
        class="validate-phone ${invalidFields?.contains('officePhone') ? 'validation-failed' : ''}"
        title="<g:message code="homeFolder.adult.property.officePhone.validationError" />" />
    </div>
  </div>
</div>
