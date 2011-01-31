<dt class="required">${message(code:'homeFolder.child.property.legalResponsibles')}</dt>
<dd class="required">
  <ul>
  <g:each var="roleOwner" in="${roleOwners}">
    <li>
      <g:each in="${roleOwner.getIndividualRoles(child.id)}">
        ${g.capdematEnumToFlag(var:it.role, i18nKeyPrefix:'homeFolder.role')}
      </g:each> 
      ${roleOwner.firstName} ${roleOwner.lastName}
    </li>
  </g:each>
  </ul>
</dd>
