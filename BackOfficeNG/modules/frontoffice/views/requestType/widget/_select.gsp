<% enumsMap = translationService.getEnumsDataMap("${namespace}", "${elementTypeName}", "${request.locale}")%>

<select name="${name}" class="${validation} ${condition}" title="${title}">
  <option value="">${defaultOption}</option>
  <g:each in="${enumsMap}">
  	<g:if test="${it.key.equals(selected.toString())}">
  		<option value="${modelNamespace}.${elementTypeName}_${it.key}" selected="selected">${it.value}</option>
  	</g:if>
  	<g:else>
    	<option value="${modelNamespace}.${elementTypeName}_${it.key}" >${it.value}</option>
    </g:else>
  </g:each>
</select>

