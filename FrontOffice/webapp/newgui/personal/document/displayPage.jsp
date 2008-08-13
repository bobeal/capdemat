<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import = "fr.cg95.cvq.fo.common.form.DocumentForm" %>
<%@ page import = "fr.cg95.cvq.fo.dispatcher.StartupServlet" %>
<%@ page import = "fr.cg95.cvq.fo.util.Constants" %>

<% 
  DocumentForm currentDocument = (DocumentForm) request.getAttribute(Constants.DOCUMENT_FORM);
	String serverFilePath = StartupServlet.getFileContextName(request,currentDocument.getServerFile(currentDocument.getDisplayedPageNumber()));
%>
  <div class="block_type5">
    <div class="box">
      <div class="box_top"></div>
      <div class="box_middle">
		<div class="div_imagearea" style="top:0px;width:100%;float:left;clear:right;text-align:center;">
			<html:img src="<%=serverFilePath%>" width="312" height="432" />
		</div>
		<p class="paragraph" style="float:right;"><a href="documentDisplayAction.do?transition=document">Retour</a></p>
      </div>
      <div class="box_bottom"></div>
    </div>
  </div>
