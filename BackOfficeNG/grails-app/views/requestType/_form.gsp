<div>
  <form id="requestForm_${requestForm?.getId()}" 
        method="post" class="editable-list-form" 
        action="${createLink(action:'form')}">
      <div id="error-container:${requestForm?.getId()}" class="error"></div>
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
      <g:select
        optionKey="name"
        optionValue="name"
        name="templateName" 
        from="${templates}" 
        value="${requestForm?.getTemplateName()}" />
      <input type="hidden" name="currentTemplateName" value="${requestForm?.getTemplateName()}" />
      <input type="hidden" name="requestFormId" value="${requestForm?.getId()}" />
      <input type="hidden" name="requestTypeId" value="" />
      <g:if test="${requestForm?.getId()}">
        <a id="a-personalize:${requestForm?.getId()}" href="javascript:;">
          ${message(code:'action.personalize')}
        </a>
      </g:if>
      <p class="same-line">
        <label></label>
        <input id="button-ok" name="-ok" type="button" class="form-button" 
          value="${message(code:'action.ok')}" /> 
        <input id="button-cancel" name="-cancel" type="button" class="form-button" 
          value="${message(code:'action.cancel')}" />
      </p>
  </form>
</div>
