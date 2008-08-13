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
      <cvqf:title stage="Needs"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Souhaits et Besoins : 
          </p>
          <p class="text">
            <cvqf:radio name="hopesAndNeeds" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Souhaits : 
          </p>
          <p class="text">
            <cvqf:text name="hopes" mode="static" rows="3"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Besoins : 
          </p>
          <p class="text">
            <cvqf:text name="needs" mode="static" rows="3"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Observations : 
          </p>
          <p class="text">
            <cvqf:text name="comments" mode="static" rows="3"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Help"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Aide à la formulation : 
          </p>
          <p class="text">
            <cvqf:radio name="writingHelp" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom de l'aidant : 
          </p>
          <p class="text">
            <cvqf:text name="helperName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Fonction de l'aidant : 
          </p>
          <p class="text">
            <cvqf:text name="helperResponsability" mode="static"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Legal"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Représentant légal : 
          </p>
          <p class="text">
            <cvqf:radio name="legalRepresentative" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom du représentant légal : 
          </p>
          <p class="text">
            <cvqf:text name="legalRepresentativeName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom du représentant légal : 
          </p>
          <p class="text">
            <cvqf:text name="legalRepresentativeFirstame" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Lien de parenté du représentant légal : 
          </p>
          <p class="text">
            <cvqf:text name="legalRepresentativeFamilyRelationship" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App. :				
          </p>
          <p class="text">
    		<cvqf:text name="legalRepresentativeAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés. :				
          </p>
          <p class="text">
    		<cvqf:text name="legalRepresentativeAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie :				
          </p>
          <p class="text">
    		<cvqf:text name="legalRepresentativeAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="legalRepresentativeAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale :				
          </p>
          <p class="text">
    		<cvqf:text name="legalRepresentativeAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité :				
          </p>
          <p class="text">
    		<cvqf:text name="legalRepresentativeAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="legalRepresentativeAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">
            Téléphone du représentant légal : 
          </p>
          <p class="text">
            <cvqf:text name="legalRepresentativePhone" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
