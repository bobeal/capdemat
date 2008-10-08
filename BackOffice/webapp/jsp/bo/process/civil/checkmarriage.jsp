<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
      <fieldset class="fieldset004">
 
         <div class="form_cell">
         <label for="format" class="label">Type de l'acte :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="format"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="copies" class="label">Nombre d'actes souhaité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="copies"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="comment" class="label">Commentaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="comment"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="motive" class="label">Motif :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motive"/>
    
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
        		}
</script>

