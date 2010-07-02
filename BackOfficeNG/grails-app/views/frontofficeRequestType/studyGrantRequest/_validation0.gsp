


  
    <h3><g:message code="sgr.step.subject.label" /></h3>
    
      
      <h4><g:message code="sgr.property.subjectInformations.label" /></h4>
      <dl>
        
          <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

        
          <dt><g:message code="sgr.property.subjectAddress.label" /></dt>
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
          

        
          <dt><g:message code="sgr.property.subjectPhone.label" /></dt><dd>${rqt.subjectPhone?.toString()}</dd>

        
          <dt><g:message code="sgr.property.subjectMobilePhone.label" /></dt><dd>${rqt.subjectMobilePhone?.toString()}</dd>

        
          <dt><g:message code="sgr.property.subjectEmail.label" /></dt><dd>${rqt.subjectEmail?.toString()}</dd>

        
          <dt><g:message code="sgr.property.subjectBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectBirthDate}"/></dd>
          

        
          <dt><g:message code="sgr.property.subjectFirstRequest.label" /></dt>
          <dd><g:message code="message.${rqt.subjectFirstRequest ? 'yes' : 'no'}" /></dd>
          

        
      </dl>
      
    
  

  
    <h3><g:message code="sgr.step.taxHousehold.label" /></h3>
    
      
      <dl>
        <dt><g:message code="sgr.property.taxHouseholdLastName.label" /></dt><dd>${rqt.taxHouseholdLastName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.taxHouseholdFirstName.label" /></dt><dd>${rqt.taxHouseholdFirstName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.taxHouseholdCity.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'taxHouseholdCity', 'lrEntries': lrTypes.taxHouseholdCity.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.taxHouseholdCityPrecision.label" /></dt><dd>${rqt.taxHouseholdCityPrecision?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.taxHouseholdIncome.label" /></dt><dd>${rqt.taxHouseholdIncome?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="sgr.step.otherHelps.label" /></h3>
    
      
      <dl>
        <dt><g:message code="sgr.property.hasCROUSHelp.label" /></dt>
          <dd><g:message code="message.${rqt.hasCROUSHelp ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.hasRegionalCouncilHelp.label" /></dt>
          <dd><g:message code="message.${rqt.hasRegionalCouncilHelp ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.hasEuropeHelp.label" /></dt>
          <dd><g:message code="message.${rqt.hasEuropeHelp ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.hasOtherHelp.label" /></dt>
          <dd><g:message code="message.${rqt.hasOtherHelp ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="sgr.step.currentStudies.label" /></h3>
    
      
      <h4><g:message code="sgr.property.currentSchool.label" /></h4>
      <dl>
        
          <dt><g:message code="sgr.property.currentSchoolName.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'currentSchoolName', 'lrEntries': lrTypes.currentSchoolName.entries, 'depth':0]" />
          </dd>
          

        
          <dt><g:message code="sgr.property.currentSchoolNamePrecision.label" /></dt><dd>${rqt.currentSchoolNamePrecision?.toString()}</dd>

        
          <dt><g:message code="sgr.property.currentSchoolPostalCode.label" /></dt><dd>${rqt.currentSchoolPostalCode?.toString()}</dd>

        
          <dt><g:message code="sgr.property.currentSchoolCity.label" /></dt><dd>${rqt.currentSchoolCity?.toString()}</dd>

        
          <dt><g:message code="sgr.property.currentSchoolCountry.label" /></dt>
          <dd>
            <g:if test="${rqt.currentSchoolCountry}">
              <g:capdematEnumToField var="${rqt.currentSchoolCountry}" i18nKeyPrefix="sgr.property.currentSchoolCountry" />
            </g:if>
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="sgr.property.aLevelsInformations.label" /></h4>
      <dl>
        
          <dt><g:message code="sgr.property.alevelsDate.label" /></dt><dd>${rqt.alevelsDate?.toString()}</dd>

        
          <dt><g:message code="sgr.property.alevels.label" /></dt>
          <dd>
            <g:if test="${rqt.alevels}">
              <g:capdematEnumToField var="${rqt.alevels}" i18nKeyPrefix="sgr.property.alevels" />
            </g:if>
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="sgr.property.currentStudiesInformations.label" /></h4>
      <dl>
        
          <dt><g:message code="sgr.property.currentStudiesDiploma.label" /></dt>
          <dd>
            <g:if test="${rqt.currentStudiesDiploma}">
              <g:capdematEnumToField var="${rqt.currentStudiesDiploma}" i18nKeyPrefix="sgr.property.currentStudiesDiploma" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="sgr.property.otherStudiesLabel.label" /></dt><dd>${rqt.otherStudiesLabel?.toString()}</dd>

        
          <dt><g:message code="sgr.property.currentStudiesLevel.label" /></dt>
          <dd>
            <g:if test="${rqt.currentStudiesLevel}">
              <g:capdematEnumToField var="${rqt.currentStudiesLevel}" i18nKeyPrefix="sgr.property.currentStudiesLevel" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="sgr.property.sandwichCourses.label" /></dt>
          <dd><g:message code="message.${rqt.sandwichCourses ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="sgr.property.abroadInternship.label" /></dt>
          <dd><g:message code="message.${rqt.abroadInternship ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="sgr.property.abroadInternshipStartDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.abroadInternshipStartDate}"/></dd>
          

        
          <dt><g:message code="sgr.property.abroadInternshipEndDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.abroadInternshipEndDate}"/></dd>
          

        
          <dt><g:message code="sgr.property.abroadInternshipSchoolName.label" /></dt><dd>${rqt.abroadInternshipSchoolName?.toString()}</dd>

        
          <dt><g:message code="sgr.property.abroadInternshipSchoolCountry.label" /></dt>
          <dd>
            <g:if test="${rqt.abroadInternshipSchoolCountry}">
              <g:capdematEnumToField var="${rqt.abroadInternshipSchoolCountry}" i18nKeyPrefix="sgr.property.abroadInternshipSchoolCountry" />
            </g:if>
          </dd>
          

        
      </dl>
      
    
  

  
    <h3><g:message code="sgr.step.calculationElements.label" /></h3>
    
      
      <dl>
        <dt><g:message code="sgr.property.distance.label" /></dt>
          <dd>
            <g:if test="${rqt.distance}">
              <g:capdematEnumToField var="${rqt.distance}" i18nKeyPrefix="sgr.property.distance" />
            </g:if>
          </dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="sgr.step.bankReference.label" /></h3>
    
      
      <dl>
        <dt><g:message code="sgr.property.isSubjectAccountHolder.label" /></dt>
          <dd><g:message code="message.${rqt.isSubjectAccountHolder ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.accountHolderTitle.label" /></dt>
          <dd>
            <g:if test="${rqt.accountHolderTitle}">
              <g:capdematEnumToField var="${rqt.accountHolderTitle}" i18nKeyPrefix="sgr.property.accountHolderTitle" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.accountHolderLastName.label" /></dt><dd>${rqt.accountHolderLastName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.accountHolderFirstName.label" /></dt><dd>${rqt.accountHolderFirstName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.accountHolderBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.accountHolderBirthDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sgr.property.frenchRIB.label" /></dt>
          <dd>
          <g:if test="${rqt.frenchRIB}">
            <p>
              ${rqt.frenchRIB?.bankCode}
              ${rqt.frenchRIB?.counterCode}
              ${rqt.frenchRIB?.accountNumber}
              ${rqt.frenchRIB?.accountKey}
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
  

  


