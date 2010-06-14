


  
    <h3><g:message code="hsr.step.registration.label" /></h3>
    
      
      <dl>
        <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="hsr.property.absenceStartDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.absenceStartDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="hsr.property.absenceEndDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.absenceEndDate}"/></dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="hsr.step.rules.label" /></h3>
    
      
      <dl>
        <dt><g:message code="hsr.property.rulesAndRegulationsAcceptance.label" /></dt>
          <dd><g:message code="message.${rqt.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="hsr.step.contactphone.label" /></h3>
    
      
      <dl>
        <dt><g:message code="hsr.property.alertPhone.label" /></dt><dd>${rqt.alertPhone?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="hsr.step.contact.label" /></h3>
    
      
      <dl>
        <dt><g:message code="hsr.property.otherContact.label" /></dt>
          <dd><g:message code="message.${rqt.otherContact ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <h4><g:message code="hsr.property.otherContactInformations.label" /></h4>
      <dl>
        
          <dt><g:message code="hsr.property.otherContactLastName.label" /></dt><dd>${rqt.otherContactLastName?.toString()}</dd>

        
          <dt><g:message code="hsr.property.otherContactFirstName.label" /></dt><dd>${rqt.otherContactFirstName?.toString()}</dd>

        
          <dt><g:message code="hsr.property.otherContactAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.otherContactAddress}">
              <p>${rqt.otherContactAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.otherContactAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.otherContactAddress?.streetNumber} ${rqt.otherContactAddress?.streetName}</p>
              <p>${rqt.otherContactAddress?.placeNameOrService}</p>
              <p>${rqt.otherContactAddress?.postalCode} ${rqt.otherContactAddress?.city}</p>
              <p>${rqt.otherContactAddress?.countryName}</p>
          </g:if>
          </dd>
          

        
          <dt><g:message code="hsr.property.otherContactPhone.label" /></dt><dd>${rqt.otherContactPhone?.toString()}</dd>

        
      </dl>
      
    
  

  
    <h3><g:message code="hsr.step.additional.label" /></h3>
    
      
      <dl>
        <dt><g:message code="hsr.property.alarm.label" /></dt>
          <dd><g:message code="message.${rqt.alarm ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="hsr.property.light.label" /></dt>
          <dd><g:message code="message.${rqt.light ? 'yes' : 'no'}" /></dd>
          

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
          <g:if test="${document.id > rqt.id}"><span class="tag-state tag-new">${message(code:'document.header.new')}</span>
            <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}?isRequestCreation=true&sessionUuid=${uuidString}" target="blank" title="${message(code:'document.message.preview.longdesc')}">${message(code:'document.message.preview')}</a>
          </g:if>
          <g:else>
            <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}">${message(code:'document.message.preview')}</a>
          </g:else>
          </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        ${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  

  


