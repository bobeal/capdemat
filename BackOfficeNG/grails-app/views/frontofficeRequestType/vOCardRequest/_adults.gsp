<div class="collection">
  <input type="hidden" name="individuals" />
  <input type="hidden" name="objectToBind" value="individuals" />
  <button type="submit" value="${message(code:'action.add')}" name="submit-collectionAdd-adults-adults">
    <a>${message(code:'homeFolder.action.addNewAdult')}</a>
  </button>
  <g:each var="listItem" in="${individuals?.adults}" status="listIndex">
    <fieldset class="individual add">
    <h4>
      <g:if test="${listItem.lastName != null}">
        ${listItem?.firstName} ${listItem?.lastName}
      </g:if>
      <g:else>
        ${message(code:'homeFolder.message.newAdult')}
      </g:else>
      <button type="submit" name="submit-collectionDelete-adults-adults[${listIndex}]">
        (<a>${message(code:'action.remove')}</a>)
      </button>
    </h4>
    <div class="yui-g">
      <div class="yui-u first">
        <label for="_individuals.adults.${listIndex}.title" class="required"><g:message code="homeFolder.adult.property.title" /></label>
        <select id="_individuals.adults.${listIndex}.title" name="_individuals.adults[${listIndex}].title" class="required validate-not-first" title="<g:message code="homeFolder.adult.property.title.validationError" />">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${['Mister','Madam','Miss','Agency']}">
            <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == listItem?.title?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.title" /></option>
          </g:each>
        </select>

        <label for="_individuals.adults.${listIndex}.lastName" class="required"><g:message code="homeFolder.individual.property.lastName" /></label>
        <input type="text" id="_individuals.adults.${listIndex}.lastName" name="_individuals.adults[${listIndex}].lastName" value="${listItem?.lastName}"
          class="required validate-lastName" title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />

        <label for="_individuals.adults.${listIndex}.firstName" class="required"><g:message code="homeFolder.individual.property.firstName" /></label>
        <input type="text" id="_individuals.adults.${listIndex}.firstName" name="_individuals.adults[${listIndex}].firstName" value="${listItem?.firstName}"
          class="required validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />
        
        <label for="_individuals.adults.${listIndex}.familyStatus" class="required"><g:message code="homeFolder.adult.property.familyStatus" /></label>
        <select id="_individuals.adults.${listIndex}.familyStatus" name="_individuals.adults[${listIndex}].familyStatus" class="required validate-not-first" title="<g:message code="homeFolder.adult.property.familyStatus.validationError" />">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','Pacs','Other']}">
            <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == listItem?.familyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></option>
          </g:each>
        </select>
        
        <label for="_individuals.adults.${listIndex}.email" class="required"><g:message code="homeFolder.adult.property.email" /> <span><g:message code="homeFolder.adult.property.email.help" /></span></label>
        <input type="text" id="_individuals.adults.${listIndex}.email" name="_individuals.adults[${listIndex}].email" value="${listItem?.email}"
          class="required validate-email" title="<g:message code="homeFolder.adult.property.email.validationError" />" />
        
        <label class="required"><g:message code="homeFolder.adult.label.phones" /> <span>(<g:message code="homeFolder.adult.label.phones.help" />)</span></label>
        <div id="adultPhones" class="address-fieldset">
          <label for="_individuals.adults.${listIndex}.homePhone"><g:message code="homeFolder.adult.property.homePhone" /> <span><g:message code="homeFolder.adult.property.homePhone.help" /></span></label>
          <input type="text" id="_individuals.adults.${listIndex}.homePhone" name="_individuals.adults[${listIndex}].homePhone"
            value="${listItem?.homePhone ? listItem?.homePhone : individuals?.adults ? individuals.adults.get(0).homePhone : ''}"
            class="validate-phone" title="<g:message code="homeFolder.adult.property.homePhone.validationError" />" />

          <label for="_individuals.adults.${listIndex}.mobilePhone"><g:message code="homeFolder.adult.property.mobilePhone" /> <span><g:message code="homeFolder.adult.property.mobilePhone.help" /></span></label>
          <input type="text" id="_individuals.adults.${listIndex}.mobilePhone" name="_individuals.adults[${listIndex}].mobilePhone" value="${listItem?.mobilePhone}"
            class="validate-mobilePhone" title="<g:message code="homeFolder.adult.property.mobilePhone.validationError" />" />

          <label for="_individuals.adults.${listIndex}.officePhone"><g:message code="homeFolder.adult.property.officePhone" /> <span><g:message code="homeFolder.adult.property.officePhone.help" /></span></label>
          <input type="text" id="_individuals.adults.${listIndex}.officePhone" name="_individuals.adults[${listIndex}].officePhone" value="${listItem?.officePhone}"
            class="validate-phone" title="<g:message code="homeFolder.adult.property.officePhone.validationError" />" />
        </div>
      </div>
      
      <div class="yui-u">
         <label class="required"><g:message code="homeFolder.individual.property.address" /></label>
        <div class="address-fieldset required">
          <label for="_individuals.adults.${listIndex}.adress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" class="validate-addressLine38" maxlength="38" id="_individuals.adults.${listIndex}.adress.additionalDeliveryInformation" name="_individuals.adults[${listIndex}].adress.additionalDeliveryInformation"
            value="${listItem?.adress?.additionalDeliveryInformation ? listItem?.adress?.additionalDeliveryInformation : individuals?.adults ? individuals.adults.get(0).adress?.additionalDeliveryInformation : ''}" />
          <label for="_individuals.adults.${listIndex}.adress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" class="validate-addressLine38" maxlength="38" id="_individuals.adults.${listIndex}.adress.additionalGeographicalInformation" name="_individuals.adults[${listIndex}].adress.additionalGeographicalInformation"
            value="${listItem?.adress?.additionalGeographicalInformation ? listItem?.adress?.additionalGeographicalInformation : individuals?.adults ? individuals.adults.get(0).adress?.additionalGeographicalInformation : ''}" />
          <label for="_individuals.adults.${listIndex}.adress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
          <label for="_individuals.adults.${listIndex}.adress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
          <input type="text" class="line1 validate-streetNumber" size="5" maxlength="5" id="_individuals.adults.${listIndex}.adress.streetNumber" name="_individuals.adults[${listIndex}].adress.streetNumber"
            value="${listItem?.adress?.streetNumber ? listItem?.adress?.streetNumber : individuals?.adults ? individuals.adults.get(0).adress?.streetNumber : ''}" />
          <input type="text" class="line2 required validate-streetName" maxlength="32" id="_individuals.adults.${listIndex}.adress.streetName" name="_individuals.adults[${listIndex}].adress.streetName" title="<g:message code="address.property.streetName.validationError" />"
            value="${listItem?.adress?.streetName ? listItem?.adress?.streetName : individuals?.adults ? individuals.adults.get(0).adress?.streetName : ''}" />
          <label for="_individuals.adults.${listIndex}.adress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" class="validate-addressLine38" maxlength="38" id="_individuals.adults.${listIndex}.adress.placeNameOrService" name="_individuals.adults[${listIndex}].adress.placeNameOrService"
            value="${listItem?.adress?.placeNameOrService ? listItem?.adress?.placeNameOrService : individuals?.adults ? individuals.adults.get(0).adress?.placeNameOrService : ''}" />
          <label for="_individuals.adults.${listIndex}.adress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
          <label for="_individuals.adults.${listIndex}.adress.city" class="required"><g:message code="address.property.city" /> *</label><br />
          <input type="text" class="line1 required validate-postalCode" size="5" maxlength="5" id="_individuals.adults.${listIndex}.adress.postalCode" name="_individuals.adults[${listIndex}].adress.postalCode" title="<g:message code="address.property.postalCode.validationError" />"
            value="${listItem?.adress?.postalCode ? listItem?.adress?.postalCode : individuals?.adults ? individuals.adults.get(0).adress?.postalCode : ''}" />
          <input type="text" class="line2 required validate-city" maxlength="32" id="_individuals.adults.${listIndex}.adress.city" name="_individuals.adults[${listIndex}].adress.city" title="<g:message code="address.property.city.validationError" />"
            value="${listItem?.adress?.city ? listItem?.adress?.city : individuals?.adults ? individuals.adults.get(0).adress?.city : ''}" />
          <label for="_individuals.adults.${listIndex}.adress.countryName"><g:message code="address.property.countryName" /></label>
          <input type="text" class="validate-addressLine38" maxlength="38" id="_individuals.adults.${listIndex}.adress.countryName" name="_individuals.adults[${listIndex}].adress.countryName"
            value="${listItem?.adress?.countryName ? listItem?.adress?.countryName : individuals?.adults ? individuals.adults.get(0).adress?.countryName : ''}" />
        </div>
      </div>
    </div>
    </fieldset>
  </g:each>
  <div class="error" id="stepForm-adults-error"> </div>
</div>

