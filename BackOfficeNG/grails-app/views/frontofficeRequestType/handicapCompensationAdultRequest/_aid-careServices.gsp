

  <label class="required condition-isCareServices-filled"><g:message code="hcar.property.careServices.label" /> <span><g:message code="hcar.property.careServices.help" /></span></label>
  <div class="collection-fieldset required condition-isCareServices-filled validation-scope summary-box">
    <fieldset class="collection-fieldset-add required condition-isCareServices-filled">
    <g:set var="currentCollectionItem" value="${rqt?.careServices.size() > collectionIndex ? rqt.careServices.get(collectionIndex) : null}" />
  
      <label for="careServices.${collectionIndex}.careServiceKind" class="required"><g:message code="hcar.property.careServiceKind.label" /> *  <span><g:message code="hcar.property.careServiceKind.help" /></span></label>
            <input type="text" id="careServices.${collectionIndex}.careServiceKind" name="careServices[${collectionIndex}].careServiceKind" value="${currentCollectionItem?.careServiceKind?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceKind') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.careServiceKind.validationError" />"   />
            

  
      <label class="required"><g:message code="hcar.property.careServiceCareServiceEmployer.label" /> *  <span><g:message code="hcar.property.careServiceCareServiceEmployer.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceCareServiceEmployer') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="careServices.${collectionIndex}.careServiceCareServiceEmployer_${it ? 'yes' : 'no'}" class="required condition-isCareServiceEmployer-trigger  validate-one-required boolean" title="" value="${it}" name="careServices[${collectionIndex}].careServiceCareServiceEmployer" ${it == currentCollectionItem?.careServiceCareServiceEmployer ? 'checked="checked"': ''} />
                <label for="careServices.${collectionIndex}.careServiceCareServiceEmployer_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  
      <label for="careServices.${collectionIndex}.careServiceProviderName" class="required condition-isCareServiceEmployer-unfilled"><g:message code="hcar.property.careServiceProviderName.label" /> *  <span><g:message code="hcar.property.careServiceProviderName.help" /></span></label>
            <input type="text" id="careServices.${collectionIndex}.careServiceProviderName" name="careServices[${collectionIndex}].careServiceProviderName" value="${currentCollectionItem?.careServiceProviderName?.toString()}" 
                    class="required condition-isCareServiceEmployer-unfilled  validate-lastName ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceProviderName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.careServiceProviderName.validationError" />"  maxlength="38" />
            

  
      <label class="condition-isCareServiceEmployer-unfilled"><g:message code="hcar.property.careServiceProviderAddress.label" />   <span><g:message code="hcar.property.careServiceProviderAddress.help" /></span></label>
            <div class="address-fieldset condition-isCareServiceEmployer-unfilled  ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceProviderAddress') ? 'validation-failed' : ''}">
            <label for="careServices.${collectionIndex}.careServiceProviderAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceProviderAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.careServiceProviderAddress?.additionalDeliveryInformation}" maxlength="38" id="careServices.${collectionIndex}.careServiceProviderAddress.additionalDeliveryInformation" name="careServices[${collectionIndex}].careServiceProviderAddress.additionalDeliveryInformation" />  
            <label for="careServices.${collectionIndex}.careServiceProviderAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceProviderAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.careServiceProviderAddress?.additionalGeographicalInformation}" maxlength="38" id="careServices.${collectionIndex}.careServiceProviderAddress.additionalGeographicalInformation" name="careServices[${collectionIndex}].careServiceProviderAddress.additionalGeographicalInformation" />
            <label for="careServices.${collectionIndex}.careServiceProviderAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="careServices.${collectionIndex}.careServiceProviderAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceProviderAddress.streetNumber') ? 'validation-failed' : ''}" value="${currentCollectionItem?.careServiceProviderAddress?.streetNumber}" size="5" maxlength="5" id="careServices.${collectionIndex}.careServiceProviderAddress.streetNumber" name="careServices[${collectionIndex}].careServiceProviderAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceProviderAddress.streetName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.careServiceProviderAddress?.streetName}" maxlength="32" id="careServices.${collectionIndex}.careServiceProviderAddress.streetName" name="careServices[${collectionIndex}].careServiceProviderAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="careServices.${collectionIndex}.careServiceProviderAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceProviderAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${currentCollectionItem?.careServiceProviderAddress?.placeNameOrService}" maxlength="38" id="careServices.${collectionIndex}.careServiceProviderAddress.placeNameOrService" name="careServices[${collectionIndex}].careServiceProviderAddress.placeNameOrService" />
            <label for="careServices.${collectionIndex}.careServiceProviderAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="careServices.${collectionIndex}.careServiceProviderAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceProviderAddress.postalCode') ? 'validation-failed' : ''}" value="${currentCollectionItem?.careServiceProviderAddress?.postalCode}" size="5" maxlength="5" id="careServices.${collectionIndex}.careServiceProviderAddress.postalCode" name="careServices[${collectionIndex}].careServiceProviderAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceProviderAddress.city') ? 'validation-failed' : ''}" value="${currentCollectionItem?.careServiceProviderAddress?.city}" maxlength="32" id="careServices.${collectionIndex}.careServiceProviderAddress.city" name="careServices[${collectionIndex}].careServiceProviderAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="careServices.${collectionIndex}.careServiceProviderAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['aid'].invalidFields.contains('careServices.careServiceProviderAddress.countryName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.careServiceProviderAddress?.countryName}" maxlength="38" id="careServices.${collectionIndex}.careServiceProviderAddress.countryName" name="careServices[${collectionIndex}].careServiceProviderAddress.countryName" />
            </div>
            

  
      <input type="submit" id="submit-step-aid-careServices" name="submit-step-aid-careServices[${collectionIndex}]" value="${message(code:'action.save')}" />
      <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'aid'])}">
        ${message(code:'request.action.cancelCollectionItemEdit')}
      </a>  
    </fieldset>
</div>
  
