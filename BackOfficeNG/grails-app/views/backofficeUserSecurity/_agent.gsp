<form method="post" id="agentForm_${securityRule.agentId}" action="${g.createLink(action:'allow')}" class="editable-list-form" >
  <div id="agentForm_${securityRule.agentId}Errors" class="error"></div>
  <input name="id" type="hidden" value="${securityRule.agentId}" />
  <g:each var="profile" in="${profiles}">
    <label>${g.tag(var:profile, i18n:'user.securityProfile')}</label>
    <input type="radio" name="profile" value="${profile}" 
        ${profile == securityRule.profile ? 'checked="checked"' : ''}
        class="validate-one-required" title="${message(code:'user.error.securityProfileRequired')}"/>
  </g:each>
  <input type="button" name="allow" value="${message(code:'action.save')}" class="allow" />
  <a class="cancel">${message(code:'action.cancel')}</a>
</form>
