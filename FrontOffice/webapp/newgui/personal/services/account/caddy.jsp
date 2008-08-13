<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

<script type="text/javascript">
var alreadyExecuted = false;
function singlePayment() {
	if (!alreadyExecuted) {
		alreadyExecuted = true;
		document.location.href = "pay.do?action=pay";
	} else {
	  	alert("Paiement en cours.");
	}
}
</script>

  <div class="block_type5">
    <div class="box">
      <div class="box_top"></div>
      <div class="box_middle">
  
    <logic:notPresent name="caddy" scope="session">
		<p class="paragraph">Il n'y a pas de paiement en cours.</p>
    </logic:notPresent>
    <logic:present name="caddy" scope="session">
        <p class="paragraph caution">Informations détaillées sur les règlements en attente.</p>
        <p class="text">
        	Récapitulatif de vos différentes sélections, vous pouvez enlever un objet sélectionné en 
        	cliquant sur le lien "supprimer". Pour effectuer votre règlement appuyer sur le bouton "payer".
        </p>
        <h1 class="title money">PAIEMENT EN ATTENTE</h1>
		<cvq:displayCaddy/>
        <ul class="list_type14">
          <li class="item cancel"><a href="pay.do?action=cancel" title="">ANNULER</a></li>
          <li class="item ok"><a href="javascript:singlePayment();" title="">PAYER</a></li>
        </ul>
    </logic:present>
      </div>
      <div class="box_bottom"></div>
    </div>
  </div>

