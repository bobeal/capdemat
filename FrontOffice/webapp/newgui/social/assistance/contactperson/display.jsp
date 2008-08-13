<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Contactperson" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Type de contact
          </p>
          <p class="text">
            <cvqf:select name="contact" mode="static">
              <option value="">Choisissez un type de contact</option>
              <option value="Requester">Demandeur</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom du contact
          </p>
          <p class="text">
            <cvqf:text name="contactName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom du contact
          </p>
          <p class="text">
            <cvqf:text name="contactFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Téléphone du contact
          </p>
          <p class="text">
            <cvqf:text name="contactPhone" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Contactperson");
	</script>
