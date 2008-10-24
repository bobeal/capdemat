<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Type" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="copies" class="label">Nombre d'actes souhaité<span class="required">*</span></label>
            <cvqf:text name="copies" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="usage" class="label">Usage</label>
            <cvqf:text name="usage" mode=""/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.copies = new Function("key","this.label='Nombre d&quote;actes souhaité'; this.msg=null; this.required=true; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.usage = new Function("key","this.label='Usage'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
  		setFocus("Type");
	</script>
