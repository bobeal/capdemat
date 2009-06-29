<form>
 <FormCommunOrbeon>
  <CBdosDemandeVO>
   <miCode>${psCodeDemande}</miCode>
   <moOrigineApsect>
    <msIdentifiant>${externalRequestId}</msIdentifiant>
    <moApplicatifSectoriel>
     <miCode/>
     <msCodext>EXTSUB</msCodext>
    </moApplicatifSectoriel>
   </moOrigineApsect>
   <affichage/>
   <msStatut>${msStatut}</msStatut>
   <msAdresse>/dep/?formID=dep</msAdresse>
   <msIdentifiant/>
   <msDescription>${"TEST-" + externalRequestId}</msDescription>
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
    <miCode>${requestTypeCode}</miCode>
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
   <miMillesime>${millesime}</miMillesime>
   <mdtDateAcc/>
   <mdtDateRec/>
   <mdtDateCre/>
   <mdtDateDecision/>
   <msComment/>
   <msCodext>${msCodext}</msCodext>
   <mdMtDemande/>
   <mvListePiecesReq/>
   <mvListePiecesRecu>
    <% documents.each { document -> %>
     <% document.parts.each { part -> %>
      <CBdosPieceRecueVO>
       <msDescri/>
       <msLib>PJ</msLib>
       <miNombre>1</miNombre>
       <moDocument>
        <msDescri/>
        <msLib/>
        <miNombre/>
        <moImage>
         <msReferenceExt>${part.filename}</msReferenceExt>
         <mtbFluxBinaire>${part.filename}</mtbFluxBinaire>
         <msSourceImage>${part.remotePath}</msSourceImage>
         <msCle/>
        </moImage>
        <moFormat>
         <msTypeMime>text/plain</msTypeMime>
        </moFormat>
       </moDocument>
      </CBdosPieceRecueVO>
     <% } %>
    <% } %>
   </mvListePiecesRecu>
   <mvListeInformations/>
   <moLot/>
   <moLigneDossier/>
  </CBdosDemandeVO>
  <DemandeTiers>
   <CodeAppliSecto>EXTSUB</CodeAppliSecto>
   <NumAppliSecto/>
   <miCode>${psCodeTiers}</miCode>
   <LoginUtilisateurGda/>
   <msNom>${lastName}</msNom>
   <msLib>${firstName} ${lastName}</msLib>
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
    <miCode>${taxHouseholdCityCode}</miCode>
   </moSectorisation>
   <mvAdresses>
    <CTierAdresseVO>
     <miCode>${address.miCode}</miCode>
     <msVoie>${address.msVoie}</msVoie>
     <msComplement/>
     <msCodePostal>${address.msCodePostal}</msCodePostal>
     <msPays>${address.msPays}</msPays>
     <miBoitePostale>${address.miBoitePostale}</miBoitePostale>
     <miCedex>${address.miCedex}</miCedex>
     <msVille>${address.msVille}</msVille>
     <msTel>${address.msTel}</msTel>
     <msFax>${address.msFax}</msFax>
     <msMail>${address.msMail}</msMail>
     <mbUsuel>${address.mbUsuel}</mbUsuel>
     <moNature>
      <miCode>${address."moNature/miCode"}</miCode>
     </moNature>
    </CTierAdresseVO>
   </mvAdresses>
   <mvReferencesBancaires>
    <CTierReferenceBancaireVO>
      <moModePaiement>
        <msDescription>Virement bancaire</msDescription>
      </moModePaiement>
      <moAgence>
        <miBanque>${bankCode}</miBanque>
        <miAgence>${counterCode}</miAgence>
      </moAgence>
      <msCompte>${accountNumber}</msCompte>
      <miCleRib>${accountKey}</miCleRib>
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
     <miCode>16</miCode>
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
     <msPrenom>${firstName}</msPrenom>
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
    <msRIB type="texte" nom="RIB">${bankCode} ${counterCode} ${accountNumber} ${accountKey}</msRIB>
   </moGeneral>
   <moFoyerFiscal type="noeud" nom="FOYER FISCAL">
    <mdMtRevenuBrutGlobal type="montant" nom="Revenu brut global indiqué sur l'Avis d'imposition">${taxHouseholdIncome}</mdMtRevenuBrutGlobal>
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
    <miCPEtab type="entier" nom="Code postal de l'établissement">${currentSchoolPostalCode}</miCPEtab>
    <msVilleEtab type="texte" nom="Ville de l'établissement">${currentSchoolCity}</msVilleEtab>
    <msPaysEtab type="texte" nom="Pays de l'établissement">${currentSchoolCountry}</msPaysEtab>
    <msNomEtabAccueil type="texte" nom="Nom de l'établissement d'accueil à l'étranger">${abroadInternshipSchoolName}</msNomEtabAccueil>
    <msPaysEtabAccueil type="texte" nom="Pays de l'établissement d'accueil à l'étranger">${abroadInternshipSchoolCountry}</msPaysEtabAccueil>
   </moEtablissement>
   <moCalcul type="noeud" nom="ELEMENTS DE CALCUL">
    <msElementCalculDistance type="texte" nom="Elément de calcul de la bourse">${distance}</msElementCalculDistance>
   </moCalcul>
  </InfoXml>
 </FormDispositif>
 <traitement>Validation</traitement>
</form>