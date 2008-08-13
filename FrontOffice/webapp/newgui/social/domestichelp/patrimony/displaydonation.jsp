<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Patrimony" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Nature du bien
          </p>
          <p class="text">
            <cvqf:select name="donationsDonationAsset" mode="static">
              <option value="">Choisissez un nature du bien</option>
              <option value="Immobilier">Immobilier</option>
              <option value="Autre">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Lieu
          </p>
          <p class="text">
            <cvqf:text name="donationsDonationAssetPlace" mode="static" maxlength="200"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom du bénéficiaire
          </p>
          <p class="text">
            <cvqf:text name="donationsDonationBeneficiaryName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom du bénéficiaire
          </p>
          <p class="text">
            <cvqf:text name="donationsDonationBeneficiaryFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Valeur de la donation
          </p>
          <p class="text">
            <cvqf:text name="donationsDonationValue" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date de la donation
          </p>
          <p class="text">
            <cvqf:text name="donationsDonationDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom du notaire
          </p>
          <p class="text">
            <cvqf:text name="donationsDonationNotaryName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom du notaire
          </p>
          <p class="text">
            <cvqf:text name="donationsDonationNotaryFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App.				
          </p>
          <p class="text">
    		<cvqf:text name="donationsDonationNotaryAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.				
          </p>
          <p class="text">
    		<cvqf:text name="donationsDonationNotaryAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie				
          </p>
          <p class="text">
    		<cvqf:text name="donationsDonationNotaryAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="donationsDonationNotaryAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale				
          </p>
          <p class="text">
    		<cvqf:text name="donationsDonationNotaryAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité				
          </p>
          <p class="text">
    		<cvqf:text name="donationsDonationNotaryAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="donationsDonationNotaryAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Patrimony");
	</script>
