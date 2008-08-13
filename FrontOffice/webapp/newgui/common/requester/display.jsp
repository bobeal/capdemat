<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Requester" action="#">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
				Civilité
          </p>
          <p class="text">
			<cvqf:select name="requesterTitle" mode="static">
				<option value="">Choisissez un civilité</option>
				<option value="Mister">Monsieur</option>
				<option value="Madam">Madame</option>
				<option value="Miss">Mademoiselle</option>
				<option value="Agency">Organisme</option>
			</cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
				Nom			
          </p>
          <p class="text">
    		<cvqf:text name="requesterLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
				Prénom
          </p>
          <p class="text">
    		<cvqf:text name="requesterFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
				Nom de jeune fille				
          </p>
          <p class="text">
   			<cvqf:text name="requesterMaidenName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
				Date de naissance
          </p>
          <p class="text">
    		<cvqf:text name="requesterBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App.
          </p>
          <p class="text">
    		<cvqf:text name="requesterAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.
          </p>
          <p class="text">
    		<cvqf:text name="requesterAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie
          </p>
          <p class="text">
    		<cvqf:text name="requesterAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale
          </p>
          <p class="text">
    		<cvqf:text name="requesterAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité
          </p>
          <p class="text">
    		<cvqf:text name="requesterAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
				Téléphone				
          </p>
          <p class="text">
    		<cvqf:text name="requesterHomePhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
				Courriel				
          </p>
          <p class="text">
   			<cvqf:text name="requesterEmail" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
   	</cvqf:form>
	<script language="JavaScript">
		function validationData() {
  		}
	</script>
