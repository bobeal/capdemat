<form id="childResponsibles_${child.id}" method="post" action="${g.createLink(action:'child')}" style="padding-top: .5em; text-align:center;">
  <g:set var="roleCount" value="${0}" />
  <g:each var="roleOwner" in="${roleOwners}">
    <g:each var="individualRole" in="${roleOwner.getIndividualRoles(child.id)}">
      <p>
        <input type="hidden" name="roles.${roleCount}.id" value="${individualRole.id}" />
        <select name="roles.${roleCount}.owner">
          <option value="">${message(code:'message.select.defaultOption')}</option>
          <g:each var="adult" in="${adults}">
            <option value="${adult.id}" ${roleOwner.id == adult.id ? 'selected="selected"' : '' }>
              ${adult.fullName}
            </option>
          </g:each>
        </select>
        ${message(code:'homeFolder.role.message.anotherAdultIs', args:[''])}
        <select name="roles.${roleCount}.type">
          <option value="">${message(code:'message.select.defaultOption')}</option>
          <g:each var="roleType" in="${fr.cg95.cvq.business.users.RoleType.childRoleTypes}">
            <option value="${roleType}" ${individualRole.role.equals(roleType) ? 'selected="selected"' : ''}>
              ${g.capdematEnumToText(var:roleType, i18nKeyPrefix:'homeFolder.role.withParticle')}
            </option>
          </g:each>
        </select>
      </p>
      <g:set var="roleCount" value="${roleCount + 1}" />
    </g:each>
  </g:each>
  <g:if test="${roleCount < 3}">
    <g:each var="i" in="${roleCount..2}">
      <p>
        <select name="roles.${i}.owner">
          <option value="">${message(code:'message.select.defaultOption')}</option>
          <g:each var="adult" in="${adults}">
            <option value="${adult.id}">
              ${adult.fullName}
            </option>
          </g:each>
        </select>
        ${message(code:'homeFolder.role.message.anotherAdultIs', args:[''])}
        <select name="roles.${i}.type">
          <option value="">${message(code:'message.select.defaultOption')}</option>
          <g:each var="roleType" in="${fr.cg95.cvq.business.users.RoleType.childRoleTypes}">
            <option value="${roleType}">
              ${g.capdematEnumToText(var:roleType, i18nKeyPrefix:'homeFolder.role.withParticle')}
            </option>
          </g:each>
        </select>
      </p>
    </g:each>
  </g:if>

  <p style="padding-top: .5em;">
    <input type="hidden" name="template" value="childResponsibles" />
    <input type="hidden" name="id" value="${child.id}" />
    <input type="submit" name="cancel" value="${message(code:'action.cancel')}" class="cancel" />
    <input type="submit" name="submit" value="${message(code:'action.save')}" class="save" />
  </p>
</form>

