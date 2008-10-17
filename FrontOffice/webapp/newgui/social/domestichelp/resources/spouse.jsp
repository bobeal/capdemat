<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Resources" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="requesterSpouseIncomesSpousePensions" class="label">Pensions et retraites</label>
            <cvqf:text name="requesterSpouseIncomesSpousePensions" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="requesterSpouseIncomesSpouseAllowances" class="label">Allocations diverses</label>
            <cvqf:text name="requesterSpouseIncomesSpouseAllowances" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="requesterSpouseIncomesSpouseFurnitureInvestmentIncome" class="label">Revenus du capital mobilier</label>
            <cvqf:text name="requesterSpouseIncomesSpouseFurnitureInvestmentIncome" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="requesterSpouseIncomesSpouseRealEstateInvestmentIncome" class="label">Revenus du capital immobilier</label>
            <cvqf:text name="requesterSpouseIncomesSpouseRealEstateInvestmentIncome" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="requesterSpouseIncomesSpouseNetIncome" class="label">Salaire ou bénéfice déclaré</label>
            <cvqf:text name="requesterSpouseIncomesSpouseNetIncome" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.requesterSpouseIncomesSpousePensions = new Function("key","this.label='Pensions et retraites'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.requesterSpouseIncomesSpouseAllowances = new Function("key","this.label='Allocations diverses'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome = new Function("key","this.label='Revenus du capital mobilier'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome = new Function("key","this.label='Revenus du capital immobilier'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.requesterSpouseIncomesSpouseNetIncome = new Function("key","this.label='Salaire ou bénéfice déclaré'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
  		setFocus("Resources");
	</script>
