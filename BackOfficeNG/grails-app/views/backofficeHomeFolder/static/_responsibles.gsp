<g:each var="roleOwner" in="${roleOwners}">
  <dt class="required">${roleOwner.firstName} ${roleOwner.lastName}</dt>
  <dd class="required">
    <g:each in="${roleOwner.getIndividualRoles(child.id)}">
      ${g.capdematEnumToFlag(var:it.role, i18nKeyPrefix:'homeFolder.role')}
    </g:each>
  </dd>
</g:each>
