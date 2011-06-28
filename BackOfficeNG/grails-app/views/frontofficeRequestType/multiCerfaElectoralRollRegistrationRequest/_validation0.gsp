


  
    <h3><g:message code="mcerrr.step.registration.label" /></h3>
    
      
      <h4><g:message code="mcerrr.property.subjectSheet.label" /></h4>
      <dl>
        
          <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

        
          <dt><g:message code="mcerrr.property.subjectChoiceTitle.label" /></dt>
          <dd>
            <g:if test="${rqt.subjectChoiceTitle}">
              <g:capdematEnumToField var="${rqt.subjectChoiceTitle}" i18nKeyPrefix="mcerrr.property.subjectChoiceTitle" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="mcerrr.property.subjectChoiceLastName.label" /></dt><dd>${rqt.subjectChoiceLastName?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.subjectChoiceMaidenName.label" /></dt><dd>${rqt.subjectChoiceMaidenName?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.subjectChoiceFirstName.label" /></dt><dd>${rqt.subjectChoiceFirstName?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.subjectChoiceAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.subjectChoiceAddress}">
              <p>${rqt.subjectChoiceAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.subjectChoiceAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.subjectChoiceAddress?.streetNumber} ${rqt.subjectChoiceAddress?.streetName}</p>
              <p>${rqt.subjectChoiceAddress?.placeNameOrService}</p>
              <p>${rqt.subjectChoiceAddress?.postalCode} ${rqt.subjectChoiceAddress?.city}</p>
              <p>${rqt.subjectChoiceAddress?.countryName}</p>
          </g:if>
          </dd>
          

        
          <dt><g:message code="mcerrr.property.subjectChoiceHomePhone.label" /></dt><dd>${rqt.subjectChoiceHomePhone?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.subjectChoiceMobilPhone.label" /></dt><dd>${rqt.subjectChoiceMobilPhone?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.subjectChoiceProPhone.label" /></dt><dd>${rqt.subjectChoiceProPhone?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.subjectChoiceEmail.label" /></dt><dd>${rqt.subjectChoiceEmail?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.subjectChoiceBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectChoiceBirthDate}"/></dd>
          

        
          <dt><g:message code="mcerrr.property.subjectChoiceBirthCity.label" /></dt><dd>${rqt.subjectChoiceBirthCity?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.subjectChoiceBirthPostalCode.label" /></dt><dd>${rqt.subjectChoiceBirthPostalCode?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.subjectChoiceBirthCountry.label" /></dt>
          <dd>
            <g:if test="${rqt.subjectChoiceBirthCountry}">
              <g:capdematEnumToField var="${rqt.subjectChoiceBirthCountry}" i18nKeyPrefix="mcerrr.property.subjectChoiceBirthCountry" />
            </g:if>
          </dd>
          

        
      </dl>
      
    
  

  
    <h3><g:message code="mcerrr.step.situation.label" /></h3>
    
      
      <dl>
        <dt><g:message code="mcerrr.property.choiceNationality.label" /></dt>
          <dd>
            <g:if test="${rqt.choiceNationality}">
              <g:capdematEnumToField var="${rqt.choiceNationality}" i18nKeyPrefix="mcerrr.property.choiceNationality" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="mcerrr.property.europeanNationality.label" /></dt>
          <dd>
            <g:if test="${rqt.europeanNationality}">
              <g:capdematEnumToField var="${rqt.europeanNationality}" i18nKeyPrefix="mcerrr.property.europeanNationality" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="mcerrr.property.electionChoice.label" /></dt>
          <dd>
            <g:if test="${rqt.electionChoice}">
              <g:capdematEnumToField var="${rqt.electionChoice}" i18nKeyPrefix="mcerrr.property.electionChoice" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="mcerrr.property.motive.label" /></dt>
          <dd>
            <g:if test="${rqt.motive}">
              <g:capdematEnumToField var="${rqt.motive}" i18nKeyPrefix="mcerrr.property.motive" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <h4><g:message code="mcerrr.property.oldAddressInformation.label" /></h4>
      <dl>
        
          <dt><g:message code="mcerrr.property.oldCity.label" /></dt><dd>${rqt.oldCity?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.oldDepartment.label" /></dt><dd>${rqt.oldDepartment?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.oldOverseas.label" /></dt><dd>${rqt.oldOverseas?.toString()}</dd>

        
      </dl>
      
    
      
      <dl>
        <dt><g:message code="mcerrr.property.externalCountryAECT.label" /></dt>
          <dd>
            <g:if test="${rqt.externalCountryAECT}">
              <g:capdematEnumToField var="${rqt.externalCountryAECT}" i18nKeyPrefix="mcerrr.property.externalCountryAECT" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="mcerrr.property.externalDistrictAECT.label" /></dt><dd>${rqt.externalDistrictAECT?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="mcerrr.property.externalCityAECT.label" /></dt><dd>${rqt.externalCityAECT?.toString()}</dd>

      </dl>
      
    
      
      <h4><g:message code="mcerrr.property.additionInformationFrenchCerfa.label" /></h4>
      <dl>
        
          <dt><g:message code="mcerrr.property.ambassyOrConsulateAFCT.label" /></dt><dd>${rqt.ambassyOrConsulateAFCT?.toString()}</dd>

        
          <dt><g:message code="mcerrr.property.externalCountryAFCT.label" /></dt>
          <dd>
            <g:if test="${rqt.externalCountryAFCT}">
              <g:capdematEnumToField var="${rqt.externalCountryAFCT}" i18nKeyPrefix="mcerrr.property.externalCountryAFCT" />
            </g:if>
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
  

  


