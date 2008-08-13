<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
      <fieldset class="fieldset004">
 
         <div class="form_cell">
         <label for="subjectChildLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildLastName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="subjectChildFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="subjectChildBirthDate" class="label">Date de naissance :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildBirthDate"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="schoolName" class="label">Nom de l'école :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="schoolName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="section" class="label">Classe :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="section"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="canteenAttendingDays" class="label">Jours de présence :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="canteenAttendingDays"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="foodAllergy" class="label">Allergie :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="foodAllergy"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="foodDiet" class="label">Régime alimentaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="foodDiet"/>
    
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
                		}
</script>

