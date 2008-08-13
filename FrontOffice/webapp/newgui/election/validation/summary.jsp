<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <cvqf:title stage="Subject"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            2ème prénom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultFirstName2" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            3ème prénom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultFirstName3" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Date de naissance : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App. :				
          </p>
          <p class="text">
    		<cvqf:text name="subjectAdultAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés. :				
          </p>
          <p class="text">
    		<cvqf:text name="subjectAdultAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie :				
          </p>
          <p class="text">
    		<cvqf:text name="subjectAdultAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="subjectAdultAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale :				
          </p>
          <p class="text">
    		<cvqf:text name="subjectAdultAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité :				
          </p>
          <p class="text">
    		<cvqf:text name="subjectAdultAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="subjectAdultAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">
            Sexe : 
          </p>
          <p class="text">
            <cvqf:select name="subjectAdultSex" mode="static">
              <option value="">Choisissez un sexe</option>
              <option value="Male">Masculin</option>
              <option value="Female">Féminin</option>
              <option value="Unknown">Inconnu</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nationalité : 
          </p>
          <p class="text">
            <cvqf:select name="subjectNationality" mode="static" repository="Nationality">
              <option value="">Choisissez un nationalité</option>
            </cvqf:select>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Reason"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Raison de la demande : 
          </p>
          <p class="text">
            <cvqf:radio name="motive" mode="static">
              <option value="NewCityResident">Domicilié dans la commune ou y habitant depuis six mois au moins</option>
              <option value="DirectCityContribution">Participe aux contributions directes communales pour la cinquième fois sans interruption</option>
              <option value="CivilServantObligatoryResident">Fonctionnaire public assujetti à résidence obligatoire dans la commune</option>
              <option value="FutureAuthorizedCitizen">Ne remplit pas actuellement les conditions d'âge et de résidence mais les remplira d'ici la clôture définitive des listes</option>
            </cvqf:radio>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
