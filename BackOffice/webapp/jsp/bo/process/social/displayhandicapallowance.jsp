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
         <label for="hopesAndNeeds" class="label">Souhaits et Besoins :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="hopesAndNeeds" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="hopes" class="label">Souhaits :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="hopes" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="needs" class="label">Besoins :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="needs" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="comments" class="label">Observations :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="comments" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="writingHelp" class="label">Aide à la formulation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="writingHelp" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="helperName" class="label">Nom de l'aidant :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="helperName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="helperResponsability" class="label">Fonction de l'aidant :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="helperResponsability" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="legalRepresentative" class="label">Représentant légal :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="legalRepresentative" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="legalRepresentativeName" class="label">Nom du représentant légal :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="legalRepresentativeName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="legalRepresentativeFirstame" class="label">Prénom du représentant légal :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="legalRepresentativeFirstame" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="legalRepresentativeFamilyRelationship" class="label">Lien de parenté du représentant légal :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="legalRepresentativeFamilyRelationship" id="id" profile="profile"/>
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="legalRepresentativeAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="legalRepresentativeAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="legalRepresentativeAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="legalRepresentativeAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="legalRepresentativeAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="legalRepresentativeAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="legalRepresentativeAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="legalRepresentativeAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="legalRepresentativeAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="legalRepresentativeAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="legalRepresentativeAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="legalRepresentativeAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="legalRepresentativeAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="legalRepresentativeAddressCity" id="id" profile="profile" />
         </span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                    		this.hopesAndNeeds = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                                                                                              		this.writingHelp = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                                                                        		this.legalRepresentative = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                                                                                                      		}
</script>
 <div class="clear-both"></div>

