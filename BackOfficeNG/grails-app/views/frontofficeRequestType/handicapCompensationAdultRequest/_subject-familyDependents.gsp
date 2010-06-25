
  <g:set var="currentCollectionItem" value="${rqt?.familyDependents.size() > collectionIndex ? rqt.familyDependents.get(collectionIndex) : null}" />
  <h4>
    ${message(code:'hcar.property.familyDependents.label')}
    <span>
      <g:if test="${currentCollectionItem != null}">
        ${message(code:'request.message.editCollectionItem', args:[collectionIndex + 1])}
      </g:if>
      <g:else>
        ${message(code:'request.message.addCollectionItem')}
      </g:else>
    </span>
  </h4>
  
    <label for="familyDependents.${collectionIndex}.familyDependentLastName" class="required"><g:message code="hcar.property.familyDependentLastName.label" /> *  <span><g:message code="hcar.property.familyDependentLastName.help" /></span></label>
            <input type="text" id="familyDependents.${collectionIndex}.familyDependentLastName" name="familyDependents[${collectionIndex}].familyDependentLastName" value="${currentCollectionItem?.familyDependentLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].familyDependentLastName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.familyDependentLastName.validationError" />"  maxlength="38" />
            

  
    <label for="familyDependents.${collectionIndex}.familyDependentFirstName" class="required"><g:message code="hcar.property.familyDependentFirstName.label" /> *  <span><g:message code="hcar.property.familyDependentFirstName.help" /></span></label>
            <input type="text" id="familyDependents.${collectionIndex}.familyDependentFirstName" name="familyDependents[${collectionIndex}].familyDependentFirstName" value="${currentCollectionItem?.familyDependentFirstName?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].familyDependentFirstName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.familyDependentFirstName.validationError" />"  maxlength="38" />
            

  
    <label class="required"><g:message code="hcar.property.familyDependentBirthDate.label" /> *  <span><g:message code="hcar.property.familyDependentBirthDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].familyDependentBirthDate') ? 'validation-failed' : ''}"
                id="familyDependents.${collectionIndex}.familyDependentBirthDate_day"
                name="familyDependents[${collectionIndex}].familyDependentBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${currentCollectionItem?.familyDependentBirthDate?.date == it
                      || (currentCollectionItem?.familyDependentBirthDate == null && params['familyDependents[${collectionIndex}].familyDependentBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].familyDependentBirthDate') ? 'validation-failed' : ''}"
                id="familyDependents.${collectionIndex}.familyDependentBirthDate_month"
                name="familyDependents[${collectionIndex}].familyDependentBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${currentCollectionItem?.familyDependentBirthDate?.month == (it - 1)
                      || (currentCollectionItem?.familyDependentBirthDate == null && params['familyDependents[${collectionIndex}].familyDependentBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].familyDependentBirthDate') ? 'validation-failed' : ''}"
                id="familyDependents.${collectionIndex}.familyDependentBirthDate_year"
                name="familyDependents[${collectionIndex}].familyDependentBirthDate_year"
                value="${currentCollectionItem?.familyDependentBirthDate ? currentCollectionItem?.familyDependentBirthDate.year + 1900 : params['familyDependents[${collectionIndex}].familyDependentBirthDate_year']}"
                title="<g:message code="hcar.property.familyDependentBirthDate.validationError" />" />
            </div>
            

  
    <label for="familyDependents.${collectionIndex}.familyDependentActualSituation" class="required"><g:message code="hcar.property.familyDependentActualSituation.label" /> *  <span><g:message code="hcar.property.familyDependentActualSituation.help" /></span></label>
            <select id="familyDependents.${collectionIndex}.familyDependentActualSituation" name="familyDependents[${collectionIndex}].familyDependentActualSituation" class="required  validate-not-first ${rqt.stepStates['subject'].invalidFields.contains('familyDependents['+collectionIndex+'].familyDependentActualSituation') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.familyDependentActualSituation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Schooling','Learning','MedicoSocial']}">
                <option value="fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType_${it}" ${it == currentCollectionItem?.familyDependentActualSituation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.familyDependentActualSituation" /></option>
              </g:each>
            </select>
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.' + (currentCollectionItem != null ? 'save' : 'add'))}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'subject'])}">
    ${message(code:'request.action.backToMainForm')}
  </a>
  
