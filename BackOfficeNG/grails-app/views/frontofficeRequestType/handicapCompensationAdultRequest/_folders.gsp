


  
    <fieldset class="required">
    <legend><g:message code="hcar.property.folders.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.foldersMdph.label" /> *  <span><g:message code="hcar.property.foldersMdph.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersMdph_${it ? 'yes' : 'no'}" class="required condition-isMDPH-trigger  validate-one-required boolean" title="" value="${it}" name="foldersMdph" ${it == rqt.foldersMdph ? 'checked="checked"': ''} />
                <label for="foldersMdph_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="foldersMdphNumber" class="condition-isMDPH-filled"><g:message code="hcar.property.foldersMdphNumber.label" />   <span><g:message code="hcar.property.foldersMdphNumber.help" /></span></label>
            <input type="text" id="foldersMdphNumber" name="foldersMdphNumber" value="${rqt.foldersMdphNumber?.toString()}" 
                    class="condition-isMDPH-filled  " title="<g:message code="hcar.property.foldersMdphNumber.validationError" />"  maxlength="30" />
            

    
      <label for="foldersMdphDepartment" class="condition-isMDPH-filled"><g:message code="hcar.property.foldersMdphDepartment.label" />   <span><g:message code="hcar.property.foldersMdphDepartment.help" /></span></label>
            <input type="text" id="foldersMdphDepartment" name="foldersMdphDepartment" value="${rqt.foldersMdphDepartment?.toString()}" 
                    class="condition-isMDPH-filled  validate-departmentCode" title="<g:message code="hcar.property.foldersMdphDepartment.validationError" />"  maxlength="2" />
            

    
      <label class="required"><g:message code="hcar.property.foldersCotorep.label" /> *  <span><g:message code="hcar.property.foldersCotorep.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersCotorep_${it ? 'yes' : 'no'}" class="required condition-isCOTOREP-trigger  validate-one-required boolean" title="" value="${it}" name="foldersCotorep" ${it == rqt.foldersCotorep ? 'checked="checked"': ''} />
                <label for="foldersCotorep_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="foldersCotorepNumber" class="condition-isCOTOREP-filled"><g:message code="hcar.property.foldersCotorepNumber.label" />   <span><g:message code="hcar.property.foldersCotorepNumber.help" /></span></label>
            <input type="text" id="foldersCotorepNumber" name="foldersCotorepNumber" value="${rqt.foldersCotorepNumber?.toString()}" 
                    class="condition-isCOTOREP-filled  " title="<g:message code="hcar.property.foldersCotorepNumber.validationError" />"  maxlength="30" />
            

    
      <label for="foldersCotorepDepartment" class="condition-isCOTOREP-filled"><g:message code="hcar.property.foldersCotorepDepartment.label" />   <span><g:message code="hcar.property.foldersCotorepDepartment.help" /></span></label>
            <input type="text" id="foldersCotorepDepartment" name="foldersCotorepDepartment" value="${rqt.foldersCotorepDepartment?.toString()}" 
                    class="condition-isCOTOREP-filled  validate-departmentCode" title="<g:message code="hcar.property.foldersCotorepDepartment.validationError" />"  maxlength="2" />
            

    
      <label class="required"><g:message code="hcar.property.foldersCdes.label" /> *  <span><g:message code="hcar.property.foldersCdes.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersCdes_${it ? 'yes' : 'no'}" class="required condition-isCDES-trigger  validate-one-required boolean" title="" value="${it}" name="foldersCdes" ${it == rqt.foldersCdes ? 'checked="checked"': ''} />
                <label for="foldersCdes_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="foldersCdesNumber" class="condition-isCDES-filled"><g:message code="hcar.property.foldersCdesNumber.label" />   <span><g:message code="hcar.property.foldersCdesNumber.help" /></span></label>
            <input type="text" id="foldersCdesNumber" name="foldersCdesNumber" value="${rqt.foldersCdesNumber?.toString()}" 
                    class="condition-isCDES-filled  " title="<g:message code="hcar.property.foldersCdesNumber.validationError" />"  maxlength="30" />
            

    
      <label for="foldersCdesDepartment" class="condition-isCDES-filled"><g:message code="hcar.property.foldersCdesDepartment.label" />   <span><g:message code="hcar.property.foldersCdesDepartment.help" /></span></label>
            <input type="text" id="foldersCdesDepartment" name="foldersCdesDepartment" value="${rqt.foldersCdesDepartment?.toString()}" 
                    class="condition-isCDES-filled  validate-departmentCode" title="<g:message code="hcar.property.foldersCdesDepartment.validationError" />"  maxlength="2" />
            

    
      <label class="required"><g:message code="hcar.property.foldersOtherFolders.label" /> *  <span><g:message code="hcar.property.foldersOtherFolders.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foldersOtherFolders_${it ? 'yes' : 'no'}" class="required condition-isOtherFolders-trigger  validate-one-required boolean" title="" value="${it}" name="foldersOtherFolders" ${it == rqt.foldersOtherFolders ? 'checked="checked"': ''} />
                <label for="foldersOtherFolders_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <div class="collection condition-isOtherFolders-filled">
    <h3>
      <g:message code="hcar.property.otherFolders.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="hcar.property.otherFolders.help" /></span>
      <button type="submit" name="submit-collectionAdd-folders-otherFolders">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.otherFolders}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="hcar.property.otherFolders.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-folders-otherFolders[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label for="otherFolders.${listIndex}.otherFolderName" class="required"><g:message code="hcar.property.otherFolderName.label" /> *  <span><g:message code="hcar.property.otherFolderName.help" /></span></label>
            <input type="text" id="otherFolders.${listIndex}.otherFolderName" name="otherFolders[${listIndex}].otherFolderName" value="${listItem?.otherFolderName?.toString()}" 
                    class="required  " title="<g:message code="hcar.property.otherFolderName.validationError" />"  maxlength="60" />
            

        
          <label for="otherFolders.${listIndex}.otherFolderNumber" class=""><g:message code="hcar.property.otherFolderNumber.label" />   <span><g:message code="hcar.property.otherFolderNumber.help" /></span></label>
            <input type="text" id="otherFolders.${listIndex}.otherFolderNumber" name="otherFolders[${listIndex}].otherFolderNumber" value="${listItem?.otherFolderNumber?.toString()}" 
                    class="  " title="<g:message code="hcar.property.otherFolderNumber.validationError" />"  maxlength="30" />
            

        
          <label for="otherFolders.${listIndex}.otherFolderDepartment" class=""><g:message code="hcar.property.otherFolderDepartment.label" />   <span><g:message code="hcar.property.otherFolderDepartment.help" /></span></label>
            <input type="text" id="otherFolders.${listIndex}.otherFolderDepartment" name="otherFolders[${listIndex}].otherFolderDepartment" value="${listItem?.otherFolderDepartment?.toString()}" 
                    class="  validate-departmentCode" title="<g:message code="hcar.property.otherFolderDepartment.validationError" />"  maxlength="2" />
            

        
      </fieldset>
    </g:each>
    </div>
  

