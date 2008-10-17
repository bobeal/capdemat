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
         <label for"" class="label temp_title_class">Référent du demandeur</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterFamilyReferentFamilyReferentDesignated" class="label">Référent familial :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterFamilyReferentFamilyReferentDesignated" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterFamilyReferentFamilyReferentName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterFamilyReferentFamilyReferentName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterFamilyReferentFamilyReferentFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterFamilyReferentFamilyReferentFirstName" id="id" profile="profile"/>
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterFamilyReferentFamilyReferentAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterFamilyReferentFamilyReferentAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterFamilyReferentFamilyReferentAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterFamilyReferentFamilyReferentAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterFamilyReferentFamilyReferentAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterFamilyReferentFamilyReferentAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterFamilyReferentFamilyReferentAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterFamilyReferentFamilyReferentAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterFamilyReferentFamilyReferentAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterFamilyReferentFamilyReferentAddressCity" id="id" profile="profile" />
         </span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                    		this.requesterFamilyReferentFamilyReferentDesignated = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                                                                                		}
</script>
 <div class="clear-both"></div>

