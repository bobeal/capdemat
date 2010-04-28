

<div class="account required validation-scope">
  <g:set var="listIndex" value="${editList?.name == 'foreignAdults' ? editList?.index : ( individuals?.foreignAdults ? individuals?.foreignAdults.size() : 0 ) }" />

  <fieldset class="individual add">
    <div class="yui-g">
      <div class="yui-u first">
        <label for="_individuals.foreignAdults.${listIndex}.title" class="required"><g:message code="homeFolder.adult.property.title" /></label>
        <select id="_individuals.foreignAdults.${listIndex}.title" name="_individuals.foreignAdults[${listIndex}].title" class="required validate-not-first" title="<g:message code="homeFolder.adult.property.title.validationError" />">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${['Mister','Madam','Miss','Agency']}">
            <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == editList?.foreignAdults?.title?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.title" /></option>
          </g:each>
        </select>

        <label for="_individuals.foreignAdults.${listIndex}.lastName" class="required"><g:message code="homeFolder.individual.property.lastName" /></label>
        <input type="text" id="_individuals.foreignAdults.${listIndex}.lastName" name="_individuals.foreignAdults[${listIndex}].lastName" value="${editList?.foreignAdults?.lastName}"
          class="required validate-lastName" title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />

        <label for="_individuals.foreignAdults.${listIndex}.firstName" class="required"><g:message code="homeFolder.individual.property.firstName" /></label>
        <input type="text" id="_individuals.foreignAdults.${listIndex}.firstName" name="_individuals.foreignAdults[${listIndex}].firstName" value="${editList?.foreignAdults?.firstName}"
          class="required validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />
        
        <label for="_individuals.foreignAdults.${listIndex}.familyStatus" class="required"><g:message code="homeFolder.adult.property.familyStatus" /></label>
        <select id="_individuals.foreignAdults.${listIndex}.familyStatus" name="_individuals.foreignAdults[${listIndex}].familyStatus" class="required validate-not-first" title="<g:message code="homeFolder.adult.property.familyStatus.validationError" />">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','Pacs','Other']}">
            <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == editList?.foreignAdults?.familyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></option>
          </g:each>
        </select>
        
        <label for="_individuals.foreignAdults.${listIndex}.email" class="required"><g:message code="homeFolder.adult.property.email" /> <span><g:message code="homeFolder.adult.property.email.help" /></span></label>
        <input type="text" id="_individuals.foreignAdults.${listIndex}.email" name="_individuals.foreignAdults[${listIndex}].email" value="${editList?.foreignAdults?.email}"
          class="required validate-email" title="<g:message code="homeFolder.adult.property.email.validationError" />" />
        
        <label class="required"><g:message code="homeFolder.adult.label.phones" /> <span>(<g:message code="homeFolder.adult.label.phones.help" />)</span></label>
        <div id="foreignAdultPhones" class="address-fieldset">
          <label for="_individuals.foreignAdults.${listIndex}.homePhone"><g:message code="homeFolder.adult.property.homePhone" /> <span><g:message code="homeFolder.adult.property.homePhone.help" /></label>
          <input type="text" id="_individuals.foreignAdults.${listIndex}.homePhone" name="_individuals.foreignAdults[${listIndex}].homePhone" value="${editList?.foreignAdults?.homePhone}"
            class="validate-phone" title="<g:message code="homeFolder.adult.property.homePhone.validationError" />" />

          <label for="_individuals.foreignAdults.${listIndex}.mobilePhone"><g:message code="homeFolder.adult.property.mobilePhone" /> <span><g:message code="homeFolder.adult.property.mobilePhone.help" /></label>
          <input type="text" id="_individuals.foreignAdults.${listIndex}.mobilePhone" name="_individuals.foreignAdults[${listIndex}].mobilePhone" value="${editList?.foreignAdults?.mobilePhone}"
            class="validate-mobilePhone" title="<g:message code="homeFolder.adult.property.mobilePhone.validationError" />" />

          <label for="_individuals.foreignAdults.${listIndex}.officePhone"><g:message code="homeFolder.adult.property.officePhone" /> <span><g:message code="homeFolder.adult.property.officePhone.help" /></label>
          <input type="text" id="_individuals.foreignAdults.${listIndex}.officePhone" name="_individuals.foreignAdults[${listIndex}].officePhone" value="${editList?.foreignAdults?.officePhone}"
            class="validate-phone" title="<g:message code="homeFolder.adult.property.officePhone.validationError" />" />
        </div>
      </div>
      
      <div class="yui-u">
        <label class="required"><g:message code="homeFolder.individual.property.address" /></label>
        <div class="address-fieldset required">
          <label for="_individuals.foreignAdults.${listIndex}.adress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" class="validate-addressLine38" value="${editList?.foreignAdults?.adress?.additionalDeliveryInformation}" maxlength="38" id="_individuals.foreignAdults.${listIndex}.adress.additionalDeliveryInformation" name="_individuals.foreignAdults[${listIndex}].adress.additionalDeliveryInformation" />  
          <label for="_individuals.foreignAdults.${listIndex}.adress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" class="validate-addressLine38" value="${editList?.foreignAdults?.adress?.additionalGeographicalInformation}" maxlength="38" id="_individuals.foreignAdults.${listIndex}.adress.additionalGeographicalInformation" name="_individuals.foreignAdults[${listIndex}].adress.additionalGeographicalInformation" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
          <label for="_individuals.foreignAdults.${listIndex}.adress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
          <input type="text" class="line1 validate-streetNumber" value="${editList?.foreignAdults?.adress?.streetNumber}" size="5" maxlength="5" id="_individuals.foreignAdults.${listIndex}.adress.streetNumber" name="_individuals.foreignAdults[${listIndex}].adress.streetNumber" />
          <input type="text" class="line2 required validate-streetName" value="${editList?.foreignAdults?.adress?.streetName}" maxlength="32" id="_individuals.foreignAdults.${listIndex}.adress.streetName" name="_individuals.foreignAdults[${listIndex}].adress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" class="validate-addressLine38" value="${editList?.foreignAdults?.adress?.placeNameOrService}" maxlength="38" id="_individuals.foreignAdults.${listIndex}.adress.placeNameOrService" name="_individuals.foreignAdults[${listIndex}].adress.placeNameOrService" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
          <label for="_individuals.foreignAdults.${listIndex}.adress.city" class="required"><g:message code="address.property.city" /> *</label><br />
          <input type="text" class="line1 required validate-postalCode" value="${editList?.foreignAdults?.adress?.postalCode}" size="5" maxlength="5" id="_individuals.foreignAdults.${listIndex}.adress.postalCode" name="_individuals.foreignAdults[${listIndex}].adress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
          <input type="text" class="line2 required validate-city" value="${editList?.foreignAdults?.adress?.city}" maxlength="32" id="_individuals.foreignAdults.${listIndex}.adress.city" name="_individuals.foreignAdults[${listIndex}].adress.city" title="<g:message code="address.property.city.validationError" />" />
          <label for="_individuals.foreignAdults.${listIndex}.adress.countryName"><g:message code="address.property.countryName" /></label>
          <input type="text" class="validate-addressLine38" value="${editList?.foreignAdults?.adress?.countryName}" maxlength="38" id="_individuals.foreignAdults.${listIndex}.adress.countryName" name="_individuals.foreignAdults[${listIndex}].adress.countryName" />
        </div>
      </div>
    </div>
    <input type="hidden" name="individuals" />
    <input type="hidden" name="objectToBind" value="individuals" />
    <g:if test="${editList?.name == 'foreignAdults'}">
      <input type="submit" id="submit-collectionModify-foreignAdults-foreignAdults" name="submit-collectionModify-foreignAdults-foreignAdults[${listIndex}]" value="${message(code:'action.save')}" />
      <input type="submit" id="submit-collectionCancel-foreignAdults-foreignAdults" name="submit-collectionCancel-foreignAdults-foreignAdults[${listIndex}]" value="${message(code:'action.cancel')}" />
    </g:if>
    <g:else>
      <input type="submit" id="submit-collectionAdd-foreignAdults-foreignAdults" name="submit-collectionAdd-foreignAdults-foreignAdults[${listIndex}]" value="${message(code:'vcr.action.addForeignAdult')}" />
    </g:else>
  </fieldset>
  <div class="error" id="stepForm-foreignAdults-error"> </div>
    <g:each var="it" in="${individuals?.foreignAdults}" status="index">
    <fieldset class="individual edit summary-box">
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

