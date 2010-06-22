


  
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
  

  
    <div class="collection required summary-box">
      <h4 class="required"><g:message code="dhr.property.dhrRealAsset.label" /> 
        <span><g:message code="dhr.property.dhrRealAsset.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrRealAsset', 'collectionIndex':(rqt.dhrRealAsset ? rqt.dhrRealAsset.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.dhrRealAsset}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="dhr.property.dhrRealAsset.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrRealAsset', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrRealAsset', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="dhr.property.dhrRealAssetAddress.label" /></dt>
        
              <g:if test="${it.dhrRealAssetAddress}">
                <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset[' + index + '].dhrRealAssetAddress') ? 'validation-failed' : ''}">
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset[' + index + '].dhrRealAssetAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}">${it.dhrRealAssetAddress?.additionalDeliveryInformation}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset[' + index + '].dhrRealAssetAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}">${it.dhrRealAssetAddress?.additionalGeographicalInformation}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset[' + index + '].dhrRealAssetAddress.streetNumber') || rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset[' + index + '].dhrRealAssetAddress.streetName') ? 'validation-failed' : ''}">${it.dhrRealAssetAddress?.streetNumber} ${it.dhrRealAssetAddress?.streetName}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset[' + index + '].dhrRealAssetAddress.placeNameOrService') ? 'validation-failed' : ''}">${it.dhrRealAssetAddress?.placeNameOrService}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset[' + index + '].dhrRealAssetAddress.postalCode') || rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset[' + index + '].dhrRealAssetAddress.city') ? 'validation-failed' : ''}">${it.dhrRealAssetAddress?.postalCode} ${it.dhrRealAssetAddress?.city}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset[' + index + '].dhrRealAssetAddress.countryName') ? 'validation-failed' : ''}">${it.dhrRealAssetAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="dhr.property.dhrRealAssetValue.label" /></dt>
        <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset[' + index + '].dhrRealAssetValue') ? 'validation-failed' : ''}">${it.dhrRealAssetValue?.toString()}</dd>
    
        <dt><g:message code="dhr.property.realAssetNetFloorArea.label" /></dt>
        <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrRealAsset[' + index + '].realAssetNetFloorArea') ? 'validation-failed' : ''}">${it.realAssetNetFloorArea?.toString()}</dd>
    
        </dl>
      </div>
    </g:each>
    </div>
  

  
    <div class="collection required summary-box">
      <h4 class="required"><g:message code="dhr.property.dhrNotRealAsset.label" /> 
        <span><g:message code="dhr.property.dhrNotRealAsset.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrNotRealAsset', 'collectionIndex':(rqt.dhrNotRealAsset ? rqt.dhrNotRealAsset.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.dhrNotRealAsset}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="dhr.property.dhrNotRealAsset.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrNotRealAsset', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'resources', 'currentCollection':'dhrNotRealAsset', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetType.label" /></dt>
        
              <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetType') ? 'validation-failed' : ''}">
                <g:if test="${it.dhrNotRealAssetType}">
                  <g:capdematEnumToField var="${it.dhrNotRealAssetType}" i18nKeyPrefix="dhr.property.dhrNotRealAssetType" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="dhr.property.dhrNotRealAssetKind.label" /></dt>
        
              <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetKind') ? 'validation-failed' : ''}">
                <g:if test="${it.dhrNotRealAssetKind}">
                  <g:capdematEnumToField var="${it.dhrNotRealAssetKind}" i18nKeyPrefix="dhr.property.dhrNotRealAssetKind" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="dhr.property.dhrNotRealAssetAddress.label" /></dt>
        
              <g:if test="${it.dhrNotRealAssetAddress}">
                <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetAddress') ? 'validation-failed' : ''}">
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}">${it.dhrNotRealAssetAddress?.additionalDeliveryInformation}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}">${it.dhrNotRealAssetAddress?.additionalGeographicalInformation}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetAddress.streetNumber') || rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetAddress.streetName') ? 'validation-failed' : ''}">${it.dhrNotRealAssetAddress?.streetNumber} ${it.dhrNotRealAssetAddress?.streetName}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetAddress.placeNameOrService') ? 'validation-failed' : ''}">${it.dhrNotRealAssetAddress?.placeNameOrService}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetAddress.postalCode') || rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetAddress.city') ? 'validation-failed' : ''}">${it.dhrNotRealAssetAddress?.postalCode} ${it.dhrNotRealAssetAddress?.city}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetAddress.countryName') ? 'validation-failed' : ''}">${it.dhrNotRealAssetAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.label" /></dt>
        <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetBeneficiaryName') ? 'validation-failed' : ''}">${it.dhrNotRealAssetBeneficiaryName?.toString()}</dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.label" /></dt>
        <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetBeneficiaryFirstName') ? 'validation-failed' : ''}">${it.dhrNotRealAssetBeneficiaryFirstName?.toString()}</dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.label" /></dt>
        
              <g:if test="${it.dhrNotRealAssetBeneficiaryAddress}">
                <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetBeneficiaryAddress') ? 'validation-failed' : ''}">
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}">${it.dhrNotRealAssetBeneficiaryAddress?.additionalDeliveryInformation}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}">${it.dhrNotRealAssetBeneficiaryAddress?.additionalGeographicalInformation}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetBeneficiaryAddress.streetNumber') || rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetBeneficiaryAddress.streetName') ? 'validation-failed' : ''}">${it.dhrNotRealAssetBeneficiaryAddress?.streetNumber} ${it.dhrNotRealAssetBeneficiaryAddress?.streetName}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetBeneficiaryAddress.placeNameOrService') ? 'validation-failed' : ''}">${it.dhrNotRealAssetBeneficiaryAddress?.placeNameOrService}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetBeneficiaryAddress.postalCode') || rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetBeneficiaryAddress.city') ? 'validation-failed' : ''}">${it.dhrNotRealAssetBeneficiaryAddress?.postalCode} ${it.dhrNotRealAssetBeneficiaryAddress?.city}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetBeneficiaryAddress.countryName') ? 'validation-failed' : ''}">${it.dhrNotRealAssetBeneficiaryAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="dhr.property.dhrNotRealAssetValue.label" /></dt>
        <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetValue') ? 'validation-failed' : ''}">${it.dhrNotRealAssetValue?.toString()}</dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetDate.label" /></dt>
        <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetDate') ? 'validation-failed' : ''}"><g:formatDate formatName="format.date" date="${it.dhrNotRealAssetDate}"/></dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetNotaryName.label" /></dt>
        <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetNotaryName') ? 'validation-failed' : ''}">${it.dhrNotRealAssetNotaryName?.toString()}</dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.label" /></dt>
        
              <g:if test="${it.dhrNotRealAssetNotaryAddress}">
                <dd class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetNotaryAddress') ? 'validation-failed' : ''}">
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetNotaryAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}">${it.dhrNotRealAssetNotaryAddress?.additionalDeliveryInformation}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetNotaryAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}">${it.dhrNotRealAssetNotaryAddress?.additionalGeographicalInformation}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetNotaryAddress.streetNumber') || rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetNotaryAddress.streetName') ? 'validation-failed' : ''}">${it.dhrNotRealAssetNotaryAddress?.streetNumber} ${it.dhrNotRealAssetNotaryAddress?.streetName}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetNotaryAddress.placeNameOrService') ? 'validation-failed' : ''}">${it.dhrNotRealAssetNotaryAddress?.placeNameOrService}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetNotaryAddress.postalCode') || rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetNotaryAddress.city') ? 'validation-failed' : ''}">${it.dhrNotRealAssetNotaryAddress?.postalCode} ${it.dhrNotRealAssetNotaryAddress?.city}</p>
                  <p class="${rqt.stepStates['resources'].invalidFields.contains('dhrNotRealAsset[' + index + '].dhrNotRealAssetNotaryAddress.countryName') ? 'validation-failed' : ''}">${it.dhrNotRealAssetNotaryAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        </dl>
      </div>
    </g:each>
    </div>
  

