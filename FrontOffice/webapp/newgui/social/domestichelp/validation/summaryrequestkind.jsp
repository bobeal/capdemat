<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <ul class="validation_list">
      </ul>
      <cvqf:title stage="Demande"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Type de la demande : 
          </p>
          <p class="text">
            <cvqf:radio name="requesterRequestKind" mode="static">
              <option value="Individual">Individuelle</option>
              <option value="Couple">Couple</option>
            </cvqf:radio>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
