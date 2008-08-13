<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<logic:empty name="stateManager" property="selectedRecord.papers" scope="session">
	<div class="titre2">
		Il n y a pas de justificatifs pour ce compte.
	</div>
</logic:empty>
<cvq:resultDisplay name="stateManager" property="selectedRecord.papers" force="navigation"/>
<logic:notEmpty name="stateManager" property="selectedRecord.selectedPaper" scope="session">
	<br>
	<div class="titre2" style="position:relative">Justificatif : <bean:write name="stateManager" property="selectedRecord.selectedPaper.type" scope="session"/> </div>
	<br>
	<logic:equal name="stateManager" property="scanDocumentData" scope="session" value="true">
		<cvq:documentDisplay name="stateManager" property="selectedRecord.selectedPaper" scope="session"/>
	</logic:equal>
</logic:notEmpty>

