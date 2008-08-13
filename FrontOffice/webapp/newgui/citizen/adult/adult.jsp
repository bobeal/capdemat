<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Adult" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="select_row">
			<label for="adultTitle" class="label">Civilité<span class="required">*</span></label>
            <cvqf:select name="adultTitle" mode="required">
              <option value="">Choisissez une civilité</option>
              <option value="Mister">Monsieur</option>
              <option value="Madam">Madame</option>
              <option value="Miss">Mademoiselle</option>
              <option value="Agency">Organisme</option>
              <option value="Unknown">Inconnue</option>
            </cvqf:select>
          </li>
          <li class="text_row">
			<label for="adultLastName" class="label">Nom<span class="required">*</span></label>
            <cvqf:text name="adultLastName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="adultFirstName" class="label">Prénom<span class="required">*</span></label>
            <cvqf:text name="adultFirstName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="adultFirstName2" class="label">2ème prénom</label>
            <cvqf:text name="adultFirstName2" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="adultFirstName3" class="label">3ème prénom</label>
            <cvqf:text name="adultFirstName3" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="adultMaidenName" class="label">Nom de jeune fille</label>
            <cvqf:text name="adultMaidenName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="adultNameOfUse" class="label">Nom d'usage</label>
            <cvqf:text name="adultNameOfUse" mode="" maxlength="38"/>
          </li>
          <li class="select_row">
			<label for="adultFamilyStatus" class="label">Situation familiale<span class="required">*</span></label>
            <cvqf:select name="adultFamilyStatus" mode="">
              <option value="">Choisissez un situation familiale</option>
              <option value="Married">Marié(e)</option>
              <option value="Single">Célibataire</option>
              <option value="Divorced">Divorcé(e)</option>
              <option value="Widow">Veuf(ve)</option>
              <option value="CommonLawMarriage">Concubinage</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </li>
          <li class="date_row">
			<label for="adultBirthDate" class="label">Date de naissance</label>
            <cvqf:text name="adultBirthDate" mode="" maxlength="10"/>
            <span class="inline_text">ex: 21/06/1956</span>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Lieu de naissance :</h3>
        <ul class="insert_list">
          <li class="text_row">
			<label for="adultBirthPlaceCity" class="label">Commune</label>
            <cvqf:text name="adultBirthPlaceCity" mode="notrequired" maxlength="32"/>
          </li>
          <li class="text_row">
			<label for="adultBirthPlacePostalCode" class="label">Code postal</label>
            <cvqf:text name="adultBirthPlacePostalCode" mode="notrequired" maxlength="5"/>
          </li>
          <li class="select_row">
			<label for="adultBirthPlaceCountry" class="label">Pays</label>
            <cvqf:select name="adultBirthPlaceCountry" mode="">
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
   		  this.adultTitle = new Function("key","this.label='Civilité'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.adultLastName = new Function("key","this.label='Nom'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.adultFirstName = new Function("key","this.label='Prénom'; this.msg=null; this.required=true; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.adultFirstName2 = new Function("key","this.label='2ème prénom'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.adultFirstName3 = new Function("key","this.label='3ème prénom'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.adultMaidenName = new Function("key","this.label='Nom de jeune fille'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.adultNameOfUse = new Function("key","this.label='Nom d&quote;usage'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.adultFamilyStatus = new Function("key","this.label='Situation familiale'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.adultBirthDate = new Function("key","this.label='Date de naissance'; this.msg=null; this.required=false; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.adultBirthPlaceCity = new Function("key","this.label='Commune'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.adultBirthPlacePostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=false; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
     		  this.adultBirthPlaceCountry = new Function("key","this.label='Pays'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("adultTitle");
        updateDisplay("adultFamilyStatus");
        updateDisplay("adultBirthPlaceCountry");
  		setFocus("Adult");
	</script>
