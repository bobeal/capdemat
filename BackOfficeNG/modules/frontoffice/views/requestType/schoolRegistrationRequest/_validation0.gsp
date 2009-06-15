


  
    <h3><g:message code="srr.step.registration.label" /></h3>
    
      
      <dl>
        <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="srr.property.section.label" /></dt>
          <dd>
            <g:if test="${rqt.section}">
              <g:capdematEnumToField var="${rqt.section}" i18nKeyPrefix="srr.property.section" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="srr.property.urgencyPhone.label" /></dt><dd>${rqt.urgencyPhone}</dd>

      </dl>
      
    
      
      <h4><g:message code="srr.property.currentSchool.label" /></h4>
      <dl>
        
          <dt><g:message code="srr.property.currentSchoolName.label" /></dt><dd>${rqt.currentSchoolName}</dd>

        
          <dt><g:message code="srr.property.currentSchoolAddress.label" /></dt><dd>${rqt.currentSchoolAddress}</dd>

        
          <dt><g:message code="srr.property.currentSection.label" /></dt>
          <dd>
            <g:if test="${rqt.currentSection}">
              <g:capdematEnumToField var="${rqt.currentSection}" i18nKeyPrefix="srr.property.currentSection" />
            </g:if>
          </dd>
          

        
      </dl>
      
    
  

  
    <h3><g:message code="srr.step.rules.label" /></h3>
    
      
      <dl>
        <dt><g:message code="srr.property.rulesAndRegulationsAcceptance.label" /></dt>
          <dd><g:message code="message.${rqt.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></dd>
          

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
  

  


