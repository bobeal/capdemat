<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Alertphone" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="phone_row">
			<label for="alertPhone" class="label">Numero de téléphone en cas d'alerte<span class="required">*</span></label>
            <cvqf:text name="alertPhone" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.alertPhone = new Function("key","this.label='Numero de téléphone en cas d&quote;alerte'; this.msg=null; this.required=true; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
  		setFocus("Alertphone");
	</script>
