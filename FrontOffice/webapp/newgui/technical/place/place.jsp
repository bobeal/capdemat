<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Place" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
  			<label for="interventionPlaceAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="interventionPlaceAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="interventionPlaceAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="interventionPlaceAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="interventionPlaceStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="interventionPlaceStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="interventionPlaceStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="interventionPlacePlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="interventionPlacePlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="interventionPlacePostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="interventionPlacePostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="interventionPlaceCity" mode="" maxlength="32" size="35"/>
          </li>

        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
       	  this.interventionPlaceAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.interventionPlaceAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.interventionPlaceStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.interventionPlaceStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.interventionPlacePlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.interventionPlacePostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.interventionPlaceCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
  		}
        window.onload = function () {
	        addresseTypeAhead("interventionPlaceCity", "interventionPlacePostalCode");
        }
  		setFocus("Place");
	</script>
