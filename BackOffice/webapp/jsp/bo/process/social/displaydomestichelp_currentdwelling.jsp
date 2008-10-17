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
         <label for"" class="label temp_title_class">Habitation actuelle</label>
         <span class="input"></span>
       </div>
               <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressCity" id="id" profile="profile" />
         </span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingPersonalPhone" class="label">Téléphone personnel :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentDwellingCurrentDwellingPersonalPhone" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingType" class="label">Nature de l'habitation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentDwellingCurrentDwellingType" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingArrivalDate" class="label">Date d'arrivée :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentDwellingCurrentDwellingArrivalDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingStatus" class="label">Statut Habitation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentDwellingCurrentDwellingStatus" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingRoomNumber" class="label">Nombre de pièces :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentDwellingCurrentDwellingRoomNumber" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingNetFloorArea" class="label">Surface habitable :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentDwellingCurrentDwellingNetFloorArea" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                                          		this.currentDwellingCurrentDwellingPersonalPhone = new Function("key","this.values=new Array(); return this[key];");
                            		this.currentDwellingCurrentDwellingType = new Function("key","this.values=new Array('Domicile','Etablissment PA','Accueil particulier à titre onéreux','Autre'); return this[key];");
                                                  		this.currentDwellingCurrentDwellingStatus = new Function("key","this.values=new Array('Propriétaire','Locataire'); return this[key];");
                                                          		}
</script>
 <div class="clear-both"></div>

