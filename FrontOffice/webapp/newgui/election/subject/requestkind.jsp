<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row_inline">
			<label for="requestInformationRequestInformationKind" class="">Type de la demande<span class="required">*</span></label>
            <cvqf:radio name="requestInformationRequestInformationKind" mode="inline">
              <option value="First">Première demande</option>
              <option value="Renewal">Renouvellement</option>
            </cvqf:radio>
		  </li>
        </ul>
        <ul class="insert_list" id="Renewal">
          <li class="date_row">
			<label for="requestInformationRequestInformationExpirationDate" class="label">Date d'échéance<span class="required">*</span></label>
            <cvqf:text name="requestInformationRequestInformationExpirationDate" mode="inline" maxlength="10"/>
          </li>
        </ul>
		<br class="clear-both" />
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.requestInformationRequestInformationKind = new Function("key","this.label='Type de la demande'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.requestInformationRequestInformationExpirationDate = new Function("key","this.label='Date d&quote;échéance'; this.msg=null; this.required=true; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
  		}
        updateDisplay("requestInformationRequestInformationKind");
  		setFocus("Subject");
	</script>
