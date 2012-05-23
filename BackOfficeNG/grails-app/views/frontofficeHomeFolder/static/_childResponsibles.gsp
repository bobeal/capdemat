<!-- Hack for maintain the layout -->
<style>
  form#childResponsibles p         { margin: 0 0 .5em !important; overflow: auto; }
  form#childResponsibles label      { float: left; width: 35%; }
</style>
<a href="${createLink(action:'child', params:['id':child.id, 'fragment':'responsibles'])}#responsibles" class="modify">
  ${message(code:'action.modify')}
</a>
<g:each var="roleOwner" in="${roleOwners}">
<!-- Hack for maintain the layout -->
<form id="childResponsibles">
    <p>
      <label>
          ${roleOwner.adult.fullName} :
      </label>
        <g:if test="${roleOwner.roles}">
          <g:each var="role" in="${roleOwner.roles}">
            ${g.capdematEnumToFlag(var:role, i18nKeyPrefix:'homeFolder.role')}
          </g:each>
        </g:if>
        <g:else>
          <span>${message(code:'homeFolder.role.message.none')}</em>
        </g:else>
    </p>
</form>
  </g:each>
