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
  <logic:present parameter="group">
        <p class="paragraph">Pour sélectionner un autre compte individuel, <a href="managerWizard.do?transition=individuals" title="">cliquez ici</a>.</p>
  </logic:present>
  <logic:equal parameter="transition" value="tickets">
        <p class="text">
        	Pour effectuer un achat, cliquez sur un des champs de la ligne concernée. 
        	Puis renseignez le nombre de tickets désiré et appuyez sur le bouton « Acheter ». Vous pouvez effectuer plusieurs achats.<br>
			Cliquez sur le bouton du menu de gauche « Voir les paiements en attente » pour effectuer le paiement.
		</p>
  </logic:equal>
  <logic:equal parameter="transition" value="invoices">
        <p class="text">
			Pour régler une facture, cliquez sur un des champs de la ligne concernée. 
			Puis appuyez sur le bouton « Régler cette facture ». Vous pouvez régler plusieurs factures.<br>
			Cliquez sur le bouton du menu de gauche « Voir les paiements en attente » pour effectuer le paiement        
		</p>
  </logic:equal>
  <logic:equal parameter="transition" value="accounts">
        <p class="text">
			Pour effectuer un versement sur un compte, cliquez sur un des champs de la ligne concernée. 
			Puis renseignez le montant désiré et appuyez sur le bouton « Déposer ». Vous pouvez effectuer plusieurs dépôts.<br>
			Cliquez sur le bouton du menu de gauche « Voir les paiements en attente » pour effectuer le paiement. 
        </p>
  </logic:equal>
	<cvq:displayAccounts name="accountGroups" scope="session" mode="accounts"/>	
</logic:present>
      </div>
      <div class="box_bottom"></div>
    </div>
  </div>
