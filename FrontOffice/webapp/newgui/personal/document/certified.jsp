<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-wizard" prefix="cvqw" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >

<script language="javaScript">
	function downloadDocument() {
		window.opener.document.location.href='/FrontOffice/documentDisplayAction.do?transition=displayall&download';
		window.close();
	}
</script>

<html>
  <head>
    <base href="https://localhost:8443/FrontOffice/">
    <cvqw:baseref/>
    <cvq:htmltitle/>
	<style type="text/css">
		@import "assets/common/css/new/account/common.css";
		@import "assets/common/css/new/account/colors.css";
	</style>
  </head>
  
  <body>
	<div style="width:100%;align:center;">
		<img src="img/logo-lexpersona-p.png">
	</div>
	<p>
	Vous pouvez tÃ©lÃ©charger le document certifiÃ©, et/ou le visualiser avec l'outil Lex Persona.
	</p>
    <div class="block_type7">
      <ul class="list_type7">
        <li class="item">
          <a href="javascript:downloadDocument();" title=""><span class="custom_color"></span>TELECHARGER</a>
        </li>
        <li class="item">
          <a href="javascript:window.close();" title=""><span class="custom_color"></span>FERMER</a>
        </li>
      </ul>
    </div>
  </body>
</html>
