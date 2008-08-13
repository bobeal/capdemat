<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <cvqf:title stage="Adult"/>
      <ul class="validation_list">
        <cvqf:list name="fr.cg95.cvq.fo.common.Request" property="list(adult)">
          <adultTitle,Civilité,Mister=Monsieur,Madam=Madame,Miss=Mademoiselle,Agency=Organisme,Unknown=Inconnue>
          <adultLastName,Nom>
          <adultFirstName,Prénom>
          <adultFirstName2,2ème prénom>
          <adultFirstName3,3ème prénom>
          <adultMaidenName,Nom de jeune fille>
          <adultNameOfUse,Nom d'usage>
          <adultFamilyStatus,Situation familiale,Married=Marié(e),Single=Célibataire,Divorced=Divorcé(e),Widow=Veuf(ve),CommonLawMarriage=Concubinage,Other=Autre>
          <adultBirthDate,Date de naissance>
          <adultBirthPlaceCity,Ville>
          <adultBirthPlacePostalCode,Code postal>
          <adultAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
          <adultAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
          <adultAddressStreetNumber,Numéro>
          <adultAddressStreetName,Libellé de la voie>
          <adultAddressPlaceNameOrService,Lieu-dit ou boite postale>
          <adultAddressPostalCode,Code postal>
          <adultAddressCity,Localité>
          <adultHomePhone,Domicile>
          <adultOfficePhone,Bureau>
          <adultMobilePhone,Portable>
          <adultEmail,Courriel>
          <adultCfbn,Numéro CAF>
          <adultProfession,Profession>
        </cvqf:list>
      </ul>
      <cvqf:title stage="Child"/>
      <ul class="validation_list">
        <cvqf:list name="fr.cg95.cvq.fo.common.Request" property="list(child)">
          <childLastName,Nom>
          <childFirstName,Prénom>
          <childFirstName2,2ème prénom>
          <childFirstName3,3ème prénom>
          <childSex,Sexe,Male=Masculin,Female=Féminin,Unknown=Inconnu>
          <childBirthDate,Date de naissance>
          <childBirthPlaceCity,Commune>
          <childBirthPlacePostalCode,Code postal>
          <childBirthPlaceCountry,Pays,EEC=UE,OUTSIDE_EEC=Hors UE>
          <childAdult,Responsables légaux,repository=adults>
          <childLegalResponsible, ,childLegalResponsibleLegalResponsibleFirstName,childLegalResponsibleLegalResponsibleLastName>
        </cvqf:list>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
