<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Patrimony" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="capitalsSharesAmount" class="label">Montant actions</label>
            <cvqf:text name="capitalsSharesAmount" mode="" maxlength="5"/>
          </li>
          <li class="text_row">
			<label for="capitalsBondsAmount" class="label">Montant obligations</label>
            <cvqf:text name="capitalsBondsAmount" mode="" maxlength="5"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
 		  this.capitalsSharesAmount = new Function("key","this.label='Montant actions'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
 		  this.capitalsBondsAmount = new Function("key","this.label='Montant obligations'; this.msg=null; this.required=false; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
		}
  		setFocus("Patrimony");
	</script>
