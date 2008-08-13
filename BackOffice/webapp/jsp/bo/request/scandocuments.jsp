<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>
<%@ taglib uri="/cvq-wizard" prefix="cvqw" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
<head>
    <cvqw:baseref/>
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="expires" content="-1" />
	<title>WebCT-Démat: Numériser un document</title>
	<style type="text/css" media="all">
		.imagearea {
			 
			width: 97%;
			margin: 10px;
			
		}
		.image {
			display: inline;
			margin: 10px;
		}
	</style>
</head>

<script language="javaScript">
	function saveDocument() {
		var sf = window.opener.document.getElementById('SaveForm');
		sf.submit();
		window.close();
	}
</script>

<body>
	<p>
	Pour numériser les pièces justificatives, sélectionner l'appareil que vous voulez utiliser et 
	appuyer sur le bouton acquérir.
	</p>
	<p>
	Une fois toutes les pages numérisées appuyer sur enregistrer
	</p>
	<cvq:twain post="paperAction.do?add" height="24" label="Acquérir"/>
	<cvq:input type="button" 
			   styleClass="boutonfix" 
			   property="save" 
			   onclick="javascript:saveDocument()"
			   value="Enregistrer"
			   profile="profile"/>
	<cvq:documentThumbnails name="stateManager" property="selectedRecord.selectedPaper" scope="session"/>
</body>
</html>
