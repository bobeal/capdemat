<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Capitaltaxes" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Montant actions
          </p>
          <p class="text">
            <cvqf:text name="capitalsSharesAmount" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Montant obligations
          </p>
          <p class="text">
            <cvqf:text name="capitalsBondsAmount" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Impôt sur le revenu
          </p>
          <p class="text">
            <cvqf:text name="taxesAmountIncomeTax" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Taxe d'habitation
          </p>
          <p class="text">
            <cvqf:text name="taxesAmountLocalRate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Taxes foncières
          </p>
          <p class="text">
            <cvqf:text name="taxesAmountPropertyTaxes" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Taxes professionnelles
          </p>
          <p class="text">
            <cvqf:text name="taxesAmountProfessionalTaxes" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Capitaltaxes");
	</script>
