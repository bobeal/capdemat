<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<script type="text/javascript">
	function reportselect(listid, entryid) {
		listElement = document.getElementById(listid);
		entryElement = document.getElementById(entryid);
		
		entryElement.value = listElement.value;
	}
</script>

<html:form action="/editReportAction.do" styleClass="nomargin">
  <table width="100%">
	<tr>
		<td class="titre3" width="25%">
       		Nom de l'état:
        </td>
        <td>
		    <html:text styleClass="saisie" property="reportName" styleId="reportName"/>
        </td>
        <td align="right">
          	<input type="submit" class="boutonfix" name="load" value="Charger"/>
        </td>
	</tr>
	<tr>
		<td class="titre3" width="25%">
       		&nbsp;
        </td>
        <td rowspan="2">
		  	<cvq:referenceSelect name="ReportPrintForm" 
		  						property="reports" 
		  						scope="session" 
		  						onchange="reportselect('reports', 'reportName')"
		  						value="reportName" 
		  						id="reports" 
		  						styleClass="saisie" 
		  						rows="4"/>
        </td>
        <td align="right" valign="top">
          	<input type="submit" class="boutonfix" name="save" value="Sauvegarder"/>
        </td>
	</tr>
	<tr>
		<td class="titre3" width="25%">
       		&nbsp;
        </td>
        <td align="right" valign="top">
          	<input type="submit" class="boutonfix" name="delete" value="Supprimer"/>
        </td>
	</tr>
	<tr>
		<td class="titre3" width="25%">
       		Titre de l'état:
        </td>
        <td>
		    <html:text styleClass="saisie2" property="title" size="60"/>
        </td>
	</tr>
	<tr>
		<td class="titre3" width="25%">
       		Orientation des pages:
        </td>
        <td>
		    <label class="saisie2"><html:radio property="pageOrientation" value="1"/>Portrait</label>
		    <label class="saisie2"><html:radio property="pageOrientation" value="2"/>Paysage</<label>
        </td>
	</tr>
  </table>
</html:form>
