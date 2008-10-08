<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Keydeposit" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Personne dépositaire des clés en cas d'absence du demandeur :</h3>
        <ul class="insert_list">
          <li class="select_row">
			<label for="trustee" class="label">Type de dépositaire</label>
            <cvqf:select name="trustee" mode="">
              <option value="">Choisissez un type de dépositaire</option>
              <option value="Requester">Demandeur</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </li>
        </ul>
        <ul class="insert_list" id="Other">
          <li class="text_row">
			<label for="trusteeName" class="label">Nom du dépositaire</label>
            <cvqf:text name="trusteeName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="trusteeFirstName" class="label">Prénom du dépositaire</label>
            <cvqf:text name="trusteeFirstName" mode="" maxlength="38"/>
          </li>
          <li class="phone_row">
			<label for="trusteePhone" class="label">Téléphone du dépositaire</label>
            <cvqf:text name="trusteePhone" mode="" maxlength="10"/>
            <span class="inline_text">ex: 0102030405</span>
          </li>
        </ul>
		<br class="clear-both" />
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.trustee = new Function("key","this.label='Type de dépositaire'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.trusteeName = new Function("key","this.label='Nom du dépositaire'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.trusteeFirstName = new Function("key","this.label='Prénom du dépositaire'; this.msg=null; this.required=false; this.mask=/[A-Z]?.*/; this.minlength=0; this.maxlength=38; this.transform='firstupper'; this.type=null; return this[key];");
     		  this.trusteePhone = new Function("key","this.label='Téléphone du dépositaire'; this.msg=null; this.required=false; this.mask=/^0[1-9][0-9]{8}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
  		}
        updateDisplay("trustee");
  		setFocus("Keydeposit");
	</script>
