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
   
    

                   <cvq:referenceSelect name="record" property="list(schools)" value="schoolName" 
             scope="page" id="schoolName" styleClass="saisie2" profile="profile"/>
          
    	</span>
       </div>
           <div class="form_cell">
         <label for="section" class="label">Classe :</label>
         <span class="input">
   
    

                   <cvq:referenceSelect name="record" property="list()" value="section"
             scope="page" id="section" styleClass="saisie2" profile="profile">
                   <option value="Très Petite Section">Très Petite Section</option>
                   <option value="Petite Section">Petite Section</option>
                   <option value="Moyenne Section">Moyenne Section</option>
                   <option value="Grande Section">Grande Section</option>
                   <option value="CP">CP</option>
                   <option value="CE1">CE1</option>
                   <option value="CE2">CE2</option>
                   <option value="CM1">CM1</option>
                   <option value="CM2">CM2</option>
                   <option value="CLISS">CLISS</option>
                   <option value="Inconnue">Inconnue</option>
                 </cvq:referenceSelect>
          
    	</span>
       </div>
           <div class="form_cell">
         <label for="perischoolActivity" class="label">Activités périscolaires :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="perischoolActivity"/>
    
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
                                		}
</script>

