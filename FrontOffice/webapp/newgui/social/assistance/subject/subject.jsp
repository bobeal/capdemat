<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="subjectAdultLastName" class="label">Nom</label>
            <cvqf:text name="subjectAdultLastName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectAdultFirstName" class="label">Prénom</label>
            <cvqf:text name="subjectAdultFirstName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectAdultFirstName2" class="label">Prénom</label>
            <cvqf:text name="subjectAdultFirstName2" mode="disabled" maxlength="38"/>
          </li>
          <li class="select_row">
			<label for="subjectAdultSex" class="label">Sexe</label>
            <cvqf:select name="subjectAdultSex" mode="disabled">
              <option value="">Choisissez un sexe</option>
              <option value="Male">Masculin</option>
              <option value="Female">Féminin</option>
              <option value="Unknown">Inconnu</option>
            </cvqf:select>
          </li>
          <li class="date_row">
			<label for="subjectAdultBirthDate" class="label">Né(e) le</label>
            <cvqf:text name="subjectAdultBirthDate" mode="disabled" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="subjectAdultAddressStreetName" class="label">Type et nom de voie</label>
            <cvqf:text name="subjectAdultAddressStreetName" mode="disabled"/>
          </li>
          <li class="phone_row">
			<label for="subjectAdultHomePhone" class="label">Téléphone domicile</label>
            <cvqf:text name="subjectAdultHomePhone" mode="disabled" maxlength="10"/>
          </li>
          <li class="select_row">
			<label for="dwelling" class="label">Type d'habitation<span class="required">*</span></label>
            <cvqf:select name="dwelling" mode="">
              <option value="">Choisissez un type d'habitation</option>
              <option value="Appartment">Appartement</option>
              <option value="House">Pavillon</option>
            </cvqf:select>
          </li>
        </ul>
        <ul class="insert_list" id="Appartment">
          <li class="text_row">
			<label for="appartmentNumber" class="label">Numéro<span class="required">*</span></label>
            <cvqf:text name="appartmentNumber" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="floor" class="label">Etage<span class="required">*</span></label>
            <cvqf:text name="floor" mode="" maxlength="10"/>
          </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
          <li class="radio_row_inline">
			<label for="taxable" class="">Imposable<span class="required">*</span></label>
          <cvqf:radio name="taxable" mode="inline" label="[Oui,Non]" />
		  </li>
          <li class="radio_row_inline">
			<label for="seniorAssitanceBeneficiary" class="">Bénéficiaire APA<span class="required">*</span></label>
          <cvqf:radio name="seniorAssitanceBeneficiary" mode="inline" label="[Oui,Non]" />
		  </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.dwelling = new Function("key","this.label='Type d&quote;habitation'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.appartmentNumber = new Function("key","this.label='Numéro'; this.msg=null; this.required=true; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.floor = new Function("key","this.label='Etage'; this.msg=null; this.required=true; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.taxable = new Function("key","this.label='Imposable'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.seniorAssitanceBeneficiary = new Function("key","this.label='Bénéficiaire APA'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("dwelling");
        updateDisplay("taxable");
        updateDisplay("seniorAssitanceBeneficiary");
  		setFocus("Subject");
	</script>
