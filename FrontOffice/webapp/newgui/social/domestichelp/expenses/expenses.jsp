<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Expenses" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="mensualExpensesRent" class="label">Loyer</label>
            <cvqf:text name="mensualExpensesRent" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="mensualExpensesAlimonies" class="label">Pensions et obligations alimentaires</label>
            <cvqf:text name="mensualExpensesAlimonies" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.mensualExpensesRent = new Function("key","this.label='Loyer'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.mensualExpensesAlimonies = new Function("key","this.label='Pensions et obligations alimentaires'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
  		setFocus("Expenses");
	</script>
