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
        <h3 class="fieldset_subtitle">Activités de l'enfant au centre<span class="required">*</span> :</h3>
        <ul class="insert_list">
            <cvqf:check name="recreationActivity" mode="" repository="activityList">
            </cvqf:check>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  		  this.recreationActivity = new Function("key","this.label='Activités de l&quote;enfant au centre'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type='list'; return this[key];");
  		}
        updateDisplay("recreationActivity");
  		setFocus("Inscription");
	</script>
