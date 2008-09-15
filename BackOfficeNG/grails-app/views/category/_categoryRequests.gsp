    <li class="header">
      <span style="float: right;">action</span>
      <strong><g:message code="menu.requests" /></strong>
    </li>
    
<g:each in="${requestTypes}" var="requestType">
  <g:if test="${requestType?.categoryId == categoryId}">
    <li id="requestType_${requestType.id}">
    <a class="unassociate"><span>unassociate</span></a>
    <span class="tag-enable">v</span>
  </g:if>
  <g:else>
    <li id="requestType_${requestType.id}" class="notBelong">
      <a class="associate"><span>associate</span></a>
  </g:else>  
  <g:if test="${requestType.active}">
      <strong class="enabled">${requestType.label}</strong>
  </g:if>
  <g:else>
      <span class="disabled">${requestType.label}</span>
  </g:else>
  <g:if test="${requestType?.categoryId != categoryId}">
    <span class="category">(${requestType?.categoryName})</span>
  </g:if>
    </li>
</g:each>




