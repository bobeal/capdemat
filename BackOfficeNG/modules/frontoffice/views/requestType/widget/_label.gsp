<%	if (namespace != null)  
		value = translationService.getElementDesc("${namespace}", "${elementTypeName}", "${elementName}", "${request.locale}", false) 
	else 
		value = translationService.getGlobalElementDesc("${requestType.class.name}", "${elementName}", "${request.locale}", false)
%>
<label for="${forName}" class="${condition}">
	<strong>${value}</strong>
	<g:if test="${validation != null}">
		<g:if test="${validation.contains('required')}">
			<span class="span-required"> * </span>
		</g:if>
	</g:if>
	<span>${help}</span>
</label>	
