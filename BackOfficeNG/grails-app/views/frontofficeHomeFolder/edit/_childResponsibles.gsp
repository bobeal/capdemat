<style>
  form       { padding: 1.5em 0 !important;}
  form .tag-state { margin-right: .5em; }
  form p         { margin: 0 0 .5em !important; overflow: auto; }
  form label      { float: left; width: 35%; }
  form input[type=submit] { margin: 0 !important; }
</style>
<a href="${createLink(action:'child', params:['id':child.id])}#responsibles" class="modify">
  ${message(code:'action.back')}
</a>
<form id="childResponsibles_${child.id}" method="post" action="${g.createLink(action:'child')}">
  <g:if test="${flash.invalidFields}">
    <p class="error">${message(code:'homeFolder.child.property.legalResponsibles.help')}<p>
  </g:if>
  <g:each var="roleOwner" in="${roleOwners}">
    <p>
      <label>
          ${roleOwner.adult.fullName}
      </label>
      <g:if test="${roleOwner.adult.id == currentRoleOwnerId}">
        <g:each var="role" in="${fr.cg95.cvq.business.users.RoleType.childRoleTypes}">
          <input type="radio" name="roleType" value="${role}" ${roleOwner.roles.contains(role) ? 'checked="checked"' : ''} />
          ${g.capdematEnumToFlag(var:role, i18nKeyPrefix:'homeFolder.role')}
        </g:each>
        <input type="hidden" name="roleOwnerId" value="${roleOwner.adult.id}">
        <input type="hidden" name="fragment" value="responsibles" />
        <input type="hidden" name="id" value="${child.id}" />
        <input type="submit" name="submit" value="${message(code:'action.save')}"/>
      </g:if>
      <g:else>
        <g:if test="${roleOwner.roles}">
          <g:each var="role" in="${roleOwner.roles}">
            ${g.capdematEnumToFlag(var:role, i18nKeyPrefix:'homeFolder.role')}
          </g:each>
        </g:if>
        <g:else>
          <span>${message(code:'homeFolder.role.message.none')}</em>
        </g:else>
        <a href="${createLink(action:'child', params:['id':child.id, 'fragment':'responsibles','roleOwnerId':roleOwner.adult.id])}#responsibles">
          ${message(code:'action.modify')}
        </a>
        <g:if test="${roleOwner.roles}">
          &nbsp;
          <a href="${createLink(action:'unlink', params:['id':child.id, 'fragment':'responsibles','roleOwnerId':roleOwner.adult.id])}#responsibles">
            ${message(code:'action.removeRole')}
          </a>
        </g:if>
      </g:else>
    </p>
  </g:each>
</form>
