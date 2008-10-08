<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Cadastre" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="requesterLastName" class="label">Nom</label>
            <cvqf:text name="requesterLastName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="requesterFirstName" class="label">Prénom</label>
            <cvqf:text name="requesterFirstName" mode="disabled" maxlength="38"/>
          </li>
          <li class="radio_row_inline">
			<label for="requesterQuality" class="">Agissant en qualité de<span class="required">*</span></label>
            <cvqf:radio name="requesterQuality" mode="inline">
              <option value="Owner">Propriétaire</option>
              <option value="Tenant">Locataire</option>
            </cvqf:radio>
		  </li>
        </ul>
        <ul class="insert_list" id="Tenant">
          <li class="text_row">
			<label for="ownerLastName" class="label">Nom du propriétaire<span class="required">*</span></label>
            <cvqf:text name="ownerLastName" mode="required" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="ownerFirstNames" class="label">Prénom(s)<span class="required">*</span></label>
            <cvqf:text name="ownerFirstNames" mode="required"/>
          </li>
          <li class="text_row">
  			<label for="ownerAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="ownerAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="ownerAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="ownerAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="ownerAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="ownerAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="ownerAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="ownerAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="ownerAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="ownerAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="ownerAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="ownerAddressCity" mode="" maxlength="32" size="35"/>
          </li>

        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
          <li class="text_row">
			<label for="section" class="label">Section<span class="required">*</span></label>
            <cvqf:text name="section" mode=""/>
          </li>
          <li class="text_row">
			<label for="number" class="label">Numéro<span class="required">*</span></label>
            <cvqf:text name="number" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="locality" class="label">Lieu-dit</label>
            <cvqf:text name="locality" mode=""/>
          </li>
          <li class="text_row">
			<label for="transportationRoute" class="label">Voie de communication</label>
            <cvqf:text name="transportationRoute" mode=""/>
          </li>
          <li class="radio_row_inline">
			<label for="moreThanTwoYears" class="">Immeuble de plus de 2 ans<span class="required">*</span></label>
          <cvqf:radio name="moreThanTwoYears" mode="inline" label="[Oui,Non]" />
		  </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.requesterQuality = new Function("key","this.label='Agissant en qualité de'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.ownerLastName = new Function("key","this.label='Nom du propriétaire'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.ownerFirstNames = new Function("key","this.label='Prénom(s)'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
         	  this.ownerAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.ownerAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.ownerAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.ownerAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.ownerAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.ownerAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.ownerAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.section = new Function("key","this.label='Section'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.number = new Function("key","this.label='Numéro'; this.msg=null; this.required=true; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.locality = new Function("key","this.label='Lieu-dit'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.transportationRoute = new Function("key","this.label='Voie de communication'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.moreThanTwoYears = new Function("key","this.label='Immeuble de plus de 2 ans'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("requesterQuality");
        window.onload = function () {
	        addresseTypeAhead("ownerAddressCity", "ownerAddressPostalCode");
        }
        updateDisplay("moreThanTwoYears");
  		setFocus("Cadastre");
	</script>
