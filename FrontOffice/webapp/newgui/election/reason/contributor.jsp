<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Reason" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row_inline">
			<label for="motive" class=""> </label>
            <cvqf:radio name="motive" mode="static">
              <option value="NewCityResident">Domicilié dans la commune ou y habitant depuis six mois au moins</option>
              <option value="DirectCityContribution">Participe aux contributions directes communales pour la cinquième fois sans interruption</option>
              <option value="CivilServantObligatoryResident">Fonctionnaire public assujetti à résidence obligatoire dans la commune</option>
              <option value="FutureAuthorizedCitizen">Ne remplit pas actuellement les conditions d'âge et de résidence mais les remplira d'ici la clôture définitive des listes</option>
            </cvqf:radio>
		  </li>
          <li class="text_row">
  			<label for="subjectAddressOutsideCityAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="subjectAddressOutsideCityAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="subjectAddressOutsideCityAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="subjectAddressOutsideCityAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="subjectAddressOutsideCityStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="subjectAddressOutsideCityStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="subjectAddressOutsideCityStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="subjectAddressOutsideCityPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="subjectAddressOutsideCityPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="subjectAddressOutsideCityPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="subjectAddressOutsideCityPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="subjectAddressOutsideCityCity" mode="" maxlength="32" size="35"/>
          </li>

        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
       	  this.subjectAddressOutsideCityAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.subjectAddressOutsideCityAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.subjectAddressOutsideCityStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.subjectAddressOutsideCityStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.subjectAddressOutsideCityPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.subjectAddressOutsideCityPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.subjectAddressOutsideCityCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
  		}
        window.onload = function () {
	        addresseTypeAhead("subjectAddressOutsideCityCity", "subjectAddressOutsideCityPostalCode");
        }
  		setFocus("Reason");
	</script>
