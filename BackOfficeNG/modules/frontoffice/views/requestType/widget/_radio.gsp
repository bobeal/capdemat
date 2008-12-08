<% 
enumsMap = translationService.getEnumsDataMap("${namespace}", "${elementTypeName}", "${request.locale}") 
ulCondition = ""
liCondition = ""
if(condition.contains("trigger")) liCondition = condition
else ulCondition = condition
%>
<ul class="${ulCondition}">
<%
Integer i = 0
enumsMap.each {
	if (i == 0) 
		liValidation = validation 
	else 
		liValidation = ""
	
%>
<li style="display: inline;">
  <g:if test="${it.key.equals(checked.toString())}">
    <input type="radio" name="${name}" value="${modelNamespace}.${elementTypeName}_${it.key}" 
      class="${liCondition} ${liValidation}" checked="checked"/> 
    ${it.value}
  </g:if>	
  <g:else>
    <input type="radio" name="${name}" value="${modelNamespace}.${elementTypeName}_${it.key}" 
      class="${liCondition} ${liValidation}" title="${title}"/> 
    ${it.value}
  </g:else>
</li>
<%	
	i++;
}
%>
</ul>

