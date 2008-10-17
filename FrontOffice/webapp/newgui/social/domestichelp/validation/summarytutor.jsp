<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <ul class="validation_list">
      </ul>
      <cvqf:title stage="Tuteur"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Présence tuteur : 
          </p>
          <p class="text">
            <cvqf:radio name="requesterSituationTutorPresence" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Mesure tuteur : 
          </p>
          <p class="text">
            <cvqf:select name="requesterSituationTutor" mode="static">
              <option value="">Choisissez un mesure tuteur</option>
              <option value="SauvegardeJustice">Sauvegarde de Justice</option>
              <option value="Tutelle">Tutelle</option>
              <option value="Curatelle">Curatelle</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom du tuteur ou de l'association : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSituationTutorName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App. :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSituationTutorAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés. :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSituationTutorAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSituationTutorAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterSituationTutorAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSituationTutorAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSituationTutorAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterSituationTutorAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
