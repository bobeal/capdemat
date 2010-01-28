<form method="post" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span>
  
  <g:render template="/backofficeRequestInstruction/widget/localReferentialEntries" 
      model="['javaName':propertyName, 'lrDatas':lrDatas, 'htmlClass':htmlClass,
              'lrEntries':lrType?.entries, 'isMultiple':lrType.entriesSupportMultiple,
              'i18nKeyPrefix':i18nKeyPrefix, 'depth':0]" />
  
  <input name="requestId" type="hidden" value="${requestId}" />
  <input type="button" class="submitField" value="<g:message code="action.save" />" />
  <input type="button" class="revertField" value="<g:message code="action.cancel" />" />
</form>
