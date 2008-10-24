<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Type de la demande
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
  		setFocus("Subject");
	</script>
