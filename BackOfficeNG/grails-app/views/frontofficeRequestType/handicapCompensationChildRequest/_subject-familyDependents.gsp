
  <g:set var="currentCollectionItem" value="${rqt?.familyDependents.size() > collectionIndex ? rqt.familyDependents.get(collectionIndex) : null}" />
  <h4>
    ${message(code:'hccr.property.familyDependents.label')}
    <span>
      <g:if test="${currentCollectionItem != null}">
        ${message(code:'request.message.editCollectionItem', args:[collectionIndex + 1])}
      </g:if>
      <g:else>
        ${message(code:'request.message.addCollectionItem')}
      </g:else>
    </span>
  </h4>
  
    <label for="familyDependents.${collectionIndex}.referentFamilyDependentLastName" class="required"><g:message code="hccr.property.referentFamilyDependentLastName.label" /> *  <span><g:message code="hccr.property.referentFamilyDependentLastName.help" /></span></label>
            <input type="text" id="familyDependents.${collectionIndex}.referentFamilyDependentLastName" name="familyDependents[${collectionIndex}].referentFamilyDependentLastName" value="${currentCollectionItem?.referentFamilyDependentLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].referentFamilyDependentLastName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.referentFamilyDependentLastName.validationError" />"  maxlength="38" />
            

  
    <label for="familyDependents.${collectionIndex}.referentFamilyDependentFirstName" class="required"><g:message code="hccr.property.referentFamilyDependentFirstName.label" /> *  <span><g:message code="hccr.property.referentFamilyDependentFirstName.help" /></span></label>
            <input type="text" id="familyDependents.${collectionIndex}.referentFamilyDependentFirstName" name="familyDependents[${collectionIndex}].referentFamilyDependentFirstName" value="${currentCollectionItem?.referentFamilyDependentFirstName?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].referentFamilyDependentFirstName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.referentFamilyDependentFirstName.validationError" />"  maxlength="38" />
            

  
    <label for="familyDependents.${collectionIndex}.referentFamilyDependentBirthDate" class="required"><g:message code="hccr.property.referentFamilyDependentBirthDate.label" /> *  <span><g:message code="hccr.property.referentFamilyDependentBirthDate.help" /></span></label>
            <input type="text" id="familyDependents.${collectionIndex}.referentFamilyDependentBirthDate" name="familyDependents[${collectionIndex}].referentFamilyDependentBirthDate" value="${formatDate(formatName:'format.date',date:currentCollectionItem?.referentFamilyDependentBirthDate)}" 
                   class="required  validate-date ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].referentFamilyDependentBirthDate') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.referentFamilyDependentBirthDate.validationError" />" />
            

  
    <label for="familyDependents.${collectionIndex}.referentFamilyDependentActualSituation" class="required"><g:message code="hccr.property.referentFamilyDependentActualSituation.label" /> *  <span><g:message code="hccr.property.referentFamilyDependentActualSituation.help" /></span></label>
            <select id="familyDependents.${collectionIndex}.referentFamilyDependentActualSituation" name="familyDependents[${collectionIndex}].referentFamilyDependentActualSituation" class="required  validate-not-first ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].referentFamilyDependentActualSituation') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.referentFamilyDependentActualSituation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Schooling','Learning','MedicoSocial']}">
                <option value="fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType_${it}" ${it == currentCollectionItem?.referentFamilyDependentActualSituation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.referentFamilyDependentActualSituation" /></option>
              </g:each>
            </select>
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.' + (currentCollectionItem != null ? 'save' : 'add'))}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'subject'])}">
    ${message(code:'request.action.backToMainForm')}
  </a>
  
