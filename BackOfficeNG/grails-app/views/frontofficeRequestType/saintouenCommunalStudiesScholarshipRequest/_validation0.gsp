


  
    <h3><g:message code="scssr.step.subject.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scssr.property.subject.label" /></dt>
          <dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.subjectBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectBirthDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.subjectDomiciliationDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectDomiciliationDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.isOtherSituation.label" /></dt>
          <dd>
            <g:if test="${rqt.isOtherSituation}">
              <g:capdematEnumToField var="${rqt.isOtherSituation}" i18nKeyPrefix="scssr.property.isOtherSituation" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.saintOuenOtherSituationDetails.label" /></dt><dd>${rqt.saintOuenOtherSituationDetails?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="scssr.step.schoolingInformation.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scssr.property.saintOuenEstablishmentLabel.label" /></dt><dd>${rqt.saintOuenEstablishmentLabel?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.saintOuenIsInOtherStudies.label" /></dt>
          <dd>
            <g:if test="${rqt.saintOuenIsInOtherStudies}">
              <g:capdematEnumToField var="${rqt.saintOuenIsInOtherStudies}" i18nKeyPrefix="scssr.property.saintOuenIsInOtherStudies" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.saintOuenOtherStudiesLabel.label" /></dt><dd>${rqt.saintOuenOtherStudiesLabel?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.saintOuenCurrentStudiesLevel.label" /></dt>
          <dd>
            <g:if test="${rqt.saintOuenCurrentStudiesLevel}">
              <g:capdematEnumToField var="${rqt.saintOuenCurrentStudiesLevel}" i18nKeyPrefix="scssr.property.saintOuenCurrentStudiesLevel" />
            </g:if>
          </dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="scssr.step.bankReference.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scssr.property.isSubjectAccountHolder.label" /></dt>
          <dd><g:message code="message.${rqt.isSubjectAccountHolder ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.accountHolderTitle.label" /></dt>
          <dd>
            <g:if test="${rqt.accountHolderTitle}">
              <g:capdematEnumToField var="${rqt.accountHolderTitle}" i18nKeyPrefix="scssr.property.accountHolderTitle" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.accountHolderLastName.label" /></dt><dd>${rqt.accountHolderLastName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.accountHolderFirstName.label" /></dt><dd>${rqt.accountHolderFirstName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.accountHolderBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.accountHolderBirthDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.bankAccount.label" /></dt>
          <dd>
          <g:if test="${rqt.bankAccount}">
            <p>
              ${rqt.bankAccount?.BIC}
              ${rqt.bankAccount?.IBAN}
            </p>
          </g:if>
          </dd>
          

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
  

  


