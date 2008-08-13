<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

<logic:equal name="fr.cg95.cvq.fo.business.RequestManager" property="exists(html/paiementmessage.html)" value="false">	    
  <div class="block_type5">
    <div class="box">
      <div class="box_top"></div>
      <div class="box_middle">
	    <p class="text">
	    	Vous accédez ici à l'ensemble des fonctionnalités vous permettant de gérer vos comptes 
	  		telles que le paiement de vos factures ou l'alimentation des comptes-tickets de vos enfants.
	    </p>
      </div>
      <div class="box_bottom"></div>
    </div>
  </div>
</logic:equal>
  
<logic:equal name="fr.cg95.cvq.fo.business.RequestManager" property="exists(html/paiementmessage.html)" value="true">
  <div class="block_type5">
    <div class="box">
      <div class="box_top"></div>
      <div class="box_middle">
        <div style="position:relative;top:100px;left:100px;"
		  <div class="error_type1">
            <h1 class="title">ATTENTION</h1>
            <div class="error_box">
              <div class="error_top"></div>
              <div class="error_middle">
	      	  		
<div style="padding:10px;font-size: 1em;font-weight: bold;color: #6e6e6e;">
	<cvq:information name="paiementmessage.html" />
</div>
              </div>
              <div class="error_bottom"></div>
            </div>
          </div>
        </div>
      </div>
      <div class="box_bottom"></div>
    </div>
  </div>

</logic:equal>
  
