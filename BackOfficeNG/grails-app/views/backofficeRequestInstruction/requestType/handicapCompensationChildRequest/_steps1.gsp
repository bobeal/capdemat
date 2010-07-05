



<!-- step start -->
<div id="page4">
  <h2><g:message code="property.form" />
    <span><g:message code="hccr.step.folders.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
        
        <h3><g:message code="hccr.property.folders.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isMDPH-trigger"><g:message code="hccr.property.foldersMdph.label" /> * : </dt><dd id="foldersMdph" class="action-editField validate-boolean required-true i18n-hccr.property.foldersMdph" ><span class="value-${rqt?.foldersMdph}"><g:message code="message.${rqt?.foldersMdph ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="condition-isMDPH-filled"><g:message code="hccr.property.foldersMdphNumber.label" />  : </dt><dd id="foldersMdphNumber" class="action-editField validate- i18n-hccr.property.foldersMdphNumber maxLength-30" ><span>${rqt?.foldersMdphNumber}</span></dd>
          
              <dt class="condition-isMDPH-filled"><g:message code="hccr.property.foldersMdphDepartment.label" />  : </dt><dd id="foldersMdphDepartment" class="action-editField validate-departmentCode i18n-hccr.property.foldersMdphDepartment maxLength-2" ><span>${rqt?.foldersMdphDepartment}</span></dd>
          
              <dt class="required condition-isCOTOREP-trigger"><g:message code="hccr.property.foldersCotorep.label" /> * : </dt><dd id="foldersCotorep" class="action-editField validate-boolean required-true i18n-hccr.property.foldersCotorep" ><span class="value-${rqt?.foldersCotorep}"><g:message code="message.${rqt?.foldersCotorep ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="condition-isCOTOREP-filled"><g:message code="hccr.property.foldersCotorepNumber.label" />  : </dt><dd id="foldersCotorepNumber" class="action-editField validate- i18n-hccr.property.foldersCotorepNumber maxLength-30" ><span>${rqt?.foldersCotorepNumber}</span></dd>
          
              <dt class="condition-isCOTOREP-filled"><g:message code="hccr.property.foldersCotorepDepartment.label" />  : </dt><dd id="foldersCotorepDepartment" class="action-editField validate-departmentCode i18n-hccr.property.foldersCotorepDepartment maxLength-2" ><span>${rqt?.foldersCotorepDepartment}</span></dd>
          
              <dt class="required condition-isCDES-trigger"><g:message code="hccr.property.foldersCdes.label" /> * : </dt><dd id="foldersCdes" class="action-editField validate-boolean required-true i18n-hccr.property.foldersCdes" ><span class="value-${rqt?.foldersCdes}"><g:message code="message.${rqt?.foldersCdes ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="condition-isCDES-filled"><g:message code="hccr.property.foldersCdesNumber.label" />  : </dt><dd id="foldersCdesNumber" class="action-editField validate- i18n-hccr.property.foldersCdesNumber maxLength-30" ><span>${rqt?.foldersCdesNumber}</span></dd>
          
              <dt class="condition-isCDES-filled"><g:message code="hccr.property.foldersCdesDepartment.label" />  : </dt><dd id="foldersCdesDepartment" class="action-editField validate-departmentCode i18n-hccr.property.foldersCdesDepartment maxLength-2" ><span>${rqt?.foldersCdesDepartment}</span></dd>
          
              <dt class="required condition-isOtherFolders-trigger"><g:message code="hccr.property.foldersOtherFolders.label" /> * : </dt><dd id="foldersOtherFolders" class="action-editField validate-boolean required-true i18n-hccr.property.foldersOtherFolders" ><span class="value-${rqt?.foldersOtherFolders}"><g:message code="message.${rqt?.foldersOtherFolders ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-otherFolders" class="condition-isOtherFolders-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/otherFolders" model="['rqt':rqt]" />
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
    <span><g:message code="hccr.step.benefits.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
    </div>
    <!-- column end -->
    
    <!-- column start -->
    <div class="yui-u">
      
        
        <h3><g:message code="hccr.property.benefits.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isDisabilityRecognition-trigger"><g:message code="hccr.property.benefitsDisabilityRecognition.label" /> * : </dt><dd id="benefitsDisabilityRecognition" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabilityRecognition" ><span class="value-${rqt?.benefitsDisabilityRecognition}"><g:message code="message.${rqt?.benefitsDisabilityRecognition ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isDisabilityRecognition-filled"><g:message code="hccr.property.benefitsDisabilityRatio.label" /> * : </dt><dd id="benefitsDisabilityRatio" class="action-editField validate- required-true i18n-hccr.property.benefitsDisabilityRatio maxLength-3" ><span>${rqt?.benefitsDisabilityRatio}</span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsDisabilityCard.label" /> * : </dt><dd id="benefitsDisabilityCard" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabilityCard" ><span class="value-${rqt?.benefitsDisabilityCard}"><g:message code="message.${rqt?.benefitsDisabilityCard ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsPainfulStandingCard.label" /> * : </dt><dd id="benefitsPainfulStandingCard" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsPainfulStandingCard" ><span class="value-${rqt?.benefitsPainfulStandingCard}"><g:message code="message.${rqt?.benefitsPainfulStandingCard ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsParkingCard.label" /> * : </dt><dd id="benefitsParkingCard" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsParkingCard" ><span class="value-${rqt?.benefitsParkingCard}"><g:message code="message.${rqt?.benefitsParkingCard ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsDisabledWorkerRecognition.label" /> * : </dt><dd id="benefitsDisabledWorkerRecognition" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabledWorkerRecognition" ><span class="value-${rqt?.benefitsDisabledWorkerRecognition}"><g:message code="message.${rqt?.benefitsDisabledWorkerRecognition ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isProfessionalOrientation-trigger"><g:message code="hccr.property.benefitsProfessionalOrientation.label" /> * : </dt><dd id="benefitsProfessionalOrientation" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsProfessionalOrientation" ><span class="value-${rqt?.benefitsProfessionalOrientation}"><g:message code="message.${rqt?.benefitsProfessionalOrientation ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isProfessionalOrientation-filled"><g:message code="hccr.property.benefitsProfessionalOrientationDetails.label" /> * : </dt><dd id="benefitsProfessionalOrientationDetails" class="action-editField validate- required-true i18n-hccr.property.benefitsProfessionalOrientationDetails maxLength-60" ><span>${rqt?.benefitsProfessionalOrientationDetails}</span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsDisabledAdultAllocation.label" /> * : </dt><dd id="benefitsDisabledAdultAllocation" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabledAdultAllocation" ><span class="value-${rqt?.benefitsDisabledAdultAllocation}"><g:message code="message.${rqt?.benefitsDisabledAdultAllocation ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsIncreaseForIndependentLiving.label" /> * : </dt><dd id="benefitsIncreaseForIndependentLiving" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsIncreaseForIndependentLiving" ><span class="value-${rqt?.benefitsIncreaseForIndependentLiving}"><g:message code="message.${rqt?.benefitsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsEducationAllocationOfDisabledChildren.label" /> * : </dt><dd id="benefitsEducationAllocationOfDisabledChildren" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsEducationAllocationOfDisabledChildren" ><span class="value-${rqt?.benefitsEducationAllocationOfDisabledChildren}"><g:message code="message.${rqt?.benefitsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isEducationOfDisabledChildren-trigger"><g:message code="hccr.property.benefitsEducationOfDisabledChildren.label" /> * : </dt><dd id="benefitsEducationOfDisabledChildren" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsEducationOfDisabledChildren" ><span class="value-${rqt?.benefitsEducationOfDisabledChildren}"><g:message code="message.${rqt?.benefitsEducationOfDisabledChildren ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isEducationOfDisabledChildren-filled"><g:message code="hccr.property.benefitsEducationOfDisabledChildrenDetails.label" /> * : </dt><dd id="benefitsEducationOfDisabledChildrenDetails" class="action-editField validate- required-true i18n-hccr.property.benefitsEducationOfDisabledChildrenDetails maxLength-60" ><span>${rqt?.benefitsEducationOfDisabledChildrenDetails}</span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsSupplementForSingleParents.label" /> * : </dt><dd id="benefitsSupplementForSingleParents" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsSupplementForSingleParents" ><span class="value-${rqt?.benefitsSupplementForSingleParents}"><g:message code="message.${rqt?.benefitsSupplementForSingleParents ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsThirdPersonCompensatoryAllowance.label" /> * : </dt><dd id="benefitsThirdPersonCompensatoryAllowance" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsThirdPersonCompensatoryAllowance" ><span class="value-${rqt?.benefitsThirdPersonCompensatoryAllowance}"><g:message code="message.${rqt?.benefitsThirdPersonCompensatoryAllowance ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsThirdPartyCompensatoryAllowance.label" /> * : </dt><dd id="benefitsThirdPartyCompensatoryAllowance" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsThirdPartyCompensatoryAllowance" ><span class="value-${rqt?.benefitsThirdPartyCompensatoryAllowance}"><g:message code="message.${rqt?.benefitsThirdPartyCompensatoryAllowance ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsCompensatoryAllowanceForExpenses.label" /> * : </dt><dd id="benefitsCompensatoryAllowanceForExpenses" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsCompensatoryAllowanceForExpenses" ><span class="value-${rqt?.benefitsCompensatoryAllowanceForExpenses}"><g:message code="message.${rqt?.benefitsCompensatoryAllowanceForExpenses ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsDisabilityCompensation.label" /> * : </dt><dd id="benefitsDisabilityCompensation" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabilityCompensation" ><span class="value-${rqt?.benefitsDisabilityCompensation}"><g:message code="message.${rqt?.benefitsDisabilityCompensation ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isDisabilityPension-trigger"><g:message code="hccr.property.benefitsDisabilityPension.label" /> * : </dt><dd id="benefitsDisabilityPension" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabilityPension" ><span class="value-${rqt?.benefitsDisabilityPension}"><g:message code="message.${rqt?.benefitsDisabilityPension ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isDisabilityPension-filled"><g:message code="hccr.property.benefitsDisabilityPensionCategory.label" /> * : </dt><dd id="benefitsDisabilityPensionCategory" class="action-editField validate- required-true i18n-hccr.property.benefitsDisabilityPensionCategory maxLength-60" ><span>${rqt?.benefitsDisabilityPensionCategory}</span></dd>
          
              <dt class="required condition-isWorkAccidentAnnuity-trigger"><g:message code="hccr.property.benefitsWorkAccidentAnnuity.label" /> * : </dt><dd id="benefitsWorkAccidentAnnuity" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsWorkAccidentAnnuity" ><span class="value-${rqt?.benefitsWorkAccidentAnnuity}"><g:message code="message.${rqt?.benefitsWorkAccidentAnnuity ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isWorkAccidentAnnuity-filled"><g:message code="hccr.property.benefitsWorkAccidentAnnuityRatio.label" /> * : </dt><dd id="benefitsWorkAccidentAnnuityRatio" class="action-editField validate- required-true i18n-hccr.property.benefitsWorkAccidentAnnuityRatio maxLength-3" ><span>${rqt?.benefitsWorkAccidentAnnuityRatio}</span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsSocialWelfare.label" /> * : </dt><dd id="benefitsSocialWelfare" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsSocialWelfare" ><span class="value-${rqt?.benefitsSocialWelfare}"><g:message code="message.${rqt?.benefitsSocialWelfare ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsUnemploymentBenefits.label" /> * : </dt><dd id="benefitsUnemploymentBenefits" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsUnemploymentBenefits" ><span class="value-${rqt?.benefitsUnemploymentBenefits}"><g:message code="message.${rqt?.benefitsUnemploymentBenefits ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsDailyAllowances.label" /> * : </dt><dd id="benefitsDailyAllowances" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDailyAllowances" ><span class="value-${rqt?.benefitsDailyAllowances}"><g:message code="message.${rqt?.benefitsDailyAllowances ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required"><g:message code="hccr.property.benefitsThirdPartySupplement.label" /> * : </dt><dd id="benefitsThirdPartySupplement" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsThirdPartySupplement" ><span class="value-${rqt?.benefitsThirdPartySupplement}"><g:message code="message.${rqt?.benefitsThirdPartySupplement ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSupportedByAnInstitution-trigger"><g:message code="hccr.property.benefitsSupportedByAnInstitution.label" /> * : </dt><dd id="benefitsSupportedByAnInstitution" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsSupportedByAnInstitution" ><span class="value-${rqt?.benefitsSupportedByAnInstitution}"><g:message code="message.${rqt?.benefitsSupportedByAnInstitution ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSupportedByAnInstitution-filled"><g:message code="hccr.property.benefitsSupportedByAnInstitutionDetails.label" /> * : </dt><dd id="benefitsSupportedByAnInstitutionDetails" class="action-editField validate- required-true i18n-hccr.property.benefitsSupportedByAnInstitutionDetails maxLength-60" ><span>${rqt?.benefitsSupportedByAnInstitutionDetails}</span></dd>
          
              <dt class="required condition-isOtherBenefits-trigger"><g:message code="hccr.property.benefitsOtherBenefits.label" /> * : </dt><dd id="benefitsOtherBenefits" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsOtherBenefits" ><span class="value-${rqt?.benefitsOtherBenefits}"><g:message code="message.${rqt?.benefitsOtherBenefits ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-otherBenefits" class="condition-isOtherBenefits-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/otherBenefits" model="['rqt':rqt]" />
        </div>
        
      
        
        <div id="widget-additionalFee" class="">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/additionalFee" model="['rqt':rqt]" />
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
    <span><g:message code="hccr.step.aid.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
    </div>
    <!-- column end -->
    
    <!-- column start -->
    <div class="yui-u">
      
        
        <h3><g:message code="hccr.property.familyAssistance.label" /></h3>
        <dl class="">
          
              <dt class="required condition-isFamilyAssistance-trigger"><g:message code="hccr.property.isFamilyAssistance.label" /> * : </dt><dd id="isFamilyAssistance" class="action-editField validate-boolean required-true i18n-hccr.property.isFamilyAssistance" ><span class="value-${rqt?.isFamilyAssistance}"><g:message code="message.${rqt?.isFamilyAssistance ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-familyAssistanceMembers" class="required condition-isFamilyAssistance-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/familyAssistanceMembers" model="['rqt':rqt]" />
        </div>
        
      
        
        <h3><g:message code="hccr.property.homeIntervention.label" /></h3>
        <dl class="">
          
              <dt class="required condition-isHomeIntervenant-trigger"><g:message code="hccr.property.homeInterventionHomeIntervenant.label" /> * : </dt><dd id="homeInterventionHomeIntervenant" class="action-editField validate-boolean required-true i18n-hccr.property.homeInterventionHomeIntervenant" ><span class="value-${rqt?.homeInterventionHomeIntervenant}"><g:message code="message.${rqt?.homeInterventionHomeIntervenant ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-homeIntervenants" class="condition-isHomeIntervenant-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/homeIntervenants" model="['rqt':rqt]" />
        </div>
        
      
        
        <h3><g:message code="hccr.property.care.label" /></h3>
        <dl class="">
          
              <dt class="required condition-isCareServices-trigger"><g:message code="hccr.property.careCareServices.label" /> * : </dt><dd id="careCareServices" class="action-editField validate-boolean required-true i18n-hccr.property.careCareServices" ><span class="value-${rqt?.careCareServices}"><g:message code="message.${rqt?.careCareServices ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-careServices" class="required condition-isCareServices-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/careServices" model="['rqt':rqt]" />
        </div>
        
      
        
        <h3><g:message code="hccr.property.facilities.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isHousing-trigger"><g:message code="hccr.property.facilitiesHousing.label" /> * : </dt><dd id="facilitiesHousing" class="action-editField validate-boolean required-true i18n-hccr.property.facilitiesHousing" ><span class="value-${rqt?.facilitiesHousing}"><g:message code="message.${rqt?.facilitiesHousing ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isHousing-filled"><g:message code="hccr.property.facilitiesHousingDetails.label" /> * : </dt><dd id="facilitiesHousingDetails" class="action-editField validate- required-true i18n-hccr.property.facilitiesHousingDetails maxLength-60" ><span>${rqt?.facilitiesHousingDetails}</span></dd>
          
              <dt class="required condition-isTechnicalAssistance-trigger"><g:message code="hccr.property.facilitiesTechnicalAssistance.label" /> * : </dt><dd id="facilitiesTechnicalAssistance" class="action-editField validate-boolean required-true i18n-hccr.property.facilitiesTechnicalAssistance" ><span class="value-${rqt?.facilitiesTechnicalAssistance}"><g:message code="message.${rqt?.facilitiesTechnicalAssistance ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isTechnicalAssistance-filled"><g:message code="hccr.property.facilitiesTechnicalAssistanceDetails.label" /> * : </dt><dd id="facilitiesTechnicalAssistanceDetails" class="action-editField validate- required-true i18n-hccr.property.facilitiesTechnicalAssistanceDetails maxLength-60" ><span>${rqt?.facilitiesTechnicalAssistanceDetails}</span></dd>
          
              <dt class="required condition-isCustomCar-trigger"><g:message code="hccr.property.facilitiesCustomCar.label" /> * : </dt><dd id="facilitiesCustomCar" class="action-editField validate-boolean required-true i18n-hccr.property.facilitiesCustomCar" ><span class="value-${rqt?.facilitiesCustomCar}"><g:message code="message.${rqt?.facilitiesCustomCar ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isCustomCar-filled"><g:message code="hccr.property.facilitiesCustomCarDetails.label" /> * : </dt><dd id="facilitiesCustomCarDetails" class="action-editField validate- required-true i18n-hccr.property.facilitiesCustomCarDetails maxLength-60" ><span>${rqt?.facilitiesCustomCarDetails}</span></dd>
          
              <dt class="required condition-isAnimalAid-trigger"><g:message code="hccr.property.facilitiesAnimalAid.label" /> * : </dt><dd id="facilitiesAnimalAid" class="action-editField validate-boolean required-true i18n-hccr.property.facilitiesAnimalAid" ><span class="value-${rqt?.facilitiesAnimalAid}"><g:message code="message.${rqt?.facilitiesAnimalAid ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isAnimalAid-filled"><g:message code="hccr.property.facilitiesAnimalAidDetails.label" /> * : </dt><dd id="facilitiesAnimalAidDetails" class="action-editField validate- required-true i18n-hccr.property.facilitiesAnimalAidDetails maxLength-60" ><span>${rqt?.facilitiesAnimalAidDetails}</span></dd>
          
              <dt class="required condition-isSpecializedTransport-trigger"><g:message code="hccr.property.facilitiesSpecializedTransport.label" /> * : </dt><dd id="facilitiesSpecializedTransport" class="action-editField validate-boolean required-true i18n-hccr.property.facilitiesSpecializedTransport" ><span class="value-${rqt?.facilitiesSpecializedTransport}"><g:message code="message.${rqt?.facilitiesSpecializedTransport ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSpecializedTransport-filled"><g:message code="hccr.property.facilitiesSpecializedTransportDetails.label" /> * : </dt><dd id="facilitiesSpecializedTransportDetails" class="action-editField validate- required-true i18n-hccr.property.facilitiesSpecializedTransportDetails maxLength-60" ><span>${rqt?.facilitiesSpecializedTransportDetails}</span></dd>
          
        </dl>
        
      
        
        <h3><g:message code="hccr.property.professionalSupport.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isProfessionals-trigger"><g:message code="hccr.property.professionalSupportProfessionals.label" /> * : </dt><dd id="professionalSupportProfessionals" class="action-editField validate-boolean required-true i18n-hccr.property.professionalSupportProfessionals" ><span class="value-${rqt?.professionalSupportProfessionals}"><g:message code="message.${rqt?.professionalSupportProfessionals ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isProfessionals-filled"><g:message code="hccr.property.professionalSupportDealsWithSameProfessional.label" /> * : </dt><dd id="professionalSupportDealsWithSameProfessional" class="action-editField validate-boolean required-true i18n-hccr.property.professionalSupportDealsWithSameProfessional" ><span class="value-${rqt?.professionalSupportDealsWithSameProfessional}"><g:message code="message.${rqt?.professionalSupportDealsWithSameProfessional ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-professionals" class="condition-isProfessionals-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/professionals" model="['rqt':rqt]" />
        </div>
        
      
        
        <h3><g:message code="hccr.property.socialService.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isSocialServiceSupport-trigger"><g:message code="hccr.property.socialServiceSupport.label" /> * : </dt><dd id="socialServiceSupport" class="action-editField validate-boolean required-true i18n-hccr.property.socialServiceSupport" ><span class="value-${rqt?.socialServiceSupport}"><g:message code="message.${rqt?.socialServiceSupport ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isSocialServiceSupport-filled"><g:message code="hccr.property.socialServiceName.label" /> * : </dt><dd id="socialServiceName" class="action-editField validate- required-true i18n-hccr.property.socialServiceName maxLength-60" ><span>${rqt?.socialServiceName}</span></dd>
          
              <dt class="required condition-isSocialServiceSupport-filled"><g:message code="hccr.property.socialServiceAddress.label" /> * : </dt><dd id="socialServiceAddress" class="action-editField validate-address required-true i18n-hccr.property.socialServiceAddress" ><div><p class="additionalDeliveryInformation">${rqt?.socialServiceAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.socialServiceAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.socialServiceAddress?.streetNumber}</span> <span class="streetName">${rqt?.socialServiceAddress?.streetName}</span><g:if test="${!!rqt?.socialServiceAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.socialServiceAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.socialServiceAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.socialServiceAddress?.streetRivoliCode}</span></g:if><p class="streetMatriculation">Matricule: ${rqt?.socialServiceAddress?.streetMatriculation}</p><p class="placeNameOrService">${rqt?.socialServiceAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.socialServiceAddress?.postalCode}</span> <span class="city">${rqt?.socialServiceAddress?.city}</span><p class="countryName">${rqt?.socialServiceAddress?.countryName}</p><g:if test="${!!rqt?.socialServiceAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.socialServiceAddress?.cityInseeCode}</span></g:if></div></dd>
          
        </dl>
        
      
    </div>
    <!-- column end -->
    
  </div>
  <!-- data step  end -->
</div>
<!-- step end -->

