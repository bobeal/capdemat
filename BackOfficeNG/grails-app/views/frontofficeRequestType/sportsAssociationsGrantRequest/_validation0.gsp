


  
    <h3><g:message code="sagr.step.association.label" /></h3>
    
      
      <dl>
        <dt><g:message code="sagr.property.nomAssociation.label" /></dt><dd>${rqt.nomAssociation?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sagr.property.siegeSocialAssociation.label" /></dt>
          <dd>
          <g:if test="${rqt.siegeSocialAssociation}">
              <p>${rqt.siegeSocialAssociation?.additionalDeliveryInformation}</p>
              <p>${rqt.siegeSocialAssociation?.additionalGeographicalInformation}</p>
              <p>${rqt.siegeSocialAssociation?.streetNumber} ${rqt.siegeSocialAssociation?.streetName}</p>
              <p>${rqt.siegeSocialAssociation?.placeNameOrService}</p>
              <p>${rqt.siegeSocialAssociation?.postalCode} ${rqt.siegeSocialAssociation?.city}</p>
              <p>${rqt.siegeSocialAssociation?.countryName}</p>
          </g:if>
          </dd>
          

      </dl>
      
    
      
      <h4><g:message code="sagr.property.numerosAssociation.label" /></h4>
      <dl>
        
          <dt><g:message code="sagr.property.numeroSiretAssociation.label" /></dt><dd>${rqt.numeroSiretAssociation?.toString()}</dd>

        
          <dt><g:message code="sagr.property.numeroEnregistrementPrefectureAssociation.label" /></dt><dd>${rqt.numeroEnregistrementPrefectureAssociation?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="sagr.property.contactsAssociation.label" /></h4>
      <dl>
        
          <dt><g:message code="sagr.property.estAdresseCorrespondantPrincipal.label" /></dt>
          <dd><g:message code="message.${rqt.estAdresseCorrespondantPrincipal ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="sagr.property.nomCompletCorrespondantPrincipal.label" /></dt><dd>${rqt.nomCompletCorrespondantPrincipal?.toString()}</dd>

        
          <dt><g:message code="sagr.property.adresseCorrespondantPrincipal.label" /></dt>
          <dd>
          <g:if test="${rqt.adresseCorrespondantPrincipal}">
              <p>${rqt.adresseCorrespondantPrincipal?.additionalDeliveryInformation}</p>
              <p>${rqt.adresseCorrespondantPrincipal?.additionalGeographicalInformation}</p>
              <p>${rqt.adresseCorrespondantPrincipal?.streetNumber} ${rqt.adresseCorrespondantPrincipal?.streetName}</p>
              <p>${rqt.adresseCorrespondantPrincipal?.placeNameOrService}</p>
              <p>${rqt.adresseCorrespondantPrincipal?.postalCode} ${rqt.adresseCorrespondantPrincipal?.city}</p>
              <p>${rqt.adresseCorrespondantPrincipal?.countryName}</p>
          </g:if>
          </dd>
          

        
          <dt><g:message code="sagr.property.emailClubOuCorrespondant.label" /></dt><dd>${rqt.emailClubOuCorrespondant?.toString()}</dd>

        
      </dl>
      
    
  

  
    <h3><g:message code="sagr.step.president.label" /></h3>
    
      
      <dl>
        <dt><g:message code="sagr.property.roleDemandeur.label" /></dt>
          <dd>
            <g:if test="${rqt.roleDemandeur}">
              <g:capdematEnumToField var="${rqt.roleDemandeur}" i18nKeyPrefix="sagr.property.roleDemandeur" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <h4><g:message code="sagr.property.precisionPresident.label" /></h4>
      <dl>
        
          <dt><g:message code="sagr.property.nomPresident.label" /></dt><dd>${rqt.nomPresident?.toString()}</dd>

        
          <dt><g:message code="sagr.property.prenomPresident.label" /></dt><dd>${rqt.prenomPresident?.toString()}</dd>

        
          <dt><g:message code="sagr.property.telephonePresident.label" /></dt><dd>${rqt.telephonePresident?.toString()}</dd>

        
          <dt><g:message code="sagr.property.emailPresident.label" /></dt><dd>${rqt.emailPresident?.toString()}</dd>

        
      </dl>
      
    
  

  
    <h3><g:message code="sagr.step.bureau.label" /></h3>
    
      
      <h4><g:message code="sagr.property.autreMembreBureau.label" /></h4>
      <g:each var="it" in="${rqt.autreMembreBureau}" status="index">
      <dl>
        
          <dt><g:message code="sagr.property.roleMembre.label" /></dt>
          <dd>
            <g:if test="${it.roleMembre}">
              <g:capdematEnumToField var="${it.roleMembre}" i18nKeyPrefix="sagr.property.roleMembre" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="sagr.property.nomMembre.label" /></dt><dd>${it.nomMembre?.toString()}</dd>

        
          <dt><g:message code="sagr.property.prenomMembre.label" /></dt><dd>${it.prenomMembre?.toString()}</dd>

        
          <dt><g:message code="sagr.property.telephoneMembre.label" /></dt><dd>${it.telephoneMembre?.toString()}</dd>

        
          <dt><g:message code="sagr.property.emailMembre.label" /></dt><dd>${it.emailMembre?.toString()}</dd>

        
      </dl>
      </g:each>
      
    
  

  
    <h3><g:message code="sagr.step.activites.label" /></h3>
    
      
      <h4><g:message code="sagr.property.sagrActiviteAssociation.label" /></h4>
      <g:each var="it" in="${rqt.sagrActiviteAssociation}" status="index">
      <dl>
        
          <dt><g:message code="sagr.property.sportPratique.label" /></dt>
          <dd>
            <g:if test="${it.sportPratique}">
              <g:capdematEnumToField var="${it.sportPratique}" i18nKeyPrefix="sagr.property.sportPratique" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="sagr.property.sportPratiquePrecision.label" /></dt><dd>${it.sportPratiquePrecision?.toString()}</dd>

        
          <dt><g:message code="sagr.property.federationSportive.label" /></dt>
          <dd>
            <g:if test="${it.federationSportive}">
              <g:capdematEnumToField var="${it.federationSportive}" i18nKeyPrefix="sagr.property.federationSportive" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="sagr.property.federationSportivePrecision.label" /></dt><dd>${it.federationSportivePrecision?.toString()}</dd>

        
          <dt><g:message code="sagr.property.numeroAffiliationActivite.label" /></dt><dd>${it.numeroAffiliationActivite?.toString()}</dd>

        
          <dt><g:message code="sagr.property.nombreLicencieMineurActivite.label" /></dt><dd>${it.nombreLicencieMineurActivite?.toString()}</dd>

        
          <dt><g:message code="sagr.property.nombreLicencieMajeurActivite.label" /></dt><dd>${it.nombreLicencieMajeurActivite?.toString()}</dd>

        
      </dl>
      </g:each>
      
    
  

  
    <h3><g:message code="sagr.step.subvention.label" /></h3>
    
      
      <h4><g:message code="sagr.property.subventionPubliqueFonctionnement.label" /></h4>
      <dl>
        
          <dt><g:message code="sagr.property.subventionSolliciteConseilGeneral.label" /></dt><dd>${rqt.subventionSolliciteConseilGeneral?.toString()}</dd>

        
          <dt><g:message code="sagr.property.budgetSaisonEcouleeRecette.label" /></dt><dd>${rqt.budgetSaisonEcouleeRecette?.toString()}</dd>

        
          <dt><g:message code="sagr.property.budgetSaisonEcouleeDepenses.label" /></dt><dd>${rqt.budgetSaisonEcouleeDepenses?.toString()}</dd>

        
          <dt><g:message code="sagr.property.nombreLicencieMoinsDixHuitSaisonEcoulee.label" /></dt><dd>${rqt.nombreLicencieMoinsDixHuitSaisonEcoulee?.toString()}</dd>

        
          <dt><g:message code="sagr.property.nombreLicenciePlusDixHuitSaisonEcoulee.label" /></dt><dd>${rqt.nombreLicenciePlusDixHuitSaisonEcoulee?.toString()}</dd>

        
          <dt><g:message code="sagr.property.communeAnneeN.label" /></dt><dd>${rqt.communeAnneeN?.toString()}</dd>

        
          <dt><g:message code="sagr.property.communeAnneeNPlusUn.label" /></dt><dd>${rqt.communeAnneeNPlusUn?.toString()}</dd>

        
      </dl>
      
    
      
      <dl>
        <dt><g:message code="sagr.property.compteBancaire.label" /></dt>
          <dd>
          <g:if test="${rqt.compteBancaire}">
            <p>
              ${rqt.compteBancaire?.BIC}
              ${rqt.compteBancaire?.IBAN}
            </p>
          </g:if>
          </dd>
          

      </dl>
      
    
  

  
  <g:if test="${!documentsByTypes.isEmpty()}">
    <h3>${message(code:'request.step.document.label')}</h3>
    <g:each in="${documentsByTypes}" var="documentType">
      <h4>${message(code:documentType.value.name)}</h4>
      <g:if test="${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="${documentType.value.associated}" var="document">
        <dt>
          <g:if test="${document.ecitizenNote}">${message(code:'document.header.description')} : ${document.ecitizenNote}<br/></g:if>
          <g:if test="${document.endValidityDate}">${message(code:'document.header.expireOn')} ${formatDate(date:document.endValidityDate,formatName:'format.date')}</g:if>
        </dt>
        <dd>
          <g:capdematEnumToFlag var="${document.state}" i18nKeyPrefix="document.state" />
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}">${message(code:'document.message.preview')}</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        ${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  

  


