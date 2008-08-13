<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
      <fieldset class="fieldset004">
 
         <div class="form_cell">
         <label for="requesterLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterLastName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="requesterFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="isSubscriber" class="label">Est abonné :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="isSubscriber"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="subscriberNumber" class="label">Numéro d'abonné :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subscriberNumber"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for="paymentReference" class="label">Référence du paiement :</label>
         <span class="input">
   
    

          	 <cvq:input name="record" property="paymentReference" scope="page" type="text"
	     styleClass="saisie" profile="profile"/>
          
    	</span>
       </div>
       </fieldset>
 </div>

<script type="text/javascript">
	function selectionData() {
                    		}
</script>

