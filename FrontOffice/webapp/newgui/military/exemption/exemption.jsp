<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Exemption" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row">
			<label for="japdExemption" class="large_radio_label">Exemption JAPD<span class="required">*</span></label>
		  </li>
          <cvqf:radio name="japdExemption" mode="" label="[Oui,Non]" />
          <li class="radio_row">
			<label for="highlyInfirm" class="large_radio_label">Grand Infirme</label>
		  </li>
          <cvqf:radio name="highlyInfirm" mode="" label="[Oui,Non]" />
          <li class="radio_row">
			<label for="affectionOrDisease" class="large_radio_label">Affection ou maladie</label>
		  </li>
          <cvqf:radio name="affectionOrDisease" mode="" label="[Oui,Non]" />
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.japdExemption = new Function("key","this.label='Exemption JAPD'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.highlyInfirm = new Function("key","this.label='Grand Infirme'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.affectionOrDisease = new Function("key","this.label='Affection ou maladie'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("japdExemption");
        updateDisplay("highlyInfirm");
        updateDisplay("affectionOrDisease");
  		setFocus("Exemption");
	</script>
