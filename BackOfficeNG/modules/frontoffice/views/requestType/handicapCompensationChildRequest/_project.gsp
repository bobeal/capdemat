


  
    <fieldset class="required">
    <legend><g:message code="hccr.property.projectRequests.label" /></legend>
    
      <label class=""><g:message code="hccr.property.projectRequestsHandicapRecognition.label" />   <span><g:message code="hccr.property.projectRequestsHandicapRecognition.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsHandicapRecognition" ${it == rqt.projectRequestsHandicapRecognition ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsDisabilityCard.label" />   <span><g:message code="hccr.property.projectRequestsDisabilityCard.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsDisabilityCard" ${it == rqt.projectRequestsDisabilityCard ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsDisabledPriorityCard.label" />   <span><g:message code="hccr.property.projectRequestsDisabledPriorityCard.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsDisabledPriorityCard" ${it == rqt.projectRequestsDisabledPriorityCard ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsEuropeanParkingCard.label" />   <span><g:message code="hccr.property.projectRequestsEuropeanParkingCard.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsEuropeanParkingCard" ${it == rqt.projectRequestsEuropeanParkingCard ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsDisabledAdultAllowance.label" />   <span><g:message code="hccr.property.projectRequestsDisabledAdultAllowance.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsDisabledAdultAllowance" ${it == rqt.projectRequestsDisabledAdultAllowance ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsIncreaseForIndependentLiving.label" />   <span><g:message code="hccr.property.projectRequestsIncreaseForIndependentLiving.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsIncreaseForIndependentLiving" ${it == rqt.projectRequestsIncreaseForIndependentLiving ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsEducationAllocationOfDisabledChildren.label" />   <span><g:message code="hccr.property.projectRequestsEducationAllocationOfDisabledChildren.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsEducationAllocationOfDisabledChildren" ${it == rqt.projectRequestsEducationAllocationOfDisabledChildren ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsACTPRenewal.label" />   <span><g:message code="hccr.property.projectRequestsACTPRenewal.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsACTPRenewal" ${it == rqt.projectRequestsACTPRenewal ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsThirdPartyHelp.label" />   <span><g:message code="hccr.property.projectRequestsThirdPartyHelp.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsThirdPartyHelp" ${it == rqt.projectRequestsThirdPartyHelp ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsFreePensionMembership.label" />   <span><g:message code="hccr.property.projectRequestsFreePensionMembership.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsFreePensionMembership" ${it == rqt.projectRequestsFreePensionMembership ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsTechnicalHelp.label" />   <span><g:message code="hccr.property.projectRequestsTechnicalHelp.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsTechnicalHelp" ${it == rqt.projectRequestsTechnicalHelp ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsHousingFacilities.label" />   <span><g:message code="hccr.property.projectRequestsHousingFacilities.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsHousingFacilities" ${it == rqt.projectRequestsHousingFacilities ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsCustomCar.label" />   <span><g:message code="hccr.property.projectRequestsCustomCar.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsCustomCar" ${it == rqt.projectRequestsCustomCar ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsAssistance.label" />   <span><g:message code="hccr.property.projectRequestsAssistance.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsAssistance" ${it == rqt.projectRequestsAssistance ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsTransportCostAllocation.label" />   <span><g:message code="hccr.property.projectRequestsTransportCostAllocation.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsTransportCostAllocation" ${it == rqt.projectRequestsTransportCostAllocation ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsDisabilityCostAllocation.label" />   <span><g:message code="hccr.property.projectRequestsDisabilityCostAllocation.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsDisabilityCostAllocation" ${it == rqt.projectRequestsDisabilityCostAllocation ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsDisabledWorkerRecognition.label" />   <span><g:message code="hccr.property.projectRequestsDisabledWorkerRecognition.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsDisabledWorkerRecognition" ${it == rqt.projectRequestsDisabledWorkerRecognition ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsProfessionalOrientation.label" />   <span><g:message code="hccr.property.projectRequestsProfessionalOrientation.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="condition-isProfessionalOrientationRequest-trigger  validate-boolean" title="" value="${it}" name="projectRequestsProfessionalOrientation" ${it == rqt.projectRequestsProfessionalOrientation ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsOrdinaryWorking.label" />   <span><g:message code="hccr.property.projectRequestsOrdinaryWorking.help" /></span></label>
            <ul class="yes-no condition-isProfessionalOrientationRequest-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="condition-isProfessionalOrientationRequest-filled  validate-boolean" title="" value="${it}" name="projectRequestsOrdinaryWorking" ${it == rqt.projectRequestsOrdinaryWorking ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsShelteredWork.label" />   <span><g:message code="hccr.property.projectRequestsShelteredWork.help" /></span></label>
            <ul class="yes-no condition-isProfessionalOrientationRequest-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="condition-isProfessionalOrientationRequest-filled  validate-boolean" title="" value="${it}" name="projectRequestsShelteredWork" ${it == rqt.projectRequestsShelteredWork ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsVocationalTraining.label" />   <span><g:message code="hccr.property.projectRequestsVocationalTraining.help" /></span></label>
            <ul class="yes-no condition-isProfessionalOrientationRequest-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="condition-isProfessionalOrientationRequest-filled  validate-boolean" title="" value="${it}" name="projectRequestsVocationalTraining" ${it == rqt.projectRequestsVocationalTraining ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsInstitutionSupport.label" />   <span><g:message code="hccr.property.projectRequestsInstitutionSupport.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-boolean" title="" value="${it}" name="projectRequestsInstitutionSupport" ${it == rqt.projectRequestsInstitutionSupport ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class=""><g:message code="hccr.property.projectRequestsOther.label" />   <span><g:message code="hccr.property.projectRequestsOther.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="condition-isOtherRequest-trigger  validate-boolean" title="" value="${it}" name="projectRequestsOther" ${it == rqt.projectRequestsOther ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isOtherRequest-filled"><g:message code="hccr.property.projectRequestsOtherDetails.label" /> *  <span><g:message code="hccr.property.projectRequestsOtherDetails.help" /></span></label>
            <input type="text" name="projectRequestsOtherDetails" value="${rqt.projectRequestsOtherDetails?.toString()}" 
                    class="required condition-isOtherRequest-filled  " title="<g:message code="hccr.property.projectRequestsOtherDetails.validationError" />"  maxLength="60"/>
            

    
    </fieldset>
  

  
    <label class=""><g:message code="hccr.property.projectWish.label" />   <span><g:message code="hccr.property.projectWish.help" /></span></label>
            <textarea name="projectWish" class="  validate-textarea" title="<g:message code="hccr.property.projectWish.validationError" />" rows="10" maxLength="600">${rqt.projectWish}</textarea>
            

  

  
    <label class=""><g:message code="hccr.property.projectNeeds.label" />   <span><g:message code="hccr.property.projectNeeds.help" /></span></label>
            <textarea name="projectNeeds" class="  validate-textarea" title="<g:message code="hccr.property.projectNeeds.validationError" />" rows="10" maxLength="600">${rqt.projectNeeds}</textarea>
            

  

  
    <label class=""><g:message code="hccr.property.projectComments.label" />   <span><g:message code="hccr.property.projectComments.help" /></span></label>
            <textarea name="projectComments" class="  validate-textarea" title="<g:message code="hccr.property.projectComments.validationError" />" rows="10" maxLength="600">${rqt.projectComments}</textarea>
            

  

