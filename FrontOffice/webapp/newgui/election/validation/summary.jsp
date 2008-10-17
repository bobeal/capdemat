<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <cvqf:title stage="Needs"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Souhaits et Besoins : 
          </p>
          <p class="text">
            <cvqf:radio name="hopesAndNeeds" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Souhaits : 
          </p>
          <p class="text">
            <cvqf:text name="hopes" mode="static" rows="3"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Besoins : 
          </p>
          <p class="text">
            <cvqf:text name="needs" mode="static" rows="3"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Observations : 
          </p>
          <p class="text">
            <cvqf:text name="comments" mode="static" rows="3"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Help"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Aide à la formulation : 
          </p>
          <p class="text">
            <cvqf:radio name="writingHelp" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom de l'aidant : 
          </p>
          <p class="text">
            <cvqf:text name="helperName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Fonction de l'aidant : 
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
  		setFocus("Validation");
	</script>
