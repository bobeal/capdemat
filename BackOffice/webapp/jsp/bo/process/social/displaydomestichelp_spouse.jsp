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
         <label for"" class="label temp_title_class">Conjoint</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseInformationLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseInformationLastName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseInformationFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseInformationFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseInformationMaidenName" class="label">Nom de jeune fille :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseInformationMaidenName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseInformationBirthDate" class="label">Né(e) le :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseInformationBirthDate"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseInformationBirthPlaceCity" class="label">Ville :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseInformationBirthPlaceCity"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseNationality" class="label">Nationalité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseNationality" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseFranceArrivalDate" class="label">Date d'arrivée en France :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseFranceArrivalDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseMoreThan15YearsInFrance" class="label">Je réside en France depuis plus de 15 ans de manière continue :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseMoreThan15YearsInFrance" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpousePensionner" class="label">Retraité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpousePensionner" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpousePensionPlan" class="label">Régime de retraite principal :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpousePensionPlan" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpousePensionPlanPrecision" class="label">Préciser :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpousePensionPlanPrecision" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseComplementaryPensionPlanPrecision" class="label">Régime de retraite complémentaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseComplementaryPensionPlanPrecision" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseOccupation" class="label">Profession :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseOccupation" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployer" class="label">Employeur :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseEmployer" id="id" profile="profile"/>
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressCity" id="id" profile="profile" />
         </span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                              		this.requesterSpouseSpouseNationality = new Function("key","this.values=new Array('Française','Union Européenne','Hors Union Européenne'); return this[key];");
                                                  		this.requesterSpouseSpouseMoreThan15YearsInFrance = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.requesterSpouseSpousePensionner = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.requesterSpouseSpousePensionPlan = new Function("key","this.values=new Array('CRAMIF','CNAV','MSA','CRAM','MGEN','SNCF','Autre'); return this[key];");
                                                                                                                            		}
</script>
 <div class="clear-both"></div>

