<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Type de la demande
          </p>
          <p class="text">
            <cvqf:radio name="requestInformationRequestInformationKind" mode="static">
              <option value="First">Première demande</option>
              <option value="Renewal">Renouvellement</option>
            </cvqf:radio>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Profil du demandeur
          </p>
          <p class="text">
            <cvqf:radio name="requestInformationRequestInformationRequesterProfile" mode="static">
              <option value="Adult">Adulte</option>
              <option value="LessThan20">Enfants de moins de 20 ans</option>
            </cvqf:radio>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date d'échéance
          </p>
          <p class="text">
            <cvqf:text name="requestInformationRequestInformationExpirationDate" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Subject");
	</script>
