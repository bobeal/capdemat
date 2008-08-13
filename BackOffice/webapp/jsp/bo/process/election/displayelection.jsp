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
         <label for="subjectIndividualLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectIndividualLastName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectIndividualFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectIndividualFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectIndividualFirstName2" class="label">2ème prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectIndividualFirstName2"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectIndividualFirstName3" class="label">3ème prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectIndividualFirstName3"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectIndividualBirthDate" class="label">Date de naissance :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectIndividualBirthDate"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectIndividualSex" class="label">Sexe :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectIndividualSex"/>
    
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="subjectIndividualAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectIndividualAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectIndividualAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectIndividualAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectIndividualAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectIndividualAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectIndividualAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectIndividualAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectIndividualAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectIndividualAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectIndividualAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectIndividualAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectIndividualAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectIndividualAddressCity" id="id" profile="profile" />
         </span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectNationality" class="label">Nationalité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectNationality" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="motive" class="label">Raison de la demande :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motive" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectOldCity" class="label">Ancienne commune :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectOldCity" id="id" profile="profile"/>
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="subjectAddressOutsideCityAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAddressOutsideCityAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAddressOutsideCityAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAddressOutsideCityAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAddressOutsideCityStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAddressOutsideCityStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAddressOutsideCityStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAddressOutsideCityStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAddressOutsideCityPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAddressOutsideCityPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAddressOutsideCityPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAddressOutsideCityPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectAddressOutsideCityCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectAddressOutsideCityCity" id="id" profile="profile" />
         </span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                            		this.subjectNationality = new Function("key","this.values=new Array(); return this[key];");
                            		this.motive = new Function("key","this.values=new Array('Domicilié dans la commune ou y habitant depuis six mois au moins','Participe aux contributions directes communales pour la cinquième fois sans interruption','Fonctionnaire public assujetti à résidence obligatoire dans la commune','Ne remplit pas actuellement les conditions d&rsquo;âge et de résidence mais les remplira d&rsquo;ici la clôture définitive des listes'); return this[key];");
                                                          		}
</script>
 <div class="clear-both"></div>

