

<div class="account required validation-scope">
  <g:set var="listIndex" value="${editList?.name == 'foreignAdults' ? editList?.index : ( individuals?.foreignAdults ? individuals?.foreignAdults.size() : 0 ) }" />

  <fieldset class="individual add">
    <div class="yui-g">
      <div class="yui-u first">
        <label for="_individuals.foreignAdults.${listIndex}.title" class="required"><g:message code="homeFolder.adult.property.title" /></label>
        <select id="_individuals.foreignAdults.${listIndex}.title" name="_individuals.foreignAdults[${listIndex}].title" class="required validate-not-first ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('title') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.title.validationError" />">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${fr.cg95.cvq.business.users.TitleType.allTitleTypes}">
            <option value="fr.cg95.cvq.business.users.TitleType_${it.toString()}" ${it == editList?.foreignAdults?.title ? 'selected="selected"': ''}><g:capdematEnumToText var="${it.toString()}" i18nKeyPrefix="homeFolder.adult.title" /></option>
          </g:each>
        </select>

        <label for="_individuals.foreignAdults.${listIndex}.lastName" class="required"><g:message code="homeFolder.individual.property.lastName" /></label>
        <input type="text" id="_individuals.foreignAdults.${listIndex}.lastName" name="_individuals.foreignAdults[${listIndex}].lastName" value="${editList?.foreignAdults?.lastName}"
          class="required validate-lastName ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('lastName') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />

        <label for="_individuals.foreignAdults.${listIndex}.firstName" class="required"><g:message code="homeFolder.individual.property.firstName" /></label>
        <input type="text" id="_individuals.foreignAdults.${listIndex}.firstName" name="_individuals.foreignAdults[${listIndex}].firstName" value="${editList?.foreignAdults?.firstName}"
          class="required validate-firstName ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('firstName') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />
        
        <label for="_individuals.foreignAdults.${listIndex}.familyStatus" class="required"><g:message code="homeFolder.adult.property.familyStatus" /></label>
        <select id="_individuals.foreignAdults.${listIndex}.familyStatus" name="_individuals.foreignAdults[${listIndex}].familyStatus" class="required validate-not-first ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('familyStatus') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.familyStatus.validationError" />">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${fr.cg95.cvq.business.users.FamilyStatusType.allFamilyStatusTypes}">
            <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it.toString()}" ${it == editList?.foreignAdults?.familyStatus ? 'selected="selected"': ''}><g:capdematEnumToText var="${it.toString()}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></option>
          </g:each>
        </select>
        
        <label for="_individuals.foreignAdults.${listIndex}.email" class="required"><g:message code="homeFolder.adult.property.email" /> <span><g:message code="homeFolder.adult.property.email.help" /></span></label>
        <input type="text" id="_individuals.foreignAdults.${listIndex}.email" name="_individuals.foreignAdults[${listIndex}].email" value="${editList?.foreignAdults?.email}"
          class="required validate-email ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('email') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.email.validationError" />" />
        
        <label class="required"><g:message code="homeFolder.adult.label.phones" /> <span>(<g:message code="homeFolder.adult.label.phones.help" />)</span></label>
        <div id="foreignAdultPhones" class="address-fieldset ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('adultPhones') ? 'validation-failed' : ''}">
          <label for="_individuals.foreignAdults.${listIndex}.homePhone"><g:message code="homeFolder.adult.property.homePhone" /> <span><g:message code="homeFolder.adult.property.homePhone.help" /></label>
          <input type="text" id="_individuals.foreignAdults.${listIndex}.homePhone" name="_individuals.foreignAdults[${listIndex}].homePhone" value="${editList?.foreignAdults?.homePhone}"
            class="validate-phone ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('homePhone') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.homePhone.validationError" />" />

          <label for="_individuals.foreignAdults.${listIndex}.mobilePhone"><g:message code="homeFolder.adult.property.mobilePhone" /> <span><g:message code="homeFolder.adult.property.mobilePhone.help" /></label>
          <input type="text" id="_individuals.foreignAdults.${listIndex}.mobilePhone" name="_individuals.foreignAdults[${listIndex}].mobilePhone" value="${editList?.foreignAdults?.mobilePhone}"
            class="validate-mobilePhone ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('mobilePhone') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.mobilePhone.validationError" />" />

          <label for="_individuals.foreignAdults.${listIndex}.officePhone"><g:message code="homeFolder.adult.property.officePhone" /> <span><g:message code="homeFolder.adult.property.officePhone.help" /></label>
          <input type="text" id="_individuals.foreignAdults.${listIndex}.officePhone" name="_individuals.foreignAdults[${listIndex}].officePhone" value="${editList?.foreignAdults?.officePhone}"
            class="validate-phone ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('officePhone') ? 'validation-failed' : ''}" title="<g:message code="homeFolder.adult.property.officePhone.validationError" />" />
        </div>
      </div>


      <div class="yui-u">
        <label class="required"><g:message code="homeFolder.individual.property.address" /></label>
        <div id="_individuals_foreignAdults_${listIndex}_adress" class="address-fieldset required ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('adress') ? 'validation-failed' : ''}">
          <label for="_individuals.foreignAdults.${listIndex}.adress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('adress.additionalDeliveryInformation') ? 'validation-failed' : ''}" maxlength="38" id="_individuals.foreignAdults.${listIndex}.adress.additionalDeliveryInformation" name="_individuals.foreignAdults[${listIndex}].adress.additionalDeliveryInformation"
            value="${editList?.foreignAdults ? editList?.foreignAdults.adress?.additionalDeliveryInformation : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.additionalDeliveryInformation : ''}" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('adress.additionalGeographicalInformation') ? 'validation-failed' : ''}" maxlength="38" id="_individuals.foreignAdults.${listIndex}.adress.additionalGeographicalInformation" name="_individuals.foreignAdults[${listIndex}].adress.additionalGeographicalInformation"
            value="${editList?.foreignAdults ? editList?.foreignAdults.adress?.additionalGeographicalInformation : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.additionalGeographicalInformation : ''}" />
          <label for="_individuals_foreignAdults_${listIndex}_adress_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
          <label for="_individuals_foreignAdults_${listIndex}_adress_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
          <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('adress.streetNumber') ? 'validation-failed' : ''}" size="5" maxlength="5" id="_individuals_foreignAdults_${listIndex}_adress_streetNumber" name="_individuals.foreignAdults[${listIndex}].adress.streetNumber"
            value="${editList?.foreignAdults ? editList?.foreignAdults.adress?.streetNumber : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.streetNumber : ''}" />
          <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('adress.streetName') ? 'validation-failed' : ''}" maxlength="32" id="_individuals_foreignAdults_${listIndex}_adress_streetName" name="_individuals.foreignAdults[${listIndex}].adress.streetName" title="<g:message code="address.property.streetName.validationError" />"
            value="${editList?.foreignAdults ? editList?.foreignAdults.adress?.streetName : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.streetName : ''}" />
          <input type="hidden" id="_individuals_foreignAdults_${listIndex}_adress_streetMatriculation" name="_individuals.foreignAdults[${listIndex}].adress.streetMatriculation"
            value="${editList?.foreignAdults ? editList?.foreignAdults.adress?.streetMatriculation : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.streetMatriculation : ''}" />
          <input type="hidden" id="_individuals_foreignAdults_${listIndex}_adress_streetRivoliCode" name="_individuals.foreignAdults[${listIndex}].adress.streetRivoliCode"
              value="${editList?.foreignAdults ? editList?.foreignAdults.adress?.streetRivoliCode : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.streetRivoliCode : ''}" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('adress.placeNameOrService') ? 'validation-failed' : ''}" maxlength="38" id="_individuals.foreignAdults.${listIndex}.adress.placeNameOrService" name="_individuals.foreignAdults[${listIndex}].adress.placeNameOrService"
            value="${editList?.foreignAdults ? editList?.foreignAdults.adress?.placeNameOrService : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.placeNameOrService : ''}" />
          <label for="_individuals_foreignAdults_${listIndex}_adress_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
          <label for="_individuals_foreignAdults_${listIndex}_adress_city" class="required"><g:message code="address.property.city" /> *</label><br />
          <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('adress.postalCode') ? 'validation-failed' : ''}" size="5" maxlength="5" id="_individuals_foreignAdults_${listIndex}_adress_postalCode" name="_individuals.foreignAdults[${listIndex}].adress.postalCode" title="<g:message code="address.property.postalCode.validationError" />"
            value="${editList?.foreignAdults ? editList?.foreignAdults.adress?.postalCode : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.postalCode : ''}" />
          <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('adress.city') ? 'validation-failed' : ''}" maxlength="32" id="_individuals_foreignAdults_${listIndex}_adress_city" name="_individuals.foreignAdults[${listIndex}].adress.city" title="<g:message code="address.property.city.validationError" />"
            value="${editList?.foreignAdults ? editList?.foreignAdults.adress?.city : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.city : ''}" />
          <input type="hidden" id="_individuals_foreignAdults_${listIndex}_adress_cityInseeCode" name="_individuals.foreignAdults[${listIndex}].adress.cityInseeCode"
            value="${editList?.foreignAdults ? editList?.foreignAdults.adress?.cityInseeCode : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.cityInseeCode : ''}" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.countryName"><g:message code="address.property.countryName" /></label>
          <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['foreignAdults']?.invalidFields.contains('adress.countryName') ? 'validation-failed' : ''}" maxlength="38" id="_individuals_foreignAdults_${listIndex}_adress_countryName" name="_individuals.foreignAdults[${listIndex}].adress.countryName"
            value="${editList?.foreignAdults ? editList?.foreignAdults.adress?.countryName : individuals?.foreignAdults ? individuals.foreignAdults.get(0).adress?.countryName : ''}" />
        </div>
      </div>
    </div>
    <input type="hidden" name="individuals" />
    <input type="hidden" name="objectToBind" value="individuals" />
    <div class="error" id="stepForm-foreignAdults-error"> </div>
    <g:if test="${editList?.name == 'foreignAdults'}">
      <input type="submit" id="submit-collectionModify-foreignAdults-foreignAdults" name="submit-collectionModify-foreignAdults-foreignAdults[${listIndex}]" value="${message(code:'action.save')}" class="modify" />
      <input type="submit" id="submit-collectionCancel-foreignAdults-foreignAdults" name="submit-collectionCancel-foreignAdults-foreignAdults[${listIndex}]" value="${message(code:'action.cancel')}" class="cancel" />
    </g:if>
    <g:else>
      <input type="submit" id="submit-collectionAdd-foreignAdults-foreignAdults" name="submit-collectionAdd-foreignAdults-foreignAdults[${listIndex}]" value="${message(code:'vcr.action.addForeignAdult')}" />
    </g:else>
  </fieldset>
    <g:each var="it" in="${individuals?.foreignAdults}" status="index">
    <fieldset class="individual edit summary-box ${stepStates != null && stepStates['children']?.invalidFields.contains('foreignAdults[' + index + ']') ? 'validation-failed' : ''}">
      <h4>
        <g:capdematEnumToField var="${it.title}" i18nKeyPrefix="homeFolder.adult.title" /> ${it.firstName} ${it.lastName}
        <input type="hidden" name="objectToManage[${index}]" value="individuals" />
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-foreignAdults-foreignAdults[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-foreignAdults-foreignAdults[${index}]" />
      </h4> 
      <dl>
        <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt>
        <dd> <g:capdematEnumToField var="${it.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></dd>

        <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
        <dd>
          <div>
            <p class="additionalDeliveryInformation">${it.adress?.additionalDeliveryInformation}</p>
            <p class="additionalGeographicalInformation">${it.adress?.additionalGeographicalInformation}</p>
            <span class="streetNumber">${it.adress?.streetNumber}</span>
            <span class="streetName">${it.adress?.streetName}</span>
            <p class="placeNameOrService">${it.adress?.placeNameOrService}</p>
            <span class="postalCode">${it.adress?.postalCode}</span>
            <span class="city">${it.adress?.city}</span>
            <p class="countryName">${it.adress?.countryName}</p>
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

