

  <h4>${message(code:'hcar.property.familyDependents.label')}<span>${message(code:'hcar.property.familyDependents.help')}</span></h4>
  <g:set var="currentCollectionItem" value="${rqt?.familyDependents.size() > collectionIndex ? rqt.familyDependents.get(collectionIndex) : null}" />
  
    <label for="familyDependents.${collectionIndex}.familyDependentLastName" class="required"><g:message code="hcar.property.familyDependentLastName.label" /> *  <span><g:message code="hcar.property.familyDependentLastName.help" /></span></label>
            <input type="text" id="familyDependents.${collectionIndex}.familyDependentLastName" name="familyDependents[${collectionIndex}].familyDependentLastName" value="${currentCollectionItem?.familyDependentLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].familyDependentLastName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.familyDependentLastName.validationError" />"  maxlength="38" />
            

  
    <label for="familyDependents.${collectionIndex}.familyDependentFirstName" class="required"><g:message code="hcar.property.familyDependentFirstName.label" /> *  <span><g:message code="hcar.property.familyDependentFirstName.help" /></span></label>
            <input type="text" id="familyDependents.${collectionIndex}.familyDependentFirstName" name="familyDependents[${collectionIndex}].familyDependentFirstName" value="${currentCollectionItem?.familyDependentFirstName?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].familyDependentFirstName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.familyDependentFirstName.validationError" />"  maxlength="38" />
            

  
    <label for="familyDependents.${collectionIndex}.familyDependentBirthDate" class="required"><g:message code="hcar.property.familyDependentBirthDate.label" /> *  <span><g:message code="hcar.property.familyDependentBirthDate.help" /></span></label>
            <input type="text" id="familyDependents.${collectionIndex}.familyDependentBirthDate" name="familyDependents[${collectionIndex}].familyDependentBirthDate" value="${formatDate(formatName:'format.date',date:currentCollectionItem?.familyDependentBirthDate)}" 
                   class="required  validate-date ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].familyDependentBirthDate') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.familyDependentBirthDate.validationError" />" />
            

  
    <label for="familyDependents.${collectionIndex}.familyDependentActualSituation" class="required"><g:message code="hcar.property.familyDependentActualSituation.label" /> *  <span><g:message code="hcar.property.familyDependentActualSituation.help" /></span></label>
            <select id="familyDependents.${collectionIndex}.familyDependentActualSituation" name="familyDependents[${collectionIndex}].familyDependentActualSituation" class="required  validate-not-first ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].familyDependentActualSituation') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.familyDependentActualSituation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Schooling','Learning','MedicoSocial']}">
                <option value="fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType_${it}" ${it == currentCollectionItem?.familyDependentActualSituation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.familyDependentActualSituation" /></option>
              </g:each>
            </select>
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.save')}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'subject'])}">
    ${message(code:'request.action.cancelCollectionItemEdit')}
  </a>
  
