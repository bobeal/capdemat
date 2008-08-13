<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <cvqf:title stage="Subject"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultFirstName2" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Sexe : 
          </p>
          <p class="text">
            <cvqf:select name="subjectAdultSex" mode="static">
              <option value="">Choisissez un sexe</option>
              <option value="Male">Masculin</option>
              <option value="Female">Féminin</option>
              <option value="Unknown">Inconnu</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Né(e) le : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Type et nom de voie : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultAddressStreetName" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Téléphone domicile : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultHomePhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Type d'habitation : 
          </p>
          <p class="text">
            <cvqf:select name="dwelling" mode="static">
              <option value="">Choisissez un type d'habitation</option>
              <option value="Appartment">Appartement</option>
              <option value="House">Pavillon</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Numéro d'appartement : 
          </p>
          <p class="text">
            <cvqf:text name="appartmentNumber" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Etage : 
          </p>
          <p class="text">
            <cvqf:text name="floor" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Imposable : 
          </p>
          <p class="text">
            <cvqf:radio name="taxable" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Bénéficiaire APA : 
          </p>
          <p class="text">
            <cvqf:radio name="seniorAssitanceBeneficiary" mode="static" label="[Oui,Non]" />
          </p>
        </li>
      </ul>
      <cvqf:title stage="Contactperson"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Type de contact : 
          </p>
          <p class="text">
            <cvqf:select name="contact" mode="static">
              <option value="">Choisissez un type de contact</option>
              <option value="Requester">Demandeur</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom du contact : 
          </p>
          <p class="text">
            <cvqf:text name="contactName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom du contact : 
          </p>
          <p class="text">
            <cvqf:text name="contactFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Téléphone du contact : 
          </p>
          <p class="text">
            <cvqf:text name="contactPhone" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Keydeposit"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Type de dépositaire : 
          </p>
          <p class="text">
            <cvqf:select name="trustee" mode="static">
              <option value="">Choisissez un type de dépositaire</option>
              <option value="Requester">Demandeur</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom du dépositaire : 
          </p>
          <p class="text">
            <cvqf:text name="trusteeName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom du dépositaire : 
          </p>
          <p class="text">
            <cvqf:text name="trusteeFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Téléphone du dépositaire : 
          </p>
          <p class="text">
            <cvqf:text name="trusteePhone" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Rules"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Demande urgente : 
          </p>
          <p class="text">
            <cvqf:radio name="emergency" mode="static" label="[Oui,Non]" />
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
