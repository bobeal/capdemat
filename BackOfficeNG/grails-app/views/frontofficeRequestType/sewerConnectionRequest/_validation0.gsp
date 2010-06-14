


  
    <h3><g:message code="scr.step.requester.label" /></h3>
    
      
      <dl>
        
          <g:render template="/frontofficeRequestType/widget/requesterSummary" model="['requester':requester]" />
          

      </dl>
      
    
  

  
    <h3><g:message code="scr.step.cadastre.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scr.property.requesterQuality.label" /></dt>
          <dd>
            <g:if test="${rqt.requesterQuality}">
              <g:capdematEnumToField var="${rqt.requesterQuality}" i18nKeyPrefix="scr.property.requesterQuality" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scr.property.ownerLastName.label" /></dt><dd>${rqt.ownerLastName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scr.property.ownerFirstNames.label" /></dt><dd>${rqt.ownerFirstNames?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scr.property.ownerAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.ownerAddress}">
              <p>${rqt.ownerAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.ownerAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.ownerAddress?.streetNumber} ${rqt.ownerAddress?.streetName}</p>
              <p>${rqt.ownerAddress?.placeNameOrService}</p>
              <p>${rqt.ownerAddress?.postalCode} ${rqt.ownerAddress?.city}</p>
              <p>${rqt.ownerAddress?.countryName}</p>
          </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scr.property.section.label" /></dt><dd>${rqt.section?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scr.property.number.label" /></dt><dd>${rqt.number?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scr.property.locality.label" /></dt><dd>${rqt.locality?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scr.property.transportationRoute.label" /></dt><dd>${rqt.transportationRoute?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scr.property.moreThanTwoYears.label" /></dt>
          <dd><g:message code="message.${rqt.moreThanTwoYears ? 'yes' : 'no'}" /></dd>
          

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
  

  


