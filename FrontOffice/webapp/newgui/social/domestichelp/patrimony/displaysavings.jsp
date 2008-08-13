<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Patrimony" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Numéro de Livret
          </p>
          <p class="text">
            <cvqf:text name="savingsPaybookNumber" mode="static" maxlength="30"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Montant du Livret
          </p>
          <p class="text">
            <cvqf:text name="savingsPaybookAmount" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Patrimony");
	</script>
