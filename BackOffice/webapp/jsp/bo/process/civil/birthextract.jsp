<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
      <fieldset class="fieldset004">
 
         <div class="form_cell">
         <label for="birthLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="birthLastName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="birthFirstNames" class="label">Prénom(s) :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="birthFirstNames" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="birthDate" class="label">Date de naissance :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="birthDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="birthCity" class="label">Ville de naissance :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="birthCity" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="birthPostalCode" class="label">Département de naissance :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="birthPostalCode" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
                                                                                                              		}
</script>

