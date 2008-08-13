<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/reporting.tld" prefix="cvq-report" %>

<script type="text/javascript">
	var trsel = null;
	var bgcolor = null;

	function select(trId, index) {
		var tr = document.getElementById(trId);
		if (trsel != null) {
			for (var i = 0; i < trsel.cells.length; i++) {
				trsel.cells[i].style.color = "black";
				trsel.cells[i].style.backgroundColor = bgcolor;
			}
		}
		trsel = tr;
		bgcolor = tr.cells[0].style.backgroundColor;

		var column = document.getElementsByName("index")[0];
		column.value = index;

		column = document.getElementsByName("column")[0];
		column.value = trim(tr.cells[0].innerHTML);

		column = document.getElementsByName("requestType")[0];
		column.value = trim(tr.cells[1].innerHTML);
		typeselect('requestType', 'field');
		
		column = document.getElementsByName("field")[0];
		column.value = trim(tr.cells[2].innerHTML);

		column = document.getElementsByName("label")[0];
		column.value = trim(tr.cells[3].innerHTML);

		column = document.getElementsByName("width")[0];
		column.value = trim(tr.cells[4].innerHTML);

		column = document.getElementsByName("group")[0];
		column.checked = tr.cells[5].firstChild.checked;

		for (var i = 0; i < trsel.cells.length; i++) {
			trsel.cells[i].style.color = "white";
			trsel.cells[i].style.backgroundColor = "blue";
		}
	}

	function trim(s) {
	    var result = s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
	    if (result == "&nbsp;")
	    	return "";
	    	
	    return result;
	}

	function FieldData(field, text, width) {
		this.field = field;
		this.text = text;
		this.width = width;
	}
	
	var requestTypes = null;
	function typeselect(typeid, fieldid) {
		if (requestTypes == null)
			requestTypes = new RequestTypeData();

		if (requestTypes != null) {
			typeElement = document.getElementById(typeid);
			fieldElement = document.getElementById(fieldid);

			var selectedType = typeElement.selectedIndex;
			var type = requestTypes['t' + selectedType];

			if (type != null) {
				// Remove all elements except the empty first line
				while (fieldElement.options.length > 1)
					fieldElement.remove(1);
	
				for (var i = 0; i < type.length; i++) {				
					var option = new Option();
					option.text = type[i].text;
					option.value = type[i].field;

					fieldElement.options[fieldElement.options.length] = option;
				}
			}
		}
	}

</script>
<cvq-report:reportField name="ReportPrintForm" property="fields" scope="session" />

<html:form action="/editReportAction.do" styleClass="nomargin">
  <html:hidden property="index"/>
  <table width="100%">
	<tr>
		<td class="titre3" width="25%">N° de colonne dans l'état:</td>
        <td><html:text property="column" styleClass="saisie2" size="2"/></td>
	</tr>
	<tr>
		<td class="titre3" width="25%">Champ à inclure dans l'état</td>
	</tr>
	<tr>
		<td class="titre3" width="25%" align="right">Type de demande:</td>
        <td>
			<cvq:referenceSelect name="ReportPrintForm" 
								property="requestTypes" 
								scope="session" 
		  						onchange="typeselect('requestType', 'field')"
								value="requestType" 
								id="requestType" 
								styleClass="saisie" 
								search="true"/>
        </td>
	</tr>
	<tr>
		<td class="titre3" width="25%" align="right">Champ:</td>
        <td>
			<cvq:referenceSelect name="ReportPrintForm" 
								property="fields" 
								scope="session" 
								value="field" 
								id="field" 
								styleClass="saisie" 
								label="name"/>
        </td>
        <td align="right">
          	<input type="submit" class="boutonfix" name="newcolumn" value="Ajouter"/>
        </td>
	</tr>
	<tr>
		<td class="titre3" width="25%">Libellé pour la colonne:</td>
        <td><html:text property="label" styleClass="saisie"/></td>
        <td align="right">
          	<input type="submit" class="boutonfix" name="modcolumn" value="Modifier"/>
        </td>
	</tr>
	<tr>
		<td class="titre3" width="25%">Largeur de la colonne:</td>
        <td><html:text property="width" styleClass="saisie2" size="5"/></td>
        <td align="right">
          	<input type="submit" class="boutonfix" name="delcolumn" value="Supprimer"/>
        </td>
	</tr>
	<tr>
		<td class="titre3" width="25%">Groupe:</td>
        <td><html:checkbox property="group" styleClass="saisie3"/></td>
	</tr>
  </table>
</html:form>
<cvq:resultDisplay name="ReportPrintForm" property="elements" onclick="select" disabled="true"/>
<script type="text/javascript">
	var resultTable = document.getElementById("elements");
	if (resultTable != null) {
		var selectedIndex = document.getElementsByName("index")[0].value;
		if ((selectedIndex >= 0) && (selectedIndex < resultTable.rows.length)) {
			var tr = "tr" + selectedIndex;
			select(tr,selectedIndex);
		}
	}
</script>