


  
    <fieldset class="required">
    <legend><g:message code="hcar.property.folders.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.foldersMdph.label" /> *  <span><g:message code="hcar.property.foldersMdph.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isMDPH-trigger  validate-one-required boolean" title="" value="${it}" name="foldersMdph" ${it == rqt.foldersMdph ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="condition-isMDPH-filled"><g:message code="hcar.property.foldersMdphNumber.label" />   <span><g:message code="hcar.property.foldersMdphNumber.help" /></span></label>
            <input type="text" name="foldersMdphNumber" value="${rqt.foldersMdphNumber?.toString()}" 
                    class="condition-isMDPH-filled  " title="<g:message code="hcar.property.foldersMdphNumber.validationError" />"  maxLength="30"/>
            

    
      <label class="condition-isMDPH-filled"><g:message code="hcar.property.foldersMdphDepartment.label" />   <span><g:message code="hcar.property.foldersMdphDepartment.help" /></span></label>
            <input type="text" name="foldersMdphDepartment" value="${rqt.foldersMdphDepartment?.toString()}" 
                    class="condition-isMDPH-filled  validate-departmentCode" title="<g:message code="hcar.property.foldersMdphDepartment.validationError" />"  maxLength="2"/>
            

    
      <label class="required"><g:message code="hcar.property.foldersCotorep.label" /> *  <span><g:message code="hcar.property.foldersCotorep.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isCOTOREP-trigger  validate-one-required boolean" title="" value="${it}" name="foldersCotorep" ${it == rqt.foldersCotorep ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="condition-isCOTOREP-filled"><g:message code="hcar.property.foldersCotorepNumber.label" />   <span><g:message code="hcar.property.foldersCotorepNumber.help" /></span></label>
            <input type="text" name="foldersCotorepNumber" value="${rqt.foldersCotorepNumber?.toString()}" 
                    class="condition-isCOTOREP-filled  " title="<g:message code="hcar.property.foldersCotorepNumber.validationError" />"  maxLength="30"/>
            

    
      <label class="condition-isCOTOREP-filled"><g:message code="hcar.property.foldersCotorepDepartment.label" />   <span><g:message code="hcar.property.foldersCotorepDepartment.help" /></span></label>
            <input type="text" name="foldersCotorepDepartment" value="${rqt.foldersCotorepDepartment?.toString()}" 
                    class="condition-isCOTOREP-filled  validate-departmentCode" title="<g:message code="hcar.property.foldersCotorepDepartment.validationError" />"  maxLength="2"/>
            

    
      <label class="required"><g:message code="hcar.property.foldersCdes.label" /> *  <span><g:message code="hcar.property.foldersCdes.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isCDES-trigger  validate-one-required boolean" title="" value="${it}" name="foldersCdes" ${it == rqt.foldersCdes ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="condition-isCDES-filled"><g:message code="hcar.property.foldersCdesNumber.label" />   <span><g:message code="hcar.property.foldersCdesNumber.help" /></span></label>
            <input type="text" name="foldersCdesNumber" value="${rqt.foldersCdesNumber?.toString()}" 
                    class="condition-isCDES-filled  " title="<g:message code="hcar.property.foldersCdesNumber.validationError" />"  maxLength="30"/>
            

    
      <label class="condition-isCDES-filled"><g:message code="hcar.property.foldersCdesDepartment.label" />   <span><g:message code="hcar.property.foldersCdesDepartment.help" /></span></label>
            <input type="text" name="foldersCdesDepartment" value="${rqt.foldersCdesDepartment?.toString()}" 
                    class="condition-isCDES-filled  validate-departmentCode" title="<g:message code="hcar.property.foldersCdesDepartment.validationError" />"  maxLength="2"/>
            

    
      <label class="required"><g:message code="hcar.property.foldersOtherFolders.label" /> *  <span><g:message code="hcar.property.foldersOtherFolders.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isOtherFolders-trigger  validate-one-required boolean" title="" value="${it}" name="foldersOtherFolders" ${it == rqt.foldersOtherFolders ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="condition-isOtherFolders-filled"><g:message code="hcar.property.otherFolders.label" /> <span><g:message code="hcar.property.otherFolders.help" /></span></label>
    <div class="collection-fieldset condition-isOtherFolders-filled validation-scope">
      <g:set var="listIndex" value="${editList?.name == 'otherFolders' ? editList?.index : ( rqt.otherFolders ? rqt.otherFolders.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add condition-isOtherFolders-filled">
    
        <label class="required"><g:message code="hcar.property.otherFolderName.label" /> *  <span><g:message code="hcar.property.otherFolderName.help" /></span></label>
            <input type="text" name="otherFolders[${listIndex}].otherFolderName" value="${editList?.otherFolders?.otherFolderName?.toString()}" 
                    class="required  " title="<g:message code="hcar.property.otherFolderName.validationError" />"  maxLength="60"/>
            

    
        <label class=""><g:message code="hcar.property.otherFolderNumber.label" />   <span><g:message code="hcar.property.otherFolderNumber.help" /></span></label>
            <input type="text" name="otherFolders[${listIndex}].otherFolderNumber" value="${editList?.otherFolders?.otherFolderNumber?.toString()}" 
                    class="  " title="<g:message code="hcar.property.otherFolderNumber.validationError" />"  maxLength="30"/>
            

    
        <label class=""><g:message code="hcar.property.otherFolderDepartment.label" />   <span><g:message code="hcar.property.otherFolderDepartment.help" /></span></label>
            <input type="text" name="otherFolders[${listIndex}].otherFolderDepartment" value="${editList?.otherFolders?.otherFolderDepartment?.toString()}" 
                    class="  validate-departmentCode" title="<g:message code="hcar.property.otherFolderDepartment.validationError" />"  maxLength="2"/>
            

    
        <g:if test="${editList?.name == 'otherFolders'}">
          <input type="submit" id="submit-collectionModify-folders-otherFolders[${listIndex}]" name="submit-collectionModify-folders-otherFolders[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-folders-otherFolders[${listIndex}]" name="submit-collectionAdd-folders-otherFolders[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.otherFolders}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="hcar.property.otherFolderName.label" /></dt>
        <dd>${it.otherFolderName?.toString()}</dd>
    
        <dt><g:message code="hcar.property.otherFolderNumber.label" /></dt>
        <dd>${it.otherFolderNumber?.toString()}</dd>
    
        <dt><g:message code="hcar.property.otherFolderDepartment.label" /></dt>
        <dd>${it.otherFolderDepartment?.toString()}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-folders-otherFolders[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-folders-otherFolders[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

