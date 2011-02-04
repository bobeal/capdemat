<input type="hidden" name="id" value="${adult?.id}" />
<input type="hidden" name="mode" value="edit" />
  <fieldset>
  <legend><g:message code="homeFolder.individual.header.civilInformations" /></legend>
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

    <label for="lastName" class="required">
      <g:message code="homeFolder.individual.property.lastName" />
    </label>
    <input type="text" id="lastName" name="lastName" value="${adult?.lastName}"
      class="required validate-lastName ${invalidFields?.contains('lastName') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />

    <label for="firstName" class="required">
      <g:message code="homeFolder.individual.property.firstName" />
    </label>
    <input type="text" id="firstName" name="firstName" value="${adult?.firstName}"
      class="required validate-firstName ${invalidFields?.contains('firstName') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />
    </fieldset>

    <fieldset>
    <legend><g:message code="homeFolder.individual.header.contactInformations" /></legend>
    <label class="required"><g:message code="homeFolder.individual.property.address" /></label>
    <div class="address required ${invalidFields?.contains('address') ? 'validation-failed' : ''}">
      <label for="address.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
      <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.additionalDeliveryInformation') ? 'validation-failed' : ''}" maxlength="38" id="address.additionalDeliveryInformation" name="address.additionalDeliveryInformation"
        value="${adult?.address?.additionalDeliveryInformation}" />
      <label for="address.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
      <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.additionalGeographicalInformation') ? 'validation-failed' : ''}" maxlength="38" id="address.additionalGeographicalInformation" name="address.additionalGeographicalInformation"
        value="${adult?.address?.additionalGeographicalInformation}" />
      <label for="address.streetNumber"><g:message code="address.property.streetNumber" /></label> -
      <label for="address.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
      <input type="text" class="line1 validate-streetNumber ${invalidFields?.contains('address.streetNumber') ? 'validation-failed' : ''}" size="5" maxlength="5" id="address.streetNumber" name="address.streetNumber"
        value="${adult?.address?.streetNumber}" />
      <input type="text" class="line2 required validate-streetName ${invalidFields?.contains('address.streetName') ? 'validation-failed' : ''}" maxlength="32" id="address.streetName" name="address.streetName" title="<g:message code="address.property.streetName.validationError" />"
        value="${adult?.address?.streetName}" />
      <label for="address.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
      <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.placeNameOrService') ? 'validation-failed' : ''}" maxlength="38" id="address.placeNameOrService" name="address.placeNameOrService"
        value="${adult?.address?.placeNameOrService}" />
      <label for="address.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> -
      <label for="address.city" class="required"><g:message code="address.property.city" /> *</label><br />
      <input type="text" class="line1 required validate-postalCode ${invalidFields?.contains('address.postalCode') ? 'validation-failed' : ''}" size="5" maxlength="5" id="address.postalCode" name="address.postalCode" title="<g:message code="address.property.postalCode.validationError" />"
        value="${adult?.address?.postalCode}" />
      <input type="text" class="line2 required validate-city ${invalidFields?.contains('address.city') ? 'validation-failed' : ''}" maxlength="32" id="address.city" name="address.city" title="<g:message code="address.property.city.validationError" />"
        value="${adult?.address?.city}" />
      <label for="address.countryName"><g:message code="address.property.countryName" /></label>
      <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.countryName') ? 'validation-failed' : ''}" maxlength="38" id="address.countryName" name="address.countryName"
        value="${adult?.address?.countryName}" />
    </div>
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
      class="address ${invalidFields?.contains('adultPhones') ? 'validation-failed' : ''}">
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
    </fieldset>

