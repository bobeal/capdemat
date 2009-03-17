



  
  <h3><g:message code="sgr.step.subject.label" /></h3>
  
  
    
    <h4><g:message code="sgr.property.subjetInformations.label" /></h4>
    <dl>
      
      <dt><g:message code="request.property.subjectName" /></dt>
      <dd>${subjects.get(rqt.subjectId)}</dd>
          
      
      
      <dt><g:message code="sgr.property.subjectPhone.label" /></dt>
        <dd>${rqt.subjectPhone}</dd>
      
      <dt><g:message code="sgr.property.subjectMobilePhone.label" /></dt>
        <dd>${rqt.subjectMobilePhone}</dd>
      
      <dt><g:message code="sgr.property.subjectEmail.label" /></dt>
        <dd>${rqt.subjectEmail}</dd>
      
      <dt><g:message code="sgr.property.subjectBirthDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectBirthDate}"/></dd>
          
      
      <dt><g:message code="sgr.property.subjectBirthPlace.label" /></dt>
        <dd>${rqt.subjectBirthPlace}</dd>
      
      <dt><g:message code="sgr.property.hasParentsAddress.label" /></dt>
        
          <dd><g:message code="message.${rqt.hasParentsAddress ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="sgr.property.subjectAddress.label" /></dt>
        
          <g:if test="${rqt.subjectAddress}">
            <dd>
              <p>${rqt.subjectAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.subjectAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.subjectAddress?.streetNumber} ${rqt.subjectAddress?.streetName}</p>
              <p>${rqt.subjectAddress?.placeNameOrService}</p>
              <p>${rqt.subjectAddress?.postalCode} ${rqt.subjectAddress?.city}</p>
              <p>${rqt.subjectAddress?.countryName}</p>
            </dd>
          </g:if>
          
      
    </dl>
    
  

  
  <h3><g:message code="sgr.step.taxHousehold.label" /></h3>
  
  
    
      <dl>
      <dt><g:message code="sgr.property.taxHouseholdLastName.label" /></dt>
      <dd>${rqt.taxHouseholdLastName}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.taxHouseholdFirstName.label" /></dt>
      <dd>${rqt.taxHouseholdFirstName}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.taxHouseholdAddress.label" /></dt>
      
          <g:if test="${rqt.taxHouseholdAddress}">
            <dd>
              <p>${rqt.taxHouseholdAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.taxHouseholdAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.taxHouseholdAddress?.streetNumber} ${rqt.taxHouseholdAddress?.streetName}</p>
              <p>${rqt.taxHouseholdAddress?.placeNameOrService}</p>
              <p>${rqt.taxHouseholdAddress?.postalCode} ${rqt.taxHouseholdAddress?.city}</p>
              <p>${rqt.taxHouseholdAddress?.countryName}</p>
            </dd>
          </g:if>
          
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.taxHouseholdPhone.label" /></dt>
      <dd>${rqt.taxHouseholdPhone}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.taxHouseholdIncome.label" /></dt>
      <dd>${rqt.taxHouseholdIncome}</dd>
      </dl>
    
  

  
  <h3><g:message code="sgr.step.otherHelps.label" /></h3>
  
  
    
      <dl>
      <dt><g:message code="sgr.property.hasCROUSHelp.label" /></dt>
      
          <dd><g:message code="message.${rqt.hasCROUSHelp ? 'yes' : 'no'}" /></dd>
          
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.hasOtherHelp.label" /></dt>
      
          <dd><g:message code="message.${rqt.hasOtherHelp ? 'yes' : 'no'}" /></dd>
          
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.otherHelpInformations.label" /></dt>
      <dd>${rqt.otherHelpInformations}</dd>
      </dl>
    
  

  
  <h3><g:message code="sgr.step.currentStudies.label" /></h3>
  
  
    
      <dl>
      <dt><g:message code="sgr.property.isInLastYear.label" /></dt>
      
          <dd><g:message code="message.${rqt.isInLastYear ? 'yes' : 'no'}" /></dd>
          
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.lastYearDate.label" /></dt>
      <dd>${rqt.lastYearDate}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.lastYearType.label" /></dt>
      <dd>${rqt.lastYearType}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.currentStudies.label" /></dt>
      
          <dd>
            <g:if test="${rqt.currentStudies}">
              <g:capdematEnumToField var="${rqt.currentStudies}" i18nKeyPrefix="sgr.property.currentStudies" />
            </g:if>
          </dd>
          
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.sandwichCoursesLabel.label" /></dt>
      <dd>${rqt.sandwichCoursesLabel}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.abroadInternshipStartDate.label" /></dt>
      
          <dd><g:formatDate formatName="format.date" date="${rqt.abroadInternshipStartDate}"/></dd>
          
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.abroadInternshipEndDate.label" /></dt>
      
          <dd><g:formatDate formatName="format.date" date="${rqt.abroadInternshipEndDate}"/></dd>
          
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.otherStudiesLabel.label" /></dt>
      <dd>${rqt.otherStudiesLabel}</dd>
      </dl>
    
  

  
  <h3><g:message code="sgr.step.futureSchool.label" /></h3>
  
  
    
      <dl>
      <dt><g:message code="sgr.property.futureSchoolName.label" /></dt>
      <dd>${rqt.futureSchoolName}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.futureSchoolAddress.label" /></dt>
      
          <g:if test="${rqt.futureSchoolAddress}">
            <dd>
              <p>${rqt.futureSchoolAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.futureSchoolAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.futureSchoolAddress?.streetNumber} ${rqt.futureSchoolAddress?.streetName}</p>
              <p>${rqt.futureSchoolAddress?.placeNameOrService}</p>
              <p>${rqt.futureSchoolAddress?.postalCode} ${rqt.futureSchoolAddress?.city}</p>
              <p>${rqt.futureSchoolAddress?.countryName}</p>
            </dd>
          </g:if>
          
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.futureSchoolPhone.label" /></dt>
      <dd>${rqt.futureSchoolPhone}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.futureDiplomaName.label" /></dt>
      <dd>${rqt.futureDiplomaName}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.futureDiplomaLevel.label" /></dt>
      <dd>${rqt.futureDiplomaLevel}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.futureSchoolIsAbroad.label" /></dt>
      
          <dd><g:message code="message.${rqt.futureSchoolIsAbroad ? 'yes' : 'no'}" /></dd>
          
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.abroadInternshipSchoolName.label" /></dt>
      <dd>${rqt.abroadInternshipSchoolName}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.abroadInternshipSchoolAddress.label" /></dt>
      <dd>${rqt.abroadInternshipSchoolAddress}</dd>
      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.abroadInternshipSchoolCountry.label" /></dt>
      
          <dd>
            <g:if test="${rqt.abroadInternshipSchoolCountry}">
              <g:capdematEnumToField var="${rqt.abroadInternshipSchoolCountry}" i18nKeyPrefix="sgr.property.abroadInternshipSchoolCountry" />
            </g:if>
          </dd>
          
      </dl>
    
  

  
  <h3><g:message code="sgr.step.calculationElements.label" /></h3>
  
  

  
  <h3><g:message code="sgr.step.bankReference.label" /></h3>
  
  

  
  


