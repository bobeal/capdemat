<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Legal" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row">
			<label for="legalRepresentative" class="large_radio_label">Représentant légal de la personne concernée par la demande</label>
		  </li>
          <cvqf:radio name="legalRepresentative" mode="" label="[Oui,Non]" />
        </ul>
        <ul class="insert_list" id="Oui">
          <li class="text_row">
			<label for="legalRepresentativeName" class="label">Nom</label>
            <cvqf:text name="legalRepresentativeName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="legalRepresentativeFirstame" class="label">Prénom</label>
            <cvqf:text name="legalRepresentativeFirstame" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="legalRepresentativeFamilyRelationship" class="label">Lien de parenté</label>
            <cvqf:text name="legalRepresentativeFamilyRelationship" mode=""/>
          </li>
          <li class="text_row">
  			<label for="legalRepresentativeAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="legalRepresentativeAddressAdditionalDeliveryInformation" mode="notrequired" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="legalRepresentativeAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="legalRepresentativeAddressAdditionalGeographicalInformation" mode="notrequired" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="legalRepresentativeAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="legalRepresentativeAddressStreetNumber" mode="notrequired" maxlength="5"/>
    		<cvqf:text name="legalRepresentativeAddressStreetName" mode="notrequired" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="legalRepresentativeAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="legalRepresentativeAddressPlaceNameOrService" mode="notrequired" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="legalRepresentativeAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="legalRepresentativeAddressPostalCode" mode="notrequired" maxlength="5" validEvents="2"/>
    		<cvqf:text name="legalRepresentativeAddressCity" mode="notrequired" maxlength="32" size="35"/>
          </li>

          <li class="phone_row">
			<label for="legalRepresentativePhone" class="label">Téléphone</label>
            <cvqf:text name="legalRepresentativePhone" mode="" maxlength="10"/>
          </li>
        </ul>
		<br class="clear-both" />
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.legalRepresentative = new Function("key","this.label='Représentant légal de la personne concernée par la demande'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.legalRepresentativeName = new Function("key","this.label='Nom'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.legalRepresentativeFirstame = new Function("key","this.label='Prénom'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.legalRepresentativeFamilyRelationship = new Function("key","this.label='Lien de parenté'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
         	  this.legalRepresentativeAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.legalRepresentativeAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.legalRepresentativeAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.legalRepresentativeAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.legalRepresentativeAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.legalRepresentativeAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.legalRepresentativeAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.legalRepresentativePhone = new Function("key","this.label='Téléphone'; this.msg=null; this.required=false; this.mask=/^0[1-9][0-9]{8}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
        updateDisplay("legalRepresentative");
        window.onload = function () {
	        addresseTypeAhead("legalRepresentativeAddressCity", "legalRepresentativeAddressPostalCode");
        }
  		setFocus("Legal");
	</script>
