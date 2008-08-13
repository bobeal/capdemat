<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Residence" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="previousDwellingsPreviousDwellingAddressAddress" class="label">Adresse<span class="required">*</span></label>
            <cvqf:text name="previousDwellingsPreviousDwellingAddressAddress" mode="" maxlength="114" rows="3"/>
          </li>
          <li class="town_row">
			<label for="previousDwellingsPreviousDwellingAddressPostalCode" class="label">Code postal, Ville<span class="required">*</span></label>
            <cvqf:text name="previousDwellingsPreviousDwellingAddressPostalCode" mode="" maxlength="5"/>
            <cvqf:text name="previousDwellingsPreviousDwellingAddressCity" mode="" maxlength="32"/>
          </li> 
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
 		  this.previousDwellingsPreviousDwellingAddressAddress = new Function("key","this.label='Adresse'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=114; this.type=null; return this[key];");
 		  this.previousDwellingsPreviousDwellingAddressPostalCode = new Function("key","this.label='Adresse'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
		}
		updateDisplay("previousDwellingsPreviousDwellingAddressPostalCode");
  		setFocus("Residence");
	</script>
