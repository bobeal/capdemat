<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
      <fieldset class="fieldset004">
 
         <div class="form_cell">
         <label for="marriageHusbandLastName" class="label">Nom de l'époux :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageHusbandLastName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="marriageHusbandFirstNames" class="label">Prénom(s) de l'époux :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageHusbandFirstNames" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="marriageWifeLastName" class="label">Nom de l'épouse :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageWifeLastName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="marriageWifeFirstNames" class="label">Prénom(s) de l'épouse :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageWifeFirstNames" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="marriageDate" class="label">Date de mariage :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="marriageCity" class="label">Ville de mariage :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageCity" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for="marriagePostalCode" class="label">Département de mariage :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriagePostalCode" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
                                                                                                                                                          		}
</script>

