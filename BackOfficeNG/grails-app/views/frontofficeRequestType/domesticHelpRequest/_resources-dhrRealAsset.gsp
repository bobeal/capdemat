

  <label class="required"><g:message code="dhr.property.dhrRealAsset.label" /> <span><g:message code="dhr.property.dhrRealAsset.help" /></span></label>
  <div class="collection-fieldset required validation-scope summary-box">
    <fieldset class="collection-fieldset-add required">
    <g:set var="currentCollectionItem" value="${rqt?.dhrRealAsset.size() > collectionIndex ? rqt.dhrRealAsset.get(collectionIndex) : null}" />
  
      <label class="required"><g:message code="dhr.property.dhrRealAssetAddress.label" /> *  <span><g:message code="dhr.property.dhrRealAssetAddress.help" /></span></label>
            <div class="address-fieldset required  ${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset.dhrRealAssetAddress') ? 'validation-failed' : ''}">
            <label for="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset.dhrRealAssetAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrRealAssetAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.additionalDeliveryInformation" name="dhrRealAsset[${collectionIndex}].dhrRealAssetAddress.additionalDeliveryInformation" />  
            <label for="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset.dhrRealAssetAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrRealAssetAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.additionalGeographicalInformation" name="dhrRealAsset[${collectionIndex}].dhrRealAssetAddress.additionalGeographicalInformation" />
            <label for="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset.dhrRealAssetAddress.streetNumber') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrRealAssetAddress?.streetNumber}" size="5" maxlength="5" id="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.streetNumber" name="dhrRealAsset[${collectionIndex}].dhrRealAssetAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset.dhrRealAssetAddress.streetName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrRealAssetAddress?.streetName}" maxlength="32" id="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.streetName" name="dhrRealAsset[${collectionIndex}].dhrRealAssetAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset.dhrRealAssetAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrRealAssetAddress?.placeNameOrService}" maxlength="38" id="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.placeNameOrService" name="dhrRealAsset[${collectionIndex}].dhrRealAssetAddress.placeNameOrService" />
            <label for="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset.dhrRealAssetAddress.postalCode') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrRealAssetAddress?.postalCode}" size="5" maxlength="5" id="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.postalCode" name="dhrRealAsset[${collectionIndex}].dhrRealAssetAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset.dhrRealAssetAddress.city') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrRealAssetAddress?.city}" maxlength="32" id="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.city" name="dhrRealAsset[${collectionIndex}].dhrRealAssetAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset.dhrRealAssetAddress.countryName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrRealAssetAddress?.countryName}" maxlength="38" id="dhrRealAsset.${collectionIndex}.dhrRealAssetAddress.countryName" name="dhrRealAsset[${collectionIndex}].dhrRealAssetAddress.countryName" />
            </div>
            

  
      <label for="dhrRealAsset.${collectionIndex}.dhrRealAssetValue" class="required"><g:message code="dhr.property.dhrRealAssetValue.label" /> *  <span><g:message code="dhr.property.dhrRealAssetValue.help" /></span></label>
            <input type="text" id="dhrRealAsset.${collectionIndex}.dhrRealAssetValue" name="dhrRealAsset[${collectionIndex}].dhrRealAssetValue" value="${currentCollectionItem?.dhrRealAssetValue?.toString()}" 
                    class="required  validate-positiveInteger ${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset.dhrRealAssetValue') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrRealAssetValue.validationError" />"   />
            

  
      <label for="dhrRealAsset.${collectionIndex}.realAssetNetFloorArea" class="required"><g:message code="dhr.property.realAssetNetFloorArea.label" /> *  <span><g:message code="dhr.property.realAssetNetFloorArea.help" /></span></label>
            <input type="text" id="dhrRealAsset.${collectionIndex}.realAssetNetFloorArea" name="dhrRealAsset[${collectionIndex}].realAssetNetFloorArea" value="${currentCollectionItem?.realAssetNetFloorArea?.toString()}" 
                    class="required  validate-positiveInteger ${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset.realAssetNetFloorArea') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.realAssetNetFloorArea.validationError" />"   />
            

  
      <input type="submit" id="submit-step-resources-dhrRealAsset" name="submit-step-resources-dhrRealAsset[${collectionIndex}]" value="${message(code:'action.save')}" />
      <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'resources'])}">
        ${message(code:'request.action.cancelCollectionItemEdit')}
      </a>  
    </fieldset>
</div>
  
