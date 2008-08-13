<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<!-- <%= (String)request.getSession().getAttribute("url1") %> -->
<%
			String baseref = request.getScheme() + "://" + request.getServerName();
			if (request.getScheme().equals("http") && (request.getServerPort() == 80));
			else if (request.getScheme().equals("https") && (request.getServerPort() == 443));
			else
				baseref += ":" + request.getServerPort();
			baseref += request.getContextPath() +"/";
%>

<head>
	<base href="<%=baseref%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Cartevaloise</title>
	<style type="text/css" media="all">
      @import "css/layout.css";
      @import "css/common.css";
      @import "css/content.css";

	</style>
</head>
<body>
<script type="text/javascript">
function select(id) {
	sHRef='<%=request.getContextPath()%>/selectAction.do?select=paper&forward=ok&id=' + document.getElementById(id).value;
	document.location.href=sHRef;
}    
</script>
  <div class="form_block">

    <div class="grid_cell">
      <div class="block004">
        <div class="grid_cell">
          <div class="block010">
            <fieldset class="fieldset003">
              <div class="form_cell  form_cell001">
                <label for="document" class="label">Justificatifs :</label>
                <span class="input">
                  <cvq:referenceSelect name="stateManager" property="selectedRecord.validPapers" label="type" value="selectedRecord.selectedPaper" scope="session" id="document" styleClass="saisie" onchange="select('document')"/>
                </span>
              </div>
	        </fieldset>
	      </div>
        </div>
        <div class="grid_cell">
          <cvq:documentDisplay name="stateManager" property="selectedRecord.selectedPaper" scope="session"/>
        </div>
      </div>
    </div>
  </div>
    
</body>
</html:html>