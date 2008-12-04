<% 	if (namespace == null) 
		legend = translationService.getGlobalElementDesc("${requestType.class.name}", "${elementName}", "${request.locale}", true) 
	else
		legend = translationService.getElementDesc("${namespace}", "${elementTypeName}", "${elementName}", "${request.locale}", true)
%>

<legend>${legend}</legend>

