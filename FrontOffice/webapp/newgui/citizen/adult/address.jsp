<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Adult" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list" id="DisplayAccountManager">
          <cvqf:hidden name="showAccMan" property="DisplayAccountManager"/>
          <li class="radio_row_inline">
			<label for="accountManager" class="">Responsable du compte</label>
          <cvqf:radio name="accountManager" mode="inline" label="[Oui,Non]" />
		  </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
          <li class="text_row">
  			<label for="adultAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="adultAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="adultAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="adultAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="adultAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="adultAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="adultAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="adultAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="adultAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="adultAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="adultAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="adultAddressCity" mode="" maxlength="32" size="35"/>
          </li>

        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Téléphone* :</h3>
        <ul class="insert_list">
        </ul>
        <ul class="insert_list" id="Phone">
          <li class="phone_row">
			<label for="adultHomePhone" class="label">Domicile</label>
            <cvqf:text name="adultHomePhone" mode="blockrequired" maxlength="10"/>
            <span class="inline_text">ex: 0102030405</span>
          </li>
          <li class="phone_row">
			<label for="adultOfficePhone" class="label">Bureau</label>
            <cvqf:text name="adultOfficePhone" mode="" maxlength="10"/>
          </li>
          <li class="phone_row">
			<label for="adultMobilePhone" class="label">Portable</label>
            <cvqf:text name="adultMobilePhone" mode="" maxlength="10"/>
          </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
          <li class="text_row">
			<label for="adultEmail" class="label">Courriel<span class="required">*</span></label>
            <cvqf:text name="adultEmail" mode=""/>
          </li>
          <li class="number_row">
			<label for="adultCfbn" class="label">Numéro CAF</label>
            <cvqf:text name="adultCfbn" mode="" maxlength="8"/>
            <span class="inline_text">Saisissez les chiffres de votre numéro d'allocataire.</span>
          </li>
          <li class="text_row">
			<label for="adultProfession" class="label">Profession</label>
            <cvqf:text name="adultProfession" mode=""/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.showAccMan = new Function("key","this.label='ShowAccMan[]'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.accountManager = new Function("key","this.label='Responsable du compte'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
         	  this.adultAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.adultAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.adultAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.adultAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.adultAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.adultAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.adultAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     			  this.adultHomePhone = new Function("key","this.label='Domicile'; this.msg='Au moins un numéro de téléphone est obligatoire.'; this.required=true; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type='block:Phone'; return this[key];");
     		  this.adultOfficePhone = new Function("key","this.label='Bureau'; this.msg=null; this.required=false; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.adultMobilePhone = new Function("key","this.label='Portable'; this.msg=null; this.required=false; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.adultEmail = new Function("key","this.label='Courriel'; this.msg=null; this.required=true; this.mask=/[a-zA-Z0-9._%\-]+@[a-zA-Z0-9._%\-]+\.[a-zA-Z0-9._%\-]{2,4}/; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.adultCfbn = new Function("key","this.label='Numéro CAF'; this.msg=null; this.required=false; this.mask=/[0-9]{7}[A-Z]{0,1}/; this.minlength=0; this.maxlength=8; this.type=null; return this[key];");
     		  this.adultProfession = new Function("key","this.label='Profession'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("showAccMan");
        updateDisplay("accountManager");
        window.onload = function () {
	        addresseTypeAhead("adultAddressCity", "adultAddressPostalCode");
        }
  		setFocus("Adult");
	</script>
