



<!-- step start -->
<div id="page0">
  <h2><g:message code="property.form" />
    <span><g:message code="hccr.step.subject.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
        
        <h3><g:message code="hccr.property.hccrSubject.label" /></h3>
        <dl class="required">
          
              <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${request?.subjectFirstName} ${request?.subjectLastName}</span></dd>
          
          
              <dt class="required condition-isLessThan18-trigger"><g:message code="hccr.property.subjectBirthDate.label" /> * : </dt><dd id="subjectBirthDate" class="action-editField validate-date required-true i18n-hccr.property.subjectBirthDate" ><span><g:formatDate formatName="format.date" date="${request?.subjectBirthDate}"/></span></dd>
          
              <dt class="required"><g:message code="hccr.property.subjectBirthCity.label" /> * : </dt><dd id="subjectBirthCity" class="action-editField validate-city required-true i18n-hccr.property.subjectBirthCity maxLength-32" ><span>${request?.subjectBirthCity}</span></dd>
          
              <dt class="required"><g:message code="hccr.property.subjectBirthCountry.label" /> * : </dt><dd id="subjectBirthCountry" class="action-editField validate- required-true i18n-hccr.property.subjectBirthCountry maxLength-50" ><span>${request?.subjectBirthCountry}</span></dd>
          
              <dt class="required condition-isLessThan18-filled"><g:message code="hccr.property.subjectParentalAuthorityHolder.label" /> * : </dt><dd id="subjectParentalAuthorityHolder" class="action-editField validate-capdematEnum required-true i18n-hccr.property.subjectParentalAuthorityHolder javatype-fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType" ><g:capdematEnumToField var="${request?.subjectParentalAuthorityHolder}" i18nKeyPrefix="hccr.property.subjectParentalAuthorityHolder" /></dd>
          
        </dl>
        
      
    </div>
    <!-- column end -->
    
    <!-- column start -->
    <div class="yui-u">
      
        
        <h3><g:message code="hccr.property.father.label" /></h3>
        <dl class="required condition-isLessThan18-filled">
          
              <dt class=""><g:message code="hccr.property.fatherLastName.label" />  : </dt><dd id="fatherLastName" class="action-editField validate-lastName i18n-hccr.property.fatherLastName maxLength-38" ><span>${request?.fatherLastName}</span></dd>
          
              <dt class=""><g:message code="hccr.property.fatherFirstName.label" />  : </dt><dd id="fatherFirstName" class="action-editField validate-firstName i18n-hccr.property.fatherFirstName maxLength-38" ><span>${request?.fatherFirstName}</span></dd>
          
              <dt class=""><g:message code="hccr.property.fatherJob.label" />  : </dt><dd id="fatherJob" class="action-editField validate- i18n-hccr.property.fatherJob maxLength-60" ><span>${request?.fatherJob}</span></dd>
          
              <dt class="condition-isFatherActivityReduction-trigger"><g:message code="hccr.property.fatherActivityReduction.label" />  : </dt><dd id="fatherActivityReduction" class="action-editField validate-boolean i18n-hccr.property.fatherActivityReduction" ><span class="value-${request?.fatherActivityReduction}"><g:message code="message.${request?.fatherActivityReduction ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="condition-isFatherActivityReduction-filled"><g:message code="hccr.property.fatherActivityReductionRatio.label" />  : </dt><dd id="fatherActivityReductionRatio" class="action-editField validate-positiveInteger i18n-hccr.property.fatherActivityReductionRatio" ><span>${request?.fatherActivityReductionRatio}</span></dd>
          
        </dl>
        
      
        
        <h3><g:message code="hccr.property.mother.label" /></h3>
        <dl class="required condition-isLessThan18-filled">
          
              <dt class=""><g:message code="hccr.property.motherLastName.label" />  : </dt><dd id="motherLastName" class="action-editField validate-lastName i18n-hccr.property.motherLastName maxLength-38" ><span>${request?.motherLastName}</span></dd>
          
              <dt class=""><g:message code="hccr.property.motherFirstName.label" />  : </dt><dd id="motherFirstName" class="action-editField validate-firstName i18n-hccr.property.motherFirstName maxLength-38" ><span>${request?.motherFirstName}</span></dd>
          
              <dt class=""><g:message code="hccr.property.motherJob.label" />  : </dt><dd id="motherJob" class="action-editField validate- i18n-hccr.property.motherJob maxLength-60" ><span>${request?.motherJob}</span></dd>
          
              <dt class="condition-isMotherActivityReduction-trigger"><g:message code="hccr.property.motherActivityReduction.label" />  : </dt><dd id="motherActivityReduction" class="action-editField validate-boolean i18n-hccr.property.motherActivityReduction" ><span class="value-${request?.motherActivityReduction}"><g:message code="message.${request?.motherActivityReduction ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="condition-isMotherActivityReduction-filled"><g:message code="hccr.property.motherActivityReductionRatio.label" />  : </dt><dd id="motherActivityReductionRatio" class="action-editField validate-positiveInteger i18n-hccr.property.motherActivityReductionRatio" ><span>${request?.motherActivityReductionRatio}</span></dd>
          
        </dl>
        
      
        
        <h3><g:message code="hccr.property.aseReferent.label" /></h3>
        <dl class="required condition-isLessThan18-filled">
          
              <dt class=""><g:message code="hccr.property.aseReferentLastName.label" />  : </dt><dd id="aseReferentLastName" class="action-editField validate-lastName i18n-hccr.property.aseReferentLastName maxLength-38" ><span>${request?.aseReferentLastName}</span></dd>
          
              <dt class=""><g:message code="hccr.property.aseReferentDepartment.label" />  : </dt><dd id="aseReferentDepartment" class="action-editField validate-departmentCode i18n-hccr.property.aseReferentDepartment maxLength-2" ><span>${request?.aseReferentDepartment}</span></dd>
          
        </dl>
        
      
        
        <h3><g:message code="hccr.property.referent.label" /></h3>
        <dl class="required">
          
              <dt class="required"><g:message code="hccr.property.referentLastName.label" /> * : </dt><dd id="referentLastName" class="action-editField validate-lastName required-true i18n-hccr.property.referentLastName maxLength-38" ><span>${request?.referentLastName}</span></dd>
          
              <dt class="required"><g:message code="hccr.property.referentFirstName.label" /> * : </dt><dd id="referentFirstName" class="action-editField validate-firstName required-true i18n-hccr.property.referentFirstName maxLength-38" ><span>${request?.referentFirstName}</span></dd>
          
              <dt class="required condition-isReferentMadam-trigger"><g:message code="hccr.property.referentTitle.label" /> * : </dt><dd id="referentTitle" class="action-editField validate-capdematEnum required-true i18n-hccr.property.referentTitle javatype-fr.cg95.cvq.business.users.TitleType" ><g:capdematEnumToField var="${request?.referentTitle}" i18nKeyPrefix="hccr.property.referentTitle" /></dd>
          
              <dt class="required condition-isReferentMadam-filled"><g:message code="hccr.property.referentMaidenName.label" /> * : </dt><dd id="referentMaidenName" class="action-editField validate-lastName required-true i18n-hccr.property.referentMaidenName maxLength-38" ><span>${request?.referentMaidenName}</span></dd>
          
              <dt class="required"><g:message code="hccr.property.referentBirthDate.label" /> * : </dt><dd id="referentBirthDate" class="action-editField validate-date required-true i18n-hccr.property.referentBirthDate" ><span><g:formatDate formatName="format.date" date="${request?.referentBirthDate}"/></span></dd>
          
              <dt class="required"><g:message code="hccr.property.referentBirthCity.label" /> * : </dt><dd id="referentBirthCity" class="action-editField validate-city required-true i18n-hccr.property.referentBirthCity maxLength-32" ><span>${request?.referentBirthCity}</span></dd>
          
              <dt class="required"><g:message code="hccr.property.referentBirthCountry.label" /> * : </dt><dd id="referentBirthCountry" class="action-editField validate- required-true i18n-hccr.property.referentBirthCountry maxLength-50" ><span>${request?.referentBirthCountry}</span></dd>
          
              <dt class="required"><g:message code="hccr.property.referentFamilyStatus.label" /> * : </dt><dd id="referentFamilyStatus" class="action-editField validate-capdematEnum required-true i18n-hccr.property.referentFamilyStatus javatype-fr.cg95.cvq.business.users.FamilyStatusType" ><g:capdematEnumToField var="${request?.referentFamilyStatus}" i18nKeyPrefix="hccr.property.referentFamilyStatus" /></dd>
          
              <dt class="required condition-isReferentFamilyDependents-trigger"><g:message code="hccr.property.referentFamilyDependents.label" /> * : </dt><dd id="referentFamilyDependents" class="action-editField validate-boolean required-true i18n-hccr.property.referentFamilyDependents" ><span class="value-${request?.referentFamilyDependents}"><g:message code="message.${request?.referentFamilyDependents ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-familyDependents" class="required condition-isReferentFamilyDependents-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/familyDependents" model="['request':request]" />
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
    <span><g:message code="hccr.step.dwelling.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
        
        <h3><g:message code="hccr.property.dwelling.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isNotPlaceOfResidence-trigger"><g:message code="hccr.property.dwellingKind.label" /> * : </dt><dd id="dwellingKind" class="action-editField validate-capdematEnum required-true i18n-hccr.property.dwellingKind javatype-fr.cg95.cvq.business.request.social.HccrDwellingKindType" ><g:capdematEnumToField var="${request?.dwellingKind}" i18nKeyPrefix="hccr.property.dwellingKind" /></dd>
          
              <dt class="required condition-isNotPlaceOfResidence-filled"><g:message code="hccr.property.dwellingPrecision.label" /> * : </dt><dd id="dwellingPrecision" class="action-editField validate-textarea required-true i18n-hccr.property.dwellingPrecision rows-2 maxLength-120" ><span>${request?.dwellingPrecision}</span></dd>
          
              <dt class="required condition-isInEstablishmentReception-trigger"><g:message code="hccr.property.dwellingEstablishmentReception.label" /> * : </dt><dd id="dwellingEstablishmentReception" class="action-editField validate-boolean required-true i18n-hccr.property.dwellingEstablishmentReception" ><span class="value-${request?.dwellingEstablishmentReception}"><g:message code="message.${request?.dwellingEstablishmentReception ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isInEstablishmentReception-filled"><g:message code="hccr.property.dwellingReceptionType.label" /> * : </dt><dd id="dwellingReceptionType" class="action-editField validate-capdematEnum required-true i18n-hccr.property.dwellingReceptionType javatype-fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType" ><g:capdematEnumToField var="${request?.dwellingReceptionType}" i18nKeyPrefix="hccr.property.dwellingReceptionType" /></dd>
          
              <dt class="required condition-isInEstablishmentReception-filled"><g:message code="hccr.property.dwellingReceptionNaming.label" /> * : </dt><dd id="dwellingReceptionNaming" class="action-editField validate- required-true i18n-hccr.property.dwellingReceptionNaming maxLength-80" ><span>${request?.dwellingReceptionNaming}</span></dd>
          
              <dt class="required condition-isInEstablishmentReception-filled"><g:message code="hccr.property.dwellingReceptionAddress.label" /> * : </dt><dd id="dwellingReceptionAddress" class="action-editField validate-address required-true i18n-hccr.property.dwellingReceptionAddress" ><div><p class="additionalDeliveryInformation">${request?.dwellingReceptionAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.dwellingReceptionAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.dwellingReceptionAddress?.streetNumber}</span> <span class="streetName">${request?.dwellingReceptionAddress?.streetName}</span><p class="placeNameOrService">${request?.dwellingReceptionAddress?.placeNameOrService}</p><span class="postalCode">${request?.dwellingReceptionAddress?.postalCode}</span> <span class="city">${request?.dwellingReceptionAddress?.city}</span><p class="countryName">${request?.dwellingReceptionAddress?.countryName}</p></div></dd>
          
              <dt class="required condition-isInSocialReception-trigger"><g:message code="hccr.property.dwellingSocialReception.label" /> * : </dt><dd id="dwellingSocialReception" class="action-editField validate-boolean required-true i18n-hccr.property.dwellingSocialReception" ><span class="value-${request?.dwellingSocialReception}"><g:message code="message.${request?.dwellingSocialReception ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isInSocialReception-filled"><g:message code="hccr.property.dwellingSocialReceptionNaming.label" /> * : </dt><dd id="dwellingSocialReceptionNaming" class="action-editField validate- required-true i18n-hccr.property.dwellingSocialReceptionNaming maxLength-80" ><span>${request?.dwellingSocialReceptionNaming}</span></dd>
          
              <dt class="required condition-isInSocialReception-filled"><g:message code="hccr.property.dwellingSocialReceptionAddress.label" /> * : </dt><dd id="dwellingSocialReceptionAddress" class="action-editField validate-address required-true i18n-hccr.property.dwellingSocialReceptionAddress" ><div><p class="additionalDeliveryInformation">${request?.dwellingSocialReceptionAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.dwellingSocialReceptionAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.dwellingSocialReceptionAddress?.streetNumber}</span> <span class="streetName">${request?.dwellingSocialReceptionAddress?.streetName}</span><p class="placeNameOrService">${request?.dwellingSocialReceptionAddress?.placeNameOrService}</p><span class="postalCode">${request?.dwellingSocialReceptionAddress?.postalCode}</span> <span class="city">${request?.dwellingSocialReceptionAddress?.city}</span><p class="countryName">${request?.dwellingSocialReceptionAddress?.countryName}</p></div></dd>
          
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
    <span><g:message code="hccr.step.socialSecurityAndPaymentAgency.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
        
        <h3><g:message code="hccr.property.socialSecurity.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isSocialSecurityMemberShip-trigger"><g:message code="hccr.property.socialSecurityMemberShipKind.label" /> * : </dt><dd id="socialSecurityMemberShipKind" class="action-editField validate-capdematEnum required-true i18n-hccr.property.socialSecurityMemberShipKind javatype-fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType" ><g:capdematEnumToField var="${request?.socialSecurityMemberShipKind}" i18nKeyPrefix="hccr.property.socialSecurityMemberShipKind" /></dd>
          
              <dt class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hccr.property.socialSecurityNumber.label" /> * : </dt><dd id="socialSecurityNumber" class="action-editField validate- required-true i18n-hccr.property.socialSecurityNumber" ><span>${request?.socialSecurityNumber}</span></dd>
          
              <dt class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hccr.property.socialSecurityAgencyName.label" /> * : </dt><dd id="socialSecurityAgencyName" class="action-editField validate- required-true i18n-hccr.property.socialSecurityAgencyName maxLength-50" ><span>${request?.socialSecurityAgencyName}</span></dd>
          
              <dt class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hccr.property.socialSecurityAgencyAddress.label" /> * : </dt><dd id="socialSecurityAgencyAddress" class="action-editField validate-address required-true i18n-hccr.property.socialSecurityAgencyAddress" ><div><p class="additionalDeliveryInformation">${request?.socialSecurityAgencyAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.socialSecurityAgencyAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.socialSecurityAgencyAddress?.streetNumber}</span> <span class="streetName">${request?.socialSecurityAgencyAddress?.streetName}</span><p class="placeNameOrService">${request?.socialSecurityAgencyAddress?.placeNameOrService}</p><span class="postalCode">${request?.socialSecurityAgencyAddress?.postalCode}</span> <span class="city">${request?.socialSecurityAgencyAddress?.city}</span><p class="countryName">${request?.socialSecurityAgencyAddress?.countryName}</p></div></dd>
          
        </dl>
        
      
    </div>
    <!-- column end -->
    
    <!-- column start -->
    <div class="yui-u">
      
        
        <h3><g:message code="hccr.property.paymentAgency.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isPaymentAgencyBeneficiary-trigger"><g:message code="hccr.property.paymentAgencyBeneficiary.label" /> * : </dt><dd id="paymentAgencyBeneficiary" class="action-editField validate-capdematEnum required-true i18n-hccr.property.paymentAgencyBeneficiary javatype-fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType" ><g:capdematEnumToField var="${request?.paymentAgencyBeneficiary}" i18nKeyPrefix="hccr.property.paymentAgencyBeneficiary" /></dd>
          
              <dt class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hccr.property.paymentAgencyBeneficiaryNumber.label" /> * : </dt><dd id="paymentAgencyBeneficiaryNumber" class="action-editField validate- required-true i18n-hccr.property.paymentAgencyBeneficiaryNumber maxLength-20" ><span>${request?.paymentAgencyBeneficiaryNumber}</span></dd>
          
              <dt class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hccr.property.paymentAgencyName.label" /> * : </dt><dd id="paymentAgencyName" class="action-editField validate- required-true i18n-hccr.property.paymentAgencyName maxLength-50" ><span>${request?.paymentAgencyName}</span></dd>
          
              <dt class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hccr.property.paymentAgencyAddress.label" /> * : </dt><dd id="paymentAgencyAddress" class="action-editField validate-address required-true i18n-hccr.property.paymentAgencyAddress" ><div><p class="additionalDeliveryInformation">${request?.paymentAgencyAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.paymentAgencyAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.paymentAgencyAddress?.streetNumber}</span> <span class="streetName">${request?.paymentAgencyAddress?.streetName}</span><p class="placeNameOrService">${request?.paymentAgencyAddress?.placeNameOrService}</p><span class="postalCode">${request?.paymentAgencyAddress?.postalCode}</span> <span class="city">${request?.paymentAgencyAddress?.city}</span><p class="countryName">${request?.paymentAgencyAddress?.countryName}</p></div></dd>
          
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
    <span><g:message code="hccr.step.occupationnalAndSchoolStatus.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
        
        <h3><g:message code="hccr.property.schooling.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isSchoolingEnrolment-trigger"><g:message code="hccr.property.schoolingEnrolment.label" /> * : </dt><dd id="schoolingEnrolment" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingEnrolment" ><span class="value-${request?.schoolingEnrolment}"><g:message code="message.${request?.schoolingEnrolment ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSchoolingEnrolment-filled"><g:message code="hccr.property.schoolingSchoolName.label" /> * : </dt><dd id="schoolingSchoolName" class="action-editField validate- required-true i18n-hccr.property.schoolingSchoolName maxLength-80" ><span>${request?.schoolingSchoolName}</span></dd>
          
              <dt class="required condition-isSchoolingEnrolment-filled"><g:message code="hccr.property.schoolingSchoolAddress.label" /> * : </dt><dd id="schoolingSchoolAddress" class="action-editField validate-address required-true i18n-hccr.property.schoolingSchoolAddress" ><div><p class="additionalDeliveryInformation">${request?.schoolingSchoolAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.schoolingSchoolAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.schoolingSchoolAddress?.streetNumber}</span> <span class="streetName">${request?.schoolingSchoolAddress?.streetName}</span><p class="placeNameOrService">${request?.schoolingSchoolAddress?.placeNameOrService}</p><span class="postalCode">${request?.schoolingSchoolAddress?.postalCode}</span> <span class="city">${request?.schoolingSchoolAddress?.city}</span><p class="countryName">${request?.schoolingSchoolAddress?.countryName}</p></div></dd>
          
              <dt class="required condition-isSentToSchool-trigger"><g:message code="hccr.property.schoolingSendToSchool.label" /> * : </dt><dd id="schoolingSendToSchool" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingSendToSchool" ><span class="value-${request?.schoolingSendToSchool}"><g:message code="message.${request?.schoolingSendToSchool ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSentToSchool-filled"><g:message code="hccr.property.schoolingAttendedGrade.label" /> * : </dt><dd id="schoolingAttendedGrade" class="action-editField validate-capdematEnum required-true i18n-hccr.property.schoolingAttendedGrade javatype-fr.cg95.cvq.business.users.SectionType maxLength-32" ><g:capdematEnumToField var="${request?.schoolingAttendedGrade}" i18nKeyPrefix="hccr.property.schoolingAttendedGrade" /></dd>
          
              <dt class="required condition-isSpecializedGrade-trigger"><g:message code="hccr.property.schoolingSpecializedGrade.label" /> * : </dt><dd id="schoolingSpecializedGrade" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingSpecializedGrade" ><span class="value-${request?.schoolingSpecializedGrade}"><g:message code="message.${request?.schoolingSpecializedGrade ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSpecializedGrade-filled"><g:message code="hccr.property.schoolingSpecializedGradeDetails.label" /> * : </dt><dd id="schoolingSpecializedGradeDetails" class="action-editField validate- required-true i18n-hccr.property.schoolingSpecializedGradeDetails maxLength-30" ><span>${request?.schoolingSpecializedGradeDetails}</span></dd>
          
              <dt class="required condition-isPartTimeSchooling-trigger"><g:message code="hccr.property.schoolingSchoolingKind.label" /> * : </dt><dd id="schoolingSchoolingKind" class="action-editField validate-capdematEnum required-true i18n-hccr.property.schoolingSchoolingKind javatype-fr.cg95.cvq.business.request.social.HccrSchoolingKindType" ><g:capdematEnumToField var="${request?.schoolingSchoolingKind}" i18nKeyPrefix="hccr.property.schoolingSchoolingKind" /></dd>
          
              <dt class="required condition-isPartTimeSchooling-filled"><g:message code="hccr.property.schoolingTime.label" /> * : </dt><dd id="schoolingTime" class="action-editField validate- required-true i18n-hccr.property.schoolingTime" ><span>${request?.schoolingTime}</span></dd>
          
              <dt class="required"><g:message code="hccr.property.schoolingHomeSchooling.label" /> * : </dt><dd id="schoolingHomeSchooling" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingHomeSchooling" ><span class="value-${request?.schoolingHomeSchooling}"><g:message code="message.${request?.schoolingHomeSchooling ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.schoolingPersonalizedSchoolingPlan.label" /> * : </dt><dd id="schoolingPersonalizedSchoolingPlan" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingPersonalizedSchoolingPlan" ><span class="value-${request?.schoolingPersonalizedSchoolingPlan}"><g:message code="message.${request?.schoolingPersonalizedSchoolingPlan ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isAccompaniedHomeSchooling-trigger"><g:message code="hccr.property.schoolingHomeSchoolingKind.label" /> * : </dt><dd id="schoolingHomeSchoolingKind" class="action-editField validate-capdematEnum required-true i18n-hccr.property.schoolingHomeSchoolingKind javatype-fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType" ><g:capdematEnumToField var="${request?.schoolingHomeSchoolingKind}" i18nKeyPrefix="hccr.property.schoolingHomeSchoolingKind" /></dd>
          
              <dt class="required condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistLastName.label" /> * : </dt><dd id="schoolingHomeSchoolingAccompanistLastName" class="action-editField validate-lastName required-true i18n-hccr.property.schoolingHomeSchoolingAccompanistLastName maxLength-38" ><span>${request?.schoolingHomeSchoolingAccompanistLastName}</span></dd>
          
              <dt class="required condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistFirstName.label" /> * : </dt><dd id="schoolingHomeSchoolingAccompanistFirstName" class="action-editField validate-firstName required-true i18n-hccr.property.schoolingHomeSchoolingAccompanistFirstName maxLength-38" ><span>${request?.schoolingHomeSchoolingAccompanistFirstName}</span></dd>
          
              <dt class="condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistAddress.label" />  : </dt><dd id="schoolingHomeSchoolingAccompanistAddress" class="action-editField validate-address i18n-hccr.property.schoolingHomeSchoolingAccompanistAddress" ><div><p class="additionalDeliveryInformation">${request?.schoolingHomeSchoolingAccompanistAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.schoolingHomeSchoolingAccompanistAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.schoolingHomeSchoolingAccompanistAddress?.streetNumber}</span> <span class="streetName">${request?.schoolingHomeSchoolingAccompanistAddress?.streetName}</span><p class="placeNameOrService">${request?.schoolingHomeSchoolingAccompanistAddress?.placeNameOrService}</p><span class="postalCode">${request?.schoolingHomeSchoolingAccompanistAddress?.postalCode}</span> <span class="city">${request?.schoolingHomeSchoolingAccompanistAddress?.city}</span><p class="countryName">${request?.schoolingHomeSchoolingAccompanistAddress?.countryName}</p></div></dd>
          
              <dt class="required condition-isExtraCurricular-trigger"><g:message code="hccr.property.schoolingExtraCurricular.label" /> * : </dt><dd id="schoolingExtraCurricular" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingExtraCurricular" ><span class="value-${request?.schoolingExtraCurricular}"><g:message code="message.${request?.schoolingExtraCurricular ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isExtraCurricular-filled"><g:message code="hccr.property.schoolingExtraCurricularDetails.label" /> * : </dt><dd id="schoolingExtraCurricularDetails" class="action-editField validate- required-true i18n-hccr.property.schoolingExtraCurricularDetails maxLength-50" ><span>${request?.schoolingExtraCurricularDetails}</span></dd>
          
        </dl>
        
      
        
        <h3><g:message code="hccr.property.studies.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isHighSchool-trigger"><g:message code="hccr.property.studiesHighSchool.label" /> * : </dt><dd id="studiesHighSchool" class="action-editField validate-boolean required-true i18n-hccr.property.studiesHighSchool" ><span class="value-${request?.studiesHighSchool}"><g:message code="message.${request?.studiesHighSchool ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolGrade.label" /> * : </dt><dd id="studiesHighSchoolGrade" class="action-editField validate- required-true i18n-hccr.property.studiesHighSchoolGrade maxLength-60" ><span>${request?.studiesHighSchoolGrade}</span></dd>
          
              <dt class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolName.label" /> * : </dt><dd id="studiesHighSchoolName" class="action-editField validate- required-true i18n-hccr.property.studiesHighSchoolName maxLength-60" ><span>${request?.studiesHighSchoolName}</span></dd>
          
              <dt class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolAddress.label" /> * : </dt><dd id="studiesHighSchoolAddress" class="action-editField validate-address required-true i18n-hccr.property.studiesHighSchoolAddress" ><div><p class="additionalDeliveryInformation">${request?.studiesHighSchoolAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.studiesHighSchoolAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.studiesHighSchoolAddress?.streetNumber}</span> <span class="streetName">${request?.studiesHighSchoolAddress?.streetName}</span><p class="placeNameOrService">${request?.studiesHighSchoolAddress?.placeNameOrService}</p><span class="postalCode">${request?.studiesHighSchoolAddress?.postalCode}</span> <span class="city">${request?.studiesHighSchoolAddress?.city}</span><p class="countryName">${request?.studiesHighSchoolAddress?.countryName}</p></div></dd>
          
              <dt class="required condition-isHighSchool-filled condition-isAssistanceUnderDisability-trigger"><g:message code="hccr.property.studiesAssistanceUnderDisability.label" /> * : </dt><dd id="studiesAssistanceUnderDisability" class="action-editField validate-boolean required-true i18n-hccr.property.studiesAssistanceUnderDisability" ><span class="value-${request?.studiesAssistanceUnderDisability}"><g:message code="message.${request?.studiesAssistanceUnderDisability ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isAssistanceUnderDisability-filled"><g:message code="hccr.property.studiesAssistanceUnderDisabilityDetails.label" /> * : </dt><dd id="studiesAssistanceUnderDisabilityDetails" class="action-editField validate- required-true i18n-hccr.property.studiesAssistanceUnderDisabilityDetails maxLength-60" ><span>${request?.studiesAssistanceUnderDisabilityDetails}</span></dd>
          
        </dl>
        
      
        
        <h3><g:message code="hccr.property.formation.label" /></h3>
        <dl class="required">
          
              <dt class=""><g:message code="hccr.property.formationStudiesLevel.label" />  : </dt><dd id="formationStudiesLevel" class="action-editField validate- i18n-hccr.property.formationStudiesLevel maxLength-30" ><span>${request?.formationStudiesLevel}</span></dd>
          
              <dt class=""><g:message code="hccr.property.formationDiploma.label" />  : </dt><dd id="formationDiploma" class="action-editField validate-textarea i18n-hccr.property.formationDiploma rows-2 maxLength-120" ><span>${request?.formationDiploma}</span></dd>
          
              <dt class=""><g:message code="hccr.property.formationPreviousFormation.label" />  : </dt><dd id="formationPreviousFormation" class="action-editField validate-textarea i18n-hccr.property.formationPreviousFormation rows-3 maxLength-180" ><span>${request?.formationPreviousFormation}</span></dd>
          
              <dt class=""><g:message code="hccr.property.formationCurrentFormation.label" />  : </dt><dd id="formationCurrentFormation" class="action-editField validate-textarea i18n-hccr.property.formationCurrentFormation rows-2 maxLength-120" ><span>${request?.formationCurrentFormation}</span></dd>
          
        </dl>
        
      
    </div>
    <!-- column end -->
    
    <!-- column start -->
    <div class="yui-u">
      
        
        <h3><g:message code="hccr.property.professionalStatus.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isEmployed-trigger condition-isUnemployed-trigger"><g:message code="hccr.property.professionalStatusKind.label" /> * : </dt><dd id="professionalStatusKind" class="action-editField validate-capdematEnum required-true i18n-hccr.property.professionalStatusKind javatype-fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType" ><g:capdematEnumToField var="${request?.professionalStatusKind}" i18nKeyPrefix="hccr.property.professionalStatusKind" /></dd>
          
              <dt class="required"><g:message code="hccr.property.professionalStatusDate.label" /> * : </dt><dd id="professionalStatusDate" class="action-editField validate-date required-true i18n-hccr.property.professionalStatusDate" ><span><g:formatDate formatName="format.date" date="${request?.professionalStatusDate}"/></span></dd>
          
              <dt class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusEnvironment.label" /> * : </dt><dd id="professionalStatusEnvironment" class="action-editField validate-capdematEnum required-true i18n-hccr.property.professionalStatusEnvironment javatype-fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType" ><g:capdematEnumToField var="${request?.professionalStatusEnvironment}" i18nKeyPrefix="hccr.property.professionalStatusEnvironment" /></dd>
          
              <dt class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusProfession.label" /> * : </dt><dd id="professionalStatusProfession" class="action-editField validate- required-true i18n-hccr.property.professionalStatusProfession maxLength-60" ><span>${request?.professionalStatusProfession}</span></dd>
          
              <dt class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusEmployerName.label" /> * : </dt><dd id="professionalStatusEmployerName" class="action-editField validate-lastName required-true i18n-hccr.property.professionalStatusEmployerName maxLength-38" ><span>${request?.professionalStatusEmployerName}</span></dd>
          
              <dt class="condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusAddress.label" />  : </dt><dd id="professionalStatusAddress" class="action-editField validate-address i18n-hccr.property.professionalStatusAddress" ><div><p class="additionalDeliveryInformation">${request?.professionalStatusAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.professionalStatusAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.professionalStatusAddress?.streetNumber}</span> <span class="streetName">${request?.professionalStatusAddress?.streetName}</span><p class="placeNameOrService">${request?.professionalStatusAddress?.placeNameOrService}</p><span class="postalCode">${request?.professionalStatusAddress?.postalCode}</span> <span class="city">${request?.professionalStatusAddress?.city}</span><p class="countryName">${request?.professionalStatusAddress?.countryName}</p></div></dd>
          
              <dt class="required condition-isUnemployed-filled condition-isRegisteredAsUnemployed-trigger"><g:message code="hccr.property.professionalStatusRegisterAsUnemployed.label" /> * : </dt><dd id="professionalStatusRegisterAsUnemployed" class="action-editField validate-boolean required-true i18n-hccr.property.professionalStatusRegisterAsUnemployed" ><span class="value-${request?.professionalStatusRegisterAsUnemployed}"><g:message code="message.${request?.professionalStatusRegisterAsUnemployed ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isRegisteredAsUnemployed-filled"><g:message code="hccr.property.professionalStatusRegisterAsUnemployedDate.label" /> * : </dt><dd id="professionalStatusRegisterAsUnemployedDate" class="action-editField validate-date required-true i18n-hccr.property.professionalStatusRegisterAsUnemployedDate" ><span><g:formatDate formatName="format.date" date="${request?.professionalStatusRegisterAsUnemployedDate}"/></span></dd>
          
              <dt class="required condition-isUnemployed-filled condition-isIndemnified-trigger"><g:message code="hccr.property.professionalStatusIndemnified.label" /> * : </dt><dd id="professionalStatusIndemnified" class="action-editField validate-boolean required-true i18n-hccr.property.professionalStatusIndemnified" ><span class="value-${request?.professionalStatusIndemnified}"><g:message code="message.${request?.professionalStatusIndemnified ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isIndemnified-filled"><g:message code="hccr.property.professionalStatusIndemnifiedDate.label" /> * : </dt><dd id="professionalStatusIndemnifiedDate" class="action-editField validate-date required-true i18n-hccr.property.professionalStatusIndemnifiedDate" ><span><g:formatDate formatName="format.date" date="${request?.professionalStatusIndemnifiedDate}"/></span></dd>
          
              <dt class="required condition-isElectiveFunction-trigger"><g:message code="hccr.property.professionalStatusElectiveFunction.label" /> * : </dt><dd id="professionalStatusElectiveFunction" class="action-editField validate-boolean required-true i18n-hccr.property.professionalStatusElectiveFunction" ><span class="value-${request?.professionalStatusElectiveFunction}"><g:message code="message.${request?.professionalStatusElectiveFunction ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isElectiveFunction-filled"><g:message code="hccr.property.professionalStatusElectiveFunctionDetails.label" /> * : </dt><dd id="professionalStatusElectiveFunctionDetails" class="action-editField validate- required-true i18n-hccr.property.professionalStatusElectiveFunctionDetails maxLength-60" ><span>${request?.professionalStatusElectiveFunctionDetails}</span></dd>
          
        </dl>
        
      
    </div>
    <!-- column end -->
    
  </div>
  <!-- data step  end -->
</div>
<!-- step end -->

