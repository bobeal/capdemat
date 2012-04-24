<g:if test="${session.frontContext}">
  <g:if test="${session.currentCredentialBean.ecitizen.homeFolder.temporary}">
    <g:render template="/shared/menus/menu_temporary"/>
  </g:if>
  <g:else>
    <g:render template="/shared/menus/menu_${session.frontContext.toString().toLowerCase()}"/>
  </g:else>
</g:if>
<g:else>
  <g:render template="/shared/menus/menu_unauth_ecitizen"/>
</g:else>
