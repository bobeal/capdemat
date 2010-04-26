


  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequesterIncomes.label" /></legend>
    
      <label for="pensions" class=""><g:message code="dhr.property.pensions.label" />   <span><g:message code="dhr.property.pensions.help" /></span></label>
            <input type="text" id="pensions" name="pensions" value="${rqt.pensions?.toString()}" 
                    class="  validate-positiveInteger" title="<g:message code="dhr.property.pensions.validationError" />"   />
            

    
      <label for="dhrAllowances" class=""><g:message code="dhr.property.dhrAllowances.label" />   <span><g:message code="dhr.property.dhrAllowances.help" /></span></label>
            <input type="text" id="dhrAllowances" name="dhrAllowances" value="${rqt.dhrAllowances?.toString()}" 
                    class="  validate-positiveInteger" title="<g:message code="dhr.property.dhrAllowances.validationError" />"   />
            

    
      <label for="dhrFurnitureInvestmentIncome" class=""><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" />   <span><g:message code="dhr.property.dhrFurnitureInvestmentIncome.help" /></span></label>
            <input type="text" id="dhrFurnitureInvestmentIncome" name="dhrFurnitureInvestmentIncome" value="${rqt.dhrFurnitureInvestmentIncome?.toString()}" 
                    class="  validate-positiveInteger" title="<g:message code="dhr.property.dhrFurnitureInvestmentIncome.validationError" />"   />
            

    
      <label for="dhrRealEstateInvestmentIncome" class=""><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" />   <span><g:message code="dhr.property.dhrRealEstateInvestmentIncome.help" /></span></label>
            <input type="text" id="dhrRealEstateInvestmentIncome" name="dhrRealEstateInvestmentIncome" value="${rqt.dhrRealEstateInvestmentIncome?.toString()}" 
                    class="  validate-positiveInteger" title="<g:message code="dhr.property.dhrRealEstateInvestmentIncome.validationError" />"   />
            

    
      <label for="dhrNetIncome" class=""><g:message code="dhr.property.dhrNetIncome.label" />   <span><g:message code="dhr.property.dhrNetIncome.help" /></span></label>
            <input type="text" id="dhrNetIncome" name="dhrNetIncome" value="${rqt.dhrNetIncome?.toString()}" 
                    class="  validate-positiveInteger" title="<g:message code="dhr.property.dhrNetIncome.validationError" />"   />
            

    
    </fieldset>
  

  
    <div class="collection required">
    <h3>
      <g:message code="dhr.property.dhrRealAsset.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="dhr.property.dhrRealAsset.help" /></span>
      <button type="submit" name="submit-collectionAdd-resources-dhrRealAsset">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.dhrRealAsset}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="dhr.property.dhrRealAsset.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-resources-dhrRealAsset[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label class="required"><g:message code="dhr.property.dhrRealAssetAddress.label" /> *  <span><g:message code="dhr.property.dhrRealAssetAddress.help" /></span></label>
            <div class="address-fieldset required ">
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrRealAssetAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.additionalDeliveryInformation" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.additionalDeliveryInformation" />  
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrRealAssetAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.additionalGeographicalInformation" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.additionalGeographicalInformation" />
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${listItem?.dhrRealAssetAddress?.streetNumber}" size="5" maxlength="5" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.streetNumber" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${listItem?.dhrRealAssetAddress?.streetName}" maxlength="32" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.streetName" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrRealAssetAddress?.placeNameOrService}" maxlength="38" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.placeNameOrService" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.placeNameOrService" />
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${listItem?.dhrRealAssetAddress?.postalCode}" size="5" maxlength="5" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.postalCode" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${listItem?.dhrRealAssetAddress?.city}" maxlength="32" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.city" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrRealAsset.${listIndex}.dhrRealAssetAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrRealAssetAddress?.countryName}" maxlength="38" id="dhrRealAsset.${listIndex}.dhrRealAssetAddress.countryName" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.countryName" />
            </div>
            

        
          <label for="dhrRealAsset.${listIndex}.dhrRealAssetValue" class="required"><g:message code="dhr.property.dhrRealAssetValue.label" /> *  <span><g:message code="dhr.property.dhrRealAssetValue.help" /></span></label>
            <input type="text" id="dhrRealAsset.${listIndex}.dhrRealAssetValue" name="dhrRealAsset[${listIndex}].dhrRealAssetValue" value="${listItem?.dhrRealAssetValue?.toString()}" 
                    class="required  validate-positiveInteger" title="<g:message code="dhr.property.dhrRealAssetValue.validationError" />"   />
            

        
          <label for="dhrRealAsset.${listIndex}.realAssetNetFloorArea" class="required"><g:message code="dhr.property.realAssetNetFloorArea.label" /> *  <span><g:message code="dhr.property.realAssetNetFloorArea.help" /></span></label>
            <input type="text" id="dhrRealAsset.${listIndex}.realAssetNetFloorArea" name="dhrRealAsset[${listIndex}].realAssetNetFloorArea" value="${listItem?.realAssetNetFloorArea?.toString()}" 
                    class="required  validate-positiveInteger" title="<g:message code="dhr.property.realAssetNetFloorArea.validationError" />"   />
            

        
      </fieldset>
    </g:each>
    </div>
  

  
    <div class="collection required">
    <h3>
      <g:message code="dhr.property.dhrNotRealAsset.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="dhr.property.dhrNotRealAsset.help" /></span>
      <button type="submit" name="submit-collectionAdd-resources-dhrNotRealAsset">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.dhrNotRealAsset}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="dhr.property.dhrNotRealAsset.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-resources-dhrNotRealAsset[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label class="required"><g:message code="dhr.property.dhrNotRealAssetType.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetType.help" /></span></label>
            <ul class="required">
              <g:each in="${['Share','Gift','Sale']}">
              <li>
                <input type="radio" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetType_${it}" class="required  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrAssetTypeType_${it}" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetType" ${it == listItem?.dhrNotRealAssetType.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrNotRealAssetType.validationError" />" />
                <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetType_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrNotRealAssetType" /></label>
              </li>
              </g:each>
            </ul>
            

        
          <label class="required"><g:message code="dhr.property.dhrNotRealAssetKind.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetKind.help" /></span></label>
            <ul class="required">
              <g:each in="${['RealEstate','Other']}">
              <li>
                <input type="radio" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetKind_${it}" class="required condition-isRealEstate-trigger  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrAssetKindType_${it}" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetKind" ${it == listItem?.dhrNotRealAssetKind.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrNotRealAssetKind.validationError" />" />
                <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetKind_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrNotRealAssetKind" /></label>
              </li>
              </g:each>
            </ul>
            

        
          <label class="required condition-isRealEstate-filled"><g:message code="dhr.property.dhrNotRealAssetAddress.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetAddress.help" /></span></label>
            <div class="address-fieldset required condition-isRealEstate-filled ">
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.additionalDeliveryInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.additionalDeliveryInformation" />  
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.additionalGeographicalInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.additionalGeographicalInformation" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${listItem?.dhrNotRealAssetAddress?.streetNumber}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.streetNumber" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${listItem?.dhrNotRealAssetAddress?.streetName}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.streetName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetAddress?.placeNameOrService}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.placeNameOrService" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.placeNameOrService" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${listItem?.dhrNotRealAssetAddress?.postalCode}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.postalCode" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${listItem?.dhrNotRealAssetAddress?.city}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.city" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetAddress?.countryName}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetAddress.countryName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.countryName" />
            </div>
            

        
          <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryName" class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryName" value="${listItem?.dhrNotRealAssetBeneficiaryName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.validationError" />"  maxlength="38" />
            

        
          <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryFirstName" class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryFirstName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryFirstName" value="${listItem?.dhrNotRealAssetBeneficiaryFirstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.validationError" />"  maxlength="38" />
            

        
          <label class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.help" /></span></label>
            <div class="address-fieldset required ">
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetBeneficiaryAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation" />  
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetBeneficiaryAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${listItem?.dhrNotRealAssetBeneficiaryAddress?.streetNumber}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.streetNumber" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${listItem?.dhrNotRealAssetBeneficiaryAddress?.streetName}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.streetName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetBeneficiaryAddress?.placeNameOrService}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.placeNameOrService" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.placeNameOrService" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${listItem?.dhrNotRealAssetBeneficiaryAddress?.postalCode}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.postalCode" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${listItem?.dhrNotRealAssetBeneficiaryAddress?.city}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.city" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetBeneficiaryAddress?.countryName}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetBeneficiaryAddress.countryName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.countryName" />
            </div>
            

        
          <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetValue" class="required"><g:message code="dhr.property.dhrNotRealAssetValue.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetValue.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetValue" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetValue" value="${listItem?.dhrNotRealAssetValue?.toString()}" 
                    class="required  validate-positiveInteger" title="<g:message code="dhr.property.dhrNotRealAssetValue.validationError" />"   />
            

        
          <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetDate" class="required"><g:message code="dhr.property.dhrNotRealAssetDate.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetDate.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetDate" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetDate" value="${formatDate(formatName:'format.date',date:listItem?.dhrNotRealAssetDate)}" 
                   class="required  validate-date" title="<g:message code="dhr.property.dhrNotRealAssetDate.validationError" />" />
            

        
          <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryName" class="required"><g:message code="dhr.property.dhrNotRealAssetNotaryName.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetNotaryName.help" /></span></label>
            <input type="text" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryName" value="${listItem?.dhrNotRealAssetNotaryName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="dhr.property.dhrNotRealAssetNotaryName.validationError" />"  maxlength="38" />
            

        
          <label class="required"><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.label" /> *  <span><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.help" /></span></label>
            <div class="address-fieldset required ">
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetNotaryAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.additionalDeliveryInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.additionalDeliveryInformation" />  
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetNotaryAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.additionalGeographicalInformation" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.additionalGeographicalInformation" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${listItem?.dhrNotRealAssetNotaryAddress?.streetNumber}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.streetNumber" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${listItem?.dhrNotRealAssetNotaryAddress?.streetName}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.streetName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetNotaryAddress?.placeNameOrService}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.placeNameOrService" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.placeNameOrService" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${listItem?.dhrNotRealAssetNotaryAddress?.postalCode}" size="5" maxlength="5" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.postalCode" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${listItem?.dhrNotRealAssetNotaryAddress?.city}" maxlength="32" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.city" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrNotRealAssetNotaryAddress?.countryName}" maxlength="38" id="dhrNotRealAsset.${listIndex}.dhrNotRealAssetNotaryAddress.countryName" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.countryName" />
            </div>
            

        
      </fieldset>
    </g:each>
    </div>
  

