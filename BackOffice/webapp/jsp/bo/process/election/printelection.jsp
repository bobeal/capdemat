<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
      <fieldset class="fieldset004">
 
         <div class="form_cell">
         <label for="subjectIndividualLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectIndividualLastName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="subjectIndividualFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectIndividualFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="subjectIndividualBirthDate" class="label">Date de naissance :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectIndividualBirthDate"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="electoralNumber" class="label">Numéro d'ordre :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="electoralNumber"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="pollingStation" class="label">Numéro de bureau :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="pollingStation"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="pollingSchoolName" class="label">Nom du groupe scolaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="pollingSchoolName"/>
    
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
            		}
</script>

