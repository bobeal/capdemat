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
 
         <div class="form_cell">
         <label for"" class="label temp_title_class">Habitation antérieure</label>
         <span class="input"></span>
       </div>
               <div class="form_cell form_cell1">
         <label for="previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="previousDwellingPreviousDwellingAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="previousDwellingPreviousDwellingAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="previousDwellingPreviousDwellingAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="previousDwellingPreviousDwellingAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="previousDwellingPreviousDwellingAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="previousDwellingPreviousDwellingAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="previousDwellingPreviousDwellingAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="previousDwellingPreviousDwellingAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="previousDwellingPreviousDwellingAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="previousDwellingPreviousDwellingAddressCity" id="id" profile="profile" />
         </span>
       </div>
           <div class="form_cell form_cell1">
         <label for="previousDwellingPreviousDwellingArrivalDate" class="label">Date d'arrivée :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="previousDwellingPreviousDwellingArrivalDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="previousDwellingPreviousDwellingDepartureDate" class="label">Date de départ :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="previousDwellingPreviousDwellingDepartureDate" id="id" profile="profile"/>
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

