<g:each in="${users}" var="user">
  <g:if test="${user?.notBelong}">
    <li id="user_${user.id}" class="notBelong">
    <a class="associate"><span><g:message code="category.action.associate" /></span></a>
  </g:if>
  <g:else>
    <li id="user_${user.id}">
    <a class="unassociate"><span><g:message code="category.action.unassociate" /></span></a>
    <a class="editItem"><span><g:message code="category.action.edit" /></span></a>
  </g:else>
    <span class="itemName">
      <g:if test="${user.active}">
      <strong>${user.lastName} ${user.firstName}</strong>
      </g:if>
      <g:else>
      <span>${user.lastName} ${user.firstName}</span>
      </g:else>
    </span>
    <span class="${user?.profile?.cssClass}"><g:message code="${user?.profile?.i18nKey}"/></span>
  </li>
</g:each>
