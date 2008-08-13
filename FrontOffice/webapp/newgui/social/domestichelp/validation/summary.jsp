<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <cvqf:title stage="Subject"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom de jeune fille : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultMaidenName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Né(e) le : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Ville : 
          </p>
          <p class="text">
            <cvqf:text name="subjectAdultBirthPlaceCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Numéro de Sécurité Sociale : 
          </p>
          <p class="text">
            <cvqf:text name="socialSecurityNumber" mode="static" maxlength="13"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Clé du numéro de Sécurité Sociale : 
          </p>
          <p class="text">
            <cvqf:text name="socialSecurityKeyNumber" mode="static" maxlength="2"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nationalité : 
          </p>
          <p class="text">
            <cvqf:select name="nationality" mode="static">
              <option value="">Choisissez un nationalité</option>
              <option value="French">Française</option>
              <option value="EuropeanUnion">Union Européenne</option>
              <option value="OutsideEuropeanUnion">Hors Union Européenne</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Date d'arrivée en France : 
          </p>
          <p class="text">
            <cvqf:text name="franceArrivalDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Régime de retraite : 
          </p>
          <p class="text">
            <cvqf:select name="requesterPensionPlan" mode="static">
              <option value="">Choisissez un régime de retraite</option>
              <option value="CRAMIF">CRAMIF</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom de jeune fille : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationMaidenName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Né(e) le : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Ville : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationBirthPlaceCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Numéro de sécurité sociale : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseSocialSecurityNumber" mode="static" maxlength="13"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Clé de numéro de sécurité sociale : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseSocialSecurityKeyNumber" mode="static" maxlength="2"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nationalité : 
          </p>
          <p class="text">
            <cvqf:select name="requesterSpouseSpouseNationality" mode="static">
              <option value="">Choisissez un nationalité</option>
              <option value="French">Française</option>
              <option value="EuropeanUnion">Union Européenne</option>
              <option value="OutsideEuropeanUnion">Hors Union Européenne</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Date d'arrivée en France : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseFranceArrivalDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Retraité : 
          </p>
          <p class="text">
            <cvqf:radio name="requesterSpouseSpousePensionner" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Régime retraite : 
          </p>
          <p class="text">
            <cvqf:select name="requesterSpouseSpousePensionPlan" mode="static">
              <option value="">Choisissez un régime retraite</option>
              <option value="CRAMIF">CRAMIF</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Profession : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseOccupation" mode="static" maxlength="50"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Employeur : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseEmployer" mode="static" maxlength="50"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App. :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés. :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">
            Présence d'un tuteur : 
          </p>
          <p class="text">
            <cvqf:radio name="requesterSituationTutorPresence" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Mesure : 
          </p>
          <p class="text">
            <cvqf:select name="requesterSituationTutor" mode="static">
              <option value="">Choisissez un mesure</option>
              <option value="SauvegardeJustice">Sauvegarde de Justice</option>
              <option value="Tutelle">Tutelle</option>
              <option value="Curatelle">Curatelle</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSituationTutorName" mode="static" maxlength="38"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Residence"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Prénom : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSituationTutorFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App. :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSituationTutorAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés. :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSituationTutorAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSituationTutorAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterSituationTutorAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSituationTutorAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité :				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSituationTutorAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterSituationTutorAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App. :				
          </p>
          <p class="text">
    		<cvqf:text name="currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés. :				
          </p>
          <p class="text">
    		<cvqf:text name="currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie :				
          </p>
          <p class="text">
    		<cvqf:text name="currentDwellingCurrentDwellingAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="currentDwellingCurrentDwellingAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale :				
          </p>
          <p class="text">
    		<cvqf:text name="currentDwellingCurrentDwellingAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité :				
          </p>
          <p class="text">
    		<cvqf:text name="currentDwellingCurrentDwellingAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="currentDwellingCurrentDwellingAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">
            Nature de la résidence : 
          </p>
          <p class="text">
            <cvqf:select name="currentDwellingCurrentDwellingType" mode="static">
              <option value="">Choisissez un nature de la résidence</option>
              <option value="Domicile">Domicile</option>
              <option value="EtablissmentPA">Etablissment PA</option>
              <option value="AccueilParticulierOnereux">Accueil particulier à titre onéreux</option>
              <option value="Autre">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Date d'arrivée : 
          </p>
          <p class="text">
            <cvqf:text name="currentDwellingCurrentDwellingArrivalDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Statut Habitation : 
          </p>
          <p class="text">
            <cvqf:select name="currentDwellingCurrentDwellingStatus" mode="static">
              <option value="">Choisissez un statut habitation</option>
              <option value="Owner">Propriétaire</option>
              <option value="Tenant">Locataire</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nombre de pièces : 
          </p>
          <p class="text">
            <cvqf:text name="currentDwellingCurrentDwellingRoomNumber" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Surface habitable : 
          </p>
          <p class="text">
            <cvqf:text name="currentDwellingCurrentDwellingNetFloorArea" mode="static" maxlength="10"/>
          </p>
        </li>
        <cvqf:list name="fr.cg95.cvq.fo.common.Request" property="list(residences)">
          <previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
          <previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
          <previousDwellingsPreviousDwellingAddressStreetNumber,Numéro>
          <previousDwellingsPreviousDwellingAddressStreetName,Libellé de la voie>
          <previousDwellingsPreviousDwellingAddressPlaceNameOrService,Lieu-dit ou boite postale>
          <previousDwellingsPreviousDwellingAddressPostalCode,Code postal>
          <previousDwellingsPreviousDwellingAddressCity,Localité>
          <previousDwellingsPreviousDwellingArrivalDate,Date d'arrivée>
          <previousDwellingsPreviousDwellingDepartureDate,Date de départ>
        </cvqf:list>
      </ul>
      <cvqf:title stage="Resources"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Pensions et retraites : 
          </p>
          <p class="text">
            <cvqf:text name="requesterIncomesRequesterPensions" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Allocations diverses : 
          </p>
          <p class="text">
            <cvqf:text name="requesterIncomesRequesterAllowances" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Revenus du capital : 
          </p>
          <p class="text">
            <cvqf:text name="requesterIncomesRequesterInvestmentIncome" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Salaire : 
          </p>
          <p class="text">
            <cvqf:text name="requesterIncomesRequesterNetIncome" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Pensions et retraites : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseIncomesSpousePensions" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Allocations diverses : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseIncomesSpouseAllowances" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Revenus du capital : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseIncomesSpouseInvestmentIncome" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Salaire : 
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseIncomesSpouseNetIncome" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Patrimony"/>
      <ul class="validation_list">
        <cvqf:list name="fr.cg95.cvq.fo.common.Request" property="list(assets)">
          <realAssetsRealAssetAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
          <realAssetsRealAssetAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
          <realAssetsRealAssetAddressStreetNumber,Numéro>
          <realAssetsRealAssetAddressStreetName,Libellé de la voie>
          <realAssetsRealAssetAddressPlaceNameOrService,Lieu-dit ou boite postale>
          <realAssetsRealAssetAddressPostalCode,Code postal>
          <realAssetsRealAssetAddressCity,Localité>
          <realAssetsRealAssetValue,Valeur du bien>
          <realAssetsRealAssetNetFloorArea,Superficie du bien>
          <realAssetsRealAssetCadastre,Cadastre du bien>
        </cvqf:list>
        <cvqf:list name="fr.cg95.cvq.fo.common.Request" property="list(donation)">
          <donationsDonationAsset,Nature du bien,Immobilier=Immobilier,Autre=Autre>
          <donationsDonationAssetPlace,Lieu>
          <donationsDonationBeneficiaryName,Nom du bénéficiaire>
          <donationsDonationBeneficiaryFirstName,Prénom du bénéficiaire>
          <donationsDonationValue,Valeur de la donation>
          <donationsDonationDate,Date de la donation>
          <donationsDonationNotaryName,Nom du notaire>
          <donationsDonationNotaryFirstName,Prénom du notaire>
          <donationsDonationNotaryAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
          <donationsDonationNotaryAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
          <donationsDonationNotaryAddressStreetNumber,Numéro>
          <donationsDonationNotaryAddressStreetName,Libellé de la voie>
          <donationsDonationNotaryAddressPlaceNameOrService,Lieu-dit ou boite postale>
          <donationsDonationNotaryAddressPostalCode,Code postal>
          <donationsDonationNotaryAddressCity,Localité>
        </cvqf:list>
        <cvqf:list name="fr.cg95.cvq.fo.common.Request" property="list(savings)">
          <savingsPaybookNumber,Numéro de Livret>
          <savingsPaybookAmount,Montant du Livret>
        </cvqf:list>
        <li class="text_row">
          <p class="label">
            Montant actions : 
          </p>
          <p class="text">
            <cvqf:text name="capitalsSharesAmount" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Montant obligations : 
          </p>
          <p class="text">
            <cvqf:text name="capitalsBondsAmount" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Impôt sur le revenu : 
          </p>
          <p class="text">
            <cvqf:text name="taxesAmountIncomeTax" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Taxe d'habitation : 
          </p>
          <p class="text">
            <cvqf:text name="taxesAmountLocalRate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Taxes foncières : 
          </p>
          <p class="text">
            <cvqf:text name="taxesAmountPropertyTaxes" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Taxes professionnelles : 
          </p>
          <p class="text">
            <cvqf:text name="taxesAmountProfessionalTaxes" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
      <cvqf:title stage="Expenses"/>
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Loyer : 
          </p>
          <p class="text">
            <cvqf:text name="mensualExpensesRent" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Pensions et obligations alimentaires : 
          </p>
          <p class="text">
            <cvqf:text name="mensualExpensesAlimonies" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
