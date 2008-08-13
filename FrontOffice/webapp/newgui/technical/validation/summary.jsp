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
      <cvqf:title stage="Type"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nature de l'intervention : 
          </p>
          <p class="text">
            <cvqf:select name="interventionType" mode="static" repository="InterventionType">
              <option value="">Choisissez un nature de l'intervention</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App. :				
          </p>
          <p class="text">
    		<cvqf:text name="interventionPlaceAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés. :				
          </p>
          <p class="text">
    		<cvqf:text name="interventionPlaceAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie :				
          </p>
          <p class="text">
    		<cvqf:text name="interventionPlaceStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="interventionPlaceStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale :				
          </p>
          <p class="text">
    		<cvqf:text name="interventionPlacePlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité :				
          </p>
          <p class="text">
    		<cvqf:text name="interventionPlacePostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="interventionPlaceCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

      </ul>
      <cvqf:title stage="Description"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Description de la demande d'intervention : 
          </p>
          <p class="text">
            <cvqf:text name="interventionDescription" mode="static"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
