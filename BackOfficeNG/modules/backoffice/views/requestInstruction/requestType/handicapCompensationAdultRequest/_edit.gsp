

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="hcar.step.subject.label" /></em></a>
    </li>
  
    <li>
      <a href="#page1"><em><g:message code="hcar.step.dwelling.label" /></em></a>
    </li>
  
    <li>
      <a href="#page2"><em><g:message code="hcar.step.socialSecurityAndPaymentAgency.label" /></em></a>
    </li>
  
    <li>
      <a href="#page3"><em><g:message code="hcar.step.occupationnalAndSchoolStatus.label" /></em></a>
    </li>
  
    <li>
      <a href="#page4"><em><g:message code="hcar.step.folders.label" /></em></a>
    </li>
  
    <li>
      <a href="#page5"><em><g:message code="hcar.step.benefits.label" /></em></a>
    </li>
  
    <li>
      <a href="#page6"><em><g:message code="hcar.step.aid.label" /></em></a>
    </li>
  
    <li>
      <a href="#page7"><em><g:message code="hcar.step.health.label" /></em></a>
    </li>
  
    <li>
      <a href="#page8"><em><g:message code="hcar.step.project.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
    <!-- step start -->
    <div id="page0">
      <h2><g:message code="property.form" />
        <span><g:message code="hcar.step.subject.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hcar.property.hcarSubject.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isMadam-trigger"><g:message code="hcar.property.subjectTitle.label" /> * : </dt>
                  <dd id="subjectTitle" class="action-editField validate-capdematEnum required-true i18n-hcar.property.subjectTitle javatype-fr.cg95.cvq.business.users.TitleType" >
                    <g:capdematEnumToField var="${request?.subjectTitle}" i18nKeyPrefix="hcar.property.subjectTitle" />
                  </dd>
                
                  <dt class="required condition-isMadam-filled"><g:message code="hcar.property.subjectMaidenName.label" /> * : </dt>
                  <dd id="subjectMaidenName" class="action-editField validate-lastName required-true i18n-hcar.property.subjectMaidenName" >
                    <span>${request?.subjectMaidenName}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.subjectBirthDate.label" /> * : </dt>
                  <dd id="subjectBirthDate" class="action-editField validate-date required-true i18n-hcar.property.subjectBirthDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.subjectBirthDate}"/></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.subjectBirthCity.label" /> * : </dt>
                  <dd id="subjectBirthCity" class="action-editField validate-city required-true i18n-hcar.property.subjectBirthCity" >
                    <span>${request?.subjectBirthCity}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.subjectBirthCountry.label" /> * : </dt>
                  <dd id="subjectBirthCountry" class="action-editField validate- required-true i18n-hcar.property.subjectBirthCountry" >
                    <span>${request?.subjectBirthCountry}</span>
                  </dd>
                
              </dl>
              
            
              
              <h3><g:message code="hcar.property.legalAccess.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isLegalAccessPresence-trigger"><g:message code="hcar.property.legalAccessPresence.label" /> * : </dt>
                  <dd id="legalAccessPresence" class="action-editField validate-boolean required-true i18n-hcar.property.legalAccessPresence" >
                    <span class="value-${request?.legalAccessPresence}"><g:message code="message.${request?.legalAccessPresence ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessKind.label" /> * : </dt>
                  <dd id="legalAccessKind" class="action-editField validate-capdematEnum required-true i18n-hcar.property.legalAccessKind javatype-fr.cg95.cvq.business.request.social.HcarLegalAccessKindType" >
                    <g:capdematEnumToField var="${request?.legalAccessKind}" i18nKeyPrefix="hcar.property.legalAccessKind" />
                  </dd>
                
                  <dt class="required condition-isLegalAccessPresence-filled condition-isOtherLegalAccessRepresentative-trigger"><g:message code="hcar.property.legalAccessRepresentativeKind.label" /> * : </dt>
                  <dd id="legalAccessRepresentativeKind" class="action-editField validate-capdematEnum required-true i18n-hcar.property.legalAccessRepresentativeKind javatype-fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType" >
                    <g:capdematEnumToField var="${request?.legalAccessRepresentativeKind}" i18nKeyPrefix="hcar.property.legalAccessRepresentativeKind" />
                  </dd>
                
                  <dt class="required condition-isOtherLegalAccessRepresentative-filled"><g:message code="hcar.property.legalAccessRepresentativeKindDetail.label" /> * : </dt>
                  <dd id="legalAccessRepresentativeKindDetail" class="action-editField validate- required-true i18n-hcar.property.legalAccessRepresentativeKindDetail" >
                    <span>${request?.legalAccessRepresentativeKindDetail}</span>
                  </dd>
                
                  <dt class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessRepresentativeName.label" /> * : </dt>
                  <dd id="legalAccessRepresentativeName" class="action-editField validate-lastName required-true i18n-hcar.property.legalAccessRepresentativeName" >
                    <span>${request?.legalAccessRepresentativeName}</span>
                  </dd>
                
                  <dt class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessRepresentativeFirstName.label" /> * : </dt>
                  <dd id="legalAccessRepresentativeFirstName" class="action-editField validate-firstName required-true i18n-hcar.property.legalAccessRepresentativeFirstName" >
                    <span>${request?.legalAccessRepresentativeFirstName}</span>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="hcar.property.family.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="hcar.property.familyStatus.label" /> * : </dt>
                  <dd id="familyStatus" class="action-editField validate-capdematEnum required-true i18n-hcar.property.familyStatus javatype-fr.cg95.cvq.business.users.FamilyStatusType" >
                    <g:capdematEnumToField var="${request?.familyStatus}" i18nKeyPrefix="hcar.property.familyStatus" />
                  </dd>
                
                  <dt class="required condition-isFamilyDependents-trigger"><g:message code="hcar.property.familyFamilyDependents.label" /> * : </dt>
                  <dd id="familyFamilyDependents" class="action-editField validate-boolean required-true i18n-hcar.property.familyFamilyDependents" >
                    <span class="value-${request?.familyFamilyDependents}"><g:message code="message.${request?.familyFamilyDependents ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-familyDependents">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/familyDependents" model="['request':request]" />
              </div>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page1">
      <h2><g:message code="property.form" />
        <span><g:message code="hcar.step.dwelling.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hcar.property.dwelling.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isNotPlaceOfResidence-trigger"><g:message code="hcar.property.dwellingKind.label" /> * : </dt>
                  <dd id="dwellingKind" class="action-editField validate-capdematEnum required-true i18n-hcar.property.dwellingKind javatype-fr.cg95.cvq.business.request.social.HcarDwellingKindType" >
                    <g:capdematEnumToField var="${request?.dwellingKind}" i18nKeyPrefix="hcar.property.dwellingKind" />
                  </dd>
                
                  <dt class="required condition-isNotPlaceOfResidence-filled"><g:message code="hcar.property.dwellingPrecision.label" /> * : </dt>
                  <dd id="dwellingPrecision" class="action-editField validate- required-true i18n-hcar.property.dwellingPrecision" >
                    <span>${request?.dwellingPrecision}</span>
                  </dd>
                
                  <dt class="required condition-isInEstablishmentReception-trigger"><g:message code="hcar.property.dwellingEstablishmentReception.label" /> * : </dt>
                  <dd id="dwellingEstablishmentReception" class="action-editField validate-boolean required-true i18n-hcar.property.dwellingEstablishmentReception" >
                    <span class="value-${request?.dwellingEstablishmentReception}"><g:message code="message.${request?.dwellingEstablishmentReception ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isInEstablishmentReception-filled"><g:message code="hcar.property.dwellingReceptionType.label" /> * : </dt>
                  <dd id="dwellingReceptionType" class="action-editField validate-capdematEnum required-true i18n-hcar.property.dwellingReceptionType javatype-fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType" >
                    <g:capdematEnumToField var="${request?.dwellingReceptionType}" i18nKeyPrefix="hcar.property.dwellingReceptionType" />
                  </dd>
                
                  <dt class="required condition-isInEstablishmentReception-filled"><g:message code="hcar.property.dwellingReceptionNaming.label" /> * : </dt>
                  <dd id="dwellingReceptionNaming" class="action-editField validate- required-true i18n-hcar.property.dwellingReceptionNaming" >
                    <span>${request?.dwellingReceptionNaming}</span>
                  </dd>
                
                  <dt class="required condition-isInEstablishmentReception-filled"><g:message code="hcar.property.dwellingReceptionAddress.label" /> * : </dt>
                  <dd id="dwellingReceptionAddress" class="action-editField validate-address required-true i18n-hcar.property.dwellingReceptionAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.dwellingReceptionAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.dwellingReceptionAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.dwellingReceptionAddress?.streetNumber}</span> <span class="streetName">${request?.dwellingReceptionAddress?.streetName}</span><p class="placeNameOrService">${request?.dwellingReceptionAddress?.placeNameOrService}</p><span class="postalCode">${request?.dwellingReceptionAddress?.postalCode}</span> <span class="city">${request?.dwellingReceptionAddress?.city}</span><p class="countryName">${request?.dwellingReceptionAddress?.countryName}</p></div>
                  </dd>
                
                  <dt class="required condition-isInSocialReception-trigger"><g:message code="hcar.property.dwellingSocialReception.label" /> * : </dt>
                  <dd id="dwellingSocialReception" class="action-editField validate-boolean required-true i18n-hcar.property.dwellingSocialReception" >
                    <span class="value-${request?.dwellingSocialReception}"><g:message code="message.${request?.dwellingSocialReception ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isInSocialReception-filled"><g:message code="hcar.property.dwellingSocialReceptionNaming.label" /> * : </dt>
                  <dd id="dwellingSocialReceptionNaming" class="action-editField validate- required-true i18n-hcar.property.dwellingSocialReceptionNaming" >
                    <span>${request?.dwellingSocialReceptionNaming}</span>
                  </dd>
                
                  <dt class="required condition-isInSocialReception-filled"><g:message code="hcar.property.dwellingSocialReceptionAddress.label" /> * : </dt>
                  <dd id="dwellingSocialReceptionAddress" class="action-editField validate-address required-true i18n-hcar.property.dwellingSocialReceptionAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.dwellingSocialReceptionAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.dwellingSocialReceptionAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.dwellingSocialReceptionAddress?.streetNumber}</span> <span class="streetName">${request?.dwellingSocialReceptionAddress?.streetName}</span><p class="placeNameOrService">${request?.dwellingSocialReceptionAddress?.placeNameOrService}</p><span class="postalCode">${request?.dwellingSocialReceptionAddress?.postalCode}</span> <span class="city">${request?.dwellingSocialReceptionAddress?.city}</span><p class="countryName">${request?.dwellingSocialReceptionAddress?.countryName}</p></div>
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
        <span><g:message code="hcar.step.socialSecurityAndPaymentAgency.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hcar.property.socialSecurity.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isSocialSecurityMemberShip-trigger"><g:message code="hcar.property.socialSecurityMemberShipKind.label" /> * : </dt>
                  <dd id="socialSecurityMemberShipKind" class="action-editField validate-capdematEnum required-true i18n-hcar.property.socialSecurityMemberShipKind javatype-fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType" >
                    <g:capdematEnumToField var="${request?.socialSecurityMemberShipKind}" i18nKeyPrefix="hcar.property.socialSecurityMemberShipKind" />
                  </dd>
                
                  <dt class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hcar.property.socialSecurityNumber.label" /> * : </dt>
                  <dd id="socialSecurityNumber" class="action-editField validate- required-true i18n-hcar.property.socialSecurityNumber" >
                    <span>${request?.socialSecurityNumber}</span>
                  </dd>
                
                  <dt class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hcar.property.socialSecurityAgencyName.label" /> * : </dt>
                  <dd id="socialSecurityAgencyName" class="action-editField validate- required-true i18n-hcar.property.socialSecurityAgencyName" >
                    <span>${request?.socialSecurityAgencyName}</span>
                  </dd>
                
                  <dt class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hcar.property.socialSecurityAgencyAddress.label" /> * : </dt>
                  <dd id="socialSecurityAgencyAddress" class="action-editField validate-address required-true i18n-hcar.property.socialSecurityAgencyAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.socialSecurityAgencyAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.socialSecurityAgencyAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.socialSecurityAgencyAddress?.streetNumber}</span> <span class="streetName">${request?.socialSecurityAgencyAddress?.streetName}</span><p class="placeNameOrService">${request?.socialSecurityAgencyAddress?.placeNameOrService}</p><span class="postalCode">${request?.socialSecurityAgencyAddress?.postalCode}</span> <span class="city">${request?.socialSecurityAgencyAddress?.city}</span><p class="countryName">${request?.socialSecurityAgencyAddress?.countryName}</p></div>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="hcar.property.paymentAgency.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isPaymentAgencyBeneficiary-trigger"><g:message code="hcar.property.paymentAgencyBeneficiary.label" /> * : </dt>
                  <dd id="paymentAgencyBeneficiary" class="action-editField validate-capdematEnum required-true i18n-hcar.property.paymentAgencyBeneficiary javatype-fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType" >
                    <g:capdematEnumToField var="${request?.paymentAgencyBeneficiary}" i18nKeyPrefix="hcar.property.paymentAgencyBeneficiary" />
                  </dd>
                
                  <dt class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hcar.property.paymentAgencyBeneficiaryNumber.label" /> * : </dt>
                  <dd id="paymentAgencyBeneficiaryNumber" class="action-editField validate- required-true i18n-hcar.property.paymentAgencyBeneficiaryNumber" >
                    <span>${request?.paymentAgencyBeneficiaryNumber}</span>
                  </dd>
                
                  <dt class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hcar.property.paymentAgencyName.label" /> * : </dt>
                  <dd id="paymentAgencyName" class="action-editField validate- required-true i18n-hcar.property.paymentAgencyName" >
                    <span>${request?.paymentAgencyName}</span>
                  </dd>
                
                  <dt class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hcar.property.paymentAgencyAddress.label" /> * : </dt>
                  <dd id="paymentAgencyAddress" class="action-editField validate-address required-true i18n-hcar.property.paymentAgencyAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.paymentAgencyAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.paymentAgencyAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.paymentAgencyAddress?.streetNumber}</span> <span class="streetName">${request?.paymentAgencyAddress?.streetName}</span><p class="placeNameOrService">${request?.paymentAgencyAddress?.placeNameOrService}</p><span class="postalCode">${request?.paymentAgencyAddress?.postalCode}</span> <span class="city">${request?.paymentAgencyAddress?.city}</span><p class="countryName">${request?.paymentAgencyAddress?.countryName}</p></div>
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
        <span><g:message code="hcar.step.occupationnalAndSchoolStatus.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hcar.property.studies.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isHighSchool-trigger"><g:message code="hcar.property.studiesHighSchool.label" /> * : </dt>
                  <dd id="studiesHighSchool" class="action-editField validate-boolean required-true i18n-hcar.property.studiesHighSchool" >
                    <span class="value-${request?.studiesHighSchool}"><g:message code="message.${request?.studiesHighSchool ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isHighSchool-filled"><g:message code="hcar.property.studiesHighSchoolGrade.label" /> * : </dt>
                  <dd id="studiesHighSchoolGrade" class="action-editField validate- required-true i18n-hcar.property.studiesHighSchoolGrade" >
                    <span>${request?.studiesHighSchoolGrade}</span>
                  </dd>
                
                  <dt class="required condition-isHighSchool-filled"><g:message code="hcar.property.studiesHighSchoolName.label" /> * : </dt>
                  <dd id="studiesHighSchoolName" class="action-editField validate- required-true i18n-hcar.property.studiesHighSchoolName" >
                    <span>${request?.studiesHighSchoolName}</span>
                  </dd>
                
                  <dt class="required condition-isHighSchool-filled"><g:message code="hcar.property.studiesHighSchoolAddress.label" /> * : </dt>
                  <dd id="studiesHighSchoolAddress" class="action-editField validate-address required-true i18n-hcar.property.studiesHighSchoolAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.studiesHighSchoolAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.studiesHighSchoolAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.studiesHighSchoolAddress?.streetNumber}</span> <span class="streetName">${request?.studiesHighSchoolAddress?.streetName}</span><p class="placeNameOrService">${request?.studiesHighSchoolAddress?.placeNameOrService}</p><span class="postalCode">${request?.studiesHighSchoolAddress?.postalCode}</span> <span class="city">${request?.studiesHighSchoolAddress?.city}</span><p class="countryName">${request?.studiesHighSchoolAddress?.countryName}</p></div>
                  </dd>
                
                  <dt class="required condition-isHighSchool-filled condition-isAssistanceUnderDisability-trigger"><g:message code="hcar.property.studiesAssistanceUnderDisability.label" /> * : </dt>
                  <dd id="studiesAssistanceUnderDisability" class="action-editField validate-boolean required-true i18n-hcar.property.studiesAssistanceUnderDisability" >
                    <span class="value-${request?.studiesAssistanceUnderDisability}"><g:message code="message.${request?.studiesAssistanceUnderDisability ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isAssistanceUnderDisability-filled"><g:message code="hcar.property.studiesAssistanceUnderDisabilityDetails.label" /> * : </dt>
                  <dd id="studiesAssistanceUnderDisabilityDetails" class="action-editField validate- required-true i18n-hcar.property.studiesAssistanceUnderDisabilityDetails" >
                    <span>${request?.studiesAssistanceUnderDisabilityDetails}</span>
                  </dd>
                
              </dl>
              
            
              
              <h3><g:message code="hcar.property.formation.label" /></h3>
              <dl class="required">
                
                  <dt class=""><g:message code="hcar.property.formationStudiesLevel.label" />  : </dt>
                  <dd id="formationStudiesLevel" class="action-editField validate- i18n-hcar.property.formationStudiesLevel" >
                    <span>${request?.formationStudiesLevel}</span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.formationDiploma.label" />  : </dt>
                  <dd id="formationDiploma" class="action-editField validate- i18n-hcar.property.formationDiploma" >
                    <span>${request?.formationDiploma}</span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.formationPreviousFormation.label" />  : </dt>
                  <dd id="formationPreviousFormation" class="action-editField validate- i18n-hcar.property.formationPreviousFormation" >
                    <span>${request?.formationPreviousFormation}</span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.formationCurrentFormation.label" />  : </dt>
                  <dd id="formationCurrentFormation" class="action-editField validate- i18n-hcar.property.formationCurrentFormation" >
                    <span>${request?.formationCurrentFormation}</span>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="hcar.property.professionalStatus.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isEmployed-trigger condition-isUnemployed-trigger"><g:message code="hcar.property.professionalStatusKind.label" /> * : </dt>
                  <dd id="professionalStatusKind" class="action-editField validate-capdematEnum required-true i18n-hcar.property.professionalStatusKind javatype-fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType" >
                    <g:capdematEnumToField var="${request?.professionalStatusKind}" i18nKeyPrefix="hcar.property.professionalStatusKind" />
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.professionalStatusDate.label" /> * : </dt>
                  <dd id="professionalStatusDate" class="action-editField validate-date required-true i18n-hcar.property.professionalStatusDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.professionalStatusDate}"/></span>
                  </dd>
                
                  <dt class="required condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusEnvironment.label" /> * : </dt>
                  <dd id="professionalStatusEnvironment" class="action-editField validate-capdematEnum required-true i18n-hcar.property.professionalStatusEnvironment javatype-fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType" >
                    <g:capdematEnumToField var="${request?.professionalStatusEnvironment}" i18nKeyPrefix="hcar.property.professionalStatusEnvironment" />
                  </dd>
                
                  <dt class="required condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusProfession.label" /> * : </dt>
                  <dd id="professionalStatusProfession" class="action-editField validate- required-true i18n-hcar.property.professionalStatusProfession" >
                    <span>${request?.professionalStatusProfession}</span>
                  </dd>
                
                  <dt class="required condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusEmployerName.label" /> * : </dt>
                  <dd id="professionalStatusEmployerName" class="action-editField validate-lastName required-true i18n-hcar.property.professionalStatusEmployerName" >
                    <span>${request?.professionalStatusEmployerName}</span>
                  </dd>
                
                  <dt class="condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusAddress.label" />  : </dt>
                  <dd id="professionalStatusAddress" class="action-editField validate-address i18n-hcar.property.professionalStatusAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.professionalStatusAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.professionalStatusAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.professionalStatusAddress?.streetNumber}</span> <span class="streetName">${request?.professionalStatusAddress?.streetName}</span><p class="placeNameOrService">${request?.professionalStatusAddress?.placeNameOrService}</p><span class="postalCode">${request?.professionalStatusAddress?.postalCode}</span> <span class="city">${request?.professionalStatusAddress?.city}</span><p class="countryName">${request?.professionalStatusAddress?.countryName}</p></div>
                  </dd>
                
                  <dt class="required condition-isUnemployed-filled condition-isRegisteredAsUnemployed-trigger"><g:message code="hcar.property.professionalStatusRegisterAsUnemployed.label" /> * : </dt>
                  <dd id="professionalStatusRegisterAsUnemployed" class="action-editField validate-boolean required-true i18n-hcar.property.professionalStatusRegisterAsUnemployed" >
                    <span class="value-${request?.professionalStatusRegisterAsUnemployed}"><g:message code="message.${request?.professionalStatusRegisterAsUnemployed ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isRegisteredAsUnemployed-filled"><g:message code="hcar.property.professionalStatusRegisterAsUnemployedDate.label" /> * : </dt>
                  <dd id="professionalStatusRegisterAsUnemployedDate" class="action-editField validate-date required-true i18n-hcar.property.professionalStatusRegisterAsUnemployedDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.professionalStatusRegisterAsUnemployedDate}"/></span>
                  </dd>
                
                  <dt class="required condition-isUnemployed-filled condition-isIndemnified-trigger"><g:message code="hcar.property.professionalStatusIndemnified.label" /> * : </dt>
                  <dd id="professionalStatusIndemnified" class="action-editField validate-boolean required-true i18n-hcar.property.professionalStatusIndemnified" >
                    <span class="value-${request?.professionalStatusIndemnified}"><g:message code="message.${request?.professionalStatusIndemnified ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isIndemnified-filled"><g:message code="hcar.property.professionalStatusIndemnifiedDate.label" /> * : </dt>
                  <dd id="professionalStatusIndemnifiedDate" class="action-editField validate-date required-true i18n-hcar.property.professionalStatusIndemnifiedDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.professionalStatusIndemnifiedDate}"/></span>
                  </dd>
                
                  <dt class="required condition-isElectiveFunction-trigger"><g:message code="hcar.property.professionalStatusElectiveFunction.label" /> * : </dt>
                  <dd id="professionalStatusElectiveFunction" class="action-editField validate-boolean required-true i18n-hcar.property.professionalStatusElectiveFunction" >
                    <span class="value-${request?.professionalStatusElectiveFunction}"><g:message code="message.${request?.professionalStatusElectiveFunction ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isElectiveFunction-filled"><g:message code="hcar.property.professionalStatusElectiveFunctionDetails.label" /> * : </dt>
                  <dd id="professionalStatusElectiveFunctionDetails" class="action-editField validate- required-true i18n-hcar.property.professionalStatusElectiveFunctionDetails" >
                    <span>${request?.professionalStatusElectiveFunctionDetails}</span>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page4">
      <h2><g:message code="property.form" />
        <span><g:message code="hcar.step.folders.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hcar.property.folders.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isMDPH-trigger"><g:message code="hcar.property.foldersMdph.label" /> * : </dt>
                  <dd id="foldersMdph" class="action-editField validate-boolean required-true i18n-hcar.property.foldersMdph" >
                    <span class="value-${request?.foldersMdph}"><g:message code="message.${request?.foldersMdph ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isMDPH-filled"><g:message code="hcar.property.foldersMdphNumber.label" />  : </dt>
                  <dd id="foldersMdphNumber" class="action-editField validate- i18n-hcar.property.foldersMdphNumber" >
                    <span>${request?.foldersMdphNumber}</span>
                  </dd>
                
                  <dt class="condition-isMDPH-filled"><g:message code="hcar.property.foldersMdphDepartment.label" />  : </dt>
                  <dd id="foldersMdphDepartment" class="action-editField validate-departmentCode i18n-hcar.property.foldersMdphDepartment" >
                    <span>${request?.foldersMdphDepartment}</span>
                  </dd>
                
                  <dt class="required condition-isCOTOREP-trigger"><g:message code="hcar.property.foldersCotorep.label" /> * : </dt>
                  <dd id="foldersCotorep" class="action-editField validate-boolean required-true i18n-hcar.property.foldersCotorep" >
                    <span class="value-${request?.foldersCotorep}"><g:message code="message.${request?.foldersCotorep ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isCOTOREP-filled"><g:message code="hcar.property.foldersCotorepNumber.label" />  : </dt>
                  <dd id="foldersCotorepNumber" class="action-editField validate- i18n-hcar.property.foldersCotorepNumber" >
                    <span>${request?.foldersCotorepNumber}</span>
                  </dd>
                
                  <dt class="condition-isCOTOREP-filled"><g:message code="hcar.property.foldersCotorepDepartment.label" />  : </dt>
                  <dd id="foldersCotorepDepartment" class="action-editField validate-departmentCode i18n-hcar.property.foldersCotorepDepartment" >
                    <span>${request?.foldersCotorepDepartment}</span>
                  </dd>
                
                  <dt class="required condition-isCDES-trigger"><g:message code="hcar.property.foldersCdes.label" /> * : </dt>
                  <dd id="foldersCdes" class="action-editField validate-boolean required-true i18n-hcar.property.foldersCdes" >
                    <span class="value-${request?.foldersCdes}"><g:message code="message.${request?.foldersCdes ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isCDES-filled"><g:message code="hcar.property.foldersCdesNumber.label" />  : </dt>
                  <dd id="foldersCdesNumber" class="action-editField validate- i18n-hcar.property.foldersCdesNumber" >
                    <span>${request?.foldersCdesNumber}</span>
                  </dd>
                
                  <dt class="condition-isCDES-filled"><g:message code="hcar.property.foldersCdesDepartment.label" />  : </dt>
                  <dd id="foldersCdesDepartment" class="action-editField validate-departmentCode i18n-hcar.property.foldersCdesDepartment" >
                    <span>${request?.foldersCdesDepartment}</span>
                  </dd>
                
                  <dt class="required condition-isOtherFolders-trigger"><g:message code="hcar.property.foldersOtherFolders.label" /> * : </dt>
                  <dd id="foldersOtherFolders" class="action-editField validate-boolean required-true i18n-hcar.property.foldersOtherFolders" >
                    <span class="value-${request?.foldersOtherFolders}"><g:message code="message.${request?.foldersOtherFolders ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-otherFolders">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/otherFolders" model="['request':request]" />
              </div>
              
            
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
    <div id="page5">
      <h2><g:message code="property.form" />
        <span><g:message code="hcar.step.benefits.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="hcar.property.benefits.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isDisabilityRecognition-trigger"><g:message code="hcar.property.benefitsDisabilityRecognition.label" /> * : </dt>
                  <dd id="benefitsDisabilityRecognition" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityRecognition" >
                    <span class="value-${request?.benefitsDisabilityRecognition}"><g:message code="message.${request?.benefitsDisabilityRecognition ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isDisabilityRecognition-filled"><g:message code="hcar.property.benefitsDisabilityRatio.label" /> * : </dt>
                  <dd id="benefitsDisabilityRatio" class="action-editField validate- required-true i18n-hcar.property.benefitsDisabilityRatio" >
                    <span>${request?.benefitsDisabilityRatio}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsDisabilityCard.label" /> * : </dt>
                  <dd id="benefitsDisabilityCard" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityCard" >
                    <span class="value-${request?.benefitsDisabilityCard}"><g:message code="message.${request?.benefitsDisabilityCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsPainfulStandingCard.label" /> * : </dt>
                  <dd id="benefitsPainfulStandingCard" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsPainfulStandingCard" >
                    <span class="value-${request?.benefitsPainfulStandingCard}"><g:message code="message.${request?.benefitsPainfulStandingCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsParkingCard.label" /> * : </dt>
                  <dd id="benefitsParkingCard" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsParkingCard" >
                    <span class="value-${request?.benefitsParkingCard}"><g:message code="message.${request?.benefitsParkingCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsDisabledWorkerRecognition.label" /> * : </dt>
                  <dd id="benefitsDisabledWorkerRecognition" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabledWorkerRecognition" >
                    <span class="value-${request?.benefitsDisabledWorkerRecognition}"><g:message code="message.${request?.benefitsDisabledWorkerRecognition ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isProfessionalOrientation-trigger"><g:message code="hcar.property.benefitsProfessionalOrientation.label" /> * : </dt>
                  <dd id="benefitsProfessionalOrientation" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsProfessionalOrientation" >
                    <span class="value-${request?.benefitsProfessionalOrientation}"><g:message code="message.${request?.benefitsProfessionalOrientation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isProfessionalOrientation-filled"><g:message code="hcar.property.benefitsProfessionalOrientationDetails.label" /> * : </dt>
                  <dd id="benefitsProfessionalOrientationDetails" class="action-editField validate- required-true i18n-hcar.property.benefitsProfessionalOrientationDetails" >
                    <span>${request?.benefitsProfessionalOrientationDetails}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsDisabledAdultAllocation.label" /> * : </dt>
                  <dd id="benefitsDisabledAdultAllocation" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabledAdultAllocation" >
                    <span class="value-${request?.benefitsDisabledAdultAllocation}"><g:message code="message.${request?.benefitsDisabledAdultAllocation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsIncreaseForIndependentLiving.label" /> * : </dt>
                  <dd id="benefitsIncreaseForIndependentLiving" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsIncreaseForIndependentLiving" >
                    <span class="value-${request?.benefitsIncreaseForIndependentLiving}"><g:message code="message.${request?.benefitsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsEducationAllocationOfDisabledChildren.label" /> * : </dt>
                  <dd id="benefitsEducationAllocationOfDisabledChildren" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsEducationAllocationOfDisabledChildren" >
                    <span class="value-${request?.benefitsEducationAllocationOfDisabledChildren}"><g:message code="message.${request?.benefitsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isEducationOfDisabledChildren-trigger"><g:message code="hcar.property.benefitsEducationOfDisabledChildren.label" /> * : </dt>
                  <dd id="benefitsEducationOfDisabledChildren" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsEducationOfDisabledChildren" >
                    <span class="value-${request?.benefitsEducationOfDisabledChildren}"><g:message code="message.${request?.benefitsEducationOfDisabledChildren ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isEducationOfDisabledChildren-filled"><g:message code="hcar.property.benefitsEducationOfDisabledChildrenDetails.label" /> * : </dt>
                  <dd id="benefitsEducationOfDisabledChildrenDetails" class="action-editField validate- required-true i18n-hcar.property.benefitsEducationOfDisabledChildrenDetails" >
                    <span>${request?.benefitsEducationOfDisabledChildrenDetails}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsSupplementForSingleParents.label" /> * : </dt>
                  <dd id="benefitsSupplementForSingleParents" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsSupplementForSingleParents" >
                    <span class="value-${request?.benefitsSupplementForSingleParents}"><g:message code="message.${request?.benefitsSupplementForSingleParents ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsThirdPersonCompensatoryAllowance.label" /> * : </dt>
                  <dd id="benefitsThirdPersonCompensatoryAllowance" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsThirdPersonCompensatoryAllowance" >
                    <span class="value-${request?.benefitsThirdPersonCompensatoryAllowance}"><g:message code="message.${request?.benefitsThirdPersonCompensatoryAllowance ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsThirdPartyCompensatoryAllowance.label" /> * : </dt>
                  <dd id="benefitsThirdPartyCompensatoryAllowance" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsThirdPartyCompensatoryAllowance" >
                    <span class="value-${request?.benefitsThirdPartyCompensatoryAllowance}"><g:message code="message.${request?.benefitsThirdPartyCompensatoryAllowance ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsCompensatoryAllowanceForExpenses.label" /> * : </dt>
                  <dd id="benefitsCompensatoryAllowanceForExpenses" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsCompensatoryAllowanceForExpenses" >
                    <span class="value-${request?.benefitsCompensatoryAllowanceForExpenses}"><g:message code="message.${request?.benefitsCompensatoryAllowanceForExpenses ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsDisabilityCompensation.label" /> * : </dt>
                  <dd id="benefitsDisabilityCompensation" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityCompensation" >
                    <span class="value-${request?.benefitsDisabilityCompensation}"><g:message code="message.${request?.benefitsDisabilityCompensation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isDisabilityPension-trigger"><g:message code="hcar.property.benefitsDisabilityPension.label" /> * : </dt>
                  <dd id="benefitsDisabilityPension" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityPension" >
                    <span class="value-${request?.benefitsDisabilityPension}"><g:message code="message.${request?.benefitsDisabilityPension ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isDisabilityPension-filled"><g:message code="hcar.property.benefitsDisabilityPensionCategory.label" /> * : </dt>
                  <dd id="benefitsDisabilityPensionCategory" class="action-editField validate- required-true i18n-hcar.property.benefitsDisabilityPensionCategory" >
                    <span>${request?.benefitsDisabilityPensionCategory}</span>
                  </dd>
                
                  <dt class="required condition-isWorkAccidentAnnuity-trigger"><g:message code="hcar.property.benefitsWorkAccidentAnnuity.label" /> * : </dt>
                  <dd id="benefitsWorkAccidentAnnuity" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsWorkAccidentAnnuity" >
                    <span class="value-${request?.benefitsWorkAccidentAnnuity}"><g:message code="message.${request?.benefitsWorkAccidentAnnuity ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isWorkAccidentAnnuity-filled"><g:message code="hcar.property.benefitsWorkAccidentAnnuityRatio.label" /> * : </dt>
                  <dd id="benefitsWorkAccidentAnnuityRatio" class="action-editField validate- required-true i18n-hcar.property.benefitsWorkAccidentAnnuityRatio" >
                    <span>${request?.benefitsWorkAccidentAnnuityRatio}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsSocialWelfare.label" /> * : </dt>
                  <dd id="benefitsSocialWelfare" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsSocialWelfare" >
                    <span class="value-${request?.benefitsSocialWelfare}"><g:message code="message.${request?.benefitsSocialWelfare ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsUnemploymentBenefits.label" /> * : </dt>
                  <dd id="benefitsUnemploymentBenefits" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsUnemploymentBenefits" >
                    <span class="value-${request?.benefitsUnemploymentBenefits}"><g:message code="message.${request?.benefitsUnemploymentBenefits ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsDailyAllowances.label" /> * : </dt>
                  <dd id="benefitsDailyAllowances" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDailyAllowances" >
                    <span class="value-${request?.benefitsDailyAllowances}"><g:message code="message.${request?.benefitsDailyAllowances ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hcar.property.benefitsThirdPartySupplement.label" /> * : </dt>
                  <dd id="benefitsThirdPartySupplement" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsThirdPartySupplement" >
                    <span class="value-${request?.benefitsThirdPartySupplement}"><g:message code="message.${request?.benefitsThirdPartySupplement ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSupportedByAnInstitution-trigger"><g:message code="hcar.property.benefitsSupportedByAnInstitution.label" /> * : </dt>
                  <dd id="benefitsSupportedByAnInstitution" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsSupportedByAnInstitution" >
                    <span class="value-${request?.benefitsSupportedByAnInstitution}"><g:message code="message.${request?.benefitsSupportedByAnInstitution ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSupportedByAnInstitution-filled"><g:message code="hcar.property.benefitsSupportedByAnInstitutionDetails.label" /> * : </dt>
                  <dd id="benefitsSupportedByAnInstitutionDetails" class="action-editField validate- required-true i18n-hcar.property.benefitsSupportedByAnInstitutionDetails" >
                    <span>${request?.benefitsSupportedByAnInstitutionDetails}</span>
                  </dd>
                
                  <dt class="required condition-isOtherBenefits-trigger"><g:message code="hcar.property.benefitsOtherBenefits.label" /> * : </dt>
                  <dd id="benefitsOtherBenefits" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsOtherBenefits" >
                    <span class="value-${request?.benefitsOtherBenefits}"><g:message code="message.${request?.benefitsOtherBenefits ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-otherBenefits">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/otherBenefits" model="['request':request]" />
              </div>
              
            
              
              <div id="widget-additionalFee">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/additionalFee" model="['request':request]" />
              </div>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page6">
      <h2><g:message code="property.form" />
        <span><g:message code="hcar.step.aid.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="hcar.property.familyAssistance.label" /></h3>
              <dl class="">
                
                  <dt class="required condition-isFamilyAssistance-trigger"><g:message code="hcar.property.isFamilyAssistance.label" /> * : </dt>
                  <dd id="isFamilyAssistance" class="action-editField validate-boolean required-true i18n-hcar.property.isFamilyAssistance" >
                    <span class="value-${request?.isFamilyAssistance}"><g:message code="message.${request?.isFamilyAssistance ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-familyAssistanceMembers">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/familyAssistanceMembers" model="['request':request]" />
              </div>
              
            
              
              <h3><g:message code="hcar.property.homeIntervention.label" /></h3>
              <dl class="">
                
                  <dt class="required condition-isHomeIntervenant-trigger"><g:message code="hcar.property.homeInterventionHomeIntervenant.label" /> * : </dt>
                  <dd id="homeInterventionHomeIntervenant" class="action-editField validate-boolean required-true i18n-hcar.property.homeInterventionHomeIntervenant" >
                    <span class="value-${request?.homeInterventionHomeIntervenant}"><g:message code="message.${request?.homeInterventionHomeIntervenant ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-homeIntervenants">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/homeIntervenants" model="['request':request]" />
              </div>
              
            
              
              <h3><g:message code="hcar.property.care.label" /></h3>
              <dl class="">
                
                  <dt class="required condition-isCareServices-trigger"><g:message code="hcar.property.careCareServices.label" /> * : </dt>
                  <dd id="careCareServices" class="action-editField validate-boolean required-true i18n-hcar.property.careCareServices" >
                    <span class="value-${request?.careCareServices}"><g:message code="message.${request?.careCareServices ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-careServices">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/careServices" model="['request':request]" />
              </div>
              
            
              
              <h3><g:message code="hcar.property.facilities.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isHousing-trigger"><g:message code="hcar.property.facilitiesHousing.label" /> * : </dt>
                  <dd id="facilitiesHousing" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesHousing" >
                    <span class="value-${request?.facilitiesHousing}"><g:message code="message.${request?.facilitiesHousing ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isHousing-filled"><g:message code="hcar.property.facilitiesHousingDetails.label" /> * : </dt>
                  <dd id="facilitiesHousingDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesHousingDetails" >
                    <span>${request?.facilitiesHousingDetails}</span>
                  </dd>
                
                  <dt class="required condition-isTechnicalAssistance-trigger"><g:message code="hcar.property.facilitiesTechnicalAssistance.label" /> * : </dt>
                  <dd id="facilitiesTechnicalAssistance" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesTechnicalAssistance" >
                    <span class="value-${request?.facilitiesTechnicalAssistance}"><g:message code="message.${request?.facilitiesTechnicalAssistance ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isTechnicalAssistance-filled"><g:message code="hcar.property.facilitiesTechnicalAssistanceDetails.label" /> * : </dt>
                  <dd id="facilitiesTechnicalAssistanceDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesTechnicalAssistanceDetails" >
                    <span>${request?.facilitiesTechnicalAssistanceDetails}</span>
                  </dd>
                
                  <dt class="required condition-isCustomCar-trigger"><g:message code="hcar.property.facilitiesCustomCar.label" /> * : </dt>
                  <dd id="facilitiesCustomCar" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesCustomCar" >
                    <span class="value-${request?.facilitiesCustomCar}"><g:message code="message.${request?.facilitiesCustomCar ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isCustomCar-filled"><g:message code="hcar.property.facilitiesCustomCarDetails.label" /> * : </dt>
                  <dd id="facilitiesCustomCarDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesCustomCarDetails" >
                    <span>${request?.facilitiesCustomCarDetails}</span>
                  </dd>
                
                  <dt class="required condition-isAnimalAid-trigger"><g:message code="hcar.property.facilitiesAnimalAid.label" /> * : </dt>
                  <dd id="facilitiesAnimalAid" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesAnimalAid" >
                    <span class="value-${request?.facilitiesAnimalAid}"><g:message code="message.${request?.facilitiesAnimalAid ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isAnimalAid-filled"><g:message code="hcar.property.facilitiesAnimalAidDetails.label" /> * : </dt>
                  <dd id="facilitiesAnimalAidDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesAnimalAidDetails" >
                    <span>${request?.facilitiesAnimalAidDetails}</span>
                  </dd>
                
                  <dt class="required condition-isSpecializedTransport-trigger"><g:message code="hcar.property.facilitiesSpecializedTransport.label" /> * : </dt>
                  <dd id="facilitiesSpecializedTransport" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesSpecializedTransport" >
                    <span class="value-${request?.facilitiesSpecializedTransport}"><g:message code="message.${request?.facilitiesSpecializedTransport ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSpecializedTransport-filled"><g:message code="hcar.property.facilitiesSpecializedTransportDetails.label" /> * : </dt>
                  <dd id="facilitiesSpecializedTransportDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesSpecializedTransportDetails" >
                    <span>${request?.facilitiesSpecializedTransportDetails}</span>
                  </dd>
                
              </dl>
              
            
              
              <h3><g:message code="hcar.property.professionalSupport.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isProfessionals-trigger"><g:message code="hcar.property.professionalSupportProfessionals.label" /> * : </dt>
                  <dd id="professionalSupportProfessionals" class="action-editField validate-boolean required-true i18n-hcar.property.professionalSupportProfessionals" >
                    <span class="value-${request?.professionalSupportProfessionals}"><g:message code="message.${request?.professionalSupportProfessionals ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isProfessionals-filled"><g:message code="hcar.property.professionalSupportDealsWithSameProfessional.label" /> * : </dt>
                  <dd id="professionalSupportDealsWithSameProfessional" class="action-editField validate-boolean required-true i18n-hcar.property.professionalSupportDealsWithSameProfessional" >
                    <span class="value-${request?.professionalSupportDealsWithSameProfessional}"><g:message code="message.${request?.professionalSupportDealsWithSameProfessional ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-professionals">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/professionals" model="['request':request]" />
              </div>
              
            
              
              <h3><g:message code="hcar.property.socialService.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isSocialServiceSupport-trigger"><g:message code="hcar.property.professionalSupportSocialServiceSupport.label" /> * : </dt>
                  <dd id="professionalSupportSocialServiceSupport" class="action-editField validate-boolean required-true i18n-hcar.property.professionalSupportSocialServiceSupport" >
                    <span class="value-${request?.professionalSupportSocialServiceSupport}"><g:message code="message.${request?.professionalSupportSocialServiceSupport ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSocialServiceSupport-filled"><g:message code="hcar.property.professionalSupportSocialServiceName.label" /> * : </dt>
                  <dd id="professionalSupportSocialServiceName" class="action-editField validate- required-true i18n-hcar.property.professionalSupportSocialServiceName" >
                    <span>${request?.professionalSupportSocialServiceName}</span>
                  </dd>
                
                  <dt class="required condition-isSocialServiceSupport-filled"><g:message code="hcar.property.professionalSupportSocialServiceAddress.label" /> * : </dt>
                  <dd id="professionalSupportSocialServiceAddress" class="action-editField validate-address required-true i18n-hcar.property.professionalSupportSocialServiceAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.professionalSupportSocialServiceAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.professionalSupportSocialServiceAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.professionalSupportSocialServiceAddress?.streetNumber}</span> <span class="streetName">${request?.professionalSupportSocialServiceAddress?.streetName}</span><p class="placeNameOrService">${request?.professionalSupportSocialServiceAddress?.placeNameOrService}</p><span class="postalCode">${request?.professionalSupportSocialServiceAddress?.postalCode}</span> <span class="city">${request?.professionalSupportSocialServiceAddress?.city}</span><p class="countryName">${request?.professionalSupportSocialServiceAddress?.countryName}</p></div>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page7">
      <h2><g:message code="property.form" />
        <span><g:message code="hcar.step.health.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hcar.property.health.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isFollowedByDoctor-trigger"><g:message code="hcar.property.healthFollowedByDoctor.label" /> * : </dt>
                  <dd id="healthFollowedByDoctor" class="action-editField validate-boolean required-true i18n-hcar.property.healthFollowedByDoctor" >
                    <span class="value-${request?.healthFollowedByDoctor}"><g:message code="message.${request?.healthFollowedByDoctor ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isFollowedByDoctor-filled"><g:message code="hcar.property.healthDoctorLastName.label" /> * : </dt>
                  <dd id="healthDoctorLastName" class="action-editField validate-lastName required-true i18n-hcar.property.healthDoctorLastName" >
                    <span>${request?.healthDoctorLastName}</span>
                  </dd>
                
                  <dt class="required condition-isFollowedByDoctor-filled"><g:message code="hcar.property.healthDoctorFirstName.label" /> * : </dt>
                  <dd id="healthDoctorFirstName" class="action-editField validate-firstName required-true i18n-hcar.property.healthDoctorFirstName" >
                    <span>${request?.healthDoctorFirstName}</span>
                  </dd>
                
                  <dt class="required condition-isFollowedByProfessional-trigger"><g:message code="hcar.property.healthFollowedByProfessional.label" /> * : </dt>
                  <dd id="healthFollowedByProfessional" class="action-editField validate-boolean required-true i18n-hcar.property.healthFollowedByProfessional" >
                    <span class="value-${request?.healthFollowedByProfessional}"><g:message code="message.${request?.healthFollowedByProfessional ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isFollowedByProfessional-filled"><g:message code="hcar.property.healthProfessionalLastName.label" /> * : </dt>
                  <dd id="healthProfessionalLastName" class="action-editField validate-lastName required-true i18n-hcar.property.healthProfessionalLastName" >
                    <span>${request?.healthProfessionalLastName}</span>
                  </dd>
                
                  <dt class="required condition-isFollowedByProfessional-filled"><g:message code="hcar.property.healthProfessionalFirstName.label" /> * : </dt>
                  <dd id="healthProfessionalFirstName" class="action-editField validate-firstName required-true i18n-hcar.property.healthProfessionalFirstName" >
                    <span>${request?.healthProfessionalFirstName}</span>
                  </dd>
                
                  <dt class="required condition-isFollowedByHospital-trigger"><g:message code="hcar.property.healthFollowedByHospital.label" /> * : </dt>
                  <dd id="healthFollowedByHospital" class="action-editField validate-boolean required-true i18n-hcar.property.healthFollowedByHospital" >
                    <span class="value-${request?.healthFollowedByHospital}"><g:message code="message.${request?.healthFollowedByHospital ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isFollowedByHospital-filled"><g:message code="hcar.property.healthHospitalName.label" /> * : </dt>
                  <dd id="healthHospitalName" class="action-editField validate- required-true i18n-hcar.property.healthHospitalName" >
                    <span>${request?.healthHospitalName}</span>
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
    <div id="page8">
      <h2><g:message code="property.form" />
        <span><g:message code="hcar.step.project.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hcar.property.projectRequests.label" /></h3>
              <dl class="required">
                
                  <dt class=""><g:message code="hcar.property.projectRequestsHandicapRecognition.label" />  : </dt>
                  <dd id="projectRequestsHandicapRecognition" class="action-editField validate-boolean i18n-hcar.property.projectRequestsHandicapRecognition" >
                    <span class="value-${request?.projectRequestsHandicapRecognition}"><g:message code="message.${request?.projectRequestsHandicapRecognition ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsDisabilityCard.label" />  : </dt>
                  <dd id="projectRequestsDisabilityCard" class="action-editField validate-boolean i18n-hcar.property.projectRequestsDisabilityCard" >
                    <span class="value-${request?.projectRequestsDisabilityCard}"><g:message code="message.${request?.projectRequestsDisabilityCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsDisabledPriorityCard.label" />  : </dt>
                  <dd id="projectRequestsDisabledPriorityCard" class="action-editField validate-boolean i18n-hcar.property.projectRequestsDisabledPriorityCard" >
                    <span class="value-${request?.projectRequestsDisabledPriorityCard}"><g:message code="message.${request?.projectRequestsDisabledPriorityCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsEuropeanParkingCard.label" />  : </dt>
                  <dd id="projectRequestsEuropeanParkingCard" class="action-editField validate-boolean i18n-hcar.property.projectRequestsEuropeanParkingCard" >
                    <span class="value-${request?.projectRequestsEuropeanParkingCard}"><g:message code="message.${request?.projectRequestsEuropeanParkingCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsDisabledAdultAllowance.label" />  : </dt>
                  <dd id="projectRequestsDisabledAdultAllowance" class="action-editField validate-boolean i18n-hcar.property.projectRequestsDisabledAdultAllowance" >
                    <span class="value-${request?.projectRequestsDisabledAdultAllowance}"><g:message code="message.${request?.projectRequestsDisabledAdultAllowance ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsIncreaseForIndependentLiving.label" />  : </dt>
                  <dd id="projectRequestsIncreaseForIndependentLiving" class="action-editField validate-boolean i18n-hcar.property.projectRequestsIncreaseForIndependentLiving" >
                    <span class="value-${request?.projectRequestsIncreaseForIndependentLiving}"><g:message code="message.${request?.projectRequestsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsEducationAllocationOfDisabledChildren.label" />  : </dt>
                  <dd id="projectRequestsEducationAllocationOfDisabledChildren" class="action-editField validate-boolean i18n-hcar.property.projectRequestsEducationAllocationOfDisabledChildren" >
                    <span class="value-${request?.projectRequestsEducationAllocationOfDisabledChildren}"><g:message code="message.${request?.projectRequestsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsACTPRenewal.label" />  : </dt>
                  <dd id="projectRequestsACTPRenewal" class="action-editField validate-boolean i18n-hcar.property.projectRequestsACTPRenewal" >
                    <span class="value-${request?.projectRequestsACTPRenewal}"><g:message code="message.${request?.projectRequestsACTPRenewal ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsThirdPartyHelp.label" />  : </dt>
                  <dd id="projectRequestsThirdPartyHelp" class="action-editField validate-boolean i18n-hcar.property.projectRequestsThirdPartyHelp" >
                    <span class="value-${request?.projectRequestsThirdPartyHelp}"><g:message code="message.${request?.projectRequestsThirdPartyHelp ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsFreePensionMembership.label" />  : </dt>
                  <dd id="projectRequestsFreePensionMembership" class="action-editField validate-boolean i18n-hcar.property.projectRequestsFreePensionMembership" >
                    <span class="value-${request?.projectRequestsFreePensionMembership}"><g:message code="message.${request?.projectRequestsFreePensionMembership ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsTechnicalHelp.label" />  : </dt>
                  <dd id="projectRequestsTechnicalHelp" class="action-editField validate-boolean i18n-hcar.property.projectRequestsTechnicalHelp" >
                    <span class="value-${request?.projectRequestsTechnicalHelp}"><g:message code="message.${request?.projectRequestsTechnicalHelp ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsHousingFacilities.label" />  : </dt>
                  <dd id="projectRequestsHousingFacilities" class="action-editField validate-boolean i18n-hcar.property.projectRequestsHousingFacilities" >
                    <span class="value-${request?.projectRequestsHousingFacilities}"><g:message code="message.${request?.projectRequestsHousingFacilities ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsCustomCar.label" />  : </dt>
                  <dd id="projectRequestsCustomCar" class="action-editField validate-boolean i18n-hcar.property.projectRequestsCustomCar" >
                    <span class="value-${request?.projectRequestsCustomCar}"><g:message code="message.${request?.projectRequestsCustomCar ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsAssistance.label" />  : </dt>
                  <dd id="projectRequestsAssistance" class="action-editField validate-boolean i18n-hcar.property.projectRequestsAssistance" >
                    <span class="value-${request?.projectRequestsAssistance}"><g:message code="message.${request?.projectRequestsAssistance ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsTransportCostAllocation.label" />  : </dt>
                  <dd id="projectRequestsTransportCostAllocation" class="action-editField validate-boolean i18n-hcar.property.projectRequestsTransportCostAllocation" >
                    <span class="value-${request?.projectRequestsTransportCostAllocation}"><g:message code="message.${request?.projectRequestsTransportCostAllocation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsDisabilityCostAllocation.label" />  : </dt>
                  <dd id="projectRequestsDisabilityCostAllocation" class="action-editField validate-boolean i18n-hcar.property.projectRequestsDisabilityCostAllocation" >
                    <span class="value-${request?.projectRequestsDisabilityCostAllocation}"><g:message code="message.${request?.projectRequestsDisabilityCostAllocation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsDisabledWorkerRecognition.label" />  : </dt>
                  <dd id="projectRequestsDisabledWorkerRecognition" class="action-editField validate-boolean i18n-hcar.property.projectRequestsDisabledWorkerRecognition" >
                    <span class="value-${request?.projectRequestsDisabledWorkerRecognition}"><g:message code="message.${request?.projectRequestsDisabledWorkerRecognition ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isProfessionalOrientationRequest-trigger"><g:message code="hcar.property.projectRequestsProfessionalOrientation.label" />  : </dt>
                  <dd id="projectRequestsProfessionalOrientation" class="action-editField validate-boolean i18n-hcar.property.projectRequestsProfessionalOrientation" >
                    <span class="value-${request?.projectRequestsProfessionalOrientation}"><g:message code="message.${request?.projectRequestsProfessionalOrientation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isProfessionalOrientationRequest-filled"><g:message code="hcar.property.projectRequestsOrdinaryWorking.label" />  : </dt>
                  <dd id="projectRequestsOrdinaryWorking" class="action-editField validate-boolean i18n-hcar.property.projectRequestsOrdinaryWorking" >
                    <span class="value-${request?.projectRequestsOrdinaryWorking}"><g:message code="message.${request?.projectRequestsOrdinaryWorking ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isProfessionalOrientationRequest-filled"><g:message code="hcar.property.projectRequestsShelteredWork.label" />  : </dt>
                  <dd id="projectRequestsShelteredWork" class="action-editField validate-boolean i18n-hcar.property.projectRequestsShelteredWork" >
                    <span class="value-${request?.projectRequestsShelteredWork}"><g:message code="message.${request?.projectRequestsShelteredWork ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isProfessionalOrientationRequest-filled"><g:message code="hcar.property.projectRequestsVocationalTraining.label" />  : </dt>
                  <dd id="projectRequestsVocationalTraining" class="action-editField validate-boolean i18n-hcar.property.projectRequestsVocationalTraining" >
                    <span class="value-${request?.projectRequestsVocationalTraining}"><g:message code="message.${request?.projectRequestsVocationalTraining ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hcar.property.projectRequestsInstitutionSupport.label" />  : </dt>
                  <dd id="projectRequestsInstitutionSupport" class="action-editField validate-boolean i18n-hcar.property.projectRequestsInstitutionSupport" >
                    <span class="value-${request?.projectRequestsInstitutionSupport}"><g:message code="message.${request?.projectRequestsInstitutionSupport ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isOtherRequest-trigger"><g:message code="hcar.property.projectRequestsOther.label" />  : </dt>
                  <dd id="projectRequestsOther" class="action-editField validate-boolean i18n-hcar.property.projectRequestsOther" >
                    <span class="value-${request?.projectRequestsOther}"><g:message code="message.${request?.projectRequestsOther ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isOtherRequest-filled"><g:message code="hcar.property.projectRequestsOtherDetails.label" /> * : </dt>
                  <dd id="projectRequestsOtherDetails" class="action-editField validate- required-true i18n-hcar.property.projectRequestsOtherDetails" >
                    <span>${request?.projectRequestsOtherDetails}</span>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class=""><g:message code="hcar.property.projectWish.label" />  : </dt>
                <dd id="projectWish" class="action-editField validate- i18n-hcar.property.projectWish" >
                  <span>${request?.projectWish}</span>
                </dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="hcar.property.projectNeeds.label" />  : </dt>
                <dd id="projectNeeds" class="action-editField validate- i18n-hcar.property.projectNeeds" >
                  <span>${request?.projectNeeds}</span>
                </dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="hcar.property.projectComments.label" />  : </dt>
                <dd id="projectComments" class="action-editField validate- i18n-hcar.property.projectComments" >
                  <span>${request?.projectComments}</span>
                </dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    
  </div>
  
</div>
