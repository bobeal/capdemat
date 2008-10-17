<div>
  <form id="requestForm_${requestForm?.getId()}" 
        method="post" class="form-list-edition datasheet" 
        action="${createLink(action:'requestFormDatasheet')}">
    <p>
      <label for="shortlabel" class="required">
        <g:message code="requestType.property.formShortLabel" /> * :
      </label>
      <input class="datasheet-input" name="shortLabel" id="shortLabel" 
        type="textbox" value="${requestForm?.getShortLabel()}" />
    </p>
    <p>
      <label for="label" class="required">
        <g:message code="requestType.property.formLabel" /> * :
      </label>
      <input class="datasheet-input" name="label" id="label" type="textbox" value="${requestForm?.getLabel()}" />
    </p>
    <p>
      <label for="label" class="required">
        <g:message code="requestType.property.formTemplateName" /> * :
      </label>
      <g:select 
        class="datasheet-input"
        optionKey="name"
        optionValue="name"
        name="templateName" 
        from="${templates}" 
        value="${requestForm?.getTemplateName()}"
        />
      <input type="hidden" name="currentTemplateName" value="${requestForm?.getTemplateName()}" />
      <input type="hidden" name="requestFormId" value="${requestForm?.getId()}" />
      <input type="hidden" name="requestTypeId" value="" />
      <g:if test="${requestForm?.getId()}">
        <a id="a-personalize:${requestForm?.getId()}" href="javascript:;">
          ${message(code:'requestType.property.personalize')}
        </a>
      </g:if>
    </p>
    
    <p>
      <input id="button-ok" class="datasheet-button" name="button-ok" type="button" 
        value="${message(code:'action.ok')}" /> 
      <input id="button-cancel" class="datasheet-button" name="button-cancel" type="button" 
        value="${message(code:'action.cancel')}" />
    </p>
  </form>
</div>