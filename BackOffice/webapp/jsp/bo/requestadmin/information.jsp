<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<div style="padding: 10px;width:95%;">
	<html:form action="/requestAction.do?save=information">
		<table width="100%">
			<tr>
				<td class="titre3"><bean:write name="RequestForm" property="informationLabel"/></td>
				<td align="right"><input type="submit" class="boutonfix" name="save" value="<bean:message key='action.save'/>"/></td>
			</tr>
			<tr>
			</tr>
			<tr>
		        <td colspan="3"><html:textarea property="information" styleClass="saisie2" rows="25" cols="100"/></td>
			</tr>
		</table>
	</html:form>
</div>