<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Help" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Aide à la formulation
          </p>
          <p class="text">
            <cvqf:radio name="writingHelp" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom de l'aidant
          </p>
          <p class="text">
            <cvqf:text name="helperName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Fonction de l'aidant
          </p>
          <p class="text">
            <cvqf:text name="helperResponsability" mode="static"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Help");
	</script>
