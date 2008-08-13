<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Description" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="interventionDescription" class="label">Description de l'intervention<span class="required">*</span></label>
            <cvqf:text name="interventionDescription" mode="" rows="5"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.interventionDescription = new Function("key","this.label='Description de l&quote;intervention'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
  		setFocus("Description");
	</script>
