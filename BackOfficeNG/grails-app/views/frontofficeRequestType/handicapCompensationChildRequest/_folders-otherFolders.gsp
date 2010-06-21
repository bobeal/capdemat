

  <h4>${message(code:'hccr.property.otherFolders.label')}<span>${message(code:'hccr.property.otherFolders.help')}</span></h4>
  <g:set var="currentCollectionItem" value="${rqt?.otherFolders.size() > collectionIndex ? rqt.otherFolders.get(collectionIndex) : null}" />
  
    <label for="otherFolders.${collectionIndex}.otherFolderName" class="required"><g:message code="hccr.property.otherFolderName.label" /> *  <span><g:message code="hccr.property.otherFolderName.help" /></span></label>
            <input type="text" id="otherFolders.${collectionIndex}.otherFolderName" name="otherFolders[${collectionIndex}].otherFolderName" value="${currentCollectionItem?.otherFolderName?.toString()}" 
                    class="required   ${rqt.stepStates['folders'].invalidFields.contains('otherFolders['+collectionIndex+'].otherFolderName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.otherFolderName.validationError" />"  maxlength="60" />
            

  
    <label for="otherFolders.${collectionIndex}.otherFolderNumber" class=""><g:message code="hccr.property.otherFolderNumber.label" />   <span><g:message code="hccr.property.otherFolderNumber.help" /></span></label>
            <input type="text" id="otherFolders.${collectionIndex}.otherFolderNumber" name="otherFolders[${collectionIndex}].otherFolderNumber" value="${currentCollectionItem?.otherFolderNumber?.toString()}" 
                    class="   ${rqt.stepStates['folders'].invalidFields.contains('otherFolders['+collectionIndex+'].otherFolderNumber') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.otherFolderNumber.validationError" />"  maxlength="30" />
            

  
    <label for="otherFolders.${collectionIndex}.otherFolderDepartment" class=""><g:message code="hccr.property.otherFolderDepartment.label" />   <span><g:message code="hccr.property.otherFolderDepartment.help" /></span></label>
            <input type="text" id="otherFolders.${collectionIndex}.otherFolderDepartment" name="otherFolders[${collectionIndex}].otherFolderDepartment" value="${currentCollectionItem?.otherFolderDepartment?.toString()}" 
                    class="  validate-departmentCode ${rqt.stepStates['folders'].invalidFields.contains('otherFolders['+collectionIndex+'].otherFolderDepartment') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.otherFolderDepartment.validationError" />"  maxlength="2" />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.save')}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'folders'])}">
    ${message(code:'request.action.cancelCollectionItemEdit')}
  </a>
  
