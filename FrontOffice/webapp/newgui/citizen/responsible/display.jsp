<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Responsible" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Qualité
          </p>
          <p class="text">
            <cvqf:select name="childLegalResponsibleRole" mode="static">
              <option value="">Choisissez un qualité</option>
              <option value="Father">Père</option>
              <option value="Mother">Mère</option>
              <option value="Tutor">Tuteur</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Civilité
          </p>
          <p class="text">
            <cvqf:select name="childLegalResponsibleLegalResponsibleTitle" mode="static">
              <option value="">Choisissez un civilité</option>
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
            <cvqf:text name="childLegalResponsibleLegalResponsibleLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            2ème prénom
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleFirstName2" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            3ème prénom
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleFirstName3" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom de jeune fille
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleMaidenName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom d'usage
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleNameOfUse" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Situation familiale
          </p>
          <p class="text">
            <cvqf:select name="childLegalResponsibleLegalResponsibleFamilyStatus" mode="static">
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
            <cvqf:text name="childLegalResponsibleLegalResponsibleBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Ville
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleBirthPlaceCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Code postal
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleBirthPlacePostalCode" mode="static" maxlength="5"/>
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
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.				
          </p>
          <p class="text">
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie				
          </p>
          <p class="text">
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale				
          </p>
          <p class="text">
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité				
          </p>
          <p class="text">
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">            
            Domicile
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleHomePhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Bureau
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleOfficePhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Portable
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleMobilePhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Courriel
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleEmail" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Numéro CAF
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleCfbn" mode="static" maxlength="8"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Profession
          </p>
          <p class="text">
            <cvqf:text name="childLegalResponsibleLegalResponsibleProfession" mode="static"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Responsible");
	</script>
