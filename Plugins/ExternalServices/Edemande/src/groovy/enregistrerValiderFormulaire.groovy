<form>
 <FormCommunOrbeon>
  <CBdosDemandeVO>
   <miCode>-1</miCode>
   <moOrigineApsect>
    <msIdentifiant>${["CapDemat", date, firstName, lastName, id].join('-')}</msIdentifiant>
    <moApplicatifSectoriel>
     <miCode/>
     <msCodext>EXTSUB</msCodext>
    </moApplicatifSectoriel>
   </moOrigineApsect>
   <affichage/>
   <msStatut/>
   <msAdresse>/dep/?formID=dep</msAdresse>
   <msIdentifiant/>
   <msDescription>${["TEST", date, firstName, lastName, id].join('-')}</msDescription>
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
    <msLib>xxxx</msLib>
    <msDescri>xxxx</msDescri>
    <mvPiecesNec/>
   </moTypDem>
   <moEtatCourant>
     <miCode>2</miCode>
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
   <miMillesime/>
   <mdtDateAcc/>
   <mdtDateRec/>
   <mdtDateCre/>
   <mdtDateDecision/>
   <msComment/>
   <msCodext/>
   <mdMtDemande>1000,00</mdMtDemande>
   <mvListePiecesReq/>
   <mvListePiecesRecu/>
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
   <msLib>${lastName}</msLib>
   <moAttach>
    <moProcedure>
     <miCode/>
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
    <miCode/>
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
      <miCode>1</miCode>
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
      <msIntitule>XXXXXXXXX</msIntitule>
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
     <msPrenom>Prenom</msPrenom>
   </PersonnePhysique>
   <mvDocuments/>
  </DemandeTiers>
  <mvIndicateurs>
   <SiteInternet/>
   <EstAsso>false</EstAsso>
   <EstAssoLoi1901>false</EstAssoLoi1901>
   <NumEnregPref/>
   <DtJournalOfficiel/>
   <EstAssoUtilitePublique>false</EstAssoUtilitePublique>
   <DtReconnaissanceUtilPub/>
   <EstAssoAgreee>false</EstAssoAgreee>
   <AgrementAutres1/>
   <NumAgrementAutres1/>
   <DtAgrementAutres1/>
   <AgrementAutres2/>
   <NumAgrementAutres2/>
   <DtAgrementAutres2/>
   <EstAssoAffilieeFederation>false</EstAssoAffilieeFederation>
   <FederationAffiliee1/>
   <FederationAffiliee2/>
   <NumFederationAffiliee1/>
   <NumFederationAffiliee2/>
   <EstCommune>true</EstCommune>
   <EstSociete>false</EstSociete>
   <EstEtablissementScolaire>false</EstEtablissementScolaire>
   <EstEtablissementPublic>false</EstEtablissementPublic>
   <EstAutre>false</EstAutre>
   <LibelleAgrement/>
   <NumAgrement/>
   <DtAgrement/>
   <LibelleLicence/>
   <NumLicence/>
   <DtLicence/>
   <LibelleLabel/>
   <NumLabel/>
  </mvIndicateurs>
 </FormCommunOrbeon>
 <FormDispositif>
  <InfoXml type="" nom="">
   <moGeneral type="noeud" nom="Renseignements de la demande">
    <mbDemande type="texte" nom="Type de demande">Première demande</mbDemande>
    <mbAnnee type="texte" nom="Typologie Année">Civile</mbAnnee>
    <msAnneeCivile type="texte" nom="Année Civile">2008</msAnneeCivile>
    <msAnneeScolaire type="texte" nom="Année Scolaire"/>
    <miAdherent type="entier" nom="Nombre d'adhérents"/>
    <mbSalarie type="booleen" nom="Salariés ?">false</mbSalarie>
    <miSalarie type="entier" nom="Nombre de salariés">2</miSalarie>
    <miEquivalent type="entier" nom="Nombre en équivalent temps plein">1</miEquivalent>
   </moGeneral>
   <moAssociation type="noeud" nom="Renseignements Association">
    <mbBenevole type="booleen" nom="Bénévolat ?">false</mbBenevole>
    <miBenevole type="entier" nom="Nombre de bénévoles"/>
   </moAssociation>
   <moSociete type="noeud" nom="Renseignements Société">
    <msStatut type="texte" nom="Statut"/>
    <mdtImmat type="date" nom="Date d'immatriculation au RCS"/>
   </moSociete>
   <moProjet type="noeud" nom="Présentation du projet">
    <mbprojet type="texte" nom="Type de projet">Nouveau projet</mbprojet>
    <msBilan type="texte" nom="Bilan des actions menées"/>
    <msDescri type="texte" nom="Description du projet"/>
    <msPublic type="texte" nom="Publics concernés"/>
    <miBeneficiaire type="entier" nom="Nombre de bénéficiaires de l'action"/>
    <msLieu type="texte" nom="Lieux de réalisation"/>
    <mdtMiseEnOeuvre type="date" nom="Date de mise en oeuvre prévue"/>
    <miDureeAction type="date" nom="Durée de l'action "/>
    <miMontant type="montant" nom="Montant de l'action projetée"/>
    <mbPartenaire type="booleen" nom="Partenaires associés au projet ?">false</mbPartenaire>
    <moPartenaire type="noeud" nom="Partenaire">
     <msNom type="texte" nom="Nom"/>
     <msType type="texte" nom="Type"/>
     <miSollicite type="texte" nom="Montant ou prestations en nature sollicité(es)"/>
     <miRecu type="texte" nom="Montant ou prestations en nature reçu(es)"/>
    </moPartenaire>
   </moProjet>
  </InfoXml>
 </FormDispositif>
 <traitement>Validation</traitement>
</form>