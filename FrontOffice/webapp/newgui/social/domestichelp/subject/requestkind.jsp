<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row_inline">
			<label for="requesterRequestKind" class="">Type de la demande<span class="required">*</span></label>
            <cvqf:radio name="requesterRequestKind" mode="inline">
              <option value="Individual">Individuelle</option>
              <option value="Couple">Couple</option>
            </cvqf:radio>
		  </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.requesterRequestKind = new Function("key","this.label='Type de la demande'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("requesterRequestKind");
  		setFocus("Subject");
	</script>
