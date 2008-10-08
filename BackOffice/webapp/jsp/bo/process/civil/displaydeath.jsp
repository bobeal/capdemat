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
         <label for="format" class="label">Type de l'acte :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="format" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="copies" class="label">Nombre d'actes souhaité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="copies" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="comment" class="label">Commentaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="comment" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="motive" class="label">Motif :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motive" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="deathLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="deathLastName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="deathFirstNames" class="label">Prénom(s) :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="deathFirstNames" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="deathDate" class="label">Date de décès :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="deathDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="deathCity" class="label">Ville de décès :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="deathCity" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="deathPostalCode" class="label">Département de décès :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="deathPostalCode" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
              		this.format = new Function("key","this.values=new Array('Copie intégrale','Extrait plurilingue'); return this[key];");
                                                                        		this.motive = new Function("key","this.values=new Array('Acte de notaire','Mariage','Passeport','Pension','Autre'); return this[key];");
                                                                                                                            		}
</script>
 <div class="clear-both"></div>

