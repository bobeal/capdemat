<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Rules" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row">
			<label for="rulesAndRegulationsAcceptance" class="large_radio_label">J'ai pris connaissance du règlement intérieur de l'école de musique.</label>
		  </li>
          <cvqf:radio name="rulesAndRegulationsAcceptance" mode="" label="[Oui,Non]" />
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.rulesAndRegulationsAcceptance = new Function("key","this.label='J&quote;ai pris connaissance du règlement intérieur de l&quote;école de musique.'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("rulesAndRegulationsAcceptance");
  		setFocus("Rules");
	</script>
