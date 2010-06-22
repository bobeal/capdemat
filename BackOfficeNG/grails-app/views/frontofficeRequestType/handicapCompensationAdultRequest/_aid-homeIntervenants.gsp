
  <g:set var="currentCollectionItem" value="${rqt?.homeIntervenants.size() > collectionIndex ? rqt.homeIntervenants.get(collectionIndex) : null}" />
  <h4>
    ${message(code:'hcar.property.homeIntervenants.label')}
    <span>
      <g:if test="${currentCollectionItem != null}">
        ${message(code:'request.message.editCollectionItem', args:[collectionIndex + 1])}
      </g:if>
      <g:else>
        ${message(code:'request.message.addCollectionItem')}
      </g:else>
    </span>
  </h4>
  
    <label for="homeIntervenants.${collectionIndex}.homeIntervenantKind" class="required"><g:message code="hcar.property.homeIntervenantKind.label" /> *  <span><g:message code="hcar.property.homeIntervenantKind.help" /></span></label>
            <select id="homeIntervenants.${collectionIndex}.homeIntervenantKind" name="homeIntervenants[${collectionIndex}].homeIntervenantKind" class="required condition-isOtherHomeIntervant-trigger  validate-not-first ${rqt.stepStates['aid'].invalidFields.contains('homeIntervenants['+collectionIndex+'].homeIntervenantKind') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.homeIntervenantKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Carer','HomeHelp','Other']}">
                <option value="fr.cg95.cvq.business.request.social.HcarHomeIntervenantKindType_${it}" ${it == currentCollectionItem?.homeIntervenantKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.homeIntervenantKind" /></option>
              </g:each>
            </select>
            

  
    <label for="homeIntervenants.${collectionIndex}.homeIntervenantDetails" class="required condition-isOtherHomeIntervant-filled"><g:message code="hcar.property.homeIntervenantDetails.label" /> *  <span><g:message code="hcar.property.homeIntervenantDetails.help" /></span></label>
            <input type="text" id="homeIntervenants.${collectionIndex}.homeIntervenantDetails" name="homeIntervenants[${collectionIndex}].homeIntervenantDetails" value="${currentCollectionItem?.homeIntervenantDetails?.toString()}" 
                    class="required condition-isOtherHomeIntervant-filled   ${rqt.stepStates['aid'].invalidFields.contains('homeIntervenants['+collectionIndex+'].homeIntervenantDetails') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.homeIntervenantDetails.validationError" />"  maxlength="60" />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.' + (currentCollectionItem != null ? 'save' : 'add'))}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'aid'])}">
    ${message(code:'request.action.backToMainForm')}
  </a>
  
