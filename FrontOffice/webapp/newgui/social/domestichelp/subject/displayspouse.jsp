<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Civilité
          </p>
          <p class="text">
            <cvqf:select name="requesterSpouseSpouseInformationTitle" mode="static">
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
            Situation familiale
          </p>
          <p class="text">
            <cvqf:select name="requesterSpouseSpouseInformationFamilyStatus" mode="static">
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
            Nom
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom de jeune fille
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationMaidenName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Né(e) le
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Ville
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationBirthPlaceCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nationalité
          </p>
          <p class="text">
            <cvqf:select name="requesterSpouseSpouseNationality" mode="static">
              <option value="">Choisissez un nationalité</option>
              <option value="French">Française</option>
              <option value="EuropeanUnion">Union Européenne</option>
              <option value="OutsideEuropeanUnion">Hors Union Européenne</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date d'arrivée en France
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseFranceArrivalDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Je réside en France depuis plus de 15 ans de manière continue
          </p>
          <p class="text">
            <cvqf:radio name="requesterSpouseSpouseMoreThan15YearsInFrance" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Retraité
          </p>
          <p class="text">
            <cvqf:radio name="requesterSpouseSpousePensionner" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Régime de retraite principal
          </p>
          <p class="text">
            <cvqf:select name="requesterSpouseSpousePensionPlan" mode="static">
              <option value="">Choisissez un régime de retraite principal</option>
              <option value="CRAMIF">CRAMIF</option>
              <option value="CNAV">CNAV</option>
              <option value="MSA">MSA</option>
              <option value="CRAM">CRAM</option>
              <option value="MGEN">MGEN</option>
              <option value="SNCF">SNCF</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Préciser
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpousePensionPlanPrecision" mode="static" maxlength="50"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Régime de retraite complémentaire
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseComplementaryPensionPlanPrecision" mode="static" maxlength="50"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Profession
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseOccupation" mode="static" maxlength="50"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Employeur
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseEmployer" mode="static" maxlength="50"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App.				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Subject");
	</script>
