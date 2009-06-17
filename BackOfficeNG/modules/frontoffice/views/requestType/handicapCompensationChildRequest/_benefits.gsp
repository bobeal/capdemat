


  
    <fieldset class="required">
    <legend><g:message code="hccr.property.benefits.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.benefitsDisabilityRecognition.label" /> *  <span><g:message code="hccr.property.benefitsDisabilityRecognition.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isDisabilityRecognition-trigger  validate-boolean" title="" value="${it}" name="benefitsDisabilityRecognition" ${it == rqt.benefitsDisabilityRecognition ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isDisabilityRecognition-filled"><g:message code="hccr.property.benefitsDisabilityRatio.label" /> *  <span><g:message code="hccr.property.benefitsDisabilityRatio.help" /></span></label>
            <input type="text" name="benefitsDisabilityRatio" value="${rqt.benefitsDisabilityRatio?.toString()}" 
                    class="required condition-isDisabilityRecognition-filled  " title="<g:message code="hccr.property.benefitsDisabilityRatio.validationError" />"  maxLength="3"/>
            

    
      <label class="required"><g:message code="hccr.property.benefitsDisabilityCard.label" /> *  <span><g:message code="hccr.property.benefitsDisabilityCard.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsDisabilityCard" ${it == rqt.benefitsDisabilityCard ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsPainfulStandingCard.label" /> *  <span><g:message code="hccr.property.benefitsPainfulStandingCard.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsPainfulStandingCard" ${it == rqt.benefitsPainfulStandingCard ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsParkingCard.label" /> *  <span><g:message code="hccr.property.benefitsParkingCard.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsParkingCard" ${it == rqt.benefitsParkingCard ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsDisabledWorkerRecognition.label" /> *  <span><g:message code="hccr.property.benefitsDisabledWorkerRecognition.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsDisabledWorkerRecognition" ${it == rqt.benefitsDisabledWorkerRecognition ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsProfessionalOrientation.label" /> *  <span><g:message code="hccr.property.benefitsProfessionalOrientation.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isProfessionalOrientation-trigger  validate-boolean" title="" value="${it}" name="benefitsProfessionalOrientation" ${it == rqt.benefitsProfessionalOrientation ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isProfessionalOrientation-filled"><g:message code="hccr.property.benefitsProfessionalOrientationDetails.label" /> *  <span><g:message code="hccr.property.benefitsProfessionalOrientationDetails.help" /></span></label>
            <input type="text" name="benefitsProfessionalOrientationDetails" value="${rqt.benefitsProfessionalOrientationDetails?.toString()}" 
                    class="required condition-isProfessionalOrientation-filled  " title="<g:message code="hccr.property.benefitsProfessionalOrientationDetails.validationError" />"  maxLength="60"/>
            

    
      <label class="required"><g:message code="hccr.property.benefitsDisabledAdultAllocation.label" /> *  <span><g:message code="hccr.property.benefitsDisabledAdultAllocation.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsDisabledAdultAllocation" ${it == rqt.benefitsDisabledAdultAllocation ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsIncreaseForIndependentLiving.label" /> *  <span><g:message code="hccr.property.benefitsIncreaseForIndependentLiving.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsIncreaseForIndependentLiving" ${it == rqt.benefitsIncreaseForIndependentLiving ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsEducationAllocationOfDisabledChildren.label" /> *  <span><g:message code="hccr.property.benefitsEducationAllocationOfDisabledChildren.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsEducationAllocationOfDisabledChildren" ${it == rqt.benefitsEducationAllocationOfDisabledChildren ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsEducationOfDisabledChildren.label" /> *  <span><g:message code="hccr.property.benefitsEducationOfDisabledChildren.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isEducationOfDisabledChildren-trigger  validate-boolean" title="" value="${it}" name="benefitsEducationOfDisabledChildren" ${it == rqt.benefitsEducationOfDisabledChildren ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isEducationOfDisabledChildren-filled"><g:message code="hccr.property.benefitsEducationOfDisabledChildrenDetails.label" /> *  <span><g:message code="hccr.property.benefitsEducationOfDisabledChildrenDetails.help" /></span></label>
            <input type="text" name="benefitsEducationOfDisabledChildrenDetails" value="${rqt.benefitsEducationOfDisabledChildrenDetails?.toString()}" 
                    class="required condition-isEducationOfDisabledChildren-filled  " title="<g:message code="hccr.property.benefitsEducationOfDisabledChildrenDetails.validationError" />"  maxLength="60"/>
            

    
      <label class="required"><g:message code="hccr.property.benefitsSupplementForSingleParents.label" /> *  <span><g:message code="hccr.property.benefitsSupplementForSingleParents.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsSupplementForSingleParents" ${it == rqt.benefitsSupplementForSingleParents ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsThirdPersonCompensatoryAllowance.label" /> *  <span><g:message code="hccr.property.benefitsThirdPersonCompensatoryAllowance.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsThirdPersonCompensatoryAllowance" ${it == rqt.benefitsThirdPersonCompensatoryAllowance ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsThirdPartyCompensatoryAllowance.label" /> *  <span><g:message code="hccr.property.benefitsThirdPartyCompensatoryAllowance.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsThirdPartyCompensatoryAllowance" ${it == rqt.benefitsThirdPartyCompensatoryAllowance ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsCompensatoryAllowanceForExpenses.label" /> *  <span><g:message code="hccr.property.benefitsCompensatoryAllowanceForExpenses.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsCompensatoryAllowanceForExpenses" ${it == rqt.benefitsCompensatoryAllowanceForExpenses ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsDisabilityCompensation.label" /> *  <span><g:message code="hccr.property.benefitsDisabilityCompensation.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsDisabilityCompensation" ${it == rqt.benefitsDisabilityCompensation ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsDisabilityPension.label" /> *  <span><g:message code="hccr.property.benefitsDisabilityPension.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isDisabilityPension-trigger  validate-boolean" title="" value="${it}" name="benefitsDisabilityPension" ${it == rqt.benefitsDisabilityPension ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isDisabilityPension-filled"><g:message code="hccr.property.benefitsDisabilityPensionCategory.label" /> *  <span><g:message code="hccr.property.benefitsDisabilityPensionCategory.help" /></span></label>
            <input type="text" name="benefitsDisabilityPensionCategory" value="${rqt.benefitsDisabilityPensionCategory?.toString()}" 
                    class="required condition-isDisabilityPension-filled  " title="<g:message code="hccr.property.benefitsDisabilityPensionCategory.validationError" />"  maxLength="60"/>
            

    
      <label class="required"><g:message code="hccr.property.benefitsWorkAccidentAnnuity.label" /> *  <span><g:message code="hccr.property.benefitsWorkAccidentAnnuity.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isWorkAccidentAnnuity-trigger  validate-boolean" title="" value="${it}" name="benefitsWorkAccidentAnnuity" ${it == rqt.benefitsWorkAccidentAnnuity ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isWorkAccidentAnnuity-filled"><g:message code="hccr.property.benefitsWorkAccidentAnnuityRatio.label" /> *  <span><g:message code="hccr.property.benefitsWorkAccidentAnnuityRatio.help" /></span></label>
            <input type="text" name="benefitsWorkAccidentAnnuityRatio" value="${rqt.benefitsWorkAccidentAnnuityRatio?.toString()}" 
                    class="required condition-isWorkAccidentAnnuity-filled  " title="<g:message code="hccr.property.benefitsWorkAccidentAnnuityRatio.validationError" />"  maxLength="3"/>
            

    
      <label class="required"><g:message code="hccr.property.benefitsSocialWelfare.label" /> *  <span><g:message code="hccr.property.benefitsSocialWelfare.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsSocialWelfare" ${it == rqt.benefitsSocialWelfare ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsUnemploymentBenefits.label" /> *  <span><g:message code="hccr.property.benefitsUnemploymentBenefits.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsUnemploymentBenefits" ${it == rqt.benefitsUnemploymentBenefits ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsDailyAllowances.label" /> *  <span><g:message code="hccr.property.benefitsDailyAllowances.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsDailyAllowances" ${it == rqt.benefitsDailyAllowances ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsThirdPartySupplement.label" /> *  <span><g:message code="hccr.property.benefitsThirdPartySupplement.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="benefitsThirdPartySupplement" ${it == rqt.benefitsThirdPartySupplement ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.benefitsSupportedByAnInstitution.label" /> *  <span><g:message code="hccr.property.benefitsSupportedByAnInstitution.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isSupportedByAnInstitution-trigger  validate-boolean" title="" value="${it}" name="benefitsSupportedByAnInstitution" ${it == rqt.benefitsSupportedByAnInstitution ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isSupportedByAnInstitution-filled"><g:message code="hccr.property.benefitsSupportedByAnInstitutionDetails.label" /> *  <span><g:message code="hccr.property.benefitsSupportedByAnInstitutionDetails.help" /></span></label>
            <input type="text" name="benefitsSupportedByAnInstitutionDetails" value="${rqt.benefitsSupportedByAnInstitutionDetails?.toString()}" 
                    class="required condition-isSupportedByAnInstitution-filled  " title="<g:message code="hccr.property.benefitsSupportedByAnInstitutionDetails.validationError" />"  maxLength="60"/>
            

    
      <label class="required"><g:message code="hccr.property.benefitsOtherBenefits.label" /> *  <span><g:message code="hccr.property.benefitsOtherBenefits.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isOtherBenefits-trigger  validate-boolean" title="" value="${it}" name="benefitsOtherBenefits" ${it == rqt.benefitsOtherBenefits ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="condition-isOtherBenefits-filled"><g:message code="hccr.property.otherBenefits.label" /> <span><g:message code="hccr.property.otherBenefits.help" /></span></label>
    <div class="collection-fieldset condition-isOtherBenefits-filled validation-scope">
      <g:set var="listIndex" value="${editList?.name == 'otherBenefits' ? editList?.index : ( rqt.otherBenefits ? rqt.otherBenefits.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add condition-isOtherBenefits-filled">
    
        <label class="required"><g:message code="hccr.property.otherBenefitName.label" /> *  <span><g:message code="hccr.property.otherBenefitName.help" /></span></label>
            <input type="text" name="otherBenefits[${listIndex}].otherBenefitName" value="${editList?.otherBenefits?.otherBenefitName?.toString()}" 
                    class="required  " title="<g:message code="hccr.property.otherBenefitName.validationError" />"  maxLength="60"/>
            

    
        <g:if test="${editList?.name == 'otherBenefits'}">
          <input type="submit" id="submit-collectionModify-benefits-otherBenefits[${listIndex}]" name="submit-collectionModify-benefits-otherBenefits[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-benefits-otherBenefits[${listIndex}]" name="submit-collectionAdd-benefits-otherBenefits[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.otherBenefits}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="hccr.property.otherBenefitName.label" /></dt>
        <dd>${it.otherBenefitName?.toString()}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-benefits-otherBenefits[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-benefits-otherBenefits[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

  
    <label class=""><g:message code="hccr.property.additionalFee.label" /> <span><g:message code="hccr.property.additionalFee.help" /></span></label>
    <div class="collection-fieldset  validation-scope">
      <g:set var="listIndex" value="${editList?.name == 'additionalFee' ? editList?.index : ( rqt.additionalFee ? rqt.additionalFee.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add ">
    
        <label class="required"><g:message code="hccr.property.additionalFeeKind.label" /> *  <span><g:message code="hccr.property.additionalFeeKind.help" /></span></label>
            <input type="text" name="additionalFee[${listIndex}].additionalFeeKind" value="${editList?.additionalFee?.additionalFeeKind?.toString()}" 
                    class="required  " title="<g:message code="hccr.property.additionalFeeKind.validationError" />"  maxLength="30"/>
            

    
        <label class="required"><g:message code="hccr.property.additionalFeeCost.label" /> *  <span><g:message code="hccr.property.additionalFeeCost.help" /></span></label>
            <input type="text" name="additionalFee[${listIndex}].additionalFeeCost" value="${editList?.additionalFee?.additionalFeeCost?.toString()}" 
                    class="required  " title="<g:message code="hccr.property.additionalFeeCost.validationError" />"  />
            

    
        <label class="required"><g:message code="hccr.property.additionalFeePeriodicity.label" /> *  <span><g:message code="hccr.property.additionalFeePeriodicity.help" /></span></label>
            <input type="text" name="additionalFee[${listIndex}].additionalFeePeriodicity" value="${editList?.additionalFee?.additionalFeePeriodicity?.toString()}" 
                    class="required  " title="<g:message code="hccr.property.additionalFeePeriodicity.validationError" />"  maxLength="30"/>
            

    
        <g:if test="${editList?.name == 'additionalFee'}">
          <input type="submit" id="submit-collectionModify-benefits-additionalFee[${listIndex}]" name="submit-collectionModify-benefits-additionalFee[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-benefits-additionalFee[${listIndex}]" name="submit-collectionAdd-benefits-additionalFee[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.additionalFee}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="hccr.property.additionalFeeKind.label" /></dt>
        <dd>${it.additionalFeeKind?.toString()}</dd>
    
        <dt><g:message code="hccr.property.additionalFeeCost.label" /></dt>
        <dd>${it.additionalFeeCost?.toString()}</dd>
    
        <dt><g:message code="hccr.property.additionalFeePeriodicity.label" /></dt>
        <dd>${it.additionalFeePeriodicity?.toString()}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-benefits-additionalFee[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-benefits-additionalFee[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

