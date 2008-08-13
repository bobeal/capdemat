<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subscription" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Abonnement
          </p>
          <p class="text">
            <cvqf:radio name="subscription" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Centres d'intérêt
          </p>
          <p class="text">
            <cvqf:radio name="interests" mode="static" repository="Interests" label="[Oui,Non]"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Subscription");
	</script>
