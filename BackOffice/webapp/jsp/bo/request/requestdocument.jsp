<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<%--  <script type="text/javascript" src="<%= request.getContextPath() + "/js/calendar.js"%>">  --%>
<%--  </script>  --%>

<script type="text/javascript">
var extentions = ".jpg.jpeg.gif.png";
function checkExtention(file) {
	fileName = file.value;
	pos = fileName.lastIndexOf('.');
	if (pos != -1) {
		extention = fileName.substring(pos).toLowerCase();
		if (extentions.indexOf(extention) == -1) {
			alert("L'extension du fichier donné n'est pas traitée.\nVeuillez vérifier le bon format du fichier.");
		}
	}
	else {
		alert("Il n'y a pas d'extension pour le fichier.\nVeuillez vérifier le bon format du fichier.");
	}
}

function submitAction(form) {
	if ((stateElem.value != origState) && (stateElem.value == 'Certifié')) {
		window.open('jsp/bo/request/certifydocument.jsp','certify','resizable=yes,scrollbars=yes,top=234,left=312,width=400,height=300');
	} else {
		var sf = document.getElementById(form);
		sf.submit();
	}
}

function scanDocuments() {
	window.open('jsp/bo/request/scandocuments.jsp?forward=scan','scan','resizable=yes,scrollbars=yes,top=34,left=162,width=800,height=600');
}
</script>

    <div class="grid_cell">
      <div class="block002">
        <p class="text002 pictoFormular">Justificatifs de la <cvq:liason name="stateManager" property="selectedRecord.typeLabel" prefix="demande" article="de" scope="session"/> - référence <bean:write name="stateManager" property="selectedRecord.id" scope="session"/></p>
      </div>

      <div class="block004">
        <cvq:resultDisplay name="stateManager" property="selectedRecord.papers" styleClass="table002"/>
      </div>
    </div>


<logic:notEmpty name="stateManager" property="selectedRecord.selectedPaper" scope="session">

    <div class="grid_cell grid_column_left">
    <html:form action="/saveAction.do?paper" styleId="SaveForm" styleClass="form_block form_block001">
      <div class="block006">
        <p class="text007 pictoStatus">Statut de : <bean:write name="stateManager" property="selectedRecord.selectedPaper.type" scope="session"/></p>
      </div>
      <div class="block012">
        <fieldset class="fieldset006">
          <div class="form_cell">
            <label for="expirationDate" class="label">Valable jusqu'au :</label>
            <div class="periodCalendar">
              <input width="126" type="text" class="input_short_text" value="" id="expirationDate" name="expirationDate"/>
              <span class="block001"><img border="0" alt="" src="/BackOffice/images/calendrier.gif" id="expirationDateButton" /></span>
              <script type="text/javascript">
                Calendar.setup({
                  inputField :  "expirationDate",
                  button :      "expirationDateButton"
                });
              </script>
            </div>
            <div class="clear-both"></div>
            <%-- <cvq:date name="SaveForm"
                  property="expirationDate"
                  scope="request"
                  styleClass="saisie"
                  profile="profile"/> --%>
          </div>
          <div class="form_cell">
            <label for="" class="label">Etat :</label>
            <span class="input">
              <cvq:referenceSelect name="stateManager"
                property="filteredDocumentStates"
                scope="session"
                value="selectedRecord.selectedPaper.state"
                id="state"
                styleClass="input_select"
                empty="false"
                profile="profile"/>
            </span>
            <span class="input">
              <cvq:input type="button"
                styleClass="input_submit"
                property="save"
                onclick="javascript:submitAction('SaveForm')"
                value="Enregistrer"
                profile="profile"/>
            </span>
          </div>
        </fieldset>
      </div>
    </html:form>
    </div>

    <script language="javaScript">
      var stateElem = document.getElementById('state');
      origState = stateElem.value;
    </script>
    
  <logic:equal name="stateManager" property="scanDocumentData" scope="session" value="true">
    <logic:equal name="stateManager" property="canAddPage" scope="session" value="true">
      
      <div class="grid_cell grid_column_right">
      <html:form action="/paperAction.do?add" enctype="multipart/form-data" styleClass="form_block form_block002">
        <div class="block006">
          <p class="text008 pictoAdd">Ajout de pièces justificatives</p>
        </div>
        <div class="block013">
          <fieldset class="fieldset006">
            <div class="form_cell form_cell001">
              <span class="input_button">
                <cvq:input type="button"
                  styleClass="input_digitize"
                  property="scan"
                  onclick="javascript:scanDocuments()"
                  value="Numériser"
                  profile="profile"/>
              </span>
            </div>
            <div class="form_cell form_cell001">
              <span class="input">
                <html:file property="file" styleClass="input_file" onchange="checkExtention(file)"  />
              </span>
              <span class="input_button">
                <cvq:input type="submit"
                  styleClass="input_add"
                  property="add"
                  value="Ajouter"
                  profile="profile"/>
              </span>
            </div>
          </fieldset>
        </div>
      </html:form>
      </div>

    </logic:equal>
  </logic:equal>
    
  <logic:equal name="stateManager" property="viewCertified" scope="session" value="true">
	  <cvq:lp7View/>
  </logic:equal>

  <logic:equal name="stateManager" property="scanDocumentData" scope="session" value="true">
    <logic:equal name="stateManager" property="viewCertified" scope="session" value="false">
      <div class="grid_cell">
        <div class="block014">
	        <cvq:documentDisplay name="stateManager" property="selectedRecord.selectedPaper" scope="session"/>
        </div>
      </div>
    </logic:equal>
  </logic:equal>

</logic:notEmpty>

