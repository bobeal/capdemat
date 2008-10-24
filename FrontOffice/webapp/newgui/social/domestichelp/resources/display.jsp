<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Resources" action="#" mode="static">
      <ul class="confirm_list">
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
            Revenus du capital mobilier
          </p>
          <p class="text">
            <cvqf:text name="requesterIncomesRequesterFurnitureInvestmentIncome" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Revenus du capital immobilier
          </p>
          <p class="text">
            <cvqf:text name="requesterIncomesRequesterRealEstateInvestmentIncome" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Salaire ou bénéfice déclaré
          </p>
          <p class="text">
            <cvqf:text name="requesterIncomesRequesterNetIncome" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Resources");
	</script>
