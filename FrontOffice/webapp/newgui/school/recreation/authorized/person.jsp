<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Authorized" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="otherIndividualLastName" class="label">Nom<span class="required">*</span></label>
            <cvqf:text name="otherIndividualLastName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="otherIndividualFirstName" class="label">Prénom<span class="required">*</span></label>
            <cvqf:text name="otherIndividualFirstName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="otherIndividualAddress" class="label">Adresse<span class="required">*</span></label>
            <cvqf:text name="otherIndividualAddress" mode="" rows="3"/>
          </li>
          <li class="phone_row">
			<label for="otherIndividualHomePhone" class="label">Téléphone domicile</label>
            <cvqf:text name="otherIndividualHomePhone" mode="" maxlength="10"/>
          </li>
          <li class="phone_row">
			<label for="otherIndividualOfficePhone" class="label">Téléphone bureau</label>
            <cvqf:text name="otherIndividualOfficePhone" mode="" maxlength="10"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.otherIndividualLastName = new Function("key","this.label='Nom'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.otherIndividualFirstName = new Function("key","this.label='Prénom'; this.msg=null; this.required=true; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.otherIndividualAddress = new Function("key","this.label='Adresse'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.otherIndividualHomePhone = new Function("key","this.label='Téléphone domicile'; this.msg=null; this.required=false; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.otherIndividualOfficePhone = new Function("key","this.label='Téléphone bureau'; this.msg=null; this.required=false; this.mask=/[0-9]{10}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
  		setFocus("Authorized");
	</script>
