



  
  <h3><g:message code="rsr.step.subject.label" /></h3>
  
  
    
    <h4><g:message code="rsr.property.rsrSubject.label" /></h4>
    <dl>
      
      <dt><g:message code="request.property.subjectName" /></dt>
      <dd>${subjects.get(rqt.subjectId)}</dd>
          
      
      
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
  
  
    
      <dl>
      <dt><g:message code="rsr.property.contactKind.label" /></dt>
      
          <dd>
            <g:if test="${rqt.contactKind}">
              <g:capdematEnumToField var="${rqt.contactKind}" i18nKeyPrefix="rsr.property.contactKind" />
            </g:if>
          </dd>
          
      </dl>
    
  
    
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
    
  

  
  <g:if test="${!documentTypes.isEmpty()}">
    <h3><g:message code="request.step.document.label" /></h3>
    <g:each in="${documentTypes}" var="documentType">
      <h4>${message(code:documentType.value.name)}</h4>
      <g:if test="${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="${documentType.value.associated}" var="document">
        <dt>
          <g:if test="${document.ecitizenNote}">description : ${document.ecitizenNote}<br/></g:if>
          <g:if test="${document.endValidityDate}">expire le ${formatDate(date:document.endValidityDate,formatName:'format.date')}</g:if>
        </dt>
        <dd>
          <g:if test="${document.isNew}"><span class="tag-state tag-active">nouveau</span></g:if>
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">aperçu</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        Aucun document joint
      </g:else>
    </g:each>
  </g:if>
  
  

  
  


