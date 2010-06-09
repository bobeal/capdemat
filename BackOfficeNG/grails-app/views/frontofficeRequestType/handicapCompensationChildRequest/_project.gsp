


  
    <fieldset class="required">
    <legend><g:message code="hccr.property.projectRequests.label" /></legend>
    
      <label class=""><g:message code="hccr.property.projectRequestsHandicapRecognition.label" />   <span><g:message code="hccr.property.projectRequestsHandicapRecognition.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsHandicapRecognition') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsHandicapRecognition_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsHandicapRecognition" ${it == rqt.projectRequestsHandicapRecognition ? 'checked="checked"': ''} />
                <label for="projectRequestsHandicapRecognition_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsDisabilityCard.label" />   <span><g:message code="hccr.property.projectRequestsDisabilityCard.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsDisabilityCard') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsDisabilityCard_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsDisabilityCard" ${it == rqt.projectRequestsDisabilityCard ? 'checked="checked"': ''} />
                <label for="projectRequestsDisabilityCard_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsDisabledPriorityCard.label" />   <span><g:message code="hccr.property.projectRequestsDisabledPriorityCard.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsDisabledPriorityCard') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsDisabledPriorityCard_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsDisabledPriorityCard" ${it == rqt.projectRequestsDisabledPriorityCard ? 'checked="checked"': ''} />
                <label for="projectRequestsDisabledPriorityCard_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsEuropeanParkingCard.label" />   <span><g:message code="hccr.property.projectRequestsEuropeanParkingCard.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsEuropeanParkingCard') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsEuropeanParkingCard_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsEuropeanParkingCard" ${it == rqt.projectRequestsEuropeanParkingCard ? 'checked="checked"': ''} />
                <label for="projectRequestsEuropeanParkingCard_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsDisabledAdultAllowance.label" />   <span><g:message code="hccr.property.projectRequestsDisabledAdultAllowance.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsDisabledAdultAllowance') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsDisabledAdultAllowance_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsDisabledAdultAllowance" ${it == rqt.projectRequestsDisabledAdultAllowance ? 'checked="checked"': ''} />
                <label for="projectRequestsDisabledAdultAllowance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsIncreaseForIndependentLiving.label" />   <span><g:message code="hccr.property.projectRequestsIncreaseForIndependentLiving.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsIncreaseForIndependentLiving') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsIncreaseForIndependentLiving_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsIncreaseForIndependentLiving" ${it == rqt.projectRequestsIncreaseForIndependentLiving ? 'checked="checked"': ''} />
                <label for="projectRequestsIncreaseForIndependentLiving_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsEducationAllocationOfDisabledChildren.label" />   <span><g:message code="hccr.property.projectRequestsEducationAllocationOfDisabledChildren.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsEducationAllocationOfDisabledChildren') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsEducationAllocationOfDisabledChildren_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsEducationAllocationOfDisabledChildren" ${it == rqt.projectRequestsEducationAllocationOfDisabledChildren ? 'checked="checked"': ''} />
                <label for="projectRequestsEducationAllocationOfDisabledChildren_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsACTPRenewal.label" />   <span><g:message code="hccr.property.projectRequestsACTPRenewal.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsACTPRenewal') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsACTPRenewal_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsACTPRenewal" ${it == rqt.projectRequestsACTPRenewal ? 'checked="checked"': ''} />
                <label for="projectRequestsACTPRenewal_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsThirdPartyHelp.label" />   <span><g:message code="hccr.property.projectRequestsThirdPartyHelp.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsThirdPartyHelp') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsThirdPartyHelp_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsThirdPartyHelp" ${it == rqt.projectRequestsThirdPartyHelp ? 'checked="checked"': ''} />
                <label for="projectRequestsThirdPartyHelp_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsFreePensionMembership.label" />   <span><g:message code="hccr.property.projectRequestsFreePensionMembership.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsFreePensionMembership') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsFreePensionMembership_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsFreePensionMembership" ${it == rqt.projectRequestsFreePensionMembership ? 'checked="checked"': ''} />
                <label for="projectRequestsFreePensionMembership_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsTechnicalHelp.label" />   <span><g:message code="hccr.property.projectRequestsTechnicalHelp.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsTechnicalHelp') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsTechnicalHelp_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsTechnicalHelp" ${it == rqt.projectRequestsTechnicalHelp ? 'checked="checked"': ''} />
                <label for="projectRequestsTechnicalHelp_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsHousingFacilities.label" />   <span><g:message code="hccr.property.projectRequestsHousingFacilities.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsHousingFacilities') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsHousingFacilities_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsHousingFacilities" ${it == rqt.projectRequestsHousingFacilities ? 'checked="checked"': ''} />
                <label for="projectRequestsHousingFacilities_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsCustomCar.label" />   <span><g:message code="hccr.property.projectRequestsCustomCar.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsCustomCar') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsCustomCar_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsCustomCar" ${it == rqt.projectRequestsCustomCar ? 'checked="checked"': ''} />
                <label for="projectRequestsCustomCar_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsAssistance.label" />   <span><g:message code="hccr.property.projectRequestsAssistance.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsAssistance') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsAssistance_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsAssistance" ${it == rqt.projectRequestsAssistance ? 'checked="checked"': ''} />
                <label for="projectRequestsAssistance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsTransportCostAllocation.label" />   <span><g:message code="hccr.property.projectRequestsTransportCostAllocation.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsTransportCostAllocation') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsTransportCostAllocation_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsTransportCostAllocation" ${it == rqt.projectRequestsTransportCostAllocation ? 'checked="checked"': ''} />
                <label for="projectRequestsTransportCostAllocation_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsDisabilityCostAllocation.label" />   <span><g:message code="hccr.property.projectRequestsDisabilityCostAllocation.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsDisabilityCostAllocation') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsDisabilityCostAllocation_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsDisabilityCostAllocation" ${it == rqt.projectRequestsDisabilityCostAllocation ? 'checked="checked"': ''} />
                <label for="projectRequestsDisabilityCostAllocation_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsDisabledWorkerRecognition.label" />   <span><g:message code="hccr.property.projectRequestsDisabledWorkerRecognition.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsDisabledWorkerRecognition') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsDisabledWorkerRecognition_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsDisabledWorkerRecognition" ${it == rqt.projectRequestsDisabledWorkerRecognition ? 'checked="checked"': ''} />
                <label for="projectRequestsDisabledWorkerRecognition_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsProfessionalOrientation.label" />   <span><g:message code="hccr.property.projectRequestsProfessionalOrientation.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsProfessionalOrientation') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsProfessionalOrientation_${it ? 'yes' : 'no'}" class="condition-isProfessionalOrientationRequest-trigger  validate-one-required boolean" title="" value="${it}" name="projectRequestsProfessionalOrientation" ${it == rqt.projectRequestsProfessionalOrientation ? 'checked="checked"': ''} />
                <label for="projectRequestsProfessionalOrientation_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsOrdinaryWorking.label" />   <span><g:message code="hccr.property.projectRequestsOrdinaryWorking.help" /></span></label>
            <ul class="yes-no condition-isProfessionalOrientationRequest-filled ${rqt.stepStates['project'].invalidFields.contains('projectRequestsOrdinaryWorking') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsOrdinaryWorking_${it ? 'yes' : 'no'}" class="condition-isProfessionalOrientationRequest-filled  validate-one-required boolean" title="" value="${it}" name="projectRequestsOrdinaryWorking" ${it == rqt.projectRequestsOrdinaryWorking ? 'checked="checked"': ''} />
                <label for="projectRequestsOrdinaryWorking_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsShelteredWork.label" />   <span><g:message code="hccr.property.projectRequestsShelteredWork.help" /></span></label>
            <ul class="yes-no condition-isProfessionalOrientationRequest-filled ${rqt.stepStates['project'].invalidFields.contains('projectRequestsShelteredWork') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsShelteredWork_${it ? 'yes' : 'no'}" class="condition-isProfessionalOrientationRequest-filled  validate-one-required boolean" title="" value="${it}" name="projectRequestsShelteredWork" ${it == rqt.projectRequestsShelteredWork ? 'checked="checked"': ''} />
                <label for="projectRequestsShelteredWork_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsVocationalTraining.label" />   <span><g:message code="hccr.property.projectRequestsVocationalTraining.help" /></span></label>
            <ul class="yes-no condition-isProfessionalOrientationRequest-filled ${rqt.stepStates['project'].invalidFields.contains('projectRequestsVocationalTraining') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsVocationalTraining_${it ? 'yes' : 'no'}" class="condition-isProfessionalOrientationRequest-filled  validate-one-required boolean" title="" value="${it}" name="projectRequestsVocationalTraining" ${it == rqt.projectRequestsVocationalTraining ? 'checked="checked"': ''} />
                <label for="projectRequestsVocationalTraining_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsInstitutionSupport.label" />   <span><g:message code="hccr.property.projectRequestsInstitutionSupport.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsInstitutionSupport') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsInstitutionSupport_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="projectRequestsInstitutionSupport" ${it == rqt.projectRequestsInstitutionSupport ? 'checked="checked"': ''} />
                <label for="projectRequestsInstitutionSupport_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsOther.label" />   <span><g:message code="hccr.property.projectRequestsOther.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['project'].invalidFields.contains('projectRequestsOther') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="projectRequestsOther_${it ? 'yes' : 'no'}" class="condition-isOtherRequest-trigger  validate-one-required boolean" title="" value="${it}" name="projectRequestsOther" ${it == rqt.projectRequestsOther ? 'checked="checked"': ''} />
                <label for="projectRequestsOther_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="projectRequestsOtherDetails" class="required condition-isOtherRequest-filled"><g:message code="hccr.property.projectRequestsOtherDetails.label" /> *  <span><g:message code="hccr.property.projectRequestsOtherDetails.help" /></span></label>
            <input type="text" id="projectRequestsOtherDetails" name="projectRequestsOtherDetails" value="${rqt.projectRequestsOtherDetails?.toString()}" 
                    class="required condition-isOtherRequest-filled   ${rqt.stepStates['project'].invalidFields.contains('projectRequestsOtherDetails') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.projectRequestsOtherDetails.validationError" />"  maxlength="60" />
            

    
    </fieldset>
  

  
    <label for="projectWish" class=""><g:message code="hccr.property.projectWish.label" />   <span><g:message code="hccr.property.projectWish.help" /></span></label>
            <textarea id="projectWish" name="projectWish" class="  validate-textarea ${rqt.stepStates['project'].invalidFields.contains('projectWish') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.projectWish.validationError" />" rows="10" cols=""  maxlength="600">${rqt.projectWish}</textarea>
            

  

  
    <label for="projectNeeds" class=""><g:message code="hccr.property.projectNeeds.label" />   <span><g:message code="hccr.property.projectNeeds.help" /></span></label>
            <textarea id="projectNeeds" name="projectNeeds" class="  validate-textarea ${rqt.stepStates['project'].invalidFields.contains('projectNeeds') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.projectNeeds.validationError" />" rows="10" cols=""  maxlength="600">${rqt.projectNeeds}</textarea>
            

  

  
    <label for="projectComments" class=""><g:message code="hccr.property.projectComments.label" />   <span><g:message code="hccr.property.projectComments.help" /></span></label>
            <textarea id="projectComments" name="projectComments" class="  validate-textarea ${rqt.stepStates['project'].invalidFields.contains('projectComments') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.projectComments.validationError" />" rows="10" cols=""  maxlength="600">${rqt.projectComments}</textarea>
            

  

