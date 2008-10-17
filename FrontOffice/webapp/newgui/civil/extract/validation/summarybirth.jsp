<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nom : 
          </p>
          <p class="text">
            <cvqf:text name="birthLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom(s) : 
          </p>
          <p class="text">
            <cvqf:text name="birthFirstNames" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Date de naissance : 
          </p>
          <p class="text">
            <cvqf:text name="birthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Ville de naissance : 
          </p>
          <p class="text">
            <cvqf:text name="birthCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Département de naissance : 
          </p>
          <p class="text">
            <cvqf:text name="birthPostalCode" mode="static" maxlength="2"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
