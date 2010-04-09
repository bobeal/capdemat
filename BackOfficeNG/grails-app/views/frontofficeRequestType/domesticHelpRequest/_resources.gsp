


  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequesterIncomes.label" /></legend>
    
      <label for="pensions" class=""><g:message code="dhr.property.pensions.label" />   <span><g:message code="dhr.property.pensions.help" /></span></label>
            <input type="text" id="pensions" name="pensions" value="${rqt.pensions?.toString()}" 
                    class="  validate-positiveInteger ${invalidFields.contains('pensions') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.pensions.validationError" />"   />
            

    
      <label for="dhrAllowances" class=""><g:message code="dhr.property.dhrAllowances.label" />   <span><g:message code="dhr.property.dhrAllowances.help" /></span></label>
            <input type="text" id="dhrAllowances" name="dhrAllowances" value="${rqt.dhrAllowances?.toString()}" 
                    class="  validate-positiveInteger ${invalidFields.contains('dhrAllowances') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrAllowances.validationError" />"   />
            

    
      <label for="dhrFurnitureInvestmentIncome" class=""><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" />   <span><g:message code="dhr.property.dhrFurnitureInvestmentIncome.help" /></span></label>
            <input type="text" id="dhrFurnitureInvestmentIncome" name="dhrFurnitureInvestmentIncome" value="${rqt.dhrFurnitureInvestmentIncome?.toString()}" 
                    class="  validate-positiveInteger ${invalidFields.contains('dhrFurnitureInvestmentIncome') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrFurnitureInvestmentIncome.validationError" />"   />
            

    
      <label for="dhrRealEstateInvestmentIncome" class=""><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" />   <span><g:message code="dhr.property.dhrRealEstateInvestmentIncome.help" /></span></label>
            <input type="text" id="dhrRealEstateInvestmentIncome" name="dhrRealEstateInvestmentIncome" value="${rqt.dhrRealEstateInvestmentIncome?.toString()}" 
                    class="  validate-positiveInteger ${invalidFields.contains('dhrRealEstateInvestmentIncome') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrRealEstateInvestmentIncome.validationError" />"   />
            

    
      <label for="dhrNetIncome" class=""><g:message code="dhr.property.dhrNetIncome.label" />   <span><g:message code="dhr.property.dhrNetIncome.help" /></span></label>
            <input type="text" id="dhrNetIncome" name="dhrNetIncome" value="${rqt.dhrNetIncome?.toString()}" 
                    class="  validate-positiveInteger ${invalidFields.contains('dhrNetIncome') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNetIncome.validationError" />"   />
            

    
    </fieldset>
  

  
    <label class="required"><g:message code="dhr.property.dhrRealAsset.label" /> <span><g:message code="dhr.property.dhrRealAsset.help" /></span></label>
    <div class="collection-fieldset required validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'dhrRealAsset' ? editList?.index : ( rqt.dhrRealAsset ? rqt.dhrRealAsset.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required">
    
        <label class="required"><g:message code="dhr.property.dhrRealAssetAddress.label" /> *  <span><g:message code="dhr.property.dhrRealAssetAddress.help" /></span></label>
            <div class="address-fieldset required ">
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.additionalDeliveryInformation" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.additionalDeliveryInformation" />  
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.additionalGeographicalInformation" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.additionalGeographicalInformation" />
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.streetNumber}" size="5" maxlength="5" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.streetNumber" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.streetName}" maxlength="32" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.streetName" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.placeNameOrService}" maxlength="38" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.placeNameOrService" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.placeNameOrService" />
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.postalCode}" size="5" maxlength="5" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.postalCode" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.city}" maxlength="32" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.city" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.countryName}" maxlength="38" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.countryName" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.countryName" />
            </div>
            

    
        <label for="dhrRealAsset.${listIndex}.dhrRealAssetValue" class="required"><g:message code="dhr.property.dhrRealAssetValue.label" /> *  <span><g:message code="dhr.property.dhrRealAssetValue.help" /></span></label>
            <input type="text" id="dhrRealAsset.${listIndex}.dhrRealAssetValue" name="dhrRealAsset[${listIndex}].dhrRealAssetValue" value="${editList?.dhrRealAsset?.dhrRealAssetValue?.toString()}" 
                    class="required  validate-positiveInteger ${invalidFields.contains('dhrRealAssetValue') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrRealAssetValue.validationError" />"   />
            

    
        <label for="dhrRealAsset.${listIndex}.realAssetNetFloorArea" class="required"><g:message code="dhr.property.realAssetNetFloorArea.label" /> *  <span><g:message code="dhr.property.realAssetNetFloorArea.help" /></span></label>
            <input type="text" id="dhrRealAsset.${listIndex}.realAssetNetFloorArea" name="dhrRealAsset[${listIndex}].realAssetNetFloorArea" value="${editList?.dhrRealAsset?.realAssetNetFloorArea?.toString()}" 
                    class="required  validate-positiveInteger ${invalidFields.contains('realAssetNetFloorArea') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.realAssetNetFloorArea.validationError" />"   />
            

    
        <g:if test="${editList?.name == 'dhrRealAsset'}">
          <input type="submit" id="submit-collectionModify-resources-dhrRealAsset" name="submit-collectionModify-resources-dhrRealAsset[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-resources-dhrRealAsset" name="submit-collectionAdd-resources-dhrRealAsset[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.dhrRealAsset}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="dhr.property.dhrRealAssetAddress.label" /></dt>
        
              <g:if test="${it.dhrRealAssetAddress}">
                <dd>
                  <p>${it.dhrRealAssetAddress?.additionalDeliveryInformation}</p>
                  <p>${it.dhrRealAssetAddress?.additionalGeographicalInformation}</p>
                  <p>${it.dhrRealAssetAddress?.streetNumber} ${it.dhrRealAssetAddress?.streetName}</p>
                  <p>${it.dhrRealAssetAddress?.placeNameOrService}</p>
                  <p>${it.dhrRealAssetAddress?.postalCode} ${it.dhrRealAssetAddress?.city}</p>
                  <p>${it.dhrRealAssetAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="dhr.property.dhrRealAssetValue.label" /></dt>
        <dd>${it.dhrRealAssetValue?.toString()}</dd>
    
        <dt><g:message code="dhr.property.realAssetNetFloorArea.label" /></dt>
        <dd>${it.realAssetNetFloorArea?.toString()}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-resources-dhrRealAsset[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-resources-dhrRealAsset[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

  
    <label class="required"><g:message code="dhr.property.dhrNotRealAsset.label" /> <span><g:message code="dhr.property.dhrNotRealAsset.help" /></span></label>
    <div class="collection-fieldset required validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'dhrNotRealAsset' ? editList?.index : ( rqt.dhrNotRealAsset ? rqt.dhrNotRealAsset.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required">
    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetType.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetType.help" /></span></label>
            <ul class="required ${invalidFields.contains('dhrNotRealAssetType') ? 'validation-failed' : ''}">
              <g:each in="${['Share','Gift','Sale']}">
              <li>
                <input type="radio" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetType_${it}" class="required  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrAssetTypeType_${it}" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetType" ${it == editList?.dhrNotRealAsset?.dhrNotRealAssetType.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrNotRealAssetType.validationError" />" />
                <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetType_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrNotRealAssetType" /></label>
              </li>
              </g:each>
            </ul>
            

    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetKind.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetKind.help" /></span></label>
            <ul class="required ${invalidFields.contains('dhrNotRealAssetKind') ? 'validation-failed' : ''}">
              <g:each in="${['RealEstate','Other']}">
              <li>
                <input type="radio" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetKind_${it}" class="required condition-isRealEstate-trigger  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrAssetKindType_${it}" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetKind" ${it == editList?.dhrNotRealAsset?.dhrNotRealAssetKind.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrNotRealAssetKind.validationError" />" />
                <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetKind_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrNotRealAssetKind" /></label>
              </li>
              </g:each>
            </ul>
            

    
        <label class="required condition-isRealEstate-filled"><g:message code="dhr.property.dhrNotRealAssetAddress.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetAddress.help" /></span></label>
            <div class="address-fieldset required condition-isRealEstate-filled ">
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.additionalDeliveryInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.additionalDeliveryInformation" />  
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.additionalGeographicalInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.additionalGeographicalInformation" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.streetNumber}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.streetNumber" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.streetName}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.streetName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.placeNameOrService}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.placeNameOrService" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.placeNameOrService" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.postalCode}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.postalCode" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.city}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.city" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.countryName}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.countryName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.countryName" />
            </div>
            

    
        <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryName" class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryName" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryName?.toString()}" 
                    class="required  validate-lastName ${invalidFields.contains('dhrNotRealAssetBeneficiaryName') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.validationError" />"  maxlength="38" />
            

    
        <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryFirstName" class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryFirstName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryFirstName" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryFirstName?.toString()}" 
                    class="required  validate-firstName ${invalidFields.contains('dhrNotRealAssetBeneficiaryFirstName') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.help" /></span></label>
            <div class="address-fieldset required ">
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation" />  
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.streetNumber}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.streetNumber" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.streetName}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.streetName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.placeNameOrService}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.placeNameOrService" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.placeNameOrService" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.postalCode}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.postalCode" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.city}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.city" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.countryName}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.countryName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.countryName" />
            </div>
            

    
        <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetValue" class="required"><g:message code="dhr.property.dhrNotRealAssetValue.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetValue.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetValue" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetValue" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetValue?.toString()}" 
                    class="required  validate-positiveInteger ${invalidFields.contains('dhrNotRealAssetValue') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNotRealAssetValue.validationError" />"   />
            

    
        <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetDate" class="required"><g:message code="dhr.property.dhrNotRealAssetDate.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetDate.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetDate" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetDate" value="${formatDate(formatName:'format.date',date:editList?.dhrNotRealAsset?.dhrNotRealAssetDate)}" 
                   class="required  validate-date ${invalidFields.contains('dhrNotRealAssetDate') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNotRealAssetDate.validationError" />" />
            

    
        <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryName" class="required"><g:message code="dhr.property.dhrNotRealAssetNotaryName.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetNotaryName.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryName" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryName?.toString()}" 
                    class="required  validate-lastName ${invalidFields.contains('dhrNotRealAssetNotaryName') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNotRealAssetNotaryName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.help" /></span></label>
            <div class="address-fieldset required ">
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.additionalDeliveryInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.additionalDeliveryInformation" />  
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.additionalGeographicalInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.additionalGeographicalInformation" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.streetNumber}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.streetNumber" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.streetName}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.streetName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.placeNameOrService}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.placeNameOrService" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.placeNameOrService" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.postalCode}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.postalCode" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.city}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.city" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.countryName}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.countryName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.countryName" />
            </div>
            

    
        <g:if test="${editList?.name == 'dhrNotRealAsset'}">
          <input type="submit" id="submit-collectionModify-resources-dhrNotRealAsset" name="submit-collectionModify-resources-dhrNotRealAsset[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-resources-dhrNotRealAsset" name="submit-collectionAdd-resources-dhrNotRealAsset[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.dhrNotRealAsset}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetType.label" /></dt>
        
              <dd>
                <g:if test="${it.dhrNotRealAssetType}">
                  <g:capdematEnumToField var="${it.dhrNotRealAssetType}" i18nKeyPrefix="dhr.property.dhrNotRealAssetType" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="dhr.property.dhrNotRealAssetKind.label" /></dt>
        
              <dd>
                <g:if test="${it.dhrNotRealAssetKind}">
                  <g:capdematEnumToField var="${it.dhrNotRealAssetKind}" i18nKeyPrefix="dhr.property.dhrNotRealAssetKind" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="dhr.property.dhrNotRealAssetAddress.label" /></dt>
        
              <g:if test="${it.dhrNotRealAssetAddress}">
                <dd>
                  <p>${it.dhrNotRealAssetAddress?.additionalDeliveryInformation}</p>
                  <p>${it.dhrNotRealAssetAddress?.additionalGeographicalInformation}</p>
                  <p>${it.dhrNotRealAssetAddress?.streetNumber} ${it.dhrNotRealAssetAddress?.streetName}</p>
                  <p>${it.dhrNotRealAssetAddress?.placeNameOrService}</p>
                  <p>${it.dhrNotRealAssetAddress?.postalCode} ${it.dhrNotRealAssetAddress?.city}</p>
                  <p>${it.dhrNotRealAssetAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.label" /></dt>
        <dd>${it.dhrNotRealAssetBeneficiaryName?.toString()}</dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.label" /></dt>
        <dd>${it.dhrNotRealAssetBeneficiaryFirstName?.toString()}</dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.label" /></dt>
        
              <g:if test="${it.dhrNotRealAssetBeneficiaryAddress}">
                <dd>
                  <p>${it.dhrNotRealAssetBeneficiaryAddress?.additionalDeliveryInformation}</p>
                  <p>${it.dhrNotRealAssetBeneficiaryAddress?.additionalGeographicalInformation}</p>
                  <p>${it.dhrNotRealAssetBeneficiaryAddress?.streetNumber} ${it.dhrNotRealAssetBeneficiaryAddress?.streetName}</p>
                  <p>${it.dhrNotRealAssetBeneficiaryAddress?.placeNameOrService}</p>
                  <p>${it.dhrNotRealAssetBeneficiaryAddress?.postalCode} ${it.dhrNotRealAssetBeneficiaryAddress?.city}</p>
                  <p>${it.dhrNotRealAssetBeneficiaryAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="dhr.property.dhrNotRealAssetValue.label" /></dt>
        <dd>${it.dhrNotRealAssetValue?.toString()}</dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetDate.label" /></dt>
        <dd><g:formatDate formatName="format.date" date="${it.dhrNotRealAssetDate}"/></dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetNotaryName.label" /></dt>
        <dd>${it.dhrNotRealAssetNotaryName?.toString()}</dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.label" /></dt>
        
              <g:if test="${it.dhrNotRealAssetNotaryAddress}">
                <dd>
                  <p>${it.dhrNotRealAssetNotaryAddress?.additionalDeliveryInformation}</p>
                  <p>${it.dhrNotRealAssetNotaryAddress?.additionalGeographicalInformation}</p>
                  <p>${it.dhrNotRealAssetNotaryAddress?.streetNumber} ${it.dhrNotRealAssetNotaryAddress?.streetName}</p>
                  <p>${it.dhrNotRealAssetNotaryAddress?.placeNameOrService}</p>
                  <p>${it.dhrNotRealAssetNotaryAddress?.postalCode} ${it.dhrNotRealAssetNotaryAddress?.city}</p>
                  <p>${it.dhrNotRealAssetNotaryAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-resources-dhrNotRealAsset[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-resources-dhrNotRealAsset[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

