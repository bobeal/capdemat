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
          <li class="select_row">
			<label for="relationship" class="label">Filiation de<span class="required">*</span></label>
            <cvqf:select name="relationship" mode="">
              <option value="">Choisissez un filiation de</option>
              <option value="Husband">L'époux</option>
              <option value="Wife">L'épouse</option>
            </cvqf:select>
          </li>
          <li class="text_row">
			<label for="fatherLastName" class="label">Nom du père<span class="required">*</span></label>
            <cvqf:text name="fatherLastName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="fatherFirstNames" class="label">Prénom(s) du père<span class="required">*</span></label>
            <cvqf:text name="fatherFirstNames" mode=""/>
          </li>
          <li class="text_row">
			<label for="motherMaidenName" class="label">Nom de jeune fille de la mère<span class="required">*</span></label>
            <cvqf:text name="motherMaidenName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="motherFirstNames" class="label">Prénom(s) de la mère<span class="required">*</span></label>
            <cvqf:text name="motherFirstNames" mode=""/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.copies = new Function("key","this.label='Nombre d&quote;actes souhaité'; this.msg=null; this.required=true; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.usage = new Function("key","this.label='Usage'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.relationship = new Function("key","this.label='Filiation de'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.fatherLastName = new Function("key","this.label='Nom du père'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.fatherFirstNames = new Function("key","this.label='Prénom(s) du père'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.motherMaidenName = new Function("key","this.label='Nom de jeune fille de la mère'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.motherFirstNames = new Function("key","this.label='Prénom(s) de la mère'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("relationship");
  		setFocus("Type");
	</script>
