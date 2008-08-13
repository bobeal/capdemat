<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<form name="CardForm" method="post" action="cardAction.do">
  <table width="100%">
	<tr>
	  <td class="titre3" width="25%">Nom du responsable du compte:</td>
	  <td class="titre3">
		<bean:write name="stateManager" property="selectedRecord.name" scope="session"/>
	  </td>
	  <td align="right">
	    <input type="submit" class="boutonfix" name="print" value="Etiquette"/>
	  </td>
	</tr>
	<tr>
	  <td class="titre3" width="25%">Adresse du foyer:</td>
	  <td class="titre3">
		<bean:write name="stateManager" property="selectedRecord.address" scope="session"/>
	  </td>
	</tr>
	<tr>
	  <td class="titre3" width="25%">Numéro de la carte:</td>
	  <td class="titre3">
		<bean:write name="stateManager" property="selectedRecord.cardId" scope="session"/>
	  </td>
	</tr>
	<tr>
	  <td class="titre3" width="25%">Date de la création de la carte:</td>
	  <td class="titre3">
		<bean:write name="stateManager" property="selectedRecord.cardDate" scope="session"/>
	  </td>
	</tr>
	<tr>
	  <td class="titre3" width="25%">Etat de la carte:</td>
	  <td class="titre3">
		<cvq:referenceSelect name="stateManager" property="cardStates" scope="session" value="selectedRecord.cardState" id="state" styleClass="saisie" empty="false"/>
	  </td>
	  <td align="right">
	    <input type="submit" class="boutonfix" name="save" value="Enregistrer"/>
	  </td>
	</tr>
  </form>
</table>
