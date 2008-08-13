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
         <label for="requesterQuality" class="label">Agissant en qualité de :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterQuality" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="section" class="label">Section :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="section" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="number" class="label">Numéro :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="number" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="locality" class="label">Lieu-dit :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="locality" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="transportationRoute" class="label">Voie de communication :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="transportationRoute" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="moreThanTwoYears" class="label">Immeuble de plus de 2 ans :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="moreThanTwoYears" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
              		this.requesterQuality = new Function("key","this.values=new Array('Propriétaire','Locataire'); return this[key];");
                                                                                                                    		this.moreThanTwoYears = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
              		}
</script>
 <div class="clear-both"></div>

