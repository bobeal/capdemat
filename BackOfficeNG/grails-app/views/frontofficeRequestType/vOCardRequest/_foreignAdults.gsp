<div class="collection">
  <input type="hidden" name="individuals" />
  <input type="hidden" name="objectToBind" value="individuals" />
  <button type="submit" value="${message(code:'action.add')}" name="submit-collectionAdd-foreignAdults-foreignAdults">
    <a>${message(code:'homeFolder.action.addNewForeignAdult')}</a>
  </button>
  <g:each var="listItem" in="${individuals?.foreignAdults}" status="listIndex">
    <fieldset class="individual add">
    <h4>
      <g:if test="${listItem.lastName != null}">
        ${listItem?.firstName} ${listItem?.lastName}
      </g:if>
      <g:else>
        ${message(code:'homeFolder.message.newForeignAdult')}
      </g:else>
      <button type="submit" name="submit-collectionDelete-foreignAdults-foreignAdults[${listIndex}]">
        (<a>${message(code:'action.remove')}</a>)
      </button>
    </h4>
    <div class="yui-g">
      <div class="yui-u first">
        <label for="_individuals.foreignAdults.${listIndex}.title" class="required"><g:message code="homeFolder.adult.property.title" /></label>
        <select id="_individuals.foreignAdults.${listIndex}.title" name="_individuals.foreignAdults[${listIndex}].title" class="required validate-not-first" title="<g:message code="homeFolder.adult.property.title.validationError" />">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${['Mister','Madam','Miss','Agency']}">
            <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == listItem?.title?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.title" /></option>
          </g:each>
        </select>

        <label for="_individuals.foreignAdults.${listIndex}.lastName" class="required"><g:message code="homeFolder.individual.property.lastName" /></label>
        <input type="text" id="_individuals.foreignAdults.${listIndex}.lastName" name="_individuals.foreignAdults[${listIndex}].lastName" value="${listItem?.lastName}"
          class="required validate-lastName" title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />

        <label for="_individuals.foreignAdults.${listIndex}.firstName" class="required"><g:message code="homeFolder.individual.property.firstName" /></label>
        <input type="text" id="_individuals.foreignAdults.${listIndex}.firstName" name="_individuals.foreignAdults[${listIndex}].firstName" value="${listItem?.firstName}"
          class="required validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />
        
        <label for="_individuals.foreignAdults.${listIndex}.familyStatus" class="required"><g:message code="homeFolder.adult.property.familyStatus" /></label>
        <select id="_individuals.foreignAdults.${listIndex}.familyStatus" name="_individuals.foreignAdults[${listIndex}].familyStatus" class="required validate-not-first" title="<g:message code="homeFolder.adult.property.familyStatus.validationError" />">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','Pacs','Other']}">
            <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == listItem?.familyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></option>
          </g:each>
        </select>
        
        <label for="_individuals.foreignAdults.${listIndex}.email" class="required"><g:message code="homeFolder.adult.property.email" /> <span><g:message code="homeFolder.adult.property.email.help" /></span></label>
        <input type="text" id="_individuals.foreignAdults.${listIndex}.email" name="_individuals.foreignAdults[${listIndex}].email" value="${listItem?.email}"
          class="required validate-email" title="<g:message code="homeFolder.adult.property.email.validationError" />" />
        
        <label class="required"><g:message code="homeFolder.adult.label.phones" /> <span>(<g:message code="homeFolder.adult.label.phones.help" />)</span></label>
        <div class="address-fieldset">
          <label for="_individuals.foreignAdults.${listIndex}.homePhone"><g:message code="homeFolder.adult.property.homePhone" /> <span><g:message code="homeFolder.adult.property.homePhone.help" /></span></label>
          <input type="text" id="_individuals.foreignAdults.${listIndex}.homePhone" name="_individuals.foreignAdults[${listIndex}].homePhone"
            value="${listItem?.homePhone ? listItem?.homePhone : individuals?.foreignAdults ? individuals.foreignAdults.get(0).homePhone : ''}"
            class="validate-phone" title="<g:message code="homeFolder.adult.property.homePhone.validationError" />" />

          <label for="_individuals.foreignAdults.${listIndex}.mobilePhone"><g:message code="homeFolder.adult.property.mobilePhone" /> <span><g:message code="homeFolder.adult.property.mobilePhone.help" /></span></label>
          <input type="text" id="_individuals.foreignAdults.${listIndex}.mobilePhone" name="_individuals.foreignAdults[${listIndex}].mobilePhone" value="${listItem?.mobilePhone}"
            class="validate-mobilePhone" title="<g:message code="homeFolder.adult.property.mobilePhone.validationError" />" />

          <label for="_individuals.foreignAdults.${listIndex}.officePhone"><g:message code="homeFolder.adult.property.officePhone" /> <span><g:message code="homeFolder.adult.property.officePhone.help" /></span></label>
          <input type="text" id="_individuals.foreignAdults.${listIndex}.officePhone" name="_individuals.foreignAdults[${listIndex}].officePhone" value="${listItem?.officePhone}"
            class="validate-phone" title="<g:message code="homeFolder.adult.property.officePhone.validationError" />" />
        </div>
      </div>
      
      <div class="yui-u">
         <label class="required"><g:message code="homeFolder.individual.property.address" /></label>
        <div class="address-fieldset required">
          <label for="_individuals.foreignAdults.${listIndex}.adress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" maxlength="38" id="_individuals.foreignAdults.${listIndex}.adress.additionalDeliveryInformation" name="_individuals.foreignAdults[${listIndex}].adress.additionalDeliveryInformation"
            value="${listItem?.adress?.additionalDeliveryInformation ? listItem?.adress?.additionalDeliveryInformation : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.additionalDeliveryInformation : ''}" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" maxlength="38" id="_individuals.foreignAdults.${listIndex}.adress.additionalGeographicalInformation" name="_individuals.foreignAdults[${listIndex}].adress.additionalGeographicalInformation"
            value="${listItem?.adress?.additionalGeographicalInformation ? listItem?.adress?.additionalGeographicalInformation : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.additionalGeographicalInformation : ''}" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
          <label for="_individuals.foreignAdults.${listIndex}.adress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
          <input type="text" class="line1" size="5" maxlength="5" id="_individuals.foreignAdults.${listIndex}.adress.streetNumber" name="_individuals.foreignAdults[${listIndex}].adress.streetNumber"
            value="${listItem?.adress?.streetNumber ? listItem?.adress?.streetNumber : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.streetNumber : ''}" />
          <input type="text" class="line2 required" maxlength="32" id="_individuals.foreignAdults.${listIndex}.adress.streetName" name="_individuals.foreignAdults[${listIndex}].adress.streetName" title="<g:message code="address.property.streetName.validationError" />"
            value="${listItem?.adress?.streetName ? listItem?.adress?.streetName : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.streetName : ''}" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" maxlength="38" id="_individuals.foreignAdults.${listIndex}.adress.placeNameOrService" name="_individuals.foreignAdults[${listIndex}].adress.placeNameOrService"
            value="${listItem?.adress?.placeNameOrService ? listItem?.adress?.placeNameOrService : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.placeNameOrService : ''}" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
          <label for="_individuals.foreignAdults.${listIndex}.adress.city" class="required"><g:message code="address.property.city" /> *</label><br />
          <input type="text" class="line1 required" size="5" maxlength="5" id="_individuals.foreignAdults.${listIndex}.adress.postalCode" name="_individuals.foreignAdults[${listIndex}].adress.postalCode" title="<g:message code="address.property.postalCode.validationError" />"
            value="${listItem?.adress?.postalCode ? listItem?.adress?.postalCode : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.postalCode : ''}" />
          <input type="text" class="line2 required" maxlength="32" id="_individuals.foreignAdults.${listIndex}.adress.city" name="_individuals.foreignAdults[${listIndex}].adress.city" title="<g:message code="address.property.city.validationError" />"
            value="${listItem?.adress?.city ? listItem?.adress?.city : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.city : ''}" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.countryName"><g:message code="address.property.countryName" /></label>
          <input type="text" maxlength="38" id="_individuals.foreignAdults.${listIndex}.adress.countryName" name="_individuals.foreignAdults[${listIndex}].adress.countryName"
            value="${listItem?.adress?.countryName ? listItem?.adress?.countryName : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.countryName : ''}" />
        </div>
      </div>
    </div>
    </fieldset>
  </g:each>
  <div class="error" id="stepForm-foreignAdults-error"> </div>
</div>

