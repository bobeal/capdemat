<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Patrimony" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="savingsPaybookNumber" class="label">Numéro de Livret</label>
            <cvqf:text name="savingsPaybookNumber" mode="" maxlength="30"/>
          </li>
          <li class="text_row">
			<label for="savingsPaybookAmount" class="label">Montant du Livret</label>
            <cvqf:text name="savingsPaybookAmount" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.savingsPaybookNumber = new Function("key","this.label='Numéro de Livret'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=30; this.type=null; return this[key];");
     		  this.savingsPaybookAmount = new Function("key","this.label='Montant du Livret'; this.msg=null; this.required=false; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
  		setFocus("Patrimony");
	</script>
