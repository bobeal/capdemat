<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Numéro d'abonné : 
          </p>
          <p class="text">
            <cvqf:text name="subscriberNumber" mode="static"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Places"/>
      <ul class="validation_list">
          <cvqf:ticket name="placeReservation" mode="static" repository="Place Reservation" />
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
