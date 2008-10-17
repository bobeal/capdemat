<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Capitaltaxes" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
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
   		  this.taxesAmountIncomeTax = new Function("key","this.label='Impôt sur le revenu'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.taxesAmountLocalRate = new Function("key","this.label='Taxe d&quote;habitation'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.taxesAmountPropertyTaxes = new Function("key","this.label='Taxes foncières'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.taxesAmountProfessionalTaxes = new Function("key","this.label='Taxes professionnelles'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
  		setFocus("Capitaltaxes");
	</script>
