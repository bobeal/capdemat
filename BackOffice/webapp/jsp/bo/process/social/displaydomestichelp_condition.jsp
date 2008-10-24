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
         <label for="requesterHasSpouse" class="label">Variable permettant de savoir si le demandeur possede un conjoint :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterHasSpouse" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
              		this.requesterHasSpouse = new Function("key","this.values=new Array('True','False'); return this[key];");
              		}
</script>
 <div class="clear-both"></div>

