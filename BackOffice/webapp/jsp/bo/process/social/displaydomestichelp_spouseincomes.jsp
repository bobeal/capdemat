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
         <label for"" class="label temp_title_class">Ressources du conjoint</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseIncomesSpousePensions" class="label">Pensions et retraites :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseIncomesSpousePensions" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseIncomesSpouseAllowances" class="label">Allocations diverses :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseIncomesSpouseAllowances" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseIncomesSpouseFurnitureInvestmentIncome" class="label">Revenus du capital mobilier :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseIncomesSpouseFurnitureInvestmentIncome" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseIncomesSpouseRealEstateInvestmentIncome" class="label">Revenus du capital immobilier :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseIncomesSpouseRealEstateInvestmentIncome" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseIncomesSpouseNetIncome" class="label">Salaire ou bénéfice déclaré :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseIncomesSpouseNetIncome" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseIncomesSpouseIncomesAnnualTotal" class="label">Total annuel :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseIncomesSpouseIncomesAnnualTotal" id="id" profile="profile"/>
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

