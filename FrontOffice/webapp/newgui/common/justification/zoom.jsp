<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import = "fr.cg95.cvq.fo.common.form.DocumentForm" %>
<%@ page import = "fr.cg95.cvq.fo.dispatcher.StartupServlet" %>
<%@ page import = "fr.cg95.cvq.fo.util.Constants" %>

<% 
  DocumentForm currentDocument = (DocumentForm) request.getAttribute(Constants.DOCUMENT_FORM);
	String serverFilePath = StartupServlet.getFileContextName(request,currentDocument.getServerFile(currentDocument.getDisplayedPageNumber()));
%>
<div class="div_imagearea" style="text-align:center;">
<html:img src="<%=serverFilePath%>" width="253" height="350" />
</div>