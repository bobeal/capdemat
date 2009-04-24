  <input type="hidden" name="requester" />
  <input type="hidden" name="objectToBind" value="requester" />
  <label class="required"><g:message code="homeFolder.adult.property.title" /></label>
  <select name="_requester.title" class="required" title="<g:message code="homeFolder.adult.property.title.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''}>
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each in="${['Mister','Madam','Miss','Agency']}">
      <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == requester?.title?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="homeFolder.adult.title" /></option>
    </g:each>
  </select>

  <label class="required"><g:message code="homeFolder.individual.property.lastName" /> *</label>
  <input type="text" name="_requester.lastName" value="${requester?.lastName}"
    class="required validate-lastName" title="<g:message code="homeFolder.individual.property.lastName.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''} />

  <label class="required"><g:message code="homeFolder.individual.property.firstName" /> *</label>
  <input type="text" name="_requester.firstName" value="${requester?.firstName}"
    class="required validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''} />

  <label class="required"><g:message code="homeFolder.individual.property.address" /> *</label>
  <div class="address-fieldset required">
    <label><g:message code="address.property.additionalDeliveryInformation" /></label>
    <input type="text" value="${requester?.adress?.additionalDeliveryInformation}" maxlength="38" name="_requester.adress.additionalDeliveryInformation" ${hasHomeFolder? 'disabled="disabled"' : ''}/>
    <label><g:message code="address.property.additionalGeographicalInformation" /></label>
    <input type="text" value="${requester?.adress?.additionalGeographicalInformation}" maxlength="38" name="_requester.adress.additionalGeographicalInformation" ${hasHomeFolder? 'disabled="disabled"' : ''}/>
    <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
    <input type="text" class="line1" value="${requester?.adress?.streetNumber}" maxlength="5" name="_requester.adress.streetNumber" ${hasHomeFolder? 'disabled="disabled"' : ''}/>
    <input type="text" class="line2 required" value="${requester?.adress?.streetName}" maxlength="32" name="_requester.adress.streetName" title="<g:message code="address.property.streetName.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''}/>
    <label><g:message code="address.property.placeNameOrService" /></label>
    <input type="text" value="${requester?.adress?.placeNameOrService}" maxlength="38" name="_requester.adress.placeNameOrService" ${hasHomeFolder? 'disabled="disabled"' : ''}/>
    <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
    <input type="text" class="line1 required validate-postalcode" value="${requester?.adress?.postalCode}" maxlength="5" name="_requester.adress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''}/>
    <input type="text" class="line2 required validate-city" value="${requester?.adress?.city}" maxlength="32" name="_requester.adress.city" title="<g:message code="address.property.city.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''}/>
    <label><g:message code="address.property.countryName" /></label>
    <input type="text" value="${requester?.adress?.countryName}" maxlength="38" name="_requester.adress.countryName" ${hasHomeFolder? 'disabled="disabled"' : ''}/>
  </div>

  <label class="required"><g:message code="homeFolder.adult.property.email" /> * <span><g:message code="homeFolder.adult.property.email.help" /></span></label>
  <input type="text" name="_requester.email" value="${requester?.email}"
    class="required validate-email" title="<g:message code="homeFolder.adult.property.email.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''}/>

  <label class="required"><g:message code="homeFolder.adult.property.homePhone" /> * <span><g:message code="homeFolder.adult.property.homePhone.help" /></span></label>
  <input type="text" name="_requester.homePhone" value="${requester?.homePhone}"
    class="required validate-phone" title="<g:message code="homeFolder.adult.property.homePhone.validationError" />" ${hasHomeFolder? 'disabled="disabled"' : ''}/>
