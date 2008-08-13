<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Securityfacility" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row">
			<label for="alarm" class="large_radio_label">Logement équipé d'alarme<span class="required">*</span></label>
		  </li>
          <cvqf:radio name="alarm" mode="" label="[Oui,Non]" />
          <li class="radio_row">
			<label for="light" class="large_radio_label">Logement équipé d'un éclairage automatique<span class="required">*</span></label>
		  </li>
          <cvqf:radio name="light" mode="" label="[Oui,Non]" />
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.alarm = new Function("key","this.label='Logement équipé d&quote;alarme'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.light = new Function("key","this.label='Logement équipé d&quote;un éclairage automatique'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("alarm");
        updateDisplay("light");
  		setFocus("Securityfacility");
	</script>
