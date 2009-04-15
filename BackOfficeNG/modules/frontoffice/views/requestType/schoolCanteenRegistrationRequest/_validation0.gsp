


  
    <h3><g:message code="scrr.step.registration.label" /></h3>
    
      
      <dl>
        <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scrr.property.urgencyPhone.label" /></dt><dd>${rqt.urgencyPhone}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scrr.property.foodDiet.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'foodDiet', 'lrEntries': lrTypes.foodDiet.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scrr.property.canteenAttendingDays.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'canteenAttendingDays', 'lrEntries': lrTypes.canteenAttendingDays.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scrr.property.foodAllergy.label" /></dt>
          <dd><g:message code="message.${rqt.foodAllergy ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scrr.property.doctorName.label" /></dt><dd>${rqt.doctorName}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scrr.property.doctorPhone.label" /></dt><dd>${rqt.doctorPhone}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="scrr.step.rules.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scrr.property.hospitalizationPermission.label" /></dt><dd>${rqt.hospitalizationPermission}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scrr.property.rulesAndRegulationsAcceptance.label" /></dt><dd>${rqt.rulesAndRegulationsAcceptance}</dd>

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
          <g:if test="${document.isNew}"><span class="tag-state tag-active">${message(code:'document.header.new')}</span></g:if>
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">${message(code:'document.header.preview')}</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        ${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  

  


