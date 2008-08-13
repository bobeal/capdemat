<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

<p class="high_paragraph">
  <strong>
	Si vous souhaitez ajouter des responsables légaux hors du compte, 
	cliquez sur <b>Ajouter responsable</b>. 
  </strong>
</p>
<p class="high_paragraph">
  <strong>
	Si vous souhaitez enregistrer uniquement des responsables légaux parmi les adultes du compte, 
	cliquez sur le bouton <b>Enregistrer</b> 
  </strong>
</p>
<div id="extern" style="margin-left: 10px;">
  <cvq:displaylegalresponsibles name="Child" 
  								property="childLegalResponsible" 
  								scope="session" 
  								styleClass="name-button"
  								script="processSubmit"
  								action="processSelect.do?list=childLegalResponsible&transition=legaldisplay"/>
</div>