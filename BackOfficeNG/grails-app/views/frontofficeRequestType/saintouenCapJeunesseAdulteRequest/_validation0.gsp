


  
    <h3><g:message code="scjar.step.sujet.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scjar.property.subject.label" /></dt>
          <dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjar.property.dateNaissance.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.dateNaissance}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjar.property.sexe.label" /></dt>
          <dd>
            <g:if test="${rqt.sexe}">
              <g:capdematEnumToField var="${rqt.sexe}" i18nKeyPrefix="scjar.property.sexe" />
            </g:if>
          </dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="scjar.step.renseignements.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scjar.property.typeInscription.label" /></dt>
          <dd>
            <g:if test="${rqt.typeInscription}">
              <g:capdematEnumToField var="${rqt.typeInscription}" i18nKeyPrefix="scjar.property.typeInscription" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjar.property.secteurHabitation.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'secteurHabitation', 'lrEntries': lrTypes.secteurHabitation.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjar.property.situationActuelle.label" /></dt>
          <dd>
            <g:if test="${rqt.situationActuelle}">
              <g:capdematEnumToField var="${rqt.situationActuelle}" i18nKeyPrefix="scjar.property.situationActuelle" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjar.property.etudiantTypeEtablissement.label" /></dt>
          <dd>
            <g:if test="${rqt.etudiantTypeEtablissement}">
              <g:capdematEnumToField var="${rqt.etudiantTypeEtablissement}" i18nKeyPrefix="scjar.property.etudiantTypeEtablissement" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <h4><g:message code="scjar.property.etablissementScolaireAutre.label" /></h4>
      <dl>
        
          <dt><g:message code="scjar.property.precisionEtablissementScolaireAutre.label" /></dt><dd>${rqt.precisionEtablissementScolaireAutre?.toString()}</dd>

        
          <dt><g:message code="scjar.property.nomEtablissementScolaireAutre.label" /></dt><dd>${rqt.nomEtablissementScolaireAutre?.toString()}</dd>

        
          <dt><g:message code="scjar.property.adresseEtablissementScolaireAutre.label" /></dt>
          <dd>
          <g:if test="${rqt.adresseEtablissementScolaireAutre}">
              <p>${rqt.adresseEtablissementScolaireAutre?.additionalDeliveryInformation}</p>
              <p>${rqt.adresseEtablissementScolaireAutre?.additionalGeographicalInformation}</p>
              <p>${rqt.adresseEtablissementScolaireAutre?.streetNumber} ${rqt.adresseEtablissementScolaireAutre?.streetName}</p>
              <p>${rqt.adresseEtablissementScolaireAutre?.placeNameOrService}</p>
              <p>${rqt.adresseEtablissementScolaireAutre?.postalCode} ${rqt.adresseEtablissementScolaireAutre?.city}</p>
              <p>${rqt.adresseEtablissementScolaireAutre?.countryName}</p>
          </g:if>
          </dd>
          

        
      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjar.property.profession.label" /></dt><dd>${rqt.profession?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjar.property.participeActivite.label" /></dt>
          <dd><g:message code="message.${rqt.participeActivite ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjar.property.typeActivite.label" /></dt>
          <dd>
            <g:if test="${rqt.typeActivite}">
              <g:capdematEnumToField var="${rqt.typeActivite}" i18nKeyPrefix="scjar.property.typeActivite" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjar.property.precisionActivite.label" /></dt><dd>${rqt.precisionActivite?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="scjar.step.reglements.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scjar.property.autorisationMedicale.label" /></dt>
          <dd><g:message code="message.${rqt.autorisationMedicale ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjar.property.autorisationImage.label" /></dt>
          <dd><g:message code="message.${rqt.autorisationImage ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjar.property.acceptationReglement.label" /></dt>
          <dd><g:message code="message.${rqt.acceptationReglement ? 'yes' : 'no'}" /></dd>
          

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
  

  


