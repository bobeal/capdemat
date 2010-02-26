


  
    <h3><g:message code="tir.step.intervention.label" /></h3>
    
      
      <dl>
        <dt><g:message code="tir.property.interventionType.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'interventionType', 'lrEntries': lrTypes.interventionType.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="tir.property.otherInterventionLabel.label" /></dt><dd>${rqt.otherInterventionLabel?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="tir.property.interventionPlace.label" /></dt>
          <dd>
          <g:if test="${rqt.interventionPlace}">
              <p>${rqt.interventionPlace?.additionalDeliveryInformation}</p>
              <p>${rqt.interventionPlace?.additionalGeographicalInformation}</p>
              <p>${rqt.interventionPlace?.streetNumber} ${rqt.interventionPlace?.streetName}</p>
              <p>${rqt.interventionPlace?.placeNameOrService}</p>
              <p>${rqt.interventionPlace?.postalCode} ${rqt.interventionPlace?.city}</p>
              <p>${rqt.interventionPlace?.countryName}</p>
          </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="tir.property.interventionDescription.label" /></dt><dd>${rqt.interventionDescription?.toString()}</dd>

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
          <g:if test="${document.isNew}"><span class="tag-state tag-new">${message(code:'document.header.new')}</span>
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
  

  


