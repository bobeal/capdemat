


  
    <fieldset class="">
    <legend><g:message code="dhr.property.dhrSpouse.label" /></legend> 
      
    
      <label class="isCoupleRequest-trigger  required"><g:message code="dhr.property.dhrRequestKind.label" /> <span><g:message code="dhr.property.dhrRequestKind.help" /></span></label>
      
        
          <ul class="isCoupleRequest-trigger ">
            <g:each in="${['Individual','Couple']}">
            <li>
              <input type="radio" class="isCoupleRequest-trigger required validate-one-required" title="" value="fr.cg95.cvq.business.request.social.DhrRequestKindType_${it}" name="dhrRequestKind" ${it == dhr.dhrRequestKind.toString() ? 'checked="checked"': ''} />
	            <g:message code="dhr.property.dhrRequestKind.${it}" />  
            </li>
            </g:each>
          </ul>
          
      
    
      <label class="isCoupleRequest-filled isSpouseMadam-trigger  required"><g:message code="dhr.property.dhrSpouseTitle.label" /> <span><g:message code="dhr.property.dhrSpouseTitle.help" /></span></label>
      
        
          <select name="dhrSpouseTitle" class="isCoupleRequest-filled isSpouseMadam-trigger  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
              <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == dhr.dhrSpouseTitle?.toString() ? 'selected="selected"': ''}><g:message code="dhr.property.dhrSpouseTitle.${it}" /></option>
            </g:each>
          </select>
          
      
    
      <label class="isCoupleRequest-filled  required"><g:message code="dhr.property.dhrSpouseFamilyStatus.label" /> <span><g:message code="dhr.property.dhrSpouseFamilyStatus.help" /></span></label>
      
        
          <select name="dhrSpouseFamilyStatus" class="isCoupleRequest-filled  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
              <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == dhr.dhrSpouseFamilyStatus?.toString() ? 'selected="selected"': ''}><g:message code="dhr.property.dhrSpouseFamilyStatus.${it}" /></option>
            </g:each>
          </select>
          
      
    
      <label class="isCoupleRequest-filled  required"><g:message code="dhr.property.dhrSpouseName.label" /> <span><g:message code="dhr.property.dhrSpouseName.help" /></span></label>
      
        <input name="dhrSpouseName" value="${dhr.dhrSpouseName}" class="isCoupleRequest-filled  required  validate-lastname" title="<g:message code="dhr.property.dhrSpouseName.validationError" />">
      
    
      <label class="isCoupleRequest-filled  required"><g:message code="dhr.property.dhrSpouseFirstName.label" /> <span><g:message code="dhr.property.dhrSpouseFirstName.help" /></span></label>
      
        <input name="dhrSpouseFirstName" value="${dhr.dhrSpouseFirstName}" class="isCoupleRequest-filled  required  validate-firstname" title="<g:message code="dhr.property.dhrSpouseFirstName.validationError" />">
      
    
      <label class="isSpouseMadam-filled  "><g:message code="dhr.property.dhrSpouseMaidenName.label" /> <span><g:message code="dhr.property.dhrSpouseMaidenName.help" /></span></label>
      
        <input name="dhrSpouseMaidenName" value="${dhr.dhrSpouseMaidenName}" class="isSpouseMadam-filled    validate-lastname" title="<g:message code="dhr.property.dhrSpouseMaidenName.validationError" />">
      
    
      <label class="isCoupleRequest-filled  required"><g:message code="dhr.property.dhrSpouseBirthDate.label" /> <span><g:message code="dhr.property.dhrSpouseBirthDate.help" /></span></label>
      
        <input name="dhrSpouseBirthDate" value="${formatDate(formatName:'format.date',date:dhr.dhrSpouseBirthDate)}" class="isCoupleRequest-filled  required  validate-date-au" title="<g:message code="dhr.property.dhrSpouseBirthDate.validationError" />">
      
    
      <label class="isCoupleRequest-filled  required"><g:message code="dhr.property.dhrSpouseBirthPlace.label" /> <span><g:message code="dhr.property.dhrSpouseBirthPlace.help" /></span></label>
      
        <input name="dhrSpouseBirthPlace" value="${dhr.dhrSpouseBirthPlace}" class="isCoupleRequest-filled  required  validate-string" title="<g:message code="dhr.property.dhrSpouseBirthPlace.validationError" />">
      
    
      <label class="isSpouseNonEuropean-trigger isCoupleRequest-filled  required"><g:message code="dhr.property.dhrSpouseNationality.label" /> <span><g:message code="dhr.property.dhrSpouseNationality.help" /></span></label>
      
        
          <select name="dhrSpouseNationality" class="isSpouseNonEuropean-trigger isCoupleRequest-filled  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
              <option value="fr.cg95.cvq.business.users.NationalityType_${it}" ${it == dhr.dhrSpouseNationality?.toString() ? 'selected="selected"': ''}><g:message code="dhr.property.dhrSpouseNationality.${it}" /></option>
            </g:each>
          </select>
          
      
    
      <label class="isSpouseNonEuropean-filled  "><g:message code="dhr.property.dhrSpouseFranceArrivalDate.label" /> <span><g:message code="dhr.property.dhrSpouseFranceArrivalDate.help" /></span></label>
      
        <input name="dhrSpouseFranceArrivalDate" value="${formatDate(formatName:'format.date',date:dhr.dhrSpouseFranceArrivalDate)}" class="isSpouseNonEuropean-filled    validate-date-au" title="<g:message code="dhr.property.dhrSpouseFranceArrivalDate.validationError" />">
      
    
      <label class="isSpouseNonEuropean-filled  required"><g:message code="dhr.property.dhrSpouseIsFrenchResident.label" /> <span><g:message code="dhr.property.dhrSpouseIsFrenchResident.help" /></span></label>
      
        
          <ul class="isSpouseNonEuropean-filled ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="  validate-one-required" title="" value="${it}" name="dhrSpouseIsFrenchResident" ${it == dhr.dhrSpouseIsFrenchResident ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
      
    
    </fieldset>
  

  
    <fieldset class="isCoupleRequest-filled ">
    <legend><g:message code="dhr.property.dhrSpouseStatus.label" /></legend> 
      
    
      <label class="isSpouseRetired-trigger  required"><g:message code="dhr.property.dhrIsSpouseRetired.label" /> <span><g:message code="dhr.property.dhrIsSpouseRetired.help" /></span></label>
      
        
          <ul class="isSpouseRetired-trigger ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="isSpouseRetired-trigger required validate-one-required" title="" value="${it}" name="dhrIsSpouseRetired" ${it == dhr.dhrIsSpouseRetired ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
      
    
      <label class="isSpouseRetired-filled isSpouseOtherPensionPlan-trigger  "><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.label" /> <span><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.help" /></span></label>
      
        
          <select name="dhrSpousePrincipalPensionPlan" class="isSpouseRetired-filled isSpouseOtherPensionPlan-trigger   validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['CNAV','MSA','CRAM','MGEN','SNCF','Other']}">
              <option value="fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType_${it}" ${it == dhr.dhrSpousePrincipalPensionPlan?.toString() ? 'selected="selected"': ''}><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.${it}" /></option>
            </g:each>
          </select>
          
      
    
      <label class="isSpouseOtherPensionPlan-filled  "><g:message code="dhr.property.dhrSpousePensionPlanDetail.label" /> <span><g:message code="dhr.property.dhrSpousePensionPlanDetail.help" /></span></label>
      
        <input name="dhrSpousePensionPlanDetail" value="${dhr.dhrSpousePensionPlanDetail}" class="isSpouseOtherPensionPlan-filled    validate-string" title="<g:message code="dhr.property.dhrSpousePensionPlanDetail.validationError" />">
      
    
      <label class="isSpouseRetired-filled  "><g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.label" /> <span><g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.help" /></span></label>
      
        <input name="dhrSpouseComplementaryPensionPlan" value="${dhr.dhrSpouseComplementaryPensionPlan}" class="isSpouseRetired-filled    validate-string" title="<g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.validationError" />">
      
    
      <label class="isSpouseRetired-unfilled  "><g:message code="dhr.property.dhrSpouseProfession.label" /> <span><g:message code="dhr.property.dhrSpouseProfession.help" /></span></label>
      
        <input name="dhrSpouseProfession" value="${dhr.dhrSpouseProfession}" class="isSpouseRetired-unfilled    validate-string" title="<g:message code="dhr.property.dhrSpouseProfession.validationError" />">
      
    
      <label class="isSpouseRetired-unfilled  "><g:message code="dhr.property.dhrSpouseEmployer.label" /> <span><g:message code="dhr.property.dhrSpouseEmployer.help" /></span></label>
      
        <input name="dhrSpouseEmployer" value="${dhr.dhrSpouseEmployer}" class="isSpouseRetired-unfilled    validate-string" title="<g:message code="dhr.property.dhrSpouseEmployer.validationError" />">
      
    
      <label class="isSpouseRetired-unfilled  "><g:message code="dhr.property.dhrSpouseAddress.label" /> <span><g:message code="dhr.property.dhrSpouseAddress.help" /></span></label>
      
        
          <div class="address-fieldset isSpouseRetired-unfilled ">
          <label><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" value="${dhr.dhrSpouseAddress.additionalDeliveryInformation}" maxlength="38" name="dhrSpouseAddress.additionalDeliveryInformation"/>  
          <label><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" value="${dhr.dhrSpouseAddress.additionalGeographicalInformation}" maxlength="38" name="dhrSpouseAddress.additionalGeographicalInformation"/>
          <label class="required"><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
          <input type="text" class="line1" value="${dhr.dhrSpouseAddress.streetNumber}" maxlength="5" name="dhrSpouseAddress.streetNumber"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrSpouseAddress.streetName}" maxlength="32" name="dhrSpouseAddress.streetName" title="<g:message code="request.error.required" />" />
          <label><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" value="${dhr.dhrSpouseAddress.placeNameOrService}" maxlength="38" name="dhrSpouseAddress.placeNameOrService"/>
          <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
          <input type="text" class="line1 required" value="${dhr.dhrSpouseAddress.postalCode}" maxlength="5" name="dhrSpouseAddress.postalCode"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrSpouseAddress.city}" maxlength="32" name="dhrSpouseAddress.city" title="<g:message code="request.error.required" />" />
          <label><g:message code="address.property.countryName" /></label>
          <input type="text" value="${dhr.dhrSpouseAddress.countryName}" maxlength="38" name="dhrSpouseAddress.countryName"/>
          </div>
          
      
    
    </fieldset>
  

  
    <fieldset class="isCoupleRequest-filled ">
    <legend><g:message code="dhr.property.dhrSpouseIncomes.label" /></legend> 
      
    
      <label class=" "><g:message code="dhr.property.pensions.label" /> <span><g:message code="dhr.property.pensions.help" /></span></label>
      
        <input name="pensions" value="${dhr.pensions}" class="   validate-positiveinteger" title="<g:message code="dhr.property.pensions.validationError" />">
      
    
      <label class=" "><g:message code="dhr.property.dhrAllowances.label" /> <span><g:message code="dhr.property.dhrAllowances.help" /></span></label>
      
        <input name="dhrAllowances" value="${dhr.dhrAllowances}" class="   validate-positiveinteger" title="<g:message code="dhr.property.dhrAllowances.validationError" />">
      
    
      <label class=" "><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" /> <span><g:message code="dhr.property.dhrFurnitureInvestmentIncome.help" /></span></label>
      
        <input name="dhrFurnitureInvestmentIncome" value="${dhr.dhrFurnitureInvestmentIncome}" class="   validate-positiveinteger" title="<g:message code="dhr.property.dhrFurnitureInvestmentIncome.validationError" />">
      
    
      <label class=" "><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" /> <span><g:message code="dhr.property.dhrRealEstateInvestmentIncome.help" /></span></label>
      
        <input name="dhrRealEstateInvestmentIncome" value="${dhr.dhrRealEstateInvestmentIncome}" class="   validate-positiveinteger" title="<g:message code="dhr.property.dhrRealEstateInvestmentIncome.validationError" />">
      
    
      <label class=" "><g:message code="dhr.property.dhrNetIncome.label" /> <span><g:message code="dhr.property.dhrNetIncome.help" /></span></label>
      
        <input name="dhrNetIncome" value="${dhr.dhrNetIncome}" class="   validate-positiveinteger" title="<g:message code="dhr.property.dhrNetIncome.validationError" />">
      
    
    </fieldset>
  

