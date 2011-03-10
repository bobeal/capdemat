<form id="adultAddress_${adult.id}" method="post" action="${g.createLink(action:'adult')}">

  <div id="adultAddress" class="address required ${invalidFields?.contains('address') ? 'validation-failed' : ''}">
    <label for="adultAddress_additionalDeliveryInformation">${message(code:'address.property.additionalDeliveryInformation')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.additionalDeliveryInformation') ? 'validation-failed' : ''}" maxlength="38" id="adultAddress_additionalDeliveryInformation" name="additionalDeliveryInformation"
        value="${adult.address?.additionalDeliveryInformation}" />
    <label for="adultAddress_additionalGeographicalInformation">${message(code:'address.property.additionalGeographicalInformation')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.additionalGeographicalInformation') ? 'validation-failed' : ''}" maxlength="38" id="adultAddress_additionalGeographicalInformation" name="additionalGeographicalInformation"
        value="${adult.address?.additionalGeographicalInformation}" />
    <label for="adultAddress_streetNumber">${message(code:'address.property.streetNumber')}</label> -
    <label for="adultAddress_streetName" class="required">${message(code:'address.property.streetName')} *</label><br />
    <input type="text" class="line1 validate-streetNumber ${invalidFields?.contains('address.streetNumber') ? 'validation-failed' : ''}" size="5" maxlength="5" id="adultAddress_streetNumber" name="streetNumber"
        value="${adult?.address?.streetNumber}" />
    <input type="text" class="line2 required validate-streetName ${invalidFields?.contains('address.streetName') ? 'validation-failed' : ''}" maxlength="32" id="adultAddress_streetName" name="streetName" title="${message(code:'address.property.streetName.validationError')}"
        value="${adult.address?.streetName}" />
    <label for="adultAddress_placeNameOrService">${message(code:'address.property.placeNameOrService')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.placeNameOrService') ? 'validation-failed' : ''}" maxlength="38" id="adultAddress_placeNameOrService" name="placeNameOrService"
        value="${adult.address?.placeNameOrService}" />
    <label for="adultAddress_postalCode" class="required">${message(code:'address.property.postalCode')} * </label> -
    <label for="adultAddress_city" class="required">${message(code:'address.property.city')} *</label><br />
    <input type="text" class="line1 required validate-postalCode ${invalidFields?.contains('address.postalCode') ? 'validation-failed' : ''}" size="5" maxlength="5" id="adultAddress_postalCode" name="postalCode" title="${message(code:'address.property.postalCode.validationError')}"
        value="${adult.address?.postalCode}" />
    <input type="text" class="line2 required validate-city ${invalidFields?.contains('address.city') ? 'validation-failed' : ''}" maxlength="32" id="adultAddress_city" name="city" title="${message(code:'address.property.city.validationError')}"
        value="${adult.address?.city}" />
    <label for="adultAddress_countryName">${message(code:'address.property.countryName')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.countryName') ? 'validation-failed' : ''}" maxlength="38" id="adultAddress_countryName" name="countryName"
        value="${adult.address?.countryName}" />
    <input type="hidden" id="adultAddress_streetMatriculation" name="streetMatriculation" value="${adult.address?.streetMatriculation}" />
    <input type="hidden" id="adultAddress_streetRivoliCode" name="streetRivoliCode" value="${adult.address?.streetRivoliCode}" />
    <input type="hidden" id="adultAddress_cityInseeCode" name="cityInseeCode" value="${adult.address?.cityInseeCode}" />
  </div>
  <g:render template="edit/submit" model="['individual':adult, 'fragment':'address']" />
</form>
