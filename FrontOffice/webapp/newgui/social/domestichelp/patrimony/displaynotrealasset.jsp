<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Patrimony" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Type
          </p>
          <p class="text">
            <cvqf:radio name="notRealAssetsAssetType" mode="static">
              <option value="Share">Partage</option>
              <option value="Gift">Donation</option>
              <option value="Sale">Vente</option>
            </cvqf:radio>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nature du bien
          </p>
          <p class="text">
            <cvqf:radio name="notRealAssetsAssetKind" mode="static">
              <option value="RealEstate">Immobilier</option>
              <option value="Other">Autre</option>
            </cvqf:radio>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App.				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="notRealAssetsAssetAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="notRealAssetsAssetAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">            
            Nom du bénéficiaire
          </p>
          <p class="text">
            <cvqf:text name="notRealAssetsAssetBeneficiaryName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom du bénéficiaire
          </p>
          <p class="text">
            <cvqf:text name="notRealAssetsAssetBeneficiaryFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App.				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">            
            Valeur déclarée
          </p>
          <p class="text">
            <cvqf:text name="notRealAssetsAssetValue" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date partage, donation ou vente
          </p>
          <p class="text">
            <cvqf:text name="notRealAssetsAssetDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom du notaire
          </p>
          <p class="text">
            <cvqf:text name="notRealAssetsAssetNotaryName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App.				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetNotaryAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="notRealAssetsAssetNotaryAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetNotaryAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité				
          </p>
          <p class="text">
    		<cvqf:text name="notRealAssetsAssetNotaryAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="notRealAssetsAssetNotaryAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Patrimony");
	</script>
