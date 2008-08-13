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
          <li class="text_row">
			<label for="socialSecurityNumber" class="label">Numéro de Sécurité Sociale<span class="required">*</span></label>
            <cvqf:text name="socialSecurityNumber" mode="" maxlength="13"/>
          </li>
          <li class="text_row">
			<label for="socialSecurityKeyNumber" class="label">Clé du numéro de Sécurité Sociale<span class="required">*</span></label>
            <cvqf:text name="socialSecurityKeyNumber" mode="" maxlength="2"/>
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
        <ul class="insert_list" id="NotFrench">
          <li class="date_row">
			<label for="franceArrivalDate" class="label">Date d'arrivée en France<span class="required">*</span></label>
            <cvqf:text name="franceArrivalDate" mode="" maxlength="10"/>
          </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
          <li class="select_row">
			<label for="requesterPensionPlan" class="label">Régime de retraite</label>
            <cvqf:select name="requesterPensionPlan" mode="">
              <option value="">Choisissez un régime de retraite</option>
              <option value="CRAMIF">CRAMIF</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </li>
          <li class="radio_row_inline">
			<label for="requesterSituationTutorPresence" class="">Présence d'un tuteur<span class="required">*</span></label>
          <cvqf:radio name="requesterSituationTutorPresence" mode="inline" label="[Oui,Non]" />
		  </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.socialSecurityNumber = new Function("key","this.label='Numéro de Sécurité Sociale'; this.msg=null; this.required=true; this.mask=/[0-9]{13}/; this.minlength=13; this.maxlength=13; this.type=null; return this[key];");
     		  this.socialSecurityKeyNumber = new Function("key","this.label='Clé du numéro de Sécurité Sociale'; this.msg=null; this.required=true; this.mask=/[0-9]{2}/; this.minlength=2; this.maxlength=2; this.type=null; return this[key];");
     		  this.nationality = new Function("key","this.label='Nationalité'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.franceArrivalDate = new Function("key","this.label='Date d&quote;arrivée en France'; this.msg=null; this.required=true; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.requesterPensionPlan = new Function("key","this.label='Régime de retraite'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.requesterSituationTutorPresence = new Function("key","this.label='Présence d&quote;un tuteur'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("nationality");
        updateDisplay("requesterPensionPlan");
        updateDisplay("requesterSituationTutorPresence");
  		setFocus("Subject");
	</script>
