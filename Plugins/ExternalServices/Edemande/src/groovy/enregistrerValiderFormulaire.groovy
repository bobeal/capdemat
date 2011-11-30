<%
    org.codehaus.groovy.runtime.GStringImpl.metaClass.truncate = { length ->
        if (delegate == null)
            return ""
        if (delegate.length() <= length)
            return delegate
        def original = org.apache.commons.lang3.StringEscapeUtils.unescapeXml(delegate)
        original = original[0..(original.length() -2)]
        def result = org.apache.commons.lang3.StringEscapeUtils.escapeXml(original)
        while (result.length() > length) {
            original = original[0..(original.length() -2)]
            result = org.apache.commons.lang3.StringEscapeUtils.escapeXml(original)
        }
        return result
    }
%>
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
   <msAdresse>${config.path}</msAdresse>
   <msIdentifiant/>
   <msDescription>${config.description}</msDescription>
   <mdMtProjetHT/>
   <mdMtProjetTTC/>
   <moTvaProjet>
     <miCode>1</miCode>
   </moTvaProjet>
   <moCdr>
    <miCode/>
   </moCdr>
   <moTypDem>
    <msNom>${config.name}</msNom>
    <miCode>${requestTypeCode}</miCode>
    <msLib>${config.label}</msLib>
    <msDescri>${config.longDescription}</msDescri>
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
     <CBdosPieceRecueVO>
      <msDescri/>
      <msLib>${document.label}</msLib>
      <miNombre>1</miNombre>
      <moDocument>
       <msDescri/>
       <msLib/>
       <miNombre/>
       <moImage>
        <msReferenceExt>${document.filename}</msReferenceExt>
        <mtbFluxBinaire>${document.filename}</mtbFluxBinaire>
        <msSourceImage>${document.remotePath}</msSourceImage>
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
   <miCode>${psCodeTiers}</miCode>
   <LoginUtilisateurGda/>
   <msNom>${lastName}</msNom>
   <msLib>${lastName}</msLib>
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
     <msVoie><% out << "${address.streetNumber} ${address.streetName}".truncate(32) %></msVoie>
     <msComplement>${address.additionalDeliveryInformation}</msComplement>
     <miBoitePostale/>
     <msCodePostal>${address.postalCode}</msCodePostal>
     <msVille>${address.city}</msVille>
     <miCedex/>
     <msPays>${address.countryName}</msPays>
     <msTel>${phone}</msTel>
     <msFax/>
     <msMail>${email}</msMail>
     <mbUsuel>true</mbUsuel>
    </CTierAdresseVO>
   </mvAdresses>
   <mvReferencesBancaires>
    <CTierReferenceBancaireVO>
      <moModePaiement>
        <msDescription>Virement bancaire</msDescription>
      </moModePaiement>
      <moAgence>
        <miBanque>${frenchRIB.split()[0]}</miBanque>
        <miAgence>${frenchRIB.split()[1]}</miAgence>
      </moAgence>
      <msCompte>${frenchRIB.split()[2]}</msCompte>
      <miCleRib>${frenchRIB.split()[3]}</miCleRib>
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
     <msPrenom>${firstName}</msPrenom>
   </PersonnePhysique>
   <mvDocuments/>
  </DemandeTiers>
  <mvIndicateurs/>
 </FormCommunOrbeon>
 <FormDispositif>
  <InfoXml type="" nom="">
   ${form}
  </InfoXml>
 </FormDispositif>
 <traitement>Validation</traitement>
</form>
