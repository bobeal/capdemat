<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <cvqf:title stage="Cadastre"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Agissant en qualité de : 
          </p>
          <p class="text">
            <cvqf:radio name="requesterQuality" mode="static">
              <option value="Owner">Propriétaire</option>
              <option value="Tenant">Locataire</option>
            </cvqf:radio>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Section : 
          </p>
          <p class="text">
            <cvqf:text name="section" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Numéro : 
          </p>
          <p class="text">
            <cvqf:text name="number" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Lieu-dit : 
          </p>
          <p class="text">
            <cvqf:text name="locality" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Voie de communication : 
          </p>
          <p class="text">
            <cvqf:text name="transportationRoute" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Immeuble de plus de 2 ans : 
          </p>
          <p class="text">
            <cvqf:radio name="moreThanTwoYears" mode="static" label="[Oui,Non]" />
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
