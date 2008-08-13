<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <cvqf:title stage="Subject"/>
      <ul class="validation_list">
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
            Téléphone portable : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultMobilePhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Courriel : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultEmail" mode="static"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Absencedate"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Date de début d'absence : 
          </p>
          <p class="text">
            <cvqf:text name="absenceStartDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Date de fin d'absence : 
          </p>
          <p class="text">
            <cvqf:text name="absenceEndDate" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Rules"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            J'accepte les conditions réglementaire de ce service : 
          </p>
          <p class="text">
            <cvqf:radio name="rulesAndRegulationsAcceptance" mode="static" label="[Oui,Non]" />
          </p>
        </li>
      </ul>
      <cvqf:title stage="Alertphone"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Numero de téléphone en cas d'alerte : 
          </p>
          <p class="text">
            <cvqf:text name="alertPhone" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Othercontact"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nom : 
          </p>
          <p class="text">
            <cvqf:text name="otherContactLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom : 
          </p>
          <p class="text">
            <cvqf:text name="otherContactFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App. :				
          </p>
          <p class="text">
    		<cvqf:text name="otherContactAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés. :				
          </p>
          <p class="text">
    		<cvqf:text name="otherContactAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie :				
          </p>
          <p class="text">
    		<cvqf:text name="otherContactAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="otherContactAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale :				
          </p>
          <p class="text">
    		<cvqf:text name="otherContactAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité :				
          </p>
          <p class="text">
    		<cvqf:text name="otherContactAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="otherContactAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">
            Téléphone : 
          </p>
          <p class="text">
            <cvqf:text name="otherContactPhone" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Securityfacility"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Logement équipé d'alarme : 
          </p>
          <p class="text">
            <cvqf:radio name="alarm" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Logement équipé d'un éclairage automatique : 
          </p>
          <p class="text">
            <cvqf:radio name="light" mode="static" label="[Oui,Non]" />
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
