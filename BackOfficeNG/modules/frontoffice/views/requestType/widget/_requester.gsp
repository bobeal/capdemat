  <input type="hidden" name="requester" />
  <input type="hidden" name="objectToBind" value="requester" />
  <label for="_requester.title" class="required"><g:message code="homeFolder.adult.property.title" /></label>
  <select id="_requester.title" name="_requester.title" class="required" title="<g:message code="homeFolder.adult.property.title.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''}>
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each in="${['Mister','Madam','Miss','Agency']}">
      <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == requester?.title?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.title" /></option>
    </g:each>
  </select>

  <label for="_requester.lastName" class="required"><g:message code="homeFolder.individual.property.lastName" /> *</label>
  <input type="text" id="_requester.lastName" name="_requester.lastName" value="${requester?.lastName}"
    class="required validate-lastName" title="<g:message code="homeFolder.individual.property.lastName.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''} />

  <label for="_requester.firstName" class="required"><g:message code="homeFolder.individual.property.firstName" /> *</label>
  <input type="text" id="_requester.firstName" name="_requester.firstName" value="${requester?.firstName}"
    class="required validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''} />

  <label class="required"><g:message code="homeFolder.individual.property.address" /> *</label>
  
  <div class="address-fieldset required">
    <label for="_requester.adress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
    <input type="text" class="validate-addressLine38" value="${requester?.adress?.additionalDeliveryInformation}" maxlength="38" id="_requester.adress.additionalDeliveryInformation" name="_requester.adress.additionalDeliveryInformation" />  
    <label for="_requester.adress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
    <input type="text" class="validate-addressLine38" value="${requester?.adress?.additionalGeographicalInformation}" maxlength="38" id="_requester.adress.additionalGeographicalInformation" name="_requester.adress.additionalGeographicalInformation" />
    <label for="_requester.adress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
    <label for="_requester.adress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
    <input type="text" class="line1 validate-streetNumber" value="${requester?.adress?.streetNumber}" size="5" maxlength="5" id="_requester.adress.streetNumber" name="_requester.adress.streetNumber" />
    <input type="text" class="line2 required validate-streetName" value="${requester?.adress?.streetName}" maxlength="32" id="_requester.adress.streetName" name="_requester.adress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
    <label for="_requester.adress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
    <input type="text" class="validate-addressLine38" value="${requester?.adress?.placeNameOrService}" maxlength="38" id="_requester.adress.placeNameOrService" name="_requester.adress.placeNameOrService" />
    <label for="_requester.adress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
    <label for="_requester.adress.city" class="required"><g:message code="address.property.city" /> *</label><br />
    <input type="text" class="line1 required validate-postalCode" value="${requester?.adress?.postalCode}" size="5" maxlength="5" id="_requester.adress.postalCode" name="_requester.adress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
    <input type="text" class="line2 required validate-city" value="${requester?.adress?.city}" maxlength="32" id="_requester.adress.city" name="_requester.adress.city" title="<g:message code="address.property.city.validationError" />" />
    <label for="_requester.adress.countryName"><g:message code="address.property.countryName" /></label>
    <input type="text" class="validate-addressLine38" value="${requester?.adress?.countryName}" maxlength="38" id="_requester.adress.countryName" name="_requester.adress.countryName" />
  </div>

  <label for="_requester.email" class="required"><g:message code="homeFolder.adult.property.email" /> * <span><g:message code="homeFolder.adult.property.email.help" /></span></label>
  <input type="text" id="_requester.email" name="_requester.email" value="${requester?.email}"
    class="required validate-email" title="<g:message code="homeFolder.adult.property.email.validationError" />" ${(hasHomeFolder && requester?.email) ? 'disabled="disabled"' : ''}/>

  <label for="_requester.homePhone" class="required"><g:message code="homeFolder.adult.property.homePhone" /> * <span><g:message code="homeFolder.adult.property.homePhone.help" /></span></label>
  <input type="text" id="_requester.homePhone" name="_requester.homePhone" value="${requester?.homePhone}"
    class="required validate-phone" title="<g:message code="homeFolder.adult.property.homePhone.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''}/>
