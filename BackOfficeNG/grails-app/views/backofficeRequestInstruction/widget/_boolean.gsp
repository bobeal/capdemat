<form method="post" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span> 
  <ul>
    <li>
      <input name="${propertyName}" type="radio" value="true"
          class="validate-one-required ${required}"  
          title="<g:message code=\"${i18nKeyPrefix}.validationError\" />" ${propertyValue == 'true' ? 'checked="checked"' : ''} />
      <span><g:message code="message.yes" /></span>
    </li>
    <li>
      <input name="${propertyName}" type="radio" value="false"
          class="validate-one-required ${required}"  
          title="<g:message code=\"${i18nKeyPrefix}.validationError\" />" ${propertyValue == 'false' ? 'checked="checked"' : ''} />
      <span><g:message code="message.no" /></span>
    </li>
  </ul>
  
  <input name="requestId" type="hidden" value="${requestId}" />
  <input type="button" class="submitField" value="<g:message code="action.save" />" />
  <input type="button" class="revertField" value="<g:message code="action.cancel" />" />
</form>
