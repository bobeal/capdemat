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
         <label for"" class="label temp_title_class">Ressources du demandeur</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterIncomesRequesterPensions" class="label">Pensions et retraites :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterIncomesRequesterPensions" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterIncomesRequesterAllowances" class="label">Allocations diverses :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterIncomesRequesterAllowances" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterIncomesRequesterFurnitureInvestmentIncome" class="label">Revenus du capital mobilier :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterIncomesRequesterFurnitureInvestmentIncome" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterIncomesRequesterRealEstateInvestmentIncome" class="label">Revenus du capital immobilier :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterIncomesRequesterRealEstateInvestmentIncome" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterIncomesRequesterNetIncome" class="label">Salaire ou bénéfice déclaré :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterIncomesRequesterNetIncome" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterIncomesRequesterIncomesAnnualTotal" class="label">Total annuel :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterIncomesRequesterIncomesAnnualTotal" id="id" profile="profile"/>
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

