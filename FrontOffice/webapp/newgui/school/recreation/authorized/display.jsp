<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Authorized" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Nom
          </p>
          <p class="text">
            <cvqf:text name="otherIndividualLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom
          </p>
          <p class="text">
            <cvqf:text name="otherIndividualFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Adresse
          </p>
          <p class="text">
            <cvqf:text name="otherIndividualAddress" mode="static" rows="3"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Téléphone domicile
          </p>
          <p class="text">
            <cvqf:text name="otherIndividualHomePhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Téléphone bureau
          </p>
          <p class="text">
            <cvqf:text name="otherIndividualOfficePhone" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Authorized");
	</script>
