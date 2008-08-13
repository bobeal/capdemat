<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Responsible" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
  			<label for="childLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="childLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="childLegalResponsibleLegalResponsibleAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="childLegalResponsibleLegalResponsibleAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="childLegalResponsibleLegalResponsibleAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="childLegalResponsibleLegalResponsibleAddressCity" mode="" maxlength="32" size="35"/>
          </li>

        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Téléphone* :</h3>
        <ul class="insert_list">
        </ul>
        <ul class="insert_list" id="Phone">
          <li class="phone_row">
			<label for="childLegalResponsibleLegalResponsibleHomePhone" class="label">Domicile</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleHomePhone" mode="blockrequired" maxlength="10"/>
            <span class="inline_text">ex: 0102030405</span>
          </li>
          <li class="phone_row">
			<label for="childLegalResponsibleLegalResponsibleOfficePhone" class="label">Bureau</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleOfficePhone" mode="" maxlength="10"/>
          </li>
          <li class="phone_row">
			<label for="childLegalResponsibleLegalResponsibleMobilePhone" class="label">Portable</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleMobilePhone" mode="" maxlength="10"/>
          </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
          <li class="text_row">
			<label for="childLegalResponsibleLegalResponsibleEmail" class="label">Courriel<span class="required">*</span></label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleEmail" mode=""/>
          </li>
          <li class="number_row">
			<label for="childLegalResponsibleLegalResponsibleCfbn" class="label">Numéro CAF</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleCfbn" mode="" maxlength="8"/>
            <span class="inline_text">Saisissez les chiffres de votre numéro d'allocataire.</span>
          </li>
          <li class="text_row">
			<label for="childLegalResponsibleLegalResponsibleProfession" class="label">Profession</label>
            <cvqf:text name="childLegalResponsibleLegalResponsibleProfession" mode=""/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
       	  this.childLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.childLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.childLegalResponsibleLegalResponsibleAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.childLegalResponsibleLegalResponsibleAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.childLegalResponsibleLegalResponsibleAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.childLegalResponsibleLegalResponsibleAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.childLegalResponsibleLegalResponsibleAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     			  this.childLegalResponsibleLegalResponsibleHomePhone = new Function("key","this.label='Domicile'; this.msg='Au moins un numéro de téléphone'; this.required=true; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type='block:Phone'; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleOfficePhone = new Function("key","this.label='Bureau'; this.msg=null; this.required=false; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleMobilePhone = new Function("key","this.label='Portable'; this.msg=null; this.required=false; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleEmail = new Function("key","this.label='Courriel'; this.msg=null; this.required=true; this.mask=/[a-zA-Z0-9._%\-]+@[a-zA-Z0-9._%\-]+\.[a-zA-Z0-9._%\-]{2,4}/; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleCfbn = new Function("key","this.label='Numéro CAF'; this.msg=null; this.required=false; this.mask=/[0-9]{7}[A-Z]{0,1}/; this.minlength=0; this.maxlength=8; this.type=null; return this[key];");
     		  this.childLegalResponsibleLegalResponsibleProfession = new Function("key","this.label='Profession'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        window.onload = function () {
	        addresseTypeAhead("childLegalResponsibleLegalResponsibleAddressCity", "childLegalResponsibleLegalResponsibleAddressPostalCode");
        }
  		setFocus("Responsible");
	</script>
