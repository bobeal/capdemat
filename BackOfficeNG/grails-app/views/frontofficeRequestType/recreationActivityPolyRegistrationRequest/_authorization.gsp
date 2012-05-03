


  
    <label class=""><g:message code="raprr.property.authorizedPolyIndividuals.label" /> <span><g:message code="raprr.property.authorizedPolyIndividuals.help" /></span></label>
    <div class="collection-fieldset  validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'authorizedPolyIndividuals' ? editList?.index : ( rqt.authorizedPolyIndividuals ? rqt.authorizedPolyIndividuals.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add ">
    
        <label for="authorizedPolyIndividuals.${listIndex}.lastName" class="required"><g:message code="raprr.property.lastName.label" /> *  <span><g:message code="raprr.property.lastName.help" /></span></label>
            <input type="text" id="authorizedPolyIndividuals.${listIndex}.lastName" name="authorizedPolyIndividuals[${listIndex}].lastName" value="${editList?.authorizedPolyIndividuals?.lastName?.toString()}" 
                    class="required  validate-lastName ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.lastName') ? 'validation-failed' : ''}" title="<g:message code="raprr.property.lastName.validationError" />"  maxlength="38" />
            

    
        <label for="authorizedPolyIndividuals.${listIndex}.firstName" class="required"><g:message code="raprr.property.firstName.label" /> *  <span><g:message code="raprr.property.firstName.help" /></span></label>
            <input type="text" id="authorizedPolyIndividuals.${listIndex}.firstName" name="authorizedPolyIndividuals[${listIndex}].firstName" value="${editList?.authorizedPolyIndividuals?.firstName?.toString()}" 
                    class="required  validate-firstName ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.firstName') ? 'validation-failed' : ''}" title="<g:message code="raprr.property.firstName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="raprr.property.address.label" /> *  <span><g:message code="raprr.property.address.help" /></span></label>
            <div class="address-fieldset required  ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.address') ? 'validation-failed' : ''}">
            <label for="authorizedPolyIndividuals.${listIndex}.address.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.address.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${editList?.authorizedPolyIndividuals?.address?.additionalDeliveryInformation}" maxlength="38" id="authorizedPolyIndividuals.${listIndex}.address.additionalDeliveryInformation" name="authorizedPolyIndividuals[${listIndex}].address.additionalDeliveryInformation" />  
            <label for="authorizedPolyIndividuals.${listIndex}.address.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.address.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${editList?.authorizedPolyIndividuals?.address?.additionalGeographicalInformation}" maxlength="38" id="authorizedPolyIndividuals.${listIndex}.address.additionalGeographicalInformation" name="authorizedPolyIndividuals[${listIndex}].address.additionalGeographicalInformation" />
            <label for="authorizedPolyIndividuals.${listIndex}.address.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="authorizedPolyIndividuals.${listIndex}.address.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.address.streetNumber') ? 'validation-failed' : ''}" value="${editList?.authorizedPolyIndividuals?.address?.streetNumber}" size="5" maxlength="5" id="authorizedPolyIndividuals.${listIndex}.address.streetNumber" name="authorizedPolyIndividuals[${listIndex}].address.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.address.streetName') ? 'validation-failed' : ''}" value="${editList?.authorizedPolyIndividuals?.address?.streetName}" maxlength="32" id="authorizedPolyIndividuals.${listIndex}.address.streetName" name="authorizedPolyIndividuals[${listIndex}].address.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="authorizedPolyIndividuals.${listIndex}.address.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.address.placeNameOrService') ? 'validation-failed' : ''}" value="${editList?.authorizedPolyIndividuals?.address?.placeNameOrService}" maxlength="38" id="authorizedPolyIndividuals.${listIndex}.address.placeNameOrService" name="authorizedPolyIndividuals[${listIndex}].address.placeNameOrService" />
            <label for="authorizedPolyIndividuals.${listIndex}.address.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="authorizedPolyIndividuals.${listIndex}.address.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.address.postalCode') ? 'validation-failed' : ''}" value="${editList?.authorizedPolyIndividuals?.address?.postalCode}" size="5" maxlength="5" id="authorizedPolyIndividuals.${listIndex}.address.postalCode" name="authorizedPolyIndividuals[${listIndex}].address.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.address.city') ? 'validation-failed' : ''}" value="${editList?.authorizedPolyIndividuals?.address?.city}" maxlength="32" id="authorizedPolyIndividuals.${listIndex}.address.city" name="authorizedPolyIndividuals[${listIndex}].address.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="authorizedPolyIndividuals.${listIndex}.address.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.address.countryName') ? 'validation-failed' : ''}" value="${editList?.authorizedPolyIndividuals?.address?.countryName}" maxlength="38" id="authorizedPolyIndividuals.${listIndex}.address.countryName" name="authorizedPolyIndividuals[${listIndex}].address.countryName" />
            </div>
            

    
        <label for="authorizedPolyIndividuals.${listIndex}.homePhone" class=""><g:message code="raprr.property.homePhone.label" />   <span><g:message code="raprr.property.homePhone.help" /></span></label>
            <input type="text" id="authorizedPolyIndividuals.${listIndex}.homePhone" name="authorizedPolyIndividuals[${listIndex}].homePhone" value="${editList?.authorizedPolyIndividuals?.homePhone?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.homePhone') ? 'validation-failed' : ''}" title="<g:message code="raprr.property.homePhone.validationError" />"  maxlength="10" />
            

    
        <label for="authorizedPolyIndividuals.${listIndex}.officePhone" class=""><g:message code="raprr.property.officePhone.label" />   <span><g:message code="raprr.property.officePhone.help" /></span></label>
            <input type="text" id="authorizedPolyIndividuals.${listIndex}.officePhone" name="authorizedPolyIndividuals[${listIndex}].officePhone" value="${editList?.authorizedPolyIndividuals?.officePhone?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['authorization']?.invalidFields?.contains('authorizedPolyIndividuals.officePhone') ? 'validation-failed' : ''}" title="<g:message code="raprr.property.officePhone.validationError" />"  maxlength="10" />
            

    
        <g:if test="${editList?.name == 'authorizedPolyIndividuals'}">
          <input type="submit" id="submit-collectionModify-authorization-authorizedPolyIndividuals" name="submit-collectionModify-authorization-authorizedPolyIndividuals[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-authorization-authorizedPolyIndividuals" name="submit-collectionAdd-authorization-authorizedPolyIndividuals[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.authorizedPolyIndividuals}" status="index">
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
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-authorization-authorizedPolyIndividuals[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-authorization-authorizedPolyIndividuals[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

