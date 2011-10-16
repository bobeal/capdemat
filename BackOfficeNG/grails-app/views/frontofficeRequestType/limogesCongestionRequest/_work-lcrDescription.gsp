
  <g:set var="currentCollectionItem" value="${rqt?.lcrDescription.size() > collectionIndex ? rqt.lcrDescription.get(collectionIndex) : null}" />
  <h4>
    ${message(code:'lcr.property.lcrDescription.label')}
    <span>
      <g:if test="${currentCollectionItem != null}">
        ${message(code:'request.message.editCollectionItem', args:[collectionIndex + 1])}
      </g:if>
      <g:else>
        ${message(code:'request.message.addCollectionItem')}
      </g:else>
    </span>
  </h4>
  
    <label for="lcrDescription.${collectionIndex}.lcrDetailDescription" class="required"><g:message code="lcr.property.lcrDetailDescription.label" /> *  <span><g:message code="lcr.property.lcrDetailDescription.help" /></span></label>
            <select id="lcrDescription.${collectionIndex}.lcrDetailDescription" name="lcrDescription[${collectionIndex}].lcrDetailDescription" class="required  validate-not-first ${rqt.stepStates['work'].invalidFields.contains('lcrDescription['+collectionIndex+'].lcrDetailDescription') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.lcrDetailDescription.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['SCAFFOLDING','SKIP','NACELLE','MATERIALSTORAGE','SITEHUT','PALISADES','OTHER']}">
                <option value="${it}" ${it == currentCollectionItem?.lcrDetailDescription?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="lcr.property.lcrDetailDescription" /></option>
              </g:each>
            </select>
            

  
    <label for="lcrDescription.${collectionIndex}.lcrDetailLength" class="required"><g:message code="lcr.property.lcrDetailLength.label" /> *  <span><g:message code="lcr.property.lcrDetailLength.help" /></span></label>
            <input type="text" id="lcrDescription.${collectionIndex}.lcrDetailLength" name="lcrDescription[${collectionIndex}].lcrDetailLength" value="${currentCollectionItem?.lcrDetailLength?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['work'].invalidFields.contains('lcrDescription['+collectionIndex+'].lcrDetailLength') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.lcrDetailLength.validationError" />"   />
            

  
    <label for="lcrDescription.${collectionIndex}.lcrDetailWidth" class="required"><g:message code="lcr.property.lcrDetailWidth.label" /> *  <span><g:message code="lcr.property.lcrDetailWidth.help" /></span></label>
            <input type="text" id="lcrDescription.${collectionIndex}.lcrDetailWidth" name="lcrDescription[${collectionIndex}].lcrDetailWidth" value="${currentCollectionItem?.lcrDetailWidth?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['work'].invalidFields.contains('lcrDescription['+collectionIndex+'].lcrDetailWidth') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.lcrDetailWidth.validationError" />"   />
            

  
    <label for="lcrDescription.${collectionIndex}.lcrDetailHeight" class=""><g:message code="lcr.property.lcrDetailHeight.label" />   <span><g:message code="lcr.property.lcrDetailHeight.help" /></span></label>
            <input type="text" id="lcrDescription.${collectionIndex}.lcrDetailHeight" name="lcrDescription[${collectionIndex}].lcrDetailHeight" value="${currentCollectionItem?.lcrDetailHeight?.toString()}" 
                    class="  validate-string ${rqt.stepStates['work'].invalidFields.contains('lcrDescription['+collectionIndex+'].lcrDetailHeight') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.lcrDetailHeight.validationError" />"   />
            

  
    <label for="lcrDescription.${collectionIndex}.lcrDetailOther" class=""><g:message code="lcr.property.lcrDetailOther.label" />   <span><g:message code="lcr.property.lcrDetailOther.help" /></span></label>
            <input type="text" id="lcrDescription.${collectionIndex}.lcrDetailOther" name="lcrDescription[${collectionIndex}].lcrDetailOther" value="${currentCollectionItem?.lcrDetailOther?.toString()}" 
                    class="  validate-string ${rqt.stepStates['work'].invalidFields.contains('lcrDescription['+collectionIndex+'].lcrDetailOther') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.lcrDetailOther.validationError" />"   />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.' + (currentCollectionItem != null ? 'save' : 'add'))}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'work'])}">
    ${message(code:'request.action.backToMainForm')}
  </a>
  
