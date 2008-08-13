<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Responsible" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="select_row">
			<label for="childLegalResponsibleRole" class="label">Qualité<span class="required">*</span></label>
            <cvqf:select name="childLegalResponsibleRole" mode="">
              <option value="">Choisissez une qualité</option>
              <option value="Father">Père</option>
              <option value="Mother">Mère</option>
              <option value="Tutor">Tuteur</option>
            </cvqf:select>
          </li>
          <li class="select_row">
			<label for="childLegalResponsibleLegalResponsibleTitle" class="label">Civilité<span class="required">*</span></label>
            <cvqf:select name="childLegalResponsibleLegalResponsibleTitle" mode="required">
              <option value="">Choisissez une civilité</option>
              <option value="Mister">Monsieur</option>
              <option value="Madam">Madame</option>
              <option value="Miss">Mademoiselle</option>
              <option value="Agency">Organisme</option>
              <option value="Unknown">Inconnue</option>
            </cvqf:select>
          </li>
          <li class="text_row">
			<label for="childLegalResponsibleLegalResponsibleLastName" class="label">Nom<span class="required">*</span></label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleLastName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="childLegalResponsibleLegalResponsibleFirstName" class="label">Prénom<span class="required">*</span></label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleFirstName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="childLegalResponsibleLegalResponsibleFirstName2" class="label">2ème prénom</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleFirstName2" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="childLegalResponsibleLegalResponsibleFirstName3" class="label">3ème prénom</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleFirstName3" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="childLegalResponsibleLegalResponsibleMaidenName" class="label">Nom de jeune fille</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleMaidenName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="childLegalResponsibleLegalResponsibleNameOfUse" class="label">Nom d'usage</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleNameOfUse" mode="" maxlength="38"/>
          </li>
          <li class="select_row">
			<label for="childLegalResponsibleLegalResponsibleFamilyStatus" class="label">Situation familiale<span class="required">*</span></label>
            <cvqf:select name="childLegalResponsibleLegalResponsibleFamilyStatus" mode="">
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
			<label for="childLegalResponsibleLegalResponsibleBirthDate" class="label">Date de naissance</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleBirthDate" mode="" maxlength="10"/>
            <span class="inline_text">ex: 21/06/1956</span>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Lieu de naissance :</h3>
        <ul class="insert_list">
          <li class="text_row">
			<label for="childLegalResponsibleLegalResponsibleBirthPlaceCity" class="label">Commune</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleBirthPlaceCity" mode="notrequired" maxlength="32"/>
          </li>
          <li class="text_row">
			<label for="childLegalResponsibleLegalResponsibleBirthPlacePostalCode" class="label">Code postal</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleBirthPlacePostalCode" mode="notrequired" maxlength="5"/>
          </li>
          <li class="select_row">
			<label for="childLegalResponsibleLegalResponsibleBirthPlaceCountry" class="label">Pays</label>
            <cvqf:select name="childLegalResponsibleLegalResponsibleBirthPlaceCountry" mode="">
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
   		  this.childLegalResponsibleRole = new Function("key","this.label='Qualité'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleTitle = new Function("key","this.label='Civilité'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleLastName = new Function("key","this.label='Nom'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleFirstName = new Function("key","this.label='Prénom'; this.msg=null; this.required=true; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleFirstName2 = new Function("key","this.label='2ème prénom'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleFirstName3 = new Function("key","this.label='3ème prénom'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleMaidenName = new Function("key","this.label='Nom de jeune fille'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleNameOfUse = new Function("key","this.label='Nom d&quote;usage'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleFamilyStatus = new Function("key","this.label='Situation familiale'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleBirthDate = new Function("key","this.label='Date de naissance'; this.msg=null; this.required=false; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleBirthPlaceCity = new Function("key","this.label='Commune'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleBirthPlacePostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=false; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleBirthPlaceCountry = new Function("key","this.label='Pays'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("childLegalResponsibleRole");
        updateDisplay("childLegalResponsibleLegalResponsibleTitle");
        updateDisplay("childLegalResponsibleLegalResponsibleFamilyStatus");
        updateDisplay("childLegalResponsibleLegalResponsibleBirthPlaceCountry");
  		setFocus("Responsible");
	</script>
