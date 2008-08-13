<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Othercontact" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="otherContactLastName" class="label">Nom<span class="required">*</span></label>
            <cvqf:text name="otherContactLastName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="otherContactFirstName" class="label">Prénom<span class="required">*</span></label>
            <cvqf:text name="otherContactFirstName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="otherContactAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="otherContactAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="otherContactAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="otherContactAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="otherContactAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="otherContactAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="otherContactAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="otherContactAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="otherContactAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="otherContactAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="otherContactAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="otherContactAddressCity" mode="" maxlength="32" size="35"/>
          </li>

          <li class="phone_row">
			<label for="otherContactPhone" class="label">Téléphone<span class="required">*</span></label>
            <cvqf:text name="otherContactPhone" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.otherContactLastName = new Function("key","this.label='Nom'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.otherContactFirstName = new Function("key","this.label='Prénom'; this.msg=null; this.required=true; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
         	  this.otherContactAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.otherContactAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.otherContactAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.otherContactAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.otherContactAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.otherContactAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.otherContactAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.otherContactPhone = new Function("key","this.label='Téléphone'; this.msg=null; this.required=true; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
        window.onload = function () {
	        addresseTypeAhead("otherContactAddressCity", "otherContactAddressPostalCode");
        }
  		setFocus("Othercontact");
	</script>
