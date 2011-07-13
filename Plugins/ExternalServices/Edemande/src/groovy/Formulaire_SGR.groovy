<moGeneral type="noeud" nom="DEMANDE">
 <mbPremiereDem type="booleen" nom="Indicateur Première Demande">${firstRequest}</mbPremiereDem>
 <mdtDateCreation type="date" nom="Date de validation de la demande par l'étudiant">${creationDate}</mdtDateCreation>
 <msRIB type="texte" nom="RIB">${frenchRIB}</msRIB>
</moGeneral>
<moFoyerFiscal type="noeud" nom="FOYER FISCAL">
 <mdMtRevenuBrutGlobal type="montant" nom="Revenu brut global pour l'année 2009 et inférieur à 32 000 euros">${taxHouseholdIncome}</mdMtRevenuBrutGlobal>
 <msSecto type="texte" nom="Sectorisation hors 77">${taxHouseholdCityPrecision}</msSecto>
</moFoyerFiscal>
<moAutresAides type="noeud" nom="AUTRES AIDES">
 <mbAideCROUS type="booleen" nom="Aide CROUS">${hasCROUSHelp}</mbAideCROUS>
 <mbAideCR type="booleen" nom="Aide du Conseil Régional">${hasRegionalCouncilHelp}</mbAideCR>
 <mbAideEurope type="booleen" nom="Aide Europe">${hasEuropeHelp}</mbAideEurope>
 <mbAideAutres type="booleen" nom="Autres aides obtenues">${hasOtherHelp}</mbAideAutres>
</moAutresAides>
<moEtudes type="noeud" nom="ETUDES EN COURS">
 <miAnneeBac type="entier" nom="Année d'obtention du baccalauréat">${AlevelsDate}</miAnneeBac>
 <msTypeBac type="texte" nom="Type de baccalauréat">${AlevelsType}</msTypeBac>
 <msDiplomePrepare type="texte" nom="Diplôme préparé">${currentStudiesType}</msDiplomePrepare>
 <msDiplomeNiveau type="texte" nom="Niveau diplôme">${currentStudiesLevel}</msDiplomeNiveau>
 <mbEtudeAlternance type="booleen" nom="Etudes en alternance">${sandwichCourses}</mbEtudeAlternance>
 <mbStageEtranger type="booleen" nom="Stage conventionné à l'étranger">${abroadInternship}</mbStageEtranger>
 <mdtDateDebutStage type="date" nom="Date de début de stage">${abroadInternshipStartDate}</mdtDateDebutStage>
 <mdtDateFinStage type="date" nom="Date de fin de stage">${abroadInternshipEndDate}</mdtDateFinStage>
</moEtudes>
<moEtablissement type="noeud" nom="ETABLISSEMENT SCOLAIRE">
 <msNomEtab type="texte" nom="Nom de l'établissement">${currentSchoolName}</msNomEtab>
 <miCPEtab type="entier" nom="Code postal de l'établissement">${currentSchoolAddress.postalCode}</miCPEtab>
 <msVilleEtab type="texte" nom="Ville de l'établissement">${currentSchoolAddress.city}</msVilleEtab>
 <msPaysEtab type="texte" nom="Pays de l'établissement">${currentSchoolAddress.countryName}</msPaysEtab>
 <msNomEtabAccueil type="texte" nom="Nom de l'établissement d'accueil à l'étranger">${abroadInternshipSchoolName}</msNomEtabAccueil>
 <msPaysEtabAccueil type="texte" nom="Pays de l'établissement d'accueil à l'étranger">${abroadInternshipSchoolCountry}</msPaysEtabAccueil>
</moEtablissement>
<moCalcul type="noeud" nom="ELEMENTS DE CALCUL">
 <msElementCalculDistance type="texte" nom="Elément de calcul de la bourse">${distance}</msElementCalculDistance>
</moCalcul>
