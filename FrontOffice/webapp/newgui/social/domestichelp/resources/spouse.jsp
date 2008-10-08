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
			<label for="requesterSpouseIncomesSpouseInvestmentIncome" class="label">Revenus du capital</label>
            <cvqf:text name="requesterSpouseIncomesSpouseInvestmentIncome" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="requesterSpouseIncomesSpouseNetIncome" class="label">Salaire</label>
            <cvqf:text name="requesterSpouseIncomesSpouseNetIncome" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.requesterSpouseIncomesSpousePensions = new Function("key","this.label='Pensions et retraites'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.requesterSpouseIncomesSpouseAllowances = new Function("key","this.label='Allocations diverses'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.requesterSpouseIncomesSpouseInvestmentIncome = new Function("key","this.label='Revenus du capital'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.requesterSpouseIncomesSpouseNetIncome = new Function("key","this.label='Salaire'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
  		setFocus("Resources");
	</script>
