


  
    <h3><g:message code="lcr.step.requester.label" /></h3>
    
      
      <dl>
        <dt><g:message code="lcr.property.requesterType.label" /></dt>
          <dd>
            <g:if test="${rqt.requesterType}">
              <g:capdematEnumToField var="${rqt.requesterType}" i18nKeyPrefix="lcr.property.requesterType" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.civility.label" /></dt>
          <dd>
            <g:if test="${rqt.civility}">
              <g:capdematEnumToField var="${rqt.civility}" i18nKeyPrefix="lcr.property.civility" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.lastName.label" /></dt><dd>${rqt.lastName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.firstName.label" /></dt><dd>${rqt.firstName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.contractorName.label" /></dt><dd>${rqt.contractorName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.collectivityName.label" /></dt><dd>${rqt.collectivityName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.address.label" /></dt><dd>${rqt.address?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.phoneNumber.label" /></dt><dd>${rqt.phoneNumber?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.faxNumber.label" /></dt><dd>${rqt.faxNumber?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.mail.label" /></dt><dd>${rqt.mail?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="lcr.step.work.label" /></h3>
    
      
      <dl>
        <dt><g:message code="lcr.property.selectedRequestType.label" /></dt>
          <dd>
            <g:if test="${rqt.selectedRequestType}">
              <g:capdematEnumToField var="${rqt.selectedRequestType}" i18nKeyPrefix="lcr.property.selectedRequestType" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.autorizationNumber.label" /></dt><dd>${rqt.autorizationNumber?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.lcrCompteDe.label" /></dt><dd>${rqt.lcrCompteDe?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.lcrWorkAddress.label" /></dt><dd>${rqt.lcrWorkAddress?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.lcrWorkNature.label" /></dt><dd>${rqt.lcrWorkNature?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.lcrDuration.label" /></dt><dd>${rqt.lcrDuration?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.lcrStartWork.label" /></dt><dd>${rqt.lcrStartWork?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lcr.property.lcrEndWork.label" /></dt><dd>${rqt.lcrEndWork?.toString()}</dd>

      </dl>
      
    
      
      <h4><g:message code="lcr.property.lcrDescription.label" /></h4>
      <g:each var="it" in="${rqt.lcrDescription}" status="index">
      <dl>
        
          <dt><g:message code="lcr.property.lcrDetailDescription.label" /></dt>
          <dd>
            <g:if test="${it.lcrDetailDescription}">
              <g:capdematEnumToField var="${it.lcrDetailDescription}" i18nKeyPrefix="lcr.property.lcrDetailDescription" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="lcr.property.lcrDetailLength.label" /></dt><dd>${it.lcrDetailLength?.toString()}</dd>

        
          <dt><g:message code="lcr.property.lcrDetailWidth.label" /></dt><dd>${it.lcrDetailWidth?.toString()}</dd>

        
          <dt><g:message code="lcr.property.lcrDetailHeight.label" /></dt><dd>${it.lcrDetailHeight?.toString()}</dd>

        
          <dt><g:message code="lcr.property.lcrDetailOther.label" /></dt><dd>${it.lcrDetailOther?.toString()}</dd>

        
      </dl>
      </g:each>
      
    
  

  
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
          <g:capdematEnumToFlag var="${document.state}" i18nKeyPrefix="document.state" />
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}">${message(code:'document.message.preview')}</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        ${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  

  
    <h3><g:message code="lcr.step.rules.label" /></h3>
    
      
      <dl>
        <dt><g:message code="lcr.property.lcrDuesAcceptance.label" /></dt>
          <dd><g:message code="message.${rqt.lcrDuesAcceptance ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
  

  


