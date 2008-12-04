<%
if (type.equals("yesnoWidget")) {
	if (value == true) { 
%>
<span class="${condition}"><g:message code="widget.yesno.yes" /></span>
<%
	} else {
%>
<span class="${condition}"><g:message code="widget.yesno.no" /></span>
<%
	}
} else if (type.equals("selectWidget") || type.equals("radioWidget")) {
enumsMap = translationService.getEnumsDataMap("${namespace}", "${elementTypeName}", "${request.locale}")
enumsMap.each {
	if (it.key.equals(value.toString())) valueTranslation = it.value
}
%>
<span class="${condition}">${valueTranslation}</span>	
<%
} else {
%>
<span class="${condition}">${value}</span>
<%
}
%>

