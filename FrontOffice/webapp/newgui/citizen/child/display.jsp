<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Child" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Nom
          </p>
          <p class="text">
            <cvqf:text name="childLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom
          </p>
          <p class="text">
            <cvqf:text name="childFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            2ème prénom
          </p>
          <p class="text">
            <cvqf:text name="childFirstName2" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            3ème prénom
          </p>
          <p class="text">
            <cvqf:text name="childFirstName3" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Sexe
          </p>
          <p class="text">
            <cvqf:radio name="childSex" mode="static">
              <option value="Male">Masculin</option>
              <option value="Female">Féminin</option>
              <option value="Unknown">Inconnu</option>
            </cvqf:radio>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date de naissance
          </p>
          <p class="text">
            <cvqf:text name="childBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu de naissance				
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Commune
          </p>
          <p class="text">
            <cvqf:text name="childBirthPlaceCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Code postal
          </p>
          <p class="text">
            <cvqf:text name="childBirthPlacePostalCode" mode="static" maxlength="5"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Pays
          </p>
          <p class="text">
            <cvqf:select name="childBirthPlaceCountry" mode="static">
              <option value="">Choisissez un pays</option>
              <option value="EEC">UE</option>
              <option value="OUTSIDE_EEC">Hors UE</option>
            </cvqf:select>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Child");
	</script>
