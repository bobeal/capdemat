<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<logic:notEmpty name="ImportForm" property="currentSearch" scope="session">

<script language="JavaScript">
function xmlImport(form) {
	form.page.value="import";
	form.submit();
}

</script>

<cvq:resultDisplay name="ImportForm" property="currentSearch"/>

<div class="grid_cell">
  <div class="form_block">
    <fieldset class="fieldset002">
      <div class="form_cell">
        <input type="button" name="import" id="import" onclick="javascript:xmlImport(resultForm);" class="input_submit" value="Importer"/>
      </div>
    </fieldset>
  </div>
</div>

</logic:notEmpty>