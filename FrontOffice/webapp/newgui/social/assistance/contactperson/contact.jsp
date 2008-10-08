<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Contactperson" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Personne à contacter pour la mise en oeuvre de la télé-assistance :</h3>
        <ul class="insert_list">
          <li class="select_row">
			<label for="contact" class="label">Type de contact</label>
            <cvqf:select name="contact" mode="">
              <option value="">Choisissez un type de contact</option>
              <option value="Requester">Demandeur</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </li>
        </ul>
        <ul class="insert_list" id="Other">
          <li class="text_row">
			<label for="contactName" class="label">Nom du contact</label>
            <cvqf:text name="contactName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="contactFirstName" class="label">Prénom du contact</label>
            <cvqf:text name="contactFirstName" mode="" maxlength="38"/>
          </li>
          <li class="phone_row">
			<label for="contactPhone" class="label">Téléphone du contact</label>
            <cvqf:text name="contactPhone" mode="" maxlength="10"/>
            <span class="inline_text">ex: 0102030405</span>
          </li>
        </ul>
		<br class="clear-both" />
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.contact = new Function("key","this.label='Type de contact'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.contactName = new Function("key","this.label='Nom du contact'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.contactFirstName = new Function("key","this.label='Prénom du contact'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.contactPhone = new Function("key","this.label='Téléphone du contact'; this.msg=null; this.required=false; this.mask=/^0[1-9][0-9]{8}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
        updateDisplay("contact");
  		setFocus("Contactperson");
	</script>
