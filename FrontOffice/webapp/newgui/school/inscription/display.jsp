<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Inscription" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Nom
          </p>
          <p class="text">
            <cvqf:text name="subjectChildLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom
          </p>
          <p class="text">
            <cvqf:text name="subjectChildFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Né(e) le
          </p>
          <p class="text">
            <cvqf:text name="subjectChildBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Inscription en classe
          </p>
          <p class="text">
            <cvqf:select name="section" mode="static">
              <option value="">Choisissez un inscription en classe</option>
              <option value="BeforeFirstSection">Très Petite Section</option>
              <option value="FirstSection">Petite Section</option>
              <option value="SecondSection">Moyenne Section</option>
              <option value="ThirdSection">Grande Section</option>
              <option value="CP">CP</option>
              <option value="CE1">CE1</option>
              <option value="CE2">CE2</option>
              <option value="CM1">CM1</option>
              <option value="CM2">CM2</option>
              <option value="CLISS">CLISS</option>
              <option value="Unknown">Inconnue</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom de l'école actuelle
          </p>
          <p class="text">
            <cvqf:text name="currentSchoolName" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Adresse de l'école actuelle
          </p>
          <p class="text">
            <cvqf:text name="currentSchoolAddress" mode="static" rows="3"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Classe actuelle
          </p>
          <p class="text">
            <cvqf:select name="currentSection" mode="static">
              <option value="">Choisissez un classe actuelle</option>
              <option value="BeforeFirstSection">Très Petite Section</option>
              <option value="FirstSection">Petite Section</option>
              <option value="SecondSection">Moyenne Section</option>
              <option value="ThirdSection">Grande Section</option>
              <option value="CP">CP</option>
              <option value="CE1">CE1</option>
              <option value="CE2">CE2</option>
              <option value="CM1">CM1</option>
              <option value="CM2">CM2</option>
              <option value="CLISS">CLISS</option>
              <option value="Unknown">Inconnue</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Téléphone en cas d'urgence
          </p>
          <p class="text">
            <cvqf:text name="urgencyPhone" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Inscription");
	</script>
