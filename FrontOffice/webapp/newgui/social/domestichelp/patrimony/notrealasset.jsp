<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Patrimony" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row_inline">
			<label for="notRealAssetsAssetType" class="">Type<span class="required">*</span></label>
            <cvqf:radio name="notRealAssetsAssetType" mode="inline">
              <option value="Share">Partage</option>
              <option value="Gift">Donation</option>
              <option value="Sale">Vente</option>
            </cvqf:radio>
		  </li>
          <li class="radio_row_inline">
			<label for="notRealAssetsAssetKind" class="">Nature du bien<span class="required">*</span></label>
            <cvqf:radio name="notRealAssetsAssetKind" mode="inline">
              <option value="RealEstate">Immobilier</option>
              <option value="Other">Autre</option>
            </cvqf:radio>
		  </li>
        </ul>
        <ul class="insert_list" id="RealEstate">
          <li class="text_row">
  			<label for="notRealAssetsAssetAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="notRealAssetsAssetAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="notRealAssetsAssetAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="notRealAssetsAssetAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="notRealAssetsAssetAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="notRealAssetsAssetAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="notRealAssetsAssetAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="notRealAssetsAssetAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="notRealAssetsAssetAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="notRealAssetsAssetAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="notRealAssetsAssetAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="notRealAssetsAssetAddressCity" mode="" maxlength="32" size="35"/>
          </li>

        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
          <li class="text_row">
			<label for="notRealAssetsAssetBeneficiaryName" class="label">Nom du bénéficiaire<span class="required">*</span></label>
            <cvqf:text name="notRealAssetsAssetBeneficiaryName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="notRealAssetsAssetBeneficiaryFirstName" class="label">Prénom du bénéficiaire<span class="required">*</span></label>
            <cvqf:text name="notRealAssetsAssetBeneficiaryFirstName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="notRealAssetsAssetBeneficiaryAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="notRealAssetsAssetBeneficiaryAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="notRealAssetsAssetBeneficiaryAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="notRealAssetsAssetBeneficiaryAddressCity" mode="" maxlength="32" size="35"/>
          </li>

          <li class="text_row">
			<label for="notRealAssetsAssetValue" class="label">Valeur déclarée<span class="required">*</span></label>
            <cvqf:text name="notRealAssetsAssetValue" mode="" maxlength="10"/>
          </li>
          <li class="date_row">
			<label for="notRealAssetsAssetDate" class="label">Date partage, donation ou vente<span class="required">*</span></label>
            <cvqf:text name="notRealAssetsAssetDate" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Informations sur le notaire :</h3>
        <ul class="insert_list">
          <li class="text_row">
			<label for="notRealAssetsAssetNotaryName" class="label">Nom du notaire<span class="required">*</span></label>
            <cvqf:text name="notRealAssetsAssetNotaryName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="notRealAssetsAssetNotaryAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="notRealAssetsAssetNotaryAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="notRealAssetsAssetNotaryAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="notRealAssetsAssetNotaryAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="notRealAssetsAssetNotaryAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="notRealAssetsAssetNotaryAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="notRealAssetsAssetNotaryAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="notRealAssetsAssetNotaryAddressCity" mode="" maxlength="32" size="35"/>
          </li>

        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.notRealAssetsAssetType = new Function("key","this.label='Type'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.notRealAssetsAssetKind = new Function("key","this.label='Nature du bien'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
         	  this.notRealAssetsAssetAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.notRealAssetsAssetAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.notRealAssetsAssetAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.notRealAssetsAssetAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.notRealAssetsAssetAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.notRealAssetsAssetAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.notRealAssetsAssetAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.notRealAssetsAssetBeneficiaryName = new Function("key","this.label='Nom du bénéficiaire'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.notRealAssetsAssetBeneficiaryFirstName = new Function("key","this.label='Prénom du bénéficiaire'; this.msg=null; this.required=true; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
         	  this.notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.notRealAssetsAssetBeneficiaryAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.notRealAssetsAssetBeneficiaryAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.notRealAssetsAssetBeneficiaryAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.notRealAssetsAssetBeneficiaryAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.notRealAssetsAssetBeneficiaryAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.notRealAssetsAssetValue = new Function("key","this.label='Valeur déclarée'; this.msg=null; this.required=true; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.notRealAssetsAssetDate = new Function("key","this.label='Date partage, donation ou vente'; this.msg=null; this.required=true; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.notRealAssetsAssetNotaryName = new Function("key","this.label='Nom du notaire'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
         	  this.notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.notRealAssetsAssetNotaryAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.notRealAssetsAssetNotaryAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.notRealAssetsAssetNotaryAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.notRealAssetsAssetNotaryAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.notRealAssetsAssetNotaryAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
  		}
        updateDisplay("notRealAssetsAssetType");
        updateDisplay("notRealAssetsAssetKind");
        window.onload = function () {
	        addresseTypeAhead("notRealAssetsAssetAddressCity", "notRealAssetsAssetAddressPostalCode");
        }
        window.onload = function () {
	        addresseTypeAhead("notRealAssetsAssetBeneficiaryAddressCity", "notRealAssetsAssetBeneficiaryAddressPostalCode");
        }
        window.onload = function () {
	        addresseTypeAhead("notRealAssetsAssetNotaryAddressCity", "notRealAssetsAssetNotaryAddressPostalCode");
        }
  		setFocus("Patrimony");
	</script>
