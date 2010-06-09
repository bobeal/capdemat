

  <label class="condition-isOtherFolders-filled"><g:message code="hcar.property.otherFolders.label" /> <span><g:message code="hcar.property.otherFolders.help" /></span></label>
  <div class="collection-fieldset condition-isOtherFolders-filled validation-scope summary-box">
    <fieldset class="collection-fieldset-add condition-isOtherFolders-filled">
    <g:set var="currentCollectionItem" value="${rqt?.otherFolders.size() > collectionIndex ? rqt.otherFolders.get(collectionIndex) : null}" />
  
      <label for="otherFolders.${collectionIndex}.otherFolderName" class="required"><g:message code="hcar.property.otherFolderName.label" /> *  <span><g:message code="hcar.property.otherFolderName.help" /></span></label>
            <input type="text" id="otherFolders.${collectionIndex}.otherFolderName" name="otherFolders[${collectionIndex}].otherFolderName" value="${currentCollectionItem?.otherFolderName?.toString()}" 
                    class="required   ${rqt.stepStates['folders'].invalidFields.contains('otherFolders.otherFolderName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.otherFolderName.validationError" />"  maxlength="60" />
            

  
      <label for="otherFolders.${collectionIndex}.otherFolderNumber" class=""><g:message code="hcar.property.otherFolderNumber.label" />   <span><g:message code="hcar.property.otherFolderNumber.help" /></span></label>
            <input type="text" id="otherFolders.${collectionIndex}.otherFolderNumber" name="otherFolders[${collectionIndex}].otherFolderNumber" value="${currentCollectionItem?.otherFolderNumber?.toString()}" 
                    class="   ${rqt.stepStates['folders'].invalidFields.contains('otherFolders.otherFolderNumber') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.otherFolderNumber.validationError" />"  maxlength="30" />
            

  
      <label for="otherFolders.${collectionIndex}.otherFolderDepartment" class=""><g:message code="hcar.property.otherFolderDepartment.label" />   <span><g:message code="hcar.property.otherFolderDepartment.help" /></span></label>
            <input type="text" id="otherFolders.${collectionIndex}.otherFolderDepartment" name="otherFolders[${collectionIndex}].otherFolderDepartment" value="${currentCollectionItem?.otherFolderDepartment?.toString()}" 
                    class="  validate-departmentCode ${rqt.stepStates['folders'].invalidFields.contains('otherFolders.otherFolderDepartment') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.otherFolderDepartment.validationError" />"  maxlength="2" />
            

  
      <input type="submit" id="submit-step-folders-otherFolders" name="submit-step-folders-otherFolders[${collectionIndex}]" value="${message(code:'action.save')}" />
      <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'folders'])}">
        ${message(code:'request.action.cancelCollectionItemEdit')}
      </a>  
    </fieldset>
</div>
  
