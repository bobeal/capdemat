<form method="post" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span>

  <select id="${propertyName}_Field_hour" name="${propertyName}_hour" style="width:40%; display:inline; float:none;">
%{--    <option value="">${message(code:'message.select.defaultOption')}</option>--}%
    <g:each in="${0..23}">
      <option value="${it}" ${propertyValue.hour == it.toString() ? 'selected="selected"' :''}>
      ${it}
      </option>
    </g:each>
  </select>
  ${message(code:'time.hour')}
  <select id="${propertyName}_Field_minute" name="${propertyName}_minute" style="width:40%; display:inline; float:none;">
%{--    <option value="">${message(code:'message.select.defaultOption')}</option>--}%
    <g:each in="${0..59}">
      <g:if test="${(it % 5) == 0}">
        <option value="${it}" ${propertyValue.minute == it.toString() ? 'selected="selected"' :''}>
          <g:if test="${it < 10}">
            0${it}
          </g:if>
          <g:else>
            ${it}
          </g:else>
        </option>
     </g:if>
    </g:each>
  </select>

  <input name="requestId" type="hidden" value="${requestId}" />
  <input type="button" class="submitField" value="${message(code:'action.save')}" />
  <input type="button" class="revertField" value="${message(code:'action.cancel')}" />
</form>
