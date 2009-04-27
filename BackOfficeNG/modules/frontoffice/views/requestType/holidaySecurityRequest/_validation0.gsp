


  
    <h3><g:message code="hsr.step.subject.label" /></h3>
    
      
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
        <dt><g:message code="hsr.property.alertPhone.label" /></dt><dd>${rqt.alertPhone}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="hsr.step.contact.label" /></h3>
    
      
      <dl>
        <dt><g:message code="hsr.property.otherContactLastName.label" /></dt><dd>${rqt.otherContactLastName}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="hsr.property.otherContactFirstName.label" /></dt><dd>${rqt.otherContactFirstName}</dd>

      </dl>
      
    
      
      <dl>
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
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="hsr.property.otherContactPhone.label" /></dt><dd>${rqt.otherContactPhone}</dd>

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
      
    
  

  
  <g:if test="${!documentTypes.isEmpty()}">
    <h3>${message(code:'request.step.document.label')}</h3>
    <g:each in="${documentTypes}" var="documentType">
      <h4>${message(code:documentType.value.name)}</h4>
      <g:if test="${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="${documentType.value.associated}" var="document">
        <dt>
          <g:if test="${document.ecitizenNote}">${message(code:'document.header.description')} : ${document.ecitizenNote}<br/></g:if>
          <g:if test="${document.endValidityDate}">${message(code:'document.header.expireOn')} ${formatDate(date:document.endValidityDate,formatName:'format.date')}</g:if>
        </dt>
        <dd>
          <g:if test="${document.isNew}"><span class="tag-state tag-active">${message(code:'document.header.new')}</span></g:if>
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">${message(code:'document.header.preview')}</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        ${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  

  


