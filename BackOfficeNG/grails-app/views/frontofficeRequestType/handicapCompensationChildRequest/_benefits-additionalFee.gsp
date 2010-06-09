

  <label class=""><g:message code="hccr.property.additionalFee.label" /> <span><g:message code="hccr.property.additionalFee.help" /></span></label>
  <div class="collection-fieldset  validation-scope summary-box">
    <fieldset class="collection-fieldset-add ">
    <g:set var="currentCollectionItem" value="${rqt?.additionalFee.size() > collectionIndex ? rqt.additionalFee.get(collectionIndex) : null}" />
  
      <label for="additionalFee.${collectionIndex}.additionalFeeKind" class="required"><g:message code="hccr.property.additionalFeeKind.label" /> *  <span><g:message code="hccr.property.additionalFeeKind.help" /></span></label>
            <input type="text" id="additionalFee.${collectionIndex}.additionalFeeKind" name="additionalFee[${collectionIndex}].additionalFeeKind" value="${currentCollectionItem?.additionalFeeKind?.toString()}" 
                    class="required   ${rqt.stepStates['benefits'].invalidFields.contains('additionalFee.additionalFeeKind') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.additionalFeeKind.validationError" />"  maxlength="30" />
            

  
      <label for="additionalFee.${collectionIndex}.additionalFeeCost" class="required"><g:message code="hccr.property.additionalFeeCost.label" /> *  <span><g:message code="hccr.property.additionalFeeCost.help" /></span></label>
            <input type="text" id="additionalFee.${collectionIndex}.additionalFeeCost" name="additionalFee[${collectionIndex}].additionalFeeCost" value="${currentCollectionItem?.additionalFeeCost?.toString()}" 
                    class="required   ${rqt.stepStates['benefits'].invalidFields.contains('additionalFee.additionalFeeCost') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.additionalFeeCost.validationError" />"   />
            

  
      <label for="additionalFee.${collectionIndex}.additionalFeePeriodicity" class="required"><g:message code="hccr.property.additionalFeePeriodicity.label" /> *  <span><g:message code="hccr.property.additionalFeePeriodicity.help" /></span></label>
            <input type="text" id="additionalFee.${collectionIndex}.additionalFeePeriodicity" name="additionalFee[${collectionIndex}].additionalFeePeriodicity" value="${currentCollectionItem?.additionalFeePeriodicity?.toString()}" 
                    class="required   ${rqt.stepStates['benefits'].invalidFields.contains('additionalFee.additionalFeePeriodicity') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.additionalFeePeriodicity.validationError" />"  maxlength="30" />
            

  
      <input type="hidden" name="currentCollection" value="${currentCollection}" />
      <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
      <input type="submit" id="submit-step-benefits-additionalFee" name="submit-step-benefits-additionalFee[${collectionIndex}]" value="${message(code:'action.save')}" />
      <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'benefits'])}">
        ${message(code:'request.action.cancelCollectionItemEdit')}
      </a>  
    </fieldset>
</div>
  
