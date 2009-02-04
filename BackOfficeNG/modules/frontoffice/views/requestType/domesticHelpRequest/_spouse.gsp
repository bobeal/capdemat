




  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrSpouse.label" /></legend> 
      
    
      <label class="required"><g:message code="dhr.property.dhrRequestKind.label" /> <span><g:message code="dhr.property.dhrRequestKind.help" /></span></label>
      
            <ul class="required">
              <g:each in="${['Individual','Couple']}">
              <li>
                <input type="radio" class="required condition-isCoupleRequest-trigger validate-one-required" value="fr.cg95.cvq.business.request.social.DhrRequestKindType_${it}" name="dhrRequestKind" ${it == rqt.dhrRequestKind.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrRequestKind.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrRequestKind" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseTitle.label" /> <span><g:message code="dhr.property.dhrSpouseTitle.help" /></span></label>
      
            <select name="dhrSpouseTitle" class="required condition-isCoupleRequest-filled condition-isSpouseMadam-trigger validate-no-first" title="<g:message code="dhr.property.dhrSpouseTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.dhrSpouseTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrSpouseTitle" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseFamilyStatus.label" /> <span><g:message code="dhr.property.dhrSpouseFamilyStatus.help" /></span></label>
      
            <select name="dhrSpouseFamilyStatus" class="required condition-isCoupleRequest-filled validate-no-first" title="<g:message code="dhr.property.dhrSpouseFamilyStatus.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
                <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == rqt.dhrSpouseFamilyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrSpouseFamilyStatus" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseName.label" /> <span><g:message code="dhr.property.dhrSpouseName.help" /></span></label>
      
            <input name="dhrSpouseName" value="${rqt.dhrSpouseName}" 
                    class="required condition-isCoupleRequest-filled validate-lastName" title="<g:message code="dhr.property.dhrSpouseName.validationError" />">
            
    
      <label class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseFirstName.label" /> <span><g:message code="dhr.property.dhrSpouseFirstName.help" /></span></label>
      
            <input name="dhrSpouseFirstName" value="${rqt.dhrSpouseFirstName}" 
                    class="required condition-isCoupleRequest-filled validate-firstName" title="<g:message code="dhr.property.dhrSpouseFirstName.validationError" />">
            
    
      <label class="required condition-isSpouseMadam-filled"><g:message code="dhr.property.dhrSpouseMaidenName.label" /> <span><g:message code="dhr.property.dhrSpouseMaidenName.help" /></span></label>
      
            <input name="dhrSpouseMaidenName" value="${rqt.dhrSpouseMaidenName}" 
                    class="required condition-isSpouseMadam-filled validate-lastName" title="<g:message code="dhr.property.dhrSpouseMaidenName.validationError" />">
            
    
      <label class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseBirthDate.label" /> <span><g:message code="dhr.property.dhrSpouseBirthDate.help" /></span></label>
      
            <input name="dhrSpouseBirthDate" value="${formatDate(formatName:'format.date',date:rqt.dhrSpouseBirthDate)}" 
                   class="required condition-isCoupleRequest-filled validate-date" title="<g:message code="dhr.property.dhrSpouseBirthDate.validationError" />">
            
    
      <label class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseBirthPlace.label" /> <span><g:message code="dhr.property.dhrSpouseBirthPlace.help" /></span></label>
      
            <input name="dhrSpouseBirthPlace" value="${rqt.dhrSpouseBirthPlace}" 
                    class="required condition-isCoupleRequest-filled validate-string" title="<g:message code="dhr.property.dhrSpouseBirthPlace.validationError" />">
            
    
      <label class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseNationality.label" /> <span><g:message code="dhr.property.dhrSpouseNationality.help" /></span></label>
      
            <select name="dhrSpouseNationality" class="required condition-isSpouseNonEuropean-trigger condition-isCoupleRequest-filled validate-no-first" title="<g:message code="dhr.property.dhrSpouseNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
                <option value="fr.cg95.cvq.business.users.NationalityType_${it}" ${it == rqt.dhrSpouseNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrSpouseNationality" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-isSpouseNonEuropean-filled"><g:message code="dhr.property.dhrSpouseFranceArrivalDate.label" /> <span><g:message code="dhr.property.dhrSpouseFranceArrivalDate.help" /></span></label>
      
            <input name="dhrSpouseFranceArrivalDate" value="${formatDate(formatName:'format.date',date:rqt.dhrSpouseFranceArrivalDate)}" 
                   class="required condition-isSpouseNonEuropean-filled validate-date" title="<g:message code="dhr.property.dhrSpouseFranceArrivalDate.validationError" />">
            
    
      <label class="required condition-isSpouseNonEuropean-filled"><g:message code="dhr.property.dhrSpouseIsFrenchResident.label" /> <span><g:message code="dhr.property.dhrSpouseIsFrenchResident.help" /></span></label>
      
            <ul class="required condition-isSpouseNonEuropean-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isSpouseNonEuropean-filled validate-boolean" title="" value="${it}" name="dhrSpouseIsFrenchResident" ${it == rqt.dhrSpouseIsFrenchResident ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
    </fieldset>
  

  
    <fieldset class="required condition-isCoupleRequest-filled">
    <legend><g:message code="dhr.property.dhrSpouseStatus.label" /></legend> 
      
    
      <label class="required"><g:message code="dhr.property.dhrIsSpouseRetired.label" /> <span><g:message code="dhr.property.dhrIsSpouseRetired.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isSpouseRetired-trigger validate-boolean" title="" value="${it}" name="dhrIsSpouseRetired" ${it == rqt.dhrIsSpouseRetired ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-isSpouseRetired-filled"><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.label" /> <span><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.help" /></span></label>
      
            <select name="dhrSpousePrincipalPensionPlan" class="required condition-isSpouseOtherPensionPlan-trigger condition-isSpouseRetired-filled validate-no-first" title="<g:message code="dhr.property.dhrSpousePrincipalPensionPlan.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['CNAV','MSA','CRAM','MGEN','SNCF','Other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType_${it}" ${it == rqt.dhrSpousePrincipalPensionPlan?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrSpousePrincipalPensionPlan" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-isSpouseOtherPensionPlan-filled"><g:message code="dhr.property.dhrSpousePensionPlanDetail.label" /> <span><g:message code="dhr.property.dhrSpousePensionPlanDetail.help" /></span></label>
      
            <input name="dhrSpousePensionPlanDetail" value="${rqt.dhrSpousePensionPlanDetail}" 
                    class="required condition-isSpouseOtherPensionPlan-filled validate-string" title="<g:message code="dhr.property.dhrSpousePensionPlanDetail.validationError" />">
            
    
      <label class="required condition-isSpouseRetired-filled"><g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.label" /> <span><g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.help" /></span></label>
      
            <input name="dhrSpouseComplementaryPensionPlan" value="${rqt.dhrSpouseComplementaryPensionPlan}" 
                    class="required condition-isSpouseRetired-filled validate-string" title="<g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.validationError" />">
            
    
      <label class="required condition-isSpouseRetired-unfilled"><g:message code="dhr.property.dhrSpouseProfession.label" /> <span><g:message code="dhr.property.dhrSpouseProfession.help" /></span></label>
      
            <input name="dhrSpouseProfession" value="${rqt.dhrSpouseProfession}" 
                    class="required condition-isSpouseRetired-unfilled validate-string" title="<g:message code="dhr.property.dhrSpouseProfession.validationError" />">
            
    
      <label class="required condition-isSpouseRetired-unfilled"><g:message code="dhr.property.dhrSpouseEmployer.label" /> <span><g:message code="dhr.property.dhrSpouseEmployer.help" /></span></label>
      
            <input name="dhrSpouseEmployer" value="${rqt.dhrSpouseEmployer}" 
                    class="required condition-isSpouseRetired-unfilled validate-string" title="<g:message code="dhr.property.dhrSpouseEmployer.validationError" />">
            
    
      <label class="required condition-isSpouseRetired-unfilled"><g:message code="dhr.property.dhrSpouseAddress.label" /> <span><g:message code="dhr.property.dhrSpouseAddress.help" /></span></label>
      
            <div class="address-fieldset required condition-isSpouseRetired-unfilled">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.dhrSpouseAddress?.additionalDeliveryInformation}" maxlength="38" name="dhrSpouseAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.dhrSpouseAddress?.additionalGeographicalInformation}" maxlength="38" name="dhrSpouseAddress.additionalGeographicalInformation"/>
            <label class="required"><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
            <input type="text" class="line1" value="${rqt.dhrSpouseAddress?.streetNumber}" maxlength="5" name="dhrSpouseAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.dhrSpouseAddress?.streetName}" maxlength="32" name="dhrSpouseAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.dhrSpouseAddress?.placeNameOrService}" maxlength="38" name="dhrSpouseAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
            <input type="text" class="line1 required" value="${rqt.dhrSpouseAddress?.postalCode}" maxlength="5" name="dhrSpouseAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.dhrSpouseAddress?.city}" maxlength="32" name="dhrSpouseAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.dhrSpouseAddress?.countryName}" maxlength="38" name="dhrSpouseAddress.countryName"/>
            </div>
            
    
    </fieldset>
  

  
    <fieldset class="condition-isCoupleRequest-filled">
    <legend><g:message code="dhr.property.dhrSpouseIncomes.label" /></legend> 
      
    
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
            
    
      <label class="required"><g:message code="dhr.property.dhrIncomesAnnualTotal.label" /> <span><g:message code="dhr.property.dhrIncomesAnnualTotal.help" /></span></label>
      
            <input name="dhrIncomesAnnualTotal" value="${rqt.dhrIncomesAnnualTotal}" 
                    class="required validate-positiveInteger" title="<g:message code="dhr.property.dhrIncomesAnnualTotal.validationError" />">
            
    
    </fieldset>
  

