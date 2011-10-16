


  
    <h3><g:message code="ltswr.step.requester.label" /></h3>
    
      
      <dl>
        <dt><g:message code="ltswr.property.requesterType.label" /></dt>
          <dd>
            <g:if test="${rqt.requesterType}">
              <g:capdematEnumToField var="${rqt.requesterType}" i18nKeyPrefix="ltswr.property.requesterType" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.civility.label" /></dt>
          <dd>
            <g:if test="${rqt.civility}">
              <g:capdematEnumToField var="${rqt.civility}" i18nKeyPrefix="ltswr.property.civility" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.lastName.label" /></dt><dd>${rqt.lastName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.firstName.label" /></dt><dd>${rqt.firstName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.contractorName.label" /></dt><dd>${rqt.contractorName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.collectivityName.label" /></dt><dd>${rqt.collectivityName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.address.label" /></dt><dd>${rqt.address?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.phoneNumber.label" /></dt><dd>${rqt.phoneNumber?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.faxNumber.label" /></dt><dd>${rqt.faxNumber?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.mail.label" /></dt><dd>${rqt.mail?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="ltswr.step.work.label" /></h3>
    
      
      <dl>
        <dt><g:message code="ltswr.property.selectedRequestType.label" /></dt>
          <dd>
            <g:if test="${rqt.selectedRequestType}">
              <g:capdematEnumToField var="${rqt.selectedRequestType}" i18nKeyPrefix="ltswr.property.selectedRequestType" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.autorizationNumber.label" /></dt><dd>${rqt.autorizationNumber?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.onBehalf.label" /></dt><dd>${rqt.onBehalf?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.workAddress.label" /></dt><dd>${rqt.workAddress?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.workType.label" /></dt><dd>${rqt.workType?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.workDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.workDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.workTime.label" /></dt><dd>${rqt.workTime?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.workDuration.label" /></dt><dd>${rqt.workDuration?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="ltswr.step.informations.label" /></h3>
    
      
      <dl>
        <dt><g:message code="ltswr.property.noParking.label" /></dt>
          <dd>
            <g:if test="${rqt.noParking}">
              <g:capdematEnumToField var="${rqt.noParking}" i18nKeyPrefix="ltswr.property.noParking" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.noParkingStraightNumber.label" /></dt><dd>${rqt.noParkingStraightNumber?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.noParkingStraightMeter.label" /></dt><dd>${rqt.noParkingStraightMeter?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.alternateTraffic.label" /></dt>
          <dd>
            <g:if test="${rqt.alternateTraffic}">
              <g:capdematEnumToField var="${rqt.alternateTraffic}" i18nKeyPrefix="ltswr.property.alternateTraffic" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.alternateTrafficDirection.label" /></dt><dd>${rqt.alternateTrafficDirection?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.alternateTrafficMeter.label" /></dt><dd>${rqt.alternateTrafficMeter?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.drivingBan.label" /></dt>
          <dd>
            <g:if test="${rqt.drivingBan}">
              <g:capdematEnumToField var="${rqt.drivingBan}" i18nKeyPrefix="ltswr.property.drivingBan" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.drivingBanBetween.label" /></dt><dd>${rqt.drivingBanBetween?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.drivingBanDirection.label" /></dt><dd>${rqt.drivingBanDirection?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.deviation.label" /></dt><dd>${rqt.deviation?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ltswr.property.comment.label" /></dt><dd>${rqt.comment?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="ltswr.step.rules.label" /></h3>
    
      
      <dl>
        <dt><g:message code="ltswr.property.ltswrRule.label" /></dt>
          <dd><g:message code="message.${rqt.ltswrRule ? 'yes' : 'no'}" /></dd>
          

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
  

  


