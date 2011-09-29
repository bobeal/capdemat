
  <g:set var="currentCollectionItem" value="${rqt?.activiteAssociation.size() > collectionIndex ? rqt.activiteAssociation.get(collectionIndex) : null}" />
  <h4>
    ${message(code:'sagr.property.activiteAssociation.label')}
    <span>
      <g:if test="${currentCollectionItem != null}">
        ${message(code:'request.message.editCollectionItem', args:[collectionIndex + 1])}
      </g:if>
      <g:else>
        ${message(code:'request.message.addCollectionItem')}
      </g:else>
    </span>
  </h4>
  
    <label for="activiteAssociation.${collectionIndex}.nomActivite" class="required"><g:message code="sagr.property.nomActivite.label" /> *  <span><g:message code="sagr.property.nomActivite.help" /></span></label>
            <input type="text" id="activiteAssociation.${collectionIndex}.nomActivite" name="activiteAssociation[${collectionIndex}].nomActivite" value="${currentCollectionItem?.nomActivite?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].nomActivite') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nomActivite.validationError" />"   />
            

  
    <label for="activiteAssociation.${collectionIndex}.nomFederationSportiveActivite" class="required"><g:message code="sagr.property.nomFederationSportiveActivite.label" /> *  <span><g:message code="sagr.property.nomFederationSportiveActivite.help" /></span></label>
            <input type="text" id="activiteAssociation.${collectionIndex}.nomFederationSportiveActivite" name="activiteAssociation[${collectionIndex}].nomFederationSportiveActivite" value="${currentCollectionItem?.nomFederationSportiveActivite?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].nomFederationSportiveActivite') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nomFederationSportiveActivite.validationError" />"   />
            

  
    <label for="activiteAssociation.${collectionIndex}.numeroAffiliationActivite" class="required"><g:message code="sagr.property.numeroAffiliationActivite.label" /> *  <span><g:message code="sagr.property.numeroAffiliationActivite.help" /></span></label>
            <input type="text" id="activiteAssociation.${collectionIndex}.numeroAffiliationActivite" name="activiteAssociation[${collectionIndex}].numeroAffiliationActivite" value="${currentCollectionItem?.numeroAffiliationActivite?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].numeroAffiliationActivite') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.numeroAffiliationActivite.validationError" />"   />
            

  
    <label for="activiteAssociation.${collectionIndex}.nombreLicencieMineurActivite" class="required"><g:message code="sagr.property.nombreLicencieMineurActivite.label" /> *  <span><g:message code="sagr.property.nombreLicencieMineurActivite.help" /></span></label>
            <input type="text" id="activiteAssociation.${collectionIndex}.nombreLicencieMineurActivite" name="activiteAssociation[${collectionIndex}].nombreLicencieMineurActivite" value="${currentCollectionItem?.nombreLicencieMineurActivite?.toString()}" 
                    class="required  validate-long ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].nombreLicencieMineurActivite') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nombreLicencieMineurActivite.validationError" />"   />
            

  
    <label for="activiteAssociation.${collectionIndex}.nombreLicencieMajeurActivite" class="required"><g:message code="sagr.property.nombreLicencieMajeurActivite.label" /> *  <span><g:message code="sagr.property.nombreLicencieMajeurActivite.help" /></span></label>
            <input type="text" id="activiteAssociation.${collectionIndex}.nombreLicencieMajeurActivite" name="activiteAssociation[${collectionIndex}].nombreLicencieMajeurActivite" value="${currentCollectionItem?.nombreLicencieMajeurActivite?.toString()}" 
                    class="required  validate-long ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].nombreLicencieMajeurActivite') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nombreLicencieMajeurActivite.validationError" />"   />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.' + (currentCollectionItem != null ? 'save' : 'add'))}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'activites'])}">
    ${message(code:'request.action.backToMainForm')}
  </a>
  
