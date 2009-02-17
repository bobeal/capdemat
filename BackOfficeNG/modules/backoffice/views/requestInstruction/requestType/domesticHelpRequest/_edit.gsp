

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="dhr.step.subject.label" /></em></a>
    </li>
  
    <li>
      <a href="#page1"><em><g:message code="dhr.step.familyReferent.label" /></em></a>
    </li>
  
    <li>
      <a href="#page2"><em><g:message code="dhr.step.spouse.label" /></em></a>
    </li>
  
    <li>
      <a href="#page3"><em><g:message code="dhr.step.dwelling.label" /></em></a>
    </li>
  
    <li>
      <a href="#page4"><em><g:message code="dhr.step.resources.label" /></em></a>
    </li>
  
    <li>
      <a href="#page5"><em><g:message code="dhr.step.taxes.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
    <!-- step start -->
    <div id="page0">
      <h2><g:message code="property.form" />
        <span><g:message code="dhr.step.subject.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="dhr.property.dhrRequester.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="dhr.property.dhrRequesterBirthDate.label" /> : </dt>
                  <dd id="dhrRequesterBirthDate" class="action-editField validate-date required-true i18n-dhr.property.dhrRequesterBirthDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.dhrRequesterBirthDate}"/></span>
                  </dd>
                
                  <dt class="required"><g:message code="dhr.property.dhrRequesterBirthPlace.label" /> : </dt>
                  <dd id="dhrRequesterBirthPlace" class="action-editField validate-string required-true i18n-dhr.property.dhrRequesterBirthPlace" >
                    <span>${request?.dhrRequesterBirthPlace}</span>
                  </dd>
                
                  <dt class="required condition-isNonEuropean-trigger"><g:message code="dhr.property.dhrRequesterNationality.label" /> : </dt>
                  <dd id="dhrRequesterNationality" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrRequesterNationality javatype-fr.cg95.cvq.business.users.NationalityType" >
                    <g:capdematEnumToField var="${request?.dhrRequesterNationality}" i18nKeyPrefix="dhr.property.dhrRequesterNationality" />
                  </dd>
                
                  <dt class="required condition-isNonEuropean-filled"><g:message code="dhr.property.dhrRequesterFranceArrivalDate.label" /> : </dt>
                  <dd id="dhrRequesterFranceArrivalDate" class="action-editField validate-date required-true i18n-dhr.property.dhrRequesterFranceArrivalDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.dhrRequesterFranceArrivalDate}"/></span>
                  </dd>
                
                  <dt class="required condition-isNonEuropean-filled"><g:message code="dhr.property.dhrRequesterIsFrenchResident.label" /> : </dt>
                  <dd id="dhrRequesterIsFrenchResident" class="action-editField validate-boolean required-true i18n-dhr.property.dhrRequesterIsFrenchResident" >
                    <span class="value-${request?.dhrRequesterIsFrenchResident}"><g:message code="message.${request?.dhrRequesterIsFrenchResident ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <h3><g:message code="dhr.property.dhrRequesterPensionPlan.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isOtherPensionPlan-trigger"><g:message code="dhr.property.dhrPrincipalPensionPlan.label" /> : </dt>
                  <dd id="dhrPrincipalPensionPlan" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrPrincipalPensionPlan javatype-fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType" >
                    <g:capdematEnumToField var="${request?.dhrPrincipalPensionPlan}" i18nKeyPrefix="dhr.property.dhrPrincipalPensionPlan" />
                  </dd>
                
                  <dt class="required condition-isOtherPensionPlan-filled"><g:message code="dhr.property.dhrPensionPlanDetail.label" /> : </dt>
                  <dd id="dhrPensionPlanDetail" class="action-editField validate-string required-true i18n-dhr.property.dhrPensionPlanDetail" >
                    <span>${request?.dhrPensionPlanDetail}</span>
                  </dd>
                
                  <dt class="required"><g:message code="dhr.property.dhrComplementaryPensionPlan.label" /> : </dt>
                  <dd id="dhrComplementaryPensionPlan" class="action-editField validate-string required-true i18n-dhr.property.dhrComplementaryPensionPlan" >
                    <span>${request?.dhrComplementaryPensionPlan}</span>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="dhr.property.dhrRequesterGuardian.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-haveGuardian-trigger"><g:message code="dhr.property.dhrRequesterHaveGuardian.label" /> : </dt>
                  <dd id="dhrRequesterHaveGuardian" class="action-editField validate-boolean required-true i18n-dhr.property.dhrRequesterHaveGuardian" >
                    <span class="value-${request?.dhrRequesterHaveGuardian}"><g:message code="message.${request?.dhrRequesterHaveGuardian ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianMeasure.label" /> : </dt>
                  <dd id="dhrGuardianMeasure" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrGuardianMeasure javatype-fr.cg95.cvq.business.request.social.DhrGuardianMeasureType" >
                    <g:capdematEnumToField var="${request?.dhrGuardianMeasure}" i18nKeyPrefix="dhr.property.dhrGuardianMeasure" />
                  </dd>
                
                  <dt class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianName.label" /> : </dt>
                  <dd id="dhrGuardianName" class="action-editField validate-lastName required-true i18n-dhr.property.dhrGuardianName" >
                    <span>${request?.dhrGuardianName}</span>
                  </dd>
                
                  <dt class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianAddress.label" /> : </dt>
                  <dd id="dhrGuardianAddress" class="action-editField validate-address required-true i18n-dhr.property.dhrGuardianAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.dhrGuardianAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.dhrGuardianAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.dhrGuardianAddress?.streetNumber}</span> <span class="streetName">${request?.dhrGuardianAddress?.streetName}</span><p class="placeNameOrService">${request?.dhrGuardianAddress?.placeNameOrService}</p><span class="postalCode">${request?.dhrGuardianAddress?.postalCode}</span> <span class="city">${request?.dhrGuardianAddress?.city}</span><p class="countryName">${request?.dhrGuardianAddress?.countryName}</p></div>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page1">
      <h2><g:message code="property.form" />
        <span><g:message code="dhr.step.familyReferent.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="dhr.property.dhrFamilyReferent.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-haveFamilyReferent-trigger"><g:message code="dhr.property.dhrHaveFamilyReferent.label" /> : </dt>
                  <dd id="dhrHaveFamilyReferent" class="action-editField validate-boolean required-true i18n-dhr.property.dhrHaveFamilyReferent" >
                    <span class="value-${request?.dhrHaveFamilyReferent}"><g:message code="message.${request?.dhrHaveFamilyReferent ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-haveFamilyReferent-filled"><g:message code="dhr.property.dhrReferentName.label" /> : </dt>
                  <dd id="dhrReferentName" class="action-editField validate-lastName required-true i18n-dhr.property.dhrReferentName" >
                    <span>${request?.dhrReferentName}</span>
                  </dd>
                
                  <dt class="required condition-haveFamilyReferent-filled"><g:message code="dhr.property.dhrReferentFirstName.label" /> : </dt>
                  <dd id="dhrReferentFirstName" class="action-editField validate-firstName required-true i18n-dhr.property.dhrReferentFirstName" >
                    <span>${request?.dhrReferentFirstName}</span>
                  </dd>
                
                  <dt class="required condition-haveFamilyReferent-filled"><g:message code="dhr.property.dhrReferentAddress.label" /> : </dt>
                  <dd id="dhrReferentAddress" class="action-editField validate-address required-true i18n-dhr.property.dhrReferentAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.dhrReferentAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.dhrReferentAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.dhrReferentAddress?.streetNumber}</span> <span class="streetName">${request?.dhrReferentAddress?.streetName}</span><p class="placeNameOrService">${request?.dhrReferentAddress?.placeNameOrService}</p><span class="postalCode">${request?.dhrReferentAddress?.postalCode}</span> <span class="city">${request?.dhrReferentAddress?.city}</span><p class="countryName">${request?.dhrReferentAddress?.countryName}</p></div>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page2">
      <h2><g:message code="property.form" />
        <span><g:message code="dhr.step.spouse.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="dhr.property.dhrSpouse.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isCoupleRequest-trigger"><g:message code="dhr.property.dhrRequestKind.label" /> : </dt>
                  <dd id="dhrRequestKind" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrRequestKind javatype-fr.cg95.cvq.business.request.social.DhrRequestKindType" >
                    <g:capdematEnumToField var="${request?.dhrRequestKind}" i18nKeyPrefix="dhr.property.dhrRequestKind" />
                  </dd>
                
                  <dt class="required condition-isCoupleRequest-filled condition-isSpouseMadam-trigger"><g:message code="dhr.property.dhrSpouseTitle.label" /> : </dt>
                  <dd id="dhrSpouseTitle" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrSpouseTitle javatype-fr.cg95.cvq.business.users.TitleType" >
                    <g:capdematEnumToField var="${request?.dhrSpouseTitle}" i18nKeyPrefix="dhr.property.dhrSpouseTitle" />
                  </dd>
                
                  <dt class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseFamilyStatus.label" /> : </dt>
                  <dd id="dhrSpouseFamilyStatus" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrSpouseFamilyStatus javatype-fr.cg95.cvq.business.users.FamilyStatusType" >
                    <g:capdematEnumToField var="${request?.dhrSpouseFamilyStatus}" i18nKeyPrefix="dhr.property.dhrSpouseFamilyStatus" />
                  </dd>
                
                  <dt class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseName.label" /> : </dt>
                  <dd id="dhrSpouseName" class="action-editField validate-lastName required-true i18n-dhr.property.dhrSpouseName" >
                    <span>${request?.dhrSpouseName}</span>
                  </dd>
                
                  <dt class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseFirstName.label" /> : </dt>
                  <dd id="dhrSpouseFirstName" class="action-editField validate-firstName required-true i18n-dhr.property.dhrSpouseFirstName" >
                    <span>${request?.dhrSpouseFirstName}</span>
                  </dd>
                
                  <dt class="required condition-isSpouseMadam-filled"><g:message code="dhr.property.dhrSpouseMaidenName.label" /> : </dt>
                  <dd id="dhrSpouseMaidenName" class="action-editField validate-lastName required-true i18n-dhr.property.dhrSpouseMaidenName" >
                    <span>${request?.dhrSpouseMaidenName}</span>
                  </dd>
                
                  <dt class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseBirthDate.label" /> : </dt>
                  <dd id="dhrSpouseBirthDate" class="action-editField validate-date required-true i18n-dhr.property.dhrSpouseBirthDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.dhrSpouseBirthDate}"/></span>
                  </dd>
                
                  <dt class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseBirthPlace.label" /> : </dt>
                  <dd id="dhrSpouseBirthPlace" class="action-editField validate-string required-true i18n-dhr.property.dhrSpouseBirthPlace" >
                    <span>${request?.dhrSpouseBirthPlace}</span>
                  </dd>
                
                  <dt class="required condition-isCoupleRequest-filled condition-isSpouseNonEuropean-trigger"><g:message code="dhr.property.dhrSpouseNationality.label" /> : </dt>
                  <dd id="dhrSpouseNationality" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrSpouseNationality javatype-fr.cg95.cvq.business.users.NationalityType" >
                    <g:capdematEnumToField var="${request?.dhrSpouseNationality}" i18nKeyPrefix="dhr.property.dhrSpouseNationality" />
                  </dd>
                
                  <dt class="required condition-isSpouseNonEuropean-filled"><g:message code="dhr.property.dhrSpouseFranceArrivalDate.label" /> : </dt>
                  <dd id="dhrSpouseFranceArrivalDate" class="action-editField validate-date required-true i18n-dhr.property.dhrSpouseFranceArrivalDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.dhrSpouseFranceArrivalDate}"/></span>
                  </dd>
                
                  <dt class="required condition-isSpouseNonEuropean-filled"><g:message code="dhr.property.dhrSpouseIsFrenchResident.label" /> : </dt>
                  <dd id="dhrSpouseIsFrenchResident" class="action-editField validate-boolean required-true i18n-dhr.property.dhrSpouseIsFrenchResident" >
                    <span class="value-${request?.dhrSpouseIsFrenchResident}"><g:message code="message.${request?.dhrSpouseIsFrenchResident ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <h3><g:message code="dhr.property.dhrSpouseStatus.label" /></h3>
              <dl class="required condition-isCoupleRequest-filled">
                
                  <dt class="required condition-isSpouseRetired-trigger"><g:message code="dhr.property.dhrIsSpouseRetired.label" /> : </dt>
                  <dd id="dhrIsSpouseRetired" class="action-editField validate-boolean required-true i18n-dhr.property.dhrIsSpouseRetired" >
                    <span class="value-${request?.dhrIsSpouseRetired}"><g:message code="message.${request?.dhrIsSpouseRetired ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSpouseRetired-filled condition-isSpouseOtherPensionPlan-trigger"><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.label" /> : </dt>
                  <dd id="dhrSpousePrincipalPensionPlan" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrSpousePrincipalPensionPlan javatype-fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType" >
                    <g:capdematEnumToField var="${request?.dhrSpousePrincipalPensionPlan}" i18nKeyPrefix="dhr.property.dhrSpousePrincipalPensionPlan" />
                  </dd>
                
                  <dt class="required condition-isSpouseOtherPensionPlan-filled"><g:message code="dhr.property.dhrSpousePensionPlanDetail.label" /> : </dt>
                  <dd id="dhrSpousePensionPlanDetail" class="action-editField validate-string required-true i18n-dhr.property.dhrSpousePensionPlanDetail" >
                    <span>${request?.dhrSpousePensionPlanDetail}</span>
                  </dd>
                
                  <dt class="required condition-isSpouseRetired-filled"><g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.label" /> : </dt>
                  <dd id="dhrSpouseComplementaryPensionPlan" class="action-editField validate-string required-true i18n-dhr.property.dhrSpouseComplementaryPensionPlan" >
                    <span>${request?.dhrSpouseComplementaryPensionPlan}</span>
                  </dd>
                
                  <dt class="required condition-isSpouseRetired-unfilled"><g:message code="dhr.property.dhrSpouseProfession.label" /> : </dt>
                  <dd id="dhrSpouseProfession" class="action-editField validate-string required-true i18n-dhr.property.dhrSpouseProfession" >
                    <span>${request?.dhrSpouseProfession}</span>
                  </dd>
                
                  <dt class="required condition-isSpouseRetired-unfilled"><g:message code="dhr.property.dhrSpouseEmployer.label" /> : </dt>
                  <dd id="dhrSpouseEmployer" class="action-editField validate-string required-true i18n-dhr.property.dhrSpouseEmployer" >
                    <span>${request?.dhrSpouseEmployer}</span>
                  </dd>
                
                  <dt class="required condition-isSpouseRetired-unfilled"><g:message code="dhr.property.dhrSpouseAddress.label" /> : </dt>
                  <dd id="dhrSpouseAddress" class="action-editField validate-address required-true i18n-dhr.property.dhrSpouseAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.dhrSpouseAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.dhrSpouseAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.dhrSpouseAddress?.streetNumber}</span> <span class="streetName">${request?.dhrSpouseAddress?.streetName}</span><p class="placeNameOrService">${request?.dhrSpouseAddress?.placeNameOrService}</p><span class="postalCode">${request?.dhrSpouseAddress?.postalCode}</span> <span class="city">${request?.dhrSpouseAddress?.city}</span><p class="countryName">${request?.dhrSpouseAddress?.countryName}</p></div>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="dhr.property.dhrSpouseIncomes.label" /></h3>
              <dl class="condition-isCoupleRequest-filled">
                
                  <dt class=""><g:message code="dhr.property.pensions.label" /> : </dt>
                  <dd id="pensions" class="action-editField validate-positiveInteger i18n-dhr.property.pensions" >
                    <span>${request?.pensions}</span>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.dhrAllowances.label" /> : </dt>
                  <dd id="dhrAllowances" class="action-editField validate-positiveInteger i18n-dhr.property.dhrAllowances" >
                    <span>${request?.dhrAllowances}</span>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" /> : </dt>
                  <dd id="dhrFurnitureInvestmentIncome" class="action-editField validate-positiveInteger i18n-dhr.property.dhrFurnitureInvestmentIncome" >
                    <span>${request?.dhrFurnitureInvestmentIncome}</span>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" /> : </dt>
                  <dd id="dhrRealEstateInvestmentIncome" class="action-editField validate-positiveInteger i18n-dhr.property.dhrRealEstateInvestmentIncome" >
                    <span>${request?.dhrRealEstateInvestmentIncome}</span>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.dhrNetIncome.label" /> : </dt>
                  <dd id="dhrNetIncome" class="action-editField validate-positiveInteger i18n-dhr.property.dhrNetIncome" >
                    <span>${request?.dhrNetIncome}</span>
                  </dd>
                
                  <dt class="required"><g:message code="dhr.property.dhrIncomesAnnualTotal.label" /> : </dt>
                  <dd id="dhrIncomesAnnualTotal" class="action-editField validate-positiveInteger required-true i18n-dhr.property.dhrIncomesAnnualTotal" >
                    <span>${request?.dhrIncomesAnnualTotal}</span>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page3">
      <h2><g:message code="property.form" />
        <span><g:message code="dhr.step.dwelling.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="dhr.property.dhrCurrentDwelling.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="dhr.property.dhrCurrentDwellingAddress.label" /> : </dt>
                  <dd id="dhrCurrentDwellingAddress" class="action-editField validate-address required-true i18n-dhr.property.dhrCurrentDwellingAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.dhrCurrentDwellingAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.dhrCurrentDwellingAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.dhrCurrentDwellingAddress?.streetNumber}</span> <span class="streetName">${request?.dhrCurrentDwellingAddress?.streetName}</span><p class="placeNameOrService">${request?.dhrCurrentDwellingAddress?.placeNameOrService}</p><span class="postalCode">${request?.dhrCurrentDwellingAddress?.postalCode}</span> <span class="city">${request?.dhrCurrentDwellingAddress?.city}</span><p class="countryName">${request?.dhrCurrentDwellingAddress?.countryName}</p></div>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.dhrCurrentDwellingPhone.label" /> : </dt>
                  <dd id="dhrCurrentDwellingPhone" class="action-editField validate-phone i18n-dhr.property.dhrCurrentDwellingPhone" >
                    <span>${request?.dhrCurrentDwellingPhone}</span>
                  </dd>
                
                  <dt class="required condition-isCurrentDwellingPlaceOfResidence-trigger"><g:message code="dhr.property.dhrCurrentDwellingKind.label" /> : </dt>
                  <dd id="dhrCurrentDwellingKind" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrCurrentDwellingKind javatype-fr.cg95.cvq.business.request.social.DhrDwellingKindType" >
                    <g:capdematEnumToField var="${request?.dhrCurrentDwellingKind}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingKind" />
                  </dd>
                
                  <dt class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.label" /> : </dt>
                  <dd id="dhrCurrentDwellingArrivalDate" class="action-editField validate-date required-true i18n-dhr.property.dhrCurrentDwellingArrivalDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.dhrCurrentDwellingArrivalDate}"/></span>
                  </dd>
                
                  <dt class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingStatus.label" /> : </dt>
                  <dd id="dhrCurrentDwellingStatus" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrCurrentDwellingStatus javatype-fr.cg95.cvq.business.request.social.DhrDwellingStatusType" >
                    <g:capdematEnumToField var="${request?.dhrCurrentDwellingStatus}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingStatus" />
                  </dd>
                
                  <dt class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.label" /> : </dt>
                  <dd id="dhrCurrentDwellingNumberOfRoom" class="action-editField validate-dhrDwellingNumberOfRoom required-true i18n-dhr.property.dhrCurrentDwellingNumberOfRoom" >
                    <span>${request?.dhrCurrentDwellingNumberOfRoom}</span>
                  </dd>
                
                  <dt class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingNetArea.label" /> : </dt>
                  <dd id="dhrCurrentDwellingNetArea" class="action-editField validate-regex required-true i18n-dhr.property.dhrCurrentDwellingNetArea" regex="/^[1-9]$|^[1-9][0-9]$|^[1-4][0-9][0-9]$|^500$/">
                    <span>${request?.dhrCurrentDwellingNetArea}</span>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <div id="widget-dhrPreviousDwelling">
                <g:render template="/backofficeRequestInstruction/requestType/domesticHelpRequest/dhrPreviousDwelling" model="['request':request]" />
              </div>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page4">
      <h2><g:message code="property.form" />
        <span><g:message code="dhr.step.resources.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="dhr.property.dhrRequesterIncomes.label" /></h3>
              <dl class="required">
                
                  <dt class=""><g:message code="dhr.property.pensions.label" /> : </dt>
                  <dd id="pensions" class="action-editField validate-positiveInteger i18n-dhr.property.pensions" >
                    <span>${request?.pensions}</span>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.dhrAllowances.label" /> : </dt>
                  <dd id="dhrAllowances" class="action-editField validate-positiveInteger i18n-dhr.property.dhrAllowances" >
                    <span>${request?.dhrAllowances}</span>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" /> : </dt>
                  <dd id="dhrFurnitureInvestmentIncome" class="action-editField validate-positiveInteger i18n-dhr.property.dhrFurnitureInvestmentIncome" >
                    <span>${request?.dhrFurnitureInvestmentIncome}</span>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" /> : </dt>
                  <dd id="dhrRealEstateInvestmentIncome" class="action-editField validate-positiveInteger i18n-dhr.property.dhrRealEstateInvestmentIncome" >
                    <span>${request?.dhrRealEstateInvestmentIncome}</span>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.dhrNetIncome.label" /> : </dt>
                  <dd id="dhrNetIncome" class="action-editField validate-positiveInteger i18n-dhr.property.dhrNetIncome" >
                    <span>${request?.dhrNetIncome}</span>
                  </dd>
                
                  <dt class="required"><g:message code="dhr.property.dhrIncomesAnnualTotal.label" /> : </dt>
                  <dd id="dhrIncomesAnnualTotal" class="action-editField validate-positiveInteger required-true i18n-dhr.property.dhrIncomesAnnualTotal" >
                    <span>${request?.dhrIncomesAnnualTotal}</span>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <div id="widget-dhrRealAsset">
                <g:render template="/backofficeRequestInstruction/requestType/domesticHelpRequest/dhrRealAsset" model="['request':request]" />
              </div>
              
            
              
              <div id="widget-dhrNotRealAsset">
                <g:render template="/backofficeRequestInstruction/requestType/domesticHelpRequest/dhrNotRealAsset" model="['request':request]" />
              </div>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page5">
      <h2><g:message code="property.form" />
        <span><g:message code="dhr.step.taxes.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="dhr.property.dhrTaxesAmount.label" /></h3>
              <dl class="required">
                
                  <dt class=""><g:message code="dhr.property.dhrIncomeTax.label" /> : </dt>
                  <dd id="dhrIncomeTax" class="action-editField validate-positiveInteger i18n-dhr.property.dhrIncomeTax" >
                    <span>${request?.dhrIncomeTax}</span>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.localRate.label" /> : </dt>
                  <dd id="localRate" class="action-editField validate-positiveInteger i18n-dhr.property.localRate" >
                    <span>${request?.localRate}</span>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.propertyTaxes.label" /> : </dt>
                  <dd id="propertyTaxes" class="action-editField validate-positiveInteger i18n-dhr.property.propertyTaxes" >
                    <span>${request?.propertyTaxes}</span>
                  </dd>
                
                  <dt class=""><g:message code="dhr.property.professionalTaxes.label" /> : </dt>
                  <dd id="professionalTaxes" class="action-editField validate-positiveInteger i18n-dhr.property.professionalTaxes" >
                    <span>${request?.professionalTaxes}</span>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    
  </div>
  
</div>
