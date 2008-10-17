<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="select_row">
			<label for="subjectAdultTitle" class="label">Civilité</label>
            <cvqf:select name="subjectAdultTitle" mode="disabled">
              <option value="">Choisissez un civilité</option>
              <option value="Mister">Monsieur</option>
              <option value="Madam">Madame</option>
              <option value="Miss">Mademoiselle</option>
              <option value="Agency">Organisme</option>
              <option value="Unknown">Inconnue</option>
            </cvqf:select>
          </li>
          <li class="select_row">
			<label for="subjectAdultFamilyStatus" class="label">Situation familiale</label>
            <cvqf:select name="subjectAdultFamilyStatus" mode="disabled">
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
			<label for="subjectAdultLastName" class="label">Nom</label>
            <cvqf:text name="subjectAdultLastName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectAdultFirstName" class="label">Prénom</label>
            <cvqf:text name="subjectAdultFirstName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectAdultMaidenName" class="label">Nom de jeune fille</label>
            <cvqf:text name="subjectAdultMaidenName" mode="disabled" maxlength="38"/>
          </li>
          <li class="date_row">
			<label for="subjectAdultBirthDate" class="label">Né(e) le</label>
            <cvqf:text name="subjectAdultBirthDate" mode="disabled" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="subjectAdultBirthPlaceCity" class="label">Ville</label>
            <cvqf:text name="subjectAdultBirthPlaceCity" mode="disabled" maxlength="32"/>
          </li>
          <li class="select_row">
			<label for="nationality" class="label">Nationalité<span class="required">*</span></label>
            <cvqf:select name="nationality" mode="">
              <option value="">Choisissez un nationalité</option>
              <option value="French">Française</option>
              <option value="EuropeanUnion">Union Européenne</option>
              <option value="OutsideEuropeanUnion">Hors Union Européenne</option>
            </cvqf:select>
          </li>
        </ul>
        <ul class="insert_list" id="OutsideEuropeanUnion">
          <li class="date_row">
			<label for="franceArrivalDate" class="label">Date d'arrivée en France<span class="required">*</span></label>
            <cvqf:text name="franceArrivalDate" mode="" maxlength="10"/>
          </li>
          <li class="radio_row_inline">
			<label for="moreThan15YearsInFrance" class="">Je réside en France depuis plus de 15 ans de manière continue<span class="required">*</span></label>
          <cvqf:radio name="moreThan15YearsInFrance" mode="inline" label="[Oui,Non]" />
		  </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
          <li class="select_row">
			<label for="requesterPensionPlan" class="label">Régime de retraite principal<span class="required">*</span></label>
            <cvqf:select name="requesterPensionPlan" mode="">
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
        <ul class="insert_list" id="Other">
          <li class="text_row">
			<label for="pensionPlanPrecision" class="label">Préciser<span class="required">*</span></label>
            <cvqf:text name="pensionPlanPrecision" mode="" maxlength="50"/>
          </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
          <li class="text_row">
			<label for="complementaryPensionPlanPrecision" class="label">Régime de retraite complémentaire</label>
            <cvqf:text name="complementaryPensionPlanPrecision" mode="" maxlength="50"/>
          </li>
          <li class="radio_row_inline">
			<label for="requesterSituationTutorPresence" class="">Présence tuteur<span class="required">*</span></label>
          <cvqf:radio name="requesterSituationTutorPresence" mode="inline" label="[Oui,Non]" />
		  </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.nationality = new Function("key","this.label='Nationalité'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.franceArrivalDate = new Function("key","this.label='Date d&quote;arrivée en France'; this.msg=null; this.required=true; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.moreThan15YearsInFrance = new Function("key","this.label='Je réside en France depuis plus de 15 ans de manière continue'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.requesterPensionPlan = new Function("key","this.label='Régime de retraite principal'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.pensionPlanPrecision = new Function("key","this.label='Préciser'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=50; this.type=null; return this[key];");
     		  this.complementaryPensionPlanPrecision = new Function("key","this.label='Régime de retraite complémentaire'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=50; this.type=null; return this[key];");
     		  this.requesterSituationTutorPresence = new Function("key","this.label='Présence tuteur'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("nationality");
        updateDisplay("moreThan15YearsInFrance");
        updateDisplay("requesterPensionPlan");
        updateDisplay("requesterSituationTutorPresence");
  		setFocus("Subject");
	</script>
