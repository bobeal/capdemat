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
         <label for"" class="label temp_title_class">Demandeur</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultTitle" class="label">Civilité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultTitle"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultFamilyStatus" class="label">Situation familiale :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultFamilyStatus"/>
    
    	</span>
       </div>
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
         <label for="subjectAdultMaidenName" class="label">Nom de jeune fille :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultMaidenName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultBirthDate" class="label">Né(e) le :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultBirthDate"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultBirthPlaceCity" class="label">Ville :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultBirthPlaceCity"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="nationality" class="label">Nationalité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="nationality" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="franceArrivalDate" class="label">Date d'arrivée en France :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="franceArrivalDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="moreThan15YearsInFrance" class="label">Je réside en France depuis plus de 15 ans de manière continue :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="moreThan15YearsInFrance" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterPensionPlan" class="label">Régime de retraite principal :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterPensionPlan" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="pensionPlanPrecision" class="label">Préciser :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="pensionPlanPrecision" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="complementaryPensionPlanPrecision" class="label">Régime de retraite complémentaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="complementaryPensionPlanPrecision" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                                  		this.nationality = new Function("key","this.values=new Array('Française','Union Européenne','Hors Union Européenne'); return this[key];");
                                                  		this.moreThan15YearsInFrance = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.requesterPensionPlan = new Function("key","this.values=new Array('CRAMIF','CNAV','MSA','CRAM','MGEN','SNCF','Autre'); return this[key];");
                                                          		}
</script>
 <div class="clear-both"></div>

