<form>
 <FormCommunOrbeon>
  <CBdosDemandeVO>
   <miCode>${psCodeDemande.encodeAsXML()}</miCode>
   <moOrigineApsect>
    <msIdentifiant>${externalRequestId.encodeAsXML()}</msIdentifiant>
    <moApplicatifSectoriel>
     <miCode/>
     <msCodext>EXTSUB</msCodext>
    </moApplicatifSectoriel>
   </moOrigineApsect>
   <affichage/>
   <msStatut>${msStatut.encodeAsXML()}</msStatut>
   <msAdresse>/dep/?formID=dep</msAdresse>
   <msIdentifiant/>
   <msDescription>${"Mobil'études".encodeAsXML()}</msDescription>
   <mdMtProjetHT/>
   <mdMtProjetTTC/>
   <moTvaProjet>
     <miCode>1</miCode>
   </moTvaProjet>
   <moCdr>
    <miCode/>
   </moCdr>
   <moTypDem>
    <msNom>Mobil_Etudes_Extranet</msNom>
    <miCode>${requestTypeCode.encodeAsXML()}</miCode>
    <msLib>Mobil'Etudes 77 Extranet</msLib>
    <msDescri>Bourses Mobil'Etudes 77 - Extranet</msDescri>
    <mvPiecesNec/>
   </moTypDem>
   <moEtatCourant>
     <miCode>${etatCourant}</miCode>
   </moEtatCourant>
   <mbComplet/>
   <moBeneficiaire>
    <miCode/>
   </moBeneficiaire>
   <moDemandeur>
    <miCode/>
    <msQualite/>
    <msNom/>
    <msPrenom/>
    <msFonction>Chargé du suivi de la demande</msFonction>
   </moDemandeur>
   <miAnneeProg/>
   <miMillesime>${millesime.encodeAsXML()}</miMillesime>
   <mdtDateAcc/>
   <mdtDateRec/>
   <mdtDateCre/>
   <mdtDateDecision/>
   <msComment/>
   <msCodext>${msCodext.encodeAsXML()}</msCodext>
   <mdMtDemande/>
   <mvListePiecesReq/>
   <mvListePiecesRecu>
    <% documents.each { document -> %>
     <CBdosPieceRecueVO>
      <msDescri/>
      <msLib>${document.label.encodeAsXML()}</msLib>
      <miNombre>1</miNombre>
      <moDocument>
       <msDescri/>
       <msLib/>
       <miNombre/>
       <moImage>
        <msReferenceExt>${document.filename.encodeAsXML()}</msReferenceExt>
        <mtbFluxBinaire>${document.filename.encodeAsXML()}</mtbFluxBinaire>
        <msSourceImage>${document.remotePath.encodeAsXML()}</msSourceImage>
        <msCle/>
       </moImage>
       <moFormat>
        <msTypeMime>text/plain</msTypeMime>
       </moFormat>
      </moDocument>
     </CBdosPieceRecueVO>
    <% } %>
   </mvListePiecesRecu>
   <mvListeInformations/>
   <moLot/>
   <moLigneDossier/>
  </CBdosDemandeVO>
  <DemandeTiers>
   <CodeAppliSecto>EXTSUB</CodeAppliSecto>
   <NumAppliSecto/>
   <miCode>${psCodeTiers.encodeAsXML()}</miCode>
   <LoginUtilisateurGda/>
   <msNom>${lastName.encodeAsXML()}</msNom>
   <msLib>${lastName.encodeAsXML()}</msLib>
   <moAttach>
    <moProcedure>
     <miCode>27</miCode>
    </moProcedure>
   </moAttach>
   <moTiersVirePrincipal/>
   <mbSeuil/>
   <mbEtranger>false</mbEtranger>
   <mbCollectif>false</mbCollectif>
   <mbBloque>false</mbBloque>
   <msMotifBlocage/>
   <msSiret/>
   <mbGroupement>false</mbGroupement>
   <moModulo>
    <msCodext/>
   </moModulo>
   <msTvaIntra/>
   <moStatut>
    <msDescri>En instance</msDescri>
   </moStatut>
   <moCdrAppartenance>
    <miCode/>
   </moCdrAppartenance>
   <moSectorisation>
    <miCode>${taxHouseholdCityCode.encodeAsXML()}</miCode>
   </moSectorisation>
   <mvAdresses>
    <CTierAdresseVO>
     <msVoie>${address.streetNumber.encodeAsXML()} ${address.streetName.encodeAsXML()}</msVoie>
     <msComplement>${address.additionalDeliveryInformation.encodeAsXML()}</msComplement>
     <miBoitePostale/>
     <msCodePostal>${address.postalCode.encodeAsXML()}</msCodePostal>
     <msVille>${address.city.encodeAsXML()}</msVille>
     <miCedex/>
     <msPays>${address.countryName.encodeAsXML()}</msPays>
     <msTel>${phone.encodeAsXML()}</msTel>
     <msFax/>
     <msMail>${email.encodeAsXML()}</msMail>
     <mbUsuel>true</mbUsuel>
    </CTierAdresseVO>
   </mvAdresses>
   <mvReferencesBancaires>
    <CTierReferenceBancaireVO>
      <moModePaiement>
        <msDescription>Virement bancaire</msDescription>
      </moModePaiement>
      <moAgence>
        <miBanque>${bankCode.encodeAsXML()}</miBanque>
        <miAgence>${counterCode.encodeAsXML()}</miAgence>
      </moAgence>
      <msCompte>${accountNumber.encodeAsXML()}</msCompte>
      <miCleRib>${accountKey.encodeAsXML()}</miCleRib>
      <mbEtranger>false</mbEtranger>
      <mbIban>false</mbIban>
      <mbUsuel>true</mbUsuel>
      <msIntitule/>
      <miBloquee>0</miBloquee>
      <mdtDateBlocage/>
      <msMotifBlocage/>
      <moCdrBloqueur>
        <miCode>0</miCode>
      </moCdrBloqueur>
    </CTierReferenceBancaireVO>
   </mvReferencesBancaires>
   <mvCategories>
    <CTierCatTiersVO>
     <miCode>17</miCode>
     <msDescription>Tiers Extranet</msDescription>
     <mbConfidentiel>false</mbConfidentiel>
    </CTierCatTiersVO>
   </mvCategories>
   <mvComptesContrePartie>
    <CCgenNatureCptVO>
     <miCode/>
    </CCgenNatureCptVO>
   </mvComptesContrePartie>
   <PersonnePhysique>
     <msPrenom>${firstName.encodeAsXML()}</msPrenom>
   </PersonnePhysique>
   <mvDocuments/>
  </DemandeTiers>
  <mvIndicateurs/>
 </FormCommunOrbeon>
 <FormDispositif>
  <InfoXml type="" nom="">
   <moGeneral type="noeud" nom="DEMANDE">
    <mbPremiereDem type="booleen" nom="Indicateur Première Demande">${firstRequest}</mbPremiereDem>
    <mdtDateCreation type="date" nom="Date de validation de la demande par l'étudiant">${creationDate}</mdtDateCreation>
    <msRIB type="texte" nom="RIB">${bankCode.encodeAsXML()} ${counterCode.encodeAsXML()} ${accountNumber.encodeAsXML()} ${accountKey.encodeAsXML()}</msRIB>
   </moGeneral>
   <moFoyerFiscal type="noeud" nom="FOYER FISCAL">
    <mdMtRevenuBrutGlobal type="montant" nom="Revenu brut global pour l'année 2007 et inférieur à 32 000 euros">${taxHouseholdIncome}</mdMtRevenuBrutGlobal>
    <msSecto type="texte" nom="Sectorisation hors 77">${taxHouseholdCityPrecision.encodeAsXML()}</msSecto>
   </moFoyerFiscal>
   <moAutresAides type="noeud" nom="AUTRES AIDES">
    <mbAideCROUS type="booleen" nom="Aide CROUS">${hasCROUSHelp}</mbAideCROUS>
    <mbAideCR type="booleen" nom="Aide du Conseil Régional">${hasRegionalCouncilHelp}</mbAideCR>
    <mbAideEurope type="booleen" nom="Aide Europe">${hasEuropeHelp}</mbAideEurope>
    <mbAideAutres type="booleen" nom="Autres aides obtenues">${hasOtherHelp}</mbAideAutres>
   </moAutresAides>
   <moEtudes type="noeud" nom="ETUDES EN COURS">
    <miAnneeBac type="entier" nom="Année d'obtention du baccalauréat">${AlevelsDate}</miAnneeBac>
    <msTypeBac type="texte" nom="Type de baccalauréat">${AlevelsType.encodeAsXML()}</msTypeBac>
    <msDiplomePrepare type="texte" nom="Diplôme préparé">${currentStudiesType.encodeAsXML()}</msDiplomePrepare>
    <msDiplomeNiveau type="texte" nom="Niveau diplôme">${currentStudiesLevel.encodeAsXML()}</msDiplomeNiveau>
    <mbEtudeAlternance type="booleen" nom="Etudes en alternance">${sandwichCourses}</mbEtudeAlternance>
    <mbStageEtranger type="booleen" nom="Stage conventionné à l'étranger">${abroadInternship}</mbStageEtranger>
    <mdtDateDebutStage type="date" nom="Date de début de stage">${abroadInternshipStartDate}</mdtDateDebutStage>
    <mdtDateFinStage type="date" nom="Date de fin de stage">${abroadInternshipEndDate}</mdtDateFinStage>
   </moEtudes>
   <moEtablissement type="noeud" nom="ETABLISSEMENT SCOLAIRE">
    <msNomEtab type="texte" nom="Nom de l'établissement">${currentSchoolName.encodeAsXML()}</msNomEtab>
    <miCPEtab type="entier" nom="Code postal de l'établissement">${currentSchoolPostalCode}</miCPEtab>
    <msVilleEtab type="texte" nom="Ville de l'établissement">${currentSchoolCity.encodeAsXML()}</msVilleEtab>
    <msPaysEtab type="texte" nom="Pays de l'établissement">${currentSchoolCountry.encodeAsXML()}</msPaysEtab>
    <msNomEtabAccueil type="texte" nom="Nom de l'établissement d'accueil à l'étranger">${abroadInternshipSchoolName.encodeAsXML()}</msNomEtabAccueil>
    <msPaysEtabAccueil type="texte" nom="Pays de l'établissement d'accueil à l'étranger">${abroadInternshipSchoolCountry.encodeAsXML()}</msPaysEtabAccueil>
   </moEtablissement>
   <moCalcul type="noeud" nom="ELEMENTS DE CALCUL">
    <msElementCalculDistance type="texte" nom="Elément de calcul de la bourse">${distance.encodeAsXML()}</msElementCalculDistance>
   </moCalcul>
  </InfoXml>
 </FormDispositif>
 <traitement>Validation</traitement>
</form>