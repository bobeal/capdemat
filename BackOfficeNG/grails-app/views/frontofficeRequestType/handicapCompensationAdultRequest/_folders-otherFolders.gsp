
  <g:set var="currentCollectionItem" value="${rqt?.otherFolders.size() > collectionIndex ? rqt.otherFolders.get(collectionIndex) : null}" />
  <h4>
    ${message(code:'hcar.property.otherFolders.label')}
    <span>
      <g:if test="${currentCollectionItem != null}">
        ${message(code:'request.message.editCollectionItem', args:[collectionIndex + 1])}
      </g:if>
      <g:else>
        ${message(code:'request.message.addCollectionItem')}
      </g:else>
    </span>
  </h4>
  
    <label for="otherFolders.${collectionIndex}.otherFolderName" class="required"><g:message code="hcar.property.otherFolderName.label" /> *  <span><g:message code="hcar.property.otherFolderName.help" /></span></label>
            <input type="text" id="otherFolders.${collectionIndex}.otherFolderName" name="otherFolders[${collectionIndex}].otherFolderName" value="${currentCollectionItem?.otherFolderName?.toString()}" 
                    class="required   ${rqt.stepStates['folders'].invalidFields.contains('otherFolders['+collectionIndex+'].otherFolderName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.otherFolderName.validationError" />"  maxlength="60" />
            

  
    <label for="otherFolders.${collectionIndex}.otherFolderNumber" class=""><g:message code="hcar.property.otherFolderNumber.label" />   <span><g:message code="hcar.property.otherFolderNumber.help" /></span></label>
            <input type="text" id="otherFolders.${collectionIndex}.otherFolderNumber" name="otherFolders[${collectionIndex}].otherFolderNumber" value="${currentCollectionItem?.otherFolderNumber?.toString()}" 
                    class="   ${rqt.stepStates['folders'].invalidFields.contains('otherFolders['+collectionIndex+'].otherFolderNumber') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.otherFolderNumber.validationError" />"  maxlength="30" />
            

  
    <label for="otherFolders.${collectionIndex}.otherFolderDepartment" class=""><g:message code="hcar.property.otherFolderDepartment.label" />   <span><g:message code="hcar.property.otherFolderDepartment.help" /></span></label>
            <input type="text" id="otherFolders.${collectionIndex}.otherFolderDepartment" name="otherFolders[${collectionIndex}].otherFolderDepartment" value="${currentCollectionItem?.otherFolderDepartment?.toString()}" 
                    class="  validate-departmentCode ${rqt.stepStates['folders'].invalidFields.contains('otherFolders['+collectionIndex+'].otherFolderDepartment') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.otherFolderDepartment.validationError" />"  maxlength="2" />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.' + (currentCollectionItem != null ? 'save' : 'add'))}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'folders'])}">
    ${message(code:'request.action.backToMainForm')}
  </a>
  
