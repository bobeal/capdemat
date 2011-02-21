


  
    <h3><g:message code="hcrr.step.enfant.label" /></h3>
    
      
      <dl>
        <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <h4><g:message code="hcrr.property.centreSejours.label" /></h4>
      <dl>
        
          <dt><g:message code="hcrr.property.idCentreSejours.label" /></dt><dd>${rqt.idCentreSejours?.toString()}</dd>

        
          <dt><g:message code="hcrr.property.labelCentreSejours.label" /></dt><dd>${rqt.labelCentreSejours?.toString()}</dd>

        
      </dl>
      
    
  

  
    <h3><g:message code="hcrr.step.reglements.label" /></h3>
    
      
      <dl>
        <dt><g:message code="hcrr.property.acceptationReglementInterieur.label" /></dt>
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
  

  


