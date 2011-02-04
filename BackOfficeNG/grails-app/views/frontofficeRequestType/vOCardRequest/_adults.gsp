
<div class="account required validation-scope">
  <g:set var="listIndex" value="${editList?.name == 'adults' ? editList?.index : ( individuals?.adults ? individuals?.adults.size() : 0 ) }" />

  <fieldset class="individual add">
    <div class="yui-g">
      <div class="yui-u first">
        <label for="_individuals.adults.${listIndex}.title" class="required"><g:message code="homeFolder.adult.property.title" /></label>
        <select id="_individuals.adults.${listIndex}.title" name="_individuals.adults[${listIndex}].title" class="required validate-not-first ${stepStates != null && stepStates['adults']?.invalidFields.contains('title') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.title.validationError" />">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${['Mister','Madam','Miss','Agency']}">
            <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == editList?.adults?.title?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.title" /></option>
          </g:each>
        </select>

        <label for="_individuals.adults.${listIndex}.lastName" class="required"><g:message code="homeFolder.individual.property.lastName" /></label>
        <input type="text" id="_individuals.adults.${listIndex}.lastName" name="_individuals.adults[${listIndex}].lastName" value="${editList?.adults?.lastName}"
          class="required validate-lastName ${stepStates != null && stepStates['adults']?.invalidFields.contains('lastName') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />

        <label for="_individuals.adults.${listIndex}.firstName" class="required"><g:message code="homeFolder.individual.property.firstName" /></label>
        <input type="text" id="_individuals.adults.${listIndex}.firstName" name="_individuals.adults[${listIndex}].firstName" value="${editList?.adults?.firstName}"
          class="required validate-firstName ${stepStates != null && stepStates['adults']?.invalidFields.contains('firstName') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />
        
        <label for="_individuals.adults.${listIndex}.familyStatus" class="required"><g:message code="homeFolder.adult.property.familyStatus" /></label>
        <select id="_individuals.adults.${listIndex}.familyStatus" name="_individuals.adults[${listIndex}].familyStatus" class="required validate-not-first ${stepStates != null && stepStates['adults']?.invalidFields.contains('familyStatus') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.familyStatus.validationError" />">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','Pacs','Other']}">
            <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == editList?.adults?.familyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></option>
          </g:each>
        </select>
        
        <label for="_individuals.adults.${listIndex}.email" class="required"><g:message code="homeFolder.adult.property.email" /> <span><g:message code="homeFolder.adult.property.email.help" /></span></label>
        <input type="text" id="_individuals.adults.${listIndex}.email" name="_individuals.adults[${listIndex}].email" value="${editList?.adults?.email}"
          class="required validate-email ${stepStates != null && stepStates['adults']?.invalidFields.contains('email') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.email.validationError" />" />
        
        <label class="required"><g:message code="homeFolder.adult.label.phones" /> <span>(<g:message code="homeFolder.adult.label.phones.help" />)</span></label>
        <div id="adultPhones" class="address-fieldset ${stepStates != null && stepStates['adults']?.invalidFields.contains('adultPhones') ? 'validation-failed' : ''}">
          <label for="_individuals.adults.${listIndex}.homePhone"><g:message code="homeFolder.adult.property.homePhone" /> <span><g:message code="homeFolder.adult.property.homePhone.help" /></span></label>
          <input type="text" id="_individuals.adults.${listIndex}.homePhone" name="_individuals.adults[${listIndex}].homePhone"
            value="${editList?.adults ? editList.adults.homePhone : individuals?.adults ? individuals.adults.get(0).homePhone : ''}"
            class="validate-phone ${stepStates != null && stepStates['adults']?.invalidFields.contains('homePhone') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.homePhone.validationError" />" />

          <label for="_individuals.adults.${listIndex}.mobilePhone"><g:message code="homeFolder.adult.property.mobilePhone" /> <span><g:message code="homeFolder.adult.property.mobilePhone.help" /></span></label>
          <input type="text" id="_individuals.adults.${listIndex}.mobilePhone" name="_individuals.adults[${listIndex}].mobilePhone" value="${editList?.adults?.mobilePhone}"
            class="validate-mobilePhone ${stepStates != null && stepStates['adults']?.invalidFields.contains('mobilePhone') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.mobilePhone.validationError" />" />

          <label for="_individuals.adults.${listIndex}.officePhone"><g:message code="homeFolder.adult.property.officePhone" /> <span><g:message code="homeFolder.adult.property.officePhone.help" /></span></label>
          <input type="text" id="_individuals.adults.${listIndex}.officePhone" name="_individuals.adults[${listIndex}].officePhone" value="${editList?.adults?.officePhone}"
            class="validate-phone ${stepStates != null && stepStates['adults']?.invalidFields.contains('officePhone') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.officePhone.validationError" />" />
        </div>
      </div>
      
      <div class="yui-u">
        <label class="required"><g:message code="homeFolder.individual.property.address" /></label>
        <div id="_individuals_adults_${listIndex}_address" class="address-fieldset required ${stepStates != null && stepStates['adults']?.invalidFields.contains('address') ? 'validation-failed' : ''}">
          <label for="_individuals.adults.${listIndex}.address.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['adults']?.invalidFields.contains('address.additionalDeliveryInformation') ? 'validation-failed' : ''}" maxlength="38" id="_individuals.adults.${listIndex}.address.additionalDeliveryInformation" name="_individuals.adults[${listIndex}].address.additionalDeliveryInformation"
            value="${editList?.adults ? editList?.adults.address?.additionalDeliveryInformation : individuals?.adults ? individuals.adults.get(0).address?.additionalDeliveryInformation : ''}" />
          <label for="_individuals.adults.${listIndex}.address.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['adults']?.invalidFields.contains('address.additionalGeographicalInformation') ? 'validation-failed' : ''}" maxlength="38" id="_individuals.adults.${listIndex}.address.additionalGeographicalInformation" name="_individuals.adults[${listIndex}].address.additionalGeographicalInformation"
            value="${editList?.adults ? editList?.adults.address?.additionalGeographicalInformation : individuals?.adults ? individuals.adults.get(0).address?.additionalGeographicalInformation : ''}" />
          <label for="_individuals_adults_${listIndex}_address_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
          <label for="_individuals_adults_${listIndex}_address_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
          <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['adults']?.invalidFields.contains('address.streetNumber') ? 'validation-failed' : ''}" size="5" maxlength="5" id="_individuals_adults_${listIndex}_address_streetNumber" name="_individuals.adults[${listIndex}].address.streetNumber"
            value="${editList?.adults ? editList?.adults.address?.streetNumber : individuals?.adults ? individuals.adults.get(0).address?.streetNumber : ''}" />
          <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['adults']?.invalidFields.contains('address.streetName') ? 'validation-failed' : ''}" maxlength="32" id="_individuals_adults_${listIndex}_address_streetName" name="_individuals.adults[${listIndex}].address.streetName" title="<g:message code="address.property.streetName.validationError" />"
            value="${editList?.adults ? editList?.adults.address?.streetName : individuals?.adults ? individuals.adults.get(0).address?.streetName : ''}" />
          <input type="hidden" id="_individuals_adults_${listIndex}_address_streetMatriculation" name="_individuals.adults[${listIndex}].address.streetMatriculation"
            value="${editList?.adults ? editList?.adults.address?.streetMatriculation : individuals?.adults ? individuals.adults.get(0).address?.streetMatriculation : ''}" />
          <label for="_individuals.adults.${listIndex}.address.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
          <input type="hidden" id="_individuals_adults_${listIndex}_address_streetRivoliCode" name="_individuals.adults[${listIndex}].address.streetRivoliCode"
              value="${editList?.adults ? editList?.adults.address?.streetRivoliCode : individuals?.adults ? individuals.adults.get(0).address?.streetRivoliCode : ''}" />
          <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['adults']?.invalidFields.contains('address.placeNameOrService') ? 'validation-failed' : ''}" maxlength="38" id="_individuals.adults.${listIndex}.address.placeNameOrService" name="_individuals.adults[${listIndex}].address.placeNameOrService"
            value="${editList?.adults ? editList?.adults.address?.placeNameOrService : individuals?.adults ? individuals.adults.get(0).address?.placeNameOrService : ''}" />
          <label for="_individuals_adults_${listIndex}_address_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
          <label for="_individuals_adults_${listIndex}_address_city" class="required"><g:message code="address.property.city" /> *</label><br />
          <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['adults']?.invalidFields.contains('address.postalCode') ? 'validation-failed' : ''}" size="5" maxlength="5" id="_individuals_adults_${listIndex}_address_postalCode" name="_individuals.adults[${listIndex}].address.postalCode" title="<g:message code="address.property.postalCode.validationError" />"
            value="${editList?.adults ? editList?.adults.address?.postalCode : individuals?.adults ? individuals.adults.get(0).address?.postalCode : ''}" />
          <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['adults']?.invalidFields.contains('address.city') ? 'validation-failed' : ''}" maxlength="32" id="_individuals_adults_${listIndex}_address_city" name="_individuals.adults[${listIndex}].address.city" title="<g:message code="address.property.city.validationError" />"
            value="${editList?.adults ? editList?.adults.address?.city : individuals?.adults ? individuals.adults.get(0).address?.city : ''}" />
          <input type="hidden" id="_individuals_adults_${listIndex}_address_cityInseeCode" name="_individuals.adults[${listIndex}].address.cityInseeCode"
            value="${editList?.adults ? editList?.adults.address?.cityInseeCode : individuals?.adults ? individuals.adults.get(0).address?.cityInseeCode : ''}" />
          <label for="_individuals.adults.${listIndex}.address.countryName"><g:message code="address.property.countryName" /></label>
          <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['adults']?.invalidFields.contains('address.countryName') ? 'validation-failed' : ''}" maxlength="38" id="_individuals_adults_${listIndex}_address_countryName" name="_individuals.adults[${listIndex}].address.countryName"
            value="${editList?.adults ? editList?.adults.address?.countryName : individuals?.adults ? individuals.adults.get(0).address?.countryName : ''}" />
        </div>
      </div>
    </div>
    <input type="hidden" name="individuals" />
    <input type="hidden" name="objectToBind" value="individuals" />
    <div class="error" id="stepForm-adults-error"> </div>
    <g:if test="${editList?.name == 'adults'}">
      <input type="submit" id="submit-collectionModify-adults-adults" name="submit-collectionModify-adults-adults[${listIndex}]" value="${message(code:'action.save')}" class="modify" />
      <input type="submit" id="submit-collectionCancel-adults-adults" name="submit-collectionCancel-adults-adults[${listIndex}]" value="${message(code:'action.cancel')}" class="cancel" />
    </g:if>
    <g:else>
      <input type="submit" id="submit-collectionAdd-adults-adults" name="submit-collectionAdd-adults-adults[${listIndex}]" value="${message(code:'vcr.action.addAdult')}" />
    </g:else>
  </fieldset>
    <g:each var="it" in="${individuals?.adults}" status="index">
    <fieldset class="individual edit summary-box ${stepStates != null && stepStates['adults']?.invalidFields.contains('adults[' + index + ']') ? 'validation-failed' : ''}">
      <h4>
        <g:capdematEnumToField var="${it.title}" i18nKeyPrefix="homeFolder.adult.title" /> ${it.firstName} ${it.lastName}
        <input type="hidden" name="objectToManage[${index}]" value="individuals" />
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-adults-adults[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-adults-adults[${index}]" />
      </h4> 
      <dl>
        <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt>
        <dd> <g:capdematEnumToField var="${it.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></dd>

        <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
        <dd>
          <div>
            <p class="additionalDeliveryInformation">${it.address?.additionalDeliveryInformation}</p>
            <p class="additionalGeographicalInformation">${it.address?.additionalGeographicalInformation}</p>
            <span class="streetNumber">${it.address?.streetNumber}</span>
            <span class="streetName">${it.address?.streetName}</span>
            <p class="placeNameOrService">${it.address?.placeNameOrService}</p>
            <span class="postalCode">${it.address?.postalCode}</span>
            <span class="city">${it.address?.city}</span>
            <p class="countryName">${it.address?.countryName}</p>
          </div>
        </dd>

        <dt><g:message code="homeFolder.adult.property.email" /> : </dt>
        <dd>${it.email}</dd>

        <dt><g:message code="homeFolder.adult.property.homePhone" /> : </dt>
        <dd>${it.homePhone}</dd>
        <dt><g:message code="homeFolder.adult.property.mobilePhone" /> : </dt>
        <dd>${it.mobilePhone}</dd>

        <dt><g:message code="homeFolder.adult.property.officePhone" /> : </dt>
        <dd>${it.officePhone}</dd>
      </dl>
    </fieldset>
  </g:each>
</div>

