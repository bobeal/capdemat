<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="select_row">
			<label for="requesterSituationTutor" class="label">Mesure</label>
            <cvqf:select name="requesterSituationTutor" mode="">
              <option value="">Choisissez un mesure</option>
              <option value="SauvegardeJustice">Sauvegarde de Justice</option>
              <option value="Tutelle">Tutelle</option>
              <option value="Curatelle">Curatelle</option>
            </cvqf:select>
          </li>
          <li class="text_row">
			<label for="requesterSituationTutorName" class="label">Nom</label>
            <cvqf:text name="requesterSituationTutorName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="requesterSituationTutorFirstName" class="label">Prénom</label>
            <cvqf:text name="requesterSituationTutorFirstName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="requesterSituationTutorAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="requesterSituationTutorAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="requesterSituationTutorAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="requesterSituationTutorAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="requesterSituationTutorAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterSituationTutorAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="requesterSituationTutorAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="requesterSituationTutorAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="requesterSituationTutorAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="requesterSituationTutorAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterSituationTutorAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="requesterSituationTutorAddressCity" mode="" maxlength="32" size="35"/>
          </li>

        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.requesterSituationTutor = new Function("key","this.label='Mesure'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.requesterSituationTutorName = new Function("key","this.label='Nom'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.requesterSituationTutorFirstName = new Function("key","this.label='Prénom'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
         	  this.requesterSituationTutorAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.requesterSituationTutorAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.requesterSituationTutorAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.requesterSituationTutorAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.requesterSituationTutorAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.requesterSituationTutorAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.requesterSituationTutorAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
  		}
        updateDisplay("requesterSituationTutor");
        window.onload = function () {
	        addresseTypeAhead("requesterSituationTutorAddressCity", "requesterSituationTutorAddressPostalCode");
        }
  		setFocus("Subject");
	</script>
