<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Activities" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Pour sélectionner une activité, cliquez sur le bouton qui porte son nom. :</h3>
        <ul class="insert_list">
          <cvqf:referential name="activity" mode="" repository="Activity" />
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   			  this.activity = new Function("key","this.label='Activités'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type='referential'; return this[key];");
  		}
        updateDisplay("activity");
  		setFocus("Activities");
	</script>
