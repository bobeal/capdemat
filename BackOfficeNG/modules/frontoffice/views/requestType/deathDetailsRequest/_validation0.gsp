


  
    <h3><g:message code="ddr.step.requester.label" /></h3>
    
      
      <dl>
        
          <g:render template="/frontofficeRequestType/widget/requesterSummary" model="['requester':requester]" />
          

      </dl>
      
    
  

  
    <h3><g:message code="ddr.step.nature.label" /></h3>
    
      
      <dl>
        <dt><g:message code="ddr.property.deathLastName.label" /></dt><dd>${rqt.deathLastName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ddr.property.deathFirstNames.label" /></dt><dd>${rqt.deathFirstNames?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ddr.property.deathDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.deathDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ddr.property.deathCity.label" /></dt><dd>${rqt.deathCity?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ddr.property.deathPostalCode.label" /></dt><dd>${rqt.deathPostalCode?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="ddr.step.type.label" /></h3>
    
      
      <dl>
        <dt><g:message code="ddr.property.format.label" /></dt>
          <dd>
            <g:if test="${rqt.format}">
              <g:capdematEnumToField var="${rqt.format}" i18nKeyPrefix="ddr.property.format" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ddr.property.copies.label" /></dt><dd>${rqt.copies?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ddr.property.comment.label" /></dt><dd>${rqt.comment?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ddr.property.motive.label" /></dt>
          <dd>
            <g:if test="${rqt.motive}">
              <g:capdematEnumToField var="${rqt.motive}" i18nKeyPrefix="ddr.property.motive" />
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
          <g:if test="${document.isNew}"><span class="tag-state tag-active">${message(code:'document.header.new')}</span>
            <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}?isRequestCreation=true&sessionUuid=${uuidString}" target="blank">${message(code:'document.header.preview')}</a>
          </g:if>
          <g:else>
            <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">${message(code:'document.header.preview')}</a>
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
  

  


