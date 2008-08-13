<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Previousresidence" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
  			<label for="previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="previousDwellingsPreviousDwellingAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="previousDwellingsPreviousDwellingAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="previousDwellingsPreviousDwellingAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="previousDwellingsPreviousDwellingAddressCity" mode="" maxlength="32" size="35"/>
          </li>

          <li class="date_row">
			<label for="previousDwellingsPreviousDwellingArrivalDate" class="label">Date d'arrivée</label>
            <cvqf:text name="previousDwellingsPreviousDwellingArrivalDate" mode="" maxlength="10"/>
          </li>
          <li class="date_row">
			<label for="previousDwellingsPreviousDwellingDepartureDate" class="label">Date de départ</label>
            <cvqf:text name="previousDwellingsPreviousDwellingDepartureDate" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
       	  this.previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.previousDwellingsPreviousDwellingAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.previousDwellingsPreviousDwellingAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.previousDwellingsPreviousDwellingAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.previousDwellingsPreviousDwellingAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.previousDwellingsPreviousDwellingAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.previousDwellingsPreviousDwellingArrivalDate = new Function("key","this.label='Date d&quote;arrivée'; this.msg=null; this.required=false; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.previousDwellingsPreviousDwellingDepartureDate = new Function("key","this.label='Date de départ'; this.msg=null; this.required=false; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
  		}
        window.onload = function () {
	        addresseTypeAhead("previousDwellingsPreviousDwellingAddressCity", "previousDwellingsPreviousDwellingAddressPostalCode");
        }
  		setFocus("Previousresidence");
	</script>
