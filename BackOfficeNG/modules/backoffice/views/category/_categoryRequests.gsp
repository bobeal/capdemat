<g:each in="${requestTypes}" var="requestType">
  <g:if test="${requestType?.categoryId == categoryId}">
    <li id="requestType_${requestType.id}">
    <a class="unassociate"><span><g:message code="category.action.unassociate" /></span></a>
  </g:if>
  <g:else>
    <li id="requestType_${requestType.id}" class="notBelong">
      <a class="associate"><span><g:message code="category.action.associate" /></span></a>
  </g:else>  
  <g:if test="${requestType.active}">
      <strong>${requestType.label}</strong>
  </g:if>
  <g:else>
      <span>${requestType.label}</span>
  </g:else>
  <g:if test="${requestType?.categoryId != categoryId && requestType.categoryId != null}">
    <span class="categoryName">(${requestType?.categoryName})</span>
  </g:if>
    </li>
</g:each>
