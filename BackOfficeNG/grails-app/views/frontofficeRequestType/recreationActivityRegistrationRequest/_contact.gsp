


  
    <label class=""><g:message code="rarr.property.contactIndividuals.label" /> <span><g:message code="rarr.property.contactIndividuals.help" /></span></label>
    <div class="collection-fieldset  validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'contactIndividuals' ? editList?.index : ( rqt.contactIndividuals ? rqt.contactIndividuals.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add ">
    
        <label for="contactIndividuals.${listIndex}.lastName" class="required"><g:message code="rarr.property.lastName.label" /> *  <span><g:message code="rarr.property.lastName.help" /></span></label>
            <input type="text" id="contactIndividuals.${listIndex}.lastName" name="contactIndividuals[${listIndex}].lastName" value="${editList?.contactIndividuals?.lastName?.toString()}" 
                    class="required  validate-lastName ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.lastName') ? 'validation-failed' : ''}" title="<g:message code="rarr.property.lastName.validationError" />"  maxlength="38" />
            

    
        <label for="contactIndividuals.${listIndex}.firstName" class="required"><g:message code="rarr.property.firstName.label" /> *  <span><g:message code="rarr.property.firstName.help" /></span></label>
            <input type="text" id="contactIndividuals.${listIndex}.firstName" name="contactIndividuals[${listIndex}].firstName" value="${editList?.contactIndividuals?.firstName?.toString()}" 
                    class="required  validate-firstName ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.firstName') ? 'validation-failed' : ''}" title="<g:message code="rarr.property.firstName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="rarr.property.address.label" /> *  <span><g:message code="rarr.property.address.help" /></span></label>
            <div class="address-fieldset required  ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.address') ? 'validation-failed' : ''}">
            <label for="contactIndividuals.${listIndex}.address.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.address.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${editList?.contactIndividuals?.address?.additionalDeliveryInformation}" maxlength="38" id="contactIndividuals.${listIndex}.address.additionalDeliveryInformation" name="contactIndividuals[${listIndex}].address.additionalDeliveryInformation" />  
            <label for="contactIndividuals.${listIndex}.address.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.address.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${editList?.contactIndividuals?.address?.additionalGeographicalInformation}" maxlength="38" id="contactIndividuals.${listIndex}.address.additionalGeographicalInformation" name="contactIndividuals[${listIndex}].address.additionalGeographicalInformation" />
            <label for="contactIndividuals.${listIndex}.address.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="contactIndividuals.${listIndex}.address.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.address.streetNumber') ? 'validation-failed' : ''}" value="${editList?.contactIndividuals?.address?.streetNumber}" size="5" maxlength="5" id="contactIndividuals.${listIndex}.address.streetNumber" name="contactIndividuals[${listIndex}].address.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.address.streetName') ? 'validation-failed' : ''}" value="${editList?.contactIndividuals?.address?.streetName}" maxlength="32" id="contactIndividuals.${listIndex}.address.streetName" name="contactIndividuals[${listIndex}].address.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${editList?.contactIndividuals?.address?.streetMatriculation}" id="contactIndividuals.${listIndex}.address_streetMatriculation" name="contactIndividuals.${listIndex}.address.streetMatriculation" />
            <label for="contactIndividuals.${listIndex}.address.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.address.placeNameOrService') ? 'validation-failed' : ''}" value="${editList?.contactIndividuals?.address?.placeNameOrService}" maxlength="38" id="contactIndividuals.${listIndex}.address.placeNameOrService" name="contactIndividuals[${listIndex}].address.placeNameOrService" />
            <label for="contactIndividuals.${listIndex}.address.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="contactIndividuals.${listIndex}.address.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.address.postalCode') ? 'validation-failed' : ''}" value="${editList?.contactIndividuals?.address?.postalCode}" size="5" maxlength="5" id="contactIndividuals.${listIndex}.address.postalCode" name="contactIndividuals[${listIndex}].address.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.address.city') ? 'validation-failed' : ''}" value="${editList?.contactIndividuals?.address?.city}" maxlength="32" id="contactIndividuals.${listIndex}.address.city" name="contactIndividuals[${listIndex}].address.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${editList?.contactIndividuals?.address?.cityInseeCode}" id="contactIndividuals.${listIndex}.address_cityInseeCode" name="contactIndividuals.${listIndex}.address.cityInseeCode" />
            <label for="contactIndividuals.${listIndex}.address.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.address.countryName') ? 'validation-failed' : ''}" value="${editList?.contactIndividuals?.address?.countryName}" maxlength="38" id="contactIndividuals.${listIndex}.address.countryName" name="contactIndividuals[${listIndex}].address.countryName" />
            </div>
            

    
        <label for="contactIndividuals.${listIndex}.homePhone" class=""><g:message code="rarr.property.homePhone.label" />   <span><g:message code="rarr.property.homePhone.help" /></span></label>
            <input type="text" id="contactIndividuals.${listIndex}.homePhone" name="contactIndividuals[${listIndex}].homePhone" value="${editList?.contactIndividuals?.homePhone?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.homePhone') ? 'validation-failed' : ''}" title="<g:message code="rarr.property.homePhone.validationError" />"  maxlength="10" />
            

    
        <label for="contactIndividuals.${listIndex}.officePhone" class=""><g:message code="rarr.property.officePhone.label" />   <span><g:message code="rarr.property.officePhone.help" /></span></label>
            <input type="text" id="contactIndividuals.${listIndex}.officePhone" name="contactIndividuals[${listIndex}].officePhone" value="${editList?.contactIndividuals?.officePhone?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['contact']?.invalidFields.contains('contactIndividuals.officePhone') ? 'validation-failed' : ''}" title="<g:message code="rarr.property.officePhone.validationError" />"  maxlength="10" />
            

    
        <g:if test="${editList?.name == 'contactIndividuals'}">
          <input type="submit" id="submit-collectionModify-contact-contactIndividuals" name="submit-collectionModify-contact-contactIndividuals[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-contact-contactIndividuals" name="submit-collectionAdd-contact-contactIndividuals[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.contactIndividuals}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="rarr.property.lastName.label" /></dt>
        <dd>${it.lastName?.toString()}</dd>
    
        <dt><g:message code="rarr.property.firstName.label" /></dt>
        <dd>${it.firstName?.toString()}</dd>
    
        <dt><g:message code="rarr.property.address.label" /></dt>
        
              <g:if test="${it.address}">
                <dd>
                  <p>${it.address?.additionalDeliveryInformation}</p>
                  <p>${it.address?.additionalGeographicalInformation}</p>
                  <p>${it.address?.streetNumber} ${it.address?.streetName}</p>
                  <p>${it.address?.placeNameOrService}</p>
                  <p>${it.address?.postalCode} ${it.address?.city}</p>
                  <p>${it.address?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="rarr.property.homePhone.label" /></dt>
        <dd>${it.homePhone?.toString()}</dd>
    
        <dt><g:message code="rarr.property.officePhone.label" /></dt>
        <dd>${it.officePhone?.toString()}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-contact-contactIndividuals[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-contact-contactIndividuals[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

