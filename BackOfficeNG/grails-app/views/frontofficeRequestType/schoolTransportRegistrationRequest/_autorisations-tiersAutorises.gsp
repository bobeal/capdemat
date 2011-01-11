
  <g:set var="currentCollectionItem" value="${rqt?.tiersAutorises.size() > collectionIndex ? rqt.tiersAutorises.get(collectionIndex) : null}" />
  <h4>
    ${message(code:'strr.property.tiersAutorises.label')}
    <span>
      <g:if test="${currentCollectionItem != null}">
        ${message(code:'request.message.editCollectionItem', args:[collectionIndex + 1])}
      </g:if>
      <g:else>
        ${message(code:'request.message.addCollectionItem')}
      </g:else>
    </span>
  </h4>
  
    <label for="tiersAutorises.${collectionIndex}.tiersNom" class="required"><g:message code="strr.property.tiersNom.label" /> *  <span><g:message code="strr.property.tiersNom.help" /></span></label>
            <input type="text" id="tiersAutorises.${collectionIndex}.tiersNom" name="tiersAutorises[${collectionIndex}].tiersNom" value="${currentCollectionItem?.tiersNom?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['autorisations'].invalidFields.contains('tiersAutorises['+collectionIndex+'].tiersNom') ? 'validation-failed' : ''}" title="<g:message code="strr.property.tiersNom.validationError" />"  maxlength="38" />
            

  
    <label for="tiersAutorises.${collectionIndex}.tiersPrenom" class="required"><g:message code="strr.property.tiersPrenom.label" /> *  <span><g:message code="strr.property.tiersPrenom.help" /></span></label>
            <input type="text" id="tiersAutorises.${collectionIndex}.tiersPrenom" name="tiersAutorises[${collectionIndex}].tiersPrenom" value="${currentCollectionItem?.tiersPrenom?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['autorisations'].invalidFields.contains('tiersAutorises['+collectionIndex+'].tiersPrenom') ? 'validation-failed' : ''}" title="<g:message code="strr.property.tiersPrenom.validationError" />"  maxlength="38" />
            

  
    <label for="tiersAutorises.${collectionIndex}.tiersTelephone" class="required"><g:message code="strr.property.tiersTelephone.label" /> *  <span><g:message code="strr.property.tiersTelephone.help" /></span></label>
            <input type="text" id="tiersAutorises.${collectionIndex}.tiersTelephone" name="tiersAutorises[${collectionIndex}].tiersTelephone" value="${currentCollectionItem?.tiersTelephone?.toString()}" 
                    class="required  validate-phone ${rqt.stepStates['autorisations'].invalidFields.contains('tiersAutorises['+collectionIndex+'].tiersTelephone') ? 'validation-failed' : ''}" title="<g:message code="strr.property.tiersTelephone.validationError" />"  maxlength="10" />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.' + (currentCollectionItem != null ? 'save' : 'add'))}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'autorisations'])}">
    ${message(code:'request.action.backToMainForm')}
  </a>
  
