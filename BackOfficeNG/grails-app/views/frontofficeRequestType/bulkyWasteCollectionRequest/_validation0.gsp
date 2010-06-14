


  
    <h3><g:message code="bwcr.step.waste.label" /></h3>
    
      
      <dl>
        <dt><g:message code="bwcr.property.bulkyWasteType.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'bulkyWasteType', 'lrEntries': lrTypes.bulkyWasteType.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bwcr.property.otherWaste.label" /></dt><dd>${rqt.otherWaste?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bwcr.property.collectionAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.collectionAddress}">
              <p>${rqt.collectionAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.collectionAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.collectionAddress?.streetNumber} ${rqt.collectionAddress?.streetName}</p>
              <p>${rqt.collectionAddress?.placeNameOrService}</p>
              <p>${rqt.collectionAddress?.postalCode} ${rqt.collectionAddress?.city}</p>
              <p>${rqt.collectionAddress?.countryName}</p>
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
  

  


