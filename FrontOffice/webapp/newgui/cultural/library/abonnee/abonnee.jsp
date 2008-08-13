<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Abonnee" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="subjectIndividualLastName" class="label">Nom</label>
            <cvqf:text name="subjectIndividualLastName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectIndividualFirstName" class="label">Prénom</label>
            <cvqf:text name="subjectIndividualFirstName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectIndividualFirstName2" class="label">2ème prénom</label>
            <cvqf:text name="subjectIndividualFirstName2" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectIndividualFirstName3" class="label">3ème prénom</label>
            <cvqf:text name="subjectIndividualFirstName3" mode="disabled" maxlength="38"/>
          </li>
          <li class="date_row">
			<label for="subjectIndividualBirthDate" class="label">Date de naissance</label>
            <cvqf:text name="subjectIndividualBirthDate" mode="disabled" maxlength="10"/>
          </li>
          <li class="select_row">
			<label for="subjectIndividualSex" class="label">Sexe</label>
            <cvqf:select name="subjectIndividualSex" mode="disabled">
              <option value="">Choisissez un sexe</option>
              <option value="Male">Masculin</option>
              <option value="Female">Féminin</option>
              <option value="Unknown">Inconnu</option>
            </cvqf:select>
          </li>
          <li class="text_row">
  			<label for="subjectIndividualAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="subjectIndividualAddressAdditionalDeliveryInformation" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="subjectIndividualAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="subjectIndividualAddressAdditionalGeographicalInformation" mode="disabled" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="subjectIndividualAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="subjectIndividualAddressStreetNumber" mode="disabled" maxlength="5"/>
    		<cvqf:text name="subjectIndividualAddressStreetName" mode="disabled" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="subjectIndividualAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="subjectIndividualAddressPlaceNameOrService" mode="disabled" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="subjectIndividualAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="subjectIndividualAddressPostalCode" mode="disabled" maxlength="5" validEvents="2"/>
    		<cvqf:text name="subjectIndividualAddressCity" mode="disabled" maxlength="32" size="35"/>
          </li>

          <li class="select_row">
			<label for="subscription" class="label">Formule d'abonnement<span class="required">*</span></label>
            <cvqf:select name="subscription" mode="" repository="Subscription">
              <option value="">Choisissez une formule</option>
            </cvqf:select>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.subscription = new Function("key","this.label='Formule d&quote;abonnement'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("subscription");
  		setFocus("Abonnee");
	</script>
