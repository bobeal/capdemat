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
         <label for="hopesAndNeeds" class="label">Souhaits et Besoins :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="hopesAndNeeds" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="hopes" class="label">Souhaits :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="hopes" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="needs" class="label">Besoins :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="needs" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="comments" class="label">Observations :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="comments" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="writingHelp" class="label">Aide à la formulation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="writingHelp" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="helperName" class="label">Nom de l'aidant :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="helperName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="helperResponsability" class="label">Fonction de l'aidant :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="helperResponsability" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
              		this.hopesAndNeeds = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                                                                                              		this.writingHelp = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                                                          		}
</script>
 <div class="clear-both"></div>

