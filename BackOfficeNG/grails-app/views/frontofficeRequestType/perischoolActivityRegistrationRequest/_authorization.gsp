


  
    <label class=""><g:message code="parr.property.authorizedIndividuals.label" /> <span><g:message code="parr.property.authorizedIndividuals.help" /></span></label>
    <div class="collection-fieldset  validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'authorizedIndividuals' ? editList?.index : ( rqt.authorizedIndividuals ? rqt.authorizedIndividuals.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add ">
    
        <label for="authorizedIndividuals.${listIndex}.lastName" class="required"><g:message code="parr.property.lastName.label" /> *  <span><g:message code="parr.property.lastName.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${listIndex}.lastName" name="authorizedIndividuals[${listIndex}].lastName" value="${editList?.authorizedIndividuals?.lastName?.toString()}" 
                    class="required  validate-lastName ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.lastName') ? 'validation-failed' : ''}" title="<g:message code="parr.property.lastName.validationError" />"  maxlength="38" />
            

    
        <label for="authorizedIndividuals.${listIndex}.firstName" class="required"><g:message code="parr.property.firstName.label" /> *  <span><g:message code="parr.property.firstName.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${listIndex}.firstName" name="authorizedIndividuals[${listIndex}].firstName" value="${editList?.authorizedIndividuals?.firstName?.toString()}" 
                    class="required  validate-firstName ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.firstName') ? 'validation-failed' : ''}" title="<g:message code="parr.property.firstName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="parr.property.address.label" /> *  <span><g:message code="parr.property.address.help" /></span></label>
            <div class="address-fieldset required  ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.address') ? 'validation-failed' : ''}">
            <label for="authorizedIndividuals.${listIndex}.address.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.address.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${editList?.authorizedIndividuals?.address?.additionalDeliveryInformation}" maxlength="38" id="authorizedIndividuals.${listIndex}.address.additionalDeliveryInformation" name="authorizedIndividuals[${listIndex}].address.additionalDeliveryInformation" />  
            <label for="authorizedIndividuals.${listIndex}.address.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.address.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${editList?.authorizedIndividuals?.address?.additionalGeographicalInformation}" maxlength="38" id="authorizedIndividuals.${listIndex}.address.additionalGeographicalInformation" name="authorizedIndividuals[${listIndex}].address.additionalGeographicalInformation" />
            <label for="authorizedIndividuals.${listIndex}.address.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="authorizedIndividuals.${listIndex}.address.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.address.streetNumber') ? 'validation-failed' : ''}" value="${editList?.authorizedIndividuals?.address?.streetNumber}" size="5" maxlength="5" id="authorizedIndividuals.${listIndex}.address.streetNumber" name="authorizedIndividuals[${listIndex}].address.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.address.streetName') ? 'validation-failed' : ''}" value="${editList?.authorizedIndividuals?.address?.streetName}" maxlength="32" id="authorizedIndividuals.${listIndex}.address.streetName" name="authorizedIndividuals[${listIndex}].address.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="" id="authorizedIndividuals.${listIndex}.address_streetMatriculation" name="authorizedIndividuals.${listIndex}.address.streetMatriculation" />
            <label for="authorizedIndividuals.${listIndex}.address.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.address.placeNameOrService') ? 'validation-failed' : ''}" value="${editList?.authorizedIndividuals?.address?.placeNameOrService}" maxlength="38" id="authorizedIndividuals.${listIndex}.address.placeNameOrService" name="authorizedIndividuals[${listIndex}].address.placeNameOrService" />
            <label for="authorizedIndividuals.${listIndex}.address.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="authorizedIndividuals.${listIndex}.address.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="hidden" value="" id="authorizedIndividuals.${listIndex}.address_cityInseeCode" name="authorizedIndividuals.${listIndex}.address.cityInseeCode" />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.address.postalCode') ? 'validation-failed' : ''}" value="${editList?.authorizedIndividuals?.address?.postalCode}" size="5" maxlength="5" id="authorizedIndividuals.${listIndex}.address.postalCode" name="authorizedIndividuals[${listIndex}].address.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.address.city') ? 'validation-failed' : ''}" value="${editList?.authorizedIndividuals?.address?.city}" maxlength="32" id="authorizedIndividuals.${listIndex}.address.city" name="authorizedIndividuals[${listIndex}].address.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="authorizedIndividuals.${listIndex}.address.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.address.countryName') ? 'validation-failed' : ''}" value="${editList?.authorizedIndividuals?.address?.countryName}" maxlength="38" id="authorizedIndividuals.${listIndex}.address.countryName" name="authorizedIndividuals[${listIndex}].address.countryName" />
            </div>
            

    
        <label for="authorizedIndividuals.${listIndex}.homePhone" class=""><g:message code="parr.property.homePhone.label" />   <span><g:message code="parr.property.homePhone.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${listIndex}.homePhone" name="authorizedIndividuals[${listIndex}].homePhone" value="${editList?.authorizedIndividuals?.homePhone?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.homePhone') ? 'validation-failed' : ''}" title="<g:message code="parr.property.homePhone.validationError" />"  maxlength="10" />
            

    
        <label for="authorizedIndividuals.${listIndex}.officePhone" class=""><g:message code="parr.property.officePhone.label" />   <span><g:message code="parr.property.officePhone.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${listIndex}.officePhone" name="authorizedIndividuals[${listIndex}].officePhone" value="${editList?.authorizedIndividuals?.officePhone?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['authorization']?.invalidFields.contains('authorizedIndividuals.officePhone') ? 'validation-failed' : ''}" title="<g:message code="parr.property.officePhone.validationError" />"  maxlength="10" />
            

    
        <g:if test="${editList?.name == 'authorizedIndividuals'}">
          <input type="submit" id="submit-collectionModify-authorization-authorizedIndividuals" name="submit-collectionModify-authorization-authorizedIndividuals[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-authorization-authorizedIndividuals" name="submit-collectionAdd-authorization-authorizedIndividuals[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.authorizedIndividuals}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="parr.property.lastName.label" /></dt>
        <dd>${it.lastName?.toString()}</dd>
    
        <dt><g:message code="parr.property.firstName.label" /></dt>
        <dd>${it.firstName?.toString()}</dd>
    
        <dt><g:message code="parr.property.address.label" /></dt>
        
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
              
    
        <dt><g:message code="parr.property.homePhone.label" /></dt>
        <dd>${it.homePhone?.toString()}</dd>
    
        <dt><g:message code="parr.property.officePhone.label" /></dt>
        <dd>${it.officePhone?.toString()}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-authorization-authorizedIndividuals[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-authorization-authorizedIndividuals[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

