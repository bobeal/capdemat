


  
    <h3><g:message code="cccrr.step.registrationSubject.label" /></h3>
    
      
      <dl>
        <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="cccrr.property.subjectChoiceBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectChoiceBirthDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="cccrr.property.subjectChoiceGender.label" /></dt>
          <dd>
            <g:if test="${rqt.subjectChoiceGender}">
              <g:capdematEnumToField var="${rqt.subjectChoiceGender}" i18nKeyPrefix="cccrr.property.subjectChoiceGender" />
            </g:if>
          </dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="cccrr.step.registrationParams.label" /></h3>
    
      
      <dl>
        <dt><g:message code="cccrr.property.registrationDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.registrationDate}"/></dd>
          

      </dl>
      
    
      
      <h4><g:message code="cccrr.property.mondayRegistrationParam.label" /></h4>
      <dl>
        
          <dt><g:message code="cccrr.property.mondayPeriod.label" /></dt>
          <dd>
            <g:if test="${rqt.mondayPeriod}">
              <g:capdematEnumToField var="${rqt.mondayPeriod}" i18nKeyPrefix="cccrr.property.mondayPeriod" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="cccrr.property.mondayFirstPeriodBegining.label" /></dt><dd>${rqt.mondayFirstPeriodBegining?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.mondayFirstPeriodEnding.label" /></dt><dd>${rqt.mondayFirstPeriodEnding?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.mondaySecondPeriodBegining.label" /></dt><dd>${rqt.mondaySecondPeriodBegining?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.mondaySecondPeriodEnding.label" /></dt><dd>${rqt.mondaySecondPeriodEnding?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="cccrr.property.tuesdayRegistrationParam.label" /></h4>
      <dl>
        
          <dt><g:message code="cccrr.property.tuesdayPeriod.label" /></dt>
          <dd>
            <g:if test="${rqt.tuesdayPeriod}">
              <g:capdematEnumToField var="${rqt.tuesdayPeriod}" i18nKeyPrefix="cccrr.property.tuesdayPeriod" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="cccrr.property.tuesdayFirstPeriodBegining.label" /></dt><dd>${rqt.tuesdayFirstPeriodBegining?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.tuesdayFirstPeriodEnding.label" /></dt><dd>${rqt.tuesdayFirstPeriodEnding?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.tuesdaySecondPeriodBegining.label" /></dt><dd>${rqt.tuesdaySecondPeriodBegining?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.tuesdaySecondPeriodEnding.label" /></dt><dd>${rqt.tuesdaySecondPeriodEnding?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="cccrr.property.wednesdayRegistrationParam.label" /></h4>
      <dl>
        
          <dt><g:message code="cccrr.property.wednesdayPeriod.label" /></dt>
          <dd>
            <g:if test="${rqt.wednesdayPeriod}">
              <g:capdematEnumToField var="${rqt.wednesdayPeriod}" i18nKeyPrefix="cccrr.property.wednesdayPeriod" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="cccrr.property.wednesdayFirstPeriodBegining.label" /></dt><dd>${rqt.wednesdayFirstPeriodBegining?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.wednesdayFirstPeriodEnding.label" /></dt><dd>${rqt.wednesdayFirstPeriodEnding?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.wednesdaySecondPeriodBegining.label" /></dt><dd>${rqt.wednesdaySecondPeriodBegining?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.wednesdaySecondPeriodEnding.label" /></dt><dd>${rqt.wednesdaySecondPeriodEnding?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="cccrr.property.thursdayRegistrationParam.label" /></h4>
      <dl>
        
          <dt><g:message code="cccrr.property.thursdayPeriod.label" /></dt>
          <dd>
            <g:if test="${rqt.thursdayPeriod}">
              <g:capdematEnumToField var="${rqt.thursdayPeriod}" i18nKeyPrefix="cccrr.property.thursdayPeriod" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="cccrr.property.thursdayFirstPeriodBegining.label" /></dt><dd>${rqt.thursdayFirstPeriodBegining?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.thursdayFirstPeriodEnding.label" /></dt><dd>${rqt.thursdayFirstPeriodEnding?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.thursdaySecondPeriodBegining.label" /></dt><dd>${rqt.thursdaySecondPeriodBegining?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.thursdaySecondPeriodEnding.label" /></dt><dd>${rqt.thursdaySecondPeriodEnding?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="cccrr.property.fridayRegistrationParam.label" /></h4>
      <dl>
        
          <dt><g:message code="cccrr.property.fridayPeriod.label" /></dt>
          <dd>
            <g:if test="${rqt.fridayPeriod}">
              <g:capdematEnumToField var="${rqt.fridayPeriod}" i18nKeyPrefix="cccrr.property.fridayPeriod" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="cccrr.property.fridayFirstPeriodBegining.label" /></dt><dd>${rqt.fridayFirstPeriodBegining?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.fridayFirstPeriodEnding.label" /></dt><dd>${rqt.fridayFirstPeriodEnding?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.fridaySecondPeriodBegining.label" /></dt><dd>${rqt.fridaySecondPeriodBegining?.toString()}</dd>

        
          <dt><g:message code="cccrr.property.fridaySecondPeriodEnding.label" /></dt><dd>${rqt.fridaySecondPeriodEnding?.toString()}</dd>

        
      </dl>
      
    
  

  
    <h3><g:message code="cccrr.step.welcoming.label" /></h3>
    
      
      <dl>
        <dt><g:message code="cccrr.property.welcomingChoice.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'welcomingChoice', 'lrEntries': lrTypes.welcomingChoice.entries, 'depth':0]" />
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
  

  


