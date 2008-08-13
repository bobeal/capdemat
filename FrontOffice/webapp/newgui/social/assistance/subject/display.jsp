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
            Prénom
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultFirstName2" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Sexe
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
            Né(e) le
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Type et nom de voie
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultAddressStreetName" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Téléphone domicile
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultHomePhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Type d'habitation
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
            Numéro d'appartement
          </p>
          <p class="text">
            <cvqf:text name="appartmentNumber" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Etage
          </p>
          <p class="text">
            <cvqf:text name="floor" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Imposable
          </p>
          <p class="text">
            <cvqf:radio name="taxable" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Bénéficiaire APA
          </p>
          <p class="text">
            <cvqf:radio name="seniorAssitanceBeneficiary" mode="static" label="[Oui,Non]" />
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Subject");
	</script>
