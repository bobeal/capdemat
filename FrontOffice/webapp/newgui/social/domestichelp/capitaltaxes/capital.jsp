<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Capitaltaxes" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Informations concernant les revenus de placements et taxes du foyer :</h3>
        <ul class="insert_list">
          <li class="text_row">
			<label for="capitalsSharesAmount" class="label">Montant actions</label>
            <cvqf:text name="capitalsSharesAmount" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="capitalsBondsAmount" class="label">Montant obligations</label>
            <cvqf:text name="capitalsBondsAmount" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="taxesAmountIncomeTax" class="label">Impôt sur le revenu</label>
            <cvqf:text name="taxesAmountIncomeTax" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="taxesAmountLocalRate" class="label">Taxe d'habitation</label>
            <cvqf:text name="taxesAmountLocalRate" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="taxesAmountPropertyTaxes" class="label">Taxes foncières</label>
            <cvqf:text name="taxesAmountPropertyTaxes" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="taxesAmountProfessionalTaxes" class="label">Taxes professionnelles</label>
            <cvqf:text name="taxesAmountProfessionalTaxes" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.capitalsSharesAmount = new Function("key","this.label='Montant actions'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.capitalsBondsAmount = new Function("key","this.label='Montant obligations'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.taxesAmountIncomeTax = new Function("key","this.label='Impôt sur le revenu'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.taxesAmountLocalRate = new Function("key","this.label='Taxe d&quote;habitation'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.taxesAmountPropertyTaxes = new Function("key","this.label='Taxes foncières'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.taxesAmountProfessionalTaxes = new Function("key","this.label='Taxes professionnelles'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
  		setFocus("Capitaltaxes");
	</script>
