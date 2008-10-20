<div id="insert-in-list"></div>
<ul id="requestFormList" class="editableList">
  <g:each in="${requestForms}" var="form">
    <li id="requestForm:${form.id}">
      <a id="unassociate" class="unassociate">
        <span><g:message code="category.action.unassociate" /></span>
      </a>
      <a id="editItem" class="editItem">
        <span>editItem</span>
      </a>
      <strong>
        ${form.label}
      </strong>
    </li>
  </g:each>
</ul>