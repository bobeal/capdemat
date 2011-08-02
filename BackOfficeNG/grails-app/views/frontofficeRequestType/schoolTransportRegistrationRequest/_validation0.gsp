


  
    <h3><g:message code="strr.step.enfant.label" /></h3>
    
      
      <dl>
        <dt><g:message code="strr.property.subject.label" /></dt>
          <dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <h4><g:message code="strr.property.ligne.label" /></h4>
      <dl>
        
          <dt><g:message code="strr.property.idLigne.label" /></dt><dd>${rqt.idLigne?.toString()}</dd>

        
          <dt><g:message code="strr.property.labelLigne.label" /></dt><dd>${rqt.labelLigne?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="strr.property.arret.label" /></h4>
      <dl>
        
          <dt><g:message code="strr.property.idArret.label" /></dt><dd>${rqt.idArret?.toString()}</dd>

        
          <dt><g:message code="strr.property.labelArret.label" /></dt><dd>${rqt.labelArret?.toString()}</dd>

        
      </dl>
      
    
  

  
    <h3><g:message code="strr.step.autorisations.label" /></h3>
    
      
      <dl>
        <dt><g:message code="strr.property.estMaternelleElementaireAutorisations.label" /></dt>
          <dd><g:message code="message.${rqt.estMaternelleElementaireAutorisations ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="strr.property.autorisation.label" /></dt>
          <dd>
            <g:if test="${rqt.autorisation}">
              <g:capdematEnumToField var="${rqt.autorisation}" i18nKeyPrefix="strr.property.autorisation" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <h4><g:message code="strr.property.tiersAutorises.label" /></h4>
      <g:each var="it" in="${rqt.tiersAutorises}" status="index">
      <dl>
        
          <dt><g:message code="strr.property.tiersNom.label" /></dt><dd>${it.tiersNom?.toString()}</dd>

        
          <dt><g:message code="strr.property.tiersPrenom.label" /></dt><dd>${it.tiersPrenom?.toString()}</dd>

        
          <dt><g:message code="strr.property.tiersTelephone.label" /></dt><dd>${it.tiersTelephone?.toString()}</dd>

        
      </dl>
      </g:each>
      
    
      
      <h4><g:message code="strr.property.frereOuSoeurAutorise.label" /></h4>
      <dl>
        
          <dt><g:message code="strr.property.frereOuSoeurNom.label" /></dt><dd>${rqt.frereOuSoeurNom?.toString()}</dd>

        
          <dt><g:message code="strr.property.frereOuSoeurPrenom.label" /></dt><dd>${rqt.frereOuSoeurPrenom?.toString()}</dd>

        
          <dt><g:message code="strr.property.frereOuSoeurEcole.label" /></dt><dd>${rqt.frereOuSoeurEcole?.toString()}</dd>

        
          <dt><g:message code="strr.property.frereOuSoeurClasse.label" /></dt><dd>${rqt.frereOuSoeurClasse?.toString()}</dd>

        
      </dl>
      
    
  

  
    <h3><g:message code="strr.step.reglements.label" /></h3>
    
      
      <dl>
        <dt><g:message code="strr.property.acceptationReglementInterieur.label" /></dt>
          <dd><g:message code="message.${rqt.acceptationReglementInterieur ? 'yes' : 'no'}" /></dd>
          

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
  

  


