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
        <h3 class="fieldset_subtitle">Téléphone en cas d'urgence<span class="required">*</span> :</h3>
        <ul class="insert_list">
          <li class="phone_row">
			<label></label>
            <cvqf:text name="urgencyPhone" mode="title" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.urgencyPhone = new Function("key","this.label='Téléphone en cas d&quote;urgence'; this.msg=null; this.required=true; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
  		setFocus("Inscription");
	</script>
