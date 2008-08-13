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
			<label for="subjectAdultFirstName2" class="label">2ème prénom</label>
            <cvqf:text name="subjectAdultFirstName2" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectAdultFirstName3" class="label">3ème prénom</label>
            <cvqf:text name="subjectAdultFirstName3" mode="disabled" maxlength="38"/>
          </li>
          <li class="date_row">
			<label for="subjectAdultBirthDate" class="label">Date de naissance</label>
            <cvqf:text name="subjectAdultBirthDate" mode="disabled" maxlength="10"/>
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

          <li class="select_row">
			<label for="subjectAdultSex" class="label">Sexe</label>
            <cvqf:select name="subjectAdultSex" mode="disabled">
              <option value="">Choisissez un sexe</option>
              <option value="Male">Masculin</option>
              <option value="Female">Féminin</option>
              <option value="Unknown">Inconnu</option>
            </cvqf:select>
          </li>
          <li class="select_row">
			<label for="subjectNationality" class="label">Nationalité<span class="required">*</span></label>
            <cvqf:select name="subjectNationality" mode="" repository="Nationality">
              <option value="">Choisissez une nationalité</option>
            </cvqf:select>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.subjectNationality = new Function("key","this.label='Nationalité'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("subjectNationality");
  		setFocus("Subject");
	</script>
