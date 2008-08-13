<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Resources" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="requesterIncomesRequesterPensions" class="label">Pensions et retraites</label>
            <cvqf:text name="requesterIncomesRequesterPensions" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="requesterIncomesRequesterAllowances" class="label">Allocations diverses</label>
            <cvqf:text name="requesterIncomesRequesterAllowances" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="requesterIncomesRequesterInvestmentIncome" class="label">Revenus du capital</label>
            <cvqf:text name="requesterIncomesRequesterInvestmentIncome" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="requesterIncomesRequesterNetIncome" class="label">Salaire</label>
            <cvqf:text name="requesterIncomesRequesterNetIncome" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.requesterIncomesRequesterPensions = new Function("key","this.label='Pensions et retraites'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.requesterIncomesRequesterAllowances = new Function("key","this.label='Allocations diverses'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.requesterIncomesRequesterInvestmentIncome = new Function("key","this.label='Revenus du capital'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.requesterIncomesRequesterNetIncome = new Function("key","this.label='Salaire'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
  		setFocus("Resources");
	</script>
