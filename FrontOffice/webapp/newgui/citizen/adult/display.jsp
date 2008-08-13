<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Adult" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Responsable du compte
          </p>
          <p class="text">
            <cvqf:radio name="accountManager" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Civilité
          </p>
          <p class="text">
            <cvqf:select name="adultTitle" mode="static">
              <option value="">Choisissez une civilité</option>
              <option value="Mister">Monsieur</option>
              <option value="Madam">Madame</option>
              <option value="Miss">Mademoiselle</option>
              <option value="Agency">Organisme</option>
              <option value="Unknown">Inconnue</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom
          </p>
          <p class="text">
            <cvqf:text name="adultLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom
          </p>
          <p class="text">
            <cvqf:text name="adultFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            2ème prénom
          </p>
          <p class="text">
            <cvqf:text name="adultFirstName2" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            3ème prénom
          </p>
          <p class="text">
            <cvqf:text name="adultFirstName3" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom de jeune fille
          </p>
          <p class="text">
            <cvqf:text name="adultMaidenName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom d'usage
          </p>
          <p class="text">
            <cvqf:text name="adultNameOfUse" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Situation familiale
          </p>
          <p class="text">
            <cvqf:select name="adultFamilyStatus" mode="static">
              <option value="">Choisissez un situation familiale</option>
              <option value="Married">Marié(e)</option>
              <option value="Single">Célibataire</option>
              <option value="Divorced">Divorcé(e)</option>
              <option value="Widow">Veuf(ve)</option>
              <option value="CommonLawMarriage">Concubinage</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date de naissance
          </p>
          <p class="text">
            <cvqf:text name="adultBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Ville
          </p>
          <p class="text">
            <cvqf:text name="adultBirthPlaceCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Code postal
          </p>
          <p class="text">
            <cvqf:text name="adultBirthPlacePostalCode" mode="static" maxlength="5"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Adresse				
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App.				
          </p>
          <p class="text">
    		<cvqf:text name="adultAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.				
          </p>
          <p class="text">
    		<cvqf:text name="adultAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie				
          </p>
          <p class="text">
    		<cvqf:text name="adultAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="adultAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale				
          </p>
          <p class="text">
    		<cvqf:text name="adultAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité				
          </p>
          <p class="text">
    		<cvqf:text name="adultAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="adultAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">            
            Domicile
          </p>
          <p class="text">
            <cvqf:text name="adultHomePhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Bureau
          </p>
          <p class="text">
            <cvqf:text name="adultOfficePhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Portable
          </p>
          <p class="text">
            <cvqf:text name="adultMobilePhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Courriel
          </p>
          <p class="text">
            <cvqf:text name="adultEmail" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Numéro CAF
          </p>
          <p class="text">
            <cvqf:text name="adultCfbn" mode="static" maxlength="8"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Profession
          </p>
          <p class="text">
            <cvqf:text name="adultProfession" mode="static"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Adult");
	</script>
