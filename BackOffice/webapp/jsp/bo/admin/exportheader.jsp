<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<script language="JavaScript">
function xmlExport(form) {
	form.page.value="export";
	form.submit();
}
</script>

<logic:notEmpty name="stateManager" property="currentSearch" scope="session">

<div class="grid_cell">
  <iframe src="<%=(String) request.getAttribute("url")%>" height="0" width="0"></iframe>

  <div class="form_block">
    <fieldset class="fieldset002">
      <div class="form_cell">
        <input type="button" name="export" id="export" onclick="javascript:xmlExport(resultForm);" class="input_submit" value="Exporter"/>
      </div>
    </fieldset>
  </div>
</div>


</logic:notEmpty>
