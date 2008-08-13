<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Keydeposit" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Type de dépositaire
          </p>
          <p class="text">
            <cvqf:select name="trustee" mode="static">
              <option value="">Choisissez un type de dépositaire</option>
              <option value="Requester">Demandeur</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom du dépositaire
          </p>
          <p class="text">
            <cvqf:text name="trusteeName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom du dépositaire
          </p>
          <p class="text">
            <cvqf:text name="trusteeFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Téléphone du dépositaire
          </p>
          <p class="text">
            <cvqf:text name="trusteePhone" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Keydeposit");
	</script>
