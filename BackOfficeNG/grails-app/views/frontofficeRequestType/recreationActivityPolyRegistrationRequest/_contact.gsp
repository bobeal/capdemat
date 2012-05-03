


  
    <label class=""><g:message code="raprr.property.contactPolyIndividuals.label" /> <span><g:message code="raprr.property.contactPolyIndividuals.help" /></span></label>
    <div class="collection-fieldset  validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'contactPolyIndividuals' ? editList?.index : ( rqt.contactPolyIndividuals ? rqt.contactPolyIndividuals.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add ">
    
        <label for="contactPolyIndividuals.${listIndex}.lastName" class="required"><g:message code="raprr.property.lastName.label" /> *  <span><g:message code="raprr.property.lastName.help" /></span></label>
            <input type="text" id="contactPolyIndividuals.${listIndex}.lastName" name="contactPolyIndividuals[${listIndex}].lastName" value="${editList?.contactPolyIndividuals?.lastName?.toString()}" 
                    class="required  validate-lastName ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.lastName') ? 'validation-failed' : ''}" title="<g:message code="raprr.property.lastName.validationError" />"  maxlength="38" />
            

    
        <label for="contactPolyIndividuals.${listIndex}.firstName" class="required"><g:message code="raprr.property.firstName.label" /> *  <span><g:message code="raprr.property.firstName.help" /></span></label>
            <input type="text" id="contactPolyIndividuals.${listIndex}.firstName" name="contactPolyIndividuals[${listIndex}].firstName" value="${editList?.contactPolyIndividuals?.firstName?.toString()}" 
                    class="required  validate-firstName ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.firstName') ? 'validation-failed' : ''}" title="<g:message code="raprr.property.firstName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="raprr.property.address.label" /> *  <span><g:message code="raprr.property.address.help" /></span></label>
            <div class="address-fieldset required  ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.address') ? 'validation-failed' : ''}">
            <label for="contactPolyIndividuals.${listIndex}.address.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.address.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${editList?.contactPolyIndividuals?.address?.additionalDeliveryInformation}" maxlength="38" id="contactPolyIndividuals.${listIndex}.address.additionalDeliveryInformation" name="contactPolyIndividuals[${listIndex}].address.additionalDeliveryInformation" />  
            <label for="contactPolyIndividuals.${listIndex}.address.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.address.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${editList?.contactPolyIndividuals?.address?.additionalGeographicalInformation}" maxlength="38" id="contactPolyIndividuals.${listIndex}.address.additionalGeographicalInformation" name="contactPolyIndividuals[${listIndex}].address.additionalGeographicalInformation" />
            <label for="contactPolyIndividuals.${listIndex}.address.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="contactPolyIndividuals.${listIndex}.address.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.address.streetNumber') ? 'validation-failed' : ''}" value="${editList?.contactPolyIndividuals?.address?.streetNumber}" size="5" maxlength="5" id="contactPolyIndividuals.${listIndex}.address.streetNumber" name="contactPolyIndividuals[${listIndex}].address.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.address.streetName') ? 'validation-failed' : ''}" value="${editList?.contactPolyIndividuals?.address?.streetName}" maxlength="32" id="contactPolyIndividuals.${listIndex}.address.streetName" name="contactPolyIndividuals[${listIndex}].address.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="contactPolyIndividuals.${listIndex}.address.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.address.placeNameOrService') ? 'validation-failed' : ''}" value="${editList?.contactPolyIndividuals?.address?.placeNameOrService}" maxlength="38" id="contactPolyIndividuals.${listIndex}.address.placeNameOrService" name="contactPolyIndividuals[${listIndex}].address.placeNameOrService" />
            <label for="contactPolyIndividuals.${listIndex}.address.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="contactPolyIndividuals.${listIndex}.address.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.address.postalCode') ? 'validation-failed' : ''}" value="${editList?.contactPolyIndividuals?.address?.postalCode}" size="5" maxlength="5" id="contactPolyIndividuals.${listIndex}.address.postalCode" name="contactPolyIndividuals[${listIndex}].address.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.address.city') ? 'validation-failed' : ''}" value="${editList?.contactPolyIndividuals?.address?.city}" maxlength="32" id="contactPolyIndividuals.${listIndex}.address.city" name="contactPolyIndividuals[${listIndex}].address.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="contactPolyIndividuals.${listIndex}.address.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.address.countryName') ? 'validation-failed' : ''}" value="${editList?.contactPolyIndividuals?.address?.countryName}" maxlength="38" id="contactPolyIndividuals.${listIndex}.address.countryName" name="contactPolyIndividuals[${listIndex}].address.countryName" />
            </div>
            

    
        <label for="contactPolyIndividuals.${listIndex}.homePhone" class=""><g:message code="raprr.property.homePhone.label" />   <span><g:message code="raprr.property.homePhone.help" /></span></label>
            <input type="text" id="contactPolyIndividuals.${listIndex}.homePhone" name="contactPolyIndividuals[${listIndex}].homePhone" value="${editList?.contactPolyIndividuals?.homePhone?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.homePhone') ? 'validation-failed' : ''}" title="<g:message code="raprr.property.homePhone.validationError" />"  maxlength="10" />
            

    
        <label for="contactPolyIndividuals.${listIndex}.officePhone" class=""><g:message code="raprr.property.officePhone.label" />   <span><g:message code="raprr.property.officePhone.help" /></span></label>
            <input type="text" id="contactPolyIndividuals.${listIndex}.officePhone" name="contactPolyIndividuals[${listIndex}].officePhone" value="${editList?.contactPolyIndividuals?.officePhone?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['contact']?.invalidFields?.contains('contactPolyIndividuals.officePhone') ? 'validation-failed' : ''}" title="<g:message code="raprr.property.officePhone.validationError" />"  maxlength="10" />
            

    
        <g:if test="${editList?.name == 'contactPolyIndividuals'}">
          <input type="submit" id="submit-collectionModify-contact-contactPolyIndividuals" name="submit-collectionModify-contact-contactPolyIndividuals[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-contact-contactPolyIndividuals" name="submit-collectionAdd-contact-contactPolyIndividuals[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.contactPolyIndividuals}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="raprr.property.lastName.label" /></dt>
        <dd>${it.lastName?.toString()}</dd>
    
        <dt><g:message code="raprr.property.firstName.label" /></dt>
        <dd>${it.firstName?.toString()}</dd>
    
        <dt><g:message code="raprr.property.address.label" /></dt>
        
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
              
    
        <dt><g:message code="raprr.property.homePhone.label" /></dt>
        <dd>${it.homePhone?.toString()}</dd>
    
        <dt><g:message code="raprr.property.officePhone.label" /></dt>
        <dd>${it.officePhone?.toString()}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-contact-contactPolyIndividuals[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-contact-contactPolyIndividuals[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

