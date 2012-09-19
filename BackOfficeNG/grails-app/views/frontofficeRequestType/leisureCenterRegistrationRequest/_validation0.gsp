


  
    <h3><g:message code="lcrr.step.enfant.label" /></h3>
    
      
      <dl>
        <dt><g:message code="lcrr.property.subject.label" /></dt>
          <dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcrr.property.estDerogation.label" /></dt>
          <dd><g:message code="message.${rqt.estDerogation ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcrr.property.motifsDerogationCentreLoisirs.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'motifsDerogationCentreLoisirs', 'lrEntries': lrTypes.motifsDerogationCentreLoisirs.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <h4><g:message code="lcrr.property.centresLoisirs.label" /></h4>
      <dl>
        
          <dt><g:message code="lcrr.property.idCentreLoisirs.label" /></dt><dd>${rqt.idCentreLoisirs?.toString()}</dd>

        
          <dt><g:message code="lcrr.property.labelCentreLoisirs.label" /></dt><dd>${rqt.labelCentreLoisirs?.toString()}</dd>

        
      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcrr.property.estTransport.label" /></dt>
          <dd><g:message code="message.${rqt.estTransport ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <h4><g:message code="lcrr.property.transports.label" /></h4>
      <dl>
        
          <dt><g:message code="lcrr.property.idLigne.label" /></dt><dd>${rqt.idLigne?.toString()}</dd>

        
          <dt><g:message code="lcrr.property.labelLigne.label" /></dt><dd>${rqt.labelLigne?.toString()}</dd>

        
          <dt><g:message code="lcrr.property.idArret.label" /></dt><dd>${rqt.idArret?.toString()}</dd>

        
          <dt><g:message code="lcrr.property.labelArret.label" /></dt><dd>${rqt.labelArret?.toString()}</dd>

        
      </dl>
      
    
  


  
    <h3><g:message code="lcrr.step.reglements.label" /></h3>
    
      
      <dl>
        <dt><g:message code="lcrr.property.acceptationReglementInterieur.label" /></dt>
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
  


  


