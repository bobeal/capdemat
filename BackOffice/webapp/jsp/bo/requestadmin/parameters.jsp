<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<script language=JavaScript>
	var trsel = null;
	var bgcolor = null;
	function select(tr) {
		if (trsel != null) {
			trsel.cells[0].style.color = "black";
			trsel.cells[1].style.color = "black";
			trsel.cells[0].style.backgroundColor = bgcolor;
			trsel.cells[1].style.backgroundColor = bgcolor;
		}
		trsel = tr;
		bgcolor = tr.cells[0].style.backgroundColor;

		key = document.getElementsByName("key")[0];
		key.value = trim(tr.cells[0].innerText);
		label = document.getElementsByName("label")[0];
		label.value = trim(tr.cells[1].innerText);
		
		tr.cells[0].style.color = "white";
		tr.cells[1].style.color = "white";
		tr.cells[0].style.backgroundColor = "blue";
		tr.cells[1].style.backgroundColor = "blue";
	}

	function trim(s) {
	    return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
	}
</script>

<div style="padding: 10px;">
	<html:form action="/parameterAction.do">
		<div class="label-field">
			<label for="name" class="label">
				Groupe de données:
			</label>
		  	<bean:write name="ParameterForm" property="groupLabel"/>
		</div>
		<div style="width: 75%;">
			<div class="label-field">
				<label for="key" class="label">
					Clé :
				</label>
			    <html:text property="key"/>
			</div>
			<div class="label-field">
				<label for="label" class="label">
					Libellé :
				</label>
			    <html:text property="label"/>
			</div>
			<div class="label-field">
				<label for="label" class="label">
					Données :
				</label>
			</div>
		</div>
		<div style="float:right;clear:left;">
			<div style="margin-bottom: 2px;">
	    	<input type="submit" class="boutonfix" name="save" value="<bean:message key='action.save'/>"/>
	    	</div>
	    	<input type="submit" class="boutonfix" name="delete" value="<bean:message key='action.suppress'/>"/>
		</div>
		<div class="label-field">
			<cvq:resultDisplay name="ParameterForm" property="referentialData" onclick="select"/>
		</div>
	</html:form>
</div>