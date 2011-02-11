<a href="${createLink(action:'child', params:['id':child.id, 'fragment':'responsibles'])}#responsibles" class="modify">
  ${message(code:'action.modify')}
</a>
<dl>
  <g:if test="${!roleOwners.isEmpty()}">
    <dt><g:message code="homeFolder.child.property.legalResponsibles" /> :</dt>
    <dd>
      <g:each var="roleOwner" in="${roleOwners}">
        <p>
          ${roleOwner.fullName}
          <g:each in="${roleOwner.getIndividualRoles(child.id)}">
            ${g.capdematEnumToFlag(var:it.role, i18nKeyPrefix:'homeFolder.role')}
          </g:each>
        </p>
      </g:each>
    </dd>
  </g:if>
</dl>
