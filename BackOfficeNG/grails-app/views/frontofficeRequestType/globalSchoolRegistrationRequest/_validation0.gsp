


  
    <h3><g:message code="gsrr.step.enfant.label" /></h3>
    
      
      <dl>
        <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="gsrr.property.estDerogation.label" /></dt>
          <dd><g:message code="message.${rqt.estDerogation ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <h4><g:message code="gsrr.property.ecoleDerogation.label" /></h4>
      <dl>
        
          <dt><g:message code="gsrr.property.idEcoleDerog.label" /></dt><dd>${rqt.idEcoleDerog?.toString()}</dd>

        
          <dt><g:message code="gsrr.property.labelEcoleDerog.label" /></dt><dd>${rqt.labelEcoleDerog?.toString()}</dd>

        
      </dl>
      
    
      
      <dl>
        <dt><g:message code="gsrr.property.motifsDerogationEcole.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'motifsDerogationEcole', 'lrEntries': lrTypes.motifsDerogationEcole.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="gsrr.property.informationsComplementairesDerogation.label" /></dt><dd>${rqt.informationsComplementairesDerogation?.toString()}</dd>

      </dl>
      
    
      
      <h4><g:message code="gsrr.property.ecoleSecteur.label" /></h4>
      <dl>
        
          <dt><g:message code="gsrr.property.idEcoleSecteur.label" /></dt><dd>${rqt.idEcoleSecteur?.toString()}</dd>

        
          <dt><g:message code="gsrr.property.labelEcoleSecteur.label" /></dt><dd>${rqt.labelEcoleSecteur?.toString()}</dd>

        
      </dl>
      
    
  

  
    <h3><g:message code="gsrr.step.restauration.label" /></h3>
    
      
      <dl>
        <dt><g:message code="gsrr.property.estRestauration.label" /></dt>
          <dd><g:message code="message.${rqt.estRestauration ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="gsrr.property.regimeAlimentaire.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'regimeAlimentaire', 'lrEntries': lrTypes.regimeAlimentaire.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="gsrr.step.periscolaire.label" /></h3>
    
      
      <dl>
        <dt><g:message code="gsrr.property.estPeriscolaire.label" /></dt>
          <dd><g:message code="message.${rqt.estPeriscolaire ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="gsrr.step.reglements.label" /></h3>
    
      
      <dl>
        <dt><g:message code="gsrr.property.acceptationReglementInterieur.label" /></dt>
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
  

  


