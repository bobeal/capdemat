<form id="adultAddress_${adult.id}" method="post" action="${g.createLink(action:'adult')}">

  <div class="address required ${invalidFields?.contains('address') ? 'validation-failed' : ''}">
    <label for="address.additionalDeliveryInformation">${message(code:'address.property.additionalDeliveryInformation')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.additionalDeliveryInformation') ? 'validation-failed' : ''}" maxlength="38" id="address.additionalDeliveryInformation" name="additionalDeliveryInformation"
        value="${adult.address?.additionalDeliveryInformation}" />
    <label for="address.additionalGeographicalInformation">${message(code:'address.property.additionalGeographicalInformation')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.additionalGeographicalInformation') ? 'validation-failed' : ''}" maxlength="38" id="address.additionalGeographicalInformation" name="additionalGeographicalInformation"
        value="${adult.address?.additionalGeographicalInformation}" />
    <label for="address.streetNumber">${message(code:'address.property.streetNumber')}</label> -
    <label for="address.streetName" class="required">${message(code:'address.property.streetName')} *</label><br />
    <input type="text" class="line1 validate-streetNumber ${invalidFields?.contains('address.streetNumber') ? 'validation-failed' : ''}" size="5" maxlength="5" id="address.streetNumber" name="streetNumber"
        value="${adult?.address?.streetNumber}" />
    <input type="text" class="line2 required validate-streetName ${invalidFields?.contains('address.streetName') ? 'validation-failed' : ''}" maxlength="32" id="address.streetName" name="streetName" title="${message(code:'address.property.streetName.validationError')}"
        value="${adult.address?.streetName}" />
    <label for="address.placeNameOrService">${message(code:'address.property.placeNameOrService')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.placeNameOrService') ? 'validation-failed' : ''}" maxlength="38" id="address.placeNameOrService" name="placeNameOrService"
        value="${adult.address?.placeNameOrService}" />
    <label for="address.postalCode" class="required">${message(code:'address.property.postalCode')} * </label> -
    <label for="address.city" class="required">${message(code:'address.property.city')} *</label><br />
    <input type="text" class="line1 required validate-postalCode ${invalidFields?.contains('address.postalCode') ? 'validation-failed' : ''}" size="5" maxlength="5" id="postalCode" name="postalCode" title="${message(code:'address.property.postalCode.validationError')}"
        value="${adult.address?.postalCode}" />
    <input type="text" class="line2 required validate-city ${invalidFields?.contains('address.city') ? 'validation-failed' : ''}" maxlength="32" id="address.city" name="city" title="${message(code:'address.property.city.validationError')}"
        value="${adult.address?.city}" />
    <label for="address.countryName">${message(code:'address.property.countryName')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.countryName') ? 'validation-failed' : ''}" maxlength="38" id="address.countryName" name="countryName"
        value="${adult.address?.countryName}" />
  </div>
  <g:render template="edit/submit" model="['individual':adult, 'fragment':'address']" />
</form>
