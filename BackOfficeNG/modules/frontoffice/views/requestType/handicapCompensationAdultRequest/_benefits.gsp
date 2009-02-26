




  
    <fieldset class="required">
    <legend><g:message code="hcar.property.benefits.label" /></legend> 
      
    
      <label class="required"><g:message code="hcar.property.benefitsDisabilityRecognition.label" /> <span><g:message code="hcar.property.benefitsDisabilityRecognition.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isDisabilityRecognition-trigger validate-boolean" title="" value="${it}" name="benefitsDisabilityRecognition" ${it == rqt.benefitsDisabilityRecognition ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-isDisabilityRecognition-filled"><g:message code="hcar.property.benefitsDisabilityRatio.label" /> <span><g:message code="hcar.property.benefitsDisabilityRatio.help" /></span></label>
      
            <input type="text" name="benefitsDisabilityRatio" value="${rqt.benefitsDisabilityRatio}" 
                    class="required condition-isDisabilityRecognition-filled " title="<g:message code="hcar.property.benefitsDisabilityRatio.validationError" />">
            
    
      <label class="required"><g:message code="hcar.property.benefitsDisabilityCard.label" /> <span><g:message code="hcar.property.benefitsDisabilityCard.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsDisabilityCard" ${it == rqt.benefitsDisabilityCard ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsPainfulStandingCard.label" /> <span><g:message code="hcar.property.benefitsPainfulStandingCard.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsPainfulStandingCard" ${it == rqt.benefitsPainfulStandingCard ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsParkingCard.label" /> <span><g:message code="hcar.property.benefitsParkingCard.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsParkingCard" ${it == rqt.benefitsParkingCard ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsDisabledWorkerRecognition.label" /> <span><g:message code="hcar.property.benefitsDisabledWorkerRecognition.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsDisabledWorkerRecognition" ${it == rqt.benefitsDisabledWorkerRecognition ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsProfessionalOrientation.label" /> <span><g:message code="hcar.property.benefitsProfessionalOrientation.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isProfessionalOrientation-trigger validate-boolean" title="" value="${it}" name="benefitsProfessionalOrientation" ${it == rqt.benefitsProfessionalOrientation ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-isProfessionalOrientation-filled"><g:message code="hcar.property.benefitsProfessionalOrientationDetails.label" /> <span><g:message code="hcar.property.benefitsProfessionalOrientationDetails.help" /></span></label>
      
            <input type="text" name="benefitsProfessionalOrientationDetails" value="${rqt.benefitsProfessionalOrientationDetails}" 
                    class="required condition-isProfessionalOrientation-filled " title="<g:message code="hcar.property.benefitsProfessionalOrientationDetails.validationError" />">
            
    
      <label class="required"><g:message code="hcar.property.benefitsDisabledAdultAllocation.label" /> <span><g:message code="hcar.property.benefitsDisabledAdultAllocation.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsDisabledAdultAllocation" ${it == rqt.benefitsDisabledAdultAllocation ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsIncreaseForIndependentLiving.label" /> <span><g:message code="hcar.property.benefitsIncreaseForIndependentLiving.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsIncreaseForIndependentLiving" ${it == rqt.benefitsIncreaseForIndependentLiving ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsEducationAllocationOfDisabledChildren.label" /> <span><g:message code="hcar.property.benefitsEducationAllocationOfDisabledChildren.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsEducationAllocationOfDisabledChildren" ${it == rqt.benefitsEducationAllocationOfDisabledChildren ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsEducationOfDisabledChildren.label" /> <span><g:message code="hcar.property.benefitsEducationOfDisabledChildren.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isEducationOfDisabledChildren-trigger validate-boolean" title="" value="${it}" name="benefitsEducationOfDisabledChildren" ${it == rqt.benefitsEducationOfDisabledChildren ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-isEducationOfDisabledChildren-filled"><g:message code="hcar.property.benefitsEducationOfDisabledChildrenDetails.label" /> <span><g:message code="hcar.property.benefitsEducationOfDisabledChildrenDetails.help" /></span></label>
      
            <input type="text" name="benefitsEducationOfDisabledChildrenDetails" value="${rqt.benefitsEducationOfDisabledChildrenDetails}" 
                    class="required condition-isEducationOfDisabledChildren-filled " title="<g:message code="hcar.property.benefitsEducationOfDisabledChildrenDetails.validationError" />">
            
    
      <label class="required"><g:message code="hcar.property.benefitsSupplementForSingleParents.label" /> <span><g:message code="hcar.property.benefitsSupplementForSingleParents.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsSupplementForSingleParents" ${it == rqt.benefitsSupplementForSingleParents ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsThirdPersonCompensatoryAllowance.label" /> <span><g:message code="hcar.property.benefitsThirdPersonCompensatoryAllowance.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsThirdPersonCompensatoryAllowance" ${it == rqt.benefitsThirdPersonCompensatoryAllowance ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsThirdPartyCompensatoryAllowance.label" /> <span><g:message code="hcar.property.benefitsThirdPartyCompensatoryAllowance.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsThirdPartyCompensatoryAllowance" ${it == rqt.benefitsThirdPartyCompensatoryAllowance ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsCompensatoryAllowanceForExpenses.label" /> <span><g:message code="hcar.property.benefitsCompensatoryAllowanceForExpenses.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsCompensatoryAllowanceForExpenses" ${it == rqt.benefitsCompensatoryAllowanceForExpenses ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsDisabilityCompensation.label" /> <span><g:message code="hcar.property.benefitsDisabilityCompensation.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsDisabilityCompensation" ${it == rqt.benefitsDisabilityCompensation ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsDisabilityPension.label" /> <span><g:message code="hcar.property.benefitsDisabilityPension.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isDisabilityPension-trigger validate-boolean" title="" value="${it}" name="benefitsDisabilityPension" ${it == rqt.benefitsDisabilityPension ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-isDisabilityPension-filled"><g:message code="hcar.property.benefitsDisabilityPensionCategory.label" /> <span><g:message code="hcar.property.benefitsDisabilityPensionCategory.help" /></span></label>
      
            <input type="text" name="benefitsDisabilityPensionCategory" value="${rqt.benefitsDisabilityPensionCategory}" 
                    class="required condition-isDisabilityPension-filled " title="<g:message code="hcar.property.benefitsDisabilityPensionCategory.validationError" />">
            
    
      <label class="required"><g:message code="hcar.property.benefitsWorkAccidentAnnuity.label" /> <span><g:message code="hcar.property.benefitsWorkAccidentAnnuity.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isWorkAccidentAnnuity-trigger validate-boolean" title="" value="${it}" name="benefitsWorkAccidentAnnuity" ${it == rqt.benefitsWorkAccidentAnnuity ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-isWorkAccidentAnnuity-filled"><g:message code="hcar.property.benefitsWorkAccidentAnnuityRatio.label" /> <span><g:message code="hcar.property.benefitsWorkAccidentAnnuityRatio.help" /></span></label>
      
            <input type="text" name="benefitsWorkAccidentAnnuityRatio" value="${rqt.benefitsWorkAccidentAnnuityRatio}" 
                    class="required condition-isWorkAccidentAnnuity-filled " title="<g:message code="hcar.property.benefitsWorkAccidentAnnuityRatio.validationError" />">
            
    
      <label class="required"><g:message code="hcar.property.benefitsSocialWelfare.label" /> <span><g:message code="hcar.property.benefitsSocialWelfare.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsSocialWelfare" ${it == rqt.benefitsSocialWelfare ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsUnemploymentBenefits.label" /> <span><g:message code="hcar.property.benefitsUnemploymentBenefits.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsUnemploymentBenefits" ${it == rqt.benefitsUnemploymentBenefits ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsDailyAllowances.label" /> <span><g:message code="hcar.property.benefitsDailyAllowances.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsDailyAllowances" ${it == rqt.benefitsDailyAllowances ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsThirdPartySupplement.label" /> <span><g:message code="hcar.property.benefitsThirdPartySupplement.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="benefitsThirdPartySupplement" ${it == rqt.benefitsThirdPartySupplement ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="hcar.property.benefitsSupportedByAnInstitution.label" /> <span><g:message code="hcar.property.benefitsSupportedByAnInstitution.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isSupportedByAnInstitution-trigger validate-boolean" title="" value="${it}" name="benefitsSupportedByAnInstitution" ${it == rqt.benefitsSupportedByAnInstitution ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-isSupportedByAnInstitution-filled"><g:message code="hcar.property.benefitsSupportedByAnInstitutionDetails.label" /> <span><g:message code="hcar.property.benefitsSupportedByAnInstitutionDetails.help" /></span></label>
      
            <input type="text" name="benefitsSupportedByAnInstitutionDetails" value="${rqt.benefitsSupportedByAnInstitutionDetails}" 
                    class="required condition-isSupportedByAnInstitution-filled " title="<g:message code="hcar.property.benefitsSupportedByAnInstitutionDetails.validationError" />">
            
    
      <label class="required"><g:message code="hcar.property.benefitsOtherBenefits.label" /> <span><g:message code="hcar.property.benefitsOtherBenefits.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isOtherBenefits-trigger validate-boolean" title="" value="${it}" name="benefitsOtherBenefits" ${it == rqt.benefitsOtherBenefits ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
    </fieldset>
  

  
    <label class="condition-isOtherBenefits-filled"><g:message code="hcar.property.otherBenefits.label" /> <span><g:message code="hcar.property.otherBenefits.help" /></span></label>
    <div class="collection-fieldset condition-isOtherBenefits-filled validation-scope">
      <!--<h4><g:message code="hcar.property.otherBenefits.label" /></h4>-->
      <g:set var="listIndex" value="${editList?.name == 'otherBenefits' ? editList?.index : ( rqt.otherBenefits ? rqt.otherBenefits.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add condition-isOtherBenefits-filled">
    
        <label class="required"><g:message code="hcar.property.otherBenefitName.label" /> <span><g:message code="hcar.property.otherBenefitName.help" /></span></label>
        
            <input type="text" name="otherBenefits[${listIndex}].otherBenefitName" value="${editList?.otherBenefits?.otherBenefitName}" 
                    class="required " title="<g:message code="hcar.property.otherBenefitName.validationError" />">
            
    
        <g:if test="${editList?.name == 'otherBenefits'}">
          <input type="submit" id="submit-collectionModify-benefits-otherBenefits[${listIndex}]" name="submit-collectionModify-benefits-otherBenefits[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-benefits-otherBenefits[${listIndex}]" name="submit-collectionAdd-benefits-otherBenefits[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.otherBenefits}" status="index">
      <fieldset class="collection-fieldset-edit">
        <!-- <legend><g:message code="hcar.property.otherBenefits.label" /></legend> -->
        <dl>
    
        <dt><g:message code="hcar.property.otherBenefitName.label" /></dt>
        <dd>${it.otherBenefitName}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-benefits-otherBenefits[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-benefits-otherBenefits[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

  
    <label class=""><g:message code="hcar.property.additionalFee.label" /> <span><g:message code="hcar.property.additionalFee.help" /></span></label>
    <div class="collection-fieldset  validation-scope">
      <!--<h4><g:message code="hcar.property.additionalFee.label" /></h4>-->
      <g:set var="listIndex" value="${editList?.name == 'additionalFee' ? editList?.index : ( rqt.additionalFee ? rqt.additionalFee.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add ">
    
        <label class="required"><g:message code="hcar.property.additionalFeeKind.label" /> <span><g:message code="hcar.property.additionalFeeKind.help" /></span></label>
        
            <input type="text" name="additionalFee[${listIndex}].additionalFeeKind" value="${editList?.additionalFee?.additionalFeeKind}" 
                    class="required " title="<g:message code="hcar.property.additionalFeeKind.validationError" />">
            
    
        <label class="required"><g:message code="hcar.property.additionalFeeCost.label" /> <span><g:message code="hcar.property.additionalFeeCost.help" /></span></label>
        
            <input type="text" name="additionalFee[${listIndex}].additionalFeeCost" value="${editList?.additionalFee?.additionalFeeCost}" 
                    class="required " title="<g:message code="hcar.property.additionalFeeCost.validationError" />">
            
    
        <label class="required"><g:message code="hcar.property.additionalFeePeriodicity.label" /> <span><g:message code="hcar.property.additionalFeePeriodicity.help" /></span></label>
        
            <input type="text" name="additionalFee[${listIndex}].additionalFeePeriodicity" value="${editList?.additionalFee?.additionalFeePeriodicity}" 
                    class="required " title="<g:message code="hcar.property.additionalFeePeriodicity.validationError" />">
            
    
        <g:if test="${editList?.name == 'additionalFee'}">
          <input type="submit" id="submit-collectionModify-benefits-additionalFee[${listIndex}]" name="submit-collectionModify-benefits-additionalFee[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-benefits-additionalFee[${listIndex}]" name="submit-collectionAdd-benefits-additionalFee[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.additionalFee}" status="index">
      <fieldset class="collection-fieldset-edit">
        <!-- <legend><g:message code="hcar.property.additionalFee.label" /></legend> -->
        <dl>
    
        <dt><g:message code="hcar.property.additionalFeeKind.label" /></dt>
        <dd>${it.additionalFeeKind}</dd>
    
        <dt><g:message code="hcar.property.additionalFeeCost.label" /></dt>
        <dd>${it.additionalFeeCost}</dd>
    
        <dt><g:message code="hcar.property.additionalFeePeriodicity.label" /></dt>
        <dd>${it.additionalFeePeriodicity}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-benefits-additionalFee[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-benefits-additionalFee[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

