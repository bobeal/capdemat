



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
          
              <dt class="required condition-isDisabilityRecognition-trigger"><g:message code="hcar.property.benefitsDisabilityRecognition.label" /> * : </dt><dd id="benefitsDisabilityRecognition" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityRecognition" ><span class="value-${request?.benefitsDisabilityRecognition}"><g:message code="message.${request?.benefitsDisabilityRecognition ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isDisabilityRecognition-filled"><g:message code="hcar.property.benefitsDisabilityRatio.label" /> * : </dt><dd id="benefitsDisabilityRatio" class="action-editField validate- required-true i18n-hcar.property.benefitsDisabilityRatio maxLength-3" ><span>${request?.benefitsDisabilityRatio}</span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsDisabilityCard.label" /> * : </dt><dd id="benefitsDisabilityCard" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityCard" ><span class="value-${request?.benefitsDisabilityCard}"><g:message code="message.${request?.benefitsDisabilityCard ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsPainfulStandingCard.label" /> * : </dt><dd id="benefitsPainfulStandingCard" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsPainfulStandingCard" ><span class="value-${request?.benefitsPainfulStandingCard}"><g:message code="message.${request?.benefitsPainfulStandingCard ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsParkingCard.label" /> * : </dt><dd id="benefitsParkingCard" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsParkingCard" ><span class="value-${request?.benefitsParkingCard}"><g:message code="message.${request?.benefitsParkingCard ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsDisabledWorkerRecognition.label" /> * : </dt><dd id="benefitsDisabledWorkerRecognition" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabledWorkerRecognition" ><span class="value-${request?.benefitsDisabledWorkerRecognition}"><g:message code="message.${request?.benefitsDisabledWorkerRecognition ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isProfessionalOrientation-trigger"><g:message code="hcar.property.benefitsProfessionalOrientation.label" /> * : </dt><dd id="benefitsProfessionalOrientation" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsProfessionalOrientation" ><span class="value-${request?.benefitsProfessionalOrientation}"><g:message code="message.${request?.benefitsProfessionalOrientation ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isProfessionalOrientation-filled"><g:message code="hcar.property.benefitsProfessionalOrientationDetails.label" /> * : </dt><dd id="benefitsProfessionalOrientationDetails" class="action-editField validate- required-true i18n-hcar.property.benefitsProfessionalOrientationDetails maxLength-60" ><span>${request?.benefitsProfessionalOrientationDetails}</span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsDisabledAdultAllocation.label" /> * : </dt><dd id="benefitsDisabledAdultAllocation" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabledAdultAllocation" ><span class="value-${request?.benefitsDisabledAdultAllocation}"><g:message code="message.${request?.benefitsDisabledAdultAllocation ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsIncreaseForIndependentLiving.label" /> * : </dt><dd id="benefitsIncreaseForIndependentLiving" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsIncreaseForIndependentLiving" ><span class="value-${request?.benefitsIncreaseForIndependentLiving}"><g:message code="message.${request?.benefitsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsEducationAllocationOfDisabledChildren.label" /> * : </dt><dd id="benefitsEducationAllocationOfDisabledChildren" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsEducationAllocationOfDisabledChildren" ><span class="value-${request?.benefitsEducationAllocationOfDisabledChildren}"><g:message code="message.${request?.benefitsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isEducationOfDisabledChildren-trigger"><g:message code="hcar.property.benefitsEducationOfDisabledChildren.label" /> * : </dt><dd id="benefitsEducationOfDisabledChildren" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsEducationOfDisabledChildren" ><span class="value-${request?.benefitsEducationOfDisabledChildren}"><g:message code="message.${request?.benefitsEducationOfDisabledChildren ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isEducationOfDisabledChildren-filled"><g:message code="hcar.property.benefitsEducationOfDisabledChildrenDetails.label" /> * : </dt><dd id="benefitsEducationOfDisabledChildrenDetails" class="action-editField validate- required-true i18n-hcar.property.benefitsEducationOfDisabledChildrenDetails maxLength-60" ><span>${request?.benefitsEducationOfDisabledChildrenDetails}</span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsSupplementForSingleParents.label" /> * : </dt><dd id="benefitsSupplementForSingleParents" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsSupplementForSingleParents" ><span class="value-${request?.benefitsSupplementForSingleParents}"><g:message code="message.${request?.benefitsSupplementForSingleParents ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsThirdPersonCompensatoryAllowance.label" /> * : </dt><dd id="benefitsThirdPersonCompensatoryAllowance" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsThirdPersonCompensatoryAllowance" ><span class="value-${request?.benefitsThirdPersonCompensatoryAllowance}"><g:message code="message.${request?.benefitsThirdPersonCompensatoryAllowance ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsThirdPartyCompensatoryAllowance.label" /> * : </dt><dd id="benefitsThirdPartyCompensatoryAllowance" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsThirdPartyCompensatoryAllowance" ><span class="value-${request?.benefitsThirdPartyCompensatoryAllowance}"><g:message code="message.${request?.benefitsThirdPartyCompensatoryAllowance ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsCompensatoryAllowanceForExpenses.label" /> * : </dt><dd id="benefitsCompensatoryAllowanceForExpenses" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsCompensatoryAllowanceForExpenses" ><span class="value-${request?.benefitsCompensatoryAllowanceForExpenses}"><g:message code="message.${request?.benefitsCompensatoryAllowanceForExpenses ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsDisabilityCompensation.label" /> * : </dt><dd id="benefitsDisabilityCompensation" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityCompensation" ><span class="value-${request?.benefitsDisabilityCompensation}"><g:message code="message.${request?.benefitsDisabilityCompensation ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isDisabilityPension-trigger"><g:message code="hcar.property.benefitsDisabilityPension.label" /> * : </dt><dd id="benefitsDisabilityPension" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDisabilityPension" ><span class="value-${request?.benefitsDisabilityPension}"><g:message code="message.${request?.benefitsDisabilityPension ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isDisabilityPension-filled"><g:message code="hcar.property.benefitsDisabilityPensionCategory.label" /> * : </dt><dd id="benefitsDisabilityPensionCategory" class="action-editField validate- required-true i18n-hcar.property.benefitsDisabilityPensionCategory maxLength-60" ><span>${request?.benefitsDisabilityPensionCategory}</span></dd>
          
              <dt class="required condition-isWorkAccidentAnnuity-trigger"><g:message code="hcar.property.benefitsWorkAccidentAnnuity.label" /> * : </dt><dd id="benefitsWorkAccidentAnnuity" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsWorkAccidentAnnuity" ><span class="value-${request?.benefitsWorkAccidentAnnuity}"><g:message code="message.${request?.benefitsWorkAccidentAnnuity ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isWorkAccidentAnnuity-filled"><g:message code="hcar.property.benefitsWorkAccidentAnnuityRatio.label" /> * : </dt><dd id="benefitsWorkAccidentAnnuityRatio" class="action-editField validate- required-true i18n-hcar.property.benefitsWorkAccidentAnnuityRatio maxLength-3" ><span>${request?.benefitsWorkAccidentAnnuityRatio}</span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsSocialWelfare.label" /> * : </dt><dd id="benefitsSocialWelfare" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsSocialWelfare" ><span class="value-${request?.benefitsSocialWelfare}"><g:message code="message.${request?.benefitsSocialWelfare ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsUnemploymentBenefits.label" /> * : </dt><dd id="benefitsUnemploymentBenefits" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsUnemploymentBenefits" ><span class="value-${request?.benefitsUnemploymentBenefits}"><g:message code="message.${request?.benefitsUnemploymentBenefits ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsDailyAllowances.label" /> * : </dt><dd id="benefitsDailyAllowances" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsDailyAllowances" ><span class="value-${request?.benefitsDailyAllowances}"><g:message code="message.${request?.benefitsDailyAllowances ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hcar.property.benefitsThirdPartySupplement.label" /> * : </dt><dd id="benefitsThirdPartySupplement" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsThirdPartySupplement" ><span class="value-${request?.benefitsThirdPartySupplement}"><g:message code="message.${request?.benefitsThirdPartySupplement ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSupportedByAnInstitution-trigger"><g:message code="hcar.property.benefitsSupportedByAnInstitution.label" /> * : </dt><dd id="benefitsSupportedByAnInstitution" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsSupportedByAnInstitution" ><span class="value-${request?.benefitsSupportedByAnInstitution}"><g:message code="message.${request?.benefitsSupportedByAnInstitution ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSupportedByAnInstitution-filled"><g:message code="hcar.property.benefitsSupportedByAnInstitutionDetails.label" /> * : </dt><dd id="benefitsSupportedByAnInstitutionDetails" class="action-editField validate- required-true i18n-hcar.property.benefitsSupportedByAnInstitutionDetails maxLength-60" ><span>${request?.benefitsSupportedByAnInstitutionDetails}</span></dd>
          
              <dt class="required condition-isOtherBenefits-trigger"><g:message code="hcar.property.benefitsOtherBenefits.label" /> * : </dt><dd id="benefitsOtherBenefits" class="action-editField validate-boolean required-true i18n-hcar.property.benefitsOtherBenefits" ><span class="value-${request?.benefitsOtherBenefits}"><g:message code="message.${request?.benefitsOtherBenefits ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-otherBenefits" class="condition-isOtherBenefits-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/otherBenefits" model="['request':request]" />
        </div>
        
      
        
        <div id="widget-additionalFee" class="">
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
          
              <dt class="required condition-isFamilyAssistance-trigger"><g:message code="hcar.property.isFamilyAssistance.label" /> * : </dt><dd id="isFamilyAssistance" class="action-editField validate-boolean required-true i18n-hcar.property.isFamilyAssistance" ><span class="value-${request?.isFamilyAssistance}"><g:message code="message.${request?.isFamilyAssistance ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-familyAssistanceMembers" class="required condition-isFamilyAssistance-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/familyAssistanceMembers" model="['request':request]" />
        </div>
        
      
        
        <h3><g:message code="hcar.property.homeIntervention.label" /></h3>
        <dl class="">
          
              <dt class="required condition-isHomeIntervenant-trigger"><g:message code="hcar.property.homeInterventionHomeIntervenant.label" /> * : </dt><dd id="homeInterventionHomeIntervenant" class="action-editField validate-boolean required-true i18n-hcar.property.homeInterventionHomeIntervenant" ><span class="value-${request?.homeInterventionHomeIntervenant}"><g:message code="message.${request?.homeInterventionHomeIntervenant ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-homeIntervenants" class="condition-isHomeIntervenant-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/homeIntervenants" model="['request':request]" />
        </div>
        
      
        
        <h3><g:message code="hcar.property.care.label" /></h3>
        <dl class="">
          
              <dt class="required condition-isCareServices-trigger"><g:message code="hcar.property.careCareServices.label" /> * : </dt><dd id="careCareServices" class="action-editField validate-boolean required-true i18n-hcar.property.careCareServices" ><span class="value-${request?.careCareServices}"><g:message code="message.${request?.careCareServices ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-careServices" class="required condition-isCareServices-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/careServices" model="['request':request]" />
        </div>
        
      
        
        <h3><g:message code="hcar.property.facilities.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isHousing-trigger"><g:message code="hcar.property.facilitiesHousing.label" /> * : </dt><dd id="facilitiesHousing" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesHousing" ><span class="value-${request?.facilitiesHousing}"><g:message code="message.${request?.facilitiesHousing ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isHousing-filled"><g:message code="hcar.property.facilitiesHousingDetails.label" /> * : </dt><dd id="facilitiesHousingDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesHousingDetails maxLength-60" ><span>${request?.facilitiesHousingDetails}</span></dd>
          
              <dt class="required condition-isTechnicalAssistance-trigger"><g:message code="hcar.property.facilitiesTechnicalAssistance.label" /> * : </dt><dd id="facilitiesTechnicalAssistance" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesTechnicalAssistance" ><span class="value-${request?.facilitiesTechnicalAssistance}"><g:message code="message.${request?.facilitiesTechnicalAssistance ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isTechnicalAssistance-filled"><g:message code="hcar.property.facilitiesTechnicalAssistanceDetails.label" /> * : </dt><dd id="facilitiesTechnicalAssistanceDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesTechnicalAssistanceDetails maxLength-60" ><span>${request?.facilitiesTechnicalAssistanceDetails}</span></dd>
          
              <dt class="required condition-isCustomCar-trigger"><g:message code="hcar.property.facilitiesCustomCar.label" /> * : </dt><dd id="facilitiesCustomCar" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesCustomCar" ><span class="value-${request?.facilitiesCustomCar}"><g:message code="message.${request?.facilitiesCustomCar ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isCustomCar-filled"><g:message code="hcar.property.facilitiesCustomCarDetails.label" /> * : </dt><dd id="facilitiesCustomCarDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesCustomCarDetails maxLength-60" ><span>${request?.facilitiesCustomCarDetails}</span></dd>
          
              <dt class="required condition-isAnimalAid-trigger"><g:message code="hcar.property.facilitiesAnimalAid.label" /> * : </dt><dd id="facilitiesAnimalAid" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesAnimalAid" ><span class="value-${request?.facilitiesAnimalAid}"><g:message code="message.${request?.facilitiesAnimalAid ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isAnimalAid-filled"><g:message code="hcar.property.facilitiesAnimalAidDetails.label" /> * : </dt><dd id="facilitiesAnimalAidDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesAnimalAidDetails maxLength-60" ><span>${request?.facilitiesAnimalAidDetails}</span></dd>
          
              <dt class="required condition-isSpecializedTransport-trigger"><g:message code="hcar.property.facilitiesSpecializedTransport.label" /> * : </dt><dd id="facilitiesSpecializedTransport" class="action-editField validate-boolean required-true i18n-hcar.property.facilitiesSpecializedTransport" ><span class="value-${request?.facilitiesSpecializedTransport}"><g:message code="message.${request?.facilitiesSpecializedTransport ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSpecializedTransport-filled"><g:message code="hcar.property.facilitiesSpecializedTransportDetails.label" /> * : </dt><dd id="facilitiesSpecializedTransportDetails" class="action-editField validate- required-true i18n-hcar.property.facilitiesSpecializedTransportDetails maxLength-60" ><span>${request?.facilitiesSpecializedTransportDetails}</span></dd>
          
        </dl>
        
      
        
        <h3><g:message code="hcar.property.professionalSupport.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isProfessionals-trigger"><g:message code="hcar.property.professionalSupportProfessionals.label" /> * : </dt><dd id="professionalSupportProfessionals" class="action-editField validate-boolean required-true i18n-hcar.property.professionalSupportProfessionals" ><span class="value-${request?.professionalSupportProfessionals}"><g:message code="message.${request?.professionalSupportProfessionals ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isProfessionals-filled"><g:message code="hcar.property.professionalSupportDealsWithSameProfessional.label" /> * : </dt><dd id="professionalSupportDealsWithSameProfessional" class="action-editField validate-boolean required-true i18n-hcar.property.professionalSupportDealsWithSameProfessional" ><span class="value-${request?.professionalSupportDealsWithSameProfessional}"><g:message code="message.${request?.professionalSupportDealsWithSameProfessional ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-professionals" class="condition-isProfessionals-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/professionals" model="['request':request]" />
        </div>
        
      
        
        <h3><g:message code="hcar.property.socialService.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isSocialServiceSupport-trigger"><g:message code="hcar.property.professionalSupportSocialServiceSupport.label" /> * : </dt><dd id="professionalSupportSocialServiceSupport" class="action-editField validate-boolean required-true i18n-hcar.property.professionalSupportSocialServiceSupport" ><span class="value-${request?.professionalSupportSocialServiceSupport}"><g:message code="message.${request?.professionalSupportSocialServiceSupport ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSocialServiceSupport-filled"><g:message code="hcar.property.professionalSupportSocialServiceName.label" /> * : </dt><dd id="professionalSupportSocialServiceName" class="action-editField validate- required-true i18n-hcar.property.professionalSupportSocialServiceName maxLength-60" ><span>${request?.professionalSupportSocialServiceName}</span></dd>
          
              <dt class="required condition-isSocialServiceSupport-filled"><g:message code="hcar.property.professionalSupportSocialServiceAddress.label" /> * : </dt><dd id="professionalSupportSocialServiceAddress" class="action-editField validate-address required-true i18n-hcar.property.professionalSupportSocialServiceAddress" ><div><p class="additionalDeliveryInformation">${request?.professionalSupportSocialServiceAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.professionalSupportSocialServiceAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.professionalSupportSocialServiceAddress?.streetNumber}</span> <span class="streetName">${request?.professionalSupportSocialServiceAddress?.streetName}</span><p class="placeNameOrService">${request?.professionalSupportSocialServiceAddress?.placeNameOrService}</p><span class="postalCode">${request?.professionalSupportSocialServiceAddress?.postalCode}</span> <span class="city">${request?.professionalSupportSocialServiceAddress?.city}</span><p class="countryName">${request?.professionalSupportSocialServiceAddress?.countryName}</p></div></dd>
          
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
          
              <dt class="required condition-isFollowedByDoctor-trigger"><g:message code="hcar.property.healthFollowedByDoctor.label" /> * : </dt><dd id="healthFollowedByDoctor" class="action-editField validate-boolean required-true i18n-hcar.property.healthFollowedByDoctor" ><span class="value-${request?.healthFollowedByDoctor}"><g:message code="message.${request?.healthFollowedByDoctor ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isFollowedByDoctor-filled"><g:message code="hcar.property.healthDoctorLastName.label" /> * : </dt><dd id="healthDoctorLastName" class="action-editField validate-lastName required-true i18n-hcar.property.healthDoctorLastName maxLength-38" ><span>${request?.healthDoctorLastName}</span></dd>
          
              <dt class="required condition-isFollowedByDoctor-filled"><g:message code="hcar.property.healthDoctorFirstName.label" /> * : </dt><dd id="healthDoctorFirstName" class="action-editField validate-firstName required-true i18n-hcar.property.healthDoctorFirstName maxLength-38" ><span>${request?.healthDoctorFirstName}</span></dd>
          
              <dt class="required condition-isFollowedByProfessional-trigger"><g:message code="hcar.property.healthFollowedByProfessional.label" /> * : </dt><dd id="healthFollowedByProfessional" class="action-editField validate-boolean required-true i18n-hcar.property.healthFollowedByProfessional" ><span class="value-${request?.healthFollowedByProfessional}"><g:message code="message.${request?.healthFollowedByProfessional ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isFollowedByProfessional-filled"><g:message code="hcar.property.healthProfessionalLastName.label" /> * : </dt><dd id="healthProfessionalLastName" class="action-editField validate-lastName required-true i18n-hcar.property.healthProfessionalLastName maxLength-38" ><span>${request?.healthProfessionalLastName}</span></dd>
          
              <dt class="required condition-isFollowedByProfessional-filled"><g:message code="hcar.property.healthProfessionalFirstName.label" /> * : </dt><dd id="healthProfessionalFirstName" class="action-editField validate-firstName required-true i18n-hcar.property.healthProfessionalFirstName maxLength-38" ><span>${request?.healthProfessionalFirstName}</span></dd>
          
              <dt class="required condition-isFollowedByHospital-trigger"><g:message code="hcar.property.healthFollowedByHospital.label" /> * : </dt><dd id="healthFollowedByHospital" class="action-editField validate-boolean required-true i18n-hcar.property.healthFollowedByHospital" ><span class="value-${request?.healthFollowedByHospital}"><g:message code="message.${request?.healthFollowedByHospital ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isFollowedByHospital-filled"><g:message code="hcar.property.healthHospitalName.label" /> * : </dt><dd id="healthHospitalName" class="action-editField validate- required-true i18n-hcar.property.healthHospitalName maxLength-60" ><span>${request?.healthHospitalName}</span></dd>
          
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

