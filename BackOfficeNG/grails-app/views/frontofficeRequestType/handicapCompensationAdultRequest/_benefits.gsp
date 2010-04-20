


  
    <fieldset class="required">
    <legend><g:message code="hcar.property.benefits.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.benefitsDisabilityRecognition.label" /> *  <span><g:message code="hcar.property.benefitsDisabilityRecognition.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsDisabilityRecognition_${it ? 'yes' : 'no'}" class="required condition-isDisabilityRecognition-trigger  validate-one-required boolean" title="" value="${it}" name="benefitsDisabilityRecognition" ${it == rqt.benefitsDisabilityRecognition ? 'checked="checked"': ''} />
                <label for="benefitsDisabilityRecognition_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="benefitsDisabilityRatio" class="required condition-isDisabilityRecognition-filled"><g:message code="hcar.property.benefitsDisabilityRatio.label" /> *  <span><g:message code="hcar.property.benefitsDisabilityRatio.help" /></span></label>
            <input type="text" id="benefitsDisabilityRatio" name="benefitsDisabilityRatio" value="${rqt.benefitsDisabilityRatio?.toString()}" 
                    class="required condition-isDisabilityRecognition-filled  " title="<g:message code="hcar.property.benefitsDisabilityRatio.validationError" />"  maxlength="3" />
            

    
      <label class="required"><g:message code="hcar.property.benefitsDisabilityCard.label" /> *  <span><g:message code="hcar.property.benefitsDisabilityCard.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsDisabilityCard_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsDisabilityCard" ${it == rqt.benefitsDisabilityCard ? 'checked="checked"': ''} />
                <label for="benefitsDisabilityCard_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsPainfulStandingCard.label" /> *  <span><g:message code="hcar.property.benefitsPainfulStandingCard.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsPainfulStandingCard_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsPainfulStandingCard" ${it == rqt.benefitsPainfulStandingCard ? 'checked="checked"': ''} />
                <label for="benefitsPainfulStandingCard_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsParkingCard.label" /> *  <span><g:message code="hcar.property.benefitsParkingCard.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsParkingCard_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsParkingCard" ${it == rqt.benefitsParkingCard ? 'checked="checked"': ''} />
                <label for="benefitsParkingCard_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsDisabledWorkerRecognition.label" /> *  <span><g:message code="hcar.property.benefitsDisabledWorkerRecognition.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsDisabledWorkerRecognition_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsDisabledWorkerRecognition" ${it == rqt.benefitsDisabledWorkerRecognition ? 'checked="checked"': ''} />
                <label for="benefitsDisabledWorkerRecognition_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsProfessionalOrientation.label" /> *  <span><g:message code="hcar.property.benefitsProfessionalOrientation.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsProfessionalOrientation_${it ? 'yes' : 'no'}" class="required condition-isProfessionalOrientation-trigger  validate-one-required boolean" title="" value="${it}" name="benefitsProfessionalOrientation" ${it == rqt.benefitsProfessionalOrientation ? 'checked="checked"': ''} />
                <label for="benefitsProfessionalOrientation_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="benefitsProfessionalOrientationDetails" class="required condition-isProfessionalOrientation-filled"><g:message code="hcar.property.benefitsProfessionalOrientationDetails.label" /> *  <span><g:message code="hcar.property.benefitsProfessionalOrientationDetails.help" /></span></label>
            <input type="text" id="benefitsProfessionalOrientationDetails" name="benefitsProfessionalOrientationDetails" value="${rqt.benefitsProfessionalOrientationDetails?.toString()}" 
                    class="required condition-isProfessionalOrientation-filled  " title="<g:message code="hcar.property.benefitsProfessionalOrientationDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.benefitsDisabledAdultAllocation.label" /> *  <span><g:message code="hcar.property.benefitsDisabledAdultAllocation.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsDisabledAdultAllocation_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsDisabledAdultAllocation" ${it == rqt.benefitsDisabledAdultAllocation ? 'checked="checked"': ''} />
                <label for="benefitsDisabledAdultAllocation_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsIncreaseForIndependentLiving.label" /> *  <span><g:message code="hcar.property.benefitsIncreaseForIndependentLiving.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsIncreaseForIndependentLiving_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsIncreaseForIndependentLiving" ${it == rqt.benefitsIncreaseForIndependentLiving ? 'checked="checked"': ''} />
                <label for="benefitsIncreaseForIndependentLiving_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsEducationAllocationOfDisabledChildren.label" /> *  <span><g:message code="hcar.property.benefitsEducationAllocationOfDisabledChildren.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsEducationAllocationOfDisabledChildren_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsEducationAllocationOfDisabledChildren" ${it == rqt.benefitsEducationAllocationOfDisabledChildren ? 'checked="checked"': ''} />
                <label for="benefitsEducationAllocationOfDisabledChildren_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsEducationOfDisabledChildren.label" /> *  <span><g:message code="hcar.property.benefitsEducationOfDisabledChildren.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsEducationOfDisabledChildren_${it ? 'yes' : 'no'}" class="required condition-isEducationOfDisabledChildren-trigger  validate-one-required boolean" title="" value="${it}" name="benefitsEducationOfDisabledChildren" ${it == rqt.benefitsEducationOfDisabledChildren ? 'checked="checked"': ''} />
                <label for="benefitsEducationOfDisabledChildren_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="benefitsEducationOfDisabledChildrenDetails" class="required condition-isEducationOfDisabledChildren-filled"><g:message code="hcar.property.benefitsEducationOfDisabledChildrenDetails.label" /> *  <span><g:message code="hcar.property.benefitsEducationOfDisabledChildrenDetails.help" /></span></label>
            <input type="text" id="benefitsEducationOfDisabledChildrenDetails" name="benefitsEducationOfDisabledChildrenDetails" value="${rqt.benefitsEducationOfDisabledChildrenDetails?.toString()}" 
                    class="required condition-isEducationOfDisabledChildren-filled  " title="<g:message code="hcar.property.benefitsEducationOfDisabledChildrenDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.benefitsSupplementForSingleParents.label" /> *  <span><g:message code="hcar.property.benefitsSupplementForSingleParents.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsSupplementForSingleParents_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsSupplementForSingleParents" ${it == rqt.benefitsSupplementForSingleParents ? 'checked="checked"': ''} />
                <label for="benefitsSupplementForSingleParents_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsThirdPersonCompensatoryAllowance.label" /> *  <span><g:message code="hcar.property.benefitsThirdPersonCompensatoryAllowance.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsThirdPersonCompensatoryAllowance_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsThirdPersonCompensatoryAllowance" ${it == rqt.benefitsThirdPersonCompensatoryAllowance ? 'checked="checked"': ''} />
                <label for="benefitsThirdPersonCompensatoryAllowance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsThirdPartyCompensatoryAllowance.label" /> *  <span><g:message code="hcar.property.benefitsThirdPartyCompensatoryAllowance.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsThirdPartyCompensatoryAllowance_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsThirdPartyCompensatoryAllowance" ${it == rqt.benefitsThirdPartyCompensatoryAllowance ? 'checked="checked"': ''} />
                <label for="benefitsThirdPartyCompensatoryAllowance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsCompensatoryAllowanceForExpenses.label" /> *  <span><g:message code="hcar.property.benefitsCompensatoryAllowanceForExpenses.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsCompensatoryAllowanceForExpenses_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsCompensatoryAllowanceForExpenses" ${it == rqt.benefitsCompensatoryAllowanceForExpenses ? 'checked="checked"': ''} />
                <label for="benefitsCompensatoryAllowanceForExpenses_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsDisabilityCompensation.label" /> *  <span><g:message code="hcar.property.benefitsDisabilityCompensation.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsDisabilityCompensation_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsDisabilityCompensation" ${it == rqt.benefitsDisabilityCompensation ? 'checked="checked"': ''} />
                <label for="benefitsDisabilityCompensation_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsDisabilityPension.label" /> *  <span><g:message code="hcar.property.benefitsDisabilityPension.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsDisabilityPension_${it ? 'yes' : 'no'}" class="required condition-isDisabilityPension-trigger  validate-one-required boolean" title="" value="${it}" name="benefitsDisabilityPension" ${it == rqt.benefitsDisabilityPension ? 'checked="checked"': ''} />
                <label for="benefitsDisabilityPension_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="benefitsDisabilityPensionCategory" class="required condition-isDisabilityPension-filled"><g:message code="hcar.property.benefitsDisabilityPensionCategory.label" /> *  <span><g:message code="hcar.property.benefitsDisabilityPensionCategory.help" /></span></label>
            <input type="text" id="benefitsDisabilityPensionCategory" name="benefitsDisabilityPensionCategory" value="${rqt.benefitsDisabilityPensionCategory?.toString()}" 
                    class="required condition-isDisabilityPension-filled  " title="<g:message code="hcar.property.benefitsDisabilityPensionCategory.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.benefitsWorkAccidentAnnuity.label" /> *  <span><g:message code="hcar.property.benefitsWorkAccidentAnnuity.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsWorkAccidentAnnuity_${it ? 'yes' : 'no'}" class="required condition-isWorkAccidentAnnuity-trigger  validate-one-required boolean" title="" value="${it}" name="benefitsWorkAccidentAnnuity" ${it == rqt.benefitsWorkAccidentAnnuity ? 'checked="checked"': ''} />
                <label for="benefitsWorkAccidentAnnuity_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="benefitsWorkAccidentAnnuityRatio" class="required condition-isWorkAccidentAnnuity-filled"><g:message code="hcar.property.benefitsWorkAccidentAnnuityRatio.label" /> *  <span><g:message code="hcar.property.benefitsWorkAccidentAnnuityRatio.help" /></span></label>
            <input type="text" id="benefitsWorkAccidentAnnuityRatio" name="benefitsWorkAccidentAnnuityRatio" value="${rqt.benefitsWorkAccidentAnnuityRatio?.toString()}" 
                    class="required condition-isWorkAccidentAnnuity-filled  " title="<g:message code="hcar.property.benefitsWorkAccidentAnnuityRatio.validationError" />"  maxlength="3" />
            

    
      <label class="required"><g:message code="hcar.property.benefitsSocialWelfare.label" /> *  <span><g:message code="hcar.property.benefitsSocialWelfare.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsSocialWelfare_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsSocialWelfare" ${it == rqt.benefitsSocialWelfare ? 'checked="checked"': ''} />
                <label for="benefitsSocialWelfare_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsUnemploymentBenefits.label" /> *  <span><g:message code="hcar.property.benefitsUnemploymentBenefits.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsUnemploymentBenefits_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsUnemploymentBenefits" ${it == rqt.benefitsUnemploymentBenefits ? 'checked="checked"': ''} />
                <label for="benefitsUnemploymentBenefits_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsDailyAllowances.label" /> *  <span><g:message code="hcar.property.benefitsDailyAllowances.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsDailyAllowances_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsDailyAllowances" ${it == rqt.benefitsDailyAllowances ? 'checked="checked"': ''} />
                <label for="benefitsDailyAllowances_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsThirdPartySupplement.label" /> *  <span><g:message code="hcar.property.benefitsThirdPartySupplement.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsThirdPartySupplement_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="benefitsThirdPartySupplement" ${it == rqt.benefitsThirdPartySupplement ? 'checked="checked"': ''} />
                <label for="benefitsThirdPartySupplement_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hcar.property.benefitsSupportedByAnInstitution.label" /> *  <span><g:message code="hcar.property.benefitsSupportedByAnInstitution.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsSupportedByAnInstitution_${it ? 'yes' : 'no'}" class="required condition-isSupportedByAnInstitution-trigger  validate-one-required boolean" title="" value="${it}" name="benefitsSupportedByAnInstitution" ${it == rqt.benefitsSupportedByAnInstitution ? 'checked="checked"': ''} />
                <label for="benefitsSupportedByAnInstitution_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="benefitsSupportedByAnInstitutionDetails" class="required condition-isSupportedByAnInstitution-filled"><g:message code="hcar.property.benefitsSupportedByAnInstitutionDetails.label" /> *  <span><g:message code="hcar.property.benefitsSupportedByAnInstitutionDetails.help" /></span></label>
            <input type="text" id="benefitsSupportedByAnInstitutionDetails" name="benefitsSupportedByAnInstitutionDetails" value="${rqt.benefitsSupportedByAnInstitutionDetails?.toString()}" 
                    class="required condition-isSupportedByAnInstitution-filled  " title="<g:message code="hcar.property.benefitsSupportedByAnInstitutionDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.benefitsOtherBenefits.label" /> *  <span><g:message code="hcar.property.benefitsOtherBenefits.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="benefitsOtherBenefits_${it ? 'yes' : 'no'}" class="required condition-isOtherBenefits-trigger  validate-one-required boolean" title="" value="${it}" name="benefitsOtherBenefits" ${it == rqt.benefitsOtherBenefits ? 'checked="checked"': ''} />
                <label for="benefitsOtherBenefits_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <div class="collection condition-isOtherBenefits-filled">
    <h3>
      <g:message code="hcar.property.otherBenefits.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="hcar.property.otherBenefits.help" /></span>
      <button type="submit" name="submit-collectionAdd-benefits-otherBenefits">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.otherBenefits}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="hcar.property.otherBenefits.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-benefits-otherBenefits[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label for="otherBenefits.${listIndex}.otherBenefitName" class="required"><g:message code="hcar.property.otherBenefitName.label" /> *  <span><g:message code="hcar.property.otherBenefitName.help" /></span></label>
            <input type="text" id="otherBenefits.${listIndex}.otherBenefitName" name="otherBenefits[${listIndex}].otherBenefitName" value="${listItem?.otherBenefitName?.toString()}" 
                    class="required  " title="<g:message code="hcar.property.otherBenefitName.validationError" />"  maxlength="60" />
            

        
      </fieldset>
    </g:each>
    </div>
  

  
    <div class="collection ">
    <h3>
      <g:message code="hcar.property.additionalFee.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="hcar.property.additionalFee.help" /></span>
      <button type="submit" name="submit-collectionAdd-benefits-additionalFee">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.additionalFee}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="hcar.property.additionalFee.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-benefits-additionalFee[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label for="additionalFee.${listIndex}.additionalFeeKind" class="required"><g:message code="hcar.property.additionalFeeKind.label" /> *  <span><g:message code="hcar.property.additionalFeeKind.help" /></span></label>
            <input type="text" id="additionalFee.${listIndex}.additionalFeeKind" name="additionalFee[${listIndex}].additionalFeeKind" value="${listItem?.additionalFeeKind?.toString()}" 
                    class="required  " title="<g:message code="hcar.property.additionalFeeKind.validationError" />"  maxlength="30" />
            

        
          <label for="additionalFee.${listIndex}.additionalFeeCost" class="required"><g:message code="hcar.property.additionalFeeCost.label" /> *  <span><g:message code="hcar.property.additionalFeeCost.help" /></span></label>
            <input type="text" id="additionalFee.${listIndex}.additionalFeeCost" name="additionalFee[${listIndex}].additionalFeeCost" value="${listItem?.additionalFeeCost?.toString()}" 
                    class="required  " title="<g:message code="hcar.property.additionalFeeCost.validationError" />"   />
            

        
          <label for="additionalFee.${listIndex}.additionalFeePeriodicity" class="required"><g:message code="hcar.property.additionalFeePeriodicity.label" /> *  <span><g:message code="hcar.property.additionalFeePeriodicity.help" /></span></label>
            <input type="text" id="additionalFee.${listIndex}.additionalFeePeriodicity" name="additionalFee[${listIndex}].additionalFeePeriodicity" value="${listItem?.additionalFeePeriodicity?.toString()}" 
                    class="required  " title="<g:message code="hcar.property.additionalFeePeriodicity.validationError" />"  maxlength="30" />
            

        
      </fieldset>
    </g:each>
    </div>
  

