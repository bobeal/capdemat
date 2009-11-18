<form method="post" class="editable-list-form"
  action="<g:createLink action="mapping" />"
  id="form_${externalServiceLabel}_${homeFolderId}_${individualId}">
  <input name="id" type="text" value="${id}" />
  <input type="hidden" name="homeFolderId" value="${homeFolderId}" />
  <input type="hidden" name="individualId" value="${individualId}" />
  <input type="hidden" name="externalServiceLabel" value="${externalServiceLabel}" />
  <input type="button" class="submitField" value="<g:message code="action.save" />" />
  <input type="button" class="revertField" value="<g:message code="action.cancel" />" />
</form>
