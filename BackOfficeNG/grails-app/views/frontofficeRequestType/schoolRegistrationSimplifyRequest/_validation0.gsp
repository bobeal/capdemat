


  
    <h3><g:message code="srsr.step.registration.label" /></h3>
    
      
      <dl>
        <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="srsr.property.section.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'section', 'lrEntries': lrTypes.section.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="srsr.property.existRegistration.label" /></dt>
          <dd><g:message code="message.${rqt.existRegistration ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="srsr.property.currentSchoolName.label" /></dt><dd>${rqt.currentSchoolName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="srsr.property.currentSchoolAddress.label" /></dt><dd>${rqt.currentSchoolAddress?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="srsr.property.currentSchoolLevel.label" /></dt><dd>${rqt.currentSchoolLevel?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="srsr.property.emergencyContactName.label" /></dt><dd>${rqt.emergencyContactName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="srsr.property.emergencyPhone.label" /></dt><dd>${rqt.emergencyPhone?.toString()}</dd>

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
  

  


