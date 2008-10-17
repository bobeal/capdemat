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
         <label for"" class="label temp_title_class">Tuteur</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSituationTutorPresence" class="label">Présence tuteur :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSituationTutorPresence" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSituationTutor" class="label">Mesure tuteur :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSituationTutor" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSituationTutorName" class="label">Nom du tuteur ou de l'association :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSituationTutorName" id="id" profile="profile"/>
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressCity" id="id" profile="profile" />
         </span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                    		this.requesterSituationTutorPresence = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.requesterSituationTutor = new Function("key","this.values=new Array('Sauvegarde de Justice','Tutelle','Curatelle'); return this[key];");
                                                          		}
</script>
 <div class="clear-both"></div>

