

  <h4>${message(code:'hcar.property.otherBenefits.label')}<span>${message(code:'hcar.property.otherBenefits.help')}</span></h4>
  <g:set var="currentCollectionItem" value="${rqt?.otherBenefits.size() > collectionIndex ? rqt.otherBenefits.get(collectionIndex) : null}" />
  
    <label for="otherBenefits.${collectionIndex}.otherBenefitName" class="required"><g:message code="hcar.property.otherBenefitName.label" /> *  <span><g:message code="hcar.property.otherBenefitName.help" /></span></label>
            <input type="text" id="otherBenefits.${collectionIndex}.otherBenefitName" name="otherBenefits[${collectionIndex}].otherBenefitName" value="${currentCollectionItem?.otherBenefitName?.toString()}" 
                    class="required   ${rqt.stepStates['benefits'].invalidFields.contains('otherBenefits['+collectionIndex+'].otherBenefitName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.otherBenefitName.validationError" />"  maxlength="60" />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.save')}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'benefits'])}">
    ${message(code:'request.action.cancelCollectionItemEdit')}
  </a>
  
