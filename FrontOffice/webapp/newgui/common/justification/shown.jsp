<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

<div class="fieldset_title_document">
  <h3 class="fieldset_title"><bean:write name="documentForm" property="type" /></h3>
</div>
<div class="media_file">
<cvq:documentThumbnails name="documentForm" scope="request" action="showCurrentPageDocumentAction.do?transition=displaypage"/>
</div>