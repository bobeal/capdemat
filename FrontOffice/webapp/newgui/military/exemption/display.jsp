<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Exemption" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Exemption JAPD
          </p>
          <p class="text">
            <cvqf:radio name="japdExemption" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Grand Infirme
          </p>
          <p class="text">
            <cvqf:radio name="highlyInfirm" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Affection ou maladie
          </p>
          <p class="text">
            <cvqf:radio name="affectionOrDisease" mode="static" label="[Oui,Non]" />
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Exemption");
	</script>
