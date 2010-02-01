<%
    org.codehaus.groovy.runtime.GStringImpl.metaClass.truncate = { length ->
        if (delegate == null)
            return ""
        if (delegate.length() > length)
            return delegate[0..(length - 1)]
        return delegate
    }
%>
<gestionCompte>
  <compteExtranet>
    <msNom></msNom>
    <msPrenom></msPrenom>
    <msFonction/>
    <mdtDateEntree></mdtDateEntree>
    <msTitre/>
    <msQualite></msQualite>
    <moAdresse/>
    <login></login>
    <password></password>
  </compteExtranet>
  <tiers>
    <msNom>${lastName}</msNom>
    <msLib>${lastName}</msLib>
    <msSiret/>
    <mbActivationSeuil>true</mbActivationSeuil>
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
          <miBanque>${bankCode}</miBanque>
          <miAgence>${counterCode}</miAgence>
          <msLibelle></msLibelle>
        </moAgence>
        <msCompte>${accountNumber}</msCompte>
        <miCleRib>${accountKey}</miCleRib>
        <mbEtranger>false</mbEtranger>
        <mbIban>false</mbIban>
        <mbUsuel>true</mbUsuel>
        <msIntitule/>
      </CTierReferenceBancaireVO>
    </mvReferencesBancaires>
    <PersonnePhysique>
      <msQualite>${title}</msQualite>
      <msPrenom>${firstName}</msPrenom>
      <msJeuneFille/>
      <msLieuNaissance>${birthPlace}</msLieuNaissance>
      <mdtDateNaissance>${birthDate}</mdtDateNaissance>
    </PersonnePhysique>
  </tiers>
  <traitement>C</traitement>
</gestionCompte>