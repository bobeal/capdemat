<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Previousresidence" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App.				
          </p>
          <p class="text">
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.				
          </p>
          <p class="text">
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie				
          </p>
          <p class="text">
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale				
          </p>
          <p class="text">
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité				
          </p>
          <p class="text">
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">            
            Date d'arrivée
          </p>
          <p class="text">
            <cvqf:text name="previousDwellingsPreviousDwellingArrivalDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date de départ
          </p>
          <p class="text">
            <cvqf:text name="previousDwellingsPreviousDwellingDepartureDate" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Previousresidence");
	</script>
