<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Waste" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Type de végétaux
          </p>
          <p class="text">
            <cvqf:check name="compostableWasteType" mode="static" repository="compostablewaste">
            </cvqf:check>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Autre, préciser
          </p>
          <p class="text">
            <cvqf:text name="otherWaste" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Adresse de collecte (si différente de l'adresse du compte)
          </p>
          <p class="text">
            <cvqf:text name="collectionAddress" mode="static"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Waste");
	</script>
