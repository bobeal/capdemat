    <!--
    <li class="header">
      <span style="float: right;">action</span>
      <strong><g:message code="menu.requests" /></strong>
    </li>
    -->
    
<g:each in="${requestTypes}" var="requestType">
  <g:if test="${requestType?.categoryId == categoryId}">
    <li id="requestType_${requestType.id}">
    <a class="unassociate"><span>unassociate</span></a>
  </g:if>
  <g:else>
    <li id="requestType_${requestType.id}" class="notBelong">
      <a class="associate"><span>associate</span></a>
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




