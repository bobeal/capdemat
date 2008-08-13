<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nom du propriétaire : 
          </p>
          <p class="text">
            <cvqf:text name="ownerLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom(s) : 
          </p>
          <p class="text">
            <cvqf:text name="ownerFirstNames" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App. :				
          </p>
          <p class="text">
    		<cvqf:text name="ownerAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés. :				
          </p>
          <p class="text">
    		<cvqf:text name="ownerAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie :				
          </p>
          <p class="text">
    		<cvqf:text name="ownerAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="ownerAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale :				
          </p>
          <p class="text">
    		<cvqf:text name="ownerAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité :				
          </p>
          <p class="text">
    		<cvqf:text name="ownerAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="ownerAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
