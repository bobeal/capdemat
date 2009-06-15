


  
    <h3><g:message code="mdr.step.requester.label" /></h3>
    
      
      <dl>
        
          <g:render template="/frontofficeRequestType/widget/requesterSummary" model="['requester':requester]" />
          

      </dl>
      
    
  

  
    <h3><g:message code="mdr.step.nature.label" /></h3>
    
      
      <dl>
        <dt><g:message code="mdr.property.requesterQuality.label" /></dt>
          <dd>
            <g:if test="${rqt.requesterQuality}">
              <g:capdematEnumToField var="${rqt.requesterQuality}" i18nKeyPrefix="mdr.property.requesterQuality" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="mdr.property.requesterQualityPrecision.label" /></dt><dd>${rqt.requesterQualityPrecision}</dd>

      </dl>
      
    
      
      <h4><g:message code="mdr.property.marriageHusband.label" /></h4>
      <dl>
        
          <dt><g:message code="mdr.property.marriageHusbandLastName.label" /></dt><dd>${rqt.marriageHusbandLastName}</dd>

        
          <dt><g:message code="mdr.property.marriageHusbandFirstNames.label" /></dt><dd>${rqt.marriageHusbandFirstNames}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="mdr.property.marriageWife.label" /></h4>
      <dl>
        
          <dt><g:message code="mdr.property.marriageWifeLastName.label" /></dt><dd>${rqt.marriageWifeLastName}</dd>

        
          <dt><g:message code="mdr.property.marriageWifeFirstNames.label" /></dt><dd>${rqt.marriageWifeFirstNames}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="mdr.property.marriage.label" /></h4>
      <dl>
        
          <dt><g:message code="mdr.property.marriageDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.marriageDate}"/></dd>
          

        
          <dt><g:message code="mdr.property.marriageCity.label" /></dt><dd>${rqt.marriageCity}</dd>

        
          <dt><g:message code="mdr.property.marriagePostalCode.label" /></dt><dd>${rqt.marriagePostalCode}</dd>

        
      </dl>
      
    
  

  
    <h3><g:message code="mdr.step.type.label" /></h3>
    
      
      <dl>
        <dt><g:message code="mdr.property.format.label" /></dt>
          <dd>
            <g:if test="${rqt.format}">
              <g:capdematEnumToField var="${rqt.format}" i18nKeyPrefix="mdr.property.format" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="mdr.property.copies.label" /></dt><dd>${rqt.copies}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="mdr.property.comment.label" /></dt><dd>${rqt.comment}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="mdr.property.motive.label" /></dt>
          <dd>
            <g:if test="${rqt.motive}">
              <g:capdematEnumToField var="${rqt.motive}" i18nKeyPrefix="mdr.property.motive" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="mdr.property.relationship.label" /></dt>
          <dd>
            <g:if test="${rqt.relationship}">
              <g:capdematEnumToField var="${rqt.relationship}" i18nKeyPrefix="mdr.property.relationship" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <h4><g:message code="mdr.property.fatherInformation.label" /></h4>
      <dl>
        
          <dt><g:message code="mdr.property.fatherLastName.label" /></dt><dd>${rqt.fatherLastName}</dd>

        
          <dt><g:message code="mdr.property.fatherFirstNames.label" /></dt><dd>${rqt.fatherFirstNames}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="mdr.property.motherInformation.label" /></h4>
      <dl>
        
          <dt><g:message code="mdr.property.motherMaidenName.label" /></dt><dd>${rqt.motherMaidenName}</dd>

        
          <dt><g:message code="mdr.property.motherFirstNames.label" /></dt><dd>${rqt.motherFirstNames}</dd>

        
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
  

  


