<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row_inline">
			<label for="requesterFamilyReferentFamilyReferentDesignated" class="">Référent familial<span class="required">*</span></label>
          <cvqf:radio name="requesterFamilyReferentFamilyReferentDesignated" mode="inline" label="[Oui,Non]" />
		  </li>
        </ul>
        <ul class="insert_list" id="Oui">
          <li class="text_row">
			<label for="requesterFamilyReferentFamilyReferentName" class="label">Nom<span class="required">*</span></label>
            <cvqf:text name="requesterFamilyReferentFamilyReferentName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="requesterFamilyReferentFamilyReferentFirstName" class="label">Prénom<span class="required">*</span></label>
            <cvqf:text name="requesterFamilyReferentFamilyReferentFirstName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="requesterFamilyReferentFamilyReferentAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterFamilyReferentFamilyReferentAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="requesterFamilyReferentFamilyReferentAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="requesterFamilyReferentFamilyReferentAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="requesterFamilyReferentFamilyReferentAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="requesterFamilyReferentFamilyReferentAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterFamilyReferentFamilyReferentAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="requesterFamilyReferentFamilyReferentAddressCity" mode="" maxlength="32" size="35"/>
          </li>

        </ul>
		<br class="clear-both" />
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.requesterFamilyReferentFamilyReferentDesignated = new Function("key","this.label='Référent familial'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.requesterFamilyReferentFamilyReferentName = new Function("key","this.label='Nom'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.requesterFamilyReferentFamilyReferentFirstName = new Function("key","this.label='Prénom'; this.msg=null; this.required=true; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
         	  this.requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.requesterFamilyReferentFamilyReferentAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.requesterFamilyReferentFamilyReferentAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.requesterFamilyReferentFamilyReferentAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.requesterFamilyReferentFamilyReferentAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.requesterFamilyReferentFamilyReferentAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
  		}
        updateDisplay("requesterFamilyReferentFamilyReferentDesignated");
        window.onload = function () {
	        addresseTypeAhead("requesterFamilyReferentFamilyReferentAddressCity", "requesterFamilyReferentFamilyReferentAddressPostalCode");
        }
  		setFocus("Subject");
	</script>
