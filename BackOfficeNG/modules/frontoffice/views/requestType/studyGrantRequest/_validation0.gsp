


  
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
          

      
        <dt><g:message code="sgr.property.subjectPhone.label" /></dt><dd>${rqt.subjectPhone}</dd>

      
        <dt><g:message code="sgr.property.subjectMobilePhone.label" /></dt><dd>${rqt.subjectMobilePhone}</dd>

      
        <dt><g:message code="sgr.property.subjectEmail.label" /></dt><dd>${rqt.subjectEmail}</dd>

      
        <dt><g:message code="sgr.property.subjectBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectBirthDate}"/></dd>
          

      
    </dl>
    
  

  
  <h3><g:message code="sgr.step.taxHousehold.label" /></h3>
  
  
    
      <dl>
      <dt><g:message code="sgr.property.taxHouseholdLastName.label" /></dt><dd>${rqt.taxHouseholdLastName}</dd>

      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.taxHouseholdFirstName.label" /></dt><dd>${rqt.taxHouseholdFirstName}</dd>

      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.taxHouseholdPostalCode.label" /></dt><dd>${rqt.taxHouseholdPostalCode}</dd>

      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.taxHouseholdCity.label" /></dt><dd>${rqt.taxHouseholdCity}</dd>

      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.taxHouseholdIncome.label" /></dt><dd>${rqt.taxHouseholdIncome}</dd>

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
  
  
    
    <h4><g:message code="sgr.property.aLevelsInformations.label" /></h4>
    <dl>
      
        <dt><g:message code="sgr.property.alevelsDate.label" /></dt><dd>${rqt.alevelsDate}</dd>

      
        <dt><g:message code="sgr.property.alevels.label" /></dt>
          <dd>
            <g:if test="${rqt.alevels}">
              <g:capdematEnumToField var="${rqt.alevels}" i18nKeyPrefix="sgr.property.alevels" />
            </g:if>
          </dd>
          

      
    </dl>
    
  
    
    <h4><g:message code="sgr.property.currentSchool.label" /></h4>
    <dl>
      
        <dt><g:message code="sgr.property.currentSchoolName.label" /></dt><dd>${rqt.currentSchoolName}</dd>

      
        <dt><g:message code="sgr.property.currentSchoolPostalCode.label" /></dt><dd>${rqt.currentSchoolPostalCode}</dd>

      
        <dt><g:message code="sgr.property.currentSchoolCity.label" /></dt><dd>${rqt.currentSchoolCity}</dd>

      
        <dt><g:message code="sgr.property.currentSchoolCountry.label" /></dt>
          <dd>
            <g:if test="${rqt.currentSchoolCountry}">
              <g:capdematEnumToField var="${rqt.currentSchoolCountry}" i18nKeyPrefix="sgr.property.currentSchoolCountry" />
            </g:if>
          </dd>
          

      
    </dl>
    
  
    
    <h4><g:message code="sgr.property.currentStudiesInformations.label" /></h4>
    <dl>
      
        <dt><g:message code="sgr.property.currentStudies.label" /></dt>
          <dd>
            <g:if test="${rqt.currentStudies}">
              <g:capdematEnumToField var="${rqt.currentStudies}" i18nKeyPrefix="sgr.property.currentStudies" />
            </g:if>
          </dd>
          

      
        <dt><g:message code="sgr.property.otherStudiesLabel.label" /></dt><dd>${rqt.otherStudiesLabel}</dd>

      
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
          

      
        <dt><g:message code="sgr.property.abroadInternshipSchoolName.label" /></dt><dd>${rqt.abroadInternshipSchoolName}</dd>

      
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
      <dt><g:message code="sgr.property.bankCode.label" /></dt><dd>${rqt.bankCode}</dd>

      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.counterCode.label" /></dt><dd>${rqt.counterCode}</dd>

      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.accountNumber.label" /></dt><dd>${rqt.accountNumber}</dd>

      </dl>
    
  
    
      <dl>
      <dt><g:message code="sgr.property.accountKey.label" /></dt><dd>${rqt.accountKey}</dd>

      </dl>
    
  

  
  


