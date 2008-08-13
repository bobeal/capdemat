<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subscription" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row">
			<label for="subscription" class="large_radio_label">Je désire recevoir l'infolettre SMS<span class="required">*</span></label>
		  </li>
          <cvqf:radio name="subscription" mode="" label="[Oui,Non]" />
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Centres d'intérêt :</h3>
        <ul class="insert_list">
          <cvqf:radio name="interests" mode="" repository="Interests" label="[Oui,Non]"/>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.subscription = new Function("key","this.label='Je désire recevoir l&quote;infolettre SMS'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  		  this.interests = new Function("key","this.label='Centres d&quote;intérêt'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type='list'; return this[key];");
  		}
        updateDisplay("subscription");
        updateDisplay("interests");
  		setFocus("Subscription");
	</script>
