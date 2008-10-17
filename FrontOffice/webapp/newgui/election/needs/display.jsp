<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Needs" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Souhaits et Besoins
          </p>
          <p class="text">
            <cvqf:radio name="hopesAndNeeds" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Souhaits
          </p>
          <p class="text">
            <cvqf:text name="hopes" mode="static" rows="3"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Besoins
          </p>
          <p class="text">
            <cvqf:text name="needs" mode="static" rows="3"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Observations
          </p>
          <p class="text">
            <cvqf:text name="comments" mode="static" rows="3"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Needs");
	</script>
