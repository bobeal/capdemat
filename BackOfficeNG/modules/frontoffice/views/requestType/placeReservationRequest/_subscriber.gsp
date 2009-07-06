


  
    <label class="required"><g:message code="prr.property.isSubscriber.label" /> *  <span><g:message code="prr.property.isSubscriber.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-hasSubscriberNumber-trigger  validate-one-required boolean" title="" value="${it}" name="isSubscriber" ${it == rqt.isSubscriber ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="condition-hasSubscriberNumber-filled"><g:message code="prr.property.subscriberNumber.label" />   <span><g:message code="prr.property.subscriberNumber.help" /></span></label>
            <input type="text" name="subscriberNumber" value="${rqt.subscriberNumber?.toString()}" 
                    class="condition-hasSubscriberNumber-filled  " title="<g:message code="prr.property.subscriberNumber.validationError" />"  />
            

  

