<ul id="meansOfContactList" class="editableList">
  <g:each in="${moCs}" var="${moC}">
    <li>
      <g:if test="${moC.enabled}">
        <a id="saveMoC_${moC.id}" class="unassociate">
          <span><g:message code="category.action.unassociate" /></span>
        </a>
      </g:if>
      <g:else>
        <a id="saveMoC_${moC.id}" class="associate">
          <span><g:message code="category.action.associate" /></span>
        </a>
      </g:else>
      <form id="${moC.id}Form" action="${createLink(action : 'moCs')}" method="post">
        <input type="hidden" name="id" value="${moC.id}" />
        <input type="hidden" name="enabled" value="${moC.enabled}" />
      </form>
      <span><g:message code="request.meansOfContact.${moC.type}"/></span>
    </li>
  </g:each>
</ul>