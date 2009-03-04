


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
              <dd id="dwellingPrecision" class="action-editField validate-textarea required-true i18n-hcar.property.dwellingPrecision rows-2" >
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
              <dd id="formationDiploma" class="action-editField validate-textarea i18n-hcar.property.formationDiploma rows-2" >
                <span>${request?.formationDiploma}</span>
              </dd>
            
              <dt class=""><g:message code="hcar.property.formationPreviousFormation.label" />  : </dt>
              <dd id="formationPreviousFormation" class="action-editField validate-textarea i18n-hcar.property.formationPreviousFormation rows-3" >
                <span>${request?.formationPreviousFormation}</span>
              </dd>
            
              <dt class=""><g:message code="hcar.property.formationCurrentFormation.label" />  : </dt>
              <dd id="formationCurrentFormation" class="action-editField validate-textarea i18n-hcar.property.formationCurrentFormation rows-2" >
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

