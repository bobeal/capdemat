<% shortDesc = translationService.getRequestLabelTranslation("${requestType.class.name}", "${request.locale}", false)%>
<% longDesc = translationService.getRequestLabelTranslation("${requestType.class.name}", "${request.locale}", true)%>

${shortDesc}
<span>${longDesc}</span>
  
