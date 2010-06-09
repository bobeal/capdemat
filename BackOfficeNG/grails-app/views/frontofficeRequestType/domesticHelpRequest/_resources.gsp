


  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequesterIncomes.label" /></legend>
    
      <label for="pensions" class=""><g:message code="dhr.property.pensions.label" />   <span><g:message code="dhr.property.pensions.help" /></span></label>
            <input type="text" id="pensions" name="pensions" value="${rqt.pensions?.toString()}" 
                    class="  validate-positiveInteger ${rqt.stepStates['resources'].invalidFields.contains('pensions') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.pensions.validationError" />"   />
            

    
      <label for="dhrAllowances" class=""><g:message code="dhr.property.dhrAllowances.label" />   <span><g:message code="dhr.property.dhrAllowances.help" /></span></label>
            <input type="text" id="dhrAllowances" name="dhrAllowances" value="${rqt.dhrAllowances?.toString()}" 
                    class="  validate-positiveInteger ${rqt.stepStates['resources'].invalidFields.contains('dhrAllowances') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrAllowances.validationError" />"   />
            

    
      <label for="dhrFurnitureInvestmentIncome" class=""><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" />   <span><g:message code="dhr.property.dhrFurnitureInvestmentIncome.help" /></span></label>
            <input type="text" id="dhrFurnitureInvestmentIncome" name="dhrFurnitureInvestmentIncome" value="${rqt.dhrFurnitureInvestmentIncome?.toString()}" 
                    class="  validate-positiveInteger ${rqt.stepStates['resources'].invalidFields.contains('dhrFurnitureInvestmentIncome') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrFurnitureInvestmentIncome.validationError" />"   />
            

    
      <label for="dhrRealEstateInvestmentIncome" class=""><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" />   <span><g:message code="dhr.property.dhrRealEstateInvestmentIncome.help" /></span></label>
            <input type="text" id="dhrRealEstateInvestmentIncome" name="dhrRealEstateInvestmentIncome" value="${rqt.dhrRealEstateInvestmentIncome?.toString()}" 
                    class="  validate-positiveInteger ${rqt.stepStates['resources'].invalidFields.contains('dhrRealEstateInvestmentIncome') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrRealEstateInvestmentIncome.validationError" />"   />
            

    
      <label for="dhrNetIncome" class=""><g:message code="dhr.property.dhrNetIncome.label" />   <span><g:message code="dhr.property.dhrNetIncome.help" /></span></label>
            <input type="text" id="dhrNetIncome" name="dhrNetIncome" value="${rqt.dhrNetIncome?.toString()}" 
                    class="  validate-positiveInteger ${rqt.stepStates['resources'].invalidFields.contains('dhrNetIncome') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNetIncome.validationError" />"   />
            

    
    </fieldset>
  

  
    <label class="required"><g:message code="dhr.property.dhrRealAsset.label" /> <span><g:message code="dhr.property.dhrRealAsset.help" /></span></label>
    <div class="collection-fieldset required summary-box">
    <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrRealAsset', 'collectionIndex':(rqt.dhrRealAsset ? rqt.dhrRealAsset.size() : 0)])}" />
      ${message(code:'request.action.newCollectionItem')}
    </a>
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
         <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrRealAsset', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrRealAsset', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
      </fieldset>
    </g:each>
    </div>
  

  
    <label class="required"><g:message code="dhr.property.dhrNotRealAsset.label" /> <span><g:message code="dhr.property.dhrNotRealAsset.help" /></span></label>
    <div class="collection-fieldset required summary-box">
    <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrNotRealAsset', 'collectionIndex':(rqt.dhrNotRealAsset ? rqt.dhrNotRealAsset.size() : 0)])}" />
      ${message(code:'request.action.newCollectionItem')}
    </a>
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
         <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrNotRealAsset', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrNotRealAsset', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
      </fieldset>
    </g:each>
    </div>
  

