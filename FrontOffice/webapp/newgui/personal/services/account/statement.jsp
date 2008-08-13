<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

    
  <div class="block_type5">
    <div class="box">
      <div class="box_top"></div>
      <div class="box_middle">
<logic:notPresent name="statement">
  <logic:present name="error">
        <p class="paragraph"><bean:write name="error"/></p>
  </logic:present>
<logic:notPresent name="error">
		<p class="paragraph">Il n'y a pas règlements effectués les derniers trois mois</p>
</logic:notPresent>	    
</logic:notPresent>
<logic:present name="statement">
        <p class="text caution">Informations détaillées sur vos comptes.</p>
        <p class="text">Pour visualiser le détail d'une ligne, cliquez sur un des champs concernés.</p>
        <h1 class="title account">RELEVE DE COMPTES</h1>
	<cvq:displayStatement name="statement" scope="request"/>	
</logic:present>
      </div>
      <div class="box_bottom"></div>
    </div>
  </div>
