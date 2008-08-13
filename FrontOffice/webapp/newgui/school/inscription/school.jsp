<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Inscription" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="subjectChildLastName" class="label">Nom</label>
            <cvqf:text name="subjectChildLastName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectChildFirstName" class="label">Prénom</label>
            <cvqf:text name="subjectChildFirstName" mode="disabled" maxlength="38"/>
          </li>
          <li class="date_row">
			<label for="subjectChildBirthDate" class="label">Né(e) le</label>
            <cvqf:text name="subjectChildBirthDate" mode="disabled" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Inscription en classe<span class="required">*</span> :</h3>
        <ul class="insert_list">
          <li class="select_row">
			<label></label>
            <cvqf:select name="section" mode="title">
              <option value="">Choisissez une classe</option>
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
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Téléphone en cas d'urgence<span class="required">*</span> :</h3>
        <ul class="insert_list">
          <li class="phone_row">
			<label></label>
            <cvqf:text name="urgencyPhone" mode="title" maxlength="10"/>
            <span class="inline_text">ex: 0102030405</span>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Ecole actuelle :</h3>
        <ul class="insert_list">
          <li class="text_row">
			<label for="currentSchoolName" class="label">Nom</label>
            <cvqf:text name="currentSchoolName" mode=""/>
          </li>
          <li class="text_row">
			<label for="currentSchoolAddress" class="label">Adresse</label>
            <cvqf:text name="currentSchoolAddress" mode="" rows="3"/>
          </li>
          <li class="select_row">
			<label for="currentSection" class="label">Classe</label>
            <cvqf:select name="currentSection" mode="">
              <option value="">Choisissez une classe</option>
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
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.section = new Function("key","this.label='Inscription en classe'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.urgencyPhone = new Function("key","this.label='Téléphone en cas d&quote;urgence'; this.msg=null; this.required=true; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.currentSchoolName = new Function("key","this.label='Nom'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.currentSchoolAddress = new Function("key","this.label='Adresse'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.currentSection = new Function("key","this.label='Classe'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
  		}
        updateDisplay("section");
        updateDisplay("currentSection");
  		setFocus("Inscription");
	</script>
