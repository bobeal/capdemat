<form id="address_${actor.id}" method="post" action="${g.createLink(action:"address", id : actor.id)}">
  <dt class="required">${message(code:'homeFolder.individual.property.address')}</dt>
  <dd class="required">
    <label>${message(code:'address.property.additionalDeliveryInformation')}</label>
    <input type="text" name="additionalDeliveryInformation" value="${actor.address.additionalDeliveryInformation}" maxlength="38" class="validate-addressLine38" />
    <label>${message(code:'address.property.additionalGeographicalInformation')}</label>
    <input type="text" name="additionalGeographicalInformation" value="${actor.address.additionalGeographicalInformation}" maxlength="38" class="validate-addressLine38" />
    <label>Numéro et <strong>${message(code:'address.property.streetName')} * </strong></label>
    <input type="text" name="streetNumber" value="${actor.address.streetNumber}" maxlength="5" class="line1 validate-streetNumber" />
    <input type="text" name="streetName" value="${actor.address.streetName}" maxlength="32" class="line2 validate-streetName" />
    <label>${message(code:'address.property.placeNameOrService')}</label>
    <input type="text" name="placeNameOrService" value="${actor.address.placeNameOrService}" maxlength="38" class="validate-addressLine38" />
    <label><strong>${message(code:'address.property.postalCode')} * - ${message(code:'address.property.city')} * </strong></label>
    <input type="text" name="postalCode" value="${actor.address.postalCode}" maxlength="5" class="line1 validate-postalCode" />
    <input type="text" name="city" value="${actor.address.city}" maxlength="32" size="4" class="line2 validate-city" />
    <label>${message(code:'address.property.countryName')}</label>
    <input type="text" name="countryName" maxlength="38" class="validate-addressLine38" value="${actor.address.countryName}" />
    <!-- TODO : wire address referential -->
    <input type="hidden" name="streetMatriculation" value="${actor.address.streetMatriculation}" />
    <input type="hidden" name="streetRivoliCode" value="${actor.address.streetRivoliCode}" />
    <input type="hidden" name="cityInseeCode" value="${actor.address.cityInseeCode}" />
  </dd>
  <g:render template="edit/submit" model="['object': actor]" />
</form>
