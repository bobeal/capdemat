
  <g:set var="currentCollectionItem" value="${rqt?.otherBenefits.size() > collectionIndex ? rqt.otherBenefits.get(collectionIndex) : null}" />
  <h4>
    ${message(code:'hccr.property.otherBenefits.label')}
    <span>
      <g:if test="${currentCollectionItem != null}">
        ${message(code:'request.message.editCollectionItem', args:[collectionIndex + 1])}
      </g:if>
      <g:else>
        ${message(code:'request.message.addCollectionItem')}
      </g:else>
    </span>
  </h4>
  
    <label for="otherBenefits.${collectionIndex}.otherBenefitName" class="required"><g:message code="hccr.property.otherBenefitName.label" /> *  <span><g:message code="hccr.property.otherBenefitName.help" /></span></label>
            <input type="text" id="otherBenefits.${collectionIndex}.otherBenefitName" name="otherBenefits[${collectionIndex}].otherBenefitName" value="${currentCollectionItem?.otherBenefitName?.toString()}" 
                    class="required   ${rqt.stepStates['benefits'].invalidFields.contains('otherBenefits['+collectionIndex+'].otherBenefitName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.otherBenefitName.validationError" />"  maxlength="60" />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.' + (currentCollectionItem != null ? 'save' : 'add'))}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'benefits'])}">
    ${message(code:'request.action.backToMainForm')}
  </a>
  
