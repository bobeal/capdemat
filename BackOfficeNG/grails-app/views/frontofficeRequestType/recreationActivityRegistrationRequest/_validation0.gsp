


  
    <h3><g:message code="rarr.step.registration.label" /></h3>
    
      
      <dl>
        <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="rarr.property.recreationActivity.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'recreationActivity', 'lrEntries': lrTypes.recreationActivity.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="rarr.property.urgencyPhone.label" /></dt><dd>${rqt.urgencyPhone?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="rarr.step.contact.label" /></h3>
    
      
      <h4><g:message code="rarr.property.contactIndividuals.label" /></h4>
      <g:each var="it" in="${rqt.contactIndividuals}" status="index">
      <dl>
        
          <dt><g:message code="rarr.property.lastName.label" /></dt><dd>${it.lastName?.toString()}</dd>

        
          <dt><g:message code="rarr.property.firstName.label" /></dt><dd>${it.firstName?.toString()}</dd>

        
          <dt><g:message code="rarr.property.address.label" /></dt>
          <dd>
          <g:if test="${it.address}">
              <p>${it.address?.additionalDeliveryInformation}</p>
              <p>${it.address?.additionalGeographicalInformation}</p>
              <p>${it.address?.streetNumber} ${it.address?.streetName}</p>
              <p>${it.address?.placeNameOrService}</p>
              <p>${it.address?.postalCode} ${it.address?.city}</p>
              <p>${it.address?.countryName}</p>
          </g:if>
          </dd>
          

        
          <dt><g:message code="rarr.property.homePhone.label" /></dt><dd>${it.homePhone?.toString()}</dd>

        
          <dt><g:message code="rarr.property.officePhone.label" /></dt><dd>${it.officePhone?.toString()}</dd>

        
      </dl>
      </g:each>
      
    
  

  
    <h3><g:message code="rarr.step.authorization.label" /></h3>
    
      
      <h4><g:message code="rarr.property.authorizedIndividuals.label" /></h4>
      <g:each var="it" in="${rqt.authorizedIndividuals}" status="index">
      <dl>
        
          <dt><g:message code="rarr.property.lastName.label" /></dt><dd>${it.lastName?.toString()}</dd>

        
          <dt><g:message code="rarr.property.firstName.label" /></dt><dd>${it.firstName?.toString()}</dd>

        
          <dt><g:message code="rarr.property.address.label" /></dt>
          <dd>
          <g:if test="${it.address}">
              <p>${it.address?.additionalDeliveryInformation}</p>
              <p>${it.address?.additionalGeographicalInformation}</p>
              <p>${it.address?.streetNumber} ${it.address?.streetName}</p>
              <p>${it.address?.placeNameOrService}</p>
              <p>${it.address?.postalCode} ${it.address?.city}</p>
              <p>${it.address?.countryName}</p>
          </g:if>
          </dd>
          

        
          <dt><g:message code="rarr.property.homePhone.label" /></dt><dd>${it.homePhone?.toString()}</dd>

        
          <dt><g:message code="rarr.property.officePhone.label" /></dt><dd>${it.officePhone?.toString()}</dd>

        
      </dl>
      </g:each>
      
    
  

  
    <h3><g:message code="rarr.step.rules.label" /></h3>
    
      
      <dl>
        <dt><g:message code="rarr.property.rulesAndRegulationsAcceptance.label" /></dt>
          <dd><g:message code="message.${rqt.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="rarr.property.classTripPermission.label" /></dt>
          <dd><g:message code="message.${rqt.classTripPermission ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="rarr.property.childPhotoExploitationPermission.label" /></dt>
          <dd><g:message code="message.${rqt.childPhotoExploitationPermission ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="rarr.property.hospitalizationPermission.label" /></dt>
          <dd><g:message code="message.${rqt.hospitalizationPermission ? 'yes' : 'no'}" /></dd>
          

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
  

  


