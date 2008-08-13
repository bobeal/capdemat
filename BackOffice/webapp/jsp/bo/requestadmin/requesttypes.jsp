<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>
<br>
<script language="JavaScript">
function confirmSave(form) {
	var cancelWindow = window.confirm("\t\t\tATTENTION ! \nSi vous désactivez une demande, la télé-procédure ne sera plus accessible pour l'usager. \nDe même, si vous l'activez elle sera immédiatement disponible.\nVoulez-vous continuer?");
	if (cancelWindow != null) {
		if (cancelWindow == true) {
			form.submit();
		}
	}
}
</script>

<html:form action="/requestAction.do?save=rtypes">
  <table width="100%">
   <tr>
    <td class="titre4">Types de demandes:</td>
    <td align="right">
     <input type="button" class="boutonfix" name="choice" value="<bean:message key='action.save' />" onclick="confirmSave(RequestForm)"/>
    </td>
   </tr>
   <tr>
    <td colspan="2" align="center">
 	 <div style="width: 100%; height: 100%; overflow-y: auto;">
		<cvq:resultDisplay name="RequestForm" property="allrtypes" type="active"/>
	 </div> 
	</td>
   </tr>
  </table>
</html:form>
