<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
    <div class="block009">
     <p class="text005 pictoTable">Formulaire</p>
   </div>
   <div class="block010">
     <fieldset class="fieldset005">
 
         <div class="form_cell form_cell1">
         <label for="ownerLastName" class="label">Nom du propriétaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="ownerLastName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="ownerFirstNames" class="label">Prénom(s) :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="ownerFirstNames" id="id" profile="profile"/>
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="ownerAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="ownerAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="ownerAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="ownerAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="ownerAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="ownerAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="ownerAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="ownerAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="ownerAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="ownerAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="ownerAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="ownerAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="ownerAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="ownerAddressCity" id="id" profile="profile" />
         </span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                                                                  		}
</script>
 <div class="clear-both"></div>

