<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Residences" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
  			<label for="previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="previousDwellingPreviousDwellingAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="previousDwellingPreviousDwellingAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="previousDwellingPreviousDwellingAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="previousDwellingPreviousDwellingAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="previousDwellingPreviousDwellingAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="previousDwellingPreviousDwellingAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="previousDwellingPreviousDwellingAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="previousDwellingPreviousDwellingAddressCity" mode="" maxlength="32" size="35"/>
          </li>

          <li class="date_row">
			<label for="previousDwellingPreviousDwellingArrivalDate" class="label">Date d'arrivée<span class="required">*</span></label>
            <cvqf:text name="previousDwellingPreviousDwellingArrivalDate" mode="" maxlength="10"/>
          </li>
          <li class="date_row">
			<label for="previousDwellingPreviousDwellingDepartureDate" class="label">Date de départ<span class="required">*</span></label>
            <cvqf:text name="previousDwellingPreviousDwellingDepartureDate" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
       	  this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.previousDwellingPreviousDwellingAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.previousDwellingPreviousDwellingAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.previousDwellingPreviousDwellingAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.previousDwellingPreviousDwellingAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.previousDwellingPreviousDwellingAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.previousDwellingPreviousDwellingArrivalDate = new Function("key","this.label='Date d&quote;arrivée'; this.msg=null; this.required=true; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.previousDwellingPreviousDwellingDepartureDate = new Function("key","this.label='Date de départ'; this.msg=null; this.required=true; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
  		}
        window.onload = function () {
	        addresseTypeAhead("previousDwellingPreviousDwellingAddressCity", "previousDwellingPreviousDwellingAddressPostalCode");
        }
  		setFocus("Residences");
	</script>
