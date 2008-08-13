<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Residence" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Adresse
          </p>
          <p class="text">
            <cvqf:text name="previousDwellingsPreviousDwellingAddressAddress" mode="static" maxlength="114"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Code postal
          </p>
          <p class="text">
            <cvqf:text name="previousDwellingsPreviousDwellingAddressPostalCode" mode="static" maxlength="5"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Ville
          </p>
          <p class="text">
            <cvqf:text name="previousDwellingsPreviousDwellingAddressCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date d'arrivée
          </p>
          <p class="text">
            <cvqf:text name="previousDwellingsPreviousDwellingArrivalDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date de départ
          </p>
          <p class="text">
            <cvqf:text name="previousDwellingsPreviousDwellingDepartureDate" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Residence");
	</script>
