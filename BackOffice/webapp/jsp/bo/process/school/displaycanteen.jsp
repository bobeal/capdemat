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
         <label for="subjectChildLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildLastName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectChildFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="urgencyPhone" class="label">Téléphone en cas d'urgence :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="urgencyPhone" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="schoolName" class="label">Nom de l'école :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="schoolName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="section" class="label">Classe :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="section"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="canteenAttendingDays" class="label">Jours de présence :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="canteenAttendingDays" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="hospitalizationPermission" class="label">Autorisation d'hospitalisation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="hospitalizationPermission" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="foodAllergy" class="label">Allergie :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="foodAllergy" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="foodDiet" class="label">Régime alimentaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="foodDiet" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="doctorName" class="label">Nom du médecin traitant :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="doctorName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="doctorPhone" class="label">Téléphone :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="doctorPhone" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="rulesAndRegulationsAcceptance" class="label">Acceptation du règlement intérieur :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="rulesAndRegulationsAcceptance" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                                            		this.canteenAttendingDays = new Function("key","this.multiple=true;this.values=new Array(); return this[key];");
	                        		this.hospitalizationPermission = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.foodAllergy = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.foodDiet = new Function("key","this.multiple=true;this.values=new Array(); return this[key];");
	                                                                    		this.rulesAndRegulationsAcceptance = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
              		}
</script>
 <div class="clear-both"></div>

