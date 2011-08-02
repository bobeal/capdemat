


  
    <h3><g:message code="bgr.step.subject.label" /></h3>
    
      
      <dl>
        <dt><g:message code="bgr.property.subject.label" /></dt>
          <dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.subjectBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectBirthDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.subjectBirthCity.label" /></dt><dd>${rqt.subjectBirthCity?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.subjectAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.subjectAddress}">
              <p>${rqt.subjectAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.subjectAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.subjectAddress?.streetNumber} ${rqt.subjectAddress?.streetName}</p>
              <p>${rqt.subjectAddress?.placeNameOrService}</p>
              <p>${rqt.subjectAddress?.postalCode} ${rqt.subjectAddress?.city}</p>
              <p>${rqt.subjectAddress?.countryName}</p>
          </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.subjectPhone.label" /></dt><dd>${rqt.subjectPhone?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.subjectEmail.label" /></dt><dd>${rqt.subjectEmail?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="bgr.step.internship.label" /></h3>
    
      
      <dl>
        <dt><g:message code="bgr.property.internshipStartDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.internshipStartDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.internshipEndDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.internshipEndDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.internshipInstituteName.label" /></dt><dd>${rqt.internshipInstituteName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.internshipInstituteAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.internshipInstituteAddress}">
              <p>${rqt.internshipInstituteAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.internshipInstituteAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.internshipInstituteAddress?.streetNumber} ${rqt.internshipInstituteAddress?.streetName}</p>
              <p>${rqt.internshipInstituteAddress?.placeNameOrService}</p>
              <p>${rqt.internshipInstituteAddress?.postalCode} ${rqt.internshipInstituteAddress?.city}</p>
              <p>${rqt.internshipInstituteAddress?.countryName}</p>
          </g:if>
          </dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="bgr.step.bankReference.label" /></h3>
    
      
      <dl>
        <dt><g:message code="bgr.property.isSubjectAccountHolder.label" /></dt>
          <dd><g:message code="message.${rqt.isSubjectAccountHolder ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.accountHolderTitle.label" /></dt>
          <dd>
            <g:if test="${rqt.accountHolderTitle}">
              <g:capdematEnumToField var="${rqt.accountHolderTitle}" i18nKeyPrefix="bgr.property.accountHolderTitle" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.accountHolderLastName.label" /></dt><dd>${rqt.accountHolderLastName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.accountHolderFirstName.label" /></dt><dd>${rqt.accountHolderFirstName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.accountHolderBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.accountHolderBirthDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="bgr.property.bankAccount.label" /></dt>
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
  

  


