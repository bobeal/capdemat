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
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.copies = new Function("key","this.label='Nombre d&quote;actes'; this.msg=null; this.required=true; this.mask=/^[0-9]+$/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.comment = new Function("key","this.label='Commentaire'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.motive = new Function("key","this.label='Motif'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("motive");
  		setFocus("Type");
	</script>
