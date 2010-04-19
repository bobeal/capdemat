


  
    <fieldset class="required">
    <legend><g:message code="hccr.property.folders.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.foldersMdph.label" /> *  <span><g:message code="hccr.property.foldersMdph.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['folders']?.invalidFields.contains('foldersMdph') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersMdph_${it ? 'yes' : 'no'}" class="required condition-isMDPH-trigger  validate-one-required boolean" title="" value="${it}" name="foldersMdph" ${it == rqt.foldersMdph ? 'checked="checked"': ''} />
                <label for="foldersMdph_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="foldersMdphNumber" class="condition-isMDPH-filled"><g:message code="hccr.property.foldersMdphNumber.label" />   <span><g:message code="hccr.property.foldersMdphNumber.help" /></span></label>
            <input type="text" id="foldersMdphNumber" name="foldersMdphNumber" value="${rqt.foldersMdphNumber?.toString()}" 
                    class="condition-isMDPH-filled   ${stepStates != null && stepStates['folders']?.invalidFields.contains('foldersMdphNumber') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersMdphNumber.validationError" />"  maxlength="30" />
            

    
      <label for="foldersMdphDepartment" class="condition-isMDPH-filled"><g:message code="hccr.property.foldersMdphDepartment.label" />   <span><g:message code="hccr.property.foldersMdphDepartment.help" /></span></label>
            <input type="text" id="foldersMdphDepartment" name="foldersMdphDepartment" value="${rqt.foldersMdphDepartment?.toString()}" 
                    class="condition-isMDPH-filled  validate-departmentCode ${stepStates != null && stepStates['folders']?.invalidFields.contains('foldersMdphDepartment') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersMdphDepartment.validationError" />"  maxlength="2" />
            

    
      <label class="required"><g:message code="hccr.property.foldersCotorep.label" /> *  <span><g:message code="hccr.property.foldersCotorep.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['folders']?.invalidFields.contains('foldersCotorep') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersCotorep_${it ? 'yes' : 'no'}" class="required condition-isCOTOREP-trigger  validate-one-required boolean" title="" value="${it}" name="foldersCotorep" ${it == rqt.foldersCotorep ? 'checked="checked"': ''} />
                <label for="foldersCotorep_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="foldersCotorepNumber" class="condition-isCOTOREP-filled"><g:message code="hccr.property.foldersCotorepNumber.label" />   <span><g:message code="hccr.property.foldersCotorepNumber.help" /></span></label>
            <input type="text" id="foldersCotorepNumber" name="foldersCotorepNumber" value="${rqt.foldersCotorepNumber?.toString()}" 
                    class="condition-isCOTOREP-filled   ${stepStates != null && stepStates['folders']?.invalidFields.contains('foldersCotorepNumber') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersCotorepNumber.validationError" />"  maxlength="30" />
            

    
      <label for="foldersCotorepDepartment" class="condition-isCOTOREP-filled"><g:message code="hccr.property.foldersCotorepDepartment.label" />   <span><g:message code="hccr.property.foldersCotorepDepartment.help" /></span></label>
            <input type="text" id="foldersCotorepDepartment" name="foldersCotorepDepartment" value="${rqt.foldersCotorepDepartment?.toString()}" 
                    class="condition-isCOTOREP-filled  validate-departmentCode ${stepStates != null && stepStates['folders']?.invalidFields.contains('foldersCotorepDepartment') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersCotorepDepartment.validationError" />"  maxlength="2" />
            

    
      <label class="required"><g:message code="hccr.property.foldersCdes.label" /> *  <span><g:message code="hccr.property.foldersCdes.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['folders']?.invalidFields.contains('foldersCdes') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersCdes_${it ? 'yes' : 'no'}" class="required condition-isCDES-trigger  validate-one-required boolean" title="" value="${it}" name="foldersCdes" ${it == rqt.foldersCdes ? 'checked="checked"': ''} />
                <label for="foldersCdes_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="foldersCdesNumber" class="condition-isCDES-filled"><g:message code="hccr.property.foldersCdesNumber.label" />   <span><g:message code="hccr.property.foldersCdesNumber.help" /></span></label>
            <input type="text" id="foldersCdesNumber" name="foldersCdesNumber" value="${rqt.foldersCdesNumber?.toString()}" 
                    class="condition-isCDES-filled   ${stepStates != null && stepStates['folders']?.invalidFields.contains('foldersCdesNumber') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersCdesNumber.validationError" />"  maxlength="30" />
            

    
      <label for="foldersCdesDepartment" class="condition-isCDES-filled"><g:message code="hccr.property.foldersCdesDepartment.label" />   <span><g:message code="hccr.property.foldersCdesDepartment.help" /></span></label>
            <input type="text" id="foldersCdesDepartment" name="foldersCdesDepartment" value="${rqt.foldersCdesDepartment?.toString()}" 
                    class="condition-isCDES-filled  validate-departmentCode ${stepStates != null && stepStates['folders']?.invalidFields.contains('foldersCdesDepartment') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.foldersCdesDepartment.validationError" />"  maxlength="2" />
            

    
      <label class="required"><g:message code="hccr.property.foldersOtherFolders.label" /> *  <span><g:message code="hccr.property.foldersOtherFolders.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['folders']?.invalidFields.contains('foldersOtherFolders') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersOtherFolders_${it ? 'yes' : 'no'}" class="required condition-isOtherFolders-trigger  validate-one-required boolean" title="" value="${it}" name="foldersOtherFolders" ${it == rqt.foldersOtherFolders ? 'checked="checked"': ''} />
                <label for="foldersOtherFolders_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="condition-isOtherFolders-filled"><g:message code="hccr.property.otherFolders.label" /> <span><g:message code="hccr.property.otherFolders.help" /></span></label>
    <div class="collection-fieldset condition-isOtherFolders-filled validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'otherFolders' ? editList?.index : ( rqt.otherFolders ? rqt.otherFolders.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add condition-isOtherFolders-filled">
    
        <label for="otherFolders.${listIndex}.otherFolderName" class="required"><g:message code="hccr.property.otherFolderName.label" /> *  <span><g:message code="hccr.property.otherFolderName.help" /></span></label>
            <input type="text" id="otherFolders.${listIndex}.otherFolderName" name="otherFolders[${listIndex}].otherFolderName" value="${editList?.otherFolders?.otherFolderName?.toString()}" 
                    class="required   ${stepStates != null && stepStates['folders']?.invalidFields.contains('otherFolderName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.otherFolderName.validationError" />"  maxlength="60" />
            

    
        <label for="otherFolders.${listIndex}.otherFolderNumber" class=""><g:message code="hccr.property.otherFolderNumber.label" />   <span><g:message code="hccr.property.otherFolderNumber.help" /></span></label>
            <input type="text" id="otherFolders.${listIndex}.otherFolderNumber" name="otherFolders[${listIndex}].otherFolderNumber" value="${editList?.otherFolders?.otherFolderNumber?.toString()}" 
                    class="   ${stepStates != null && stepStates['folders']?.invalidFields.contains('otherFolderNumber') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.otherFolderNumber.validationError" />"  maxlength="30" />
            

    
        <label for="otherFolders.${listIndex}.otherFolderDepartment" class=""><g:message code="hccr.property.otherFolderDepartment.label" />   <span><g:message code="hccr.property.otherFolderDepartment.help" /></span></label>
            <input type="text" id="otherFolders.${listIndex}.otherFolderDepartment" name="otherFolders[${listIndex}].otherFolderDepartment" value="${editList?.otherFolders?.otherFolderDepartment?.toString()}" 
                    class="  validate-departmentCode ${stepStates != null && stepStates['folders']?.invalidFields.contains('otherFolderDepartment') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.otherFolderDepartment.validationError" />"  maxlength="2" />
            

    
        <g:if test="${editList?.name == 'otherFolders'}">
          <input type="submit" id="submit-collectionModify-folders-otherFolders" name="submit-collectionModify-folders-otherFolders[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-folders-otherFolders" name="submit-collectionAdd-folders-otherFolders[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
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
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-folders-otherFolders[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-folders-otherFolders[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

