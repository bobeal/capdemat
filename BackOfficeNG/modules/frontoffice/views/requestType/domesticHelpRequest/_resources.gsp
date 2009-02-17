




  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequesterIncomes.label" /></legend> 
      
    
      <label class=""><g:message code="dhr.property.pensions.label" /> <span><g:message code="dhr.property.pensions.help" /></span></label>
      
            <input name="pensions" value="${rqt.pensions}" 
                    class=" validate-positiveInteger" title="<g:message code="dhr.property.pensions.validationError" />">
            
    
      <label class=""><g:message code="dhr.property.dhrAllowances.label" /> <span><g:message code="dhr.property.dhrAllowances.help" /></span></label>
      
            <input name="dhrAllowances" value="${rqt.dhrAllowances}" 
                    class=" validate-positiveInteger" title="<g:message code="dhr.property.dhrAllowances.validationError" />">
            
    
      <label class=""><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" /> <span><g:message code="dhr.property.dhrFurnitureInvestmentIncome.help" /></span></label>
      
            <input name="dhrFurnitureInvestmentIncome" value="${rqt.dhrFurnitureInvestmentIncome}" 
                    class=" validate-positiveInteger" title="<g:message code="dhr.property.dhrFurnitureInvestmentIncome.validationError" />">
            
    
      <label class=""><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" /> <span><g:message code="dhr.property.dhrRealEstateInvestmentIncome.help" /></span></label>
      
            <input name="dhrRealEstateInvestmentIncome" value="${rqt.dhrRealEstateInvestmentIncome}" 
                    class=" validate-positiveInteger" title="<g:message code="dhr.property.dhrRealEstateInvestmentIncome.validationError" />">
            
    
      <label class=""><g:message code="dhr.property.dhrNetIncome.label" /> <span><g:message code="dhr.property.dhrNetIncome.help" /></span></label>
      
            <input name="dhrNetIncome" value="${rqt.dhrNetIncome}" 
                    class=" validate-positiveInteger" title="<g:message code="dhr.property.dhrNetIncome.validationError" />">
            
    
    </fieldset>
  

  
    <label class="required"><g:message code="dhr.property.dhrRealAsset.label" /> <span><g:message code="dhr.property.dhrRealAsset.help" /></span></label>
    <div class="collection-fieldset required validation-scope">
      <!--<h4><g:message code="dhr.property.dhrRealAsset.label" /></h4>-->
      <g:set var="listIndex" value="${editList?.name == 'dhrRealAsset' ? editList?.index : ( rqt.dhrRealAsset ? rqt.dhrRealAsset.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required">
    
        <label class="required"><g:message code="dhr.property.dhrRealAssetAddress.label" /> <span><g:message code="dhr.property.dhrRealAssetAddress.help" /></span></label>
        
            <div class="address-fieldset required">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.additionalDeliveryInformation}" maxlength="38" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.additionalGeographicalInformation}" maxlength="38" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /></strong></label>
            <input type="text" class="line1" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.streetNumber}" maxlength="5" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.streetName}" maxlength="32" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.placeNameOrService}" maxlength="38" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
            <input type="text" class="line1 required" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.postalCode}" maxlength="5" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.city}" maxlength="32" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${editList?.dhrRealAsset?.dhrRealAssetAddress?.countryName}" maxlength="38" name="dhrRealAsset[${listIndex}].dhrRealAssetAddress.countryName"/>
            </div>
            
    
        <label class="required"><g:message code="dhr.property.dhrRealAssetValue.label" /> <span><g:message code="dhr.property.dhrRealAssetValue.help" /></span></label>
        
            <input name="dhrRealAsset[${listIndex}].dhrRealAssetValue" value="${editList?.dhrRealAsset?.dhrRealAssetValue}" 
                    class="required validate-positiveInteger" title="<g:message code="dhr.property.dhrRealAssetValue.validationError" />">
            
    
        <label class="required"><g:message code="dhr.property.realAssetNetFloorArea.label" /> <span><g:message code="dhr.property.realAssetNetFloorArea.help" /></span></label>
        
            <input name="dhrRealAsset[${listIndex}].realAssetNetFloorArea" value="${editList?.dhrRealAsset?.realAssetNetFloorArea}" 
                    class="required validate-positiveInteger" title="<g:message code="dhr.property.realAssetNetFloorArea.validationError" />">
            
    
        <g:if test="${editList?.name == 'dhrRealAsset'}">
          <input type="submit" id="submit-modify-resources-dhrRealAsset[${listIndex}]" name="submit-modify-resources-dhrRealAsset[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-add-resources-dhrRealAsset[${listIndex}]" name="submit-add-resources-dhrRealAsset[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.dhrRealAsset}" status="index">
      <fieldset class="collection-fieldset-edit">
        <!-- <legend><g:message code="dhr.property.dhrRealAsset.label" /></legend> -->
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
        <dd>${it.dhrRealAssetValue}</dd>
    
        <dt><g:message code="dhr.property.realAssetNetFloorArea.label" /></dt>
        <dd>${it.realAssetNetFloorArea}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-edit-resources-dhrRealAsset[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-delete-resources-dhrRealAsset[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

  
    <label class="required"><g:message code="dhr.property.dhrNotRealAsset.label" /> <span><g:message code="dhr.property.dhrNotRealAsset.help" /></span></label>
    <div class="collection-fieldset required validation-scope">
      <!--<h4><g:message code="dhr.property.dhrNotRealAsset.label" /></h4>-->
      <g:set var="listIndex" value="${editList?.name == 'dhrNotRealAsset' ? editList?.index : ( rqt.dhrNotRealAsset ? rqt.dhrNotRealAsset.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required">
    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetType.label" /> <span><g:message code="dhr.property.dhrNotRealAssetType.help" /></span></label>
        
            <ul class="required">
              <g:each in="${['Share','Gift','Sale']}">
              <li>
                <input type="radio" class="required validate-one-required" value="fr.cg95.cvq.business.request.social.DhrAssetTypeType_${it}" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetType" ${it == editList?.dhrNotRealAsset?.dhrNotRealAssetType.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrNotRealAssetType.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrNotRealAssetType" />
              </li>
              </g:each>
            </ul>
            
    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetKind.label" /> <span><g:message code="dhr.property.dhrNotRealAssetKind.help" /></span></label>
        
            <ul class="required">
              <g:each in="${['RealEstate','Other']}">
              <li>
                <input type="radio" class="required condition-isRealEstate-trigger validate-one-required" value="fr.cg95.cvq.business.request.social.DhrAssetKindType_${it}" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetKind" ${it == editList?.dhrNotRealAsset?.dhrNotRealAssetKind.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrNotRealAssetKind.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrNotRealAssetKind" />
              </li>
              </g:each>
            </ul>
            
    
        <label class="required condition-isRealEstate-filled"><g:message code="dhr.property.dhrNotRealAssetAddress.label" /> <span><g:message code="dhr.property.dhrNotRealAssetAddress.help" /></span></label>
        
            <div class="address-fieldset required condition-isRealEstate-filled">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.additionalDeliveryInformation}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.additionalGeographicalInformation}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /></strong></label>
            <input type="text" class="line1" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.streetNumber}" maxlength="5" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.streetName}" maxlength="32" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.placeNameOrService}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
            <input type="text" class="line1 required" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.postalCode}" maxlength="5" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.city}" maxlength="32" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetAddress?.countryName}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetAddress.countryName"/>
            </div>
            
    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.label" /> <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.help" /></span></label>
        
            <input name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryName" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryName}" 
                    class="required validate-lastName" title="<g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.validationError" />">
            
    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.label" /> <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.help" /></span></label>
        
            <input name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryFirstName" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryFirstName}" 
                    class="required validate-firstName" title="<g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.validationError" />">
            
    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.label" /> <span><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.help" /></span></label>
        
            <div class="address-fieldset required">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.additionalDeliveryInformation}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.additionalGeographicalInformation}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /></strong></label>
            <input type="text" class="line1" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.streetNumber}" maxlength="5" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.streetName}" maxlength="32" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.placeNameOrService}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
            <input type="text" class="line1 required" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.postalCode}" maxlength="5" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.city}" maxlength="32" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetBeneficiaryAddress?.countryName}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetBeneficiaryAddress.countryName"/>
            </div>
            
    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetValue.label" /> <span><g:message code="dhr.property.dhrNotRealAssetValue.help" /></span></label>
        
            <input name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetValue" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetValue}" 
                    class="required validate-positiveInteger" title="<g:message code="dhr.property.dhrNotRealAssetValue.validationError" />">
            
    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetDate.label" /> <span><g:message code="dhr.property.dhrNotRealAssetDate.help" /></span></label>
        
            <input name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetDate" value="${formatDate(formatName:'format.date',date:editList?.dhrNotRealAsset?.dhrNotRealAssetDate)}" 
                   class="required validate-date" title="<g:message code="dhr.property.dhrNotRealAssetDate.validationError" />">
            
    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetNotaryName.label" /> <span><g:message code="dhr.property.dhrNotRealAssetNotaryName.help" /></span></label>
        
            <input name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryName" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryName}" 
                    class="required validate-lastName" title="<g:message code="dhr.property.dhrNotRealAssetNotaryName.validationError" />">
            
    
        <label class="required"><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.label" /> <span><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.help" /></span></label>
        
            <div class="address-fieldset required">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.additionalDeliveryInformation}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.additionalGeographicalInformation}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /></strong></label>
            <input type="text" class="line1" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.streetNumber}" maxlength="5" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.streetName}" maxlength="32" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.placeNameOrService}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
            <input type="text" class="line1 required" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.postalCode}" maxlength="5" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.city}" maxlength="32" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${editList?.dhrNotRealAsset?.dhrNotRealAssetNotaryAddress?.countryName}" maxlength="38" name="dhrNotRealAsset[${listIndex}].dhrNotRealAssetNotaryAddress.countryName"/>
            </div>
            
    
        <g:if test="${editList?.name == 'dhrNotRealAsset'}">
          <input type="submit" id="submit-modify-resources-dhrNotRealAsset[${listIndex}]" name="submit-modify-resources-dhrNotRealAsset[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-add-resources-dhrNotRealAsset[${listIndex}]" name="submit-add-resources-dhrNotRealAsset[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.dhrNotRealAsset}" status="index">
      <fieldset class="collection-fieldset-edit">
        <!-- <legend><g:message code="dhr.property.dhrNotRealAsset.label" /></legend> -->
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
        <dd>${it.dhrNotRealAssetBeneficiaryName}</dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.label" /></dt>
        <dd>${it.dhrNotRealAssetBeneficiaryFirstName}</dd>
    
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
        <dd>${it.dhrNotRealAssetValue}</dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetDate.label" /></dt>
        <dd><g:formatDate formatName="format.date" date="${it.dhrNotRealAssetDate}"/></dd>
    
        <dt><g:message code="dhr.property.dhrNotRealAssetNotaryName.label" /></dt>
        <dd>${it.dhrNotRealAssetNotaryName}</dd>
    
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
        <input type="submit" value="${message(code:'action.modify')}" name="submit-edit-resources-dhrNotRealAsset[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-delete-resources-dhrNotRealAsset[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

