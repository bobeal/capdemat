<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nom du père : 
          </p>
          <p class="text">
            <cvqf:text name="fatherLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom(s) du père : 
          </p>
          <p class="text">
            <cvqf:text name="fatherFirstNames" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom de jeune fille de la mère : 
          </p>
          <p class="text">
            <cvqf:text name="motherMaidenName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom(s) de la mère : 
          </p>
          <p class="text">
            <cvqf:text name="motherFirstNames" mode="static"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
