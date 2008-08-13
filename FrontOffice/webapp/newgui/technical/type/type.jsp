<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Type" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="select_row">
			<label for="interventionType" class="label">Nature de l'intervention<span class="required">*</span></label>
            <cvqf:select name="interventionType" mode="" repository="InterventionType">
              <option value="">Choisissez un nature de l'intervention</option>
            </cvqf:select>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.interventionType = new Function("key","this.label='Nature de l&quote;intervention'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("interventionType");
  		setFocus("Type");
	</script>
