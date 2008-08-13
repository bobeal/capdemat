<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>
<%@ taglib uri="/cvq-wizard" prefix="cvqw" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
<head>
    <cvqw:baseref/>
	<title>WebCT-DÃ©mat: Certifier un document</title>
</head>
<script language="javaScript">
	window.moveTo(312,234);
	window.resizeTo(400,310);
</script>
<body>
	<p>
	Pour certifier le document attachÃ© au mail, veuillez insÃ©rer la clÃ© usb avec le tampon du service, 
	saisir le mot de passe correspondant et valider.
	</p>
	<cvq:lp7Certify next="jsp/bo/process/certifymailclose.jsp"/>
</body>
</html>