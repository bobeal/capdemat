<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Patrimony" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="taxesAmountIncomeTax" class="label">Impôt sur le revenu</label>
            <cvqf:text name="taxesAmountIncomeTax" mode="" maxlength="5"/>
          </li>
          <li class="text_row">
			<label for="taxesAmountLocalRate" class="label">Taxe d'habiation</label>
            <cvqf:text name="taxesAmountLocalRate" mode="" maxlength="5"/>
          </li>
          <li class="text_row">
			<label for="taxesAmountPropertyTaxes" class="label">Taxes foncières</label>
            <cvqf:text name="taxesAmountPropertyTaxes" mode="" maxlength="5"/>
          </li>
          <li class="text_row">
			<label for="taxesAmountProfessionalTaxes" class="label">Taxes professionnelles</label>
            <cvqf:text name="taxesAmountProfessionalTaxes" mode="" maxlength="5"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
 		  this.taxesAmountIncomeTax = new Function("key","this.label='Impôt sur le revenu'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
 		  this.taxesAmountLocalRate = new Function("key","this.label='Taxe d&quote;habiation'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
 		  this.taxesAmountPropertyTaxes = new Function("key","this.label='Taxes foncières'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
 		  this.taxesAmountProfessionalTaxes = new Function("key","this.label='Taxes professionnelles'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
		}
  		setFocus("Patrimony");
	</script>
