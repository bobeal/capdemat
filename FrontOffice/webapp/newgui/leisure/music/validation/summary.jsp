<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <cvqf:title stage="Student"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectIndividualLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectIndividualFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            2ème prénom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectIndividualFirstName2" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            3ème prénom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectIndividualFirstName3" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Date de naissance : 
          </p>
          <p class="text">
            <cvqf:text name="subjectIndividualBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Sexe : 
          </p>
          <p class="text">
            <cvqf:select name="subjectIndividualSex" mode="static">
              <option value="">Choisissez un sexe</option>
              <option value="Male">Masculin</option>
              <option value="Female">Féminin</option>
              <option value="Unknown">Inconnu</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App. :				
          </p>
          <p class="text">
    		<cvqf:text name="subjectIndividualAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés. :				
          </p>
          <p class="text">
    		<cvqf:text name="subjectIndividualAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie :				
          </p>
          <p class="text">
    		<cvqf:text name="subjectIndividualAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="subjectIndividualAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale :				
          </p>
          <p class="text">
    		<cvqf:text name="subjectIndividualAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité :				
          </p>
          <p class="text">
    		<cvqf:text name="subjectIndividualAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="subjectIndividualAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

      </ul>
      <cvqf:title stage="Activities"/>
      <ul class="validation_list">
          <cvqf:referential name="activity" mode="static" repository="Activity" />
      </ul>
      <cvqf:title stage="Rules"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            J'ai pris connaissance du règlement intérieur de l'école de musique. : 
          </p>
          <p class="text">
            <cvqf:radio name="rulesAndRegulationsAcceptance" mode="static" label="[Oui,Non]" />
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
