<div>
  <form id="requestForm_${requestForm?.getId()}" 
        method="post" class="editable-list-form" 
        action="${createLink(action:'form')}">
      <div id="error-container_${requestForm?.getId()}" class="error"></div>
      
      <label for="shortlabel" class="required">
        <g:message code="requestType.property.formShortLabel" /> * :
      </label>
      <input name="shortLabel" id="shortLabel" class="required"
             title="${message(code:'requestType.message.shortLabelRequired')}"
             type="text" value="${requestForm?.getShortLabel()}" />
      <label for="label" class="required">
        <g:message code="requestType.property.formLabel" /> * :
      </label>
      <input name="label" id="label" type="text" class="required"
             title="${message(code:'requestType.message.labelRequired')}"
             value="${requestForm?.getLabel()}" />
      
      <label for="templateName" class="required">
        <g:message code="requestType.property.formTemplateName" /> * :
      </label>
      <select name="templateName">
        <g:each in="${templates}" var="template">
          <option value="${template}"
            <g:if test="${requestForm?.templateName == template}">selected="selected"</g:if>>
            ${template}
          </option>
        </g:each>
      </select>
      <g:if test="${requestForm?.getId()}">
        <a id="personalize_${requestForm?.getId()}" class="personalize" href="javascript:;">
          ${message(code:'action.personalize')}
        </a>
      </g:if>
        
      <input type="hidden" name="currentTemplateName" value="${requestForm?.getTemplateName()}" />
      <input type="hidden" name="requestFormId" value="${requestForm?.getId()}" />
      <input type="hidden" name="requestTypeId" value="" />

      <p class="same-line">
        <input id="save_${requestForm?.getId()}" name="save" type="button" 
               class="first-button" value="${message(code:'action.save')}" /> 
        <input id="cancel_${requestForm?.getId()}" name="cancel" type="button" 
               class="form-button" value="${message(code:'action.close')}" />
      </p>
      
  </form>
</div>
