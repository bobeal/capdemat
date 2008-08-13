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
         <label for="recreationCenterName" class="label">Centre de loisirs retenu :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="recreationCenterName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="recreationActivity" class="label">Activités de l'enfant au centre :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="recreationActivity"/>
    
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
          		}
</script>

