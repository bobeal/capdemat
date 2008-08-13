<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<script type=text/javascript>
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

		var column = document.getElementsByName("line")[0];
		column.value = index;

		column = document.getElementsByName("letterShortLabel")[0];
		column.value = trim(tr.cells[0].innerHTML);

		column = document.getElementsByName("letterLabel")[0];
		column.value = trim(tr.cells[1].innerHTML);

		for (var i = 0; i < trsel.cells.length; i++) {
			trsel.cells[i].style.color = "white";
			trsel.cells[i].style.backgroundColor = "#F6BE54";
		}
	}

	function trim(s) {
	    return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
	}
</script>

<html:form action="/requestAction.do?save=layout" enctype="multipart/form-data" styleClass="form_block">
<html:hidden property="line"/>

<div class="grid_cell">
  <div class="block002">
    <p class="text002 XXX"><bean:write name="RequestForm" property="requestType.label"/> > Courrier type</p>
  </div>
  
  <div class="block004">
    <div class="grid_cell">
      <p class="text001">Vous pouvez associer un courrier type à votre télé-service. Pour cela choisissez le fichier au format utilisé par CapDémat et le type de courrier associé puis enregistrer.</p>
      
      <!-- TABLE TYPE 2 -->
      <cvq:resultDisplay name="RequestForm" property="letterTypes" onclick="select" styleClass="table002" />
    </div>
    <div class="clear-both"></div>
  </div>
</div>

<div class="grid_cell">
  <div class="block004">
    <div class="grid_cell">
      <fieldset class="fieldset007">
        <div class="form_cell">
          <label for="letterType" class="label">Libellé permettant d'identifier le courrier type concernée :</label>
          <span class="input"><html:text property="letterShortLabel" styleClass="input_text"/></span>
        </div>
        <div class="form_cell">
          <label for="letterLabel" class="label">Description du courrier type :</label>
          <span class="input"><html:text property="letterLabel" styleClass="input_text"/></span>
        </div>
        <div class="form_cell">
          <label for="file" class="label">Fichier avec mise en page :</label>
          <span class="input"><html:file property="file" styleId="file" styleClass="input_file" size="38"/></span>
        </div>
      </fieldset>
      <fieldset class="fieldset009">
        <div class="form_cell form_cell001">
          <span class="input_button"><input type="submit" class="input_add" name="add" value="<bean:message key='action.add'/>"/></span>
          <span class="input_button"><input type="submit" class="input_edit" name="modify" value="<bean:message key='action.modify'/>"/></span>
          <span class="input_button"><input type="submit" class="input_delete" name="delete" value="<bean:message key='action.suppress'/>"/></span>
        </div>
      </fieldset>
    </div>
    <div class="clear-both"></div>
  </div>
</div>
</html:form>

