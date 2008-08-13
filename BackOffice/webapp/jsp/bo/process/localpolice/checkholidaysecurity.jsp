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
         <label for="absenceStartDate" class="label">Date début d'absence :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="absenceStartDate"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="absenceEndDate" class="label">date fin d'absence :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="absenceEndDate"/>
    
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
        		}
</script>

