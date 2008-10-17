<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Nature" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Qualité du demandeur
          </p>
          <p class="text">
            <cvqf:select name="requesterQuality" mode="static">
              <option value="">Choisissez un qualité du demandeur</option>
              <option value="Requester">Titulaire de l'acte</option>
              <option value="Spouse">Son conjoint</option>
              <option value="Parent">Son père / sa mère</option>
              <option value="GrandParent">Son grand-père / sa grand-mère</option>
              <option value="Child">Son fils / sa fille</option>
              <option value="LegalRepresentant">Son représentant légal</option>
              <option value="Agent">Son mandataire</option>
              <option value="HeirFamily">Son héritier et aussi son frère ou sa soeur</option>
              <option value="Heir">Son héritier sans être son frère ou sa soeur</option>
              <option value="Authorized">Autorisé par le procureur de la République</option>
              <option value="LawyerNotary">Avocat, notaire</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Précisez
          </p>
          <p class="text">
            <cvqf:text name="requesterQualityPrecision" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom
          </p>
          <p class="text">
            <cvqf:text name="birthLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom(s)
          </p>
          <p class="text">
            <cvqf:text name="birthFirstNames" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date de naissance
          </p>
          <p class="text">
            <cvqf:text name="birthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Ville de naissance
          </p>
          <p class="text">
            <cvqf:text name="birthCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Département de naissance
          </p>
          <p class="text">
            <cvqf:text name="birthPostalCode" mode="static" maxlength="2"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Nature");
	</script>
