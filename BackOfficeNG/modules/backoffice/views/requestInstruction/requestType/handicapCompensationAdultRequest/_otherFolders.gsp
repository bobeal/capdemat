

  <g:set var="listSize" value="${request.otherFolders.size()}" />
  <h3>
    <a class="addListItem" id="add_otherFolders[${listSize}]"></a>
    <span><g:message code="hcar.property.otherFolders.label" /></span>
  </h3>
  <g:each var="it" in="${request.otherFolders.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_otherFolders[${listSize - 1 - index}]"></a>
  </div>
  <dl class="condition-isOtherFolders-filled">
    
      <dt class="required"><g:message code="hcar.property.otherFolderName.label" /> * : </dt>
      <dd id="otherFolders[${listSize - 1 - index}].otherFolderName" class="action-editField validate- required-true i18n-hcar.property.otherFolderName" >
        <span>${it?.otherFolderName}</span>
      </dd>
    
      <dt class=""><g:message code="hcar.property.otherFolderNumber.label" />  : </dt>
      <dd id="otherFolders[${listSize - 1 - index}].otherFolderNumber" class="action-editField validate- i18n-hcar.property.otherFolderNumber" >
        <span>${it?.otherFolderNumber}</span>
      </dd>
    
      <dt class=""><g:message code="hcar.property.otherFolderDepartment.label" />  : </dt>
      <dd id="otherFolders[${listSize - 1 - index}].otherFolderDepartment" class="action-editField validate-departmentCode i18n-hcar.property.otherFolderDepartment" >
        <span>${it?.otherFolderDepartment}</span>
      </dd>
    
  </dl>
  </g:each>
