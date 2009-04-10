


  
    
      <h3><g:message code="hcar.step.subject.label" /></h3>
      
        
        <h4><g:message code="hcar.property.hcarSubject.label" /></h4>
        <dl>
          
            <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

          
            <dt><g:message code="hcar.property.subjectTitle.label" /></dt>
          <dd>
            <g:if test="${rqt.subjectTitle}">
              <g:capdematEnumToField var="${rqt.subjectTitle}" i18nKeyPrefix="hcar.property.subjectTitle" />
            </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.subjectMaidenName.label" /></dt><dd>${rqt.subjectMaidenName}</dd>

          
            <dt><g:message code="hcar.property.subjectBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectBirthDate}"/></dd>
          

          
            <dt><g:message code="hcar.property.subjectBirthCity.label" /></dt><dd>${rqt.subjectBirthCity}</dd>

          
            <dt><g:message code="hcar.property.subjectBirthCountry.label" /></dt><dd>${rqt.subjectBirthCountry}</dd>

          
        </dl>
        
      
        
        <h4><g:message code="hcar.property.legalAccess.label" /></h4>
        <dl>
          
            <dt><g:message code="hcar.property.legalAccessPresence.label" /></dt>
          <dd><g:message code="message.${rqt.legalAccessPresence ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.legalAccessKind.label" /></dt>
          <dd>
            <g:if test="${rqt.legalAccessKind}">
              <g:capdematEnumToField var="${rqt.legalAccessKind}" i18nKeyPrefix="hcar.property.legalAccessKind" />
            </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.legalAccessRepresentativeKind.label" /></dt>
          <dd>
            <g:if test="${rqt.legalAccessRepresentativeKind}">
              <g:capdematEnumToField var="${rqt.legalAccessRepresentativeKind}" i18nKeyPrefix="hcar.property.legalAccessRepresentativeKind" />
            </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.legalAccessRepresentativeKindDetail.label" /></dt><dd>${rqt.legalAccessRepresentativeKindDetail}</dd>

          
            <dt><g:message code="hcar.property.legalAccessRepresentativeName.label" /></dt><dd>${rqt.legalAccessRepresentativeName}</dd>

          
            <dt><g:message code="hcar.property.legalAccessRepresentativeFirstName.label" /></dt><dd>${rqt.legalAccessRepresentativeFirstName}</dd>

          
        </dl>
        
      
        
        <h4><g:message code="hcar.property.family.label" /></h4>
        <dl>
          
            <dt><g:message code="hcar.property.familyStatus.label" /></dt>
          <dd>
            <g:if test="${rqt.familyStatus}">
              <g:capdematEnumToField var="${rqt.familyStatus}" i18nKeyPrefix="hcar.property.familyStatus" />
            </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.familyFamilyDependents.label" /></dt>
          <dd><g:message code="message.${rqt.familyFamilyDependents ? 'yes' : 'no'}" /></dd>
          

          
        </dl>
        
      
        
        <h4><g:message code="hcar.property.familyDependents.label" /></h4>
        <g:each var="it" in="${rqt.familyDependents}" status="index">
        <dl>
          
            <dt><g:message code="hcar.property.familyDependentLastName.label" /></dt><dd>${it.familyDependentLastName}</dd>

          
            <dt><g:message code="hcar.property.familyDependentFirstName.label" /></dt><dd>${it.familyDependentFirstName}</dd>

          
            <dt><g:message code="hcar.property.familyDependentBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${it.familyDependentBirthDate}"/></dd>
          

          
            <dt><g:message code="hcar.property.familyDependentActualSituation.label" /></dt>
          <dd>
            <g:if test="${it.familyDependentActualSituation}">
              <g:capdematEnumToField var="${it.familyDependentActualSituation}" i18nKeyPrefix="hcar.property.familyDependentActualSituation" />
            </g:if>
          </dd>
          

          
        </dl>
        </g:each>
        
      
    
  

  
    
      <h3><g:message code="hcar.step.dwelling.label" /></h3>
      
        
        <h4><g:message code="hcar.property.dwelling.label" /></h4>
        <dl>
          
            <dt><g:message code="hcar.property.dwellingKind.label" /></dt>
          <dd>
            <g:if test="${rqt.dwellingKind}">
              <g:capdematEnumToField var="${rqt.dwellingKind}" i18nKeyPrefix="hcar.property.dwellingKind" />
            </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.dwellingPrecision.label" /></dt><dd>${rqt.dwellingPrecision}</dd>

          
            <dt><g:message code="hcar.property.dwellingEstablishmentReception.label" /></dt>
          <dd><g:message code="message.${rqt.dwellingEstablishmentReception ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.dwellingReceptionType.label" /></dt>
          <dd>
            <g:if test="${rqt.dwellingReceptionType}">
              <g:capdematEnumToField var="${rqt.dwellingReceptionType}" i18nKeyPrefix="hcar.property.dwellingReceptionType" />
            </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.dwellingReceptionNaming.label" /></dt><dd>${rqt.dwellingReceptionNaming}</dd>

          
            <dt><g:message code="hcar.property.dwellingReceptionAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.dwellingReceptionAddress}">
              <p>${rqt.dwellingReceptionAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.dwellingReceptionAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.dwellingReceptionAddress?.streetNumber} ${rqt.dwellingReceptionAddress?.streetName}</p>
              <p>${rqt.dwellingReceptionAddress?.placeNameOrService}</p>
              <p>${rqt.dwellingReceptionAddress?.postalCode} ${rqt.dwellingReceptionAddress?.city}</p>
              <p>${rqt.dwellingReceptionAddress?.countryName}</p>
          </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.dwellingSocialReception.label" /></dt>
          <dd><g:message code="message.${rqt.dwellingSocialReception ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.dwellingSocialReceptionNaming.label" /></dt><dd>${rqt.dwellingSocialReceptionNaming}</dd>

          
            <dt><g:message code="hcar.property.dwellingSocialReceptionAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.dwellingSocialReceptionAddress}">
              <p>${rqt.dwellingSocialReceptionAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.dwellingSocialReceptionAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.dwellingSocialReceptionAddress?.streetNumber} ${rqt.dwellingSocialReceptionAddress?.streetName}</p>
              <p>${rqt.dwellingSocialReceptionAddress?.placeNameOrService}</p>
              <p>${rqt.dwellingSocialReceptionAddress?.postalCode} ${rqt.dwellingSocialReceptionAddress?.city}</p>
              <p>${rqt.dwellingSocialReceptionAddress?.countryName}</p>
          </g:if>
          </dd>
          

          
        </dl>
        
      
    
  

  
    
      <h3><g:message code="hcar.step.socialSecurityAndPaymentAgency.label" /></h3>
      
        
        <h4><g:message code="hcar.property.socialSecurity.label" /></h4>
        <dl>
          
            <dt><g:message code="hcar.property.socialSecurityMemberShipKind.label" /></dt>
          <dd>
            <g:if test="${rqt.socialSecurityMemberShipKind}">
              <g:capdematEnumToField var="${rqt.socialSecurityMemberShipKind}" i18nKeyPrefix="hcar.property.socialSecurityMemberShipKind" />
            </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.socialSecurityNumber.label" /></dt><dd>${rqt.socialSecurityNumber}</dd>

          
            <dt><g:message code="hcar.property.socialSecurityAgencyName.label" /></dt><dd>${rqt.socialSecurityAgencyName}</dd>

          
            <dt><g:message code="hcar.property.socialSecurityAgencyAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.socialSecurityAgencyAddress}">
              <p>${rqt.socialSecurityAgencyAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.socialSecurityAgencyAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.socialSecurityAgencyAddress?.streetNumber} ${rqt.socialSecurityAgencyAddress?.streetName}</p>
              <p>${rqt.socialSecurityAgencyAddress?.placeNameOrService}</p>
              <p>${rqt.socialSecurityAgencyAddress?.postalCode} ${rqt.socialSecurityAgencyAddress?.city}</p>
              <p>${rqt.socialSecurityAgencyAddress?.countryName}</p>
          </g:if>
          </dd>
          

          
        </dl>
        
      
        
        <h4><g:message code="hcar.property.paymentAgency.label" /></h4>
        <dl>
          
            <dt><g:message code="hcar.property.paymentAgencyBeneficiary.label" /></dt>
          <dd>
            <g:if test="${rqt.paymentAgencyBeneficiary}">
              <g:capdematEnumToField var="${rqt.paymentAgencyBeneficiary}" i18nKeyPrefix="hcar.property.paymentAgencyBeneficiary" />
            </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.paymentAgencyBeneficiaryNumber.label" /></dt><dd>${rqt.paymentAgencyBeneficiaryNumber}</dd>

          
            <dt><g:message code="hcar.property.paymentAgencyName.label" /></dt><dd>${rqt.paymentAgencyName}</dd>

          
            <dt><g:message code="hcar.property.paymentAgencyAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.paymentAgencyAddress}">
              <p>${rqt.paymentAgencyAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.paymentAgencyAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.paymentAgencyAddress?.streetNumber} ${rqt.paymentAgencyAddress?.streetName}</p>
              <p>${rqt.paymentAgencyAddress?.placeNameOrService}</p>
              <p>${rqt.paymentAgencyAddress?.postalCode} ${rqt.paymentAgencyAddress?.city}</p>
              <p>${rqt.paymentAgencyAddress?.countryName}</p>
          </g:if>
          </dd>
          

          
        </dl>
        
      
    
  

  
    
      <h3><g:message code="hcar.step.occupationnalAndSchoolStatus.label" /></h3>
      
        
        <h4><g:message code="hcar.property.studies.label" /></h4>
        <dl>
          
            <dt><g:message code="hcar.property.studiesHighSchool.label" /></dt>
          <dd><g:message code="message.${rqt.studiesHighSchool ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.studiesHighSchoolGrade.label" /></dt><dd>${rqt.studiesHighSchoolGrade}</dd>

          
            <dt><g:message code="hcar.property.studiesHighSchoolName.label" /></dt><dd>${rqt.studiesHighSchoolName}</dd>

          
            <dt><g:message code="hcar.property.studiesHighSchoolAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.studiesHighSchoolAddress}">
              <p>${rqt.studiesHighSchoolAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.studiesHighSchoolAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.studiesHighSchoolAddress?.streetNumber} ${rqt.studiesHighSchoolAddress?.streetName}</p>
              <p>${rqt.studiesHighSchoolAddress?.placeNameOrService}</p>
              <p>${rqt.studiesHighSchoolAddress?.postalCode} ${rqt.studiesHighSchoolAddress?.city}</p>
              <p>${rqt.studiesHighSchoolAddress?.countryName}</p>
          </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.studiesAssistanceUnderDisability.label" /></dt>
          <dd><g:message code="message.${rqt.studiesAssistanceUnderDisability ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.studiesAssistanceUnderDisabilityDetails.label" /></dt><dd>${rqt.studiesAssistanceUnderDisabilityDetails}</dd>

          
        </dl>
        
      
        
        <h4><g:message code="hcar.property.formation.label" /></h4>
        <dl>
          
            <dt><g:message code="hcar.property.formationStudiesLevel.label" /></dt><dd>${rqt.formationStudiesLevel}</dd>

          
            <dt><g:message code="hcar.property.formationDiploma.label" /></dt><dd>${rqt.formationDiploma}</dd>

          
            <dt><g:message code="hcar.property.formationPreviousFormation.label" /></dt><dd>${rqt.formationPreviousFormation}</dd>

          
            <dt><g:message code="hcar.property.formationCurrentFormation.label" /></dt><dd>${rqt.formationCurrentFormation}</dd>

          
        </dl>
        
      
        
        <h4><g:message code="hcar.property.professionalStatus.label" /></h4>
        <dl>
          
            <dt><g:message code="hcar.property.professionalStatusKind.label" /></dt>
          <dd>
            <g:if test="${rqt.professionalStatusKind}">
              <g:capdematEnumToField var="${rqt.professionalStatusKind}" i18nKeyPrefix="hcar.property.professionalStatusKind" />
            </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.professionalStatusDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.professionalStatusDate}"/></dd>
          

          
            <dt><g:message code="hcar.property.professionalStatusEnvironment.label" /></dt>
          <dd>
            <g:if test="${rqt.professionalStatusEnvironment}">
              <g:capdematEnumToField var="${rqt.professionalStatusEnvironment}" i18nKeyPrefix="hcar.property.professionalStatusEnvironment" />
            </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.professionalStatusProfession.label" /></dt><dd>${rqt.professionalStatusProfession}</dd>

          
            <dt><g:message code="hcar.property.professionalStatusEmployerName.label" /></dt><dd>${rqt.professionalStatusEmployerName}</dd>

          
            <dt><g:message code="hcar.property.professionalStatusAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.professionalStatusAddress}">
              <p>${rqt.professionalStatusAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.professionalStatusAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.professionalStatusAddress?.streetNumber} ${rqt.professionalStatusAddress?.streetName}</p>
              <p>${rqt.professionalStatusAddress?.placeNameOrService}</p>
              <p>${rqt.professionalStatusAddress?.postalCode} ${rqt.professionalStatusAddress?.city}</p>
              <p>${rqt.professionalStatusAddress?.countryName}</p>
          </g:if>
          </dd>
          

          
            <dt><g:message code="hcar.property.professionalStatusRegisterAsUnemployed.label" /></dt>
          <dd><g:message code="message.${rqt.professionalStatusRegisterAsUnemployed ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.professionalStatusRegisterAsUnemployedDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.professionalStatusRegisterAsUnemployedDate}"/></dd>
          

          
            <dt><g:message code="hcar.property.professionalStatusIndemnified.label" /></dt>
          <dd><g:message code="message.${rqt.professionalStatusIndemnified ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.professionalStatusIndemnifiedDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.professionalStatusIndemnifiedDate}"/></dd>
          

          
            <dt><g:message code="hcar.property.professionalStatusElectiveFunction.label" /></dt>
          <dd><g:message code="message.${rqt.professionalStatusElectiveFunction ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.professionalStatusElectiveFunctionDetails.label" /></dt><dd>${rqt.professionalStatusElectiveFunctionDetails}</dd>

          
        </dl>
        
      
    
  

  
    
      <h3><g:message code="hcar.step.folders.label" /></h3>
      
        
        <h4><g:message code="hcar.property.folders.label" /></h4>
        <dl>
          
            <dt><g:message code="hcar.property.foldersMdph.label" /></dt>
          <dd><g:message code="message.${rqt.foldersMdph ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.foldersMdphNumber.label" /></dt><dd>${rqt.foldersMdphNumber}</dd>

          
            <dt><g:message code="hcar.property.foldersMdphDepartment.label" /></dt><dd>${rqt.foldersMdphDepartment}</dd>

          
            <dt><g:message code="hcar.property.foldersCotorep.label" /></dt>
          <dd><g:message code="message.${rqt.foldersCotorep ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.foldersCotorepNumber.label" /></dt><dd>${rqt.foldersCotorepNumber}</dd>

          
            <dt><g:message code="hcar.property.foldersCotorepDepartment.label" /></dt><dd>${rqt.foldersCotorepDepartment}</dd>

          
            <dt><g:message code="hcar.property.foldersCdes.label" /></dt>
          <dd><g:message code="message.${rqt.foldersCdes ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.foldersCdesNumber.label" /></dt><dd>${rqt.foldersCdesNumber}</dd>

          
            <dt><g:message code="hcar.property.foldersCdesDepartment.label" /></dt><dd>${rqt.foldersCdesDepartment}</dd>

          
            <dt><g:message code="hcar.property.foldersOtherFolders.label" /></dt>
          <dd><g:message code="message.${rqt.foldersOtherFolders ? 'yes' : 'no'}" /></dd>
          

          
        </dl>
        
      
        
        <h4><g:message code="hcar.property.otherFolders.label" /></h4>
        <g:each var="it" in="${rqt.otherFolders}" status="index">
        <dl>
          
            <dt><g:message code="hcar.property.otherFolderName.label" /></dt><dd>${it.otherFolderName}</dd>

          
            <dt><g:message code="hcar.property.otherFolderNumber.label" /></dt><dd>${it.otherFolderNumber}</dd>

          
            <dt><g:message code="hcar.property.otherFolderDepartment.label" /></dt><dd>${it.otherFolderDepartment}</dd>

          
        </dl>
        </g:each>
        
      
    
  

  
    
      <h3><g:message code="hcar.step.benefits.label" /></h3>
      
        
        <h4><g:message code="hcar.property.benefits.label" /></h4>
        <dl>
          
            <dt><g:message code="hcar.property.benefitsDisabilityRecognition.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsDisabilityRecognition ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsDisabilityRatio.label" /></dt><dd>${rqt.benefitsDisabilityRatio}</dd>

          
            <dt><g:message code="hcar.property.benefitsDisabilityCard.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsDisabilityCard ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsPainfulStandingCard.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsPainfulStandingCard ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsParkingCard.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsParkingCard ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsDisabledWorkerRecognition.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsDisabledWorkerRecognition ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsProfessionalOrientation.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsProfessionalOrientation ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsProfessionalOrientationDetails.label" /></dt><dd>${rqt.benefitsProfessionalOrientationDetails}</dd>

          
            <dt><g:message code="hcar.property.benefitsDisabledAdultAllocation.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsDisabledAdultAllocation ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsIncreaseForIndependentLiving.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsEducationAllocationOfDisabledChildren.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsEducationOfDisabledChildren.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsEducationOfDisabledChildren ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsEducationOfDisabledChildrenDetails.label" /></dt><dd>${rqt.benefitsEducationOfDisabledChildrenDetails}</dd>

          
            <dt><g:message code="hcar.property.benefitsSupplementForSingleParents.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsSupplementForSingleParents ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsThirdPersonCompensatoryAllowance.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsThirdPersonCompensatoryAllowance ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsThirdPartyCompensatoryAllowance.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsThirdPartyCompensatoryAllowance ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsCompensatoryAllowanceForExpenses.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsCompensatoryAllowanceForExpenses ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsDisabilityCompensation.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsDisabilityCompensation ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsDisabilityPension.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsDisabilityPension ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsDisabilityPensionCategory.label" /></dt><dd>${rqt.benefitsDisabilityPensionCategory}</dd>

          
            <dt><g:message code="hcar.property.benefitsWorkAccidentAnnuity.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsWorkAccidentAnnuity ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsWorkAccidentAnnuityRatio.label" /></dt><dd>${rqt.benefitsWorkAccidentAnnuityRatio}</dd>

          
            <dt><g:message code="hcar.property.benefitsSocialWelfare.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsSocialWelfare ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsUnemploymentBenefits.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsUnemploymentBenefits ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsDailyAllowances.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsDailyAllowances ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsThirdPartySupplement.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsThirdPartySupplement ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsSupportedByAnInstitution.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsSupportedByAnInstitution ? 'yes' : 'no'}" /></dd>
          

          
            <dt><g:message code="hcar.property.benefitsSupportedByAnInstitutionDetails.label" /></dt><dd>${rqt.benefitsSupportedByAnInstitutionDetails}</dd>

          
            <dt><g:message code="hcar.property.benefitsOtherBenefits.label" /></dt>
          <dd><g:message code="message.${rqt.benefitsOtherBenefits ? 'yes' : 'no'}" /></dd>
          

          
        </dl>
        
      
        
        <h4><g:message code="hcar.property.otherBenefits.label" /></h4>
        <g:each var="it" in="${rqt.otherBenefits}" status="index">
        <dl>
          
            <dt><g:message code="hcar.property.otherBenefitName.label" /></dt><dd>${it.otherBenefitName}</dd>

          
        </dl>
        </g:each>
        
      
        
        <h4><g:message code="hcar.property.additionalFee.label" /></h4>
        <g:each var="it" in="${rqt.additionalFee}" status="index">
        <dl>
          
            <dt><g:message code="hcar.property.additionalFeeKind.label" /></dt><dd>${it.additionalFeeKind}</dd>

          
            <dt><g:message code="hcar.property.additionalFeeCost.label" /></dt><dd>${it.additionalFeeCost}</dd>

          
            <dt><g:message code="hcar.property.additionalFeePeriodicity.label" /></dt><dd>${it.additionalFeePeriodicity}</dd>

          
        </dl>
        </g:each>
        
      
    
  


