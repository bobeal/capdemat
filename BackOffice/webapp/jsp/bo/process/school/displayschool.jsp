<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
    <div class="block009">
     <p class="text005 pictoTable">Formulaire</p>
   </div>
   <div class="block010">
     <fieldset class="fieldset005">
 
         <div class="form_cell form_cell1">
         <label for="subjectChildLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildLastName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectChildFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="urgencyPhone" class="label">Téléphone en cas d'urgence :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="urgencyPhone" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentSchoolName" class="label">Nom de l'école actuelle :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentSchoolName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentSection" class="label">Classe actuelle :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentSection" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentSchoolAddress" class="label">Adresse de l'école actuelle :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentSchoolAddress" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="rulesAndRegulationsAcceptance" class="label">Acceptation du règlement intérieur :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="rulesAndRegulationsAcceptance" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                                                              		this.currentSection = new Function("key","this.values=new Array('Très Petite Section','Petite Section','Moyenne Section','Grande Section','CP','CE1','CE2','CM1','CM2','CLISS','Inconnue'); return this[key];");
                                                  		this.rulesAndRegulationsAcceptance = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
              		}
</script>
 <div class="clear-both"></div>

