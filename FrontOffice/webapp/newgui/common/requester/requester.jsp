<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Requester" action="#">
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="select_row">
  			<label for="requesterTitle" class="label">
				Civilité<span class="required">*</span>
			</label>
			<cvqf:select name="requesterTitle" mode="">
				<option value="">Choisissez une civilité</option>
				<option value="Mister">Monsieur</option>
				<option value="Madam">Madame</option>
				<option value="Miss">Mademoiselle</option>
				<option value="Agency">Organisme</option>
			</cvqf:select>
          </li>
          <li class="text_row">
  			<label for="requesterLastName" class="label">
				Nom<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterLastName" mode="" maxlength="40"/>
          </li>
          <li class="text_row">
  			<label for="requesterFirstName" class="label">
				Prénom<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterFirstName" mode="" maxlength="40"/>
          </li>
        </ul>
        <ul class="insert_list" id="Madam">
          <li class="text_row">
  			<label for="requesterMaidenName" class="label">
				Nom de jeune fille<span class="required">*</span>
			</label>
   			<cvqf:text name="requesterMaidenName" mode="" maxlength="40"/>
          </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
          <li class="date_row">
  			<label for="requesterBirthDate" class="label">
				Date de naissance<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterBirthDate" mode="" maxlength="10"/>
			<span class="inline_text">ex: 21/06/1956</span>
          </li>
          <li class="text_row">
  			<label for="requesterAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="requesterAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="requesterAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="requesterAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="requesterAddressStreetNumber" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="requesterAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="requesterAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="requesterAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="requesterAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="requesterAddressCity" mode="" maxlength="32" size="35"/>
          </li>
          <li class="phone_row">
  			<label for="requesterHomePhone" class="label">
				Téléphone<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterHomePhone" mode="" maxlength="10"/>
			<span class="inline_text">ex: 0102030405</span>
          </li>
          <li class="text_row">
  			<label for="requesterEmail" class="label">
				Courriel<span class="required">*</span>
			</label>
   			<cvqf:text name="requesterEmail" mode="" maxlength="40"/>
          </li>
        </ul>
      </fieldset>
   	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
	  	  this.requesterTitle = new Function("key","this.label='Civilité'; this.required=true; this.maxlength=0; this.type=null; return this[key];");
  	  	  this.requesterLastName = new Function("key","this.label='Nom'; this.required=true; this.mask=/[A-Z.]*/; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
    	  this.requesterMaidenName = new Function("key","this.label='Nom de jeune fille'; this.required=true; this.mask=/[A-Z.]*/; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
    	  this.requesterFirstName = new Function("key","this.label='Prenom(s)'; this.required=true; this.mask=/[A-Z]?.*/; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
    	  this.requesterBirthDate = new Function("key","this.label='Date de naissance'; this.required=true; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
          this.requesterAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	      this.requesterAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	      this.requesterAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	      this.requesterAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	      this.requesterAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	      this.requesterAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	      this.requesterAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
    	  this.requesterHomePhone = new Function("key","this.label='Téléphone domicile'; this.required=true; this.mask=/[0-9]{10}/; this.maxlength=10; this.type=null; return this[key];");
    	  this.requesterEmail = new Function("key","this.label='Courriel'; this.required=true; this.mask=/[a-zA-Z0-9._%\-]+@[a-zA-Z0-9._%\-]+\.[a-zA-Z0-9._%\-]{2,4}/; this.maxlength=0; this.type=null; return this[key];");
  		}
  		updateDisplay("requesterTitle");
        window.onload = function () {
	        addresseTypeAhead("requesterAddressCity", "requesterAddressPostalCode");
        }
  		setFocus("Requester");
	</script>
