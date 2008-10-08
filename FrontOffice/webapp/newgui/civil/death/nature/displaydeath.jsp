<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Nature" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Nom
          </p>
          <p class="text">
            <cvqf:text name="deathLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom(s)
          </p>
          <p class="text">
            <cvqf:text name="deathFirstNames" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date de décès
          </p>
          <p class="text">
            <cvqf:text name="deathDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Ville de décès
          </p>
          <p class="text">
            <cvqf:text name="deathCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Département de décès
          </p>
          <p class="text">
            <cvqf:text name="deathPostalCode" mode="static" maxlength="2"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Nature");
	</script>
