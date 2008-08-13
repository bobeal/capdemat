<%@ page contentType="text/html; charset=UTF-8" %>

<script type=text/javascript>
var winCompare=null;

function compare(url1,url2) {
	if ((winCompare == null) || winCompare.closed) {
		winCompare = window.open('jsp/bo/service/compare.jsp?url1='+ url1 + '&url2=' + url2,'compare','resizable=yes,top=0,left=110,width=800,height=714,menubar=yes');
	}
	else
	{
		winCompare.focus();
	}
}

function printPdfForm(url) {
	document.location='printAction.do?formular';
}

function printUserForm(url) {
	window.open('jsp/bo/service/print.jsp?url='+ url,'print','resizable=no,top=0,left=110,width=1,height=1');
}

</script>

<script for=window event=onunload>

if (winCompare != null) {
  winCompare.close();
  winCompare=null;
}

</script>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<div class="form_block">

<div class="grid_cell">
  <div class="block002">
    <p class="text002 pictoStatus">Statut de la <cvq:liason name="stateManager" property="selectedRecord.typeLabel" prefix="demande" article="de" scope="session"/> - référence <bean:write  name="stateManager" property="selectedRecord.id" scope="session" /></p>
	<cvq:indicator name="stateManager" property="selectedRecord.temporary" img="img/HorsFoyer.gif"/>
  </div>

  <div class="block004">
    <div class="block011">
<form method="post" action="saveAction.do?data">

      <fieldset class="fieldset003">
        <div class="form_cell form_cell001">
          <label for="state" class="label">Etat des données :</label>
          <span class="input">
            <cvq:referenceSelect name="stateManager"
              property="dataStates"
              scope="session"
              value="selectedRecord.dataState"
              id="state"
              styleClass="input_select"
              empty="false"
              profile="profile"/>
          </span>
          <span class="input">
            <cvq:input type="submit"
              styleClass="input_submit"
              property="choice"
              value="Enregistrer"
              profile="profile"/>
          </span>
        </div>
        <div class="form_cell form_cell002">
          <span class="input_button">
            <input type="button" name="print" id="print" onclick="javascript:printPdfForm('<%=request.getContextPath() + request.getAttribute("ManagerContent") + "?compare"%>')" class="input_print" value="Imprimer"/>
          </span>
          <logic:equal name="stateManager" property="scanDocumentData" scope="session" value="true">
          <a href="javascript:compare('<%=(String)request.getAttribute("ManagerContent")%>','<%=request.getContextPath() + "/jsp/bo/request/documents.jsp?forward=ok"%>');" class="link">Comparer avec les justificatifs</a>
          </logic:equal>
        </div>
      </fieldset>
</form>
    </div>
    <hr class="hr001" />
