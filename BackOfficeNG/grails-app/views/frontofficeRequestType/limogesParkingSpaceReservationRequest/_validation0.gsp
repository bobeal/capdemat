


  
    <h3><g:message code="lpsrr.step.requester.label" /></h3>
    
      
      <dl>
        <dt><g:message code="lpsrr.property.requesterType.label" /></dt>
          <dd>
            <g:if test="${rqt.requesterType}">
              <g:capdematEnumToField var="${rqt.requesterType}" i18nKeyPrefix="lpsrr.property.requesterType" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.civility.label" /></dt>
          <dd>
            <g:if test="${rqt.civility}">
              <g:capdematEnumToField var="${rqt.civility}" i18nKeyPrefix="lpsrr.property.civility" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.lastName.label" /></dt><dd>${rqt.lastName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.firstName.label" /></dt><dd>${rqt.firstName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.contractorName.label" /></dt><dd>${rqt.contractorName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.address.label" /></dt><dd>${rqt.address?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.phoneNumber.label" /></dt><dd>${rqt.phoneNumber?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.faxNumber.label" /></dt><dd>${rqt.faxNumber?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.mail.label" /></dt><dd>${rqt.mail?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="lpsrr.step.reservation.label" /></h3>
    
      
      <dl>
        <dt><g:message code="lpsrr.property.requesterFirstAddressKind.label" /></dt>
          <dd>
            <g:if test="${rqt.requesterFirstAddressKind}">
              <g:capdematEnumToField var="${rqt.requesterFirstAddressKind}" i18nKeyPrefix="lpsrr.property.requesterFirstAddressKind" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.requesterFirstAddress.label" /></dt><dd>${rqt.requesterFirstAddress?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.requesterOtherAddressKind.label" /></dt>
          <dd>
            <g:if test="${rqt.requesterOtherAddressKind}">
              <g:capdematEnumToField var="${rqt.requesterOtherAddressKind}" i18nKeyPrefix="lpsrr.property.requesterOtherAddressKind" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.requesterOtherAddress.label" /></dt><dd>${rqt.requesterOtherAddress?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.furnitureLift.label" /></dt>
          <dd><g:message code="message.${rqt.furnitureLift ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.startDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.startDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.duration.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'duration', 'lrEntries': lrTypes.duration.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="lpsrr.step.complement.label" /></h3>
    
      
      <dl>
        <dt><g:message code="lpsrr.property.footWay.label" /></dt>
          <dd><g:message code="message.${rqt.footWay ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lpsrr.property.vehiclesRegistration.label" /></dt><dd>${rqt.vehiclesRegistration?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="lpsrr.step.rules.label" /></h3>
    
      
      <dl>
        <dt><g:message code="lpsrr.property.lpsrrRule.label" /></dt>
          <dd><g:message code="message.${rqt.lpsrrRule ? 'yes' : 'no'}" /></dd>
          

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
  

  


