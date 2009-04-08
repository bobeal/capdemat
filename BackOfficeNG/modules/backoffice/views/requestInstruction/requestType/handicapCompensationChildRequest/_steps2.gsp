


<!-- step start -->
<div id="page7">
  <h2><g:message code="property.form" />
    <span><g:message code="hccr.step.health.label" /></span>
  </h2>
    
    <div class="yui-g">
      
      <!-- column start -->
      <div class="yui-u first">
        
          
          <h3><g:message code="hccr.property.health.label" /></h3>
          <dl class="required">
            
                <dt class="required condition-isFollowedByDoctor-trigger"><g:message code="hccr.property.healthFollowedByDoctor.label" /> * : </dt><dd id="healthFollowedByDoctor" class="action-editField validate-boolean required-true i18n-hccr.property.healthFollowedByDoctor" ><span class="value-${request?.healthFollowedByDoctor}"><g:message code="message.${request?.healthFollowedByDoctor ? 'yes' : 'no'}" /></span></dd>
            
                <dt class="required condition-isFollowedByDoctor-filled"><g:message code="hccr.property.healthDoctorLastName.label" /> * : </dt><dd id="healthDoctorLastName" class="action-editField validate-lastName required-true i18n-hccr.property.healthDoctorLastName maxLength-38" ><span>${request?.healthDoctorLastName}</span></dd>
            
                <dt class="required condition-isFollowedByDoctor-filled"><g:message code="hccr.property.healthDoctorFirstName.label" /> * : </dt><dd id="healthDoctorFirstName" class="action-editField validate-firstName required-true i18n-hccr.property.healthDoctorFirstName maxLength-38" ><span>${request?.healthDoctorFirstName}</span></dd>
            
                <dt class="required condition-isFollowedByProfessional-trigger"><g:message code="hccr.property.healthFollowedByProfessional.label" /> * : </dt><dd id="healthFollowedByProfessional" class="action-editField validate-boolean required-true i18n-hccr.property.healthFollowedByProfessional" ><span class="value-${request?.healthFollowedByProfessional}"><g:message code="message.${request?.healthFollowedByProfessional ? 'yes' : 'no'}" /></span></dd>
            
                <dt class="required condition-isFollowedByProfessional-filled"><g:message code="hccr.property.healthProfessionalLastName.label" /> * : </dt><dd id="healthProfessionalLastName" class="action-editField validate-lastName required-true i18n-hccr.property.healthProfessionalLastName maxLength-38" ><span>${request?.healthProfessionalLastName}</span></dd>
            
                <dt class="required condition-isFollowedByProfessional-filled"><g:message code="hccr.property.healthProfessionalFirstName.label" /> * : </dt><dd id="healthProfessionalFirstName" class="action-editField validate-firstName required-true i18n-hccr.property.healthProfessionalFirstName maxLength-38" ><span>${request?.healthProfessionalFirstName}</span></dd>
            
                <dt class="required condition-isFollowedByHospital-trigger"><g:message code="hccr.property.healthFollowedByHospital.label" /> * : </dt><dd id="healthFollowedByHospital" class="action-editField validate-boolean required-true i18n-hccr.property.healthFollowedByHospital" ><span class="value-${request?.healthFollowedByHospital}"><g:message code="message.${request?.healthFollowedByHospital ? 'yes' : 'no'}" /></span></dd>
            
                <dt class="required condition-isFollowedByHospital-filled"><g:message code="hccr.property.healthHospitalName.label" /> * : </dt><dd id="healthHospitalName" class="action-editField validate- required-true i18n-hccr.property.healthHospitalName maxLength-60" ><span>${request?.healthHospitalName}</span></dd>
            
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
    <span><g:message code="hccr.step.project.label" /></span>
  </h2>
    
    <div class="yui-g">
      
      <!-- column start -->
      <div class="yui-u first">
        
          
          <h3><g:message code="hccr.property.projectRequests.label" /></h3>
          <dl class="required">
            
                <dt class=""><g:message code="hccr.property.projectRequestsHandicapRecognition.label" />  : </dt><dd id="projectRequestsHandicapRecognition" class="action-editField validate-boolean i18n-hccr.property.projectRequestsHandicapRecognition" ><span class="value-${request?.projectRequestsHandicapRecognition}"><g:message code="message.${request?.projectRequestsHandicapRecognition ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsDisabilityCard.label" />  : </dt><dd id="projectRequestsDisabilityCard" class="action-editField validate-boolean i18n-hccr.property.projectRequestsDisabilityCard" ><span class="value-${request?.projectRequestsDisabilityCard}"><g:message code="message.${request?.projectRequestsDisabilityCard ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsDisabledPriorityCard.label" />  : </dt><dd id="projectRequestsDisabledPriorityCard" class="action-editField validate-boolean i18n-hccr.property.projectRequestsDisabledPriorityCard" ><span class="value-${request?.projectRequestsDisabledPriorityCard}"><g:message code="message.${request?.projectRequestsDisabledPriorityCard ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsEuropeanParkingCard.label" />  : </dt><dd id="projectRequestsEuropeanParkingCard" class="action-editField validate-boolean i18n-hccr.property.projectRequestsEuropeanParkingCard" ><span class="value-${request?.projectRequestsEuropeanParkingCard}"><g:message code="message.${request?.projectRequestsEuropeanParkingCard ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsDisabledAdultAllowance.label" />  : </dt><dd id="projectRequestsDisabledAdultAllowance" class="action-editField validate-boolean i18n-hccr.property.projectRequestsDisabledAdultAllowance" ><span class="value-${request?.projectRequestsDisabledAdultAllowance}"><g:message code="message.${request?.projectRequestsDisabledAdultAllowance ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsIncreaseForIndependentLiving.label" />  : </dt><dd id="projectRequestsIncreaseForIndependentLiving" class="action-editField validate-boolean i18n-hccr.property.projectRequestsIncreaseForIndependentLiving" ><span class="value-${request?.projectRequestsIncreaseForIndependentLiving}"><g:message code="message.${request?.projectRequestsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsEducationAllocationOfDisabledChildren.label" />  : </dt><dd id="projectRequestsEducationAllocationOfDisabledChildren" class="action-editField validate-boolean i18n-hccr.property.projectRequestsEducationAllocationOfDisabledChildren" ><span class="value-${request?.projectRequestsEducationAllocationOfDisabledChildren}"><g:message code="message.${request?.projectRequestsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsACTPRenewal.label" />  : </dt><dd id="projectRequestsACTPRenewal" class="action-editField validate-boolean i18n-hccr.property.projectRequestsACTPRenewal" ><span class="value-${request?.projectRequestsACTPRenewal}"><g:message code="message.${request?.projectRequestsACTPRenewal ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsThirdPartyHelp.label" />  : </dt><dd id="projectRequestsThirdPartyHelp" class="action-editField validate-boolean i18n-hccr.property.projectRequestsThirdPartyHelp" ><span class="value-${request?.projectRequestsThirdPartyHelp}"><g:message code="message.${request?.projectRequestsThirdPartyHelp ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsFreePensionMembership.label" />  : </dt><dd id="projectRequestsFreePensionMembership" class="action-editField validate-boolean i18n-hccr.property.projectRequestsFreePensionMembership" ><span class="value-${request?.projectRequestsFreePensionMembership}"><g:message code="message.${request?.projectRequestsFreePensionMembership ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsTechnicalHelp.label" />  : </dt><dd id="projectRequestsTechnicalHelp" class="action-editField validate-boolean i18n-hccr.property.projectRequestsTechnicalHelp" ><span class="value-${request?.projectRequestsTechnicalHelp}"><g:message code="message.${request?.projectRequestsTechnicalHelp ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsHousingFacilities.label" />  : </dt><dd id="projectRequestsHousingFacilities" class="action-editField validate-boolean i18n-hccr.property.projectRequestsHousingFacilities" ><span class="value-${request?.projectRequestsHousingFacilities}"><g:message code="message.${request?.projectRequestsHousingFacilities ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsCustomCar.label" />  : </dt><dd id="projectRequestsCustomCar" class="action-editField validate-boolean i18n-hccr.property.projectRequestsCustomCar" ><span class="value-${request?.projectRequestsCustomCar}"><g:message code="message.${request?.projectRequestsCustomCar ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsAssistance.label" />  : </dt><dd id="projectRequestsAssistance" class="action-editField validate-boolean i18n-hccr.property.projectRequestsAssistance" ><span class="value-${request?.projectRequestsAssistance}"><g:message code="message.${request?.projectRequestsAssistance ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsTransportCostAllocation.label" />  : </dt><dd id="projectRequestsTransportCostAllocation" class="action-editField validate-boolean i18n-hccr.property.projectRequestsTransportCostAllocation" ><span class="value-${request?.projectRequestsTransportCostAllocation}"><g:message code="message.${request?.projectRequestsTransportCostAllocation ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsDisabilityCostAllocation.label" />  : </dt><dd id="projectRequestsDisabilityCostAllocation" class="action-editField validate-boolean i18n-hccr.property.projectRequestsDisabilityCostAllocation" ><span class="value-${request?.projectRequestsDisabilityCostAllocation}"><g:message code="message.${request?.projectRequestsDisabilityCostAllocation ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsDisabledWorkerRecognition.label" />  : </dt><dd id="projectRequestsDisabledWorkerRecognition" class="action-editField validate-boolean i18n-hccr.property.projectRequestsDisabledWorkerRecognition" ><span class="value-${request?.projectRequestsDisabledWorkerRecognition}"><g:message code="message.${request?.projectRequestsDisabledWorkerRecognition ? 'yes' : 'no'}" /></span></dd>
            
                <dt class="condition-isProfessionalOrientationRequest-trigger"><g:message code="hccr.property.projectRequestsProfessionalOrientation.label" />  : </dt><dd id="projectRequestsProfessionalOrientation" class="action-editField validate-boolean i18n-hccr.property.projectRequestsProfessionalOrientation" ><span class="value-${request?.projectRequestsProfessionalOrientation}"><g:message code="message.${request?.projectRequestsProfessionalOrientation ? 'yes' : 'no'}" /></span></dd>
            
                <dt class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsOrdinaryWorking.label" />  : </dt><dd id="projectRequestsOrdinaryWorking" class="action-editField validate-boolean i18n-hccr.property.projectRequestsOrdinaryWorking" ><span class="value-${request?.projectRequestsOrdinaryWorking}"><g:message code="message.${request?.projectRequestsOrdinaryWorking ? 'yes' : 'no'}" /></span></dd>
            
                <dt class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsShelteredWork.label" />  : </dt><dd id="projectRequestsShelteredWork" class="action-editField validate-boolean i18n-hccr.property.projectRequestsShelteredWork" ><span class="value-${request?.projectRequestsShelteredWork}"><g:message code="message.${request?.projectRequestsShelteredWork ? 'yes' : 'no'}" /></span></dd>
            
                <dt class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsVocationalTraining.label" />  : </dt><dd id="projectRequestsVocationalTraining" class="action-editField validate-boolean i18n-hccr.property.projectRequestsVocationalTraining" ><span class="value-${request?.projectRequestsVocationalTraining}"><g:message code="message.${request?.projectRequestsVocationalTraining ? 'yes' : 'no'}" /></span></dd>
            
                <dt class=""><g:message code="hccr.property.projectRequestsInstitutionSupport.label" />  : </dt><dd id="projectRequestsInstitutionSupport" class="action-editField validate-boolean i18n-hccr.property.projectRequestsInstitutionSupport" ><span class="value-${request?.projectRequestsInstitutionSupport}"><g:message code="message.${request?.projectRequestsInstitutionSupport ? 'yes' : 'no'}" /></span></dd>
            
                <dt class="condition-isOtherRequest-trigger"><g:message code="hccr.property.projectRequestsOther.label" />  : </dt><dd id="projectRequestsOther" class="action-editField validate-boolean i18n-hccr.property.projectRequestsOther" ><span class="value-${request?.projectRequestsOther}"><g:message code="message.${request?.projectRequestsOther ? 'yes' : 'no'}" /></span></dd>
            
                <dt class="required condition-isOtherRequest-filled"><g:message code="hccr.property.projectRequestsOtherDetails.label" /> * : </dt><dd id="projectRequestsOtherDetails" class="action-editField validate- required-true i18n-hccr.property.projectRequestsOtherDetails maxLength-60" ><span>${request?.projectRequestsOtherDetails}</span></dd>
            
          </dl>
          
        
      </div>
      <!-- column end -->
      
      <!-- column start -->
      <div class="yui-u">
        
          
          <dl>
            <dt class=""><g:message code="hccr.property.projectWish.label" />  : </dt><dd id="projectWish" class="action-editField validate-textarea i18n-hccr.property.projectWish rows-10 maxLength-600" ><span>${request?.projectWish}</span></dd>
          </dl>
          
        
          
          <dl>
            <dt class=""><g:message code="hccr.property.projectNeeds.label" />  : </dt><dd id="projectNeeds" class="action-editField validate-textarea i18n-hccr.property.projectNeeds rows-10 maxLength-600" ><span>${request?.projectNeeds}</span></dd>
          </dl>
          
        
          
          <dl>
            <dt class=""><g:message code="hccr.property.projectComments.label" />  : </dt><dd id="projectComments" class="action-editField validate-textarea i18n-hccr.property.projectComments rows-10 maxLength-600" ><span>${request?.projectComments}</span></dd>
          </dl>
          
        
      </div>
      <!-- column end -->
      
    </div>
    <!-- data step  end -->
    
</div>
<!-- step end -->

