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
         <label for"" class="label temp_title_class">Montant d'imposition</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="taxesAmountIncomeTax" class="label">Impôt sur le revenu :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="taxesAmountIncomeTax" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="taxesAmountLocalRate" class="label">Taxe d'habitation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="taxesAmountLocalRate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="taxesAmountPropertyTaxes" class="label">Taxes foncières :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="taxesAmountPropertyTaxes" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="taxesAmountProfessionalTaxes" class="label">Taxes professionnelles :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="taxesAmountProfessionalTaxes" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="taxesAmountTaxesTotal" class="label">Total des impôts et taxes :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="taxesAmountTaxesTotal" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                                                                                                                    		}
</script>
 <div class="clear-both"></div>

