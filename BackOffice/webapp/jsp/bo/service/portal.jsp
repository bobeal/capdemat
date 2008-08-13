<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<style type="text/css">
a:link {
    text-decoration:none;
	color: #000000;
	font-family: AbadyMT, Arial;
	font-size: 11px;
	font-weight: normal;
}
a:visited {
    text-decoration:none;
	color: #000000;
	font-family: AbadyMT, Arial;
	font-size: 11px;
	font-weight: normal;
}
a:hover {
    text-decoration:underline;
	color: #000000;
	font-family: AbadyMT, Arial;
	font-size: 11px;
	font-weight: normal;
}

</style>

<a href="searchAction.do?request=open" target="_blank"><bean:write name="stateManager" property="nbopen" scope="session" /> Demandes en cours</a><br>
<a href="searchAction.do?request=validate" target="_blank"><bean:write name="stateManager" property="nbpending" scope="session" /> Demandes à valider</a><br>
<a href="searchAction.do?request=notify" target="_blank"><bean:write name="stateManager" property="nbnotify" scope="session" /> Attestations à envoyer</a><br>
