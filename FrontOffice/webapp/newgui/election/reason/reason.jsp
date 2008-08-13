<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Reason" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row_inline">
			<label for="motive" class=""> </label>
            <cvqf:radio name="motive" mode="static">
              <option value="NewCityResident">Domicilié dans la commune ou y habitant depuis six mois au moins</option>
              <option value="DirectCityContribution">Participe aux contributions directes communales pour la cinquième fois sans interruption</option>
              <option value="CivilServantObligatoryResident">Fonctionnaire public assujetti à résidence obligatoire dans la commune</option>
              <option value="FutureAuthorizedCitizen">Ne remplit pas actuellement les conditions d'âge et de résidence mais les remplira d'ici la clôture définitive des listes</option>
            </cvqf:radio>
		  </li>
          <li class="text_row">
			<label for="subjectOldCity" class="label">Ancienne commune</label>
            <cvqf:text name="subjectOldCity" mode="" maxlength="32"/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.subjectOldCity = new Function("key","this.label='Ancienne commune'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
  		}
  		setFocus("Reason");
	</script>
