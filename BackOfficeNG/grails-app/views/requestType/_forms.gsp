<div id="requestTypeFormsConfiguration">
  <h2><g:message code="requestType.configuration.forms" /></h2>
  <div id="requestTypeFormsMessages"></div>
  <form class="edit" method="POST" id="requestTypeFormsForm" action="<g:createLink action="saveForms" />">
    <input type="hidden" name="id" value="${requestType?.id}" />
    <div class="error" id="dialogRequestTypeFormsFormError"></div>
    <label for="name" class="required"><g:message code="requestType.property.formName" /> * :</label>
    <input type="text" name="name" class="required" size="21"
        title="Le nom est obligatoire"/>
    <br/>
    
    <label for="xslFoFilename" class="required"><g:message code="requestType.property.formFile" /> (XSL-FO) * :</label>
    <input type="file" class="file" id="xslFoFilename" name="xslFoFilename" />
      
    <div class="form-button">
      <input type="button" id="submitAddRequestTypeForms" 
          name="submitAddRequestTypeForms" value="<g:message code="action.add" />" />
    </div>
  </form>

  <h3><g:message code="requestType.header.formsList" /></h3>
  <ul>
  <g:each in="${requestType?.forms}" var="form">
    <li>${form.shortLabel} (${form.xslFoFilename})</li>
  </g:each>
  </ul>
  <div id="requestTypeFormsTable" class="configuration-table"></div> 
  <div class="separator">&nbsp;</div>
</div>


