<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Absencedate" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="date_row">
			<label for="absenceStartDate" class="label">Date de début d'absence<span class="required">*</span></label>
            <cvqf:text name="absenceStartDate" mode="" maxlength="10"/>
          </li>
          <li class="date_row">
			<label for="absenceEndDate" class="label">Date de fin d'absence<span class="required">*</span></label>
            <cvqf:text name="absenceEndDate" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.absenceStartDate = new Function("key","this.label='Date de début d&quote;absence'; this.msg=null; this.required=true; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
     		  this.absenceEndDate = new Function("key","this.label='Date de fin d&quote;absence'; this.msg=null; this.required=true; this.mask=/[0-9]{1,2}[\\/][0-9]{1,2}[\\/][0-9]{4}/; this.minlength=0; this.maxlength=10; this.transform='date'; this.type=null; return this[key];");
  		}
  		setFocus("Absencedate");
	</script>
