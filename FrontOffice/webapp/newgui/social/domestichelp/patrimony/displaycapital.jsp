<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Patrimony" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Montant actions
          </p>
          <p class="text">
            <cvqf:text name="capitalsSharesAmount" mode="static" maxlength="5"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Montant obligations
          </p>
          <p class="text">
            <cvqf:text name="capitalsBondsAmount" mode="static" maxlength="5"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Patrimony");
	</script>
