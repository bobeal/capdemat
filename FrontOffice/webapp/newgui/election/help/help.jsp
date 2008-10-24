<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Help" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row">
			<label for="writingHelp" class="large_radio_label">Assistance d'une tierce personne pour la formulation des besoins</label>
		  </li>
          <cvqf:radio name="writingHelp" mode="" label="[Oui,Non]" />
        </ul>
        <ul class="insert_list" id="Oui">
          <li class="text_row">
			<label for="helperName" class="label">Nom de l'aidant</label>
            <cvqf:text name="helperName" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="helperResponsability" class="label">Fonction de l'aidant</label>
            <cvqf:text name="helperResponsability" mode=""/>
          </li>
        </ul>
		<br class="clear-both" />
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.writingHelp = new Function("key","this.label='Assistance d&quote;une tierce personne pour la formulation des besoins'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.helperName = new Function("key","this.label='Nom de l&quote;aidant'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.helperResponsability = new Function("key","this.label='Fonction de l&quote;aidant'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("writingHelp");
  		setFocus("Help");
	</script>
