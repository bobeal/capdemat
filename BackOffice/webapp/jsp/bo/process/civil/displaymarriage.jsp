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
         <label for="usage" class="label">Usage :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="usage" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterQuality" class="label">Qualité du demandeur :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterQuality" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterQualityPrecision" class="label">Précision :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterQualityPrecision" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="marriageHusbandLastName" class="label">Nom de l'époux :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageHusbandLastName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="marriageHusbandFirstNames" class="label">Prénom(s) de l'époux :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageHusbandFirstNames" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="marriageWifeLastName" class="label">Nom de l'épouse :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageWifeLastName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="marriageWifeFirstNames" class="label">Prénom(s) de l'épouse :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageWifeFirstNames" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="marriageDate" class="label">Date de mariage :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="marriageCity" class="label">Ville de mariage :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriageCity" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="marriagePostalCode" class="label">Département de mariage :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="marriagePostalCode" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="relationship" class="label">Filiation de :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="relationship" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="fatherLastName" class="label">Nom du père :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="fatherLastName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="fatherFirstNames" class="label">Prénom(s) du père :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="fatherFirstNames" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="motherMaidenName" class="label">Nom de jeune fille de la mère :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motherMaidenName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="motherFirstNames" class="label">Prénom(s) de la mère :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motherFirstNames" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
              		this.format = new Function("key","this.values=new Array('Copie intégrale','Extrait avec filiation','Extrait sans filiation'); return this[key];");
                                                                        		this.requesterQuality = new Function("key","this.values=new Array('Titulaire de l&rsquo;acte','Son conjoint','Son père / sa mère','Son grand-père / sa grand-mère','Son fils / sa fille','Son représentant légal','Son mandataire','Son héritier et aussi son frère ou sa soeur','Son héritier sans être son frère ou sa soeur','Autorisé par le procureur de la République','Avocat, notaire','Autre'); return this[key];");
                                                                                                                                                                                                            		this.relationship = new Function("key","this.values=new Array('L&rsquo;époux','L&rsquo;épouse'); return this[key];");
                                                                                                      		}
</script>
 <div class="clear-both"></div>

