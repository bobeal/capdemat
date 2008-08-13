<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
      <fieldset class="fieldset004">
 
         <div class="form_cell">
         <label for="requesterLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterLastName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="requesterFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="requesterQuality" class="label">Agissant en qualité de :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterQuality"/>
    
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
      		}
</script>

