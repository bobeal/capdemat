<dt>&nbsp;</dt>
<dd style="font-size: .95em;">
  <input type="hidden" name="homeFolderId" value="${flash.homeFolderId}"/>
  <input type="hidden" name="mode" value="${!object.id ? 'add' : 'modify'}" />
  <input type="submit" name="submit" value="${message(code:'action.save')}" class="save" />
  <a class="cancel${!object.id ? 'Add' : ''}">
    ${message(code:'action.cancel')}
  </a>
</dd>
