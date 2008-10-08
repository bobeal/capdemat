<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Type" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="copies" class="label">Nombre d'actes<span class="required">*</span></label>
            <cvqf:text name="copies" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="comment" class="label">Commentaire</label>
            <cvqf:text name="comment" mode=""/>
          </li>
          <li class="select_row">
			<label for="motive" class="label">Motif</label>
            <cvqf:select name="motive" mode="">
              <option value="">Choisissez un motif</option>
              <option value="NotaryAct">Acte de notaire</option>
              <option value="FrenchNationalityCertificate">Certificat de nationalité française</option>
              <option value="MaritalRegimeChange">Changement de régime matrimonial</option>
              <option value="FrenchNationalityAcquisitionDeclaration">Déclaration d'acquisition de la nationalité française</option>
              <option value="DivorceSeparation">Divorce, séparation</option>
              <option value="Passport">Passeport</option>
              <option value="Pension">Pension</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </li>
          <li class="select_row">
			<label for="relationship" class="label">Filiation de<span class="required">*</span></label>
            <cvqf:select name="relationship" mode="">
              <option value="">Choisissez un filiation de</option>
              <option value="Husband">L'époux</option>
              <option value="Wife">L'épouse</option>
            </cvqf:select>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Le père :</h3>
        <ul class="insert_list">
          <li class="text_row">
			<label for="fatherLastName" class="label">Nom<span class="required">*</span></label>
            <cvqf:text name="fatherLastName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="fatherFirstNames" class="label">Prénom(s)<span class="required">*</span></label>
            <cvqf:text name="fatherFirstNames" mode=""/>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">La mère :</h3>
        <ul class="insert_list">
          <li class="text_row">
			<label for="motherMaidenName" class="label">Nom de jeune fille<span class="required">*</span></label>
            <cvqf:text name="motherMaidenName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="motherFirstNames" class="label">Prénom(s)<span class="required">*</span></label>
            <cvqf:text name="motherFirstNames" mode=""/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.copies = new Function("key","this.label='Nombre d&quote;actes'; this.msg=null; this.required=true; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.comment = new Function("key","this.label='Commentaire'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.motive = new Function("key","this.label='Motif'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.relationship = new Function("key","this.label='Filiation de'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.fatherLastName = new Function("key","this.label='Nom'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.fatherFirstNames = new Function("key","this.label='Prénom(s)'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.motherMaidenName = new Function("key","this.label='Nom de jeune fille'; this.msg=null; this.required=true; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.motherFirstNames = new Function("key","this.label='Prénom(s)'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("motive");
        updateDisplay("relationship");
  		setFocus("Type");
	</script>
