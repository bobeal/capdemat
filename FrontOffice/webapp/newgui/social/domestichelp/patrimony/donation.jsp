<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Patrimony" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="select_row">
			<label for="donationsDonationAsset" class="label">Nature du bien</label>
            <cvqf:select name="donationsDonationAsset" mode="">
              <option value="">Choisissez un nature du bien</option>
              <option value="Immobilier">Immobilier</option>
              <option value="Autre">Autre</option>
            </cvqf:select>
          </li>
          <li class="text_row">
			<label for="donationsDonationAssetPlace" class="label">Lieu</label>
            <cvqf:text name="donationsDonationAssetPlace" mode="" maxlength="200"/>
          </li>
          <li class="text_row">
			<label for="donationsDonationBeneficiaryName" class="label">Nom du bénéficiaire</label>
            <cvqf:text name="donationsDonationBeneficiaryName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="donationsDonationBeneficiaryFirstName" class="label">Prénom du bénéficiaire</label>
            <cvqf:text name="donationsDonationBeneficiaryFirstName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="donationsDonationValue" class="label">Valeur de la donation</label>
            <cvqf:text name="donationsDonationValue" mode="" maxlength="10"/>
          </li>
          <li class="date_row">
			<label for="donationsDonationDate" class="label">Date de la donation</label>
            <cvqf:text name="donationsDonationDate" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="donationsDonationNotaryName" class="label">Nom du notaire</label>
            <cvqf:text name="donationsDonationNotaryName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="donationsDonationNotaryFirstName" class="label">Prénom du notaire</label>
            <cvqf:text name="donationsDonationNotaryFirstName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="donationsDonationNotaryAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="donationsDonationNotaryAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="donationsDonationNotaryAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="donationsDonationNotaryAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="donationsDonationNotaryAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="donationsDonationNotaryAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="donationsDonationNotaryAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="donationsDonationNotaryAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="donationsDonationNotaryAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="donationsDonationNotaryAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="donationsDonationNotaryAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="donationsDonationNotaryAddressCity" mode="" maxlength="32" size="35"/>
          </li>

        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.donationsDonationAsset = new Function("key","this.label='Nature du bien'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.donationsDonationAssetPlace = new Function("key","this.label='Lieu'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=200; this.type=null; return this[key];");
     		  this.donationsDonationBeneficiaryName = new Function("key","this.label='Nom du bénéficiaire'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.donationsDonationBeneficiaryFirstName = new Function("key","this.label='Prénom du bénéficiaire'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.donationsDonationValue = new Function("key","this.label='Valeur de la donation'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.donationsDonationDate = new Function("key","this.label='Date de la donation'; this.msg=null; this.required=false; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.donationsDonationNotaryName = new Function("key","this.label='Nom du notaire'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.donationsDonationNotaryFirstName = new Function("key","this.label='Prénom du notaire'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
         	  this.donationsDonationNotaryAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.donationsDonationNotaryAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.donationsDonationNotaryAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.donationsDonationNotaryAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.donationsDonationNotaryAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.donationsDonationNotaryAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.donationsDonationNotaryAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
  		}
        updateDisplay("donationsDonationAsset");
        window.onload = function () {
	        addresseTypeAhead("donationsDonationNotaryAddressCity", "donationsDonationNotaryAddressPostalCode");
        }
  		setFocus("Patrimony");
	</script>
