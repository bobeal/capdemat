


  
    <h3><g:message code="lrr.step.registration.label" /></h3>
    
      
      <dl>
        <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lrr.property.subscription.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'subscription', 'lrEntries': lrTypes.subscription.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="lrr.step.rules.label" /></h3>
    
      
      <dl>
        <dt><g:message code="lrr.property.rulesAndRegulationsAcceptance.label" /></dt>
          <dd><g:message code="message.${rqt.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="lrr.property.parentalAuthorization.label" /></dt>
          <dd><g:message code="message.${rqt.parentalAuthorization ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
  

  


