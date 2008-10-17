<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Patrimony" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
  			<label for="realAssetsRealAssetAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="realAssetsRealAssetAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="realAssetsRealAssetAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="realAssetsRealAssetAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="realAssetsRealAssetAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="realAssetsRealAssetAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="realAssetsRealAssetAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="realAssetsRealAssetAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="realAssetsRealAssetAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="realAssetsRealAssetAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="realAssetsRealAssetAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="realAssetsRealAssetAddressCity" mode="" maxlength="32" size="35"/>
          </li>

          <li class="text_row">
			<label for="realAssetsRealAssetValue" class="label">Valeur estimée<span class="required">*</span></label>
            <cvqf:text name="realAssetsRealAssetValue" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="realAssetsRealAssetNetFloorArea" class="label">Superficie<span class="required">*</span></label>
            <cvqf:text name="realAssetsRealAssetNetFloorArea" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
       	  this.realAssetsRealAssetAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.realAssetsRealAssetAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.realAssetsRealAssetAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.realAssetsRealAssetAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.realAssetsRealAssetAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.realAssetsRealAssetAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.realAssetsRealAssetAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.realAssetsRealAssetValue = new Function("key","this.label='Valeur estimée'; this.msg=null; this.required=true; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.realAssetsRealAssetNetFloorArea = new Function("key","this.label='Superficie'; this.msg=null; this.required=true; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
        window.onload = function () {
	        addresseTypeAhead("realAssetsRealAssetAddressCity", "realAssetsRealAssetAddressPostalCode");
        }
  		setFocus("Patrimony");
	</script>
