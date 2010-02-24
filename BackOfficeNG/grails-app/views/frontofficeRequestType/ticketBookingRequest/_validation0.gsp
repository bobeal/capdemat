


  
    <h3><g:message code="tbr.step.requester.label" /></h3>
    
      
      <dl>
        
          <g:render template="/frontofficeRequestType/widget/requesterSummary" model="['requester':requester]" />
          

      </dl>
      
    
  

  
    <h3><g:message code="tbr.step.entertainments.label" /></h3>
    
      
      <dl>
        <dt><g:message code="tbr.property.isSubscriber.label" /></dt>
          <dd><g:message code="message.${rqt.isSubscriber ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="tbr.property.subscriberNumber.label" /></dt><dd>${rqt.subscriberNumber?.toString()}</dd>

      </dl>
      
    
      <dl>
        <dt><g:message code="tbr.property.subscriberFirstName.label" /></dt><dd>${rqt.subscriberFirstName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="tbr.property.subscriberLastName.label" /></dt><dd>${rqt.subscriberLastName?.toString()}</dd>

      </dl>
      
      <h4>${message(code:'tbr.header.cart')}</h4>
      <g:each var="ticket" in="${rqt?.tbrTicket}" status="index">
        <dl>
          <dt>
            ${ticket.eventName}
            (<g:formatDate formatName='format.fullDate' date='${ticket.eventDate}'/>)
          </dt>
          <dd>
            <strong><g:formatNumber number="${ticket.price}" type="number" format="#####.##" /> €</strong>
            : ${ticket.placeNumber} tickets (${ticket.placeCategory} / ${ticket.fareType})
          </dd>
        </dl>
      </g:each>
      <dl>
        <dt>${message(code:'tbr.property.totalPrice.label')}</dt>
        <dd>
          <g:if test="${rqt?.tbrTicket}">
            <strong>${rqt?.totalPrice}</strong>
          </g:if>
          <g:else>
            ${message(code:'tbr.message.cartIsEmpty')}
          </g:else>
        </dd>
      </dl>
  
    <h3><g:message code="tbr.step.rules.label" /></h3>
    
      
      <dl>
        <dt><g:message code="tbr.property.rulesAndRegulationsAcceptance.label" /></dt>
          <dd><g:message code="message.${rqt.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
  

  


