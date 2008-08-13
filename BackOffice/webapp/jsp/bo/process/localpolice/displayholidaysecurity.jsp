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
         <label for="subjectAdultMobilePhone" class="label">Téléphone Mobile :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultMobilePhone"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultEmail" class="label">Courriel :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultEmail"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="absenceStartDate" class="label">Date début d'absence :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="absenceStartDate"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="absenceEndDate" class="label">date fin d'absence :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="absenceEndDate"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="alarm" class="label">Présence d'une alarme :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="alarm"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="light" class="label">Eclairage automatique :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="light"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="alertPhone" class="label">Numero d'alerte :  :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="alertPhone"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="otherContactLastName" class="label">Nom de la première personne à contacter :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="otherContactLastName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="otherContactFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="otherContactFirstName"/>
    
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="otherContactAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="otherContactAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="otherContactAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="otherContactAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="otherContactAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="otherContactAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="otherContactAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="otherContactAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="otherContactAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="otherContactAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="otherContactAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="otherContactAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="otherContactAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="otherContactAddressCity" id="id" profile="profile" />
         </span>
       </div>
           <div class="form_cell form_cell1">
         <label for="otherContactPhone" class="label">Téléphone :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="otherContactPhone"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="rulesAndRegulationsAcceptance" class="label">Acceptation du règlement :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="rulesAndRegulationsAcceptance" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                                          		this.rulesAndRegulationsAcceptance = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
              		}
</script>
 <div class="clear-both"></div>

