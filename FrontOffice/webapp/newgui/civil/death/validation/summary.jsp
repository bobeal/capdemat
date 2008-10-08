<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nom : 
          </p>
          <p class="text">
            <cvqf:text name="deathLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom(s) : 
          </p>
          <p class="text">
            <cvqf:text name="deathFirstNames" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Date de décès : 
          </p>
          <p class="text">
            <cvqf:text name="deathDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Ville de décès : 
          </p>
          <p class="text">
            <cvqf:text name="deathCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Département de décès : 
          </p>
          <p class="text">
            <cvqf:text name="deathPostalCode" mode="static" maxlength="2"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Type"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Type de l'acte : 
          </p>
          <p class="text">
            <cvqf:select name="format" mode="static">
              <option value="">Choisissez un type de l'acte</option>
              <option value="FullCopy">Copie intégrale</option>
              <option value="MultilingualExtract">Extrait plurilingue</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nombre d'actes souhaité : 
          </p>
          <p class="text">
            <cvqf:text name="copies" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Commentaire : 
          </p>
          <p class="text">
            <cvqf:text name="comment" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Motif : 
          </p>
          <p class="text">
            <cvqf:select name="motive" mode="static">
              <option value="">Choisissez un motif</option>
              <option value="NotaryAct">Acte de notaire</option>
              <option value="Marriage">Mariage</option>
              <option value="Passport">Passeport</option>
              <option value="Pension">Pension</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
