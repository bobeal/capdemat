


  
    <label class="required"><g:message code="prr.property.isSubscriber.label" /> *  <span><g:message code="prr.property.isSubscriber.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="isSubscriber_${it ? 'yes' : 'no'}" class="required condition-hasSubscriberNumber-trigger  validate-one-required boolean" title="" value="${it}" name="isSubscriber" ${it == rqt.isSubscriber ? 'checked="checked"': ''} />
                <label for="isSubscriber_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="subscriberNumber" class="condition-hasSubscriberNumber-filled"><g:message code="prr.property.subscriberNumber.label" />   <span><g:message code="prr.property.subscriberNumber.help" /></span></label>
            <input type="text" id="subscriberNumber" name="subscriberNumber" value="${rqt.subscriberNumber?.toString()}" 
                    class="condition-hasSubscriberNumber-filled  " title="<g:message code="prr.property.subscriberNumber.validationError" />"   />
            

  

