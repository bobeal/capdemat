<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
      <fieldset class="fieldset004">
 
         <div class="form_cell">
         <label for="deathLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="deathLastName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="deathFirstNames" class="label">Prénom(s) :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="deathFirstNames" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="deathDate" class="label">Date du décès :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="deathDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="deathCity" class="label">Ville de décès :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="deathCity" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="deathPostalCode" class="label">Département de décès :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="deathPostalCode" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
                                                                                                              		}
</script>

