<ul id="displayGroupRequestTypes" class="editableList">
<g:each in="${requestTypes}" var="requestType">
  <g:if test="${requestType?.displayGroupId == displayGroupId}">
    <li id="requestType_${requestType.id}">
    <a id="unassociate_${requestType.id}" class="unassociate"><span>${message(code:'action.unassociate')}</span></a>
  </g:if>
  <g:else>
    <li id="requestType_${requestType.id}" class="notBelong">
      <a id="associate_${requestType.id}" class="associate"><span>${message(code:'action.associate')}</span></a>
  </g:else>  
  <g:if test="${requestType.active}">
      <strong>${requestType.label}</strong>
  </g:if>
  <g:else>
      <span>${requestType.label}</span>
  </g:else>
  <g:if test="${requestType?.displayGroupId != displayGroupId && requestType.displayGroupId != null}">
    <span class="displayGroupName">(${requestType?.displayGroupLabel})</span>
  </g:if>
    </li>
</g:each>
</ul>
