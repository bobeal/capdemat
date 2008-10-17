<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="select_row">
			<label for="requesterSpouseSpouseInformationTitle" class="label">Civilité</label>
            <cvqf:select name="requesterSpouseSpouseInformationTitle" mode="disabled">
              <option value="">Choisissez un civilité</option>
              <option value="Mister">Monsieur</option>
              <option value="Madam">Madame</option>
              <option value="Miss">Mademoiselle</option>
              <option value="Agency">Organisme</option>
              <option value="Unknown">Inconnue</option>
            </cvqf:select>
          </li>
          <li class="select_row">
			<label for="requesterSpouseSpouseInformationFamilyStatus" class="label">Situation familiale</label>
            <cvqf:select name="requesterSpouseSpouseInformationFamilyStatus" mode="disabled">
              <option value="">Choisissez un situation familiale</option>
              <option value="Married">Marié(e)</option>
              <option value="Single">Célibataire</option>
              <option value="Divorced">Divorcé(e)</option>
              <option value="Widow">Veuf(ve)</option>
              <option value="CommonLawMarriage">Concubinage</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </li>
          <li class="text_row">
			<label for="requesterSpouseSpouseInformationLastName" class="label">Nom</label>
            <cvqf:text name="requesterSpouseSpouseInformationLastName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="requesterSpouseSpouseInformationFirstName" class="label">Prénom</label>
            <cvqf:text name="requesterSpouseSpouseInformationFirstName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="requesterSpouseSpouseInformationMaidenName" class="label">Nom de jeune fille</label>
            <cvqf:text name="requesterSpouseSpouseInformationMaidenName" mode="disabled" maxlength="38"/>
          </li>
          <li class="date_row">
			<label for="requesterSpouseSpouseInformationBirthDate" class="label">Né(e) le</label>
            <cvqf:text name="requesterSpouseSpouseInformationBirthDate" mode="disabled" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="requesterSpouseSpouseInformationBirthPlaceCity" class="label">Ville</label>
            <cvqf:text name="requesterSpouseSpouseInformationBirthPlaceCity" mode="disabled" maxlength="32"/>
          </li>
          <li class="select_row">
			<label for="requesterSpouseSpouseNationality" class="label">Nationalité<span class="required">*</span></label>
            <cvqf:select name="requesterSpouseSpouseNationality" mode="">
              <option value="">Choisissez un nationalité</option>
              <option value="French">Française</option>
              <option value="EuropeanUnion">Union Européenne</option>
              <option value="OutsideEuropeanUnion">Hors Union Européenne</option>
            </cvqf:select>
          </li>
        </ul>
        <ul class="insert_list" id="OutsideEuropeanUnion">
          <li class="date_row">
			<label for="requesterSpouseSpouseFranceArrivalDate" class="label">Date d'arrivée en France<span class="required">*</span></label>
            <cvqf:text name="requesterSpouseSpouseFranceArrivalDate" mode="" maxlength="10"/>
          </li>
          <li class="radio_row_inline">
			<label for="requesterSpouseSpouseMoreThan15YearsInFrance" class="">Je réside en France depuis plus de 15 ans de manière continue<span class="required">*</span></label>
          <cvqf:radio name="requesterSpouseSpouseMoreThan15YearsInFrance" mode="inline" label="[Oui,Non]" />
		  </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
          <li class="radio_row_inline">
			<label for="requesterSpouseSpousePensionner" class="">Retraité<span class="required">*</span></label>
          <cvqf:radio name="requesterSpouseSpousePensionner" mode="inline" label="[Oui,Non]" />
		  </li>
        </ul>
        <ul class="insert_list" id="Oui">
          <li class="select_row">
			<label for="requesterSpouseSpousePensionPlan" class="label">Régime de retraite principal<span class="required">*</span></label>
            <cvqf:select name="requesterSpouseSpousePensionPlan" mode="">
              <option value="">Choisissez un régime de retraite principal</option>
              <option value="CRAMIF">CRAMIF</option>
              <option value="CNAV">CNAV</option>
              <option value="MSA">MSA</option>
              <option value="CRAM">CRAM</option>
              <option value="MGEN">MGEN</option>
              <option value="SNCF">SNCF</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list" id="Other">
          <li class="text_row">
			<label for="requesterSpouseSpousePensionPlanPrecision" class="label">Préciser</label>
            <cvqf:text name="requesterSpouseSpousePensionPlanPrecision" mode="inline" maxlength="50"/>
          </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list" id="Oui2">
          <li class="text_row">
			<label for="requesterSpouseSpouseComplementaryPensionPlanPrecision" class="label">Régime de retraite complémentaire</label>
            <cvqf:text name="requesterSpouseSpouseComplementaryPensionPlanPrecision" mode="inline" maxlength="50"/>
          </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list" id="Non">
          <li class="text_row">
			<label for="requesterSpouseSpouseOccupation" class="label">Profession<span class="required">*</span></label>
            <cvqf:text name="requesterSpouseSpouseOccupation" mode="" maxlength="50"/>
          </li>
          <li class="text_row">
			<label for="requesterSpouseSpouseEmployer" class="label">Employeur<span class="required">*</span></label>
            <cvqf:text name="requesterSpouseSpouseEmployer" mode="" maxlength="50"/>
          </li>
          <li class="text_row">
  			<label for="requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="requesterSpouseSpouseEmployerAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="requesterSpouseSpouseEmployerAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="requesterSpouseSpouseEmployerAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressCity" mode="" maxlength="32" size="35"/>
          </li>

        </ul>
		<br class="clear-both" />
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.requesterSpouseSpouseNationality = new Function("key","this.label='Nationalité'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.requesterSpouseSpouseFranceArrivalDate = new Function("key","this.label='Date d&quote;arrivée en France'; this.msg=null; this.required=true; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.requesterSpouseSpouseMoreThan15YearsInFrance = new Function("key","this.label='Je réside en France depuis plus de 15 ans de manière continue'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.requesterSpouseSpousePensionner = new Function("key","this.label='Retraité'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.requesterSpouseSpousePensionPlan = new Function("key","this.label='Régime de retraite principal'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.requesterSpouseSpousePensionPlanPrecision = new Function("key","this.label='Préciser'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=50; this.type=null; return this[key];");
     		  this.requesterSpouseSpouseComplementaryPensionPlanPrecision = new Function("key","this.label='Régime de retraite complémentaire'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=50; this.type=null; return this[key];");
     		  this.requesterSpouseSpouseOccupation = new Function("key","this.label='Profession'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=50; this.type=null; return this[key];");
     		  this.requesterSpouseSpouseEmployer = new Function("key","this.label='Employeur'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=50; this.type=null; return this[key];");
         	  this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.requesterSpouseSpouseEmployerAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.requesterSpouseSpouseEmployerAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.requesterSpouseSpouseEmployerAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.requesterSpouseSpouseEmployerAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.requesterSpouseSpouseEmployerAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
  		}
        updateDisplay("requesterSpouseSpouseNationality");
        updateDisplay("requesterSpouseSpouseMoreThan15YearsInFrance");
        updateDisplay("requesterSpouseSpousePensionner");
        updateDisplay("requesterSpouseSpousePensionPlan");
        window.onload = function () {
	        addresseTypeAhead("requesterSpouseSpouseEmployerAddressCity", "requesterSpouseSpouseEmployerAddressPostalCode");
        }
  		setFocus("Subject");
	</script>
