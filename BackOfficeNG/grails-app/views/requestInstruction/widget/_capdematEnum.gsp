<form method="POST" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="form-list-edition" >
  <span id="${propertyName}_FormErrors" class="error"></span> 
  <select id="${propertyName}_Input" name="${propertyNameTp}">
    <g:each var="it" in="${allPropertyValue}">
    <option value="${it}" ${it.toString() == propertyValue.enumString ? 'selected="selected"' : ''}>
      <g:capdematEnumToText var="${it}" i18nKeyPrefix="${propertyValue.i18nKeyPrefix}" />
    </option>
    </g:each>
  </select>
  
  <input name="requestId" type="hidden" value="${requestId}" />
  <input name="individualId" type="hidden" value="${individualId}" />

  <input type="button" value="modify" class="submit" />
  <input type="button" value="discard" class="discard" />
</form>
