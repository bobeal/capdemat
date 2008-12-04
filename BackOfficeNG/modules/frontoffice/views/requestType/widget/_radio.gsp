<% 
enumsMap = translationService.getEnumsDataMap("${namespace}", "${elementTypeName}", "${request.locale}") 
ulCondition = ""
liCondition = ""
if(condition.contains("trigger")) liCondition = condition
else ulCondition = condition
%>

<ul class=${ulCondition}>
  <g:each in="${enumsMap}">
  	<li style="display: inline;">
  		<g:if test="${it.key.equals(checked.toString())}">
    		<input type="radio" name="${name}" value="${modelNamespace}.${elementTypeName}_${it.key}" class="${validation} ${liCondition}" checked="checked"/> 
    		${it.value}
    	</g:if>	
    	<g:else>
    		<input type="radio" name="${name}" value="${modelNamespace}.${elementTypeName}_${it.key}" class="${liCondition}" /> 
    		${it.value}
    	</g:else>
    </li>
  </g:each>
</ul>

