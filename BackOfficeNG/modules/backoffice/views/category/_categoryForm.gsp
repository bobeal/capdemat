<h2>
  <g:message code="category.header.generalData" />
</h2>
<form method="POST" id="categoryForm" action="${createLink(action:'save')}">
  <div class="error" id="categoryFormErrors"></div>
  
  <label for="name" class="required"><g:message code="category.property.name" /> * :</label>
  <input type="text" name="name" class="required" size="40" 
      title="${message(code:'category.message.nameRequired')}" value="${category?.name}"/>

  <label for="primaryEmail" class="required"><g:message code="category.property.email" /> * :</label>
  <input type="text" name="primaryEmail" size="40" class="required validate-email" 
      title="${message(code:'category.message.emailRequired')}" value="${category?.primaryEmail}"/>
      
  <div class="form-button">
    <input type="hidden" name="id" value="${category?.id}" />
    <g:if test="${editMode == 'create'}">
      <input type="button" id="submitSaveCategory" name="submitSaveCategory" 
          value="${message(code:'action.create')}" />
      <a id="cancelCreateCategory" href="${createLink(action:'list')}">
        <g:message code="action.cancel" />
      </a>
    </g:if>
    <g:else>
      <input type="button" id="submitSaveCategory" name="submitSaveCategory" 
          value="${message(code:'action.save')}" />
    </g:else>
  </div>
</form>

