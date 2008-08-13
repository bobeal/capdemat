<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
      <fieldset class="fieldset004">
 
         <div class="form_cell">
         <label for="subjectAdultLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultLastName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="subjectAdultFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="subscription" class="label">Inscription à l'infolettre SMS :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subscription"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="interests" class="label">Centres d'intérêt :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="interests"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="cleverSmsContactId" class="label">Id Clever SMS :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="cleverSmsContactId"/>
    
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
          		}
</script>

