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
         <label for="bulkyWasteType" class="label">Type d'encombrants :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="bulkyWasteType" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="otherWaste" class="label">Autre, préciser :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="otherWaste" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="collectionAddress" class="label">Adresse de collecte :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="collectionAddress" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
              		this.bulkyWasteType = new Function("key","this.multiple=true;this.values=new Array(); return this[key];");
	                                                      		}
</script>
 <div class="clear-both"></div>

