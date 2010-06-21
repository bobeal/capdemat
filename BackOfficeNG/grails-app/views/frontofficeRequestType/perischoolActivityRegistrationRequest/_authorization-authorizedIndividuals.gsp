

  <h4>${message(code:'parr.property.authorizedIndividuals.label')}<span>${message(code:'parr.property.authorizedIndividuals.help')}</span></h4>
  <g:set var="currentCollectionItem" value="${rqt?.authorizedIndividuals.size() > collectionIndex ? rqt.authorizedIndividuals.get(collectionIndex) : null}" />
  
    <label for="authorizedIndividuals.${collectionIndex}.lastName" class="required"><g:message code="parr.property.lastName.label" /> *  <span><g:message code="parr.property.lastName.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${collectionIndex}.lastName" name="authorizedIndividuals[${collectionIndex}].lastName" value="${currentCollectionItem?.lastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].lastName') ? 'validation-failed' : ''}" title="<g:message code="parr.property.lastName.validationError" />"  maxlength="38" />
            

  
    <label for="authorizedIndividuals.${collectionIndex}.firstName" class="required"><g:message code="parr.property.firstName.label" /> *  <span><g:message code="parr.property.firstName.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${collectionIndex}.firstName" name="authorizedIndividuals[${collectionIndex}].firstName" value="${currentCollectionItem?.firstName?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].firstName') ? 'validation-failed' : ''}" title="<g:message code="parr.property.firstName.validationError" />"  maxlength="38" />
            

  
    <label class="required"><g:message code="parr.property.address.label" /> *  <span><g:message code="parr.property.address.help" /></span></label>
            <div class="address required  ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].address') ? 'validation-failed' : ''}">
            <label for="authorizedIndividuals.${collectionIndex}.address.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].address.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.address?.additionalDeliveryInformation}" maxlength="38" id="authorizedIndividuals.${collectionIndex}.address.additionalDeliveryInformation" name="authorizedIndividuals[${collectionIndex}].address.additionalDeliveryInformation" />  
            <label for="authorizedIndividuals.${collectionIndex}.address.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].address.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.address?.additionalGeographicalInformation}" maxlength="38" id="authorizedIndividuals.${collectionIndex}.address.additionalGeographicalInformation" name="authorizedIndividuals[${collectionIndex}].address.additionalGeographicalInformation" />
            <label for="authorizedIndividuals.${collectionIndex}.address.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="authorizedIndividuals.${collectionIndex}.address.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].address.streetNumber') ? 'validation-failed' : ''}" value="${currentCollectionItem?.address?.streetNumber}" size="5" maxlength="5" id="authorizedIndividuals.${collectionIndex}.address.streetNumber" name="authorizedIndividuals[${collectionIndex}].address.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].address.streetName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.address?.streetName}" maxlength="32" id="authorizedIndividuals.${collectionIndex}.address.streetName" name="authorizedIndividuals[${collectionIndex}].address.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="authorizedIndividuals.${collectionIndex}.address.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].address.placeNameOrService') ? 'validation-failed' : ''}" value="${currentCollectionItem?.address?.placeNameOrService}" maxlength="38" id="authorizedIndividuals.${collectionIndex}.address.placeNameOrService" name="authorizedIndividuals[${collectionIndex}].address.placeNameOrService" />
            <label for="authorizedIndividuals.${collectionIndex}.address.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="authorizedIndividuals.${collectionIndex}.address.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].address.postalCode') ? 'validation-failed' : ''}" value="${currentCollectionItem?.address?.postalCode}" size="5" maxlength="5" id="authorizedIndividuals.${collectionIndex}.address.postalCode" name="authorizedIndividuals[${collectionIndex}].address.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].address.city') ? 'validation-failed' : ''}" value="${currentCollectionItem?.address?.city}" maxlength="32" id="authorizedIndividuals.${collectionIndex}.address.city" name="authorizedIndividuals[${collectionIndex}].address.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="authorizedIndividuals.${collectionIndex}.address.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].address.countryName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.address?.countryName}" maxlength="38" id="authorizedIndividuals.${collectionIndex}.address.countryName" name="authorizedIndividuals[${collectionIndex}].address.countryName" />
            </div>
            

  
    <label for="authorizedIndividuals.${collectionIndex}.homePhone" class=""><g:message code="parr.property.homePhone.label" />   <span><g:message code="parr.property.homePhone.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${collectionIndex}.homePhone" name="authorizedIndividuals[${collectionIndex}].homePhone" value="${currentCollectionItem?.homePhone?.toString()}" 
                    class="  validate-phone ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].homePhone') ? 'validation-failed' : ''}" title="<g:message code="parr.property.homePhone.validationError" />"  maxlength="10" />
            

  
    <label for="authorizedIndividuals.${collectionIndex}.officePhone" class=""><g:message code="parr.property.officePhone.label" />   <span><g:message code="parr.property.officePhone.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${collectionIndex}.officePhone" name="authorizedIndividuals[${collectionIndex}].officePhone" value="${currentCollectionItem?.officePhone?.toString()}" 
                    class="  validate-phone ${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals['+collectionIndex+'].officePhone') ? 'validation-failed' : ''}" title="<g:message code="parr.property.officePhone.validationError" />"  maxlength="10" />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="submit-step-authorization-authorizedIndividuals" name="submit-step-authorization-authorizedIndividuals[${collectionIndex}]" value="${message(code:'action.save')}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'authorization'])}">
    ${message(code:'request.action.cancelCollectionItemEdit')}
  </a>
  
