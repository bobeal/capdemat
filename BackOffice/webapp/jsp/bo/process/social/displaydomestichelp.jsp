<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
    <div class="block009">
     <p class="text005 pictoTable">Formulaire</p>
   </div>
   <div class="block010">
     <fieldset class="fieldset005">
 
         <div class="form_cell">
         <label for"" class="label temp_title_class">Informations administratives de la personne concernée</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultLastName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultMaidenName" class="label">Nom de jeune fille :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultMaidenName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultBirthDate" class="label">Né(e) le :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultBirthDate"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectAdultBirthPlaceCity" class="label">Ville :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectAdultBirthPlaceCity"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="socialSecurityNumber" class="label">Numéro de Sécurité Sociale :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="socialSecurityNumber" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="socialSecurityKeyNumber" class="label">Clé du numéro de Sécurité Sociale :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="socialSecurityKeyNumber" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="nationality" class="label">Nationalité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="nationality" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="franceArrivalDate" class="label">Date d'arrivée en France :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="franceArrivalDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterPensionPlan" class="label">Régime retraite du demandeur :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterPensionPlan" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for"" class="label temp_title_class">Informations administratives du conjoint</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseInformationLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseInformationLastName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseInformationFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseInformationFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseInformationMaidenName" class="label">Nom de jeune fille :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseInformationMaidenName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseInformationBirthDate" class="label">Né(e) le :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseInformationBirthDate"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseInformationBirthPlaceCity" class="label">Ville :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseInformationBirthPlaceCity"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseSocialSecurityNumber" class="label">Numéro de sécurité sociale :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseSocialSecurityNumber" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseSocialSecurityKeyNumber" class="label">Clé de numéro de sécurité sociale :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseSocialSecurityKeyNumber" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseNationality" class="label">Nationalité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseNationality" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseFranceArrivalDate" class="label">Date d'arrivée en France :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseFranceArrivalDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpousePensionner" class="label">Retraité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpousePensionner" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpousePensionPlan" class="label">Régime retraite :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpousePensionPlan" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseOccupation" class="label">Profession :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseOccupation" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployer" class="label">Employeur :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseSpouseEmployer" id="id" profile="profile"/>
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSpouseSpouseEmployerAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSpouseSpouseEmployerAddressCity" id="id" profile="profile" />
         </span>
       </div>
           <div class="form_cell">
         <label for"" class="label temp_title_class">Informations administratives du tuteur</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSituationTutorPresence" class="label">Présence d'un tuteur :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSituationTutorPresence" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSituationTutor" class="label">Mesure :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSituationTutor" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSituationTutorName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSituationTutorName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSituationTutorFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSituationTutorFirstName" id="id" profile="profile"/>
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="requesterSituationTutorAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="requesterSituationTutorAddressCity" id="id" profile="profile" />
         </span>
       </div>
           <div class="form_cell">
         <label for"" class="label temp_title_class">Habitation</label>
         <span class="input"></span>
       </div>
               <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="currentDwellingCurrentDwellingAddressCity" id="id" profile="profile" />
         </span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingType" class="label">Nature de la résidence :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentDwellingCurrentDwellingType" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingArrivalDate" class="label">Date d'arrivée :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentDwellingCurrentDwellingArrivalDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingStatus" class="label">Statut Habitation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentDwellingCurrentDwellingStatus" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingRoomNumber" class="label">Nombre de pièces :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentDwellingCurrentDwellingRoomNumber" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="currentDwellingCurrentDwellingNetFloorArea" class="label">Surface habitable :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="currentDwellingCurrentDwellingNetFloorArea" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="previousDwellings" class="label">Habitation(s) antérieure(s) :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="previousDwellings">
                        <previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
		<previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
		<previousDwellingsPreviousDwellingAddressStreetNumber,Numéro>
		<previousDwellingsPreviousDwellingAddressStreetName,Libellé de la voie>
		<previousDwellingsPreviousDwellingAddressPlaceNameOrService,Lieu-dit, boite postale>
		<previousDwellingsPreviousDwellingAddressPostalCode,Code postal>
		<previousDwellingsPreviousDwellingAddressCity,Localité>
        	                <previousDwellingsPreviousDwellingArrivalDate,Date d'arrivée>
        	                <previousDwellingsPreviousDwellingDepartureDate,Date de départ>
        	  	</cvq:toggleInput>
    	</span>
       </div>
           <div class="form_cell">
         <label for"" class="label temp_title_class">Pensions et retraites</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterIncomesRequesterPensions" class="label">Pensions et retraites :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterIncomesRequesterPensions" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterIncomesRequesterAllowances" class="label">Allocations diverses :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterIncomesRequesterAllowances" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterIncomesRequesterInvestmentIncome" class="label">Revenus du capital :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterIncomesRequesterInvestmentIncome" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterIncomesRequesterNetIncome" class="label">Salaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterIncomesRequesterNetIncome" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterIncomesRequesterIncomesAnnualTotal" class="label">Total annuel :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterIncomesRequesterIncomesAnnualTotal" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseIncomesSpousePensions" class="label">Pensions et retraites :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseIncomesSpousePensions" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseIncomesSpouseAllowances" class="label">Allocations diverses :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseIncomesSpouseAllowances" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseIncomesSpouseInvestmentIncome" class="label">Revenus du capital :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseIncomesSpouseInvestmentIncome" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseIncomesSpouseNetIncome" class="label">Salaire :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseIncomesSpouseNetIncome" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="requesterSpouseIncomesSpouseIncomesAnnualTotal" class="label">Total annuel :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="requesterSpouseIncomesSpouseIncomesAnnualTotal" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="realAssets" class="label">Bien(s) immobilier(s) du foyer :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="realAssets">
                        <realAssetsRealAssetAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
		<realAssetsRealAssetAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
		<realAssetsRealAssetAddressStreetNumber,Numéro>
		<realAssetsRealAssetAddressStreetName,Libellé de la voie>
		<realAssetsRealAssetAddressPlaceNameOrService,Lieu-dit, boite postale>
		<realAssetsRealAssetAddressPostalCode,Code postal>
		<realAssetsRealAssetAddressCity,Localité>
        	                <realAssetsRealAssetValue,Valeur du bien>
        	                <realAssetsRealAssetNetFloorArea,Superficie du bien>
        	                <realAssetsRealAssetCadastre,Cadastre du bien>
        	  	</cvq:toggleInput>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="realAssetsValuesTotal" class="label">Valeur totale des biens immobiliers :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="realAssetsValuesTotal"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for"" class="label temp_title_class">Patrimoine - Donations</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="donations" class="label">Bien(s) partagé(s) et donation(s) :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="donations">
                    <donationsDonationAsset,Nature du bien>
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
		<donationsDonationNotaryAddressPlaceNameOrService,Lieu-dit, boite postale>
		<donationsDonationNotaryAddressPostalCode,Code postal>
		<donationsDonationNotaryAddressCity,Localité>
        	  	</cvq:toggleInput>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="donationsValuesTotal" class="label">Valeur totale des biens en donation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="donationsValuesTotal"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for"" class="label temp_title_class">Patrimoine - Epargne</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="savings" class="label">Biens(s) mobilier(s) et épargne(s) - Livrets et Compte :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="savings">
                    <savingsPaybookNumber,Numéro de Livret>
        	                <savingsPaybookAmount,Montant du Livret>
        	  	</cvq:toggleInput>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="savingsTotal" class="label">Valeur totale des Livrets et Comptes :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="savingsTotal"/>
    
    	</span>
       </div>
           <div class="form_cell">
         <label for"" class="label temp_title_class">Patrimoine - Capital et Taxes</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="capitalsSharesAmount" class="label">Montant actions :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="capitalsSharesAmount"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="capitalsBondsAmount" class="label">Montant obligations :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="capitalsBondsAmount"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="capitalsCapitalAmountTotal" class="label">Montant total annuel du capital placé :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="capitalsCapitalAmountTotal"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="taxesAmountIncomeTax" class="label">Impôt sur le revenu :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="taxesAmountIncomeTax" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="taxesAmountLocalRate" class="label">Taxe d'habitation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="taxesAmountLocalRate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="taxesAmountPropertyTaxes" class="label">Taxes foncières :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="taxesAmountPropertyTaxes" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="taxesAmountProfessionalTaxes" class="label">Taxes professionnelles :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="taxesAmountProfessionalTaxes" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="taxesAmountTaxesTotal" class="label">Total des impôts et taxes :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="taxesAmountTaxesTotal" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell">
         <label for"" class="label temp_title_class">Charges</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="mensualExpensesRent" class="label">Loyer :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="mensualExpensesRent" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="mensualExpensesAlimonies" class="label">Pensions et obligations alimentaires :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="mensualExpensesAlimonies" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="mensualExpensesExpensesTotal" class="label">Total charges :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="mensualExpensesExpensesTotal" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                                                                          		this.nationality = new Function("key","this.values=new Array('Française','Union Européenne','Hors Union Européenne'); return this[key];");
                                                  		this.requesterPensionPlan = new Function("key","this.values=new Array('CRAMIF','Autre'); return this[key];");
                                                                                        		this.requesterSpouseSpouseNationality = new Function("key","this.values=new Array('Française','Union Européenne','Hors Union Européenne'); return this[key];");
                                                                        		this.requesterSpouseSpousePensionPlan = new Function("key","this.values=new Array('CRAMIF','Autre'); return this[key];");
                                                                                                    		this.requesterSituationTutorPresence = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.requesterSituationTutor = new Function("key","this.values=new Array('Sauvegarde de Justice','Tutelle','Curatelle'); return this[key];");
                                                                                                                          		this.currentDwellingCurrentDwellingType = new Function("key","this.values=new Array('Domicile','Etablissment PA','Accueil particulier à titre onéreux','Autre'); return this[key];");
                                                  		this.currentDwellingCurrentDwellingStatus = new Function("key","this.values=new Array('Propriétaire','Locataire'); return this[key];");
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        		}
</script>
 <div class="clear-both"></div>

