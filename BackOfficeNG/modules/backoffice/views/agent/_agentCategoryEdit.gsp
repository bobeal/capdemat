<form method="post" id="categoryEditForm_${category.id}" action="<g:createLink action="editCategory" />" class="editable-list-form" >
  <div id="categoryEditForm_${category.id}Errors" class="error"></div>
  
  <ul>
    <g:each var="profile" in="${profiles}" status="i">
      <li>
        <span class="${profile.cssClass}">${message(code:profile.i18nKey)}</span>        
        <input name="profileIndex" value="${i}" type="radio"
            class="validate-one-required" title="${message(code:'category.error.profileRequired')}"
            ${profile.i18nKey == category?.agentProfile?.i18nKey ? 'checked="checked"' : ''}
        />
      </li>
    </g:each>
  </ul>
  
  <input name="agentId" type="hidden" value="${agentId}" />
  <input name="categoryId" type="hidden" value="${category.id}" />
  
  <input type="button" value="modifier" class="submitEditItem form-button" />
  <input type="button" value="annuler" class="cancelEditItem form-button" />
  
</form>
