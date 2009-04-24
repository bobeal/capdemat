


  
    <h3><g:message code="rarr.step.subject.label" /></h3>
    
      
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
        <dt><g:message code="rarr.property.urgencyPhone.label" /></dt><dd>${rqt.urgencyPhone}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="rarr.step.contact.label" /></h3>
    
      
      <h4><g:message code="rarr.property.otherIndividual.label" /></h4>
      <g:each var="it" in="${rqt.otherIndividual}" status="index">
      <dl>
        
      </dl>
      </g:each>
      
    
  

  
    <h3><g:message code="rarr.step.authorization.label" /></h3>
    
  

  
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
          <g:if test="${document.isNew}"><span class="tag-state tag-active">${message(code:'document.header.new')}</span></g:if>
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">${message(code:'document.header.preview')}</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        ${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  

  


