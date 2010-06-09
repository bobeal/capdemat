

  <label class="condition-isOtherBenefits-filled"><g:message code="hcar.property.otherBenefits.label" /> <span><g:message code="hcar.property.otherBenefits.help" /></span></label>
  <div class="collection-fieldset condition-isOtherBenefits-filled validation-scope summary-box">
    <fieldset class="collection-fieldset-add condition-isOtherBenefits-filled">
    <g:set var="currentCollectionItem" value="${rqt?.otherBenefits.size() > collectionIndex ? rqt.otherBenefits.get(collectionIndex) : null}" />
  
      <label for="otherBenefits.${collectionIndex}.otherBenefitName" class="required"><g:message code="hcar.property.otherBenefitName.label" /> *  <span><g:message code="hcar.property.otherBenefitName.help" /></span></label>
            <input type="text" id="otherBenefits.${collectionIndex}.otherBenefitName" name="otherBenefits[${collectionIndex}].otherBenefitName" value="${currentCollectionItem?.otherBenefitName?.toString()}" 
                    class="required   ${rqt.stepStates['benefits'].invalidFields.contains('otherBenefits.otherBenefitName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.otherBenefitName.validationError" />"  maxlength="60" />
            

  
      <input type="submit" id="submit-step-benefits-otherBenefits" name="submit-step-benefits-otherBenefits[${collectionIndex}]" value="${message(code:'action.save')}" />
      <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'benefits'])}">
        ${message(code:'request.action.cancelCollectionItemEdit')}
      </a>  
    </fieldset>
</div>
  
