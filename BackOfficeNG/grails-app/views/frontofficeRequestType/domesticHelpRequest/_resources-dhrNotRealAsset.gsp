

  <h4>${message(code:'dhr.property.dhrNotRealAsset.label')}<span>${message(code:'dhr.property.dhrNotRealAsset.help')}</span></h4>
  <g:set var="currentCollectionItem" value="${rqt?.dhrNotRealAsset.size() > collectionIndex ? rqt.dhrNotRealAsset.get(collectionIndex) : null}" />
  
    <label class="required"><g:message code="dhr.property.dhrNotRealAssetType.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetType.help" /></span></label>
            <ul class="required ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetType') ? 'validation-failed' : ''}">
              <g:each in="${['Share','Gift','Sale']}">
              <li>
                <input type="radio" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetType_${it}" class="required  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrAssetTypeType_${it}" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetType" ${it == currentCollectionItem?.dhrNotRealAssetType.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrNotRealAssetType.validationError" />" />
                <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetType_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrNotRealAssetType" /></label>
              </li>
              </g:each>
            </ul>
            

  
    <label class="required"><g:message code="dhr.property.dhrNotRealAssetKind.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetKind.help" /></span></label>
            <ul class="required ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetKind') ? 'validation-failed' : ''}">
              <g:each in="${['RealEstate','Other']}">
              <li>
                <input type="radio" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetKind_${it}" class="required condition-isRealEstate-trigger  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrAssetKindType_${it}" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetKind" ${it == currentCollectionItem?.dhrNotRealAssetKind.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrNotRealAssetKind.validationError" />" />
                <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetKind_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrNotRealAssetKind" /></label>
              </li>
              </g:each>
            </ul>
            

  
    <label class="required condition-isRealEstate-filled"><g:message code="dhr.property.dhrNotRealAssetAddress.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetAddress.help" /></span></label>
            <div class="address required condition-isRealEstate-filled  ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetAddress') ? 'validation-failed' : ''}">
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.additionalDeliveryInformation" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetAddress.additionalDeliveryInformation" />  
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.additionalGeographicalInformation" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetAddress.additionalGeographicalInformation" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetAddress.streetNumber') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetAddress?.streetNumber}" size="5" maxlength="5" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.streetNumber" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetAddress.streetName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetAddress?.streetName}" maxlength="32" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.streetName" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetAddress?.placeNameOrService}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.placeNameOrService" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetAddress.placeNameOrService" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetAddress.postalCode') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetAddress?.postalCode}" size="5" maxlength="5" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.postalCode" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetAddress.city') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetAddress?.city}" maxlength="32" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.city" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetAddress.countryName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetAddress?.countryName}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetAddress.countryName" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetAddress.countryName" />
            </div>
            

  
    <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryName" class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryName" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetBeneficiaryName" value="${currentCollectionItem?.dhrNotRealAssetBeneficiaryName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetBeneficiaryName') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.validationError" />"  maxlength="38" />
            

  
    <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryFirstName" class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryFirstName" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetBeneficiaryFirstName" value="${currentCollectionItem?.dhrNotRealAssetBeneficiaryFirstName?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetBeneficiaryFirstName') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.validationError" />"  maxlength="38" />
            

  
    <label class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.help" /></span></label>
            <div class="address required  ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetBeneficiaryAddress') ? 'validation-failed' : ''}">
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetBeneficiaryAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation" />  
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetBeneficiaryAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetBeneficiaryAddress.streetNumber') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetBeneficiaryAddress?.streetNumber}" size="5" maxlength="5" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.streetNumber" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetBeneficiaryAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetBeneficiaryAddress.streetName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetBeneficiaryAddress?.streetName}" maxlength="32" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.streetName" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetBeneficiaryAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetBeneficiaryAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetBeneficiaryAddress?.placeNameOrService}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.placeNameOrService" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetBeneficiaryAddress.placeNameOrService" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetBeneficiaryAddress.postalCode') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetBeneficiaryAddress?.postalCode}" size="5" maxlength="5" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.postalCode" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetBeneficiaryAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetBeneficiaryAddress.city') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetBeneficiaryAddress?.city}" maxlength="32" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.city" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetBeneficiaryAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetBeneficiaryAddress.countryName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetBeneficiaryAddress?.countryName}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetBeneficiaryAddress.countryName" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetBeneficiaryAddress.countryName" />
            </div>
            

  
    <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetValue" class="required"><g:message code="dhr.property.dhrNotRealAssetValue.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetValue.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetValue" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetValue" value="${currentCollectionItem?.dhrNotRealAssetValue?.toString()}" 
                    class="required  validate-positiveInteger ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetValue') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNotRealAssetValue.validationError" />"   />
            

  
    <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetDate" class="required"><g:message code="dhr.property.dhrNotRealAssetDate.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetDate.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetDate" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetDate" value="${formatDate(formatName:'format.date',date:currentCollectionItem?.dhrNotRealAssetDate)}" 
                   class="required  validate-date ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetDate') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNotRealAssetDate.validationError" />" />
            

  
    <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryName" class="required"><g:message code="dhr.property.dhrNotRealAssetNotaryName.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetNotaryName.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryName" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetNotaryName" value="${currentCollectionItem?.dhrNotRealAssetNotaryName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetNotaryName') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNotRealAssetNotaryName.validationError" />"  maxlength="38" />
            

  
    <label class="required"><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.help" /></span></label>
            <div class="address required  ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetNotaryAddress') ? 'validation-failed' : ''}">
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetNotaryAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetNotaryAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.additionalDeliveryInformation" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetNotaryAddress.additionalDeliveryInformation" />  
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetNotaryAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetNotaryAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.additionalGeographicalInformation" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetNotaryAddress.additionalGeographicalInformation" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetNotaryAddress.streetNumber') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetNotaryAddress?.streetNumber}" size="5" maxlength="5" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.streetNumber" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetNotaryAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetNotaryAddress.streetName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetNotaryAddress?.streetName}" maxlength="32" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.streetName" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetNotaryAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetNotaryAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetNotaryAddress?.placeNameOrService}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.placeNameOrService" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetNotaryAddress.placeNameOrService" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetNotaryAddress.postalCode') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetNotaryAddress?.postalCode}" size="5" maxlength="5" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.postalCode" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetNotaryAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetNotaryAddress.city') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetNotaryAddress?.city}" maxlength="32" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.city" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetNotaryAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset['+collectionIndex+'].dhrNotRealAssetNotaryAddress.countryName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrNotRealAssetNotaryAddress?.countryName}" maxlength="38" id="dhrNotRealAsset.${collectionIndex}.dhrNotRealAssetNotaryAddress.countryName" name="dhrNotRealAsset[${collectionIndex}].dhrNotRealAssetNotaryAddress.countryName" />
            </div>
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="submit-step-resources-dhrNotRealAsset" name="submit-step-resources-dhrNotRealAsset[${collectionIndex}]" value="${message(code:'action.save')}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'resources'])}">
    ${message(code:'request.action.cancelCollectionItemEdit')}
  </a>
  
