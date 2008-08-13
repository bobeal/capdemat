<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Rules" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row">
			<label for="emergency" class="large_radio_label">Préciser si cette demande est motivée par une urgence médicale<span class="required">*</span></label>
		  </li>
          <cvqf:radio name="emergency" mode="" label="[Oui,Non]" />
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.emergency = new Function("key","this.label='Préciser si cette demande est motivée par une urgence médicale'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("emergency");
  		setFocus("Rules");
	</script>
