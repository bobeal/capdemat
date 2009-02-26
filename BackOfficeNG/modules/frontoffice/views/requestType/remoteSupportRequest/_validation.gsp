



  
  <h3><g:message code="rsr.step.subject.label" /></h3>
  
  
    
    <h4><g:message code="rsr.property.rsrSubject.label" /></h4>
    <dl>
      
      <dt><g:message code="request.property.subjectName" /></dt>
      <dd>${subjects.get(request.subjectId)}</dd>
          
      
      
      <dt><g:message code="rsr.property.subjectTitle.label" /></dt>
        
          <dd>
            <g:if test="${rqt.subjectTitle}">
              <g:capdematEnumToField var="${rqt.subjectTitle}" i18nKeyPrefix="rsr.property.subjectTitle" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="rsr.property.subjectBirthDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectBirthDate}"/></dd>
          
      
      <dt><g:message code="rsr.property.subjectResideWith.label" /></dt>
        
          <dd>
            <g:if test="${rqt.subjectResideWith}">
              <g:capdematEnumToField var="${rqt.subjectResideWith}" i18nKeyPrefix="rsr.property.subjectResideWith" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="rsr.property.subjectIsTaxable.label" /></dt>
        
          <dd><g:message code="message.${rqt.subjectIsTaxable ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="rsr.property.subjectIsAPABeneficiary.label" /></dt>
        
          <dd><g:message code="message.${rqt.subjectIsAPABeneficiary ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="rsr.property.subjectIsDisabledPerson.label" /></dt>
        
          <dd><g:message code="message.${rqt.subjectIsDisabledPerson ? 'yes' : 'no'}" /></dd>
          
      
    </dl>
    
  
    
    <h4><g:message code="rsr.property.requestInformation.label" /></h4>
    <dl>
      
      
      <dt><g:message code="rsr.property.requestInformationRequestKind.label" /></dt>
        
          <dd>
            <g:if test="${rqt.requestInformationRequestKind}">
              <g:capdematEnumToField var="${rqt.requestInformationRequestKind}" i18nKeyPrefix="rsr.property.requestInformationRequestKind" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="rsr.property.requestInformationEmergency.label" /></dt>
        
          <dd><g:message code="message.${rqt.requestInformationEmergency ? 'yes' : 'no'}" /></dd>
          
      
      <dt><g:message code="rsr.property.requestInformationEmergencyMotive.label" /></dt>
        <dd>${rqt.requestInformationEmergencyMotive}</dd>
      
    </dl>
    
  
    
    <h4><g:message code="rsr.property.spouse.label" /></h4>
    <dl>
      
      
      <dt><g:message code="rsr.property.spouseLastName.label" /></dt>
        <dd>${rqt.spouseLastName}</dd>
      
      <dt><g:message code="rsr.property.spouseFirstName.label" /></dt>
        <dd>${rqt.spouseFirstName}</dd>
      
      <dt><g:message code="rsr.property.spouseTitle.label" /></dt>
        
          <dd>
            <g:if test="${rqt.spouseTitle}">
              <g:capdematEnumToField var="${rqt.spouseTitle}" i18nKeyPrefix="rsr.property.spouseTitle" />
            </g:if>
          </dd>
          
      
      <dt><g:message code="rsr.property.spouseBirthDate.label" /></dt>
        
          <dd><g:formatDate formatName="format.date" date="${rqt.spouseBirthDate}"/></dd>
          
      
      <dt><g:message code="rsr.property.spouseIsDisabledPerson.label" /></dt>
        
          <dd><g:message code="message.${rqt.spouseIsDisabledPerson ? 'yes' : 'no'}" /></dd>
          
      
    </dl>
    
  

  
  <h3><g:message code="rsr.step.contact.label" /></h3>
  
  
    
      <dt><g:message code="rsr.property.contactKind.label" /></dt>
      
          <dd>
            <g:if test="${rqt.contactKind}">
              <g:capdematEnumToField var="${rqt.contactKind}" i18nKeyPrefix="rsr.property.contactKind" />
            </g:if>
          </dd>
          
    
  
    
    <h4><g:message code="rsr.property.firstContact.label" /></h4>
    <dl>
      
      
      <dt><g:message code="rsr.property.contactLastName.label" /></dt>
        <dd>${rqt.contactLastName}</dd>
      
      <dt><g:message code="rsr.property.contactFirstName.label" /></dt>
        <dd>${rqt.contactFirstName}</dd>
      
      <dt><g:message code="rsr.property.contactPhone.label" /></dt>
        <dd>${rqt.contactPhone}</dd>
      
    </dl>
    
  
    
    <h4><g:message code="rsr.property.secondContact.label" /></h4>
    <dl>
      
      
      <dt><g:message code="rsr.property.secondContactLastName.label" /></dt>
        <dd>${rqt.secondContactLastName}</dd>
      
      <dt><g:message code="rsr.property.secondContactFirstName.label" /></dt>
        <dd>${rqt.secondContactFirstName}</dd>
      
      <dt><g:message code="rsr.property.secondContactPhone.label" /></dt>
        <dd>${rqt.secondContactPhone}</dd>
      
    </dl>
    
  
    
    <h4><g:message code="rsr.property.trustee.label" /></h4>
    <dl>
      
      
      <dt><g:message code="rsr.property.trusteeLastName.label" /></dt>
        <dd>${rqt.trusteeLastName}</dd>
      
      <dt><g:message code="rsr.property.trusteeFirstName.label" /></dt>
        <dd>${rqt.trusteeFirstName}</dd>
      
      <dt><g:message code="rsr.property.trusteePhone.label" /></dt>
        <dd>${rqt.trusteePhone}</dd>
      
    </dl>
    
  

  
  <h3><g:message code="request.step.document.label" /></h3>
  <!-- TODO : Render document summary template -->
  
  

  
  


