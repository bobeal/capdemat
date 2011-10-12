<form method="post"
  action="${g.createLink(action:'mapping', params:['id':mapping.individualId, 'externalServiceLabel':mapping.homeFolderMapping.externalServiceLabel])}"
  id="form_${mapping.homeFolderMapping.externalServiceLabel}_${mapping.homeFolderMapping.homeFolderId}_${mapping.individualId}">
  <dt class="required">${message(code:'homeFolder.property.externalId')}</dt>
  <dd class="required">
    <input type="text" name="externalId" value="${mapping.externalId}" />
  </dd>
  <input type="hidden" name="homeFolderId" value="${mapping.homeFolderMapping.homeFolderId}" />
  <dt>&nbsp;</dt>
  <dd style="font-size: .95em;">
   <input type="hidden" name="mode" value="${!mapping.id ? 'add' : 'modify'}" />
   <input type="submit" name="submit" value="${message(code:'action.save')}" class="save" />
   <a class="cancel${!mapping.id ? 'Add' : ''}">
     ${message(code:'action.cancel')}
   </a>
 </dd>
</form>