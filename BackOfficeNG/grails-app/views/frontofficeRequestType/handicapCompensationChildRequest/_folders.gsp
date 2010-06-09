


  
    <fieldset class="required">
    <legend><g:message code="hccr.property.folders.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.foldersMdph.label" /> *  <span><g:message code="hccr.property.foldersMdph.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['folders'].invalidFields.contains('foldersMdph') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersMdph_${it ? 'yes' : 'no'}" class="required condition-isMDPH-trigger  validate-one-required boolean" title="" value="${it}" name="foldersMdph" ${it == rqt.foldersMdph ? 'checked="checked"': ''} />
                <label for="foldersMdph_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="foldersMdphNumber" class="condition-isMDPH-filled"><g:message code="hccr.property.foldersMdphNumber.label" />   <span><g:message code="hccr.property.foldersMdphNumber.help" /></span></label>
            <input type="text" id="foldersMdphNumber" name="foldersMdphNumber" value="${rqt.foldersMdphNumber?.toString()}" 
                    class="condition-isMDPH-filled   ${rqt.stepStates['folders'].invalidFields.contains('foldersMdphNumber') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersMdphNumber.validationError" />"  maxlength="30" />
            

    
      <label for="foldersMdphDepartment" class="condition-isMDPH-filled"><g:message code="hccr.property.foldersMdphDepartment.label" />   <span><g:message code="hccr.property.foldersMdphDepartment.help" /></span></label>
            <input type="text" id="foldersMdphDepartment" name="foldersMdphDepartment" value="${rqt.foldersMdphDepartment?.toString()}" 
                    class="condition-isMDPH-filled  validate-departmentCode ${rqt.stepStates['folders'].invalidFields.contains('foldersMdphDepartment') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersMdphDepartment.validationError" />"  maxlength="2" />
            

    
      <label class="required"><g:message code="hccr.property.foldersCotorep.label" /> *  <span><g:message code="hccr.property.foldersCotorep.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['folders'].invalidFields.contains('foldersCotorep') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersCotorep_${it ? 'yes' : 'no'}" class="required condition-isCOTOREP-trigger  validate-one-required boolean" title="" value="${it}" name="foldersCotorep" ${it == rqt.foldersCotorep ? 'checked="checked"': ''} />
                <label for="foldersCotorep_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="foldersCotorepNumber" class="condition-isCOTOREP-filled"><g:message code="hccr.property.foldersCotorepNumber.label" />   <span><g:message code="hccr.property.foldersCotorepNumber.help" /></span></label>
            <input type="text" id="foldersCotorepNumber" name="foldersCotorepNumber" value="${rqt.foldersCotorepNumber?.toString()}" 
                    class="condition-isCOTOREP-filled   ${rqt.stepStates['folders'].invalidFields.contains('foldersCotorepNumber') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersCotorepNumber.validationError" />"  maxlength="30" />
            

    
      <label for="foldersCotorepDepartment" class="condition-isCOTOREP-filled"><g:message code="hccr.property.foldersCotorepDepartment.label" />   <span><g:message code="hccr.property.foldersCotorepDepartment.help" /></span></label>
            <input type="text" id="foldersCotorepDepartment" name="foldersCotorepDepartment" value="${rqt.foldersCotorepDepartment?.toString()}" 
                    class="condition-isCOTOREP-filled  validate-departmentCode ${rqt.stepStates['folders'].invalidFields.contains('foldersCotorepDepartment') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersCotorepDepartment.validationError" />"  maxlength="2" />
            

    
      <label class="required"><g:message code="hccr.property.foldersCdes.label" /> *  <span><g:message code="hccr.property.foldersCdes.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['folders'].invalidFields.contains('foldersCdes') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersCdes_${it ? 'yes' : 'no'}" class="required condition-isCDES-trigger  validate-one-required boolean" title="" value="${it}" name="foldersCdes" ${it == rqt.foldersCdes ? 'checked="checked"': ''} />
                <label for="foldersCdes_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="foldersCdesNumber" class="condition-isCDES-filled"><g:message code="hccr.property.foldersCdesNumber.label" />   <span><g:message code="hccr.property.foldersCdesNumber.help" /></span></label>
            <input type="text" id="foldersCdesNumber" name="foldersCdesNumber" value="${rqt.foldersCdesNumber?.toString()}" 
                    class="condition-isCDES-filled   ${rqt.stepStates['folders'].invalidFields.contains('foldersCdesNumber') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersCdesNumber.validationError" />"  maxlength="30" />
            

    
      <label for="foldersCdesDepartment" class="condition-isCDES-filled"><g:message code="hccr.property.foldersCdesDepartment.label" />   <span><g:message code="hccr.property.foldersCdesDepartment.help" /></span></label>
            <input type="text" id="foldersCdesDepartment" name="foldersCdesDepartment" value="${rqt.foldersCdesDepartment?.toString()}" 
                    class="condition-isCDES-filled  validate-departmentCode ${rqt.stepStates['folders'].invalidFields.contains('foldersCdesDepartment') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersCdesDepartment.validationError" />"  maxlength="2" />
            

    
      <label class="required"><g:message code="hccr.property.foldersOtherFolders.label" /> *  <span><g:message code="hccr.property.foldersOtherFolders.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['folders'].invalidFields.contains('foldersOtherFolders') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersOtherFolders_${it ? 'yes' : 'no'}" class="required condition-isOtherFolders-trigger  validate-one-required boolean" title="" value="${it}" name="foldersOtherFolders" ${it == rqt.foldersOtherFolders ? 'checked="checked"': ''} />
                <label for="foldersOtherFolders_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="condition-isOtherFolders-filled"><g:message code="hccr.property.otherFolders.label" /> <span><g:message code="hccr.property.otherFolders.help" /></span></label>
    <div class="collection-fieldset condition-isOtherFolders-filled summary-box">
    <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'folders', 'currentCollection':'otherFolders', 'collectionIndex':(rqt.otherFolders ? rqt.otherFolders.size() : 0)])}" />
      ${message(code:'request.action.newCollectionItem')}
    </a>
    <g:each var="it" in="${rqt.otherFolders}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="hccr.property.otherFolderName.label" /></dt>
        <dd>${it.otherFolderName?.toString()}</dd>
    
        <dt><g:message code="hccr.property.otherFolderNumber.label" /></dt>
        <dd>${it.otherFolderNumber?.toString()}</dd>
    
        <dt><g:message code="hccr.property.otherFolderDepartment.label" /></dt>
        <dd>${it.otherFolderDepartment?.toString()}</dd>
    
        </dl>
         <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'folders', 'currentCollection':'otherFolders', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'folders', 'currentCollection':'otherFolders', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
      </fieldset>
    </g:each>
    </div>
  

