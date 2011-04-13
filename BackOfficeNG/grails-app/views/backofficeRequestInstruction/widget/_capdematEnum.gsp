<form method="post" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span> 
  <select id="${propertyName}_Field" name="${propertyName}">
    <g:each var="it" in="${allPropertyValue}">
    <option value="${it.name()}" ${it.toString() == propertyValue.enumString ? 'selected="selected"' : ''}>
      <g:capdematEnumToText var="${it}" i18nKeyPrefix="${propertyValue.i18nKeyPrefix}" />
    </option>
    </g:each>
  </select>

  <input name="requestId" type="hidden" value="${requestId}" />
  <input type="button" class="submitField" value="<g:message code="action.save" />" />
  <input type="button" class="revertField" value="<g:message code="action.cancel" />" />
</form>
