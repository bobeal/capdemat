<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Inscription" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="subjectChildLastName" class="label">Nom</label>
            <cvqf:text name="subjectChildLastName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectChildFirstName" class="label">Prénom</label>
            <cvqf:text name="subjectChildFirstName" mode="disabled" maxlength="38"/>
          </li>
          <li class="date_row">
			<label for="subjectChildBirthDate" class="label">Né(e) le</label>
            <cvqf:text name="subjectChildBirthDate" mode="disabled" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Régime alimentaire :</h3>
        <ul class="insert_list">
          <cvqf:radio name="foodDiet" mode="" repository="FoodDiet" label="[Oui,Non]"/>
          <li class="radio_row_inline">
			<label for="foodAllergy" class="">Allergie<span class="required">*</span></label>
          <cvqf:radio name="foodAllergy" mode="inline" label="[Oui,Non]" />
		  </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Médecin traitant :</h3>
        <ul class="insert_list">
          <li class="text_row">
			<label for="doctorName" class="label">Nom</label>
            <cvqf:text name="doctorName" mode=""/>
          </li>
          <li class="phone_row">
			<label for="doctorPhone" class="label">Téléphone</label>
            <cvqf:text name="doctorPhone" mode="" maxlength="10"/>
            <span class="inline_text">ex: 0102030405</span>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  		  this.foodDiet = new Function("key","this.label='Régime alimentaire'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type='list'; return this[key];");
     		  this.foodAllergy = new Function("key","this.label='Allergie'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.doctorName = new Function("key","this.label='Nom'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.doctorPhone = new Function("key","this.label='Téléphone'; this.msg=null; this.required=false; this.mask=/^0[1-9][0-9]{8}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
        updateDisplay("foodDiet");
        updateDisplay("foodAllergy");
  		setFocus("Inscription");
	</script>
