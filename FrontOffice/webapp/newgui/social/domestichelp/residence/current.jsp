<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Residence" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Indication sur l'habitation de la personne concernée :</h3>
        <ul class="insert_list">
          <li class="text_row">
  			<label for="currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="currentDwellingCurrentDwellingAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="currentDwellingCurrentDwellingAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="currentDwellingCurrentDwellingAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="currentDwellingCurrentDwellingAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="currentDwellingCurrentDwellingAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="currentDwellingCurrentDwellingAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="currentDwellingCurrentDwellingAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="currentDwellingCurrentDwellingAddressCity" mode="" maxlength="32" size="35"/>
          </li>

          <li class="select_row">
			<label for="currentDwellingCurrentDwellingType" class="label">Nature de la résidence</label>
            <cvqf:select name="currentDwellingCurrentDwellingType" mode="">
              <option value="">Choisissez un nature de la résidence</option>
              <option value="Domicile">Domicile</option>
              <option value="EtablissmentPA">Etablissment PA</option>
              <option value="AccueilParticulierOnereux">Accueil particulier à titre onéreux</option>
              <option value="Autre">Autre</option>
            </cvqf:select>
          </li>
          <li class="date_row">
			<label for="currentDwellingCurrentDwellingArrivalDate" class="label">Date d'arrivée</label>
            <cvqf:text name="currentDwellingCurrentDwellingArrivalDate" mode="" maxlength="10"/>
          </li>
        </ul>
        <ul class="insert_list" id="Domicile">
          <li class="select_row">
			<label for="currentDwellingCurrentDwellingStatus" class="label">Statut Habitation</label>
            <cvqf:select name="currentDwellingCurrentDwellingStatus" mode="">
              <option value="">Choisissez un statut habitation</option>
              <option value="Owner">Propriétaire</option>
              <option value="Tenant">Locataire</option>
            </cvqf:select>
          </li>
          <li class="text_row">
			<label for="currentDwellingCurrentDwellingRoomNumber" class="label">Nombre de pièces</label>
            <cvqf:text name="currentDwellingCurrentDwellingRoomNumber" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="currentDwellingCurrentDwellingNetFloorArea" class="label">Surface habitable</label>
            <cvqf:text name="currentDwellingCurrentDwellingNetFloorArea" mode="" maxlength="10"/>
          </li>
        </ul>
		<br class="clear-both" />
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
       	  this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.currentDwellingCurrentDwellingAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.currentDwellingCurrentDwellingAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.currentDwellingCurrentDwellingAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.currentDwellingCurrentDwellingAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.currentDwellingCurrentDwellingAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.currentDwellingCurrentDwellingType = new Function("key","this.label='Nature de la résidence'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.currentDwellingCurrentDwellingArrivalDate = new Function("key","this.label='Date d&quote;arrivée'; this.msg=null; this.required=false; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.currentDwellingCurrentDwellingStatus = new Function("key","this.label='Statut Habitation'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.currentDwellingCurrentDwellingRoomNumber = new Function("key","this.label='Nombre de pièces'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.currentDwellingCurrentDwellingNetFloorArea = new Function("key","this.label='Surface habitable'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
        window.onload = function () {
	        addresseTypeAhead("currentDwellingCurrentDwellingAddressCity", "currentDwellingCurrentDwellingAddressPostalCode");
        }
        updateDisplay("currentDwellingCurrentDwellingType");
        updateDisplay("currentDwellingCurrentDwellingStatus");
  		setFocus("Residence");
	</script>
