


  
    <h3><g:message code="bdr.step.requester.label" /></h3>
    
      
      <dl>
        
          <g:render template="/frontofficeRequestType/widget/requesterSummary" model="['requester':requester]" />
          

      </dl>
      
    
  

  
    <h3><g:message code="bdr.step.nature.label" /></h3>
    
      
      <dl>
        <dt><g:message code="bdr.property.requesterQuality.label" /></dt>
          <dd>
            <g:if test="${rqt.requesterQuality}">
              <g:capdematEnumToField var="${rqt.requesterQuality}" i18nKeyPrefix="bdr.property.requesterQuality" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bdr.property.requesterQualityPrecision.label" /></dt><dd>${rqt.requesterQualityPrecision?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bdr.property.birthLastName.label" /></dt><dd>${rqt.birthLastName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bdr.property.birthMarriageName.label" /></dt><dd>${rqt.birthMarriageName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bdr.property.birthFirstNames.label" /></dt><dd>${rqt.birthFirstNames?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bdr.property.birthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.birthDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bdr.property.birthCity.label" /></dt><dd>${rqt.birthCity?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bdr.property.birthPostalCode.label" /></dt><dd>${rqt.birthPostalCode?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="bdr.step.type.label" /></h3>
    
      
      <dl>
        <dt><g:message code="bdr.property.format.label" /></dt>
          <dd>
            <g:if test="${rqt.format}">
              <g:capdematEnumToField var="${rqt.format}" i18nKeyPrefix="bdr.property.format" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <h4><g:message code="bdr.property.fatherInformation.label" /></h4>
      <dl>
        
          <dt><g:message code="bdr.property.fatherLastName.label" /></dt><dd>${rqt.fatherLastName?.toString()}</dd>

        
          <dt><g:message code="bdr.property.fatherFirstNames.label" /></dt><dd>${rqt.fatherFirstNames?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="bdr.property.motherInformation.label" /></h4>
      <dl>
        
          <dt><g:message code="bdr.property.motherMaidenName.label" /></dt><dd>${rqt.motherMaidenName?.toString()}</dd>

        
          <dt><g:message code="bdr.property.motherFirstNames.label" /></dt><dd>${rqt.motherFirstNames?.toString()}</dd>

        
      </dl>
      
    
      
      <dl>
        <dt><g:message code="bdr.property.copies.label" /></dt><dd>${rqt.copies?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bdr.property.motive.label" /></dt>
          <dd>
            <g:if test="${rqt.motive}">
              <g:capdematEnumToField var="${rqt.motive}" i18nKeyPrefix="bdr.property.motive" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bdr.property.comment.label" /></dt><dd>${rqt.comment?.toString()}</dd>

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
  

  


