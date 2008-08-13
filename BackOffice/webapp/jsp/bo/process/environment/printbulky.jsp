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
         <label for="bulkyWasteType" class="label">Type d'encombrants :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="bulkyWasteType"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="otherWaste" class="label">Autre, préciser :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="otherWaste"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="collectionAddress" class="label">Adresse de collecte :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="collectionAddress"/>
    
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
          		}
</script>

