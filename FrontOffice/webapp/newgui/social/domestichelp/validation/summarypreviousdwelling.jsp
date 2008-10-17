<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <ul class="validation_list">
      </ul>
      <cvqf:title stage="Habitation antérieure"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App. :				
          </p>
          <p class="text">
    		<cvqf:text name="previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés. :				
          </p>
          <p class="text">
    		<cvqf:text name="previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie :				
          </p>
          <p class="text">
    		<cvqf:text name="previousDwellingPreviousDwellingAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="previousDwellingPreviousDwellingAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale :				
          </p>
          <p class="text">
    		<cvqf:text name="previousDwellingPreviousDwellingAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité :				
          </p>
          <p class="text">
    		<cvqf:text name="previousDwellingPreviousDwellingAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="previousDwellingPreviousDwellingAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">
            Date d'arrivée : 
          </p>
          <p class="text">
            <cvqf:text name="previousDwellingPreviousDwellingArrivalDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Date de départ : 
          </p>
          <p class="text">
            <cvqf:text name="previousDwellingPreviousDwellingDepartureDate" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
