<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

<logic:present scope="session" name="bad_file_format" >
  <logic:equal scope="session" name="bad_file_format" value="errors.file.format">
    <script for=window event=onload >
      alert("<bean:message key="errors.file.format"/>");
    </script>
  </logic:equal>
</logic:present>

  <% session.removeAttribute("bad_file_format"); %>

  
  <logic:present cookie="TERMINAL">
    <div class="fieldset_title_document">
      <h3 class="fieldset_title"><bean:write name="documentForm" property="type"/></h3>
    </div>
    <form name="formScan" id="formScan" action="/uploadDocumentAction"  enctype="multipart/form-data">
      <p class="paragraph scan"><bean:message key="message.document.scan"/>
      <fieldset class="fieldset_zone">
        <ul class="actions_list">
          <li class="validation_process"><div id="Scan" name="Scan" class="Scan" onclick"'">NUMERISER<div></li>
        </ul>
      </fieldset>
	</form>
  </logic:present>
  
  <logic:notPresent cookie="TERMINAL">
    <div class="fieldset_title_document">
      <h3 class="fieldset_title"><bean:write name="documentForm" property="type"/></h3>
    </div>
    <p class="paragraph tabulation">Vos documents électroniques doivent être au format : <strong>jpg, jpeg, png, tiff ou bmp.</strong></p>
    <form name="documentForm" action="#" method="post" enctype="multipart/form-data">
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="file_row"><html:file name="documentForm" property="uploadedFile" styleClass="file"/></li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <ul class="actions_list">
          <li class="validation_process"><input type="button" id="submit_form" value="TELECHARGER LE FICHIER" onclick="javascript:processSubmit('uploadDocumentAction.do?transition=display')"/></li>
        </ul>
      </fieldset>
    </form>
	<script language="JavaScript">
		function validationData() {
    		this.uploadedFile = new Function("key","this.required=true; this.mask=/((.)+\.((jpg)|(JPG)|(jpeg)|(JPEG)|(png)|(PNG)|(bmp)|(BMP)|(tiff)|(TIFF))){1}/; this.maxlength=140,this.transform=false; return this[key];");
  		}
	</script>
 </logic:notPresent>
