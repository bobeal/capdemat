<form method="POST" id="userEditForm_${user.id}" action="<g:createLink action="editUser" />" class="editable-list-form" >
  <div id="userEditForm_${user.id}Errors" class="error"></div>
  
  <ul>
    <g:each var="profile" in="${profiles}" status="i">
      <li>
        <span class="${profile.cssClass}"><g:message code="${profile.i18nKey}"/></span>        
        <input name="profileIndex" value="${i}" type="radio"
            <g:if test="${i == 0}">
            class="validate-one-required" title="<g:message code="category.error.profileRequired"/>"
            </g:if> 
            ${profile.i18nKey == user?.profile?.i18nKey ? 'checked="checked"' : ''}
        />
      </li>
    </g:each>
  </ul>
  
  <input name="userId" type="hidden" value="${user.id}" />
  <input name="categoryId" type="hidden" value="${categoryId}" />
  
  <input type="button" value="modifier" class="submitEditItem form-button" />
  <input type="button" value="annuler" class="cancelEditItem form-button" />
  
</form>
