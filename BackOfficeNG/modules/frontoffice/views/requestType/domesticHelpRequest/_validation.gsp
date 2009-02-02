



  
  <h3><g:message code="dhr.step.subject.label" /></h3>
  
  
    
    <h4><g:message code="dhr.property.dhrRequester.label" /></h4>
    <dl>
      
      <dt><g:message code="request.property.subjectName" /></dt>
      <dd>${subjects.get(request.subjectId)}</dd>
          
      
      
      <dt><g:message code="dhr.property.dhrRequesterBirthDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${request.dhrRequesterBirthDate}"/></dd>
          
      
      <dt><g:message code="dhr.property.dhrRequesterBirthPlace.label" /></dt>
        <dd>${request.dhrRequesterBirthPlace}</dd>
      
      <dt><g:message code="dhr.property.dhrRequesterNationality.label" /></dt>
        
          <dd>
            <g:if test="${request.dhrRequesterNationality}">
              <g:capdematEnumToField var="${request.dhrRequesterNationality}" i18nKeyPrefix="dhr.property.dhrRequesterNationality" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="dhr.property.dhrRequesterFranceArrivalDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${request.dhrRequesterFranceArrivalDate}"/></dd>
          
      
      <dt><g:message code="dhr.property.dhrRequesterIsFrenchResident.label" /></dt>
        
          <dd><g:message code="message.${request.dhrRequesterIsFrenchResident ? 'yes' : 'no'}" /></dd>
          
      
    </dl>
    
  
    
    <h4><g:message code="dhr.property.dhrRequesterPensionPlan.label" /></h4>
    <dl>
      
      
      <dt><g:message code="dhr.property.dhrPrincipalPensionPlan.label" /></dt>
        
          <dd>
            <g:if test="${request.dhrPrincipalPensionPlan}">
              <g:capdematEnumToField var="${request.dhrPrincipalPensionPlan}" i18nKeyPrefix="dhr.property.dhrPrincipalPensionPlan" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="dhr.property.dhrPensionPlanDetail.label" /></dt>
        <dd>${request.dhrPensionPlanDetail}</dd>
      
      <dt><g:message code="dhr.property.dhrComplementaryPensionPlan.label" /></dt>
        <dd>${request.dhrComplementaryPensionPlan}</dd>
      
    </dl>
    
  
    
    <h4><g:message code="dhr.property.dhrRequesterGuardian.label" /></h4>
    <dl>
      
      
      <dt><g:message code="dhr.property.dhrRequesterHaveGuardian.label" /></dt>
        
          <dd><g:message code="message.${request.dhrRequesterHaveGuardian ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="dhr.property.dhrGuardianMeasure.label" /></dt>
        
          <dd>
            <g:if test="${request.dhrGuardianMeasure}">
              <g:capdematEnumToField var="${request.dhrGuardianMeasure}" i18nKeyPrefix="dhr.property.dhrGuardianMeasure" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="dhr.property.dhrGuardianName.label" /></dt>
        <dd>${request.dhrGuardianName}</dd>
      
      <dt><g:message code="dhr.property.dhrGuardianAddress.label" /></dt>
        
          <g:if test="${request.dhrGuardianAddress}">
            <dd>
              <p>${request.dhrGuardianAddress?.additionalDeliveryInformation}</p>
              <p>${request.dhrGuardianAddress?.additionalGeographicalInformation}</p>
              <p>${request.dhrGuardianAddress?.streetNumber} ${request.dhrGuardianAddress?.streetName}</p>
              <p>${request.dhrGuardianAddress?.placeNameOrService}</p>
              <p>${request.dhrGuardianAddress?.postalCode} ${request.dhrGuardianAddress?.city}</p>
              <p>${request.dhrGuardianAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
    </dl>
    
  

  
  <h3><g:message code="dhr.step.familyReferent.label" /></h3>
  
  
    
    <h4><g:message code="dhr.property.dhrFamilyReferent.label" /></h4>
    <dl>
      
      
      <dt><g:message code="dhr.property.dhrHaveFamilyReferent.label" /></dt>
        
          <dd><g:message code="message.${request.dhrHaveFamilyReferent ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="dhr.property.dhrReferentName.label" /></dt>
        <dd>${request.dhrReferentName}</dd>
      
      <dt><g:message code="dhr.property.dhrReferentFirstName.label" /></dt>
        <dd>${request.dhrReferentFirstName}</dd>
      
      <dt><g:message code="dhr.property.dhrReferentAddress.label" /></dt>
        
          <g:if test="${request.dhrReferentAddress}">
            <dd>
              <p>${request.dhrReferentAddress?.additionalDeliveryInformation}</p>
              <p>${request.dhrReferentAddress?.additionalGeographicalInformation}</p>
              <p>${request.dhrReferentAddress?.streetNumber} ${request.dhrReferentAddress?.streetName}</p>
              <p>${request.dhrReferentAddress?.placeNameOrService}</p>
              <p>${request.dhrReferentAddress?.postalCode} ${request.dhrReferentAddress?.city}</p>
              <p>${request.dhrReferentAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
    </dl>
    
  

  
  <h3><g:message code="dhr.step.spouse.label" /></h3>
  
  
    
    <h4><g:message code="dhr.property.dhrSpouse.label" /></h4>
    <dl>
      
      
      <dt><g:message code="dhr.property.dhrRequestKind.label" /></dt>
        
          <dd>
            <g:if test="${request.dhrRequestKind}">
              <g:capdematEnumToField var="${request.dhrRequestKind}" i18nKeyPrefix="dhr.property.dhrRequestKind" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="dhr.property.dhrSpouseTitle.label" /></dt>
        
          <dd>
            <g:if test="${request.dhrSpouseTitle}">
              <g:capdematEnumToField var="${request.dhrSpouseTitle}" i18nKeyPrefix="dhr.property.dhrSpouseTitle" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="dhr.property.dhrSpouseFamilyStatus.label" /></dt>
        
          <dd>
            <g:if test="${request.dhrSpouseFamilyStatus}">
              <g:capdematEnumToField var="${request.dhrSpouseFamilyStatus}" i18nKeyPrefix="dhr.property.dhrSpouseFamilyStatus" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="dhr.property.dhrSpouseName.label" /></dt>
        <dd>${request.dhrSpouseName}</dd>
      
      <dt><g:message code="dhr.property.dhrSpouseFirstName.label" /></dt>
        <dd>${request.dhrSpouseFirstName}</dd>
      
      <dt><g:message code="dhr.property.dhrSpouseMaidenName.label" /></dt>
        <dd>${request.dhrSpouseMaidenName}</dd>
      
      <dt><g:message code="dhr.property.dhrSpouseBirthDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${request.dhrSpouseBirthDate}"/></dd>
          
      
      <dt><g:message code="dhr.property.dhrSpouseBirthPlace.label" /></dt>
        <dd>${request.dhrSpouseBirthPlace}</dd>
      
      <dt><g:message code="dhr.property.dhrSpouseNationality.label" /></dt>
        
          <dd>
            <g:if test="${request.dhrSpouseNationality}">
              <g:capdematEnumToField var="${request.dhrSpouseNationality}" i18nKeyPrefix="dhr.property.dhrSpouseNationality" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="dhr.property.dhrSpouseFranceArrivalDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${request.dhrSpouseFranceArrivalDate}"/></dd>
          
      
      <dt><g:message code="dhr.property.dhrSpouseIsFrenchResident.label" /></dt>
        
          <dd><g:message code="message.${request.dhrSpouseIsFrenchResident ? 'yes' : 'no'}" /></dd>
          
      
    </dl>
    
  
    
    <h4><g:message code="dhr.property.dhrSpouseStatus.label" /></h4>
    <dl>
      
      
      <dt><g:message code="dhr.property.dhrIsSpouseRetired.label" /></dt>
        
          <dd><g:message code="message.${request.dhrIsSpouseRetired ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.label" /></dt>
        
          <dd>
            <g:if test="${request.dhrSpousePrincipalPensionPlan}">
              <g:capdematEnumToField var="${request.dhrSpousePrincipalPensionPlan}" i18nKeyPrefix="dhr.property.dhrSpousePrincipalPensionPlan" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="dhr.property.dhrSpousePensionPlanDetail.label" /></dt>
        <dd>${request.dhrSpousePensionPlanDetail}</dd>
      
      <dt><g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.label" /></dt>
        <dd>${request.dhrSpouseComplementaryPensionPlan}</dd>
      
      <dt><g:message code="dhr.property.dhrSpouseProfession.label" /></dt>
        <dd>${request.dhrSpouseProfession}</dd>
      
      <dt><g:message code="dhr.property.dhrSpouseEmployer.label" /></dt>
        <dd>${request.dhrSpouseEmployer}</dd>
      
      <dt><g:message code="dhr.property.dhrSpouseAddress.label" /></dt>
        
          <g:if test="${request.dhrSpouseAddress}">
            <dd>
              <p>${request.dhrSpouseAddress?.additionalDeliveryInformation}</p>
              <p>${request.dhrSpouseAddress?.additionalGeographicalInformation}</p>
              <p>${request.dhrSpouseAddress?.streetNumber} ${request.dhrSpouseAddress?.streetName}</p>
              <p>${request.dhrSpouseAddress?.placeNameOrService}</p>
              <p>${request.dhrSpouseAddress?.postalCode} ${request.dhrSpouseAddress?.city}</p>
              <p>${request.dhrSpouseAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
    </dl>
    
  
    
    <h4><g:message code="dhr.property.dhrSpouseIncomes.label" /></h4>
    <dl>
      
      
      <dt><g:message code="dhr.property.pensions.label" /></dt>
        <dd>${request.pensions}</dd>
      
      <dt><g:message code="dhr.property.dhrAllowances.label" /></dt>
        <dd>${request.dhrAllowances}</dd>
      
      <dt><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" /></dt>
        <dd>${request.dhrFurnitureInvestmentIncome}</dd>
      
      <dt><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" /></dt>
        <dd>${request.dhrRealEstateInvestmentIncome}</dd>
      
      <dt><g:message code="dhr.property.dhrNetIncome.label" /></dt>
        <dd>${request.dhrNetIncome}</dd>
      
      <dt><g:message code="dhr.property.dhrIncomesAnnualTotal.label" /></dt>
        <dd>${request.dhrIncomesAnnualTotal}</dd>
      
    </dl>
    
  

  
  <h3><g:message code="dhr.step.dwelling.label" /></h3>
  
  
    
    <h4><g:message code="dhr.property.dhrCurrentDwelling.label" /></h4>
    <dl>
      
      
      <dt><g:message code="dhr.property.dhrCurrentDwellingAddress.label" /></dt>
        
          <g:if test="${request.dhrCurrentDwellingAddress}">
            <dd>
              <p>${request.dhrCurrentDwellingAddress?.additionalDeliveryInformation}</p>
              <p>${request.dhrCurrentDwellingAddress?.additionalGeographicalInformation}</p>
              <p>${request.dhrCurrentDwellingAddress?.streetNumber} ${request.dhrCurrentDwellingAddress?.streetName}</p>
              <p>${request.dhrCurrentDwellingAddress?.placeNameOrService}</p>
              <p>${request.dhrCurrentDwellingAddress?.postalCode} ${request.dhrCurrentDwellingAddress?.city}</p>
              <p>${request.dhrCurrentDwellingAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
      <dt><g:message code="dhr.property.dhrCurrentDwellingPhone.label" /></dt>
        <dd>${request.dhrCurrentDwellingPhone}</dd>
      
      <dt><g:message code="dhr.property.dhrCurrentDwellingKind.label" /></dt>
        
          <dd>
            <g:if test="${request.dhrCurrentDwellingKind}">
              <g:capdematEnumToField var="${request.dhrCurrentDwellingKind}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingKind" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${request.dhrCurrentDwellingArrivalDate}"/></dd>
          
      
      <dt><g:message code="dhr.property.dhrCurrentDwellingStatus.label" /></dt>
        
          <dd>
            <g:if test="${request.dhrCurrentDwellingStatus}">
              <g:capdematEnumToField var="${request.dhrCurrentDwellingStatus}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingStatus" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.label" /></dt>
        <dd>${request.dhrCurrentDwellingNumberOfRoom}</dd>
      
      <dt><g:message code="dhr.property.dhrCurrentDwellingNetArea.label" /></dt>
        <dd>${request.dhrCurrentDwellingNetArea}</dd>
      
    </dl>
    
  
    
    <!-- <h4><g:message code="dhr.property.dhrPreviousDwelling.label" /></h4> -->
    <!-- TODO : Render one to many elements -->
    
  

  
  <h3><g:message code="dhr.step.resources.label" /></h3>
  
  
    
    <h4><g:message code="dhr.property.dhrRequesterIncomes.label" /></h4>
    <dl>
      
      
      <dt><g:message code="dhr.property.pensions.label" /></dt>
        <dd>${request.pensions}</dd>
      
      <dt><g:message code="dhr.property.dhrAllowances.label" /></dt>
        <dd>${request.dhrAllowances}</dd>
      
      <dt><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" /></dt>
        <dd>${request.dhrFurnitureInvestmentIncome}</dd>
      
      <dt><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" /></dt>
        <dd>${request.dhrRealEstateInvestmentIncome}</dd>
      
      <dt><g:message code="dhr.property.dhrNetIncome.label" /></dt>
        <dd>${request.dhrNetIncome}</dd>
      
      <dt><g:message code="dhr.property.dhrIncomesAnnualTotal.label" /></dt>
        <dd>${request.dhrIncomesAnnualTotal}</dd>
      
    </dl>
    
  
    
    <!-- <h4><g:message code="dhr.property.dhrRealAsset.label" /></h4> -->
    <!-- TODO : Render one to many elements -->
    
  
    
    <!-- <h4><g:message code="dhr.property.dhrNotRealAsset.label" /></h4> -->
    <!-- TODO : Render one to many elements -->
    
  

  
  <h3><g:message code="dhr.step.taxes.label" /></h3>
  
  
    
    <h4><g:message code="dhr.property.dhrTaxesAmount.label" /></h4>
    <dl>
      
      
      <dt><g:message code="dhr.property.dhrIncomeTax.label" /></dt>
        <dd>${request.dhrIncomeTax}</dd>
      
      <dt><g:message code="dhr.property.localRate.label" /></dt>
        <dd>${request.localRate}</dd>
      
      <dt><g:message code="dhr.property.propertyTaxes.label" /></dt>
        <dd>${request.propertyTaxes}</dd>
      
      <dt><g:message code="dhr.property.professionalTaxes.label" /></dt>
        <dd>${request.professionalTaxes}</dd>
      
    </dl>
    
  

  
  <h3><g:message code="request.step.document.label" /></h3>
  <!-- TODO : Render document summary template -->
  
  

  
  


