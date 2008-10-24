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
 
         <div class="form_cell">
         <label for"" class="label temp_title_class">Demande</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterRequestKind" class="label">Type de la demande :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterRequestKind" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                    		this.requesterRequestKind = new Function("key","this.values=new Array('Individuelle','Couple'); return this[key];");
              		}
</script>
 <div class="clear-both"></div>

