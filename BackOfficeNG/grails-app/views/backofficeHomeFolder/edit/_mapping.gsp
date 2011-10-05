<form method="post"
  action="${g.createLink(action:'mapping', params:['id':mapping.individualId, 'externalServiceLabel':mapping.homeFolderMapping.externalServiceLabel])}"
  id="form_${mapping.homeFolderMapping.externalServiceLabel}_${mapping.homeFolderMapping.homeFolderId}_${mapping.individualId}">
  <dt class="required">${message(code:'homeFolder.property.externalId')}</dt>
  <dd class="required">
    <input type="text" name="externalId" value="${mapping.externalId}" />
  </dd>
  <input type="hidden" name="homeFolderId" value="${mapping.homeFolderMapping.homeFolderId}" />
  <g:render template="edit/submit" model="['object':mapping]" />
</form>