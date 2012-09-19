



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
          
              <dt class="required condition-isDisabilityRecognition-trigger">${message(code:'hcar.property.benefitsDisabilityRecognition.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsDisabilityRecognition" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityRecognition" ><span class="value-${rqt?.benefitsDisabilityRecognition}"><g:message code="message.${rqt?.benefitsDisabilityRecognition ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isDisabilityRecognition-filled">${message(code:'hcar.property.benefitsDisabilityRatio.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsDisabilityRatio" class="action-editField validate- required-true i18n-hcar.property.benefitsDisabilityRatio maxLength-3" ><span>${rqt?.benefitsDisabilityRatio}</span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsDisabilityCard.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsDisabilityCard" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityCard" ><span class="value-${rqt?.benefitsDisabilityCard}"><g:message code="message.${rqt?.benefitsDisabilityCard ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsPainfulStandingCard.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsPainfulStandingCard" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsPainfulStandingCard" ><span class="value-${rqt?.benefitsPainfulStandingCard}"><g:message code="message.${rqt?.benefitsPainfulStandingCard ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsParkingCard.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsParkingCard" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsParkingCard" ><span class="value-${rqt?.benefitsParkingCard}"><g:message code="message.${rqt?.benefitsParkingCard ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsDisabledWorkerRecognition.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsDisabledWorkerRecognition" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabledWorkerRecognition" ><span class="value-${rqt?.benefitsDisabledWorkerRecognition}"><g:message code="message.${rqt?.benefitsDisabledWorkerRecognition ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isProfessionalOrientation-trigger">${message(code:'hcar.property.benefitsProfessionalOrientation.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsProfessionalOrientation" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsProfessionalOrientation" ><span class="value-${rqt?.benefitsProfessionalOrientation}"><g:message code="message.${rqt?.benefitsProfessionalOrientation ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isProfessionalOrientation-filled">${message(code:'hcar.property.benefitsProfessionalOrientationDetails.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsProfessionalOrientationDetails" class="action-editField validate- required-true i18n-hcar.property.benefitsProfessionalOrientationDetails maxLength-60" ><span>${rqt?.benefitsProfessionalOrientationDetails}</span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsDisabledAdultAllocation.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsDisabledAdultAllocation" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabledAdultAllocation" ><span class="value-${rqt?.benefitsDisabledAdultAllocation}"><g:message code="message.${rqt?.benefitsDisabledAdultAllocation ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsIncreaseForIndependentLiving.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsIncreaseForIndependentLiving" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsIncreaseForIndependentLiving" ><span class="value-${rqt?.benefitsIncreaseForIndependentLiving}"><g:message code="message.${rqt?.benefitsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsEducationAllocationOfDisabledChildren.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsEducationAllocationOfDisabledChildren" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsEducationAllocationOfDisabledChildren" ><span class="value-${rqt?.benefitsEducationAllocationOfDisabledChildren}"><g:message code="message.${rqt?.benefitsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isEducationOfDisabledChildren-trigger">${message(code:'hcar.property.benefitsEducationOfDisabledChildren.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsEducationOfDisabledChildren" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsEducationOfDisabledChildren" ><span class="value-${rqt?.benefitsEducationOfDisabledChildren}"><g:message code="message.${rqt?.benefitsEducationOfDisabledChildren ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isEducationOfDisabledChildren-filled">${message(code:'hcar.property.benefitsEducationOfDisabledChildrenDetails.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsEducationOfDisabledChildrenDetails" class="action-editField validate- required-true i18n-hcar.property.benefitsEducationOfDisabledChildrenDetails maxLength-60" ><span>${rqt?.benefitsEducationOfDisabledChildrenDetails}</span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsSupplementForSingleParents.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsSupplementForSingleParents" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsSupplementForSingleParents" ><span class="value-${rqt?.benefitsSupplementForSingleParents}"><g:message code="message.${rqt?.benefitsSupplementForSingleParents ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsThirdPersonCompensatoryAllowance.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsThirdPersonCompensatoryAllowance" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsThirdPersonCompensatoryAllowance" ><span class="value-${rqt?.benefitsThirdPersonCompensatoryAllowance}"><g:message code="message.${rqt?.benefitsThirdPersonCompensatoryAllowance ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsThirdPartyCompensatoryAllowance.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsThirdPartyCompensatoryAllowance" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsThirdPartyCompensatoryAllowance" ><span class="value-${rqt?.benefitsThirdPartyCompensatoryAllowance}"><g:message code="message.${rqt?.benefitsThirdPartyCompensatoryAllowance ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsCompensatoryAllowanceForExpenses.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsCompensatoryAllowanceForExpenses" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsCompensatoryAllowanceForExpenses" ><span class="value-${rqt?.benefitsCompensatoryAllowanceForExpenses}"><g:message code="message.${rqt?.benefitsCompensatoryAllowanceForExpenses ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsDisabilityCompensation.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsDisabilityCompensation" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityCompensation" ><span class="value-${rqt?.benefitsDisabilityCompensation}"><g:message code="message.${rqt?.benefitsDisabilityCompensation ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isDisabilityPension-trigger">${message(code:'hcar.property.benefitsDisabilityPension.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsDisabilityPension" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityPension" ><span class="value-${rqt?.benefitsDisabilityPension}"><g:message code="message.${rqt?.benefitsDisabilityPension ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isDisabilityPension-filled">${message(code:'hcar.property.benefitsDisabilityPensionCategory.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsDisabilityPensionCategory" class="action-editField validate- required-true i18n-hcar.property.benefitsDisabilityPensionCategory maxLength-60" ><span>${rqt?.benefitsDisabilityPensionCategory}</span></dd>
          
              <dt class="required condition-isWorkAccidentAnnuity-trigger">${message(code:'hcar.property.benefitsWorkAccidentAnnuity.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsWorkAccidentAnnuity" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsWorkAccidentAnnuity" ><span class="value-${rqt?.benefitsWorkAccidentAnnuity}"><g:message code="message.${rqt?.benefitsWorkAccidentAnnuity ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isWorkAccidentAnnuity-filled">${message(code:'hcar.property.benefitsWorkAccidentAnnuityRatio.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsWorkAccidentAnnuityRatio" class="action-editField validate- required-true i18n-hcar.property.benefitsWorkAccidentAnnuityRatio maxLength-3" ><span>${rqt?.benefitsWorkAccidentAnnuityRatio}</span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsSocialWelfare.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsSocialWelfare" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsSocialWelfare" ><span class="value-${rqt?.benefitsSocialWelfare}"><g:message code="message.${rqt?.benefitsSocialWelfare ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsUnemploymentBenefits.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsUnemploymentBenefits" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsUnemploymentBenefits" ><span class="value-${rqt?.benefitsUnemploymentBenefits}"><g:message code="message.${rqt?.benefitsUnemploymentBenefits ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsDailyAllowances.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsDailyAllowances" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDailyAllowances" ><span class="value-${rqt?.benefitsDailyAllowances}"><g:message code="message.${rqt?.benefitsDailyAllowances ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required">${message(code:'hcar.property.benefitsThirdPartySupplement.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsThirdPartySupplement" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsThirdPartySupplement" ><span class="value-${rqt?.benefitsThirdPartySupplement}"><g:message code="message.${rqt?.benefitsThirdPartySupplement ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSupportedByAnInstitution-trigger">${message(code:'hcar.property.benefitsSupportedByAnInstitution.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsSupportedByAnInstitution" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsSupportedByAnInstitution" ><span class="value-${rqt?.benefitsSupportedByAnInstitution}"><g:message code="message.${rqt?.benefitsSupportedByAnInstitution ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSupportedByAnInstitution-filled">${message(code:'hcar.property.benefitsSupportedByAnInstitutionDetails.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsSupportedByAnInstitutionDetails" class="action-editField validate- required-true i18n-hcar.property.benefitsSupportedByAnInstitutionDetails maxLength-60" ><span>${rqt?.benefitsSupportedByAnInstitutionDetails}</span></dd>
          
              <dt class="required condition-isOtherBenefits-trigger">${message(code:'hcar.property.benefitsOtherBenefits.label')}&nbsp;*&nbsp;:</dt><dd id="benefitsOtherBenefits" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsOtherBenefits" ><span class="value-${rqt?.benefitsOtherBenefits}"><g:message code="message.${rqt?.benefitsOtherBenefits ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-otherBenefits" class="condition-isOtherBenefits-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/otherBenefits" model="['rqt':rqt]" />
        </div>
        
      
        
        <div id="widget-additionalFee" class="">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/additionalFee" model="['rqt':rqt]" />
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
          
              <dt class="required condition-isFamilyAssistance-trigger">${message(code:'hcar.property.isFamilyAssistance.label')}&nbsp;*&nbsp;:</dt><dd id="isFamilyAssistance" class="action-editField validate-boolean required-true i18n-hcar.property.isFamilyAssistance" ><span class="value-${rqt?.isFamilyAssistance}"><g:message code="message.${rqt?.isFamilyAssistance ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-familyAssistanceMembers" class="required condition-isFamilyAssistance-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/familyAssistanceMembers" model="['rqt':rqt]" />
        </div>
        
      
        
        <h3><g:message code="hcar.property.homeIntervention.label" /></h3>
        <dl class="">
          
              <dt class="required condition-isHomeIntervenant-trigger">${message(code:'hcar.property.homeInterventionHomeIntervenant.label')}&nbsp;*&nbsp;:</dt><dd id="homeInterventionHomeIntervenant" class="action-editField validate-boolean required-true i18n-hcar.property.homeInterventionHomeIntervenant" ><span class="value-${rqt?.homeInterventionHomeIntervenant}"><g:message code="message.${rqt?.homeInterventionHomeIntervenant ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-homeIntervenants" class="condition-isHomeIntervenant-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/homeIntervenants" model="['rqt':rqt]" />
        </div>
        
      
        
        <h3><g:message code="hcar.property.care.label" /></h3>
        <dl class="">
          
              <dt class="required condition-isCareServices-trigger">${message(code:'hcar.property.careCareServices.label')}&nbsp;*&nbsp;:</dt><dd id="careCareServices" class="action-editField validate-boolean required-true i18n-hcar.property.careCareServices" ><span class="value-${rqt?.careCareServices}"><g:message code="message.${rqt?.careCareServices ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-careServices" class="required condition-isCareServices-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/careServices" model="['rqt':rqt]" />
        </div>
        
      
        
        <h3><g:message code="hcar.property.facilities.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isHousing-trigger">${message(code:'hcar.property.facilitiesHousing.label')}&nbsp;*&nbsp;:</dt><dd id="facilitiesHousing" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesHousing" ><span class="value-${rqt?.facilitiesHousing}"><g:message code="message.${rqt?.facilitiesHousing ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isHousing-filled">${message(code:'hcar.property.facilitiesHousingDetails.label')}&nbsp;*&nbsp;:</dt><dd id="facilitiesHousingDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesHousingDetails maxLength-60" ><span>${rqt?.facilitiesHousingDetails}</span></dd>
          
              <dt class="required condition-isTechnicalAssistance-trigger">${message(code:'hcar.property.facilitiesTechnicalAssistance.label')}&nbsp;*&nbsp;:</dt><dd id="facilitiesTechnicalAssistance" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesTechnicalAssistance" ><span class="value-${rqt?.facilitiesTechnicalAssistance}"><g:message code="message.${rqt?.facilitiesTechnicalAssistance ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isTechnicalAssistance-filled">${message(code:'hcar.property.facilitiesTechnicalAssistanceDetails.label')}&nbsp;*&nbsp;:</dt><dd id="facilitiesTechnicalAssistanceDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesTechnicalAssistanceDetails maxLength-60" ><span>${rqt?.facilitiesTechnicalAssistanceDetails}</span></dd>
          
              <dt class="required condition-isCustomCar-trigger">${message(code:'hcar.property.facilitiesCustomCar.label')}&nbsp;*&nbsp;:</dt><dd id="facilitiesCustomCar" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesCustomCar" ><span class="value-${rqt?.facilitiesCustomCar}"><g:message code="message.${rqt?.facilitiesCustomCar ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isCustomCar-filled">${message(code:'hcar.property.facilitiesCustomCarDetails.label')}&nbsp;*&nbsp;:</dt><dd id="facilitiesCustomCarDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesCustomCarDetails maxLength-60" ><span>${rqt?.facilitiesCustomCarDetails}</span></dd>
          
              <dt class="required condition-isAnimalAid-trigger">${message(code:'hcar.property.facilitiesAnimalAid.label')}&nbsp;*&nbsp;:</dt><dd id="facilitiesAnimalAid" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesAnimalAid" ><span class="value-${rqt?.facilitiesAnimalAid}"><g:message code="message.${rqt?.facilitiesAnimalAid ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isAnimalAid-filled">${message(code:'hcar.property.facilitiesAnimalAidDetails.label')}&nbsp;*&nbsp;:</dt><dd id="facilitiesAnimalAidDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesAnimalAidDetails maxLength-60" ><span>${rqt?.facilitiesAnimalAidDetails}</span></dd>
          
              <dt class="required condition-isSpecializedTransport-trigger">${message(code:'hcar.property.facilitiesSpecializedTransport.label')}&nbsp;*&nbsp;:</dt><dd id="facilitiesSpecializedTransport" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesSpecializedTransport" ><span class="value-${rqt?.facilitiesSpecializedTransport}"><g:message code="message.${rqt?.facilitiesSpecializedTransport ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSpecializedTransport-filled">${message(code:'hcar.property.facilitiesSpecializedTransportDetails.label')}&nbsp;*&nbsp;:</dt><dd id="facilitiesSpecializedTransportDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesSpecializedTransportDetails maxLength-60" ><span>${rqt?.facilitiesSpecializedTransportDetails}</span></dd>
          
        </dl>
        
      
        
        <h3><g:message code="hcar.property.professionalSupport.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isProfessionals-trigger">${message(code:'hcar.property.professionalSupportProfessionals.label')}&nbsp;*&nbsp;:</dt><dd id="professionalSupportProfessionals" class="action-editField validate-boolean required-true i18n-hcar.property.professionalSupportProfessionals" ><span class="value-${rqt?.professionalSupportProfessionals}"><g:message code="message.${rqt?.professionalSupportProfessionals ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isProfessionals-filled">${message(code:'hcar.property.professionalSupportDealsWithSameProfessional.label')}&nbsp;*&nbsp;:</dt><dd id="professionalSupportDealsWithSameProfessional" class="action-editField validate-boolean required-true i18n-hcar.property.professionalSupportDealsWithSameProfessional" ><span class="value-${rqt?.professionalSupportDealsWithSameProfessional}"><g:message code="message.${rqt?.professionalSupportDealsWithSameProfessional ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-professionals" class="condition-isProfessionals-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/professionals" model="['rqt':rqt]" />
        </div>
        
      
        
        <h3><g:message code="hcar.property.socialService.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isSocialServiceSupport-trigger">${message(code:'hcar.property.professionalSupportSocialServiceSupport.label')}&nbsp;*&nbsp;:</dt><dd id="professionalSupportSocialServiceSupport" class="action-editField validate-boolean required-true i18n-hcar.property.professionalSupportSocialServiceSupport" ><span class="value-${rqt?.professionalSupportSocialServiceSupport}"><g:message code="message.${rqt?.professionalSupportSocialServiceSupport ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSocialServiceSupport-filled">${message(code:'hcar.property.professionalSupportSocialServiceName.label')}&nbsp;*&nbsp;:</dt><dd id="professionalSupportSocialServiceName" class="action-editField validate- required-true i18n-hcar.property.professionalSupportSocialServiceName maxLength-60" ><span>${rqt?.professionalSupportSocialServiceName}</span></dd>
          
              <dt class="required condition-isSocialServiceSupport-filled">${message(code:'hcar.property.professionalSupportSocialServiceAddress.label')}&nbsp;*&nbsp;:</dt><dd id="professionalSupportSocialServiceAddress" class="action-editField validate-address required-true i18n-hcar.property.professionalSupportSocialServiceAddress" ><div><p class="additionalDeliveryInformation">${rqt?.professionalSupportSocialServiceAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.professionalSupportSocialServiceAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.professionalSupportSocialServiceAddress?.streetNumber}</span> <span class="streetName">${rqt?.professionalSupportSocialServiceAddress?.streetName}</span><g:if test="${!!rqt?.professionalSupportSocialServiceAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.professionalSupportSocialServiceAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.professionalSupportSocialServiceAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.professionalSupportSocialServiceAddress?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.professionalSupportSocialServiceAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.professionalSupportSocialServiceAddress?.postalCode}</span> <span class="city">${rqt?.professionalSupportSocialServiceAddress?.city}</span><p class="countryName">${rqt?.professionalSupportSocialServiceAddress?.countryName}</p><g:if test="${!!rqt?.professionalSupportSocialServiceAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.professionalSupportSocialServiceAddress?.cityInseeCode}</span></g:if></div></dd>
          
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
          
              <dt class="required condition-isFollowedByDoctor-trigger">${message(code:'hcar.property.healthFollowedByDoctor.label')}&nbsp;*&nbsp;:</dt><dd id="healthFollowedByDoctor" class="action-editField validate-boolean required-true i18n-hcar.property.healthFollowedByDoctor" ><span class="value-${rqt?.healthFollowedByDoctor}"><g:message code="message.${rqt?.healthFollowedByDoctor ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isFollowedByDoctor-filled">${message(code:'hcar.property.healthDoctorLastName.label')}&nbsp;*&nbsp;:</dt><dd id="healthDoctorLastName" class="action-editField validate-lastName required-true i18n-hcar.property.healthDoctorLastName maxLength-38" ><span>${rqt?.healthDoctorLastName}</span></dd>
          
              <dt class="required condition-isFollowedByDoctor-filled">${message(code:'hcar.property.healthDoctorFirstName.label')}&nbsp;*&nbsp;:</dt><dd id="healthDoctorFirstName" class="action-editField validate-firstName required-true i18n-hcar.property.healthDoctorFirstName maxLength-38" ><span>${rqt?.healthDoctorFirstName}</span></dd>
          
              <dt class="required condition-isFollowedByProfessional-trigger">${message(code:'hcar.property.healthFollowedByProfessional.label')}&nbsp;*&nbsp;:</dt><dd id="healthFollowedByProfessional" class="action-editField validate-boolean required-true i18n-hcar.property.healthFollowedByProfessional" ><span class="value-${rqt?.healthFollowedByProfessional}"><g:message code="message.${rqt?.healthFollowedByProfessional ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isFollowedByProfessional-filled">${message(code:'hcar.property.healthProfessionalLastName.label')}&nbsp;*&nbsp;:</dt><dd id="healthProfessionalLastName" class="action-editField validate-lastName required-true i18n-hcar.property.healthProfessionalLastName maxLength-38" ><span>${rqt?.healthProfessionalLastName}</span></dd>
          
              <dt class="required condition-isFollowedByProfessional-filled">${message(code:'hcar.property.healthProfessionalFirstName.label')}&nbsp;*&nbsp;:</dt><dd id="healthProfessionalFirstName" class="action-editField validate-firstName required-true i18n-hcar.property.healthProfessionalFirstName maxLength-38" ><span>${rqt?.healthProfessionalFirstName}</span></dd>
          
              <dt class="required condition-isFollowedByHospital-trigger">${message(code:'hcar.property.healthFollowedByHospital.label')}&nbsp;*&nbsp;:</dt><dd id="healthFollowedByHospital" class="action-editField validate-boolean required-true i18n-hcar.property.healthFollowedByHospital" ><span class="value-${rqt?.healthFollowedByHospital}"><g:message code="message.${rqt?.healthFollowedByHospital ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isFollowedByHospital-filled">${message(code:'hcar.property.healthHospitalName.label')}&nbsp;*&nbsp;:</dt><dd id="healthHospitalName" class="action-editField validate- required-true i18n-hcar.property.healthHospitalName maxLength-60" ><span>${rqt?.healthHospitalName}</span></dd>
          
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

