<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Resources" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">
				Le demandeur				
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Pensions et retraites
          </p>
          <p class="text">
            <cvqf:text name="requesterIncomesRequesterPensions" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Allocations diverses
          </p>
          <p class="text">
            <cvqf:text name="requesterIncomesRequesterAllowances" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Revenus du capital
          </p>
          <p class="text">
            <cvqf:text name="requesterIncomesRequesterInvestmentIncome" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Salaire
          </p>
          <p class="text">
            <cvqf:text name="requesterIncomesRequesterNetIncome" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Le conjoint				
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Pensions et retraites
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseIncomesSpousePensions" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Allocations diverses
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseIncomesSpouseAllowances" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Revenus du capital
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseIncomesSpouseInvestmentIncome" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Salaire
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseIncomesSpouseNetIncome" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Resources");
	</script>
