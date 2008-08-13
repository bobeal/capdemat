<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <cvqf:title stage="Inscription"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectChildLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectChildFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Né(e) le : 
          </p>
          <p class="text">
            <cvqf:text name="subjectChildBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Téléphone en cas d'urgence : 
          </p>
          <p class="text">
            <cvqf:text name="urgencyPhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Activités périscolaires : 
          </p>
          <p class="text">
            <cvqf:check name="perischoolActivity" mode="static" repository="activityList">
            </cvqf:check>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Contact"/>
      <ul class="validation_list">
        <cvqf:list name="fr.cg95.cvq.fo.common.Request" property="list(contact)">
          <otherIndividualLastName,Nom>
          <otherIndividualFirstName,Prénom>
          <otherIndividualAddress,Adresse>
          <otherIndividualHomePhone,Téléphone domicile>
          <otherIndividualOfficePhone,Téléphone bureau>
        </cvqf:list>
      </ul>
      <cvqf:title stage="Authorized"/>
      <ul class="validation_list">
        <cvqf:list name="fr.cg95.cvq.fo.common.Request" property="list(authorized)">
          <otherIndividualLastName,Nom>
          <otherIndividualFirstName,Prénom>
          <otherIndividualAddress,Adresse>
          <otherIndividualHomePhone,Téléphone domicile>
          <otherIndividualOfficePhone,Téléphone bureau>
        </cvqf:list>
      </ul>
      <cvqf:title stage="Rules"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            J'accepte et je m'engage à respecter le règlement : 
          </p>
          <p class="text">
            <cvqf:radio name="rulesAndRegulationsAcceptance" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            J'autorise les sorties à mon enfant : 
          </p>
          <p class="text">
            <cvqf:radio name="classTripPermission" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            J'autorise l'exposition et la diffusion des photographies de mon enfant : 
          </p>
          <p class="text">
            <cvqf:radio name="childPhotoExploitationPermission" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            J'autorise l'hospitalisation de mon enfant : 
          </p>
          <p class="text">
            <cvqf:radio name="hospitalizationPermission" mode="static" label="[Oui,Non]" />
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
