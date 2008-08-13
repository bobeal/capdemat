<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Child" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="childLastName" class="label">Nom<span class="required">*</span></label>
            <cvqf:text name="childLastName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="childFirstName" class="label">Prénom<span class="required">*</span></label>
            <cvqf:text name="childFirstName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="childFirstName2" class="label">2ème prénom</label>
            <cvqf:text name="childFirstName2" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="childFirstName3" class="label">3ème prénom</label>
            <cvqf:text name="childFirstName3" mode="" maxlength="38"/>
          </li>
          <li class="radio_row_inline">
			<label for="childSex" class="">Sexe<span class="required">*</span></label>
            <cvqf:radio name="childSex" mode="inline">
              <option value="Male">Masculin</option>
              <option value="Female">Féminin</option>
            </cvqf:radio>
		  </li>
          <li class="date_row">
			<label for="childBirthDate" class="label">Date de naissance<span class="required">*</span></label>
            <cvqf:text name="childBirthDate" mode="required" maxlength="10"/>
            <span class="inline_text">ex: 21/06/2001</span>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Lieu de naissance :</h3>
        <ul class="insert_list">
          <li class="text_row">
			<label for="childBirthPlaceCity" class="label">Commune</label>
            <cvqf:text name="childBirthPlaceCity" mode="notrequired" maxlength="32"/>
          </li>
          <li class="text_row">
			<label for="childBirthPlacePostalCode" class="label">Code postal</label>
            <cvqf:text name="childBirthPlacePostalCode" mode="notrequired" maxlength="5"/>
          </li>
          <li class="select_row">
			<label for="childBirthPlaceCountry" class="label">Pays</label>
            <cvqf:select name="childBirthPlaceCountry" mode="">
              <option value="">Choisissez un pays</option>
              <option value="EEC">UE</option>
              <option value="OUTSIDE_EEC">Hors UE</option>
            </cvqf:select>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.childLastName = new Function("key","this.label='Nom'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.childFirstName = new Function("key","this.label='Prénom'; this.msg=null; this.required=true; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.childFirstName2 = new Function("key","this.label='2ème prénom'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.childFirstName3 = new Function("key","this.label='3ème prénom'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.childSex = new Function("key","this.label='Sexe'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.childBirthDate = new Function("key","this.label='Date de naissance'; this.msg=null; this.required=true; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.childBirthPlaceCity = new Function("key","this.label='Commune'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.childBirthPlacePostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=false; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
     		  this.childBirthPlaceCountry = new Function("key","this.label='Pays'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("childSex");
        updateDisplay("childBirthPlaceCountry");
  		setFocus("Child");
	</script>
