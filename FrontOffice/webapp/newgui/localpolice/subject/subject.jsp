<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="subjectAdultLastName" class="label">Nom</label>
            <cvqf:text name="subjectAdultLastName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectAdultFirstName" class="label">Prénom</label>
            <cvqf:text name="subjectAdultFirstName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="subjectAdultAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="subjectAdultAddressAdditionalDeliveryInformation" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="subjectAdultAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="subjectAdultAddressAdditionalGeographicalInformation" mode="disabled" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="subjectAdultAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="subjectAdultAddressStreetNumber" mode="disabled" maxlength="5"/>
    		<cvqf:text name="subjectAdultAddressStreetName" mode="disabled" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="subjectAdultAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="subjectAdultAddressPlaceNameOrService" mode="disabled" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="subjectAdultAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="subjectAdultAddressPostalCode" mode="disabled" maxlength="5" validEvents="2"/>
    		<cvqf:text name="subjectAdultAddressCity" mode="disabled" maxlength="32" size="35"/>
          </li>

          <li class="phone_row">
			<label for="subjectAdultMobilePhone" class="label">Téléphone portable</label>
            <cvqf:text name="subjectAdultMobilePhone" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="subjectAdultEmail" class="label">Courriel<span class="required">*</span></label>
            <cvqf:text name="subjectAdultEmail" mode=""/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.subjectAdultMobilePhone = new Function("key","this.label='Téléphone portable'; this.msg=null; this.required=false; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.subjectAdultEmail = new Function("key","this.label='Courriel'; this.msg=null; this.required=true; this.mask=/[a-zA-Z0-9._%\-]+@[a-zA-Z0-9._%\-]+\.[a-zA-Z0-9._%\-]{2,4}/; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
  		setFocus("Subject");
	</script>
