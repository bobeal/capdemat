<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
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

		column = document.getElementsByName("label")[0];
		column.value = trim(tr.cells[0].innerHTML);

		column = document.getElementsByName("startDate")[0];
		column.value = trim(tr.cells[1].innerHTML);

		column = document.getElementsByName("endDate")[0];
		column.value = trim(tr.cells[2].innerHTML);

		column = document.getElementsByName("startInscription")[0];
		column.value = trim(tr.cells[3].innerHTML);

		column = document.getElementsByName("endInscription")[0];
		column.value = trim(tr.cells[4].innerHTML);

		column = document.getElementsByName("validationDate")[0];
		column.value = trim(tr.cells[5].innerHTML);

		for (var i = 0; i < trsel.cells.length; i++) {
			trsel.cells[i].style.color = "white";
			trsel.cells[i].style.backgroundColor = "#F6BE54";
		}
	}

	function transformDate(field) {
        var D = DatVal(field.value, 2, 99)
        if (D[0])
            field.value = D[2];
	}
	
	function trim(s) {
	    return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
	}
</script>

<html:form action="/requestAction.do?save=season" styleClass="form_block">
<html:hidden property="line"/>

<div class="grid_cell">
  <div class="block002">
    <p class="text002 XXX"><bean:write name="RequestForm" property="requestType.label"/> > Gestion des saisons</p>
  </div>
  
  <div class="block004">
    <div class="grid_cell">
      <p class="text001">Vous pouvez définir des saisons afin de permettre les nouvelles inscriptions à des activités futures concernant le même domaine d'activité. Ceci a pour effet de proposer aux usagers de s'inscrire à nouveau à une même activité mais disponible pour une période différente.</p>
      
      <!-- TABLE TYPE 2 -->
      <cvq:resultDisplay name="RequestForm" property="seasons" onclick="select" styleClass="table002" />
    </div>
      
    <div class="clear-both"></div>
  </div>
</div>
  
  
<div class="grid_cell">
  <div class="block004">
    <div class="grid_cell">
      <fieldset class="fieldset009">
        <div class="form_cell">
          <label for="label" class="label">Libellé permettant d'identifier la saison concernée :</label>
          <span class="input"><html:text property="label" styleClass="input_text" size="43" /></span>
        </div>
        <div class="form_cell">
          <label for="startDate" class="label">Date de début de la saison proposée :</label>
          <span class="input"><html:text property="startDate" styleId="startDate" styleClass="input_text" size="12" onchange="javascript:transformDate(this)"/></span>
          <span class="block001"><img border="0" alt="" src="/BackOffice/images/calendrier.gif" id="startDateButton" /></span>
          <script type="text/javascript">
            Calendar.setup({
              inputField :  "startDate",
              button :      "startDateButton"
            });
          </script>
        </div>
        <div class="form_cell">
          <label for="endDate" class="label">Date de fin de la saison proposée :</label>
          <span class="input"><html:text property="endDate" styleId="endDate" styleClass="input_text" size="12" onchange="javascript:transformDate(this)"/></span>
          <span class="block001"><img border="0" alt="" src="/BackOffice/images/calendrier.gif" id="endDateButton" /></span>
          <script type="text/javascript">
            Calendar.setup({
              inputField :  "endDate",
              button :      "endDateButton"
            });
          </script>
        </div>
        <div class="form_cell">
          <label for="startInscription" class="label">Date de début de la période d'inscription :</label>
          <span class="input"><html:text property="startInscription" styleId="startInscription" styleClass="input_text" size="12" onchange="javascript:transformDate(this)"/></span>
          <span class="block001"><img border="0" alt="" src="/BackOffice/images/calendrier.gif" id="startInscriptionButton" /></span>
          <script type="text/javascript">
            Calendar.setup({
              inputField :  "startInscription",
              button :      "startInscriptionButton"
            });
          </script>
        </div>
        <div class="form_cell">
          <label for="endInscription" class="label">Date de fin de la période d'inscription :</label>
          <span class="input"><html:text property="endInscription" styleId="endInscription" styleClass="input_text" size="12" onchange="javascript:transformDate(this)"/></span>
          <span class="block001"><img border="0" alt="" src="/BackOffice/images/calendrier.gif" id="endInscriptionButton" /></span>
          <script type="text/javascript">
            Calendar.setup({
              inputField :  "endInscription",
              button :      "endInscriptionButton"
            });
          </script>
        </div>
        <div class="form_cell">
          <label for="validationDate" class="label">Date à partir de laquelle la demande peut être validée :</label>
          <span class="input"><html:text property="validationDate" styleId="validationDate" styleClass="input_text" size="12" onchange="javascript:transformDate(this)"/></span>
          <span class="block001"><img border="0" alt="" src="/BackOffice/images/calendrier.gif" id="validationDateButton" /></span>
          <script type="text/javascript">
            Calendar.setup({
              inputField :  "validationDate",
              button :      "validationDateButton"
            });
          </script>
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