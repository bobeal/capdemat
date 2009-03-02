



  
  <h3><g:message code="hccr.step.subject.label" /></h3>
  
  
    
    <h4><g:message code="hccr.property.hccrSubject.label" /></h4>
    <dl>
      
      <dt><g:message code="request.property.subjectName" /></dt>
      <dd>${subjects.get(rqt.subjectId)}</dd>
          
      
      
      <dt><g:message code="hccr.property.subjectBirthDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectBirthDate}"/></dd>
          
      
      <dt><g:message code="hccr.property.subjectBirthCity.label" /></dt>
        <dd>${rqt.subjectBirthCity}</dd>
      
      <dt><g:message code="hccr.property.subjectBirthCountry.label" /></dt>
        <dd>${rqt.subjectBirthCountry}</dd>
      
      <dt><g:message code="hccr.property.subjectParentalAuthorityHolder.label" /></dt>
        
          <dd>
            <g:if test="${rqt.subjectParentalAuthorityHolder}">
              <g:capdematEnumToField var="${rqt.subjectParentalAuthorityHolder}" i18nKeyPrefix="hccr.property.subjectParentalAuthorityHolder" />
            </g:if>
          </dd>
          
      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.father.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.fatherLastName.label" /></dt>
        <dd>${rqt.fatherLastName}</dd>
      
      <dt><g:message code="hccr.property.fatherFirstName.label" /></dt>
        <dd>${rqt.fatherFirstName}</dd>
      
      <dt><g:message code="hccr.property.fatherJob.label" /></dt>
        <dd>${rqt.fatherJob}</dd>
      
      <dt><g:message code="hccr.property.fatherActivityReduction.label" /></dt>
        
          <dd><g:message code="message.${rqt.fatherActivityReduction ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.fatherActivityReductionRatio.label" /></dt>
        <dd>${rqt.fatherActivityReductionRatio}</dd>
      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.mother.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.motherLastName.label" /></dt>
        <dd>${rqt.motherLastName}</dd>
      
      <dt><g:message code="hccr.property.motherFirstName.label" /></dt>
        <dd>${rqt.motherFirstName}</dd>
      
      <dt><g:message code="hccr.property.motherJob.label" /></dt>
        <dd>${rqt.motherJob}</dd>
      
      <dt><g:message code="hccr.property.motherActivityReduction.label" /></dt>
        
          <dd><g:message code="message.${rqt.motherActivityReduction ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.motherActivityReductionRatio.label" /></dt>
        <dd>${rqt.motherActivityReductionRatio}</dd>
      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.aseReferent.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.aseReferentLastName.label" /></dt>
        <dd>${rqt.aseReferentLastName}</dd>
      
      <dt><g:message code="hccr.property.aseReferentDepartment.label" /></dt>
        <dd>${rqt.aseReferentDepartment}</dd>
      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.referent.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.referentLastName.label" /></dt>
        <dd>${rqt.referentLastName}</dd>
      
      <dt><g:message code="hccr.property.referentFirstName.label" /></dt>
        <dd>${rqt.referentFirstName}</dd>
      
      <dt><g:message code="hccr.property.referentTitle.label" /></dt>
        
          <dd>
            <g:if test="${rqt.referentTitle}">
              <g:capdematEnumToField var="${rqt.referentTitle}" i18nKeyPrefix="hccr.property.referentTitle" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="hccr.property.referentMaidenName.label" /></dt>
        <dd>${rqt.referentMaidenName}</dd>
      
      <dt><g:message code="hccr.property.referentBirthDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${rqt.referentBirthDate}"/></dd>
          
      
      <dt><g:message code="hccr.property.referentBirthCity.label" /></dt>
        <dd>${rqt.referentBirthCity}</dd>
      
      <dt><g:message code="hccr.property.referentBirthCountry.label" /></dt>
        <dd>${rqt.referentBirthCountry}</dd>
      
      <dt><g:message code="hccr.property.referentFamilyStatus.label" /></dt>
        
          <dd>
            <g:if test="${rqt.referentFamilyStatus}">
              <g:capdematEnumToField var="${rqt.referentFamilyStatus}" i18nKeyPrefix="hccr.property.referentFamilyStatus" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="hccr.property.referentFamilyDependents.label" /></dt>
        
          <dd><g:message code="message.${rqt.referentFamilyDependents ? 'yes' : 'no'}" /></dd>
          
      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.familyDependents.label" /></h4>
    <g:each var="it" in="${rqt.familyDependents}" status="index">
    <dl>
      
      <dt><g:message code="hccr.property.referentFamilyDependentLastName.label" /></dt>
        <dd>${it.referentFamilyDependentLastName}</dd>
      
      <dt><g:message code="hccr.property.referentFamilyDependentFirstName.label" /></dt>
        <dd>${it.referentFamilyDependentFirstName}</dd>
      
      <dt><g:message code="hccr.property.referentFamilyDependentBirthDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${it.referentFamilyDependentBirthDate}"/></dd>
          
      
      <dt><g:message code="hccr.property.referentFamilyDependentActualSituation.label" /></dt>
        
          <dd>
            <g:if test="${it.referentFamilyDependentActualSituation}">
              <g:capdematEnumToField var="${it.referentFamilyDependentActualSituation}" i18nKeyPrefix="hccr.property.referentFamilyDependentActualSituation" />
            </g:if>
          </dd>
          
      
    </dl>
    </g:each>
    
  

  
  <h3><g:message code="hccr.step.dwelling.label" /></h3>
  
  
    
    <h4><g:message code="hccr.property.dwelling.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.dwellingKind.label" /></dt>
        
          <dd>
            <g:if test="${rqt.dwellingKind}">
              <g:capdematEnumToField var="${rqt.dwellingKind}" i18nKeyPrefix="hccr.property.dwellingKind" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="hccr.property.dwellingPrecision.label" /></dt>
        <dd>${rqt.dwellingPrecision}</dd>
      
      <dt><g:message code="hccr.property.dwellingEstablishmentReception.label" /></dt>
        
          <dd><g:message code="message.${rqt.dwellingEstablishmentReception ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.dwellingReceptionType.label" /></dt>
        
          <dd>
            <g:if test="${rqt.dwellingReceptionType}">
              <g:capdematEnumToField var="${rqt.dwellingReceptionType}" i18nKeyPrefix="hccr.property.dwellingReceptionType" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="hccr.property.dwellingReceptionNaming.label" /></dt>
        <dd>${rqt.dwellingReceptionNaming}</dd>
      
      <dt><g:message code="hccr.property.dwellingReceptionAddress.label" /></dt>
        
          <g:if test="${rqt.dwellingReceptionAddress}">
            <dd>
              <p>${rqt.dwellingReceptionAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.dwellingReceptionAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.dwellingReceptionAddress?.streetNumber} ${rqt.dwellingReceptionAddress?.streetName}</p>
              <p>${rqt.dwellingReceptionAddress?.placeNameOrService}</p>
              <p>${rqt.dwellingReceptionAddress?.postalCode} ${rqt.dwellingReceptionAddress?.city}</p>
              <p>${rqt.dwellingReceptionAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
      <dt><g:message code="hccr.property.dwellingSocialReception.label" /></dt>
        
          <dd><g:message code="message.${rqt.dwellingSocialReception ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.dwellingSocialReceptionNaming.label" /></dt>
        <dd>${rqt.dwellingSocialReceptionNaming}</dd>
      
      <dt><g:message code="hccr.property.dwellingSocialReceptionAddress.label" /></dt>
        
          <g:if test="${rqt.dwellingSocialReceptionAddress}">
            <dd>
              <p>${rqt.dwellingSocialReceptionAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.dwellingSocialReceptionAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.dwellingSocialReceptionAddress?.streetNumber} ${rqt.dwellingSocialReceptionAddress?.streetName}</p>
              <p>${rqt.dwellingSocialReceptionAddress?.placeNameOrService}</p>
              <p>${rqt.dwellingSocialReceptionAddress?.postalCode} ${rqt.dwellingSocialReceptionAddress?.city}</p>
              <p>${rqt.dwellingSocialReceptionAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
    </dl>
    
  

  
  <h3><g:message code="hccr.step.socialSecurityAndPaymentAgency.label" /></h3>
  
  
    
    <h4><g:message code="hccr.property.socialSecurity.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.socialSecurityMemberShipKind.label" /></dt>
        
          <dd>
            <g:if test="${rqt.socialSecurityMemberShipKind}">
              <g:capdematEnumToField var="${rqt.socialSecurityMemberShipKind}" i18nKeyPrefix="hccr.property.socialSecurityMemberShipKind" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="hccr.property.socialSecurityNumber.label" /></dt>
        <dd>${rqt.socialSecurityNumber}</dd>
      
      <dt><g:message code="hccr.property.socialSecurityAgencyName.label" /></dt>
        <dd>${rqt.socialSecurityAgencyName}</dd>
      
      <dt><g:message code="hccr.property.socialSecurityAgencyAddress.label" /></dt>
        
          <g:if test="${rqt.socialSecurityAgencyAddress}">
            <dd>
              <p>${rqt.socialSecurityAgencyAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.socialSecurityAgencyAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.socialSecurityAgencyAddress?.streetNumber} ${rqt.socialSecurityAgencyAddress?.streetName}</p>
              <p>${rqt.socialSecurityAgencyAddress?.placeNameOrService}</p>
              <p>${rqt.socialSecurityAgencyAddress?.postalCode} ${rqt.socialSecurityAgencyAddress?.city}</p>
              <p>${rqt.socialSecurityAgencyAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.paymentAgency.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.paymentAgencyBeneficiary.label" /></dt>
        
          <dd>
            <g:if test="${rqt.paymentAgencyBeneficiary}">
              <g:capdematEnumToField var="${rqt.paymentAgencyBeneficiary}" i18nKeyPrefix="hccr.property.paymentAgencyBeneficiary" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="hccr.property.paymentAgencyBeneficiaryNumber.label" /></dt>
        <dd>${rqt.paymentAgencyBeneficiaryNumber}</dd>
      
      <dt><g:message code="hccr.property.paymentAgencyName.label" /></dt>
        <dd>${rqt.paymentAgencyName}</dd>
      
      <dt><g:message code="hccr.property.paymentAgencyAddress.label" /></dt>
        
          <g:if test="${rqt.paymentAgencyAddress}">
            <dd>
              <p>${rqt.paymentAgencyAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.paymentAgencyAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.paymentAgencyAddress?.streetNumber} ${rqt.paymentAgencyAddress?.streetName}</p>
              <p>${rqt.paymentAgencyAddress?.placeNameOrService}</p>
              <p>${rqt.paymentAgencyAddress?.postalCode} ${rqt.paymentAgencyAddress?.city}</p>
              <p>${rqt.paymentAgencyAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
    </dl>
    
  

  
  <h3><g:message code="hccr.step.occupationnalAndSchoolStatus.label" /></h3>
  
  
    
    <h4><g:message code="hccr.property.schooling.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.schoolingEnrolment.label" /></dt>
        
          <dd><g:message code="message.${rqt.schoolingEnrolment ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.schoolingSchoolName.label" /></dt>
        <dd>${rqt.schoolingSchoolName}</dd>
      
      <dt><g:message code="hccr.property.schoolingSchoolAddress.label" /></dt>
        
          <g:if test="${rqt.schoolingSchoolAddress}">
            <dd>
              <p>${rqt.schoolingSchoolAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.schoolingSchoolAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.schoolingSchoolAddress?.streetNumber} ${rqt.schoolingSchoolAddress?.streetName}</p>
              <p>${rqt.schoolingSchoolAddress?.placeNameOrService}</p>
              <p>${rqt.schoolingSchoolAddress?.postalCode} ${rqt.schoolingSchoolAddress?.city}</p>
              <p>${rqt.schoolingSchoolAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
      <dt><g:message code="hccr.property.schoolingSendToSchool.label" /></dt>
        
          <dd><g:message code="message.${rqt.schoolingSendToSchool ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.schoolingAttendedGrade.label" /></dt>
        
          <dd>
            <g:if test="${rqt.schoolingAttendedGrade}">
              <g:capdematEnumToField var="${rqt.schoolingAttendedGrade}" i18nKeyPrefix="hccr.property.schoolingAttendedGrade" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="hccr.property.schoolingSpecializedGrade.label" /></dt>
        
          <dd><g:message code="message.${rqt.schoolingSpecializedGrade ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.schoolingSpecializedGradeDetails.label" /></dt>
        <dd>${rqt.schoolingSpecializedGradeDetails}</dd>
      
      <dt><g:message code="hccr.property.schoolingSchoolingKind.label" /></dt>
        
          <dd>
            <g:if test="${rqt.schoolingSchoolingKind}">
              <g:capdematEnumToField var="${rqt.schoolingSchoolingKind}" i18nKeyPrefix="hccr.property.schoolingSchoolingKind" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="hccr.property.schoolingTime.label" /></dt>
        <dd>${rqt.schoolingTime}</dd>
      
      <dt><g:message code="hccr.property.schoolingHomeSchooling.label" /></dt>
        
          <dd><g:message code="message.${rqt.schoolingHomeSchooling ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.schoolingPersonalizedSchoolingPlan.label" /></dt>
        
          <dd><g:message code="message.${rqt.schoolingPersonalizedSchoolingPlan ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.schoolingHomeSchoolingKind.label" /></dt>
        
          <dd>
            <g:if test="${rqt.schoolingHomeSchoolingKind}">
              <g:capdematEnumToField var="${rqt.schoolingHomeSchoolingKind}" i18nKeyPrefix="hccr.property.schoolingHomeSchoolingKind" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="hccr.property.schoolingHomeSchoolingAccompanistLastName.label" /></dt>
        <dd>${rqt.schoolingHomeSchoolingAccompanistLastName}</dd>
      
      <dt><g:message code="hccr.property.schoolingHomeSchoolingAccompanistFirstName.label" /></dt>
        <dd>${rqt.schoolingHomeSchoolingAccompanistFirstName}</dd>
      
      <dt><g:message code="hccr.property.schoolingHomeSchoolingAccompanistAddress.label" /></dt>
        
          <g:if test="${rqt.schoolingHomeSchoolingAccompanistAddress}">
            <dd>
              <p>${rqt.schoolingHomeSchoolingAccompanistAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.schoolingHomeSchoolingAccompanistAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.schoolingHomeSchoolingAccompanistAddress?.streetNumber} ${rqt.schoolingHomeSchoolingAccompanistAddress?.streetName}</p>
              <p>${rqt.schoolingHomeSchoolingAccompanistAddress?.placeNameOrService}</p>
              <p>${rqt.schoolingHomeSchoolingAccompanistAddress?.postalCode} ${rqt.schoolingHomeSchoolingAccompanistAddress?.city}</p>
              <p>${rqt.schoolingHomeSchoolingAccompanistAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
      <dt><g:message code="hccr.property.schoolingExtraCurricular.label" /></dt>
        
          <dd><g:message code="message.${rqt.schoolingExtraCurricular ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.schoolingExtraCurricularDetails.label" /></dt>
        <dd>${rqt.schoolingExtraCurricularDetails}</dd>
      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.studies.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.studiesHighSchool.label" /></dt>
        
          <dd><g:message code="message.${rqt.studiesHighSchool ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.studiesHighSchoolGrade.label" /></dt>
        <dd>${rqt.studiesHighSchoolGrade}</dd>
      
      <dt><g:message code="hccr.property.studiesHighSchoolName.label" /></dt>
        <dd>${rqt.studiesHighSchoolName}</dd>
      
      <dt><g:message code="hccr.property.studiesHighSchoolAddress.label" /></dt>
        
          <g:if test="${rqt.studiesHighSchoolAddress}">
            <dd>
              <p>${rqt.studiesHighSchoolAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.studiesHighSchoolAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.studiesHighSchoolAddress?.streetNumber} ${rqt.studiesHighSchoolAddress?.streetName}</p>
              <p>${rqt.studiesHighSchoolAddress?.placeNameOrService}</p>
              <p>${rqt.studiesHighSchoolAddress?.postalCode} ${rqt.studiesHighSchoolAddress?.city}</p>
              <p>${rqt.studiesHighSchoolAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
      <dt><g:message code="hccr.property.studiesAssistanceUnderDisability.label" /></dt>
        
          <dd><g:message code="message.${rqt.studiesAssistanceUnderDisability ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.studiesAssistanceUnderDisabilityDetails.label" /></dt>
        <dd>${rqt.studiesAssistanceUnderDisabilityDetails}</dd>
      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.formation.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.formationStudiesLevel.label" /></dt>
        <dd>${rqt.formationStudiesLevel}</dd>
      
      <dt><g:message code="hccr.property.formationDiploma.label" /></dt>
        <dd>${rqt.formationDiploma}</dd>
      
      <dt><g:message code="hccr.property.formationPreviousFormation.label" /></dt>
        <dd>${rqt.formationPreviousFormation}</dd>
      
      <dt><g:message code="hccr.property.formationCurrentFormation.label" /></dt>
        <dd>${rqt.formationCurrentFormation}</dd>
      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.professionalStatus.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.professionalStatusKind.label" /></dt>
        
          <dd>
            <g:if test="${rqt.professionalStatusKind}">
              <g:capdematEnumToField var="${rqt.professionalStatusKind}" i18nKeyPrefix="hccr.property.professionalStatusKind" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="hccr.property.professionalStatusDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${rqt.professionalStatusDate}"/></dd>
          
      
      <dt><g:message code="hccr.property.professionalStatusEnvironment.label" /></dt>
        
          <dd>
            <g:if test="${rqt.professionalStatusEnvironment}">
              <g:capdematEnumToField var="${rqt.professionalStatusEnvironment}" i18nKeyPrefix="hccr.property.professionalStatusEnvironment" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="hccr.property.professionalStatusProfession.label" /></dt>
        <dd>${rqt.professionalStatusProfession}</dd>
      
      <dt><g:message code="hccr.property.professionalStatusEmployerName.label" /></dt>
        <dd>${rqt.professionalStatusEmployerName}</dd>
      
      <dt><g:message code="hccr.property.professionalStatusAddress.label" /></dt>
        
          <g:if test="${rqt.professionalStatusAddress}">
            <dd>
              <p>${rqt.professionalStatusAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.professionalStatusAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.professionalStatusAddress?.streetNumber} ${rqt.professionalStatusAddress?.streetName}</p>
              <p>${rqt.professionalStatusAddress?.placeNameOrService}</p>
              <p>${rqt.professionalStatusAddress?.postalCode} ${rqt.professionalStatusAddress?.city}</p>
              <p>${rqt.professionalStatusAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
      <dt><g:message code="hccr.property.professionalStatusRegisterAsUnemployed.label" /></dt>
        
          <dd><g:message code="message.${rqt.professionalStatusRegisterAsUnemployed ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.professionalStatusRegisterAsUnemployedDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${rqt.professionalStatusRegisterAsUnemployedDate}"/></dd>
          
      
      <dt><g:message code="hccr.property.professionalStatusIndemnified.label" /></dt>
        
          <dd><g:message code="message.${rqt.professionalStatusIndemnified ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.professionalStatusIndemnifiedDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${rqt.professionalStatusIndemnifiedDate}"/></dd>
          
      
      <dt><g:message code="hccr.property.professionalStatusElectiveFunction.label" /></dt>
        
          <dd><g:message code="message.${rqt.professionalStatusElectiveFunction ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.professionalStatusElectiveFunctionDetails.label" /></dt>
        <dd>${rqt.professionalStatusElectiveFunctionDetails}</dd>
      
    </dl>
    
  

  
  <h3><g:message code="hccr.step.folders.label" /></h3>
  
  
    
    <h4><g:message code="hccr.property.folders.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.foldersMdph.label" /></dt>
        
          <dd><g:message code="message.${rqt.foldersMdph ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.foldersMdphNumber.label" /></dt>
        <dd>${rqt.foldersMdphNumber}</dd>
      
      <dt><g:message code="hccr.property.foldersMdphDepartment.label" /></dt>
        <dd>${rqt.foldersMdphDepartment}</dd>
      
      <dt><g:message code="hccr.property.foldersCotorep.label" /></dt>
        
          <dd><g:message code="message.${rqt.foldersCotorep ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.foldersCotorepNumber.label" /></dt>
        <dd>${rqt.foldersCotorepNumber}</dd>
      
      <dt><g:message code="hccr.property.foldersCotorepDepartment.label" /></dt>
        <dd>${rqt.foldersCotorepDepartment}</dd>
      
      <dt><g:message code="hccr.property.foldersCdes.label" /></dt>
        
          <dd><g:message code="message.${rqt.foldersCdes ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.foldersCdesNumber.label" /></dt>
        <dd>${rqt.foldersCdesNumber}</dd>
      
      <dt><g:message code="hccr.property.foldersCdesDepartment.label" /></dt>
        <dd>${rqt.foldersCdesDepartment}</dd>
      
      <dt><g:message code="hccr.property.foldersOtherFolders.label" /></dt>
        
          <dd><g:message code="message.${rqt.foldersOtherFolders ? 'yes' : 'no'}" /></dd>
          
      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.otherFolders.label" /></h4>
    <g:each var="it" in="${rqt.otherFolders}" status="index">
    <dl>
      
      <dt><g:message code="hccr.property.otherFolderName.label" /></dt>
        <dd>${it.otherFolderName}</dd>
      
      <dt><g:message code="hccr.property.otherFolderNumber.label" /></dt>
        <dd>${it.otherFolderNumber}</dd>
      
      <dt><g:message code="hccr.property.otherFolderDepartment.label" /></dt>
        <dd>${it.otherFolderDepartment}</dd>
      
    </dl>
    </g:each>
    
  

  
  <h3><g:message code="hccr.step.benefits.label" /></h3>
  
  
    
    <h4><g:message code="hccr.property.benefits.label" /></h4>
    <dl>
      
      
      <dt><g:message code="hccr.property.benefitsDisabilityRecognition.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsDisabilityRecognition ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsDisabilityRatio.label" /></dt>
        <dd>${rqt.benefitsDisabilityRatio}</dd>
      
      <dt><g:message code="hccr.property.benefitsDisabilityCard.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsDisabilityCard ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsPainfulStandingCard.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsPainfulStandingCard ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsParkingCard.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsParkingCard ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsDisabledWorkerRecognition.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsDisabledWorkerRecognition ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsProfessionalOrientation.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsProfessionalOrientation ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsProfessionalOrientationDetails.label" /></dt>
        <dd>${rqt.benefitsProfessionalOrientationDetails}</dd>
      
      <dt><g:message code="hccr.property.benefitsDisabledAdultAllocation.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsDisabledAdultAllocation ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsIncreaseForIndependentLiving.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsEducationAllocationOfDisabledChildren.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsEducationOfDisabledChildren.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsEducationOfDisabledChildren ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsEducationOfDisabledChildrenDetails.label" /></dt>
        <dd>${rqt.benefitsEducationOfDisabledChildrenDetails}</dd>
      
      <dt><g:message code="hccr.property.benefitsSupplementForSingleParents.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsSupplementForSingleParents ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsThirdPersonCompensatoryAllowance.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsThirdPersonCompensatoryAllowance ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsThirdPartyCompensatoryAllowance.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsThirdPartyCompensatoryAllowance ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsCompensatoryAllowanceForExpenses.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsCompensatoryAllowanceForExpenses ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsDisabilityCompensation.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsDisabilityCompensation ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsDisabilityPension.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsDisabilityPension ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsDisabilityPensionCategory.label" /></dt>
        <dd>${rqt.benefitsDisabilityPensionCategory}</dd>
      
      <dt><g:message code="hccr.property.benefitsWorkAccidentAnnuity.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsWorkAccidentAnnuity ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsWorkAccidentAnnuityRatio.label" /></dt>
        <dd>${rqt.benefitsWorkAccidentAnnuityRatio}</dd>
      
      <dt><g:message code="hccr.property.benefitsSocialWelfare.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsSocialWelfare ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsUnemploymentBenefits.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsUnemploymentBenefits ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsDailyAllowances.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsDailyAllowances ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsThirdPartySupplement.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsThirdPartySupplement ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsSupportedByAnInstitution.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsSupportedByAnInstitution ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="hccr.property.benefitsSupportedByAnInstitutionDetails.label" /></dt>
        <dd>${rqt.benefitsSupportedByAnInstitutionDetails}</dd>
      
      <dt><g:message code="hccr.property.benefitsOtherBenefits.label" /></dt>
        
          <dd><g:message code="message.${rqt.benefitsOtherBenefits ? 'yes' : 'no'}" /></dd>
          
      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.otherBenefits.label" /></h4>
    <g:each var="it" in="${rqt.otherBenefits}" status="index">
    <dl>
      
      <dt><g:message code="hccr.property.otherBenefitName.label" /></dt>
        <dd>${it.otherBenefitName}</dd>
      
    </dl>
    </g:each>
    
  
    
    <h4><g:message code="hccr.property.additionalFee.label" /></h4>
    <g:each var="it" in="${rqt.additionalFee}" status="index">
    <dl>
      
      <dt><g:message code="hccr.property.additionalFeeKind.label" /></dt>
        <dd>${it.additionalFeeKind}</dd>
      
      <dt><g:message code="hccr.property.additionalFeeCost.label" /></dt>
        <dd>${it.additionalFeeCost}</dd>
      
      <dt><g:message code="hccr.property.additionalFeePeriodicity.label" /></dt>
        <dd>${it.additionalFeePeriodicity}</dd>
      
    </dl>
    </g:each>
    
  


