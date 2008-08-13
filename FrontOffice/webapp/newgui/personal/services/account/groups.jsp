<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

    
  <div class="block_type5">
    <div class="box">
      <div class="box_top"></div>
      <div class="box_middle">
<logic:notPresent name="accountGroups">
  <logic:present name="error">
	    <p class="paragraph"><bean:write name="error"/></p>
  </logic:present>
  <logic:notPresent name="error">
	    <p class="paragraph">Il n'y a pas de comptes tickets définis</p>
  </logic:notPresent>	    
</logic:notPresent>
<logic:present name="accountGroups">
        <p class="paragraph">Pour afficher un compte individuel, <strong>cliquez sur la personne concernée :</strong></p>
        <h1 class="title document">CONTRATS DE :</h1>
	<cvq:displayAccounts name="accountGroups" scope="session" mode="groups"/>	
</logic:present>
      </div>
      <div class="box_bottom"></div>
    </div>
  </div>
