<ul id="requestFormList" class="editableList">
  <g:each in="${requestForms}" var="form">
    <li id="formItem_${form.id}">
      <a id="deleteItem_${form.id}" class="unassociate">
        <span><g:message code="category.action.unassociate" /></span>
      </a>
      <a id="editItem_${form.id}" class="editItem">
        <span>editItem</span>
      </a>
      <strong>
        ${form.label}
      </strong>
    </li>
  </g:each>
</ul>