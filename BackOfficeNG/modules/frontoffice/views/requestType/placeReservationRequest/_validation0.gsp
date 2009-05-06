


  
    <h3><g:message code="prr.step.requester.label" /></h3>
    
      
      <dl>
        
          <g:render template="/frontofficeRequestType/widget/requesterSummary" model="['requester':requester]" />
          

      </dl>
      
    
  

  
    <h3><g:message code="prr.step.subscriber.label" /></h3>
    
      
      <dl>
        <dt><g:message code="prr.property.isSubscriber.label" /></dt>
          <dd><g:message code="message.${rqt.isSubscriber ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="prr.property.subscriberNumber.label" /></dt><dd>${rqt.subscriberNumber}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="prr.step.places.label" /></h3>
    
      
      <h4><g:message code="prr.property.placeReservation.label" /></h4>
      <g:each var="it" in="${rqt.placeReservation}" status="index">
      <dl>
        
      </dl>
      </g:each>
      
    
  

  
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
  

  


