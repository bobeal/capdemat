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
         <label for="subjectAdultFirstName2" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultFirstName2"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultSex" class="label">Sexe :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultSex"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultBirthDate" class="label">Né(e) le :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultBirthDate"/>
    
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
         <label for="dwelling" class="label">Type d'habitation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="dwelling" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="appartmentNumber" class="label">Numéro d'appartement :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="appartmentNumber" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="floor" class="label">Etage :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="floor" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultHomePhone" class="label">Téléphone domicile :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultHomePhone"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="taxable" class="label">Imposable :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="taxable" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="seniorAssitanceBeneficiary" class="label">Bénéficiaire APA :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="seniorAssitanceBeneficiary" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="contact" class="label">Type de contact :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="contact" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="contactName" class="label">Nom du contact :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="contactName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="contactFirstName" class="label">Prénom du contact :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="contactFirstName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="contactPhone" class="label">Téléphone du contact :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="contactPhone" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="trustee" class="label">Type de dépositaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="trustee" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="trusteeName" class="label">Nom du dépositaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="trusteeName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="trusteeFirstName" class="label">Prénom du dépositaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="trusteeFirstName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="trusteePhone" class="label">Téléphone du dépositaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="trusteePhone" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="emergency" class="label">Demande urgente :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="emergency" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                          		this.dwelling = new Function("key","this.values=new Array('Appartement','Pavillon'); return this[key];");
                                                                          		this.taxable = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.seniorAssitanceBeneficiary = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.contact = new Function("key","this.values=new Array('Demandeur','Autre'); return this[key];");
                                                                                              		this.trustee = new Function("key","this.values=new Array('Demandeur','Autre'); return this[key];");
                                                                                              		this.emergency = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
              		}
</script>
 <div class="clear-both"></div>

