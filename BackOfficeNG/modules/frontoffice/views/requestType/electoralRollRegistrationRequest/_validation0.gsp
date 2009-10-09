


  
    <h3><g:message code="errr.step.registration.label" /></h3>
    
      
      <dl>
        <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="errr.property.subjectNationality.label" /></dt>
          <dd>
            <g:if test="${rqt.subjectNationality}">
              <g:capdematEnumToField var="${rqt.subjectNationality}" i18nKeyPrefix="errr.property.subjectNationality" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="errr.property.motive.label" /></dt>
          <dd>
            <g:if test="${rqt.motive}">
              <g:capdematEnumToField var="${rqt.motive}" i18nKeyPrefix="errr.property.motive" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="errr.property.subjectOldCity.label" /></dt><dd>${rqt.subjectOldCity?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="errr.property.subjectAddressOutsideCity.label" /></dt>
          <dd>
          <g:if test="${rqt.subjectAddressOutsideCity}">
              <p>${rqt.subjectAddressOutsideCity?.additionalDeliveryInformation}</p>
              <p>${rqt.subjectAddressOutsideCity?.additionalGeographicalInformation}</p>
              <p>${rqt.subjectAddressOutsideCity?.streetNumber} ${rqt.subjectAddressOutsideCity?.streetName}</p>
              <p>${rqt.subjectAddressOutsideCity?.placeNameOrService}</p>
              <p>${rqt.subjectAddressOutsideCity?.postalCode} ${rqt.subjectAddressOutsideCity?.city}</p>
              <p>${rqt.subjectAddressOutsideCity?.countryName}</p>
          </g:if>
          </dd>
          

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
  

  


