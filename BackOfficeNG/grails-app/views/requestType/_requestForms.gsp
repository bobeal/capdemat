<div id="insert-in-list"></div>
<ul id="requestFromList" class="editableList">
  <g:each in="${requestForms}" var="form">
    <li id="requestForm:${form.id}">
      <a id="unassociate" class="unassociate">
        <span>unassociate</span>
      </a>
      <a id="editItem" class="editItem">
        <span>editItem</span>
      </a>
      <strong>
        ${form?.getLabel()}
      </strong>
    </li>
  </g:each>
</ul>