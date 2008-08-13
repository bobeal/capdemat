<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/cvq-wizard" prefix="cvqw" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<cvqw:baseref/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>Site de backdoor</title>

</head>
<body>
<div align="center">
<table cellpadding="0" cellspacing="0" width="100%">
<tr>
<td align="center">Site de backdoor</td>
</tr>
</table>
<html:form action="/loginAction.do" focus="username">

<!-- tableau des champs de saisie-->
<table class="align1">
 <tr>
  <td class="titre3" colspan="2">L'accÃšs Ã  cet espace est rÃ©servÃ© aux agents.</td>
 </tr>
 <tr><td>&nbsp;</td></tr>

 <tr>
  <td colspan="2">
   <!-- error messages go here -->
   <logic:messagesPresent>
    <span style="color:red;">
     <html:errors/>
    </span>
   </logic:messagesPresent>
  </td>
 </tr>

 <tr>
  <td class="titre4">Nom d'utilisateur :</td>
  <td>
   <html:text property="username" styleClass="saisie" maxlength="20"/>
  </td>
 </tr>

 <tr>
  <td class="titre4">Mot de passe :</td>
  <td>
   <html:password property="password" styleClass="saisie" maxlength="20"/>
  </td>
 </tr>

</table>
<!-- fin du tableau des champs de saisie-->

<!-- tableau des boutons-->
<table>
 <tr>
  <td align="right">
   <html:submit property="choice"><bean:message key="action.confirm"/></html:submit>
  </td>
  <td align="left">
   <input type="submit" name="cancel" value="<bean:message key='action.abort'/>"/>
  </td>
 </tr>
</table>

<!-- fin du tableau des boutons-->
</html:form>
</div>

</body>
</html>

