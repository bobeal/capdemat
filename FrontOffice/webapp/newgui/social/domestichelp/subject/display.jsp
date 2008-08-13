<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Nom
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom de jeune fille
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultMaidenName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Né(e) le
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Ville
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultBirthPlaceCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Numéro de Sécurité Sociale
          </p>
          <p class="text">
            <cvqf:text name="socialSecurityNumber" mode="static" maxlength="13"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Clé du numéro de Sécurité Sociale
          </p>
          <p class="text">
            <cvqf:text name="socialSecurityKeyNumber" mode="static" maxlength="2"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nationalité
          </p>
          <p class="text">
            <cvqf:select name="nationality" mode="static">
              <option value="">Choisissez un nationalité</option>
              <option value="French">Française</option>
              <option value="EuropeanUnion">Union Européenne</option>
              <option value="OutsideEuropeanUnion">Hors Union Européenne</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date d'arrivée en France
          </p>
          <p class="text">
            <cvqf:text name="franceArrivalDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Régime de retraite
          </p>
          <p class="text">
            <cvqf:select name="requesterPensionPlan" mode="static">
              <option value="">Choisissez un régime de retraite</option>
              <option value="CRAMIF">CRAMIF</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Présence d'un tuteur
          </p>
          <p class="text">
            <cvqf:radio name="requesterSituationTutorPresence" mode="static" label="[Oui,Non]" />
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Subject");
	</script>
