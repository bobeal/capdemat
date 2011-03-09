<form id="responsibles_${child.id}" method="post" action="${g.createLink(action:'responsibles', id : child.id)}">
  <p>${message(code:'homeFolder.child.property.legalResponsibles.help')}</p>
  <g:each var="roleOwner" in="${roleOwners}" status="index">
    <dt class="required">
      ${roleOwner.adult.fullName}
      <input type="hidden" name="roles.${index}.owner" value="${roleOwner.adult.id}" />
    </dt>
    <dd>
      <select name="roles.${index}.type">
        <option value="">${message(code:'homeFolder.role.message.none')}</option>
        <g:each var="roleType" in="${fr.cg95.cvq.business.users.RoleType.childRoleTypes}">
          <option value="${roleType}" ${roleOwner?.roles?.contains(roleType) ? 'selected="selected"' : ''}>
            ${g.capdematEnumToText(var:roleType, i18nKeyPrefix:'homeFolder.role.withParticle')}
          </option>
        </g:each>
      </select>
    </dd>
  </g:each>
  <g:render template="edit/submit" model="['object': child]" />
</form>
