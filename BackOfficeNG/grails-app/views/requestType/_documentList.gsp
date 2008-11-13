<ul id="documentTypeFormList" class="editableList">
  <g:each in="${documents}" var="doc">
    <li id="documentItem_${doc.documentId}" class="${doc.class}">
      <g:if test="${doc.bound}">
        <a id="unassociateItem_${doc.documentId}" class="unassociate">
          <span><g:message code="category.action.unassociate" /></span>
        </a>
      </g:if>
      <g:else>
        <a id="associateItem_${doc.documentId}" class="associate">
          <span><g:message code="category.action.associate" /></span>
        </a>
      </g:else>
      <strong>
        ${doc.name}
      </strong>
    </li>
  </g:each>
</ul>
