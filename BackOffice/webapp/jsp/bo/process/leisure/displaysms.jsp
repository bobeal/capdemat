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
         <label for="subjectAdultLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultLastName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultFirstName"/>
    
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="subjectAdultAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAdultAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAdultAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAdultAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAdultAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAdultAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAdultAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAdultAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAdultAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAdultAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAdultAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAdultAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAdultAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAdultAddressCity" id="id" profile="profile" />
         </span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultMobilePhone" class="label">Téléphone portable :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultMobilePhone"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subscription" class="label">Inscription à l'infolettre SMS :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subscription"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="interests" class="label">Centres d'intérêt :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="interests"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="cleverSmsContactId" class="label">Id Clever SMS :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="cleverSmsContactId"/>
    
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

