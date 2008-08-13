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
 
         <div class="form_cell form_cell1 form_cell2">
         <label for="placeReservation" class="label">Places réservées :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="placeReservation" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="isSubscriber" class="label">Est abonné :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="isSubscriber"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subscriberNumber" class="label">Numéro d'abonné :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subscriberNumber"/>
    
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
              		this.placeReservation = new Function("key","this.multiple=true;this.values=new Array(); return this[key];");
	              		}
</script>
 <div class="clear-both"></div>

